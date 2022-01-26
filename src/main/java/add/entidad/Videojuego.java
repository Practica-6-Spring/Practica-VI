package add.entidad;
// Generated 24 ene. 2022 21:19:42 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Videojuego generated by hbm2java
 */
@Entity
@Table(name = "videojuego", catalog = "videojuegos")
public class Videojuego implements java.io.Serializable {

	private Integer id;
	private Company company;
	private String titulo;
	private double precio;
	private Set<Plataforma> plataformas = new HashSet<Plataforma>(0);
	private Set<Genero> generos = new HashSet<Genero>(0);

	public Videojuego() {
	}

	public Videojuego(Company company, String titulo, double precio) {
		this.company = company;
		this.titulo = titulo;
		this.precio = precio;
	}

	public Videojuego(Company company, String titulo, double precio, Set<Plataforma> plataformas, Set<Genero> generos) {
		this.company = company;
		this.titulo = titulo;
		this.precio = precio;
		this.plataformas = plataformas;
		this.generos = generos;
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

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "company", nullable = false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Column(name = "titulo", nullable = false, length = 30)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "precio", nullable = false, precision = 22, scale = 0)
	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "videojuegos", cascade = CascadeType.MERGE)
	
	public Set<Plataforma> getPlataformas() {
		return this.plataformas;
	}

	public void setPlataformas(Set<Plataforma> plataformas) {
		this.plataformas = plataformas;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "videojuegos", cascade = CascadeType.MERGE)
	public Set<Genero> getGeneros() {
		return this.generos;
	}

	public void setGeneros(Set<Genero> generos) {
		this.generos = generos;
	}

}
