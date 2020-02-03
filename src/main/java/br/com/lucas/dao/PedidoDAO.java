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
import br.com.lucas.modelo.Pedido;

public class PedidoDAO implements XML {

	private static final XmlMapper xmlMapper = new XmlMapper();
	private String filename = "pedidos.xml";
	private File arquivo = new File(filename);

	private static List<Pedido> listaDePedidos = new ArrayList<Pedido>();
	
	private static PedidoDAO instance;
	
	public static synchronized PedidoDAO getInstance() {
		if (instance == null) {
			instance = new PedidoDAO();
		}
		return instance;
	}
	
	public PedidoDAO() {
		escreveListaNoArquivo();
		listaDePedidos = getLista();
	}
	
	public boolean add(Pedido pedido) {
		return listaDePedidos.add(pedido);
	}
	
	public List<Pedido> findAll(){
		return Collections.unmodifiableList(getLista());
	}

	public void escreveListaNoArquivo() {
		try {
			xmlMapper.writeValue(arquivo, listaDePedidos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Pedido> getLista() {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(arquivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro no arquivo!");
		}
		TypeReference<List<Pedido>> typeReference = new TypeReference<List<Pedido>>() {};
		List<Pedido> lista = null;
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
		if(lista.isEmpty()) {
			System.out.println("Lista vazia, inserir dados antes");
			return lista;
		}
		return lista;
	}
}
