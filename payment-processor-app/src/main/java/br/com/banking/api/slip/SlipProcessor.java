package br.com.banking.api.slip;

import br.com.banking.domain.slip.model.Slip;
import br.com.banking.domain.slip.usecase.ProcessSlip;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SlipProcessor {

    @Inject
    private ProcessSlip process;

    @Incoming("slip-to-pay")
    @Outgoing("slip-processed")
    @Broadcast
    public Slip process(Slip slip) {
        return process.apply(slip);
    }

}