package br.com.ciacpla.rovdigital.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.ciacpla.rovdigital.util.HibernateUtil;

public class GenericDAO<Entidade> {
	
	private Class<Entidade> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().
				getGenericSuperclass()).getActualTypeArguments()[0];

	}
	
	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		}catch(RuntimeException erro){
			if(transacao != null){
				transacao.rollback();
			}
			throw erro;
		}finally {
			sessao.close();
		}
			
	}
}
