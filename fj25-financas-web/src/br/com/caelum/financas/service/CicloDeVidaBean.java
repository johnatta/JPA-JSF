package br.com.caelum.financas.service;

import javax.inject.Inject;

public class CicloDeVidaBean {
	@Inject
	private Agendador agendador;
	
	public void executeAgendador() {
		
		agendador.executa();
	}

}
