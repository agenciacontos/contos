package br.com.agenciacontos.producer;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.agenciacontos.qualifier.EntityManagerBancoXQualifier;

@RequestScoped
public class EntityManagerProducer {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContosPU");
	
	//Era para fazer com o @PersistenceContext(unitName = "ContosPU") Mas ele não instanciou
//	private @PersistenceContext(unitName = "ContosPU")
	private EntityManager entityManager;

	public EntityManagerProducer() {
	}

	@Produces
	@RequestScoped
	@EntityManagerBancoXQualifier
	public EntityManager createEntityManager() {
		if(entityManager == null)
			entityManager = emf.createEntityManager();
		
		return entityManager;
	}

	public void dispose(
			@Disposes @EntityManagerBancoXQualifier EntityManager entityManager) {
		System.out.println("EntityManager fechado");
		entityManager.close();
	}
}
