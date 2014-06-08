package br.com.contos.facade;

import br.com.contos.model.Usuario;

public class UsuarioFacade {
	
//	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	public Usuario verificarDadosLogin(String email, String documento, String senha) {
		/*
		usuarioDAO.beginTransaction();
		Usuario usuario = usuarioDAO.findUserByEmail(email);

		if (usuario == null || !usuario.getPassword().equals(password)) {
			return null;
		}
		*/
		
		return new Usuario();
	}

	
}