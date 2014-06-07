package br.com.agenciacontos.dao;
 
import br.com.agenciacontos.model.Ponto;
 
public class PontosGeradosDAO extends GenericDAO<Ponto> {
	private static final long serialVersionUID = 1L;

	public PontosGeradosDAO() {
        super(Ponto.class);
    }
 
}