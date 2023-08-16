import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int continuar;

		double resultado = 0;

		do {
			double num1 = EntradaSaida.solicitaNumero("1º");
			double num2 = EntradaSaida.solicitaNumero("2º");
			int operacao = EntradaSaida.solicitaOperacao();

			switch (operacao) {

			case 1:

				Soma soma = new Soma();

				soma.setNum1(num1);

				soma.setNum2(num2);

				resultado = soma.calculaSoma();

				break;

			case 2:

				Subtracao sub = new Subtracao();

				sub.setNum1(num1);

				sub.setNum2(num2);

				resultado = sub.calculaSubtracao();

				break;

			case 3:

				Multiplicacao mult = new Multiplicacao();
				
				mult.setNum1(num1);

				mult.setNum2(num2);

				resultado = mult.calculaMultiplicacao();

				break;

			case 4:
				while (num2 == 0) {

					num2 = EntradaSaida.solicitaNumero("2º");
				}

				Divisao div = new Divisao();
				
				div.setNum1(num1);

				div.setNum2(num2);

				resultado = div.calculaDivisao();

				break;

			default:

				JOptionPane.showMessageDialog(null, "Operação inválida! A calculadora será encerrada!");
				System.exit(0);

				break;
			}

			EntradaSaida.mostraResultado(resultado, operacao);
			continuar = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar calculando? 1 - Sim | 2 - não"));

		} while (continuar == 1);
	}
}
