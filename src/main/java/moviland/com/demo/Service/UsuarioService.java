package moviland.com.demo.Service;

import org.springframework.stereotype.Service;

import moviland.com.demo.Model.Usuario;
import moviland.com.demo.Repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public boolean autentificar(String coreo, String contraseña){
        if (usuarioRepository.findByCorreoAndContraseña(coreo, contraseña).isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public Usuario registrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario usuarioPorCorreo(String correo){
        return usuarioRepository.findByCorreo(correo);
    }
}
