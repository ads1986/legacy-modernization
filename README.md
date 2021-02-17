# Projeto : Modernização Legado

O objetivo deste projeto é apresentar um plano para modernização de um sistema legado.

## 1. Plano de Trabalho

### 1.1. Cenário Atual

 Atualmente as funcionalidades relacionadas a Recuperação de Crédito (Cobrança e Renegociação) estão
 numa aplicação monolítica, altamente acoplada. Os dados são processados em Batch para prover as informações 
 dos canais on-line do banco.

### 1.2. Metas

A modernização dos sistemas relacionados a Recuperação de Crédito é extremamente necessária, pois a 
solução atual é de difícil manutenção/evolução, dificultando a disponibilização das informações aos 
canais de maneira rapida e eficiente. Os principais pontos as serem atingidos com a implementação 
deste projeto são:

- Atender a sazonalidade dos consumidores de maneira eficiente
- Reduzir o tempo para o lançamento de novos produtos de acordo com as demandas do mercado

### 1.3. Plano de Ação

Compreende as ações a serem realizadas para que o projeto seja implementado. 

#### 1.3.1. Design

Realizar o desenho da solução do ponto de vista de arquitetura, tendo como base os requisitos descritos abaixo:

- Ter uma plataforma mais online possivel.
- Atender as demandas de maneira responsiva

Esta atividade gerará os seguintes artefatos: 

- Diagrama de Arquitetura
- Diagrama de implantacao da solucao

#### 1.3.2 Implementação

Para realização das atividades referentes a etapa de implementação, os seguintes pré-requisitos devem 
ter sidos contemplados:

- Set-up do ambiente de desenvolvimento
- Pro visionamento da infraestrutura proposta dos ambientes de Desenvolvimento, Homologação e Produção com base na solução proposta.

Segue abaixo as ações que serão realizadas:

- Criacao da estrutura do projeto
- Implementacao da Logica da funcionalidade 
- Implementacao de Testes Unitarios
- Implementacao de Testes Funcionais

## 2. Diagrama de arquitetura

<p align="center" >
<img src="https://github.com/ads1986/legacy-modernization/blob/main/artifacts/diagrama-arquitetura.jpeg"/>
</p>

## 3. Diagrama de implantação da solução

<p align="center" >
<img src="https://github.com/ads1986/legacy-modernization/blob/main/artifacts/diagrama-implantacao.jpeg"/>
</p>

## 4. Projeto Exemplo

### 4.1 Detalhes do Projeto

Foram dsenvolvidas 2 aplicações com responsabilidades diferentes.

#### 4.1.1 Aplicação [backend-internet-banking-app](https://github.com/ads1986/legacy-modernization/tree/main/backend-internet-banking-app)

Apesar de ser uma aplicação simples, a ideia com este projeto é demonstrar o Pattern BFF (Backend For Front-End) que tem como objetivo fazer com que o backend 
trabalhe para devolver as informações que permitam ao Front-End entregar a melhor experiencia ao usuário. Uma aplicação Web por exemplo, do ponto de vista funcional, 
necessita receber o extrato bancário numa paginação simples, enquanto que no Mobile, esta paginação tem que facilitar a implementação num modelo de scroll infinito.

#### 4.1.2 Aplicação [payment-processor-app](https://github.com/ads1986/legacy-modernization/tree/main/payment-processor-app)

Esta aplicação tem um objetivo diferente, seguindo um padrão de arquitetura orientada a eventos, observa um topico (slip-to-pay) do Kafka Streams e quando
um evento é lançado, obtem este vento, realiza o processamento e posta o resultado em outro tópico (slip-processed). Este topico por sua vez, permitira que quem o observar
receba os eventos postados.

### 4.2 Execução dos Projetos

#### 4.2.1 Pré-Requisitos

- Ter instalado o Java 11+
- Ter instalado o [Docker](https://docs.docker.com/get-docker/)
- Ter instalado o [Maven](https://maven.apache.org/) [3.6.2+](https://maven.apache.org/download.cgi)

#### 4.2.2 Execução do Ambiente do Kafka Streams

Após a instalação do [Docker](https://docs.docker.com/get-docker/), acessar o diretório raiz deste repositorio (../legacy-modernization/) e executar o comando abaixo para que seja provisionado 
um cluster de desenvolvimento do Kafka Streams por meio do [Docker Componse](https://docs.docker.com/compose/).

```sh
$ docker/docker-compose up -d
```

Após a execução do comando acima, as seguintes mensagens serão apresentadas :

```sh
$ Starting docker_zookeeper_1 ... done
$ Creating docker_kafka_1     ... done
```

#### 4.2.3 Executar Projetos

Para que os projetos sejam inicializados, basta executar os seguintes comandos:

```sh
$ backend-internet-banking-app/./mvnw quarkus:dev
$ payment-processor-app/./mvnw quarkus:dev
```

Apos a inicializacao, basta acessar ao endereco [http://localhost:8080/slips.html](http://localhost:8080/slips.html), e executar 
o seguinte comando no terminal :

```sh
curl --location --request POST 'http://localhost:8080/slips' \
--header 'Content-Type: application/json' \
--data-raw '{
"documentValue": 10,
"paymentValue": 10,
"dueDate": "2020-01-20",
"barCode": "66190500954014481606906809350314337370000000100"
}'
```

## 5. Referências utilizadas

Segue abaixo a lista de referencias utilizadas :

[QUARKUS - USING APACHE KAFKA WITH REACTIVE MESSAGING](https://quarkus.io/guides/kafka)
[Kafka - Quickstart](https://kafka.apache.org/quickstart)
[Debezium - Connector DB2](https://debezium.io/documentation/reference/connectors/db2.html)

## 6. Demais itens que você julgar relevante (Framework ou técnicas de teste, metodologias, padrões, etc.)

Segue abaixo as principais tecnologias sugeridas na solucao proposta, assim como no projeto desenvolvido:

Linguagem de Programação
- Java

Frameworks
- Quarkus (Aplicações Cloud Native / Menor consumo de Memoria)

Container
- Docker

Orquestração de Container
- Kubernetes (Amazon EKS)

Ferramentas de CI/CD
- AWS CodeCommit
- AWS CodeBuild
- AWS CodeDeploy
- AWS SNS

Provedor Cloud
- AWS

Event Stream
- Kafka Stream (Amazon MSK)

Banco de Dados
- Debezium (CDC)
- IBM DB2
- Amazon RDS (Oracle)

## 7. Atividades nao realizadas

Infelizmente algumas atividades que julgo de extrema importância, nao foram realizadas devido à falta de tempo 
por conta da criticidade dos projetos que estou atuando no momento, são elas:

- Criacao da Modelagem da base de dados
- Implementação de Testes Unitários 
- Implementação de Testes Integrados
- Implementação de Padrões de Código que utilizo nos meus projetos atualmente
- Melhor elaboração da funcionalidade escolhida, e revisão adequada dos código produzidos
