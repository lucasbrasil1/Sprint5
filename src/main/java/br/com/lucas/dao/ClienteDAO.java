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
import br.com.lucas.modelo.Cliente;

public class ClienteDAO implements XML {
	private static List<Cliente> clientes = new ArrayList<Cliente>();
	private String filename = "clientes.xml";
	private File arquivo = new File(filename);
	private static ClienteDAO instance;
	private XmlMapper xmlMapper = new XmlMapper();
	
	public static synchronized ClienteDAO getInstance() throws IOException {
		if (instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}

	public void adicionaCliente(Cliente cliente) {
		clientes.add(cliente);
		escreveListaNoArquivo();
	}
	
	public void escreveListaNoArquivo() {
		try {
			xmlMapper.writeValue(arquivo, clientes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Cliente> findAll(){
		return Collections.unmodifiableList(getLista());
	}
	
	public List<Cliente> getLista() {
		
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(arquivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro no arquivo!");
		}
		TypeReference<List<Cliente>> typeReference = new TypeReference<List<Cliente>>() {};
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			lista = xmlMapper.readValue(inputStream, typeReference);
		} catch (JsonParseException e) {
			System.out.println("Erro ao fazer parseamento do arquivo");
		} catch (JsonMappingException e) {
			System.out.println("Erro ao fazer mapeamento do arquivo");
		} catch (IOException e) {
			System.out.println("Erro de entrada ou saída.");
		}
		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Erro ao fechar input stream");
		}
		
		if(lista.isEmpty()) {
			System.out.println("Não existem clientes cadastrados!");
		}
		return lista;
	}


	


}
