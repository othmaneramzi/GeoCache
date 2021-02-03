package test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import geocache.Lieu;

public class Test {
	
	private static final SessionFactory ourSessionFactory;

	   static {
	       try {
	           Configuration configuration = new Configuration();
	           configuration.configure("hibernate.cfg.xml");

	           ourSessionFactory = configuration.buildSessionFactory();
	       } catch (Throwable ex) {
	           throw new ExceptionInInitializerError(ex);
	       }
	   }

	   public static Session getSession() throws HibernateException {
	       return ourSessionFactory.openSession();
	   }


	public static void main(String[] args) throws Exception {
		 final Session session = getSession();
		   try {
		Lieu lieu;
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   lieu = new Lieu("Lens");
		   session.save(lieu);
		   System.out.println("Lieu Insérée");

		   tx.commit();
		}
		catch (Exception ex)
		{
		   ex.printStackTrace();

		   if (tx != null)
		   {
		       tx.rollback();
		   }
		   throw ex;
		}
		} finally {
		   session.close();
		   

		}

	}

}
