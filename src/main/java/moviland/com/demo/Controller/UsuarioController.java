package moviland.com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import moviland.com.demo.Model.Usuario;
import moviland.com.demo.Service.UsuarioService;

@RestController
@RequestMapping("api/v1/moviland/user")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public Usuario registrarUsuario(@RequestBody Usuario usuario){
        return usuarioService.registrarUsuario(usuario);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Usuario usuario, HttpServletResponse response){
        boolean autenticado = usuarioService.autentificar(usuario.getCorreo(), usuario.getContraseña());

        if (autenticado) {
            
            Cookie cookie = new Cookie("nombreUsuario", usuarioService.usuarioPorCorreo(usuario.getCorreo()).getNombre());
            cookie.setMaxAge(24 * 60 * 60); // Duración en segundos (aquí, 1 día)
            cookie.setPath("/");
            response.addCookie(cookie);
        }

        return autenticado;
    }


    @GetMapping(path = "{correo}")
    public Usuario usuarioPorCorreo(@PathVariable("correo") String correo){
        return usuarioService.usuarioPorCorreo(correo);
    }
 
}
