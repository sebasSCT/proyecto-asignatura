package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CiudadRepo extends JpaRepository<Ciudad, Integer>
{
    Optional<Ciudad> findByNombre(String nombreCiudad);
}
