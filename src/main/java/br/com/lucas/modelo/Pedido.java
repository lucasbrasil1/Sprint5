package br.com.lucas.modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.lucas.service.ProdutoLista;

public class Pedido {

	private Cliente cliente;
	private double valorTotal;
	private List<Produto> listaDeProdutos = new ArrayList<Produto>();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean adicionaItem(int codigo, int quantidade) throws IOException {
		Produto produto = new ProdutoLista().buscaPorId(codigo);	
		
		if (produto.equals(null)) {
			System.out.println("Produto não existente.");
			return false;
		}

		if(produto.verificaQuantidade(quantidade)) {
			produto.setQuantidade(quantidade);
		}

		listaDeProdutos.add(produto);
		//escrever no xml
		setValorTotal(getValorTotal() + produto.getValor() * quantidade);
		System.out.println("Item adicionado com sucesso.");
		return true;
	}
	
	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
