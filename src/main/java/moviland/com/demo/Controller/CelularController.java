package moviland.com.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import moviland.com.demo.Model.Celular;
import moviland.com.demo.Service.CelularService;

@Controller
@RequestMapping("api/v1/moviland")
public class CelularController {
    private final CelularService celularService;

    public CelularController(CelularService celularService) {
		this.celularService = celularService;
	} 

    
    @GetMapping
    public List<Celular> getListarCelulars() {
        return this.celularService.getCelulars();
    }

    public String registrarCelularForm(Model model,
            @CookieValue(name = "nombreUsuario", required = false) String username) {
        Celular celular = new Celular();
        model.addAttribute("Celular", celular);
        if (username != null) {
            model.addAttribute("username", username);
        } else {
            model.addAttribute("username", null);
        }
        return "nuevoCelular";
    }

    @PostMapping
	public ResponseEntity<Object> guardarCelular(@RequestBody Celular celular){
		return this.celularService.nuevoCelular(celular);
	}
	@PostMapping
	public ResponseEntity<Object> actualizarCelular(@RequestBody Celular celular){
		return this.celularService.nuevoCelular(celular);
	}

    @DeleteMapping(path = "{celularId}")
    public ResponseEntity<Object> eliminarCelular(@PathVariable("productId") Integer id){
		return this.celularService.desabilitarCelular(id);
	}
   
}
