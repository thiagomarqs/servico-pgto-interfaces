package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.*;

/* Gera as parcelas do Contrato
 * Usa o ServicoPagamento para calcular o valor de cada parcela
 * Adiciona as parcelas no contrato
 */
public class ProcessContractService {
	Contract contract;
	int numOfInstallments;
	PaymentService paySvc;
	
	public ProcessContractService(Contract contract, int numOfInstallments, PaymentService paySvc) {
		this.contract = contract;
		this.numOfInstallments = numOfInstallments;
		this.paySvc = paySvc;
	}
	
	//Gera as parcelas e retorna um array contendo-as
	public Installment[] genInstallments() {
		double baseAmount = contract.getTotalAmount() / this.numOfInstallments;
		Date dueDate = contract.getDate();
		Installment[] parcelas = new Installment[numOfInstallments];
		for(int i = 0; i<numOfInstallments; i++) {
			double installmentAmount = paySvc.interest(baseAmount, i+1);
			installmentAmount += paySvc.paymentFee(installmentAmount);
			dueDate = incrementMonth(dueDate);
			parcelas[i] = new Installment(dueDate, installmentAmount);
		}
		return parcelas;
	}
	
	//Recebe uma data e incrementa o mês em 1
	public Date incrementMonth(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, 1);
		return cal.getTime();
	}
}
