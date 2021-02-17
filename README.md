# Projeto : Modernização Legado

O objetivo deste projeto é apresentar um para modernização de um sistema legado, plano para realização da modernização de um sistema legado.

## 1. Plano de Trabalho

### 1.1. Cenário Atual

 Atualmente as funcionalidades relacionadas a Recuperação de Crédito (Cobrança e Renegociação) estão
 em uma aplicação aplicação monolitica, altamente acoplada. Os dados são processados em Batch para
 prover as informações dos canais on-line do banco.

### 1.2. Metas

A modernização dos sistemas relacionados a Recuperação de Crédito é extremamente necessária, pois a 
solução atual é de dificil manutenção/evolução, dificultando a disponibilização das informações aos 
canais de maneira rapida e eficiente. Os principais pontos as serem atingidos com a implementacao 
deste projeto são :

- Atender a sacionalidade dos consumidores de maneira eficiente
- Reduzir o tempo para o lançamento de novos produtos de acordo com as demandas do mercado

### 1.3. Plano de Ação

Compreende as ações a serem realizadas para que o projeto seja implementado. 

#### 1.3.1. Design

Realizar o desenho da solução do ponto de vista de arquitetura, tendo como base os requisitos descritos abaixo :

- Ter uma plataforma mais online possivel
- Atender as demandas de maneira responsiva

Esta atividade gerará os seguintes artefatos : 

- Diagrama de Arquitetura
- Diagrama de implantacao da solucao

#### 1.3.2. Modelagem de dados

Com base nos requisitos funcionais apresentados, relizar a Modelagem da Base de Dados considerando
a Funcionalidades de Pagamento (Emissão e Pagamento de Boletos, Debito em Conta, outros).

#### 1.3.3 Implementação

Para realização das atividades referentes a etapa de implementacao, os seguintes pré-requisitos 
devem ter sidos contemplados :

- Set-up do ambiente de desenvolvimento
- Provisionamento da infra-estrutura proposta dos ambientes de Desenvolvimento, Homologação e Produção com base na solução proposta

A etapa de Implementacao aqui descrita, não inclui a atividade de provisionamento da infraestrutura 
na solucao proposta. Esta atividade é eré-requisito, para que as atividades descritas a seguir sejam 
realizadas: 

- Criacao da estrutura do projeto
- Implementacao das interfaces externas (Exemplo: Banco de Dados e outros servicos externos)
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

## 4. Implementação do Projeto

### 4.1 Pré-Requisitos

- Ter instalado o Java 11+
- Ter instalado o [Docker](https://docs.docker.com/get-docker/)
- Ter instalado o [Maven](https://maven.apache.org/) [3.6.2+](https://maven.apache.org/download.cgi)

### 4.2 Execução do Ambiente do Kafka Streams

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

### 4.3 Executar Projetos

## 5. Referências utilizadas

## 6. Demais itens que você julgar relevante (Framework ou técnicas de teste, metodologias, padrões, etc.)