package br.sigede.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "registrodemandaaudin")
@NamedQueries({
    @NamedQuery(name = "RegistroDemandaAudin.findAll", query = "SELECT rda FROM RegistroDemandaAudin rda"),
    @NamedQuery(name = "RegistroDemandaAudin.findById", query = "SELECT rda FROM RegistroDemandaAudin rda WHERE rda.id = :id"),
    @NamedQuery(name = "RegistroDemandaAudin.findByAssunto", query = "SELECT rda FROM RegistroDemandaAudin rda WHERE rda.assunto = :assunto"),
    @NamedQuery(name = "RegistroDemandaAudin.findByDesdobramento", query = "SELECT rda FROM RegistroDemandaAudin rda WHERE rda.desdobramento = :desdobramento"),
    @NamedQuery(name = "RegistroDemandaAudin.findByProvidencia", query = "SELECT rda FROM RegistroDemandaAudin rda WHERE rda.providencia = :providencia"),
    @NamedQuery(name = "RegistroDemandaAudin.findByData_atualizacao", query = "SELECT rda FROM RegistroDemandaAudin rda WHERE rda.data_atualizacao = :data_atualizacao")})
public class RegistroDemandaAudin implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable=false, nullable=false)
    private Long id;
    @Column(name = "areatematica", length=40)
    private String areatematica;
    @Column(name = "unidade", length=40)
    private String unidade;  
    @Column(name = "assunto", nullable=false, length=500)
    private String assunto;
    @Column(name = "desdobramento", nullable=false, length=5000)
    private String desdobramento;
    @Column(name = "providencia", length=5000)
    private String providencia;
    @Column(name = "data_atualizacao", nullable=false, length=20)
    private String data_atualizacao;
    @Column(name = "statusregistro", nullable=false, length=40)
    private String statusregistro;
    
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "demandaaudin_id", referencedColumnName = "id", nullable=false)
    private DemandaAudin demandaaudin;
    
    
    public RegistroDemandaAudin() {
    }
    
    public RegistroDemandaAudin(Long id) {
        this.id = id;
    }
    
    public RegistroDemandaAudin(Long id, String areatematica, String unidade, 
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

	public DemandaAudin getDemandaaudin() {
		return demandaaudin;
	}

	public void setDemandaaudin(DemandaAudin demandaaudin) {
		this.demandaaudin = demandaaudin;
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
       if (!(object instanceof RegistroDemandaAudin)) {
           return false;
       }
       RegistroDemandaAudin other = (RegistroDemandaAudin) object;
       if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
           return false;
       }
       return true;
    }
    
    @Override
    public String toString() {
        return "br.sigede.model.RegistroDemandaAudin[ id=" + id + " ]";
    }

}
