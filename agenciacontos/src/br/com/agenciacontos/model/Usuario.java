package br.com.agenciacontos.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.agenciacontos.enums.UsuarioTipoEnum;

@Entity
@Table(name = "usuario")
//@NamedQueries({
//	@NamedQuery(name = "Usuario.buscarUsuarioPorEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email "),
//	@NamedQuery(name = "Usuario.buscarUsuarioPorDocumento", query = "SELECT u FROM Usuario u WHERE u.documento = :documento ")
//})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

//	public static final String BUSCAR_POR_EMAIL = "Usuario.buscarUsuarioPorEmail";
//	public static final String BUSCAR_POR_DOCUMENTO = "Usuario.buscarUsuarioPorDocumento";

	@Transient
	private Integer identificacaoTipo;
	@Transient
	private Pessoa pessoa;
	@Transient
	private Collection<Endereco> enderecos;
	@Transient
	private Collection<Email> emails;
	@Transient
	private Collection<Telefone> telefones;
	
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

	public boolean isVendedor() {
		return UsuarioTipoEnum.VENDEDOR.equals(usuarioTipo);
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

	public Integer getIdentificacaoTipo() {
		return identificacaoTipo;
	}

	public void setIdentificacaoTipo(Integer identificacaoTipo) {
		this.identificacaoTipo = identificacaoTipo;
	}

	public Collection<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Collection<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Collection<Email> getEmails() {
		return emails;
	}

	public void setEmails(Collection<Email> emails) {
		this.emails = emails;
	}

	public Collection<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Collection<Telefone> telefones) {
		this.telefones = telefones;
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