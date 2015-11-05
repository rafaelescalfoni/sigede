package br.sigede.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tiporelatorioaudin")
@NamedQueries({
    @NamedQuery(name = "TipoRelatorioAudin.findAll", query = "SELECT ra FROM TipoRelatorioAudin ra"),
    @NamedQuery(name = "TipoRelatorioAudin.findById", query = "SELECT ra FROM TipoRelatorioAudin ra WHERE ra.id = :id"),
    @NamedQuery(name = "TipoRelatorioAudin.findByNome", query = "SELECT ra FROM TipoRelatorioAudin ra WHERE ra.nome = :nome")})
public class TipoRelatorioAudin implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "tiporelatorioaudin")
    //private List<Demanda> demandaList;
    
    public TipoRelatorioAudin() {
    }
    
    public TipoRelatorioAudin(Long id) {
        this.id = id;
    }
    
    public TipoRelatorioAudin(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//public List<Demanda> getDemandaList() {
	//	return demandaList;
	//}

	//public void setDemandaList(List<Demanda> demandaList) {
	//	this.demandaList = demandaList;
	//}
    
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       // TODO: Warning - this method won't work in the case the id fields are not set
       if (!(object instanceof TipoRelatorioAudin)) {
           return false;
       }
       TipoRelatorioAudin other = (TipoRelatorioAudin) object;
       if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
           return false;
       }
       return true;
    }
    
    @Override
    public String toString() {
        return "br.sigede.model.TipoRelatorioAudin[ id=" + id + " ]";
    }
    
}
