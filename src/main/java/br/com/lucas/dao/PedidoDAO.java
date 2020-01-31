package br.com.lucas.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.lucas.modelo.Pedido;

public class PedidoDAO {

	private static List<Pedido> listaDePedidos = new ArrayList<Pedido>();
	
	private static PedidoDAO instance;
	
	public static synchronized PedidoDAO getInstance() {
		if (instance == null) {
			instance = new PedidoDAO();
		}
		return instance;
	}
	
	public boolean add(Pedido pedido) {
		return listaDePedidos.add(pedido);
	}
	
	public List<Pedido> findAll(){
		return Collections.unmodifiableList(listaDePedidos);
	}
}
