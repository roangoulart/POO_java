package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import visualizacao.EntradaSaida;
import modelo.*;

public class Controladora {

	private Casa casa = null;

	public void exibeMenu() {

		String descricao = "";

		String cor = "";

		int opcao;

		do {

			if ((descricao == "") || (cor == "")) {

				opcao = EntradaSaida.solicitaOpcao2();

				switch (opcao) {
				case 0:
					this.casa = new Casa();

					descricao = EntradaSaida.solicitaDescricao("casa", 0);
					cor = EntradaSaida.solicitaCor();
					int qtdePortas = EntradaSaida.solicitaQtdeAberturas("portas");
					while (qtdePortas <= 0) {
						JOptionPane.showMessageDialog(null, "N�o pode zerar ou haver n�meros negativos");
						qtdePortas = EntradaSaida.solicitaQtdeAberturas("portas");
					}
					int qtdeJanelas = EntradaSaida.solicitaQtdeAberturas("janelas");
					while (qtdeJanelas <= 0) {
						JOptionPane.showMessageDialog(null, "N�o pode zerar ou haver n�meros negativos");
						qtdeJanelas = EntradaSaida.solicitaQtdeAberturas("janelas");
					}

					ArrayList<Aberturas> listaDePortas = new ArrayList<Aberturas>();

					for (int i = 0; i < qtdePortas; i++) {
						Porta porta = new Porta();
						porta.setDescricao(EntradaSaida.solicitaDescricao("porta", (i + 1)));
						porta.setEstado(EntradaSaida.solicitaEstado("porta"));
						listaDePortas.add(porta);
					}

					ArrayList<Aberturas> listaDeJanelas = new ArrayList<Aberturas>();

					for (int i = 0; i < qtdeJanelas; i++) {
						Janela janela = new Janela();
						janela.setDescricao(EntradaSaida.solicitaDescricao("janela", (i + 1)));
						janela.setEstado(EntradaSaida.solicitaEstado("janela"));
						listaDeJanelas.add(janela);
					}

					this.casa.constroiCasa(descricao, cor, listaDePortas, listaDeJanelas);

					System.out.println("Descri��o da casa: " + casa.getDescricao() + "\n");
					System.out.println("Cor da casa: " + casa.getCor() + "\n");

					for (Aberturas porta : casa.getListaDePortas()) {
						System.out.println("Descri��o da porta: " + porta.getDescricao() + "\n");
						System.out.println("Estado da porta: " + porta.getEstado() + "\n");
					}

					for (Aberturas janela : casa.getListaDeJanelas()) {
						System.out.println("Descri��o da janela: " + janela.getDescricao() + "\n");
						System.out.println("Estado da janela: " + janela.getEstado() + "\n");
					}
					break;
				}
			} else {
				opcao = EntradaSaida.solicitaOpcao1();

				switch (opcao) {
				case 0:
					this.casa = new Casa();

					descricao = EntradaSaida.solicitaDescricao("casa", 0);
					cor = EntradaSaida.solicitaCor();
					int qtdePortas = EntradaSaida.solicitaQtdeAberturas("portas");
					while (qtdePortas <= 0) {
						JOptionPane.showMessageDialog(null, "N�o pode zerar ou haver n�meros negativos");
						qtdePortas = EntradaSaida.solicitaQtdeAberturas("portas");
					}
					int qtdeJanelas = EntradaSaida.solicitaQtdeAberturas("janelas");
					while (qtdeJanelas <= 0) {
						JOptionPane.showMessageDialog(null, "N�o pode zerar ou haver n�meros negativos");
						qtdeJanelas = EntradaSaida.solicitaQtdeAberturas("portas");
					}

					ArrayList<Aberturas> listaDePortas = new ArrayList<Aberturas>();

					for (int i = 0; i < qtdePortas; i++) {
						Porta porta = new Porta();
						porta.setDescricao(EntradaSaida.solicitaDescricao("porta", (i + 1)));
						porta.setEstado(EntradaSaida.solicitaEstado("porta"));
						listaDePortas.add(porta);
					}

					ArrayList<Aberturas> listaDeJanelas = new ArrayList<Aberturas>();

					for (int i = 0; i < qtdeJanelas; i++) {
						Janela janela = new Janela();
						janela.setDescricao(EntradaSaida.solicitaDescricao("janela", (i + 1)));
						janela.setEstado(EntradaSaida.solicitaEstado("janela"));
						listaDeJanelas.add(janela);
					}

					this.casa.constroiCasa(descricao, cor, listaDePortas, listaDeJanelas);

					System.out.println("Descri��o da casa: " + casa.getDescricao() + "\n");
					System.out.println("Cor da casa: " + casa.getCor() + "\n");

					for (Aberturas porta : casa.getListaDePortas()) {
						System.out.println("Descri��o da porta: " + porta.getDescricao() + "\n");
						System.out.println("Estado da porta: " + porta.getEstado() + "\n");
					}

					for (Aberturas janela : casa.getListaDeJanelas()) {
						System.out.println("Descri��o da janela: " + janela.getDescricao() + "\n");
						System.out.println("Estado da janela: " + janela.getEstado() + "\n");
					}
					break;

				case 1:

					String tipoAbertura = EntradaSaida.solicitaTipoAbertura();

					ArrayList<Aberturas> listaDeAberturas = new ArrayList<Aberturas>();

					if (tipoAbertura.equals("portas")) {
						listaDeAberturas = this.casa.getListaDePortas();
					} else {
						listaDeAberturas = this.casa.getListaDeJanelas();
					}

					int posicao = EntradaSaida.solicitaAberturaMover(listaDeAberturas);
					String novoEstado = "";

					if (posicao != -1) {
						novoEstado = EntradaSaida.solicitaEstado(tipoAbertura);
						Aberturas abertura = this.casa.retornaAbertura(posicao, tipoAbertura);
						this.casa.moverAbertura(abertura, novoEstado);
						System.out.println("Novo estado da " + tipoAbertura + ": " + abertura.getEstado());
					} else {
						EntradaSaida.exibeMsgAbertura();
					}
					break;

				case 2:
					String informacoes = this.casa.geraInfoCasa();
					EntradaSaida.exibeInfoCasa(informacoes);
					break;
				}
			}
		} while (opcao != 3);

		EntradaSaida.exibeMsgEncerraPrograma();

		System.exit(0);
	}
}
