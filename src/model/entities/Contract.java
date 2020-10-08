package model.entities;

import java.util.ArrayList;
import java.util.Date;

public class Contract {
	private int number;
	private Date date;
	private double totalAmount;
	private ArrayList<Installment> installments = new ArrayList<>();
	
	public Contract(int numero, Date data, double valorTotal) {
		this.number = numero;
		this.date = data;
		this.totalAmount = valorTotal;
	}
	
	public int getNumber() {
		return number;
	}
	public Date getDate() {
		return date;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	/* Adiciona uma parcela no array de parcelas*/
	public void addInstallment(Installment installment) {
		installments.add(installment);
	}
	/* Retorna o array de parcelas*/
	public ArrayList<Installment> getInstallments() {
		return this.installments;
	}
}
