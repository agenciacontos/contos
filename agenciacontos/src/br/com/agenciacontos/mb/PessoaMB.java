package br.com.agenciacontos.mb;


import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class PessoaMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

}