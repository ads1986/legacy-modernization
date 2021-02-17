package br.com.banking.domain.slip.service;

import br.com.banking.domain.slip.model.Slip;

public interface SlipService {
    void pay(Slip slip);
}