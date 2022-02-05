package ifp.aad.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import add.entidad.Genero;
import add.entidad.Plataforma;
import ifp.aad.repositorio.RepositorioGenero;
import ifp.aad.repositorio.RepositorioPlataforma;

@RestController
public class PlataformaController {
	@Autowired
	RepositorioPlataforma repositorio;
		
	//GET con filtro id 
	@GetMapping("plataformas") // -> http://localhost:8080/plataformas 
	public List<Plataforma> obtenerPlataformas() { 
		return repositorio.findAll();
	}
}
