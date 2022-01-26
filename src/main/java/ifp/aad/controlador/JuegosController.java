package ifp.aad.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import add.entidad.Videojuego;
import ifp.aad.repositorio.RepositorioJuegos;

@RestController
public class JuegosController {
	@Autowired
	RepositorioJuegos repositorio;
	

	//GET con filtro id 
	@GetMapping("juegos/{id}") // -> http://localhost:8080/juegos/5 los valores variables (path param, se representan con llaves)
	public Optional<Videojuego> obtenerJuego(@PathVariable("id") Integer id) { //el objeto opcional significa que puede devolver un valor nulo o no
		return repositorio.findById(id);
	}
	
	@GetMapping("juegos")// -> http://localhost:8080/pokemonSpeed?speed=49 lista todos los pokemons con esa velocidad
	public List<Videojuego> getJuegoCompany(@RequestParam(value = "Company", required = false) String nombre) { //el objeto opcional significa que puede devolver un valor nulo o no
		
		if ( nombre == null) {
			return repositorio.findAll();
		} else {
			return repositorio.findByCompany(nombre);
		}
	}
	
	@PostMapping("juegos")
	public Integer addJuego(@RequestBody Videojuego nuevoJuego) {
		Videojuego juegoGuardado = this.repositorio.save(nuevoJuego);
		return juegoGuardado.getId();
	}
	
	@DeleteMapping("juegos/{id}")
	public String borrarJuego(@PathVariable("id") Integer idJuego) {
		
		this.repositorio.deleteById(idJuego);
		return "se ha borrado correctamente";
		
	}
	
	@PutMapping("juegos/{id}")
	public String modificarjuego(@PathVariable("id")Integer idJuego, @RequestBody Videojuego nuevoJuego) {
		
	
		Optional<Videojuego> viejo = repositorio.findById(idJuego);
		if(viejo.isEmpty()) return "Este juego no existe";
		else {
			Videojuego juegoViejo = viejo.get();
			nuevoJuego.setId(idJuego);
			this.repositorio.save(nuevoJuego);
			return "se ha guardado";
		}
}
}
