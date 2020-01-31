package br.com.lucas.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.lucas.jackson.XML;
import br.com.lucas.modelo.Cliente;

public class ClienteDAO implements XML {
	private static List<Cliente> clientes = new ArrayList<>();
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
	
	public void add(Cliente cliente) {
		clientes.add(cliente);
		escreveNoArquivo(clientes);
	}


	@Override
	public void escreveNoArquivo(Object object) {
		try {
			xmlMapper.writeValue(arquivo, object);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Cliente> buscaNoArquivo(){
		System.out.println("Buscando no arquivo.");
		
		try {
			List<?> listaXml = xmlMapper.readValue(arquivo, List.class);
			System.out.println(listaXml.get(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(clientes.toString());
		return clientes;
		
	}


	


}
