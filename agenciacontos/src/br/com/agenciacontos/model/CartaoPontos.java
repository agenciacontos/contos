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
@Table(name = "cartao_pontos")
public class CartaoPontos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "loja_id", nullable = false, length = 11)
	private int lojaId;
	
	@Column(name = "usuario_executante_id", nullable = false, length = 11)
	private int usuarioExecutanteId;
	
	@Column(name = "validade", nullable = true)
	private Date validade;

	@Column(name = "pontos", nullable = false, length = 11)
	private Long pontos;
	
	@Column(name = "hash", nullable = false, length = 100)
	private String hash;
	
	@Column(name = "motivo", nullable = true, length = 1000)
	private int motivo;
	
	@Column(name = "usuario_beneficiado_id", nullable = false, length = 11)
	private int usuarioBeneficiadoId;
	
	@Column(name = "status", nullable = false, length = 2)
	private Integer status;
	
	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

	@Override
	public int hashCode() {
		return lojaId+usuarioExecutanteId+usuarioBeneficiadoId;
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

	public int getLojaId() {
		return lojaId;
	}

	public void setLojaId(int lojaId) {
		this.lojaId = lojaId;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Long getPontos() {
		return pontos;
	}

	public void setPontos(Long pontos) {
		this.pontos = pontos;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public int getMotivo() {
		return motivo;
	}

	public void setMotivo(int motivo) {
		this.motivo = motivo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public int getUsuarioBeneficiadoId() {
		return usuarioBeneficiadoId;
	}

	public void setUsuarioBeneficiadoId(int usuarioBeneficiadoId) {
		this.usuarioBeneficiadoId = usuarioBeneficiadoId;
	}

	public int getUsuarioExecutanteId() {
		return usuarioExecutanteId;
	}

	public void setUsuarioExecutanteId(int usuarioExecutanteId) {
		this.usuarioExecutanteId = usuarioExecutanteId;
	}
	
}