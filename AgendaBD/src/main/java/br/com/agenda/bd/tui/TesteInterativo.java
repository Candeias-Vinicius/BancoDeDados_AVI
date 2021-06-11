package br.com.agenda.bd.tui;

import java.util.List;
import java.util.Scanner;

import br.com.agenda.bd.dao.ContatoDAO;
import br.com.agenda.bd.dao.GrupoDAO;
import br.com.agenda.bd.model.Contato;
import br.com.agenda.bd.model.Grupo;

public class TesteInterativo {
	private static int numero;

	public static void main(String[] args) {
		executaLista();
	}

	private static void executaLista(){
		Scanner entrada = new Scanner(System.in);

		int  aux = 0;

		

		instanciaLista(entrada, aux);

	}

	private static void instanciaLista(Scanner entrada, int opcao) {

			
			int aux;
			do {
				exibirOpcoesMenu();
				System.out.println("Qual operaçao voce deseja fazer? ");
				numero = entrada.nextInt();
				entrada.nextLine();
				executaOpcaoMenu(entrada, numero);

				System.out.println("Deseja continuar? Digite '1' para SIM ou qualquer numero para NAO \n");
				aux = entrada.nextInt();
				entrada.nextLine();
			} while (aux == 1);

		
	}

	private static void exibirOpcoesMenu() {
		System.out.println(" 1 _____________________Adicionar Contato_________________________\n");
		System.out.println(" 2 _____________________Adcionar Grupo_____________________\n");
		System.out.println(" 3 _____________________Alterar Contato_____________________________\n");
		System.out.println(" 4 _____________________Alterar Grupo_____________________________\n");
		System.out.println(" 5 _____________________Remover Contato_____________________________\n");
		System.out.println(" 6 _____________________Remover Grupo_____________________________\n");
		System.out.println(" 7 _____________________Listar Contatos_____________________________\n");
		System.out.println(" 8 _____________________Listar Grupos_____________________________\n");
	}

	private static void executaOpcaoMenu(Scanner entrada,  int numero)  {
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
			System.out.println("Opcao invalida! Por favor, tente novamente: ");
			System.out.println("Qual operacao voce deseja fazer? ");
			numero = entrada.nextInt();

			executaOpcaoMenu(entrada,  numero);
		}
	}

	private static void listarGrupos() {
		System.out.println("_____________________Listar Grupos_________________________\n");
		List<Grupo> grupos = GrupoDAO.getAllGroups();
		for (Grupo grupo : grupos) {
			System.out.println(grupo);
		}		
	}

	private static void listarContatos() {
		System.out.println("_____________________Listar Contatos_________________________\n");
		List<Contato> contatos = ContatoDAO.getAllContacts();
		for (Contato contato : contatos) {
			
			Grupo grupo = GrupoDAO.buscaGrupoPorId(contato.getIdGrupo());
			System.out.println(contato+ " Grupo: " + grupo.getNome());
		}		
	}

	private static void removerGrupo(Scanner entrada) {
		String nome;
		System.out.println("_____________________Remover Grupo_________________________\n");
		List<Grupo> grupos = GrupoDAO.getAllGroups();
		for (Grupo grupo : grupos) {
			System.out.println(grupo);
		}
		System.out.println("Qual grupo deseja remover?");
		nome = entrada.nextLine();
		
		Grupo grupo = GrupoDAO.buscaGrupo(nome);
		GrupoDAO.deleteGrupo(grupo.getId());
	}

	private static void removerContato(Scanner entrada) {
		String nome;
		System.out.println("_____________________Remover Contato_________________________\n");
		List<Contato> contatos = ContatoDAO.getAllContacts();
		for (Contato contato : contatos) {
			System.out.println(contato);
		}
		System.out.println("Qual contato deseja remover?");
		nome = entrada.nextLine();
		
		Contato contato = ContatoDAO.buscaContato(nome);
		ContatoDAO.deleteContato(contato.getId());
	}

	private static void alterarGrupo(Scanner entrada) {
		String nome;
		
		System.out.println("_____________________Alterar Grupo_________________________\n");
		
		List<Grupo> grupos = GrupoDAO.getAllGroups();
		for (Grupo grupo : grupos) {
			System.out.println(grupo);
		}		
		System.out.println("Digite o grupo que voce quer alterar");
		nome = entrada.nextLine();
		
		Grupo grupo = GrupoDAO.buscaGrupo(nome);
		
		System.out.println("Digite o nome do grupo");
		grupo.setNome(entrada.nextLine());
		
		GrupoDAO.updateGrupo(grupo);
	}

	private static void alterarContato(Scanner entrada) {
		String nome;
		String nomeGrupo;
			
		System.out.println("_____________________Alterar Contato_________________________\n");
		
		List<Contato> contatos = ContatoDAO.getAllContacts();
		
		for (Contato contato : contatos) {
			System.out.println(contato);
		}
		
		System.out.println("Digite o contato que voce quer alterar");
		nome = entrada.nextLine();
		
		
			
			Contato contato = ContatoDAO.buscaContato(nome);
			
			System.out.println("Digite o nome do contato");
			contato.setNome(entrada.nextLine());
			
			System.out.println("Digite o numero de telefone");
			contato.setTelefone(entrada.nextLine());
			
			System.out.println("Digite um numero de celular");
			contato.setTelefone(entrada.nextLine());
			
			List<Grupo> grupos = GrupoDAO.getAllGroups();
			
			for (Grupo grupo : grupos) {
				System.out.println(grupo);
			}
			System.out.println("Escolha o grupo");
			nomeGrupo = entrada.nextLine();
						
			Grupo grupo = GrupoDAO.buscaGrupo(nomeGrupo);
			
			contato.setIdGrupo(grupo.getId());
			
			ContatoDAO.updateContato(contato);
		
	}

	private static void adicionarGrupo(Scanner entrada) {
		Integer grupoid;
		String nome;
		System.out.println("_____________________Adicionar Grupo_________________________\n");
		System.out.println("Digite o id do grupo");
		grupoid = entrada.nextInt();
		System.out.println("Digite um nome");
		nome = entrada.nextLine();
		nome = entrada.nextLine();
		
		Grupo g1 = new Grupo(nome, grupoid);
		GrupoDAO.addGrupo(g1);
	}

	private static void adicionarContato(Scanner entrada) {
		Integer id;
		String nome;
		String telefone;
		String celular;
		Integer grupoid;
		String nomeGrupo;
		
		System.out.println("_____________________Adicionar contato_________________________\n");
		System.out.println("Digite o id do contato");
		id = entrada.nextInt();
		System.out.println("Digite um nome");
		nome = entrada.nextLine();
		nome = entrada.nextLine();
		System.out.println("Digite o numero de telefone");
		telefone = entrada.nextLine();
		System.out.println("Digite um numero de celular");
		celular = entrada.nextLine();
		
		System.out.println("Digite o nome grupo");
		nomeGrupo = entrada.nextLine();

		Grupo grupo = GrupoDAO.buscaGrupo(nomeGrupo);
		grupoid = grupo.getId();
		
		Contato c1 = new Contato(id, nome, telefone, celular, grupoid);
		ContatoDAO.addContato(c1);
	}
	
}

