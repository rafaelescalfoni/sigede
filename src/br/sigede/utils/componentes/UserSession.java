package br.sigede.utils.componentes;

import java.io.Serializable;

import br.sigede.model.DemandaAudin;
import br.sigede.model.DemandaDo;
import br.sigede.model.DemandaTcu;
import br.sigede.model.RegistroDemandaAudin;
import br.sigede.model.RegistroDemandaDo;
import br.sigede.model.RegistroDemandaTcu;
import br.sigede.model.Usuario;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UserSession implements Serializable {
	private static final long serialVersionUID = 1L;

	private Usuario usuario; //SALVA O USUARIO DA SESSAO
	private DemandaAudin demandaaudin;
	private RegistroDemandaAudin registrodemandaaudin;
	private DemandaTcu demandatcu;
	private RegistroDemandaTcu registrodemandatcu;
	private DemandaDo demandado;
	private RegistroDemandaDo regsitrodemandado;

	public boolean isLogged() {
		return usuario != null;
	}

	public void logout() {
		usuario = null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public DemandaAudin getDemandaaudin() {
		return demandaaudin;
	}
	
	public void setDemandaaudin(DemandaAudin demandaaudin) {
		this.demandaaudin = demandaaudin;
	}
	
	public RegistroDemandaAudin getRegistrodemandaaudin() {
		return registrodemandaaudin;
	}
	
	public void setRegistrodemandaaudin(RegistroDemandaAudin registrodemandaaudin) {
		this.registrodemandaaudin = registrodemandaaudin;
	}
	
	public DemandaTcu getDemandatcu() {
		return demandatcu;
	}
	
	public void setDemandatcu(DemandaTcu demandatcu) {
		this.demandatcu = demandatcu;
	}
	
	public RegistroDemandaTcu getRegistrodemandatcu() {
		return registrodemandatcu;
	}
	
	public void setRegistrodemandatcu(RegistroDemandaTcu registrodemandatcu) {
		this.registrodemandatcu = registrodemandatcu;
	}
	
	public DemandaDo getDemandado() {
		return demandado;
	}
	
	public void setDemandado(DemandaDo demandado) {
		this.demandado = demandado;
	}
	
	public RegistroDemandaDo getRegsitrodemandado() {
		return regsitrodemandado;
	}
	
	public void setRegsitrodemandado(RegistroDemandaDo regsitrodemandado) {
		this.regsitrodemandado = regsitrodemandado;
	}
	

	@Override
	public String toString() {
		return "UserSession [usuario.id=" + usuario + ", demandaaudin.id=" + demandaaudin + ", demandatcu.id=" + demandatcu + ", demandado.id=" + demandado + "]";
	}
	
}

