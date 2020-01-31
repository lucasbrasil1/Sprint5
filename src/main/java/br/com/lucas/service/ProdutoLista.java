package br.com.lucas.service;

import java.io.IOException;
import java.util.List;

import br.com.lucas.dao.ProdutoDAO;
import br.com.lucas.modelo.Produto;

public class ProdutoLista {
	
	private ProdutoDAO produtoDAO;
	
	public ProdutoLista() throws IOException {
		produtoDAO = ProdutoDAO.getInstance();
	}
	
	public List<Produto> buscarTodos(){
		return produtoDAO.findAll();
	}
	
	public Produto buscaPorId(int codigo) {
		Produto produto = new Produto();
		buscarTodos().forEach(p -> {
			if(p.getId() == codigo) {
				produto.setNome(p.getNome());
				produto.setValor(p.getValor());
			}
		});
		return produto;
	}
	
}
