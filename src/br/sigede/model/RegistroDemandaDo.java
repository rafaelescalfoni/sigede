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
@Table(name = "registrodemandado")
@NamedQueries({
    @NamedQuery(name = "RegistroDemandaDo.findAll", query = "SELECT rdd FROM RegistroDemandaDo rdd"),
    @NamedQuery(name = "RegistroDemandaDo.findById", query = "SELECT rdd FROM RegistroDemandaDo rdd WHERE rdd.id = :id"),
    @NamedQuery(name = "RegistroDemandaDo.findByAssunto", query = "SELECT rdd FROM RegistroDemandaDo rdd WHERE rdd.assunto = :assunto"),
    @NamedQuery(name = "RegistroDemandaDo.findByDesdobramento", query = "SELECT rdd FROM RegistroDemandaDo rdd WHERE rdd.desdobramento = :desdobramento"),
    @NamedQuery(name = "RegistroDemandaDo.findByProvidencia", query = "SELECT rdd FROM RegistroDemandaDo rdd WHERE rdd.providencia = :providencia"),
    @NamedQuery(name = "RegistroDemandaDo.findByData_atualizacao", query = "SELECT rdd FROM RegistroDemandaDo rdd WHERE rdd.data_atualizacao = :data_atualizacao")})
public class RegistroDemandaDo implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "areatematica", nullable=false, length=40)
    private String areatematica;
    @Column(name = "unidade", nullable=false, length=40)
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
    
    @ManyToOne
    @JoinColumn(name = "demandado_id", referencedColumnName = "id", updatable=false, nullable=false)
    private DemandaDo demandado;
    
    public RegistroDemandaDo() {
    }
    
    public RegistroDemandaDo(Long id) {
        this.id = id;
    }
    
    public RegistroDemandaDo(Long id, String areatematica, String unidade, 
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
	
	public DemandaDo getDemandado() {
		return demandado;
	}

	public void setDemandado(DemandaDo demandado) {
		this.demandado = demandado;
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
       if (!(object instanceof RegistroDemandaDo)) {
           return false;
       }
       RegistroDemandaDo other = (RegistroDemandaDo) object;
       if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
           return false;
       }
       return true;
    }
    
    @Override
    public String toString() {
        return "br.sigede.model.RegistroDemandaDo[ id=" + id + " ]";
    }

}
