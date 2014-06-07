package br.com.agenciacontos.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "usuario_id", nullable = false, length = 11)
	private int usuarioId;

	@Column(name = "cep", nullable = true, length = 10)
	private String cep;

	@Column(name = "endereco", nullable = true, length = 100)
	private String endereco;

	@Column(name = "complemento", nullable = true, length = 100)
	private String complemento;

	@Column(name = "bairro", nullable = true, length = 50)
	private String bairro;

	@Column(name = "cidade", nullable = true, length = 50)
	private String cidade;

	@Column(name = "uf", nullable = true, length = 2)
	private String uf;

	@Column(name = "tipo", nullable = true, length = 2)
	private Integer tipo;

	@Column(name = "principal", nullable = true, length = 2)
	private Integer principal;
	
	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {

		return false;
	}
	@Override
	public String toString() {
		return "";
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
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

	public Integer getPrincipal() {
		return principal;
	}

	public void setPrincipal(Integer principal) {
		this.principal = principal;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	
}