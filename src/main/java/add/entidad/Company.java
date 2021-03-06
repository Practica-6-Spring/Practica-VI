package add.entidad;
// Generated 24 ene. 2022 21:19:42 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Company generated by hbm2java
 */
@Entity
@Table(name = "company", catalog = "videojuegos")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Company implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private String localizacion;
	private Set<Videojuego> videojuegos = new HashSet<Videojuego>(0);

	public Company() {
	}

	public Company(String nombre, String localizacion) {
		this.nombre = nombre;
		this.localizacion = localizacion;
	}

	public Company(String nombre, String localizacion, Set<Videojuego> videojuegos) {
		this.nombre = nombre;
		this.localizacion = localizacion;
		this.videojuegos = videojuegos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false, length = 20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "localizacion", nullable = false, length = 20)
	public String getLocalizacion() {
		return this.localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	@JsonBackReference
	public Set<Videojuego> getVideojuegos() {
		return this.videojuegos;
	}

	public void setVideojuegos(Set<Videojuego> videojuegos) {
		this.videojuegos = videojuegos;
	}

}
