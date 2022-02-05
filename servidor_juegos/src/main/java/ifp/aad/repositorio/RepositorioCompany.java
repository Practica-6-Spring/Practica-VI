package ifp.aad.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import add.entidad.Company;



@Repository
public interface RepositorioCompany extends JpaRepository<Company, Integer> {

	@Query("FROM Company WHERE localizacion like %?1%")
	public List<Company> findCompanyByLoc(String nombre);
}
