package br.sigede.model;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "demandaaudin")
@NamedQueries({
    @NamedQuery(name = "DemandaAudin.findAll", query = "SELECT da FROM DemandaAudin da"),
    @NamedQuery(name = "DemandaAudin.findById", query = "SELECT da FROM DemandaAudin da WHERE da.id = :id"),
    @NamedQuery(name = "DemandaAudin.findByData_cadastro", query = "SELECT da FROM DemandaAudin da WHERE da.data_cadastro = :data_cadastro"),
    @NamedQuery(name = "DemandaAudin.findByNum_demanda", query = "SELECT da FROM DemandaAudin da WHERE da.num_demanda = :num_demanda"),
    @NamedQuery(name = "DemandaAudin.findByData_inicio", query = "SELECT da FROM DemandaAudin da WHERE da.data_inicio = :data_inicio"),
    @NamedQuery(name = "DemandaAudin.findByData_fim", query = "SELECT da FROM DemandaAudin da WHERE da.data_fim = :data_fim"),
    @NamedQuery(name = "DemandaAudin.findByProcesso_interno", query = "SELECT da FROM DemandaAudin da WHERE da.processo_interno = :processo_interno")})
public class DemandaAudin implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "data_cadastro", length=20, updatable=false, nullable=false)
    private String data_cadastro;
    @Column(name = "tipodemanda", nullable=false, length=20)
    private String tipodemanda;
    @Column(name = "tiporelatorioaudin", nullable=false, length=60)
    private String tiporelatorioaudin;
    @Column(name = "num_demanda", nullable=false, length=10)
    private int num_demanda;
    @Column(name = "ano", nullable=false, length=4)
    private String ano;
    @Column(name = "data_inicio", nullable=false, length=20)
    private String data_inicio;
    @Column(name = "data_fim", nullable=false, length=20)
    private String data_fim;
    @Column(name = "processo_interno", nullable=false, length=30)
    private String processo_interno;
    @Column(name = "institucional", nullable=false, length=5)
    private String institucional;
    @Column(name = "foco", length=40)
    private String foco;
    @Column(name = "unidadeauditada", length=40)
    private String unidadeauditada;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", updatable=false, nullable=false)
    private Usuario usuario;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "demandaaudin_id")
	private List<RegistroDemandaAudin> registrodemandaaudinList = new ArrayList<RegistroDemandaAudin>();
    

	public DemandaAudin() {
    }
    
    public DemandaAudin(Long id) {
        this.id = id;
    }
    
    public DemandaAudin(Long id, String tipodemanda, String tiporelatorioaudin, int num_demanda, String ano) {
        this.id = id;
        this.tipodemanda = tipodemanda;
        this.tiporelatorioaudin = tiporelatorioaudin;
        this.num_demanda = num_demanda;
        this.ano = ano;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTiporelatorioaudin() {
		return tiporelatorioaudin;
	}

	public void setTiporelatorioaudin(String tiporelatorioaudin) {
		this.tiporelatorioaudin = tiporelatorioaudin;
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

	public String getProcesso_interno() {
		return processo_interno;
	}

	public void setProcesso_interno(String processo_interno) {
		this.processo_interno = processo_interno;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<RegistroDemandaAudin> getRegistrodemandaaudinList() {
		return registrodemandaaudinList;
	}

	public void setRegistrodemandaaudinList(List<RegistroDemandaAudin> registrodemandaaudinList) {
		this.registrodemandaaudinList = registrodemandaaudinList;
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
