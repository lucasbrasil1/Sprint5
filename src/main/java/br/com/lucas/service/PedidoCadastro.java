package br.com.lucas.service;

import java.util.List;

import br.com.lucas.dao.PedidoDAO;
import br.com.lucas.modelo.Pedido;
import br.com.lucas.modelo.Produto;

public class PedidoCadastro {

//	private List<Produto> listaDeProdutosDoPedido = new ArrayList<>();
	private PedidoDAO pedidoDAO;
	private ProdutoLista listaDeProdutos;
	private List<Produto> itensDoPedido;

	public PedidoCadastro() {
		pedidoDAO = PedidoDAO.getInstance();
	}

	public boolean cadastra(Pedido pedido) {
		return pedidoDAO.add(pedido);
	}

}
