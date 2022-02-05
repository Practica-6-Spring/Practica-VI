package ifp.aad.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import add.entidad.Genero;
import add.entidad.Videojuego;
import ifp.aad.repositorio.RepositorioGenero;
import ifp.aad.repositorio.RepositorioJuegos;

@RestController
public class GeneroController {
	@Autowired
	RepositorioGenero repositorio;
		
	//GET con filtro id 
	@GetMapping("generos") // -> http://localhost:8080/generos los valores variables (path param, se representan con llaves)
	public List<Genero> obtenerGeneros() { //el objeto opcional significa que puede devolver un valor nulo o no
		return repositorio.findAll();
	}
}
