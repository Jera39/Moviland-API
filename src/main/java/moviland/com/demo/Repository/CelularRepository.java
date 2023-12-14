package moviland.com.demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import moviland.com.demo.Model.Celular;

public interface CelularRepository extends JpaRepository<Celular, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Celular SET estado = :estado WHERE id = :id", nativeQuery = true)
    void updateEstado(@Param("id") int id, @Param("estado") Boolean estado);
    @Query(value = "SELECT * FROM celular WHERE marca = :marca and estado = true",nativeQuery = true)
    List<Celular> celularesPorMarca(@Param("marca") String marca);
    List<Celular> findByEstadoTrue();
}
