package br.com.ciacpla.rovdigital.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.ciacpla.rovdigital.entity.User;
import br.com.ciacpla.rovdigital.util.HibernateUtil;


public class UserDAO extends GenericDAO<User>{
	
	
	@SuppressWarnings("deprecation")
	public User autenticar(String nome, String senha){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try{
			Criteria consulta = sessao.createCriteria(User.class);	
			
			consulta.add(Restrictions.eq("userName", nome));
			
			SimpleHash hash = new SimpleHash("md5", senha); //Encripta a senha no padão md5
			consulta.add(Restrictions.eq("userPassword", hash.toHex()));
			
			User usuarioAutenticado = (User) consulta.uniqueResult();
			
			return usuarioAutenticado;
			
		}catch(RuntimeException erro){
			throw erro;
		}finally {
			sessao.close();
		}
		
		
	}
}
