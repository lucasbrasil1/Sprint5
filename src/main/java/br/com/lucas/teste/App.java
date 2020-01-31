package br.com.lucas.teste;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.com.lucas.dao.ClienteDAO;
import br.com.lucas.modelo.Cliente;
import br.com.lucas.modelo.Pedido;
import br.com.lucas.modelo.Produto;
import br.com.lucas.service.ClienteCadastro;
import br.com.lucas.service.ClienteLista;
import br.com.lucas.service.PedidoCadastro;
import br.com.lucas.service.ProdutoCadastro;
import br.com.lucas.service.ProdutoLista;

public class App {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {

		int opcaoMenu = 0;

		do {
			printaMenuPrincipal();
			opcaoMenu = menu(scan.nextInt());
		} while (opcaoMenu != 5);
		
		System.out.println("Programa finalizado.");
		scan.close();
	}

	private static int menu(int opcao) throws Exception {
		switch (opcao) {
			case 1: 
				listaEstoque();
				break;
			case 2:
				System.out.println("Cadastrar novo pedido.");
				cadastraPedido();
				break;
			case 3:
				System.out.println("Cadastrar produto");
				cadastraProduto();
				break;
			case 4:
				System.out.println("Cadastrar cliente");
				cadastraCliente();
				break;
			case 6:
				System.out.println("Listando clientes");
				listaClientes();
				break;
			case 7:
				System.out.println("Lista de pedidos");
				break;
		}
		
		return opcao;
	}

	private static void cadastraPedido() throws IOException {
		Pedido pedido = new Pedido();
		PedidoCadastro cadastro = new PedidoCadastro();
		System.out.println("Digite o código do cliente do pedido: ");
//		pedido.setCliente(new ClienteLista().findId(Integer.parseInt(scan.next())));
		int codigo = Integer.parseInt(scan.next());
		int quantidade;
		do {
			listaEstoque();
			System.out.print("Digite o código do produto que deseja adicionar ao pedido: (0 para sair) ");
			codigo = scan.nextInt();
			
			System.out.print("Quantidade: ");
			quantidade = scan.nextInt();
			
			pedido.adicionaItem(codigo, quantidade);
		} while(codigo != 0);
	}


	private static void listaClientes() {
		List<Cliente> listaClientes = new ClienteLista().buscarTodos();
		listaClientes.forEach(cliente -> System.out.println("Código: "+cliente.getId()+" - Nome: "+cliente.getNome()));
	}

	private static void cadastraCliente() throws IOException {
		Cliente cliente = new Cliente();
		ClienteCadastro cadastro = new ClienteCadastro();
		
		System.out.print("Digite o código do cliente: ");
		cliente.setId(Integer.parseInt(scan.next()));
		
		System.out.print("Digite o nome: ");
		cliente.setNome(scan.next());
		
		cadastro.cadastra(cliente);
	}

	private static void listaEstoque() throws IOException {
		List<Produto> lista = new ProdutoLista().buscarTodos();
		if(lista.isEmpty()) System.out.println("Não existem produtos cadastrados");
		lista.forEach(produto -> System.out.println("Código: "+produto.getId()+" - Nome: "+ produto.getNome() + " - Valor: "+ produto.getValor() +" - Quantidade em estoque: "+produto.getQuantidade()));
	}

	private static void cadastraProduto() throws Exception {
		Produto produto = new Produto();
		ProdutoCadastro cadastro = new ProdutoCadastro();
		
		System.out.print("Digite o código: ");
		produto.setId(Integer.parseInt(scan.next()));
		
		System.out.print("Digite o nome do produto: ");
		produto.setNome(scan.next());
		
		System.out.print("Digite o valor do produto: ");
		produto.setValor(Double.parseDouble(scan.next()));
		
		System.out.print("Digite a quantidade em estoque: ");
		produto.setQuantidade(Integer.parseInt(scan.next()));
		
		cadastro.cadastra(produto);
	}

	

	public static void printaMenuPrincipal() {
		System.out.println("## Escolha uma das opções abaixo ##");
		System.out.println("1 - Verificar Estoque");
		System.out.println("2 - Realizar Pedido");
		System.out.println("3 - Cadastrar Produto");
		System.out.println("4 - Cadastrar Cliente");
		System.out.println("5 - Sair");
		//opcionais
		System.out.println("6 - Listar Clientes");
		System.out.println("7 - Listar Pedidos");
		System.out.println("________________________________");
		System.out.print("Digite sua opção: ");
	}
}
