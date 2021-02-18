package geocacheDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import geocacheEntity.Cache;
import geocacheEntity.Visite;

public class VisiteDAO {
	private static final SessionFactory ourSessionFactory;
public VisiteDAO() {
	
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
	
public Visite afficherVisite(int id) {
   Visite visite = null ;
   	Session session = null;
   	try {
   	 session = getSession();
   visite = session.load(Visite.class, (long) id);
  // 	System.out.println(visite.getUtilisateur());
   	}
   	catch(Exception exp) {
   		exp.printStackTrace();
   	}
   	
   	finally {
   		if (session != null)
   			session.close();
   	}
   	
   	return visite;
   	
   }
	
	
  public void insererVisite(Visite cache) {
	   Session session = null;
	   Transaction tx = null;
	   try {
		   session = getSession();
		   tx=session.beginTransaction();
		   session.save(cache);
		   System.out.println("Visite insérée");
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
	
	public void modifierVisite(int id, String l){
		Session session = null;
		   Transaction tx = null;
		   Visite visite;
		   try {
			   session = getSession();
			   tx=session.beginTransaction();
			   
			   visite = session.load(Visite.class, (long) id);
			   visite.setLogCache(l);
			   System.out.println("Visite a ete mise à jour");
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
	
	public void supprimerVisite(int id) {
		
		Session session = null;
		   Transaction tx = null;
		   Visite visite = null;
		   try {
			   session = getSession();
			   tx=session.beginTransaction();
			   visite = this.afficherVisite(id);
			   session.remove(visite);
			   System.out.println("La visite de : "+visite.getUtilisateur() +" a été supprimé");
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
		
		
	
	
	
	public List<Visite> afficherVisites () {
		
		List<Visite> caches= null;
		Session session = null; 
		try {
	    	 session = getSession();
	    	
	    	Query query = session.createQuery("select v from Visite v");
	    	caches = query.getResultList();
	    	}
		catch(Exception exp) {
   		exp.printStackTrace();
   	}
   	
   	finally {
   		if (session !=null)
   			session.close();
   	}
			
		
		
		return  caches;
		
	}

public List<Visite> afficherVisitesDate (String d) {
		
		List<Visite> visites= new ArrayList<Visite>();
		Transaction tx = null;

		Session session = null; 
		try {
	    	 session = getSession();
	    	 tx = session.beginTransaction();
	    	String qr = " select v from Visite v where v.date = '"+d+"'";
	    	Query query = session.createQuery(qr);
	    	
	    	visites = query.getResultList();
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
			
		
		
		return  visites;
		
	}

}
