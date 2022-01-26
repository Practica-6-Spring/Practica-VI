package ifp.aad.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import add.entidad.Company;
import add.entidad.Videojuego;
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
	
	
	//FALTA GET MASIVO Y FILTRO!!!!
	@GetMapping("companies")// -> http://localhost:8080/pokemonSpeed?speed=49 lista todos los pokemons con esa velocidad
	public List<Company> getCompanyByLoc(@RequestParam(value = "videojuego", required = false) String nombre) { //el objeto opcional significa que puede devolver un valor nulo o no
		
		if ( nombre == null) {
			return repositorio.findAll();
		} else {
			return repositorio.findCompanyByLoc(nombre);
		}
	}
	
	@PostMapping("company")
	public Integer addJuego(@RequestBody Company nuevaCompany) {
		Company CompanyGuardada = this.repositorio.save(nuevaCompany);
		return CompanyGuardada.getId();
	}
	
	@DeleteMapping("company/{id}")
	public String borrarCompany(@PathVariable("id") Integer idCompany) {
		
		this.repositorio.deleteById(idCompany);
		return "se ha borrado correctamente";
		
	}
}
