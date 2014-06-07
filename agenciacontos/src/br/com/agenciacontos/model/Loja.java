package br.com.agenciacontos.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "loja")
@NamedQueries({
	@NamedQuery(name = "Loja.buscarLojaPorDocumento", query = "SELECT l FROM Loja l WHERE l.documento = :documento ")
})
public class Loja implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String BUSCAR_LOJA_POR_DOCUMENTO = "Loja.buscarLojaPorDocumento";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nome_fantasia", nullable = true, length = 100)
	private String nomeFantasia;
	
	@Column(name = "documento", nullable = true, unique = true, length = 15)
	private String documento;
	
	@Column(name = "documento_tipo", nullable = true, length = 1)
	private int documentoTipo;
	
	@Column(name = "email", nullable = true, unique = true, length = 100)
	private String email;
	
	@Column(name = "ativo", nullable = true, length = 2)
	private Boolean status;
	
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

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
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

	public int getDocumentoTipo() {
		return documentoTipo;
	}

	public void setDocumentoTipo(int documentoTipo) {
		this.documentoTipo = documentoTipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}