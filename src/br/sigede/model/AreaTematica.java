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
@Table(name = "areatematica")
@NamedQueries({
    @NamedQuery(name = "AreaTematica.findAll", query = "SELECT at FROM AreaTematica at"),
    @NamedQuery(name = "AreaTematica.findById", query = "SELECT at FROM AreaTematica at WHERE at.id = :id"),
    @NamedQuery(name = "AreaTematica.findByNome", query = "SELECT at FROM AreaTematica at WHERE at.nome = :nome")})
public class AreaTematica implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "areatematica")
    //private List<Demanda> demandaList;
    
    public AreaTematica() {
    }
    
    public AreaTematica(Long id) {
        this.id = id;
    }
    
    public AreaTematica(Long id, String nome) {
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
       if (!(object instanceof AreaTematica)) {
           return false;
       }
       AreaTematica other = (AreaTematica) object;
       if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
           return false;
       }
       return true;
    }
    
    @Override
    public String toString() {
        return "br.sigede.model.AreaTematica[ id=" + id + " ]";
    }
}
