package moviland.com.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

import moviland.com.demo.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contraseña = :contraseña")
    Optional<Usuario> findByCorreoAndContraseña(@Param("correo") String correo, @Param("contraseña") String contraseña);

    Usuario findByCorreo(String correo);
}
