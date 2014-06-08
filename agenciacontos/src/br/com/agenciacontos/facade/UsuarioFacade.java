package br.com.agenciacontos.facade;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.agenciacontos.dao.UsuarioDAO;
import br.com.agenciacontos.enums.UsuarioTipoEnum;
import br.com.agenciacontos.model.Usuario;
import br.com.agenciacontos.util.Utils;

public class UsuarioFacade extends AbstractFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject private UsuarioDAO usuarioDAO;
	
	public Usuario verificarDadosLogin(String email, String documento, String senha) throws Exception {
		
		Usuario usuario = usuarioDAO.verificarDadosLogin(email, documento, senha);
		
		return usuario;
	}	
	
	public void cadastrarUsuario(Integer documentoTipo, Integer documento, String nome, String email, String senha) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setUsuarioTipo(UsuarioTipoEnum.CLIENTE.getCodigo());
		
		//TODO refazer apra buscar nos emails
//		if(usuarioDAO.buscarUsuarioPorEmail(usuario.getEmail()) != null){
//			throw new Exception("O e-mail utilizado ja consta na base de dados.");
//		}
//		if(usuarioDAO.buscarUsuarioPorDocumento(usuario.getDocumento()) != null){
//			throw new Exception("O documento utilizado ja consta na base de dados.");
//		}
		
		usuario.setCriado(Utils.getDataHoraAtual());
		usuario.setModificado(Utils.getDataHoraAtual());
		usuario.setSenha(Utils.convertStringToMd5(usuario.getSenha()));
		
		usuarioDAO.beginTransaction();
		usuarioDAO.save(usuario);
		usuarioDAO.commit();
		
	}

	public void updateUsuario(Usuario usuario) throws Exception {
//		usuarioDAO.beginTransaction();
		
//		Usuario persistedUsuario = usuarioDAO.find(usuario.getId());
		
		usuario.setModificado(Utils.getDataHoraAtual());
		
//		persistedUsuario.setCriado(usuario.getCriado());
//		persistedUsuario.setDocumento(usuario.getDocumento());
//		persistedUsuario.setDocumentoTipo(usuario.getDocumentoTipo());
//		persistedUsuario.setEmail(usuario.getEmail());
//		persistedUsuario.setId(usuario.getId());
//		persistedUsuario.setModificado(usuario.getModificado());
//		persistedUsuario.setNome(usuario.getNome());
//		persistedUsuario.setPassword(usuario.getSenha());
//		persistedUsuario.setTipo(usuario.getTipo());

		usuarioDAO.beginTransaction();
//		usuarioDAO.update(persistedUsuario);
		usuarioDAO.commit();
//		usuarioDAO.commitAndCloseTransaction();
	}

	public Usuario findUsuario(int usuarioId) throws Exception {
//		usuarioDAO.beginTransaction();
		Usuario usuario = usuarioDAO.find(usuarioId);
//		usuarioDAO.closeTransaction();
		return usuario;
	}

	public List<Usuario> listAll() throws Exception {
//		usuarioDAO.beginTransaction();
		List<Usuario> result = usuarioDAO.findAll();
//		usuarioDAO.closeTransaction();
		return result;
	}

	public void deleteUsuario(Usuario usuario) throws Exception {
//		usuarioDAO.beginTransaction();
//		Usuario persistedUsuario = usuarioDAO.findReferenceOnly(usuario.getId());
//		usuarioDAO.delete(persistedUsuario);
//		usuarioDAO.commitAndCloseTransaction();
	}
}