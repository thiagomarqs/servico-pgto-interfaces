package model.services;

public class PayPalService implements PaymentService{
	@Override
	public double monthlyInterest() {
		return 1.00/100.00;
	}

	@Override
	public double paymentTax() {
		return 2.00/100.00;
	}
}
