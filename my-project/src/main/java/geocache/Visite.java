package geocache;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name ="visite")
public class Visite implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idVisite")
	private Long idVisite;
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(nullable = false,name="nomLieu")
	private Date date;
	@Column(nullable = true, length = 20 , name = "logCache")
	private String logCache;
	@Column(nullable = true, length = 20 , name = "commentaire")
	private String commentaire;
	@OneToOne 
	@JoinColumn (name = "cacheID" )
	private Cache cache;
	@ManyToOne 
	@JoinColumn(name = "utilsateurId")
	private Utilisateur utilisateur;
	
	
	
	
	public Visite() {
		
	}


	public Visite(Date date, String logCache, String commentaire, Cache cache, Utilisateur utilisateur) {
		
		
		this.date = date;
		this.logCache = logCache;
		this.commentaire = commentaire;
		this.cache = cache;
		this.utilisateur = utilisateur;
	}


	public Long getIdVisite() {
		return idVisite;
	}


	public void setIdVisite(Long idVisite) {
		this.idVisite = idVisite;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getLogCache() {
		return logCache;
	}


	public void setLogCache(String logCache) {
		this.logCache = logCache;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public Cache getCache() {
		return cache;
	}


	public void setCache(Cache cache) {
		this.cache = cache;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
	
	

}
