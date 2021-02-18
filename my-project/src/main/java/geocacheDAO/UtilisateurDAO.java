package geocacheDAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import geocacheEntity.Utilisateur;

public class UtilisateurDAO {
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
	
	public UtilisateurDAO() {
		
	}
	
	public Utilisateur afficherUser(int id) {
    	Utilisateur user = null ;
    	Session session = null;
    	try {
    	 session = getSession();
    	user = session.load(Utilisateur.class, (long) id);
    	System.out.println(user.getNom());
    	}
    	catch(Exception exp) {
    		exp.printStackTrace();
    	}
    	
    	finally {
    		if (session != null)
    			session.close();
    	}
    	
    	return user;
    	
    }
	
	
   public void insererUser(Utilisateur user) {
	   Session session = null;
	   Transaction tx = null;
	   try {
		   session = getSession();
		   tx=session.beginTransaction();
		   session.save(user);
		   System.out.println("Un utilsateur a été inséré");
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
	
	public void modifierUser(int id, String l){
		Session session = null;
		   Transaction tx = null;
		  Utilisateur user;
		   try {
			   session = getSession();
			   tx=session.beginTransaction();
			   
			   user = session.load(Utilisateur.class, (long) id);
			   user.setPseudo(l);;
			   System.out.println("Pseudo a été mis à jour");
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
	
	public void supprimerUser(int id) {
		
		Session session = null;
		   Transaction tx = null;
		   Utilisateur user = null;
		   try {
			   session = getSession();
			   tx=session.beginTransaction();
			   user = this.afficherUser(id);
			   session.remove(user);
			   System.out.println("Utilsateur : "+user.getNom() +" a été supprimé");
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
		
		
	
	
	
	public List<Utilisateur> afficherTousLesUsers() {
		
		List<Utilisateur> lieux= null;
		Transaction tx = null;
		
		Session session = null; 
		try {
			
	    	 session = getSession();
	    	 tx= session.beginTransaction();
	    	Query query = session.createQuery("select u from Utilisateur  u");
	    	lieux = query.getResultList();
	    	tx.commit();
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



