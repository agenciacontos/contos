package br.com.contos.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "telefone")
public class Telefone implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "telefone_id", nullable = false, length = 11)
	private int id;
	
	@Id
	@Column(name = "pessoa_id", nullable = false, length = 11)
	private int pessoaId;

	@Column(name = "ddi", nullable = true, length = 5)
	private String ddi;

	@Column(name = "ddd", nullable = true, length = 5)
	private String ddd;

	@Column(name = "numero", nullable = true, length = 15)
	private String numero;

	@Column(name = "telefone_tipo", nullable = true, length = 20)
	private String telefoneTipo;

	@Column(name = "indicador_preferencial", nullable = true)
	private Boolean indicador_preferencial;
	
	@Column(name = "data_inicio", nullable = true)
	private Date data_inicio;
	
	@Column(name = "data_fim", nullable = true)
	private Date data_fim;

	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

	@Override
	public int hashCode() {
		return id+pessoaId;
	}

	@Override
	public boolean equals(Object obj) {

		return false;
	}
	
	@Override
	public String toString() {
		return "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTelefoneTipo() {
		return telefoneTipo;
	}

	public void setTelefoneTipo(String telefoneTipo) {
		this.telefoneTipo = telefoneTipo;
	}

	public Boolean getIndicador_preferencial() {
		return indicador_preferencial;
	}

	public void setIndicador_preferencial(Boolean indicador_preferencial) {
		this.indicador_preferencial = indicador_preferencial;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
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
}