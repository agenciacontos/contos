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
@Table(name = "pontos_gerados")
public class PontosGerados implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "usuario_id", nullable = false, length = 11)
	private int usuarioId;
	
	@Column(name = "loja_id", nullable = false, length = 11)
	private int lojaId;
	
	@Column(name = "usuario_executante_id", nullable = false, length = 11)
	private int usuarioExecutanteId;
	
	@Column(name = "pontos", nullable = false, length = 11)
	private Long pontos;
	
	@Column(name = "motivo", nullable = true)
	private String motivo;
	
	@Column(name = "data", nullable = true)
	private Date data;

	@Column(name = "validade", nullable = true)
	private Date validade;

	@Column(name = "status", nullable = false, length = 2)
	private Integer status;
	
	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

	@Override
	public int hashCode() {
		return usuarioId+lojaId+usuarioExecutanteId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PontosGerados) {
			PontosGerados pontosGerados = (PontosGerados) obj;
			return pontosGerados.getId() == id;
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

	public int getLojaId() {
		return lojaId;
	}

	public void setLojaId(int lojaId) {
		this.lojaId = lojaId;
	}

	public Long getPontos() {
		return pontos;
	}

	public void setPontos(Long pontos) {
		this.pontos = pontos;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
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

	public int getUsuarioExecutanteId() {
		return usuarioExecutanteId;
	}

	public void setUsuarioExecutanteId(int usuarioExecutanteId) {
		this.usuarioExecutanteId = usuarioExecutanteId;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	
}