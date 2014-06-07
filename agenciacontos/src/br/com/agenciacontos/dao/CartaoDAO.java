package br.com.agenciacontos.dao;
 
import br.com.agenciacontos.model.CartaoPontos;
 
public class CartaoDAO extends GenericDAO<CartaoPontos> {
	private static final long serialVersionUID = 1L;

	public CartaoDAO() {
        super(CartaoPontos.class);
    }
 
}