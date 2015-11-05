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
@Table(name = "colegiado")
@NamedQueries({
    @NamedQuery(name = "Colegiado.findAll", query = "SELECT c FROM Colegiado c"),
    @NamedQuery(name = "Colegiado.findById", query = "SELECT c FROM Colegiado c WHERE c.id = :id"),
    @NamedQuery(name = "Colegiado.findByNome", query = "SELECT c FROM Colegiado c WHERE c.nome = :nome")})
public class Colegiado implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "colegiado")
    //private List<Demanda> demandaList;
    
    public Colegiado() {
    }
    
    public Colegiado(Long id) {
        this.id = id;
    }
    
    public Colegiado(Long id, String nome) {
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
        if (!(object instanceof Colegiado)) {
            return false;
        }
        Colegiado other = (Colegiado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "br.sigede.model.Colegiado[ id=" + id + " ]";
    }
    
}
