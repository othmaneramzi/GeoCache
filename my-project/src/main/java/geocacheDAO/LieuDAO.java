package geocacheDAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import geocacheEntity.Lieu;




public class LieuDAO {

private static final SessionFactory ourSessionFactory;


 public LieuDAO () {
	 
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
	
public Lieu afficherLieu(int id) {
    	Lieu lieu = null ;
    	Session session = null;
    	try {
    	 session = getSession();
    	lieu = session.load(Lieu.class, (long) id);
    	System.out.println(lieu.getNomLieu());
    	}
    	catch(Exception exp) {
    		exp.printStackTrace();
    	}
    	
    	finally {
    		if (session != null)
    			session.close();
    	}
    	
    	return lieu;
    	
    }
	
	
   public void insererLieu(Lieu lieu) {
	   Session session = null;
	   Transaction tx = null;
	   try {
		   session = getSession();
		   tx=session.beginTransaction();
		   session.save(lieu);
		   System.out.println("Lieu insérée");
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
	
	public void modifierLieu(int id, String l){
		Session session = null;
		   Transaction tx = null;
		   Lieu lieu;
		   try {
			   session = getSession();
			   tx=session.beginTransaction();
			   
			   lieu = session.load(Lieu.class, (long) id);
			   lieu.setNomLieu(l);
			   System.out.println("Lieu mis à jour");
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
	
	public void supprimerLieu(int id) {
		
		Session session = null;
		   Transaction tx = null;
		   Lieu lieu = null;
		   try {
			   session = getSession();
			   tx=session.beginTransaction();
			   lieu = this.afficherLieu(id);
			   session.remove(lieu);
			   System.out.println("Lieu : "+lieu.getNomLieu() +" a été supprimé");
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
		
		
	
	
	
	public List<Lieu> afficherTousLeslieux () {
		
		List<Lieu> lieux= null;
		Session session = null; 
		try {
	    	 session = getSession();
	    	
	    	Query query = session.createQuery("select l from Lieu l");
	    	lieux = query.getResultList();
	    	
	    	}
		catch(Exception exp) {
    		exp.printStackTrace();
    	}
    	
    	finally {
    		if (session !=null)
    			session.close();
    	}
			
		return  lieux;
		
	}

}
