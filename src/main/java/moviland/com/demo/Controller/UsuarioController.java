package moviland.com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public boolean login(@RequestBody Usuario usuario){
        return usuarioService.autentificar(usuario.getCorreo(),usuario.getContraseña());
    }

    @GetMapping(path = "{correo}")
    public Usuario usuarioPorCorreo(@PathVariable("correo") String correo){
        return usuarioService.usuarioPorCorreo(correo);
    }
 
}
