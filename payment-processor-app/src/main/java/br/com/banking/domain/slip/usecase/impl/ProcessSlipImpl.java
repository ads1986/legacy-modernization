package br.com.banking.domain.slip.usecase.impl;

import br.com.banking.domain.slip.model.Slip;
import br.com.banking.domain.slip.model.SlipStatusEnum;
import br.com.banking.domain.slip.usecase.ProcessSlip;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcessSlipImpl implements ProcessSlip {
    /**
     * Applies this function to the given argument.
     *
     * @param slip the function argument
     * @return the function result
     */
    @Override
    public Slip apply(Slip slip) {
        return Slip.builder()
                .barCode(slip.getBarCode())
                .documentValue(slip.getDocumentValue())
                .paymentValue(slip.getPaymentValue())
                .dueDate(slip.getDueDate())
                .status(SlipStatusEnum.DONE)
                .build();
    }
}
