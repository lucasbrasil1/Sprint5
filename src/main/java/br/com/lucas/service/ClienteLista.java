package br.com.lucas.service;

import java.util.List;

import br.com.lucas.dao.ClienteDAO;
import br.com.lucas.modelo.Cliente;

public class ClienteLista {

	private ClienteDAO clienteDAO = new ClienteDAO();

	public List<Cliente> buscarTodos() {
		return clienteDAO.findAll();
	}

	public Cliente getClientePorID(int codigo) {
		Cliente cli = new Cliente();
		
		if(buscarTodos().isEmpty()) {
			return cli;
		}
		
		buscarTodos().forEach(c -> {
			if (c.getId() == codigo) {
				cli.setNome(c.getNome());
				cli.setId(c.getId());
			}
		});
		return cli;
		
	}

}
