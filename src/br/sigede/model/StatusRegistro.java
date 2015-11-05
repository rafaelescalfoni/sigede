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
@Table(name = "statusregistro")
@NamedQueries({
    @NamedQuery(name = "StatusRegistro.findAll", query = "SELECT sr FROM StatusRegistro sr"),
    @NamedQuery(name = "StatusRegistro.findById", query = "SELECT sr FROM StatusRegistro sr WHERE sr.id = :id"),
    @NamedQuery(name = "StatusRegistro.findByNome", query = "SELECT sr FROM StatusRegistro sr WHERE sr.nome = :nome")})
public class StatusRegistro implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "statusregistro")
    //private List<Demanda> demandaList;
    
    public StatusRegistro() {
    }
    
    public StatusRegistro(Long id) {
        this.id = id;
    }
    
    public StatusRegistro(Long id, String nome) {
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
       if (!(object instanceof StatusRegistro)) {
           return false;
       }
       StatusRegistro other = (StatusRegistro) object;
       if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
           return false;
       }
       return true;
    }
    
    @Override
    public String toString() {
        return "br.sigede.model.StatusRegistro[ id=" + id + " ]";
    }

}
