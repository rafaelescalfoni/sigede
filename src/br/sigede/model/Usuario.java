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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Email;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;


@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByData_cadastro", query = "SELECT u FROM Usuario u WHERE u.data_cadastro = :data_cadastro"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByTelefone", query = "SELECT u FROM Usuario u WHERE u.telefone = :telefone")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "data_cadastro", updatable=false, nullable=false)
    private String data_cadastro;
    @Column(name = "nome")
    @NotEmpty(message="O nome deve ser informado!")
    @Length(min=3, message="O nome precisa ter mais de 3 letras")
    private String nome;
    @Column(name = "email")
    @Email(message="Informe um e-mail valido!")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "area", length=80)
    private String area;
    @Column(name = "perfil", length=50)
    private String perfil;
    @Column(name = "status", length=50)
    private String status;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private List<DemandaAudin> demandaaudinList;

    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	

	public List<DemandaAudin> getDemandaaudinList() {
		return demandaaudinList;
	}

	public void setDemandaaudinList(List<DemandaAudin> demandaaudinList) {
		this.demandaaudinList = demandaaudinList;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.sigede.model.Usuario[ id=" + id + " ]";
    }
    
}
