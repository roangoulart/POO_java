package controle;

import visualizacao.EntradaSaida;
import modelo.Conta;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Controladora {

	Conta conta = new Conta();

	public void exibeMenu() {
		String informacoes = "";
		String titularDaConta = EntradaSaida.solicitarTitularDaConta();
		int tipoC = EntradaSaida.solicitarTipo();
		conta.setTitularDaConta(titularDaConta);
		conta.setTipo(tipoC);

		int opcao;

		do {
			opcao = EntradaSaida.solicitaOpcao();
			double saldo = 0;

			switch (opcao) {
			case 0:
				conta.depositar();
				break;

			case 1:
				
				
				
				
				
				
					conta.sacar();
				break;

			case 2:
				saldo = conta.getSaldo();
				EntradaSaida.exibirSaldo(saldo);
				break;

			case 3:
				saldo = conta.getSaldo();
				EntradaSaida.exibirDadosDaConta(titularDaConta, tipoC, saldo);
				break;
			case 4:
				informacoes = this.conta.gerarExtrato();
				EntradaSaida.exibirExtratoCompleto(informacoes);
				break;
			}
		} while (opcao != 5);
		EntradaSaida.exibeMsgEncerraPrograma();
		System.exit(0);
	}
}