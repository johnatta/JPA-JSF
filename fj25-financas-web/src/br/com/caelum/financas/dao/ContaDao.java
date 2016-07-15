package br.com.caelum.financas.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;

@Stateless
public class ContaDao {

	@Inject
	EntityManager manager;


	public void altera(Conta conta) {
		Conta contaParaAltera = this.manager.find(Conta.class, conta.getId());
		manager.joinTransaction();
		this.manager.merge(conta);
	}
	
	public void adiciona(Conta conta) {
		manager.joinTransaction();
		this.manager.persist(conta);
	}

	public Conta busca(Integer id) {
		return this.manager.find(Conta.class, id);
	}

	public List<Conta> lista() {
		return this.manager.createQuery("select c from Conta c", Conta.class)
				.getResultList();
	}

	public void remove(Conta conta) {
		Conta contaParaRemover = this.manager.find(Conta.class, conta.getId());
		manager.joinTransaction();
		this.manager.remove(contaParaRemover);
	}
	
	public int trocaNomeDoBancoEmLote(String antigoNomeBanco, String novoNomeBanco){
		String jpql ="update Conta c SET c.banco =:novoNome where c.banco=:antigoNome";
		Query query = manager.createQuery(jpql);
		query.setParameter("antigoNome", antigoNomeBanco);
		query.setParameter("novoNome", novoNomeBanco);
		return query.executeUpdate();
	}

}
