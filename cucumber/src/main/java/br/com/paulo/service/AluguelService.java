package br.com.paulo.service;

import br.com.paulo.entity.Filme;
import br.com.paulo.entity.NotaAluguel;
import br.com.paulo.entity.TipoAluguel;
import br.com.paulo.utils.DateUtils;

public class AluguelService {

	public NotaAluguel alugar(Filme filme, TipoAluguel tipoAluguel) {
		if (filme.getEstoque() == 0)
			throw new RuntimeException("Falta de estoque");

		NotaAluguel aluguel = new NotaAluguel();

		switch (tipoAluguel) {
		case COMUM:
			aluguel.setPreco(filme.getAluguel());
			aluguel.setDataEntrega(DateUtils.obterDiferencaDias(1));
			aluguel.setPontuacao(1);
			break;
		case EXTENDIDO:
			aluguel.setPreco(filme.getAluguel() * 2);
			aluguel.setDataEntrega(DateUtils.obterDiferencaDias(3));
			aluguel.setPontuacao(2);
			break;
		case SEMANAL:
			aluguel.setPreco(filme.getAluguel() * 3);
			aluguel.setDataEntrega(DateUtils.obterDiferencaDias(7));
			aluguel.setPontuacao(3);
			break;
		}

		filme.setEstoque(filme.getEstoque() - 1);
		return aluguel;
	}
}
