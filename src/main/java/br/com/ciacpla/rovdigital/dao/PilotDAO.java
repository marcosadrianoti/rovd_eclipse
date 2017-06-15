package br.com.ciacpla.rovdigital.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.ciacpla.rovdigital.entity.Pilot;
import br.com.ciacpla.rovdigital.util.HibernateUtil;

public class PilotDAO extends GenericDAO<Pilot> {
	
	@SuppressWarnings("unchecked")
	public List<Pilot> listarPilotoPeloTipo(String tipo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			@SuppressWarnings("deprecation")
			Criteria consulta = sessao.createCriteria(Pilot.class);
			consulta.add(Restrictions.eq(tipo,true));
			List<Pilot> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
//	@SuppressWarnings("unchecked")
//	public List<Pilot> listarAlunos() {
//		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
//		try {
//			@SuppressWarnings("deprecation")
//			Criteria consulta = sessao.createCriteria(Pilot.class);
//			consulta.add(Restrictions.eq("student",true));
//			List<Pilot> resultado = consulta.list();
//			return resultado;
//		} catch (RuntimeException erro) {
//			throw erro;
//		} finally {
//			sessao.close();
//		}
//	}

}
