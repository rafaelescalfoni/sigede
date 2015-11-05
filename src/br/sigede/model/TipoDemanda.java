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
@Table(name = "tipodemanda")
@NamedQueries({
    @NamedQuery(name = "TipoDemanda.findAll", query = "SELECT td FROM TipoDemanda td"),
    @NamedQuery(name = "TipoDemanda.findById", query = "SELECT td FROM TipoDemanda td WHERE td.id = :id"),
    @NamedQuery(name = "TipoDemanda.findByNome", query = "SELECT td FROM TipoDemanda td WHERE td.nome = :nome")})
public class TipoDemanda implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipodemanda")
    //private List<Usuario> usuarioList;
    
    public TipoDemanda() {
    }
    
    public TipoDemanda(Long id) {
        this.id = id;
    }
    
    public TipoDemanda(Long id, String nome) {
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

	//public List<Usuario> getUsuarioList() {
	//	return usuarioList;
	//}

	//public void setUsuarioList(List<Usuario> usuarioList) {
	//	this.usuarioList = usuarioList;
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
       if (!(object instanceof TipoDemanda)) {
           return false;
       }
       TipoDemanda other = (TipoDemanda) object;
       if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
           return false;
       }
       return true;
    }
    
    @Override
    public String toString() {
        return "br.sigede.model.TipoDemanda[ id=" + id + " ]";
    }

}
