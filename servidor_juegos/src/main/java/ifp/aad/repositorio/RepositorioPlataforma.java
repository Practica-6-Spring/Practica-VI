package ifp.aad.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import add.entidad.Plataforma;

@Repository
public interface RepositorioPlataforma extends JpaRepository<Plataforma, Integer>{


}
