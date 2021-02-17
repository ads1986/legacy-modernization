package br.com.banking.domain.slip.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class Slip {
    private Double documentValue;
    private Double paymentValue;
    private LocalDate dueDate;
    private String barCode;
    private SlipEnum status;
}