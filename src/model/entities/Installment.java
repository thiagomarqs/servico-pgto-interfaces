//Representa uma parcela do contrato
//Seu valor é definido pelo ProcessContractService
package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	private Date dueDate;
	private double amount;
	
	public Installment(Date data, double valor) {
		this.dueDate = data;
		this.amount = valor;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date data) {
		this.dueDate = data;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double valor) {
		this.amount = valor;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(dueDate) + " - " + String.format("%.2f", amount);
	}
}
