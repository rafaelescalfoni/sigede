package br.sigede.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "registrodemanda")
@NamedQueries({
    @NamedQuery(name = "RegistroDemanda.findAll", query = "SELECT rd FROM RegistroDemanda rd"),
    @NamedQuery(name = "RegistroDemanda.findById", query = "SELECT rd FROM RegistroDemanda rd WHERE rd.id = :id"),
    @NamedQuery(name = "RegistroDemanda.findByAssunto", query = "SELECT rd FROM RegistroDemanda rd WHERE rd.assunto = :assunto"),
    @NamedQuery(name = "RegistroDemanda.findByDesdobramento", query = "SELECT rd FROM RegistroDemanda rd WHERE rd.desdobramento = :desdobramento"),
    @NamedQuery(name = "RegistroDemanda.findByProvidencia", query = "SELECT rd FROM RegistroDemanda rd WHERE rd.providencia = :providencia"),
    @NamedQuery(name = "RegistroDemanda.findByData_atualizacao", query = "SELECT rd FROM RegistroDemanda rd WHERE rd.data_atualizacao = :data_atualizacao")})
public class RegistroDemanda implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "areatematica", length=40)
    private String areatematica;
    @Column(name = "unidade", length=40)
    private String unidade;  
    @Column(name = "assunto")
    private String assunto;
    @Column(name = "desdobramento")
    private String desdobramento;
    @Column(name = "providencia")
    private String providencia;
    @Column(name = "data_atualizacao")
    private String data_atualizacao;
    @Column(name = "statusregistro", length=20)
    private String statusregistro;
    
    @ManyToOne
    @JoinColumn(name = "demanda_id", referencedColumnName = "id")
    private Demanda demanda;
    
    public RegistroDemanda() {
    }
    
    public RegistroDemanda(Long id) {
        this.id = id;
    }
    
    public RegistroDemanda(Long id, String areatematica, String unidade, 
    		String assunto, String desdobramento, String providencia, String data_atualizacao, String statusregistro) {
        this.id = id;
        this.areatematica = areatematica;
        this.unidade = unidade;
        this.assunto = assunto;
        this.desdobramento = desdobramento;
        this.providencia = providencia;
        this.data_atualizacao = data_atualizacao;
        this.statusregistro = statusregistro;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Demanda getDemanda() {
		return demanda;
	}

	public void setDemanda(Demanda demanda) {
		this.demanda = demanda;
	}

	public String getAreatematica() {
		return areatematica;
	}

	public void setAreatematica(String areatematica) {
		this.areatematica = areatematica;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDesdobramento() {
		return desdobramento;
	}

	public void setDesdobramento(String desdobramento) {
		this.desdobramento = desdobramento;
	}

	public String getProvidencia() {
		return providencia;
	}

	public void setProvidencia(String providencia) {
		this.providencia = providencia;
	}

	public String getData_atualizacao() {
		return data_atualizacao;
	}

	public void setData_atualizacao(String data_atualizacao) {
		this.data_atualizacao = data_atualizacao;
	}

	public String getStatusregistro() {
		return statusregistro;
	}

	public void setStatusregistro(String statusregistro) {
		this.statusregistro = statusregistro;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       // TODO: Warning - this method won't work in the case the id fields are not set
       if (!(object instanceof RegistroDemanda)) {
           return false;
       }
       RegistroDemanda other = (RegistroDemanda) object;
       if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
           return false;
       }
       return true;
    }
    
    @Override
    public String toString() {
        return "br.sigede.model.RegistroDemanda[ id=" + id + " ]";
    }

}
