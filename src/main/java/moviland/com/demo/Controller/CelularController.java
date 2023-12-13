package moviland.com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import moviland.com.demo.Model.Celular;
import moviland.com.demo.Service.CelularService;

@Controller
public class CelularController {
    @Autowired
    private CelularService celularService;

    @GetMapping("/")
    public String presentacion(Model model, @CookieValue(name = "nombreUsuario", required = false) String username) {
        System.out.println(username);
        if (username != null) {
            model.addAttribute("username", username);
        } else {
            model.addAttribute("username", null);
        }
        return "index"; // Retorna la vista "index"
    }

    @GetMapping("/catalogo")
    public String verCelulares(Model model, @CookieValue(name = "nombreUsuario", required = false) String username) {
        model.addAttribute("listaCelular", celularService.getCelulares());
        if (username != null) {
            model.addAttribute("username", username);
        } else {
            model.addAttribute("username", null);
        }
        return "catalogo";
    }

    @GetMapping("/registroCelularForm")
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

    @PostMapping("guardarCelular")
    public String guardarCelular(@ModelAttribute("Celular") Celular celular,
            @CookieValue(name = "nombreUsuario", required = false) String username, Model model) {
        if (username != null) {
            model.addAttribute("username", username);
        } else {
            model.addAttribute("username", null);
        }
        celular.setEstado(true);
        celularService.nuevoCelular(celular);

        return "redirect:/catalogo";
    }

    @GetMapping("/actualizarCelular/{id}")
    public String actualizarCelular(@PathVariable(value = "id") int id, Model modelo,
            @CookieValue(name = "nombreUsuario", required = false) String username, Model model) {
        if (username != null) {
            model.addAttribute("username", username);
        } else {
            model.addAttribute("username", null);
        }

        Celular celular = celularService.buscarCelular(id);
        modelo.addAttribute("Celular", celular);
        return "actualizarCatalogo";
    }

    @GetMapping("/desabilitarCelular/{id}")
    public String desabilitarCelular(@PathVariable(value = "id") int id,
            @CookieValue(name = "nombreUsuario", required = false) String username, Model model) {
        if (username != null) {
            model.addAttribute("username", username);
        } else {
            model.addAttribute("username", null);
        }
        this.celularService.desabilitarCelular(id, false);
        return "redirect:/catalogo";
    }

}
