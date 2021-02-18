package geocacheEntity;
import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idUtilisateur")
	private Long idUtilisateur;
	@Column(nullable = false, length = 20 , name = "pseudo")
	private String pseudo;
	@Column(nullable = false, length = 20 , name = "nom")
	private String nom;
	@Column(nullable = false, length = 20 , name = "description")
	private String description;
	@Column(nullable = false, length = 20 , name = "type")
	private String type;
	
	
	
	public Utilisateur() {
		
	}
	


	public Utilisateur(String pseudo, String nom, String description, String type) {
		
		this.pseudo = pseudo;
		this.nom = nom;
		this.description = description;
		this.type = type;
	}



	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", description="
				+ description + ", type=" + type + "]";
	}
	
	
	
	

}
