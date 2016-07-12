package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.List;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ContasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Conta conta = new Conta();
	private List<Conta> contas;

	@Inject
	private ContaDao contaDao;

	public Conta getConta() {
		contaDao.lista();

		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void grava() {
		if (this.conta.getId() == null) {
			contaDao.adiciona(conta);
		} else {
			contaDao.altera(conta);
		}
		this.contas = contaDao.lista();
		System.out.println("Gravando a conta");

		limpaFormularioDoJSF();
	}

	public List<Conta> getContas() {
		if (this.contas == null) {
			this.contas = contaDao.lista();
		}
		System.out.println("Listando as contas");

		return contas;
	}

	public void remove() {
		contaDao.remove(this.conta);
		this.contas = contaDao.lista();
		System.out.println("Removendo a conta");

		limpaFormularioDoJSF();
	}

	/**
	 * Esse metodo apenas limpa o formulario da forma com que o JSF espera.
	 * Invoque-o no momento em que precisar do formulario vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.conta = new Conta();
	}
}
