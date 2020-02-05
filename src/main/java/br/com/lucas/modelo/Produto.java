package br.com.lucas.modelo;

public class Produto {

	private int id;
	private String nome;
	private double valor;
	private int quantidade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public boolean verificaQuantidade(int qt) {
		if (this.quantidade >= qt) {
			return true;
		}
		return false;
	}
	
	public boolean descontaDoEstoque(int qt) {
		if (verificaQuantidade(qt)) {
			this.quantidade -= qt;
			return true;
		}
		return false;
	}
	
}
