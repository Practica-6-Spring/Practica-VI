package ifp.aad.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import add.entidad.Company;
import add.entidad.Videojuego;
import exceptions.ExceptionCompany;
import ifp.aad.repositorio.RepositorioCompany;

@RestController
public class CompanyController {
	@Autowired
	RepositorioCompany repositorio;
	

	//GET con filtro id 
	@GetMapping("company/{id}") // -> http://localhost:8080/company/1 los valores variables (path param, se representan con llaves)
	public Optional<Company> obtenerCompany(@PathVariable("id") Integer id) { //el objeto opcional significa que puede devolver un valor nulo o no
		return repositorio.findById(id);
	}
	
	
	//GET Masivo y búsqueda por localizacion
	//MODIFICAR PARA QUE SEA POR JUEGOS
	@GetMapping("companies")// -> http://localhost:8080/companies?localizacion=USA
	public List<Company> getCompanyByLoc(@RequestParam(value = "localizacion", required = false) String nombre) { //el objeto opcional significa que puede devolver un valor nulo o no
		
		if ( nombre == null) {
			return repositorio.findAll();
		} else {
			return repositorio.findCompanyByLoc(nombre);
		}
	}
	
	
	
	//POST añadir nueva compañia
	@PostMapping("company")
	public Integer addJuego(@RequestBody Company nuevaCompany) {
		Company CompanyGuardada = this.repositorio.save(nuevaCompany);
		return CompanyGuardada.getId();
	}
	
	@DeleteMapping("company/{id}")
    public ResponseEntity<ExceptionCompany> borrarCompany(@PathVariable("id") Integer idCompany) {
        Optional<Company> companyBorrada = this.repositorio.findById(idCompany);
        if (companyBorrada.isEmpty()) {
            return new ResponseEntity<ExceptionCompany>(new ExceptionCompany("Error: el juego no existe", idCompany),
                    HttpStatus.NOT_FOUND);
        } else {
            this.repositorio.deleteById(idCompany);
              return new ResponseEntity<ExceptionCompany>(new ExceptionCompany("El juego se ha borrado", idCompany),
                      HttpStatus.OK);
        }

    }
}
