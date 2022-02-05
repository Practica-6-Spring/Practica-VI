package ifp.aad.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import add.entidad.Videojuego;


@Repository
public interface RepositorioJuegos extends JpaRepository<Videojuego, Integer> {

	@Query("FROM Videojuego WHERE company.nombre = ?1")
	public List<Videojuego> findByCompany(String nombre);
	
}

