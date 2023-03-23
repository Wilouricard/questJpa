package questJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import questJpa.entities.Personne;

public class DaoPersonneImpl implements DaoPersonne {

	@Override
	public Personne save(Personne obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Personne obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Personne.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Personne findByKey(Long key) {
		Personne personne = null;
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		personne = em.find(Personne.class, key);
		em.close();
		return personne;
	}

	@Override
	public List<Personne> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne p", Personne.class);
		List<Personne> personnes = query.getResultList();
		em.close();
		return personnes;
	}

}
