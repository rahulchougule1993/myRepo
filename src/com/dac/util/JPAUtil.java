package com.dac.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	static EntityManager em;
	public static EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		if(em==null){
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentity");
			em = emf.createEntityManager();
		}
		return em;
	}
	public static void closeEntityManager(){
		em.close();
	}
	public static void beginTransaction() {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		
	}
	public static void commitTransaction() {
		// TODO Auto-generated method stub
		em.getTransaction().commit();
	}

}
