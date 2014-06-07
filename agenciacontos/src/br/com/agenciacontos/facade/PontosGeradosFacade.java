package br.com.agenciacontos.facade;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.agenciacontos.dao.PontosGeradosDAO;
import br.com.agenciacontos.enums.PontosStatusEnum;
import br.com.agenciacontos.model.PontosGerados;
import br.com.agenciacontos.util.Utils;

@RequestScoped
@Named
public class PontosGeradosFacade extends AbstractFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject private PontosGeradosDAO pontosGeradosDAO;
	
	public void incluirPontos(PontosGerados pontosGerados) throws Exception {
		
//		pontosGerados.setLojaId(controleAcesso.getLoja().getId());
//		pontosGerados.setValidade(null);
//		pontosGerados.setMotivo(motivo);
//		pontosGerados.setPontos(pontos);
		pontosGerados.setData(Utils.getDataHoraAtual());

		pontosGerados.setStatus(PontosStatusEnum.ATIVO.getCodigo());

		pontosGerados.setCriado(Utils.getDataHoraAtual());
		pontosGerados.setModificado(Utils.getDataHoraAtual());
		
		pontosGeradosDAO.beginTransaction();
		pontosGeradosDAO.save(pontosGerados);
		pontosGeradosDAO.commit();
		
	}
	
}