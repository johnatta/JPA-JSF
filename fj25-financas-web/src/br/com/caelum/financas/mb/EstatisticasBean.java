package br.com.caelum.financas.mb;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.stat.Statistics;

@Named
@ApplicationScoped
public class EstatisticasBean {
	@Inject
	private EntityManager manager;
	
	public Statistics getEstatisticas() {
		return estatisticas;
	}

	private Statistics estatisticas;

		public void gera() {
			System.out.println("Gerando est�tisitcas");
			Session session = this.manager.unwrap(Session.class);
			this.estatisticas = session.getSessionFactory().getStatistics();
		}
}
