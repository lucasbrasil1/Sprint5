package br.com.lucas.service;

import java.util.List;

import br.com.lucas.dao.ClienteDAO;
import br.com.lucas.modelo.Cliente;

public class ClienteLista {

	private ClienteDAO clienteDAO = new ClienteDAO();
	
	public List<Cliente> buscarTodos(){
		return (List<Cliente>) clienteDAO.getLista();
	}
	
//	public Cliente findId(int id) {
//		Cliente cliente = new Cliente();
//		
//		buscarTodos().forEach(c -> {
//			if(c.getId() == id) {
//				cliente.setNome(c.getNome());
//			}
//		});
//		if(buscarTodos().contains(cliente)) return cliente;
//		System.out.println("Cliente não existe!");
//		return null;
//	}
	
}
