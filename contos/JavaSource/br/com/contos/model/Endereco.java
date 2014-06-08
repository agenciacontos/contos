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
@Table(name = "endereco")
public class Endereco implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "endereco_id", nullable = false, length = 11)
	private int id;
	
	@Id
	@Column(name = "pessoa_id", nullable = false, length = 11)
	private int pessoaId;

	@Column(name = "cep", nullable = true, length = 10)
	private String cep;

	@Column(name = "logradouro", nullable = true, length = 100)
	private String logradouro;

	@Column(name = "complemento", nullable = true, length = 100)
	private String complemento;

	@Column(name = "bairro", nullable = true, length = 50)
	private String bairro;

	@Column(name = "cidade", nullable = true, length = 50)
	private String cidade;

	@Column(name = "uf", nullable = true, length = 2)
	private String uf;

	@Column(name = "numero", nullable = true, length = 18)
	private String numero;

	@Column(name = "pais", nullable = true, length = 50)
	private String pais;

	@Column(name = "endereco_tipo", nullable = true, length = 2)
	private Integer enderecoTipo;

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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getEnderecoTipo() {
		return enderecoTipo;
	}

	public void setEnderecoTipo(Integer enderecoTipo) {
		this.enderecoTipo = enderecoTipo;
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