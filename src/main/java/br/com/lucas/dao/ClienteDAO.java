package br.com.lucas.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.lucas.modelo.Cliente;

public class ClienteDAO {
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
	
	public ClienteDAO() {
		if(!arquivo.exists()) {
			arquivo.mkdir();
		} else {
			clientes = getLista();
		}
	}
	
	public void adicionaCliente(Cliente cliente) {
		clientes.add(cliente);
		escreveListaNoArquivo();
//		escreveListaNoArquivo();
	}
	
	public void escreveListaNoArquivo() {
		try {
			xmlMapper.writeValue(arquivo, clientes);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		List<Cliente> lista = null;
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
		return lista;
	}


	


}
