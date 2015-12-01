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
@Table(name = "demandado")
@NamedQueries({
	@NamedQuery(name = "DemandaDo.findAll", query = "SELECT dd FROM DemandaDo dd"),
    @NamedQuery(name = "DemandaDo.findById", query = "SELECT dd FROM DemandaDo dd WHERE dd.id = :id"),
    @NamedQuery(name = "DemandaDo.findByData_cadastro", query = "SELECT dd FROM DemandaDo dd WHERE dd.data_cadastro = :data_cadastro"),
    @NamedQuery(name = "DemandaDo.findByNum_demanda", query = "SELECT dd FROM DemandaDo dd WHERE dd.num_demanda = :num_demanda"),
    @NamedQuery(name = "DemandaDo.findByData_demanda", query = "SELECT dd FROM DemandaDo dd WHERE dd.data_demanda = :data_demanda"),
    @NamedQuery(name = "DemandaDo.findByRemetente", query = "SELECT dd FROM DemandaDo dd WHERE dd.remetente = :remetente"),
    @NamedQuery(name = "DemandaDo.findByInteressado", query = "SELECT dd FROM DemandaDo dd WHERE dd.interessado = :interessado"),
    @NamedQuery(name = "DemandaDo.findByProcesso_interno", query = "SELECT dd FROM DemandaDo dd WHERE dd.processo_interno = :processo_interno"),
    @NamedQuery(name = "DemandaDo.findByNaturezado", query = "SELECT dd FROM DemandaDo dd WHERE dd.naturezado = :naturezado"),
    @NamedQuery(name = "DemandaDo.findByNum_relatorio", query = "SELECT dd FROM DemandaDo dd WHERE dd.num_relatorio = :num_relatorio"),
    @NamedQuery(name = "DemandaDo.findByData_relatorio", query = "SELECT dd FROM DemandaDo dd WHERE dd.data_relatorio = :data_relatorio")})
public class DemandaDo implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "data_cadastro", updatable=false, nullable=false, length=20)
    private String data_cadastro;
    @Column(name = "tipodemandado", nullable=false, length=20)
    private String tipodemandado;
    @Column(name = "num_demanda", length=10)
    private int num_demanda;
    @Column(name = "ano", length=4)
    private String ano;
    @Column(name = "data_demanda", nullable=false, length=20)
    private String data_demanda;
    @Column(name = "remetente", nullable=false, length=80)
    private String remetente;
    @Column(name = "interessado", nullable=false, length=80)
    private String interessado;
    @Column(name = "processo_interno", length=30)
    private String processo_interno;
    @Column(name = "naturezado", nullable=false, length=20)
    private String naturezado;
    @Column(name = "tiporelatoriodo", length=50)
    private String tiporelatoriodo;
    @Column(name = "num_relatorio", length=10)
    private int num_relatorio;
    @Column(name = "data_relatorio", length=30)
    private String data_relatorio;
    @Column(name = "exerciciorelatorio", length=4)
    private String exerciciorelatorio;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", updatable=false, nullable=false)
    private Usuario usuario;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "demandado_id")
	private List<RegistroDemandaDo> registrodemandadoList = new ArrayList<RegistroDemandaDo>();
    
    
    public DemandaDo() {
    }
    
    public DemandaDo(Long id) {
        this.id = id;
    }
    
    public DemandaDo(Long id, String tipodemandado, int num_demanda, String ano, String data_demanda, String remetente, String interessado, 
    		String naturezado, String tiporelatoriodo, int num_relatorio, String data_relatorio, String exerciciorelatorio) {
        this.id = id;
        this.tipodemandado = tipodemandado;
        this.num_demanda = num_demanda;
        this.ano = ano;
        this.data_demanda = data_demanda;
        this.remetente = remetente;
        this.interessado = interessado;
        this.naturezado = naturezado;
        this.tiporelatoriodo = tiporelatoriodo;
        this.num_relatorio = num_relatorio;
        this.data_relatorio = data_relatorio;
        this.exerciciorelatorio = exerciciorelatorio;
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

	public String getTipodemandado() {
		return tipodemandado;
	}

	public void setTipodemandado(String tipodemandado) {
		this.tipodemandado = tipodemandado;
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

	public String getData_demanda() {
		return data_demanda;
	}

	public void setData_demanda(String data_demanda) {
		this.data_demanda = data_demanda;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getInteressado() {
		return interessado;
	}

	public void setInteressado(String interessado) {
		this.interessado = interessado;
	}

	public String getProcesso_interno() {
		return processo_interno;
	}

	public void setProcesso_interno(String processo_interno) {
		this.processo_interno = processo_interno;
	}

	public String getNaturezado() {
		return naturezado;
	}

	public void setNaturezado(String naturezado) {
		this.naturezado = naturezado;
	}

	public String getTiporelatoriodo() {
		return tiporelatoriodo;
	}

	public void setTiporelatoriodo(String tiporelatoriodo) {
		this.tiporelatoriodo = tiporelatoriodo;
	}

	public int getNum_relatorio() {
		return num_relatorio;
	}

	public void setNum_relatorio(int num_relatorio) {
		this.num_relatorio = num_relatorio;
	}

	public String getData_relatorio() {
		return data_relatorio;
	}

	public void setData_relatorio(String data_relatorio) {
		this.data_relatorio = data_relatorio;
	}

	public String getExerciciorelatorio() {
		return exerciciorelatorio;
	}

	public void setExerciciorelatorio(String exerciciorelatorio) {
		this.exerciciorelatorio = exerciciorelatorio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<RegistroDemandaDo> getRegistrodemandadoList() {
		return registrodemandadoList;
	}

	public void setRegistrodemandadoList(List<RegistroDemandaDo> registrodemandadoList) {
		this.registrodemandadoList = registrodemandadoList;
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
        if (!(object instanceof DemandaDo)) {
            return false;
        }
        DemandaDo other = (DemandaDo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.sigede.model.DemandaDo[ id=" + id + " ]";
    }

}
