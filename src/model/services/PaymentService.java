package model.services;
//Interface para qualquer servi�o de pagamento que ser�
//utilizado.
public interface PaymentService {
	//recebe uma quantia e calcula o valor com juros
	double interest(double amount, int months);
	//recebe uma quantia e calcula o valor com a taxa
	double paymentFee(double amount);
}
