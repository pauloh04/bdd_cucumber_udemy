package br.com.paulo.service;

import java.util.Calendar;

import br.com.paulo.entity.Filme;
import br.com.paulo.entity.NotaAluguel;

public class AluguelService {

	public NotaAluguel alugar(Filme filme) {
		NotaAluguel aluguel = new NotaAluguel();
		
		aluguel.setPreco(filme.getAluguel());
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		aluguel.setDataEntrega(cal.getTime());
		
		filme.setEstoque(filme.getEstoque() - 1);
		
		return aluguel;
	}
}
