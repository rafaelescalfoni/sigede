package br.sigede.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "demandaaudin")
@NamedQueries({
    @NamedQuery(name = "DemandaAudin.findAll", query = "SELECT da FROM DemandaAudin da"),
    @NamedQuery(name = "DemandaAudin.findById", query = "SELECT da FROM DemandaAudin da WHERE da.id = :id"),
    @NamedQuery(name = "DemandaAudin.findByData_inicio", query = "SELECT da FROM DemandaAudin da WHERE da.data_inicio = :data_inicio"),
    @NamedQuery(name = "DemandaAudin.findByData_fim", query = "SELECT da FROM DemandaAudin da WHERE da.data_fim = :data_fim")})
public class DemandaAudin implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "tiporelatorioaudin", length=60)
    private String tiporelatorioaudin;
    @Column(name = "data_inicio", length=30)
    private String data_inicio;
    @Column(name = "data_fim", length=30)
    private String data_fim;
    @Column(name = "institucional", length=5)
    private String institucional;
    @Column(name = "foco", length=40)
    private String foco;
    @Column(name = "unidadeauditada", length=40)
    private String unidadeauditada;
    
    @OneToOne(cascade=CascadeType.ALL, optional=false, fetch=FetchType.LAZY, orphanRemoval=true)  
    @PrimaryKeyJoinColumn  
    private Demanda demanda;
    
    
    public DemandaAudin() {
    }
    
    public DemandaAudin(Long id) {
        this.id = id;
    }
    
    public DemandaAudin(Long id, String tiporelatorioaudin, String data_inicio, String data_fim, String institucional, String foco, String unidadeauditada) {
        this.id = id;
        this.tiporelatorioaudin = tiporelatorioaudin;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.institucional = institucional;
        this.foco = foco;
        this.unidadeauditada = unidadeauditada;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTiporelatorioaudin() {
		return tiporelatorioaudin;
	}

	public void setTiporelatorioaudin(String tiporelatorioaudin) {
		this.tiporelatorioaudin = tiporelatorioaudin;
	}

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public String getData_fim() {
		return data_fim;
	}

	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}

	public String getInstitucional() {
		return institucional;
	}

	public void setInstitucional(String institucional) {
		this.institucional = institucional;
	}

	public String getFoco() {
		return foco;
	}

	public void setFoco(String foco) {
		this.foco = foco;
	}

	public String getUnidadeauditada() {
		return unidadeauditada;
	}

	public void setUnidadeauditada(String unidadeauditada) {
		this.unidadeauditada = unidadeauditada;
	}

	public Demanda getDemanda() {
		return demanda;
	}

	public void setDemanda(Demanda demanda) {
		this.demanda = demanda;
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
        if (!(object instanceof DemandaAudin)) {
            return false;
        }
        DemandaAudin other = (DemandaAudin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.sigede.model.DemandaAudin[ id=" + id + " ]";
    }

}
