package br.com.agenciacontos.dao;
 
import br.com.agenciacontos.model.PontosGerados;
 
public class PontosDAO extends GenericDAO<PontosGerados> {
	private static final long serialVersionUID = 1L;

	public PontosDAO() {
        super(PontosGerados.class);
    }
 
}