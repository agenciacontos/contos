package br.com.agenciacontos.dao;
 
import br.com.agenciacontos.model.Ponto;
 
public class PontosDAO extends GenericDAO<Ponto> {
	private static final long serialVersionUID = 1L;

	public PontosDAO() {
        super(Ponto.class);
    }
 
}