package questJpa.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Context {
	
	private static Context singleton;
	private EntityManagerFactory emf;
	private static DaoFormation daoFormation = new DaoFormationImpl();
	private static DaoModule daoModule = new DaoModuleImpl();
	private static DaoPersonne daoPersonne = new DaoPersonneImpl();
	
	public static DaoFormation getDaoFormation() {
		return daoFormation;
	}
	
	public static DaoModule getDaoModule() {
		return daoModule;
	}
	
	public static DaoPersonne getDaoPersonne() {
		return daoPersonne;
	}
	
	private Context() {
		emf = Persistence.createEntityManagerFactory("questJpa");
	}
	
	public static Context getInstance() {
		if (singleton == null) {
			singleton = new Context();
		}
		return singleton;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
	
	public static void destroy() {
		if(singleton != null) {
			singleton.getEntityManagerFactory().close();
			singleton = null;
		}
	}
	
	

}
