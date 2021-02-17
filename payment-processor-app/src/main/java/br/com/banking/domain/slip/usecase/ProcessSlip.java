package br.com.banking.domain.slip.usecase;

import br.com.banking.domain.slip.model.Slip;

import java.util.function.UnaryOperator;

public interface ProcessSlip extends UnaryOperator<Slip> {}
