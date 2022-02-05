package ifp.aad.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import add.entidad.Genero;

@Repository
public interface RepositorioGenero extends JpaRepository<Genero, Integer>{

}
