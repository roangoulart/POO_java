package controle;

import javax.swing.JOptionPane;
//import modelo.*; (O "*" significa "todas" as classes do pacote "modelo").
import modelo.Divisao;
import modelo.Multiplicacao;
import modelo.Operacoes;
import modelo.Soma;
import modelo.Subtracao;
import visualizacao.EntradaSaida;

public class Controladora {

	public void exibeMenu() {

		int continuar;

		double resultado = 0;

		Operacoes oper = null;

		do {
			double num1 = EntradaSaida.solicitaNumero("1�");
			double num2 = EntradaSaida.solicitaNumero("2�");
			int operacao = EntradaSaida.solicitaOperacao();

			switch (operacao) {
			case 1:
				oper = new Soma();
				break;

			case 2:
				oper = new Subtracao();
				break;

			case 3:
				oper = new Multiplicacao();
				break;

			case 4:
				while (num2 == 0) {
					num2 = EntradaSaida.solicitaNumero("2�");
				}
				
				oper = new Divisao();
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opera��o inv�lida! A calculadora ser� encerrada!");
				System.exit(0);
				break;
			}

			oper.setNum1(num1);

			oper.setNum2(num2);

			resultado = oper.calcula();

			EntradaSaida.mostraResultado(resultado, operacao);
			continuar = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar calculando? 1 - Sim | 2 - n�o"));

		} while (continuar == 1);
	}
}
