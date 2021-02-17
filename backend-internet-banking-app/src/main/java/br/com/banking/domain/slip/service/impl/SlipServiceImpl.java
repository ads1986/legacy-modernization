package br.com.banking.domain.slip.service.impl;

import br.com.banking.domain.slip.model.Slip;
import br.com.banking.domain.slip.service.SlipService;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SlipServiceImpl implements SlipService {

    @Inject
    @Channel("slip-to-pay")
    private Emitter<Slip> slipEmitter;

    @Override
    public void pay(Slip slip) {
        slipEmitter.send(slip);
    }
}