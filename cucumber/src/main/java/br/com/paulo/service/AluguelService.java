package br.com.paulo.service;

import br.com.paulo.entity.Filme;
import br.com.paulo.entity.NotaAluguel;
import br.com.paulo.utils.DateUtils;

public class AluguelService {

	public NotaAluguel alugar(Filme filme, String tipoAluguel) {
		if (filme.getEstoque() == 0)
			throw new RuntimeException("Falta de estoque");

		NotaAluguel aluguel = new NotaAluguel();

		if ("extendido".equals(tipoAluguel)) {
			aluguel.setPreco(filme.getAluguel() * 2);
			aluguel.setDataEntrega(DateUtils.obterDiferencaDias(3));
			aluguel.setPontuacao(2);
		} else {
			aluguel.setPreco(filme.getAluguel());
			aluguel.setDataEntrega(DateUtils.obterDiferencaDias(1));
			aluguel.setPontuacao(1);
		}

		filme.setEstoque(filme.getEstoque() - 1);
		return aluguel;
	}
}
