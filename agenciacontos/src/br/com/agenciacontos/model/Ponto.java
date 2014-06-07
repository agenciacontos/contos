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
@Table(name = "ponto")
public class Ponto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ponto_id", nullable = false, length = 11)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Id
	@Column(name = "loja_id", nullable = false, length = 11)
	private int lojaId;
	
	@Column(name = "pessoa_id", nullable = false, length = 11)
	private int pessoaId;
	
	@Column(name = "compra_id", nullable = false, length = 11)
	private int compraId;

	@Column(name = "codigo_tipo_conversao", nullable = false, length = 2)
	private Integer codigoTipoConversao;

	@Column(name = "cartao", nullable = true)
	private Integer cartao;
	
	@Column(name = "descricao", nullable = true)
	private String descricao;

	@Column(name = "pontos", nullable = true)
	private Long pontos;
	
	@Column(name = "valor", nullable = true)
	private Double valor;
	
	@Column(name = "data", nullable = true)
	private Date data;

	@Column(name = "validade", nullable = true)
	private Date validade;
	
	@Column(name = "criado", nullable = true)
	private Date criado;
	
	@Column(name = "modificado", nullable = true)
	private Date modificado;

	@Override
	public int hashCode() {
		return id+lojaId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ponto) {
			Ponto pontos = (Ponto) obj;
			return pontos.getId() == id;
		}
		return false;
	}

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

	public int getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}

	public int getCompraId() {
		return compraId;
	}

	public void setCompraId(int compraId) {
		this.compraId = compraId;
	}

	public Integer getCodigoTipoConversao() {
		return codigoTipoConversao;
	}

	public void setCodigoTipoConversao(Integer codigoTipoConversao) {
		this.codigoTipoConversao = codigoTipoConversao;
	}

	public Integer getCartao() {
		return cartao;
	}

	public void setCartao(Integer cartao) {
		this.cartao = cartao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getPontos() {
		return pontos;
	}

	public void setPontos(Long pontos) {
		this.pontos = pontos;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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