package br.com.ciacpla.rovdigital.util;

import org.hibernate.Session;
import org.junit.Test;

import br.com.ciacpla.rovdigital.util.HibernateUtil;

public class HibernateUtilTest {
	
	@Test
	public void conectar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
