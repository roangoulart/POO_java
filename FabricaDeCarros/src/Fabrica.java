import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Fabrica {

	private String nome;
	private String modelo;
	private String cor;

	private ArrayList<Carros> listaDeCarros = new ArrayList<Carros>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public ArrayList<Carros> getListaDeCarros() {
		return listaDeCarros;
	}

	public void setListaDeCarros(ArrayList<Carros> listaDeCarros) {
		this.listaDeCarros = listaDeCarros;
	}

	public void fabricarCarro(String nome, String modelo, String cor, ArrayList<Carros> listaDeCarros) {
		setNome(nome);
		setModelo(modelo);
		setCor(cor);
	}

	public int venderCarro(ArrayList<Carros> listaDeCarros) {

		if (listaDeCarros <= 0) {
			JOptionPane.showMessageDialog(null, "N�o h� carros para vender.", "Erro", JOptionPane.WARNING_MESSAGE);
		} else {
			listaDeCarros = -1;
		}

		return listaDeCarros;
	}

	/*
	 * public void quantosCarros(int quantidade) {
	 * JOptionPane.showMessageDialog(null, "Deseja fabricar quantos carros?" +
	 * quantidade);
	 * 
	 * }
	 * 
	 * public void venderCarro(ArrayLista<Carros> listaDeCarros) { listaDeCarros =
	 * -1; return listaDeCarros; }
	 * 
	 * public int fabricarCarro(ArrayLista<Carros> listaDeCarros) { listaDeCarros =
	 * +1; return listaDeCarros; }
	 * 
	 * public ArrayLista<Carros> getListaDeCarros() { return listaDeCarros; }
	 * 
	 * public void setListaDeCarros(ArrayLista<Carros> listaDeCarros) {
	 * this.listaDeCarros = listaDeCarros; }
	 */
}
