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
@Table(name = "demandatcu")
@NamedQueries({
    @NamedQuery(name = "DemandaTcu.findAll", query = "SELECT dt FROM DemandaTcu dt"),
    @NamedQuery(name = "DemandaTcu.findById", query = "SELECT dt FROM DemandaTcu dt WHERE dt.id = :id"),
    @NamedQuery(name = "DemandaTcu.findByData_demanda", query = "SELECT dt FROM DemandaTcu dt WHERE dt.data_demanda = :data_demanda"),
    @NamedQuery(name = "DemandaTcu.findByRemetente", query = "SELECT dt FROM DemandaTcu dt WHERE dt.remetente = :remetente"),
    @NamedQuery(name = "DemandaTcu.findByProcessotcu", query = "SELECT dt FROM DemandaTcu dt WHERE dt.processotcu = :processotcu"),
    @NamedQuery(name = "DemandaTcu.findByInteressado", query = "SELECT dt FROM DemandaTcu dt WHERE dt.interessado = :interessado"),
    @NamedQuery(name = "DemandaTcu.findByNaturezatcu", query = "SELECT dt FROM DemandaTcu dt WHERE dt.naturezatcu = :naturezatcu"),
    @NamedQuery(name = "DemandaTcu.findByNum_acordao", query = "SELECT dt FROM DemandaTcu dt WHERE dt.num_acordao = :num_acordao"),
    @NamedQuery(name = "DemandaTcu.findByData_sessaoacordao", query = "SELECT dt FROM DemandaTcu dt WHERE dt.data_sessaoacordao = :data_sessaoacordao")})
public class DemandaTcu implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "data_demanda", updatable=false, nullable=false, length=30)
    private String data_demanda;
    @Column(name = "remetente", length=80)
    private String remetente;
    @Column(name = "processotcu", length=30)
    private String processotcu;
    @Column(name = "interessado", length=80)
    private String interessado;
    @Column(name = "naturezatcu", length=20)
    private String naturezatcu;
    @Column(name = "num_acordao", length=10)
    private int num_acordao;
    @Column(name = "anoacordao", length=4)
    private String anoacordao;
    @Column(name = "colegiadoacordao", length=20)
    private String colegiadoacordao;
    @Column(name = "data_sessaoacordao", updatable=false, nullable=false, length=30)
    private String data_sessaoacordao;
    
    @OneToOne(cascade=CascadeType.ALL, optional=false, fetch=FetchType.LAZY, orphanRemoval=true)  
    @PrimaryKeyJoinColumn
    private Demanda demanda;
    
    
    public DemandaTcu() {
    }
    
    public DemandaTcu(Long id) {
        this.id = id;
    }
    
    public DemandaTcu(Long id, String data_demanda, String remetente, String processotcu, String interessado,
    		String naturezatcu, int num_acordao, String anoacordao, String colegiadoacordao, String data_sessaoacordao) {
        this.id = id;
        this.data_demanda = data_demanda;
        this.remetente = remetente;
        this.processotcu = processotcu;
        this.interessado = interessado;
        this.naturezatcu = naturezatcu;
        this.num_acordao = num_acordao;
        this.anoacordao = anoacordao;
        this.colegiadoacordao = colegiadoacordao;
        this.data_sessaoacordao = data_sessaoacordao;
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

	public String getProcessotcu() {
		return processotcu;
	}

	public void setProcessotcu(String processotcu) {
		this.processotcu = processotcu;
	}

	public String getInteressado() {
		return interessado;
	}

	public void setInteressado(String interessado) {
		this.interessado = interessado;
	}

	public String getNaturezatcu() {
		return naturezatcu;
	}

	public void setNaturezatcu(String naturezatcu) {
		this.naturezatcu = naturezatcu;
	}

	public int getNum_acordao() {
		return num_acordao;
	}

	public void setNum_acordao(int num_acordao) {
		this.num_acordao = num_acordao;
	}

	public String getAnoacordao() {
		return anoacordao;
	}

	public void setAnoacordao(String anoacordao) {
		this.anoacordao = anoacordao;
	}

	public String getColegiadoacordao() {
		return colegiadoacordao;
	}

	public void setColegiadoacordao(String colegiadoacordao) {
		this.colegiadoacordao = colegiadoacordao;
	}

	public String getData_sessaoacordao() {
		return data_sessaoacordao;
	}

	public void setData_sessaoacordao(String data_sessaoacordao) {
		this.data_sessaoacordao = data_sessaoacordao;
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
        if (!(object instanceof DemandaTcu)) {
            return false;
        }
        DemandaTcu other = (DemandaTcu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.sigede.model.DemandaTcu[ id=" + id + " ]";
    }

}
