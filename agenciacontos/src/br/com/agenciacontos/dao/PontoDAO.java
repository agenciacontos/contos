package br.com.agenciacontos.dao;
 

import java.sql.Date;

import br.com.agenciacontos.model.Ponto;
import br.com.agenciacontos.util.Utils;
 
public class PontoDAO extends GenericDAO<Ponto> {
	private static final long serialVersionUID = 1L;

	public PontoDAO() {
        super(Ponto.class);
    }
	
	public Ponto cadastrarPonto(Integer lojaId, Integer pessoaId, Date data, String descricao, Long pontos, Double valor, Date validade, Integer cartao) throws Exception {
		
		Ponto ponto = new Ponto();
		ponto.setLojaId(lojaId);
		ponto.setCriado(Utils.getDataHoraAtual());
		ponto.setModificado(Utils.getDataHoraAtual());
		ponto.setPessoaId(pessoaId);
		ponto.setPontos(pontos);
		ponto.setValidade(validade);
		ponto.setCartao(cartao);
		ponto.setData(data);
		ponto.setDescricao(descricao);
//		ponto.setCompraId(compraId);
//		ponto.setCodigoTipoConversao(codigoTipoConversao);
//		ponto.setId(id);
		ponto.setValor(valor);
		
		getSession().persist(ponto);
		
		return ponto;
		
	}
}