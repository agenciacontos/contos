package br.com.agenciacontos.seguranca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.agenciacontos.enums.UsuarioTipoEnum;
import br.com.agenciacontos.model.Loja;
import br.com.agenciacontos.model.Usuario;

@Named
@SessionScoped
public class ControleAcesso implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<Acesso> acessos;
	private Usuario usuarioAtual;
	private Loja lojaAtual;
	
	public boolean verificaAcesso(Acesso acesso) throws Exception {
		if(acessos != null && acessos.contains(acesso)){
			return true;
		}else{
			throw new Exception("Sem permissão para esta funcionalidade.");
		}
	}
	
	public void gravaUsuarioLogado(Usuario usuario){
		
		this.setUsuarioAtual(usuario);
		
	}
	
	public void gravaLojaLogado(Loja loja){
		
		this.setLojaAtual(loja);
		
	}
	
	public void logout(){
		this.acessos = null;
		this.setUsuarioAtual(null);
		this.setLojaAtual(null);
	}
	
	/**
	 * Carregando estático, posteriormente da para fazer pegar de qualquer lugar
	 * */
	public void carregaAcessosPreDefinidosUsuario(Usuario usuario){
		
		acessos = new ArrayList<Acesso>();
		if(usuario.getTipo().equals(UsuarioTipoEnum.ADMIN.getCodigo())){

			acessos.add(Acesso.CADASTRAR_USUARIO);
			acessos.add(Acesso.LISTAR_USUARIOS);
			
		}else if(usuario.getTipo().equals(UsuarioTipoEnum.CLIENTE.getCodigo())){

			acessos.add(Acesso.CADASTRAR_USUARIO);
			acessos.add(Acesso.LISTAR_USUARIOS);
		
		}else if(usuario.getTipo().equals(UsuarioTipoEnum.VENDEDOR.getCodigo())){

			acessos.add(Acesso.CADASTRAR_USUARIO);
			acessos.add(Acesso.LISTAR_USUARIOS);
			
		}
		
	}
	 
	public boolean isUsuarioLogado(){
		return (this.acessos != null);
	}
	
	public List<Acesso> getAcessos(){
		return this.acessos;
	}

	public Usuario getUsuarioAtual() {
		return usuarioAtual;
	}

	public void setUsuarioAtual(Usuario usuarioAtual) {
		this.usuarioAtual = usuarioAtual;
	}

	public Loja getLojaAtual() {
		return lojaAtual;
	}

	public void setLojaAtual(Loja lojaAtual) {
		this.lojaAtual = lojaAtual;
	}

}