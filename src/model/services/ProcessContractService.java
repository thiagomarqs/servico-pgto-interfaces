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
	
	public ProcessContractService(Contract contrato, int numParcelas, PaymentService servPag) {
		this.contract = contrato;
		this.numOfInstallments = numParcelas;
		this.paySvc = servPag;
	}
	
	//Gera as parcelas e retorna um array contendo-as
	public Installment[] genInstallments() {
		double valorBaseParcela = contract.getTotalAmount() / this.numOfInstallments;
		Date vencimento = contract.getDate();
		Installment[] parcelas = new Installment[numOfInstallments];
		for(int i = 0; i<numOfInstallments; i++) {
			double valorParcela = valorBaseParcela + valorBaseParcela * paySvc.monthlyInterest() * (i+1.00);
			valorParcela += valorParcela * paySvc.paymentTax();
			vencimento = incrementMonth(vencimento);
			parcelas[i] = new Installment(vencimento, valorParcela);
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
