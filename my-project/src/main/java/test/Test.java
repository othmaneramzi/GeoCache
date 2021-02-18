package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import geocacheDAO.LieuDAO;
import geocacheDAO.UtilisateurDAO;
import geocacheDAO.*;
import geocacheEntity.*;

public class Test {
	
	

	public static void main(String[] args) throws Exception {
		
		
		
		LieuDAO ld = new LieuDAO();
		CacheDAO cd = new CacheDAO();
		Utilisateur user = new Utilisateur();
		UtilisateurDAO ud = new UtilisateurDAO();
		VisiteDAO vd = new VisiteDAO();
		//Date date =null ;
		List<Visite> v = new ArrayList<Visite>();
		//DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//date= sdf.parse("2020-01-20 11:00:00");
		String date = "2020-01-20 11:00:00";
		v = vd.afficherVisitesDate(date);
		
		for (Visite visite:v) {
			
			 System.out.println(visite.toString());
		}
		
		//ud.insererUser(user);
		//DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		//Date date =null ;
        //date= sdf.parse("20-01-2020 11:00");
        //Cache cache =new Cache();
        //cache = cd.afficherCache(1);

        //Visite visite = new Visite(date,"cache pierres trouvé","pas de commentaire",cache,user);
        //vd.insererVisite(visite);
          
		
		
        //Visite v = new Visite();
        //v = vd.afficherVisite(1);
        //System.out.println(v);
        //ud.insererUser(user);
        //ld.insererLieu(lieu);		
		//List<Utilisateur> users=new ArrayList<Utilisateur>() ;
		
	//	users= ud.afficherTousLesUsers();
		/*user.setPseudo("IGLeglaz");
		user.setNom("Isabelle Le Glaz");
		user.setType("visiteur");
		user.setDescription("enseignante");
		
		
		
		ud.insererUser(user);*/
		//for (int i =0; i<users.size();i++) {
		//	System.out.println("id user :"+user.getIdUtilisateur());
		//	System.out.println("nom user : "+user.getNom());
		//	System.out.println("pseudo : "+user.getPseudo());
		//}
		//ud.supprimerUser(2);
		
		/*
		
		System.out.println("id user :"+user.getIdUtilisateur());
		System.out.println("nom user : "+user.getNom());
		System.out.println("pseudo : "+user.getPseudo());*/
		

					
		}}
		
		 
		

	

