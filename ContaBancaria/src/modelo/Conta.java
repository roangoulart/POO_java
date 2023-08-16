package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import visualizacao.EntradaSaida;

public class Conta {

	private String titularDaConta;
	private int tipoC;
	private String tipoCo;
	private String tipoMov;
	private double saldo;

	private ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList();

	public String gerarExtrato() {
		if (tipoC == 1) {
			tipoCo = "Poupança";
		} else if (tipoC == 2) {
			tipoCo = "Corrente";
		}

		String informacoes = " Titular da Conta: " + this.titularDaConta + "\n Tipo da Conta: " + tipoCo + "\n"
				+ "=============================" + "\n Movimentação \n" + "=============================\n";
		for (int i = 0; i < listaDeMovimentacao.size(); i++) {
			Movimentacao m = listaDeMovimentacao.get(i);

			if (m.getTipoMovimentacao() == 1) {
				tipoMov = "Saque";
			} else if (m.getTipoMovimentacao() == 2) {
				tipoMov = "Depósito";
			}

			informacoes += "Tipo da Movimentação " + " - " + tipoMov + " - " + "\n" + "Valor: " + m.getValor() + "\n"
					+ "Data: " + m.getData() + "\n" + "=============================" + "\n";
		}
		return informacoes;
	}

	public void setTitularDaConta(String titularDaConta) {
		this.titularDaConta = titularDaConta;
	}

	public void setTipo(int tipoC) {
		this.tipoC = tipoC;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void depositar() {
		Movimentacao movimentacao = new Movimentacao();

		movimentacao.setTipoMovimentacao(EntradaSaida.solicitarTipoMov());
		movimentacao.setValor(EntradaSaida.solicitarValor());
		movimentacao.setData(EntradaSaida.solicitarData());
		listaDeMovimentacao.add(movimentacao);

		this.saldo += movimentacao.getValor();
	}

	public void sacar() {
		if (this.saldo == 0) {
			JOptionPane.showMessageDialog(null, "Sem saldo.", "Erro", JOptionPane.WARNING_MESSAGE);
		} else {
			Movimentacao movimentacao = new Movimentacao();

			movimentacao.setTipoMovimentacao(EntradaSaida.solicitarTipoMov());
			movimentacao.setValor(EntradaSaida.solicitarValor());

			if (movimentacao.getValor() > this.saldo + 1000) {
				JOptionPane.showMessageDialog(null, "Limite atingido!", "Erro", JOptionPane.WARNING_MESSAGE);
			} else {
				movimentacao.setData(EntradaSaida.solicitarData());
				listaDeMovimentacao.add(movimentacao);

				this.saldo -= movimentacao.getValor();
			}
		}
	}
}
