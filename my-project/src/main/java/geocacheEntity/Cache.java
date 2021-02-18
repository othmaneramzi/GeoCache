package geocacheEntity;
import java.io.Serializable;

import javax.persistence.*;
import dev.morphia.*;

@SuppressWarnings("serial")
@Entity
@NamedQuery(name="Cache.findCachesparLieu" ,query="select c from Cache c where c.lieu = :l ")
@NamedQuery(name="Cache.findCachesparUtilsateur", query=" from Cache c where c.utilisateur = :utilsateur ")
@Table(name = "cache")
public class Cache  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCache")
	private Long idCache;
	@Column(nullable = false, length = 20,name="coordonnees")
	private String coordonnees;
	@Column(nullable = false, length = 255 ,name="description")
	private String description;
	@Column(nullable = false, length = 20,name="type")
	private String type;
	@Column(nullable = false, length = 20,name="nature")
	private String nature;
	@Column(nullable = false, length = 20,name="etat")
	private String etat;
	@ManyToOne 
	@JoinColumn(name = "lieuId")	
	private Lieu lieu;	
	@ManyToOne
	@JoinColumn(name = "idUser")
	private Utilisateur utilisateur;
	
	public Cache() {
		
	}
	
	
	
	public Cache( String coordonnees, String description, String type, String nature, String etat , Lieu lieu, Utilisateur utilisateur) {
		
		this.coordonnees = coordonnees;
		this.description = description;
		this.type = type;
		this.nature = nature;
		this.etat = etat;
		this.lieu = lieu;
		this.utilisateur = utilisateur;
	}



	public Long getIdCache() {
		return idCache;
	}
	public void setIdCache(Long idCache) {
		this.idCache = idCache;
	}
	public String getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(String coordonnees) {
		this.coordonnees = coordonnees;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Cache [idCache=" + idCache + ", coordonnees=" + coordonnees + ", description=" + description + ", type="
				+ type + ", nature=" + nature + ", etat=" + etat + ", lieu=" + lieu.getNomLieu() + ", utilisateur=" + utilisateur.getNom()
				+ "]";
	}



	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}



	public Lieu getLieu() {
		return lieu;
	}



	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
	

}
