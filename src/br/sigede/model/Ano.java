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
@Table(name = "ano")
@NamedQueries({
    @NamedQuery(name = "Ano.findAll", query = "SELECT a FROM Ano a"),
    @NamedQuery(name = "Ano.findById", query = "SELECT a FROM Ano a WHERE a.id = :id"),
    @NamedQuery(name = "Ano.findByAno", query = "SELECT a FROM Ano a WHERE a.ano = :ano")})
public class Ano implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "ano")
    private Long ano;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "ano")
    //private List<Demanda> demandaList;
    
    public Ano() {
    }
    
    public Ano(Long id) {
        this.id = id;
    }
    
    public Ano(Long id, Long ano) {
        this.id = id;
        this.ano = ano;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
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
       if (!(object instanceof Ano)) {
           return false;
       }
       Ano other = (Ano) object;
       if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
           return false;
       }
       return true;
    }
    
    @Override
    public String toString() {
        return "br.sigede.model.Ano[ id=" + id + " ]";
    }

}
