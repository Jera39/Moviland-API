package moviland.com.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import moviland.com.demo.Model.Celular;
import moviland.com.demo.Service.CelularService;

@RestController
@RequestMapping("api/v1/moviland/celular")
public class CelularController {
	@Autowired
    private final CelularService celularService;

    public CelularController(CelularService celularService) {
		this.celularService = celularService;
	} 

    
    @GetMapping
    public List<Celular> getListarCelulars() {
        return this.celularService.getCelulars();
    }

    @GetMapping(path = "/marca/{marca}")
    public List<Celular> getListarCelularsPorMarca(@PathVariable("marca") String marca) {
        return this.celularService.getCelularsPorMarca(marca);
    }


    @PostMapping
	public Celular guardarCelular(@RequestBody Celular celular){
		return celularService.nuevoCelular(celular);
	}

	@GetMapping(path = "/{id}")

    public Optional<Celular> obtenerJoyaPorId(@PathVariable("id") Integer id) {
        return this.celularService.obtenerPorId(id);
    }

	@PutMapping
	public Celular actualizarCelular(@RequestBody Celular celular){
		return this.celularService.nuevoCelular(celular);
	}

    @DeleteMapping(path = "{celularId}")
    public String eliminarCelular(@PathVariable("celularId") Integer id){
		boolean ok = this.celularService.desabilitarCelular(id);
        if (ok) {
            return "Se eliminó el celular con id: " + id;
        } else {
            return "No se pudo eliminar el celular con id: " + id;
        }
	}
   
}
