package br.com.lucas.service;

import br.com.lucas.dao.PedidoDAO;
import br.com.lucas.modelo.Cliente;
import br.com.lucas.modelo.Pedido;

public class PedidoCadastro {

//	private List<Produto> listaDeProdutosDoPedido = new ArrayList<>();
	private PedidoDAO pedidoDAO;
	private ClienteLista listaDeClientes = new ClienteLista();

	public PedidoCadastro() {
		pedidoDAO = PedidoDAO.getInstance();
	}

	public boolean cadastra(Pedido pedido) {
		return pedidoDAO.add(pedido);
	}

	public Cliente getCliente(int codigo) {
		return listaDeClientes.getClientePorID(codigo);
	}

}
