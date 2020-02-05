package br.com.lucas.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.lucas.jackson.XML;
import br.com.lucas.modelo.Produto;

public class ProdutoDAO implements XML {

	private static final XmlMapper xmlMapper = new XmlMapper();
	private static List<Produto> produtos = new ArrayList<Produto>();
	private String filename = "produtos.xml";
	private File arquivo = new File(filename);
	private static ProdutoDAO instance;

	public static synchronized ProdutoDAO getInstance() throws IOException {
		if (instance == null) {
			instance = new ProdutoDAO();
		}
		return instance;
	}

	
	/*
	 * Inicializa
	 * -> Se existe o arquivo
	 * --> Se existe conteúdo: Coloca na lista
	 * --> Se não existe conteúdo : lista fica vazia
	 * -> Se não existe o arquivo : Cria o arquivo
	 */

	public void add(Produto produto) {
		// escreve no arquivo aqui
		produtos.add(produto);
		escreveListaNoArquivo();
	}

	public List<Produto> findAll() {
		return Collections.unmodifiableList(getLista());
	}

	@Override
	public void escreveListaNoArquivo() {
		try {
			xmlMapper.writeValue(arquivo, produtos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public List<Produto> getLista() {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(arquivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro, arquivo não encontrado!");
		}
		TypeReference<List<Produto>> typeReference = new TypeReference<List<Produto>>() {
		};
		List<Produto> lista = null;
		try {
			lista = xmlMapper.readValue(inputStream, typeReference);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (lista.isEmpty()) {
			System.out.println("Lista vazia, inserir dados antes");
			return null;
		}
		return lista;
	}
}
