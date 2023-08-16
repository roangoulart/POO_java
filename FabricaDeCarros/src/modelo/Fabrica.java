package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Fabrica {

	ArrayList<Carro> carrosFab = new ArrayList<>();

	public void fabricarCarro(String modelo, String cor) {

		Carro carro = new Carro();
		carro.setModelo(modelo);
		carro.setCor(cor);
		carrosFab.add(carro);
	}

	public void exibirEstoque() {

		for (int i = 0; i < carrosFab.size(); i++) {

			Carro c = carrosFab.get(i);
			JOptionPane.showMessageDialog(null, c.getModelo() + " " + c.getCor());
		}
	}

	public void venderCarro(String modelo, String cor) {

		for (int i = 0; i < carrosFab.size(); i++) {

			Carro c = carrosFab.get(i);
			if ((c.getModelo().equals(modelo)) && (c.getCor().equals(cor))) {
				carrosFab.remove(c);
				JOptionPane.showMessageDialog(null, "Ve�culo vendido!", "Vendido", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Ve�culo n�o encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}