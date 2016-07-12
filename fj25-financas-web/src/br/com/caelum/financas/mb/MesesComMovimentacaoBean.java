package br.com.caelum.financas.mb;


import java.util.List;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.ValorPorMesEAno;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MesesComMovimentacaoBean {

	private Conta conta = new Conta();
	private List<ValorPorMesEAno> valoresPorMesEAno;
	
	public List<ValorPorMesEAno> getValoresPorMesEano() {
		return valoresPorMesEAno;
	}
	@Inject
	private MovimentacaoDao dao;

	private TipoMovimentacao tipoMovimentacao;
	
	
	public void lista() {
		System.out.println("Listando as contas pelos valores movimentados no mes");
		valoresPorMesEAno = dao.listaMesesComMovimentacoes(conta, tipoMovimentacao);

	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Conta getConta() {
		return conta;
	}

}
