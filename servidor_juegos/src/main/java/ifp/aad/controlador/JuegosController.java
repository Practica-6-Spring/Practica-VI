package ifp.aad.controlador;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exceptions.Exception;

import add.entidad.Plataforma;
import add.entidad.Videojuego;
import ifp.aad.repositorio.RepositorioJuegos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
public class JuegosController {
	@Autowired
	RepositorioJuegos repositorio;
	
	//GET con filtro id 
	@GetMapping("juegos/{id}") // -> http://localhost:8080/juegos/5 los valores variables (path param, se representan con llaves)
	public Optional<Videojuego> obtenerJuego(@PathVariable("id") Integer id) { //el objeto opcional significa que puede devolver un valor nulo o no
		
		return repositorio.findById(id);
	}
	
	//GET Masivo y filtrado por company
	@GetMapping("juegos")// -> http://localhost:8080/juegos?Company=Nintendo
	public List<Videojuego> getJuegoCompany(@RequestParam(value = "Company", required = false) String nombre) { //el objeto opcional significa que puede devolver un valor nulo o no
		
		if ( nombre == null) {
			return repositorio.findAll();
		} else {
			return repositorio.findByCompany(nombre);
		}
	}
	
	//POST Nuevo juego
	@PostMapping("juegos")
	public Integer addJuego(@RequestBody Videojuego nuevoJuego) {
		
		Videojuego juegoGuardado = this.repositorio.save(nuevoJuego);
		
		return juegoGuardado.getId();
	}
	
	@DeleteMapping("juegos/{id}")
	//para controlar la excepcion que salta cuando el id no existe
	public ResponseEntity<Exception> borrarJuego(@PathVariable("id") Integer idJuego) {
		Optional<Videojuego> VideojuegoBorrar = this.repositorio.findById(idJuego);
		if (VideojuegoBorrar.isEmpty()) {
            return new ResponseEntity<Exception>(new Exception("Error: el juego no existe", idJuego),
                    HttpStatus.NOT_FOUND);
        } else {
    		this.repositorio.deleteById(idJuego);
    		  return new ResponseEntity<Exception>(new Exception("El juego se ha borrado", idJuego),
                      HttpStatus.OK);
        }
		
	}
	
	
	@PutMapping("juegos/{id}")
	public String modificarjuego(@PathVariable("id")Integer idJuego, @RequestBody Videojuego nuevoJuego) {
		
	
		Optional<Videojuego> viejo = repositorio.findById(idJuego);
		if(viejo.isEmpty()) return "Este juego no existe";
		else {
			Videojuego juegoViejo = viejo.get();
			nuevoJuego.setId(idJuego);
			nuevoJuego.setPlataformas(juegoViejo.getPlataformas());
			this.repositorio.save(nuevoJuego);
			return "se ha guardado";
		}
}
}
