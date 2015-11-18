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
@Table(name = "demandado")
@NamedQueries({
    @NamedQuery(name = "DemandaDo.findAll", query = "SELECT dt FROM DemandaDo dt"),
    @NamedQuery(name = "DemandaDo.findById", query = "SELECT dt FROM DemandaDo dt WHERE dt.id = :id"),
    @NamedQuery(name = "DemandaDo.findByData_demanda", query = "SELECT dt FROM DemandaDo dt WHERE dt.data_demanda = :data_demanda"),
    @NamedQuery(name = "DemandaDo.findByRemetente", query = "SELECT dt FROM DemandaDo dt WHERE dt.remetente = :remetente"),
    @NamedQuery(name = "DemandaDo.findByInteressado", query = "SELECT dt FROM DemandaDo dt WHERE dt.interessado = :interessado"),
    @NamedQuery(name = "DemandaDo.findByNaturezado", query = "SELECT dt FROM DemandaDo dt WHERE dt.naturezado = :naturezado"),
    @NamedQuery(name = "DemandaDo.findByNum_relatorio", query = "SELECT dt FROM DemandaDo dt WHERE dt.num_relatorio = :num_relatorio"),
    @NamedQuery(name = "DemandaDo.findByData_relatorio", query = "SELECT dt FROM DemandaDo dt WHERE dt.data_relatorio = :data_relatorio")})
public class DemandaDo implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "data_demanda", updatable=false, nullable=false, length=30)
    private String data_demanda;
    @Column(name = "remetente", length=80)
    private String remetente;
    @Column(name = "interessado", length=80)
    private String interessado;
    @Column(name = "naturezado", length=20)
    private String naturezado;
    @Column(name = "tiporelatoriodo", length=50)
    private String tiporelatoriodo;
    @Column(name = "num_relatorio", length=10)
    private int num_relatorio;
    @Column(name = "data_relatorio", updatable=false, nullable=false, length=30)
    private String data_relatorio;
    @Column(name = "exerciciorelatorio", length=4)
    private String exerciciorelatorio;
    
    @OneToOne(cascade=CascadeType.ALL, optional=false, fetch=FetchType.LAZY, orphanRemoval=true)  
    @PrimaryKeyJoinColumn
    private Demanda demanda;
    
    
    public DemandaDo() {
    }
    
    public DemandaDo(Long id) {
        this.id = id;
    }
    
    public DemandaDo(Long id, String data_demanda, String remetente, String interessado, 
    		String naturezado, String tiporelatoriodo, int num_relatorio, String data_relatorio, String exerciciorelatorio) {
        this.id = id;
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
