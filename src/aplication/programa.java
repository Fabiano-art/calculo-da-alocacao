package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entity.Aluguel;
import entity.Veiculo;
import services.AluguelService;
import services.BrazilTaxService;

public class programa {

	public static void main(String[] args) throws ParseException {
		
		Veiculo veic;
		Aluguel alu;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite os dados do aluguel:");
		
		System.out.print("Modelo do carro: ");
		veic = new Veiculo(sc.nextLine());
		
		System.out.print("Data de retirada (dd/MM/yyyy hh:ss): ");
		Date dataRetirada = sdf.parse(sc.nextLine());
		
		System.out.print("Data de devolução (dd/MM/yyyy hh:ss): ");
		Date dataDevolucao = sdf.parse(sc.nextLine());
		
		alu = new Aluguel(dataRetirada, dataDevolucao, veic);
		
		System.out.print("Qual o preço por hora?");
		double precoPorHora = sc.nextDouble();
		System.out.println("Qual o preço por dia?");
		double precoPorDia = sc.nextDouble();
		
		AluguelService servicoAluguel = new AluguelService(precoPorDia, precoPorHora, new BrazilTaxService());
		
		servicoAluguel.processarFatura(alu);
		
		double valorBasico = alu.getFatura().getValorBasico();
		double taxa = alu.getFatura().getTaxa();
		
		System.out.println("Conta:");
		System.out.print("Pagamento líquido: "+alu.getFatura().getValorBasico());
		System.out.print("Taxa: "+alu.getFatura().getTaxa());
		System.out.print("Pagamento total: "+alu.total());
	}

}
