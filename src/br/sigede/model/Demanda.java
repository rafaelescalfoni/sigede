package br.sigede.model;

import java.io.Serializable;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "demanda")
@NamedQueries({
    @NamedQuery(name = "Demanda.findAll", query = "SELECT d FROM Demanda d"),
    @NamedQuery(name = "Demanda.findById", query = "SELECT d FROM Demanda d WHERE d.id = :id"),
    @NamedQuery(name = "Demanda.findByData_cadastro", query = "SELECT d FROM Demanda d WHERE d.data_cadastro = :data_cadastro"),
    @NamedQuery(name = "Demanda.findByNum_demanda", query = "SELECT d FROM Demanda d WHERE d.num_demanda = :num_demanda"),
    @NamedQuery(name = "Demanda.findByProcesso_interno", query = "SELECT d FROM Demanda d WHERE d.processo_interno = :processo_interno")})
public class Demanda implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "data_cadastro", updatable=false, nullable=false)
    private String data_cadastro;
    @Column(name = "tipodemanda", length=20)
    private String tipodemanda;
    @Column(name = "num_demanda")
    private int num_demanda;
    @Column(name = "ano", length=4)
    private String ano;
    @Column(name = "processo_interno")
    private String processo_interno;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "demanda_id")
	private List<RegistroDemanda> registrodemandaList;
    
    public Demanda() {
    }
    
    public Demanda(Long id) {
        this.id = id;
    }
    
    public Demanda(Long id, String tipodemanda, int num_demanda, String ano, String processo_interno) {
        this.id = id;
        this.tipodemanda = tipodemanda;
        this.num_demanda = num_demanda;
        this.ano = ano;
        this.processo_interno = processo_interno;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(String data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getTipodemanda() {
		return tipodemanda;
	}

	public void setTipodemanda(String tipodemanda) {
		this.tipodemanda = tipodemanda;
	}

	public int getNum_demanda() {
		return num_demanda;
	}

	public void setNum_demanda(int num_demanda) {
		this.num_demanda = num_demanda;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getProcesso_interno() {
		return processo_interno;
	}

	public void setProcesso_interno(String processo_interno) {
		this.processo_interno = processo_interno;
	}
	
	public List<RegistroDemanda> getRegistrodemandaList() {
		return registrodemandaList;
	}

	public void setRegistrodemandaList(List<RegistroDemanda> registrodemandaList) {
		this.registrodemandaList = registrodemandaList;
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
        if (!(object instanceof Demanda)) {
            return false;
        }
        Demanda other = (Demanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.sigede.model.Demanda[ id=" + id + " ]";
    }

}
