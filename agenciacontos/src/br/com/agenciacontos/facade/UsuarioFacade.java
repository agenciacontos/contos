package br.com.agenciacontos.facade;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.agenciacontos.dao.UsuarioDAO;
import br.com.agenciacontos.enums.DocumentoTipoEnum;
import br.com.agenciacontos.enums.UsuarioTipoEnum;
import br.com.agenciacontos.model.Usuario;

public class UsuarioFacade extends AbstractFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject private UsuarioDAO usuarioDAO;
	@Inject private PessoaFacade pessoaFacade;
	
	public Usuario verificarDadosLogin(String email, String documento, String senha) throws Exception {
		
		Usuario usuario = usuarioDAO.verificarDadosLogin(email, documento, senha);
		
		return usuario;
	}	
	
	public void cadastrarUsuario(DocumentoTipoEnum documentoTipo, String documento, String nome, String email, String senha) throws Exception {
		
		//TODO Verificar se email ou documento ja existe
//		if(usuarioDAO.buscarUsuarioPorEmail(usuario.getEmail()) != null){
//			throw new Exception("O e-mail utilizado ja consta na base de dados.");
//		}
//		if(usuarioDAO.buscarUsuarioPorDocumento(usuario.getDocumento()) != null){
//			throw new Exception("O documento utilizado ja consta na base de dados.");
//		}
		
		// Cadastrar Pessoa 
		// TODO tirar isso daqui e colocar para cadastrar a pessoa lá dentro de usuário e tirar de onde esta agora em pessoa tb
		pessoaFacade.cadastrarPessoa(documentoTipo, documento, nome, email);
		
		//Cadastrar usuario
		Usuario usuario = new Usuario();
		usuario.setUsuarioTipo(UsuarioTipoEnum.CLIENTE.getCodigo());
		
	}

}