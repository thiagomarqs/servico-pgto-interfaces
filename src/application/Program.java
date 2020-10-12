package application;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import model.entities.*;
import model.services.*;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		int numContrato, numParcelas;
		double valorContrato;
		Date dataContrato;
		
		System.out.print("Número do contrato: ");
		numContrato = sc.nextInt();
		sc.nextLine();
		System.out.print("Data do contrato: ");
		dataContrato = sdf.parse(sc.nextLine());
		System.out.print("Valor total do contrato: ");
		valorContrato = sc.nextDouble();
		
		Contract contrato = new Contract(numContrato, dataContrato, valorContrato);
		
		System.out.print("Número de vezes para parcelar o contrato: ");
		numParcelas = sc.nextInt();
		ProcessContractService proc = new ProcessContractService(contrato, numParcelas, new PayPalService());
		
		/* Acessa cada posição do array parcelas, 
		pega o objeto contido e adiciona no array de parcelas do contrato.*/
		Installment[] parcelas = proc.genInstallments();
		for(int i = 0; i<numParcelas; i++) {
			contrato.addInstallment(parcelas[i]);
		}
		
		/* Imprime as informações das parcelas acessando cada 
		 * posição do array de parcelas do contrato e printando seu toString()
		 */
		System.out.println("Parcelas: ");
		double total = 0.0;
		for(Installment p : contrato.getInstallments()) {
			total+=p.getAmount();
			sb.append(p.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
		System.out.println("Total: " + String.format("%.2f", total));
		sc.close();
	}

}
