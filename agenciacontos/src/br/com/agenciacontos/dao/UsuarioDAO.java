package br.com.agenciacontos.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.agenciacontos.model.Usuario;
import br.com.agenciacontos.util.Utils;

public class UsuarioDAO extends GenericDAO<Usuario> {

	private static final long serialVersionUID = 1L;

	public UsuarioDAO() {
		super(Usuario.class);
	}
	
	public Usuario cadastrarUsuario(Integer pessoaId, String senha, Integer usuarioTipo) throws Exception {
		
		Usuario usuario = new Usuario();
		
		usuario.setPessoaId(pessoaId);
		usuario.setSenha(senha);
		usuario.setUsuarioTipo(usuarioTipo);
		usuario.setCriado(Utils.getDataHoraAtual());
		usuario.setModificado(Utils.getDataHoraAtual());
		
		getSession().persist(usuario);
		
		usuario.setSenha(null);
		
		return usuario;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Usuario buscarUsuarioPorDocumento(String documento){
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("documento", documento);
//		Usuario usuario = super.findOneResult(Usuario.BUSCAR_POR_DOCUMENTO, parameters);
		
//		return usuario;
		return null;
	}
	
	public Usuario buscarUsuarioPorEmail(String email){
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
//		Usuario usuario = super.findOneResult(Usuario.BUSCAR_POR_EMAIL, parameters);
		
//		return usuario;
		return null;
	}
	
	
	
	public Usuario verificarDadosLogin(String email, String documento, String senha) throws Exception {
		
		Usuario usuario = null;
		
		if(!Utils.isEmpty(email)){
			
			usuario = this.buscarUsuarioPorEmail(email);
			
		}else if(!Utils.isEmpty(documento)){
			
			usuario = this.buscarUsuarioPorDocumento(documento);
			
		}else{
			
			throw new Exception("Informar E-mail ou Documento.");
			
		}
		
		if (usuario != null) {
			
			if(!Utils.convertStringToMd5(senha).equalsIgnoreCase(usuario.getSenha())){
//			if(!senha.equalsIgnoreCase(usuario.getSenha())){
				usuario.setSenha("");
				throw new Exception("Senha não confere.");
			}
			usuario.setSenha("");
			
			return usuario;
			
		}else{
			throw new Exception("Dados do usuário não conferem.");
		}
		
	}

	public void delete(Usuario usuario) {
//        	super.delete(usuario.getId(), Usuario.class);
	}
}
