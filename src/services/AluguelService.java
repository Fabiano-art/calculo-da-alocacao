package services;

import entity.Aluguel;
import entity.Fatura;

public class AluguelService {
	
	private Double precoPorDia;
	private Double precoPorHora;
	private TaxService taxService;
	
	public AluguelService(Double precoPorDia, Double precoPorHora, TaxService tax) {
		super();
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.taxService= tax;
	}

	public void processarFatura(Aluguel aluguel) {
		long t1 = aluguel.getStart().getTime();
		long t2 = aluguel.getFinish().getTime();
		double hours = (double) (t2 - t1)/1000/60/60;
		
		double pagamento;
		if (hours <= 12.0) {
			pagamento = Math.ceil(hours) * precoPorHora;
		}
		else {
			pagamento = Math.ceil(hours / 24) * precoPorDia; 
		}
		
		double tax = taxService.tax(pagamento);
		
		aluguel.setFatura(new Fatura(pagamento, tax));
	}
}
