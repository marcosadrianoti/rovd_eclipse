package br.com.ciacpla.rovdigital.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener{

	@Override //Descarrega o Hibernate quando desligar o Tomcat
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtil.getFabricaDeSessoes().close();
		
	}

	@Override //Carrega o Hibernate na inicialização do Tomcat
	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getFabricaDeSessoes();
		
	}

}
