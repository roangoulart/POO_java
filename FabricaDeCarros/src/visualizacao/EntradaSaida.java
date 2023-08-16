package visualizacao;

import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class EntradaSaida {

	public static int solicitaOpcao() {

		String[] opcoes = { "1 - Fabricar carro", "2 - Vender carro", "3 - Verificar estoque", "4 - Encerrar" };

		JComboBox<String> menu = new JComboBox<String>(opcoes);

		JOptionPane.showConfirmDialog(null, menu, "Selecione a op��o desejada", JOptionPane.OK_CANCEL_OPTION);

		return menu.getSelectedIndex();
	}

	public static int solicitarQuantidade() {
		return Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de carros"));
	}

	public static String solicitarModelo() {
		return JOptionPane.showInputDialog(null, "Informe o modelo do carro");
	}

	public static String solicitarCor() {
		return JOptionPane.showInputDialog(null, "Informe a cor do carro");
	}

	public static void exibeMsgEncerraPrograma() {

		JOptionPane.showMessageDialog(null, "O programa ser� finalizado!");
	}
}