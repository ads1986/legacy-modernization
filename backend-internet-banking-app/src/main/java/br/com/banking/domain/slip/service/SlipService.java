package br.com.banking.domain.slip.service;

import br.com.banking.domain.slip.model.Slip;
import org.reactivestreams.Publisher;

public interface SlipService {
    void pay(Slip slip);
    Publisher<Slip> get();
}