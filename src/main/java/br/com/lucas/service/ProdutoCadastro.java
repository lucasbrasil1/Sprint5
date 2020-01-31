package br.com.lucas.service;

import java.io.IOException;

import br.com.lucas.dao.ProdutoDAO;
import br.com.lucas.modelo.Produto;

public class ProdutoCadastro {

	private ProdutoDAO produtoDAO;
	
	public ProdutoCadastro() throws IOException {
		produtoDAO = ProdutoDAO.getInstance();
	}
	
	public void cadastra(Produto produto) {
		produtoDAO.add(produto);
	}
}
