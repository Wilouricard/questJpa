package questJpa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityTransaction;

import questJpa.dao.Context;
import questJpa.dao.DaoFormation;
import questJpa.dao.DaoModule;
import questJpa.dao.DaoPersonne;
import questJpa.entities.Formation;
import questJpa.entities.Personne;
import questJpa.entities.Module;

public class AppTest {

	public static void main(String[] args) {
		
		// Création du contexte JPA
		Context context = Context.getInstance();
		
		// Récupération des DAOs
		DaoFormation daoFormation = Context.getDaoFormation();
		DaoModule daoModule = Context.getDaoModule();
		DaoPersonne daoPersonne = Context.getDaoPersonne();
		
		// Création des objets à persister
		Formation formation1 = new Formation("JPA", LocalDate.of(1998, 01, 01));
		Formation formation2 = new Formation("Formation 2", LocalDate.of(2012, 12, 19));
		Module module1 = new Module("Module 1", 10L);
		Module module2 = new Module("Module 2", 20L);
		Personne personne1 = new Personne("John","Doe");
		Personne personne2 = new Personne("Jane","Doe");
		
		// Enregistrement des objets
		EntityTransaction tx = null;
		try {
			tx = context.getEntityManagerFactory().createEntityManager().getTransaction();
			tx.begin();
			
			daoFormation.save(formation1);
			daoFormation.save(formation2);
			
			daoModule.save(module1);
			daoModule.save(module2);
			
			daoPersonne.save(personne1);
			daoPersonne.save(personne2);
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
		// Lecture des objets
		try {
			List<Formation> formations = daoFormation.findAll();
			List<Module> modules = daoModule.findAll();
			List<Personne> personnes = daoPersonne.findAll();
			
			System.out.println("Formations : " + formations);
			System.out.println("Modules : " + modules);
			System.out.println("Personnes : " + personnes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Fermeture du contexte JPA
		Context.destroy();

	}

}