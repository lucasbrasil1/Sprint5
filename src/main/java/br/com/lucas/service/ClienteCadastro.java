package br.com.lucas.service;

import java.io.IOException;

import br.com.lucas.dao.ClienteDAO;
import br.com.lucas.modelo.Cliente;

public class ClienteCadastro {
	
	private ClienteDAO clienteDAO;
	
	public ClienteCadastro() throws IOException {
		clienteDAO = ClienteDAO.getInstance();
	}
	
	public void cadastra(Cliente cliente) {
		clienteDAO.add(cliente);
	}
}
