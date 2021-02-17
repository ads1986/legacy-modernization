package br.com.banking.api.slip.model;

import br.com.banking.domain.slip.model.Slip;
import br.com.banking.domain.slip.model.SlipEnum;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class SlipRequest {
    private Double documentValue;
    private Double paymentValue;
    private LocalDate dueDate;
    private String barCode;

    public Slip toSlip(){
        return Slip.builder()
                .barCode(getBarCode())
                .documentValue(getDocumentValue())
                .dueDate(getDueDate())
                .paymentValue(getPaymentValue())
                .status(SlipEnum.WAITING)
                .build();
    }
}