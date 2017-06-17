package br.com.ciacpla.rovdigital.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.omnifaces.util.Faces;

import br.com.ciacpla.rovdigital.bean.AuthenticationBean;
import br.com.ciacpla.rovdigital.entity.User;

@SuppressWarnings("serial")
public class AutenticacaoListener implements PhaseListener{

	@Override
	public void afterPhase(PhaseEvent event) {
		//Pega a pagina atual.
		String paginaAtual = Faces.getViewId(); 
		boolean ehPaginaAutenticacao = paginaAtual.contains("Login.xhtml");
		//Se não é a pagina de autenticação
		if(!ehPaginaAutenticacao){
			//Pega os dados deste elemento. Será usado pra verificar se o usuário está na página de Login.
			AuthenticationBean authenticationBean = Faces.getSessionAttribute("authenticationBean"); 
			if(authenticationBean == null){
				Faces.navigate("/pages/Login.xhtml");
				return;
			}
			//Pega os dados do usuário. Será usado pra verificar se o usuário logou.
			User usuario = authenticationBean.getUsuarioLogado();
			if(usuario == null){
				Faces.navigate("/pages/Login.xhtml");
				return;
			}
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
