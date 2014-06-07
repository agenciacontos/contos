package br.com.agenciacontos.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.agenciacontos.dao.LojaDAO;
import br.com.agenciacontos.dao.UsuarioLojaDAO;
import br.com.agenciacontos.model.Loja;
import br.com.agenciacontos.model.UsuarioLoja;
import br.com.agenciacontos.seguranca.ControleAcesso;

@RequestScoped
@Named
public class LojaFacade extends AbstractFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject private LojaDAO lojaDAO;
	@Inject private UsuarioLojaDAO usuarioLojaDAO;
	
	@Inject ControleAcesso controleAcesso;
	
	public List<Loja> listarLojasPorUsuario(Integer usuario_id) throws Exception {
		
		//buscando o id das lojas
		List<UsuarioLoja> usuarioLojas = usuarioLojaDAO.listarLojasPorUsuario(usuario_id);

		List<Integer> lojas_id = new ArrayList<Integer>();
		for (Object usuarioLoja : usuarioLojas.toArray()) {
			UsuarioLoja uLoja = (UsuarioLoja) usuarioLoja;
			lojas_id.add(uLoja.getId());
		}
		
		if(lojas_id == null || lojas_id.size() <= 0)
			return new ArrayList<Loja>();
		
		return lojaDAO.listarLojasPorId(lojas_id);
	}	
	
	public Loja findLoja(int lojaId) throws Exception {
//		lojaDAO.beginTransaction();
		Loja loja = lojaDAO.find(lojaId);
//		lojaDAO.closeTransaction();
		return loja;
	}

	public List<Loja> listAll() throws Exception {
//		lojaDAO.beginTransaction();
		List<Loja> result = lojaDAO.findAll();
//		lojaDAO.closeTransaction();
		return result;
	}

	public void deleteLoja(Loja loja) throws Exception {
//		lojaDAO.beginTransaction();
		Loja persistedLoja = lojaDAO.findReferenceOnly(loja.getId());
		lojaDAO.delete(persistedLoja);
//		lojaDAO.commitAndCloseTransaction();
	}
}