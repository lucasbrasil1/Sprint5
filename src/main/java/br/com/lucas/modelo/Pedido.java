package br.com.lucas.modelo;

import java.io.IOException;
import java.util.List;

import br.com.lucas.service.ProdutoLista;

public class Pedido {


	private Cliente cliente;
	private double valorTotal;
	private List<Produto> listaDeProdutos;

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionaItem(int codigo, int quantidade) throws IOException {
		Produto produto = new ProdutoLista().buscaPorId(codigo);
		produto.setQuantidade(quantidade);
		
		System.out.println(produto.getNome());
//		listaDeProdutos.add(produto);
		System.out.println("Item adicionado com sucesso.");
	}


	
	
}
