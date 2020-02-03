package br.com.lucas.service;

import java.io.IOException;

import br.com.lucas.dao.ClienteDAO;
import br.com.lucas.modelo.Cliente;

public class ClienteCadastro {
	
	private ClienteDAO clienteDAO;
	private ClienteLista listaDeClientes = new ClienteLista();
	
	public ClienteCadastro() throws IOException {
		clienteDAO = ClienteDAO.getInstance();
	}
	
	public void cadastra(Cliente cliente) {
		if(cliente.getId() == listaDeClientes.getClientePorID(cliente.getId()).getId()) {
			System.out.println("Código já está sendo utilizado!");
			return;
		}
		
		clienteDAO.adicionaCliente(cliente);
	}
}
