package geocacheDAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import geocacheEntity.Cache;
import geocacheEntity.Lieu;

public class CacheDAO {
	private static final SessionFactory ourSessionFactory;
public CacheDAO() {
	
}
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
	
public Cache afficherCache(int id) {
   Cache cache = null ;
   	Session session = null;
   	try {
   	 session = getSession();
   cache = session.load(Cache.class, (long) id);
   	System.out.println(cache.getCoordonnees());
   	}
   	catch(Exception exp) {
   		exp.printStackTrace();
   	}
   	
   	finally {
   		if (session != null)
   			session.close();
   	}
   	
   	return cache;
   	
   }
	
	
  public void insererCache(Cache cache) {
	   Session session = null;
	   Transaction tx = null;
	   try {
		   session = getSession();
		   tx=session.beginTransaction();
		   session.save(cache);
		   System.out.println("Cache insérée");
		   tx.commit();
	   }
	   catch (Exception exp) {
		   exp.printStackTrace();
		   if (tx !=null)
			   tx.rollback();
	   }

	   finally {
  		if (session !=null)
  			session.close();
  	}
	   
  }
	
	public void modifierCache(int id, String l){
		Session session = null;
		   Transaction tx = null;
		   Cache cache;
		   try {
			   session = getSession();
			   tx=session.beginTransaction();
			   
			   cache = session.load(Cache.class, (long) id);
			   cache.setEtat(l);
			   System.out.println("Cache mis à jour");
			   tx.commit();
		   }
		   catch (Exception exp) {
			   exp.printStackTrace();
			   if (tx !=null)
				   tx.rollback();
		   }

		   finally {
	   		if (session !=null)
	   			session.close();
	   	}
		   
		
		
	}
	
	public void supprimerCache(int id) {
		
		Session session = null;
		   Transaction tx = null;
		   Cache cache = null;
		   try {
			   session = getSession();
			   tx=session.beginTransaction();
			   cache = this.afficherCache(id);
			   session.remove(cache);
			   System.out.println("Lieu : "+cache.getCoordonnees() +" a été supprimé");
			   tx.commit();
		   }
		   catch (Exception exp) {
			   exp.printStackTrace();
			   if (tx !=null)
				   tx.rollback();
		   }

		   finally {
	   		if (session !=null)
	   			session.close();
	   	}
		   
	   }
		
		
	
	
	
	public List<Cache> afficherCacheslieu (long l) {
		
		List<Cache> caches= new ArrayList<Cache>();
		Transaction tx = null;

		Session session = null; 
		try {
	    	 session = getSession();
	    	 tx = session.beginTransaction();
	    	String qr = " select c from Cache c where c.lieu = "+l;
	    	Query query = session.createQuery(qr);
	    	
	    	caches = query.getResultList();
	    	tx.commit();
			
	    	}
		catch(Exception exp) {
   		exp.printStackTrace();
   		tx.rollback();
   	}
   	
   	finally {
   		if (session !=null)
   			session.close();
   	}
			
		
		
		return  caches;
		
	}

public List<Cache> afficherCachesUtilisateur (long l) {
		
		List<Cache> caches= new ArrayList<Cache>();
		Transaction tx = null;

		Session session = null; 
		try {
	    	 session = getSession();
	    	 tx = session.beginTransaction();
	    	String qr = " select c from Cache c where c.utilisateur = "+l;
	    	Query query = session.createQuery(qr);
	    	
	    	caches = query.getResultList();
	    	tx.commit();
			
	    	}
		catch(Exception exp) {
   		exp.printStackTrace();
   		tx.rollback();
   	}
   	
   	finally {
   		if (session !=null)
   			session.close();
   	}
			
		
		
		return  caches;
		
	}


}
