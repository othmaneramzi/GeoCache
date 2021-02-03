package geocache;
import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ValueGenerationType;


@SuppressWarnings("serial")
@Entity
@Table(name = "lieu")
public class Lieu implements Serializable {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="idLieu")
	private Long idLieu;
	@Column(nullable = false, length = 20,name="nomLieu")
	private String nomLieu;
	
	public Lieu( String nomLieu) {
		
		
		this.nomLieu = nomLieu;
	}
	
	public Lieu() {
		
	}
	
	public Long getIdLieu() {
		return idLieu;
	}
	public void setIdLieu(Long idLieu) {
		this.idLieu = idLieu;
	}
	public String getNomLieu() {
		return nomLieu;
	}
	public void setNomLieu(String nomLieu) {
		this.nomLieu = nomLieu;
	}
	
	
	

	
	
}
