package br.com.lucas.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.lucas.modelo.Produto;

public class ProdutoDAO {

	private static List<Produto> produtos = new ArrayList<Produto>();
//	private String filename = " -- nome do arquivo aqui ---";
	private static ProdutoDAO instance;
	
	public static synchronized ProdutoDAO getInstance() throws IOException {
		if (instance == null) {
			instance = new ProdutoDAO();
		}
		return instance;
	}
	
	public void add(Produto produto) {
		//escreve no arquivo aqui
		produtos.add(produto);
	}
	
	public List<Produto> findAll(){
		return Collections.unmodifiableList(produtos);
	}
}
