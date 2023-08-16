package controle;

import modelo.Fabrica;
import modelo.Carro;
import visualizacao.EntradaSaida;

public class Controladora {

	private Fabrica fabrica = new Fabrica();
	private Carro carro = new Carro();

	public void exibeMenu() {

		int opcao;

		do {
			opcao = EntradaSaida.solicitaOpcao();

			switch (opcao) {

			case 0:
				int qtde = EntradaSaida.solicitarQuantidade();

				int i;

				for (i = 0; i < qtde; i++) {

					carro.setModelo(EntradaSaida.solicitarModelo());
					carro.setCor(EntradaSaida.solicitarCor());
					fabrica.fabricarCarro(carro.getModelo(), carro.getCor());
				}
				break;

			case 1:
				qtde = EntradaSaida.solicitarQuantidade();
				int j;
				for (j = 0; j < qtde; j++) {
					carro.setModelo(EntradaSaida.solicitarModelo());
					carro.setCor(EntradaSaida.solicitarCor());
					fabrica.venderCarro(carro.getModelo(), carro.getCor());
				}
				break;

			case 2:
				fabrica.exibirEstoque();
				break;
			}
		} while (opcao != 3);
		EntradaSaida.exibeMsgEncerraPrograma();
		System.exit(0);
	}

}