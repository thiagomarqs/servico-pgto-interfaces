package model.services;
//Serviço de pagamento do PayPal
public class PayPalService implements PaymentService{
	public static final double INTEREST_RATE = 0.01;
	public static final double PAYMENT_FEE = 0.02;
	
	@Override
	public double interest(double amount, int months) {
		return amount + amount * INTEREST_RATE * months;
	}

	@Override
	public double paymentFee(double amount) {
		return amount * PAYMENT_FEE;
	}
}
