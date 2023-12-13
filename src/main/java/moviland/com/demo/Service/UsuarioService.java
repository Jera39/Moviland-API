package moviland.com.demo.Service;

import moviland.com.demo.Model.Usuario;

public interface UsuarioService {
    Usuario confirmarUsuario(String correo, String contraseñaString);

    void guardarUsuario(Usuario usuario);

    Usuario buscarPorCorreo(String correo);
}
