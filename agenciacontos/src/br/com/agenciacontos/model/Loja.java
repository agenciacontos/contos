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
@Table(name = "loja")
//@NamedQueries({
//	@NamedQuery(name = "Loja.buscarLojaPorDocumento", query = "SELECT l FROM Loja l WHERE l.documento = :documento ")
//})
public class Loja implements Serializable{
	private static final long serialVersionUID = 1L;
	
//	public static final String BUSCAR_LOJA_POR_DOCUMENTO = "Loja.buscarLojaPorDocumento";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "loja_id", nullable = false, length = 11)
	private int id;
	
	@Column(name = "pessoa_id", nullable = false, length = 11)
	private int pessoaId;
	
	@Column(name = "nome_fantasia", nullable = true, length = 100)
	private String nomeFantasia;
	
	@Column(name = "indicador_matriz", nullable = true)
	private Boolean indicadorMatriz;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Boolean getIndicadorMatriz() {
		return indicadorMatriz;
	}

	public void setIndicadorMatriz(Boolean indicadorMatriz) {
		this.indicadorMatriz = indicadorMatriz;
	}
	
}