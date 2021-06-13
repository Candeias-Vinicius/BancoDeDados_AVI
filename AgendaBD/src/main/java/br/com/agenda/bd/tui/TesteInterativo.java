package br.com.agenda.bd.tui;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.agenda.bd.bo.ContatoBO;
import br.com.agenda.bd.bo.GrupoBO;
import br.com.agenda.bd.model.Contato;
import br.com.agenda.bd.model.Grupo;

public class TesteInterativo {
	private static int numero;

	public static void main(String[] args) {
		try {
			executaLista();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void executaLista() throws Exception {
		Scanner entrada = new Scanner(System.in);

		int aux = 0;

		instanciaLista(entrada, aux);

	}

	private static void instanciaLista(Scanner entrada, int opcao) throws Exception {

		int aux;
		do {
			exibirOpcoesMenu();
			System.out.println(" Qual operaçao voce deseja fazer? ");
			numero = entrada.nextInt();
			entrada.nextLine();
			executaOpcaoMenu(entrada, numero);

			System.out.println(" Deseja continuar? Digite '1' para SIM ou qualquer numero para NAO \n");
			aux = entrada.nextInt();
			entrada.nextLine();
		} while (aux == 1);

	}

	private static void exibirOpcoesMenu() {
		System.out.println(" 1 _____________________Adicionar Contato_________________________\n");
		System.out.println(" 2 _____________________Adicionar Grupo_____________________\n");
		System.out.println(" 3 _____________________Alterar Contato_____________________________\n");
		System.out.println(" 4 _____________________Alterar Grupo_____________________________\n");
		System.out.println(" 5 _____________________Remover Contato_____________________________\n");
		System.out.println(" 6 _____________________Remover Grupo_____________________________\n");
		System.out.println(" 7 _____________________Listar Contatos_____________________________\n");
		System.out.println(" 8 _____________________Listar Grupos_____________________________\n");
	}

	private static void executaOpcaoMenu(Scanner entrada, int numero) throws Exception {
		switch (numero) {

		case 1:

			adicionarContato(entrada);

			break;
		case 2:

			adicionarGrupo(entrada);
			
			break;
		case 3:

			alterarContato(entrada);

			break;
		case 4:
			alterarGrupo(entrada);
			
			break;
		case 5:

			removerContato(entrada);

			break;
		case 6:
			removerGrupo(entrada);
			
			break;
		case 7:
			listarContatos();

			break;
		case 8:
			listarGrupos();
			
			break;
		default:
			System.out.println(" Opcao invalida! Por favor, tente novamente: ");
			System.out.println(" Qual operacao voce deseja fazer? ");
			numero = entrada.nextInt();

			executaOpcaoMenu(entrada, numero);
		}
	}

	private static void listarGrupos() throws SQLException {
		System.out.println("_____________________Listando Grupos_________________________\n");
		List<Grupo> grupos = GrupoBO.listarGrupos();
		for (Grupo grupo : grupos) {
			System.out.println(grupo);
		}
	}

	private static void listarContatos() throws SQLException {
		System.out.println("_____________________Listando Contatos_________________________\n");
		List<Contato> contatos = ContatoBO.listarContatos();
		for (Contato contato : contatos) {

			Grupo grupo = GrupoBO.buscaGrupoPorId(contato.getIdGrupo());
			System.out.println(contato + " Grupo: " + grupo.getNome());
		}
	}

	private static void removerGrupo(Scanner entrada) throws Exception {
		String nome;
		System.out.println("_____________________Remover Grupo_________________________\n");
		
		listarGrupos();
		
		System.out.println("Qual grupo deseja remover?");
		nome = entrada.nextLine();

		Grupo grupo = GrupoBO.buscaGrupo(nome);
		GrupoBO.excluirGrupo(grupo.getId());
		System.out.println("Grupo removido !");
	}

	private static void removerContato(Scanner entrada) throws Exception {
		String nome;
		System.out.println("_____________________Remover Contato_________________________\n");
		
		listarContatos();
		
		System.out.println("Qual contato deseja remover?");
		nome = entrada.nextLine();

		Contato contato = ContatoBO.buscaContato(nome);
		ContatoBO.excluirContato(contato.getId());
		System.out.println("Contato removido !");
	}

	private static void alterarGrupo(Scanner entrada) throws Exception {
		String nome;

		System.out.println("_____________________Alterar Grupo_________________________\n");

		listarGrupos();

		System.out.println(" Digite o grupo que voce quer alterar");
		nome = entrada.nextLine();

		Grupo grupo = GrupoBO.buscaGrupo(nome);

		System.out.println(" Digite o nome do grupo");
		grupo.setNome(entrada.nextLine());

		GrupoBO.alterarGrupo(grupo);
		System.out.println(" Grupo atualizado !");
	}

	private static void alterarContato(Scanner entrada) throws Exception {
		String nome;
		String nomeGrupo;

		System.out.println("_____________________Alterar Contato_________________________\n");

		listarContatos();
		System.out.println(" Escolha um grupo, caso nao exista, será criado um novo !");
		nome = entrada.nextLine();

		Contato contato = ContatoBO.buscaContato(nome);

		System.out.println(" Digite o nome do contato");
		contato.setNome(entrada.nextLine());

		System.out.println(" Digite o numero de telefone");
		contato.setTelefone(entrada.nextLine());

		System.out.println(" Digite um numero de celular");
		contato.setCelular(entrada.nextLine());

		listarGrupos();

		System.out.println(" Escolha o grupo ou crie um novo !");
		nomeGrupo = entrada.nextLine();

		if(!GrupoBO.grupoExiste(nomeGrupo)) {
			
			Grupo grupo = new Grupo(nomeGrupo);
			GrupoBO.cadastraGrupo(grupo);

		}
		Grupo grupo = GrupoBO.buscaGrupo(nomeGrupo);

		contato.setIdGrupo(grupo.getId());

		ContatoBO.alterarContato(contato);
		System.out.println(" Contato atualizado !");

	}

	private static void adicionarGrupo(Scanner entrada) throws Exception {

		String nome;
		System.out.println("_____________________Adicionar Grupo_________________________\n");
		System.out.println(" Digite um nome");
		nome = entrada.nextLine();

		Grupo g1 = new Grupo(nome);
		GrupoBO.cadastraGrupo(g1);
		System.out.println("Grupo adicionado com sucesso !");
	}

	private static void adicionarContato(Scanner entrada) throws Exception {

		String nome;
		String telefone;
		String celular;
		Integer grupoid;
		String nomeGrupo;

		System.out.println("_____________________Adicionar contato_________________________\n");

		System.out.println(" Digite um nome");
		nome = entrada.nextLine();
		System.out.println(" Digite o numero de telefone");
		telefone = entrada.nextLine();
		System.out.println(" Digite um numero de celular");
		celular = entrada.nextLine();
		listarGrupos();
		System.out.println(" Escolha um grupo, caso nao exista, será criado um novo !");
		nomeGrupo = entrada.nextLine();

		if(!GrupoBO.grupoExiste(nomeGrupo)) {			
			Grupo grupo = new Grupo(nomeGrupo);
			GrupoBO.cadastraGrupo(grupo);

		}
		Grupo grupo = GrupoBO.buscaGrupo(nomeGrupo);
		grupoid = grupo.getId();
		
		Contato c1 = new Contato(nome, telefone, celular, grupoid);		
		ContatoBO.cadastraContato(c1);
		
		System.out.println(" Contato Adicionado com sucesso !");
	}

}
