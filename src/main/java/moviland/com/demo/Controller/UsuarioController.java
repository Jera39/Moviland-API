package moviland.com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import moviland.com.demo.Model.Usuario;
import moviland.com.demo.Service.UsuarioService;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "login";
    }

    @PostMapping("/autentificar")
    private String autentificar(@ModelAttribute("usuario") Usuario usuario, HttpServletResponse response, Model model) {

        Usuario user = usuarioService.confirmarUsuario(usuario.getCorreo(), usuario.getContraseña());
        if (user == null) {
            return "login";
        } else {
            String nombreUsuario = user.getNombre();
            Cookie usernameCookie = new Cookie("nombreUsuario", nombreUsuario);
            usernameCookie.setMaxAge(3600);
            response.addCookie(usernameCookie);
            System.out.println(nombreUsuario);
            model.addAttribute("username", nombreUsuario);
            return "index";

        }
    }

    @GetMapping("/registro")
    private String registro(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "registro";
    }

    @PostMapping("/registroForm")
    private String registroForm(@ModelAttribute("usuario") Usuario usuario) {

        Usuario user = usuarioService.buscarPorCorreo(usuario.getCorreo());
        if (user == null) {
            usuarioService.guardarUsuario(usuario);
            return "login";
        } else {
            return "registro";
        }
    }

    @GetMapping("/cerrarSesion")
    private String cerrarSesiom(Model model, HttpServletResponse response) {
        Cookie cookie = new Cookie("nombreUsuario", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/login";
    }
}
