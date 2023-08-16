package visualizacao;

import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class EntradaSaida {

	public static String solicitarTitularDaConta() {
		return JOptionPane.showInputDialog("Informe o nome do Titular da Conta:");
	}

	public static int solicitarTipo() {
		return Integer.parseInt(
				JOptionPane.showInputDialog("Informe o tipo da conta \n 1 - Conta Poupança \n 2 - Conta Correnta"));
	}

	public static int solicitaOpcao() {

		String[] opcoes = { "1 - Depositar", "2 - Sacar", "3 - Saldo", "4 - Dados da Conta", "5 - Extrato",
				"6 - Sair" };

		JComboBox<String> menu = new JComboBox<String>(opcoes);

		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);

		return menu.getSelectedIndex();
	}

	public static int solicitarTipoMov() {
		return Integer
				.parseInt(JOptionPane.showInputDialog("Informe o tipo da movimentação \n 1 - Sacar \n 2 - Depositar"));
	}

	public static double solicitarValor() {
		return Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da Movimentação"));
	}

	public static void exibeMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O programa será finalizado!");
	}

	public static void exibirSaldo(double saldo) {
		JOptionPane.showMessageDialog(null, "O valor atual do saldo é: " + saldo);
	}

	public static void exibirDadosDaConta(String titularDaConta, int tipoConta, double saldo) {
		String nconta = "";
		if (tipoConta == 1) {
			nconta = "Poupança";
		} else {
			nconta = "Corrente";
		}

		JOptionPane.showMessageDialog(null, "Titular da Conta: " + titularDaConta + "\n" + "Tipo da Conta: " + nconta);
	}

	public static String solicitarData() {
		return JOptionPane.showInputDialog("Informe a data da movimentação: ");
	}

	public static void exibirExtratoCompleto(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes, "Extrato completo", JOptionPane.INFORMATION_MESSAGE);
	}
}
