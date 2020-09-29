package entity;

public class Veiculo {
	
	private String modelo;
	
	public Veiculo() {
		
	}
	
	public Veiculo(String nome) {
		this.modelo = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
