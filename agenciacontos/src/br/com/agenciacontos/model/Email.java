package br.com.agenciacontos.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "email")
@IdClass(EmailPK.class)
public class Email implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	@Id
	private int pessoaId;

	@Column(name = "email", nullable = true, length = 50)
	private String email;

	@Column(name = "indicador_preferencial", nullable = true)
	private Boolean indicadorEmailPreferencial;
	
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
		if (obj instanceof Email) {
			Email email = (Email) obj;
			return email.id == this.id && email.pessoaId == this.pessoaId;
        }
 
		return false;
	}
	
	@Override
	public String toString() {
		return "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Boolean getIndicadorEmailPreferencial() {
		return indicadorEmailPreferencial;
	}

	public void setIndicadorEmailPreferencial(Boolean indicadorEmailPreferencial) {
		this.indicadorEmailPreferencial = indicadorEmailPreferencial;
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

}