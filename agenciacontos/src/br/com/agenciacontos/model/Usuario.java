package br.com.agenciacontos.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.agenciacontos.enums.UsuarioTipoEnum;

@Entity
@Table(name = "usuario")
@NamedQueries({
	@NamedQuery(name = "Usuario.buscarUsuarioPorEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email "),
	@NamedQuery(name = "Usuario.buscarUsuarioPorDocumento", query = "SELECT u FROM Usuario u WHERE u.documento = :documento ")
})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String BUSCAR_POR_EMAIL = "Usuario.buscarUsuarioPorEmail";
	public static final String BUSCAR_POR_DOCUMENTO = "Usuario.buscarUsuarioPorDocumento";
	
	@Transient
	private Integer identificacaoTipo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "nome", nullable = true, length = 100)
	private String nome;
	
	@Column(name = "documento", nullable = false, unique = true, length = 15)
	private String documento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "documento_tipo", nullable = false, length = 1)
	private Integer documentoTipo;
	
	@Column(name = "email", nullable = true, unique = true, length = 100)
	private String email;
	
	@Column(name = "senha", nullable = true, length = 100)
	private String senha;
	
	@Column(name = "status", nullable = true, length = 2)
	private Integer status;
	
	@Column(name = "tipo", nullable = true, length = 2)
	private Integer tipo;
	
	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

	public boolean isAdmin() {
		return UsuarioTipoEnum.ADMIN.equals(tipo);
	}

	public boolean isVendedor() {
		return UsuarioTipoEnum.VENDEDOR.equals(tipo);
	}

	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario usuario = (Usuario) obj;
			return usuario.getId() == id;
		}

		return false;
	}
	
	
	/**
	 * GETS e SETS
	 * */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCriado() {
		return criado;
	}

	public void setCriado(Date criado) {
		this.criado = criado;
	}

	public Date getModificado() {
		return modificado;
	}

	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getDocumentoTipo() {
		return documentoTipo;
	}

	public void setDocumentoTipo(Integer documentoTipo) {
		this.documentoTipo = documentoTipo;
	}

	public Integer getIdentificacaoTipo() {
		return identificacaoTipo;
	}

	public void setIdentificacaoTipo(Integer identificacaoTipo) {
		this.identificacaoTipo = identificacaoTipo;
	}
	
}