package br.com.agenciacontos.facade;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class UsuarioLojaFacade extends AbstractFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
}