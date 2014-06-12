package br.com.agenciacontos.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.agenciacontos.enums.UsuarioTipoEnum;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private Pessoa pessoa;
	
	@Id
	@Column(name = "pessoa_id", nullable = false, length = 11)
	private int pessoaId;

	@Column(name = "senha", nullable = true, length = 100)
	private String senha;
	
	@Column(name = "usuario_tipo", nullable = true, length = 2)
	private Integer usuarioTipo;
	
	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

	public boolean isAdmin() {
		return UsuarioTipoEnum.ADMIN.equals(usuarioTipo);
	}

	public boolean isCliente() {
		return UsuarioTipoEnum.CLIENTE.equals(usuarioTipo);
	}

	public boolean isLoja() {
		return UsuarioTipoEnum.LOJA.equals(usuarioTipo);
	}
	
	@Override
	public int hashCode() {
		return pessoaId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario usuario = (Usuario) obj;
			return usuario.getPessoaId() == pessoaId;
		}

		return false;
	}

	public int getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getUsuarioTipo() {
		return usuarioTipo;
	}

	public void setUsuarioTipo(Integer usuarioTipo) {
		this.usuarioTipo = usuarioTipo;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}