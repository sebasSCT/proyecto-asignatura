package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String>
{
//    @Query("select u from Usuario u where u.nombre = :nombre")
//    List<Usuario> obtenerUsuariosPorNombre(String nombre);

    List<Usuario>findAllByNombre(String nombre);

    Optional<Usuario>findAllByEmail(String email);

//    @Query("select u from Usuario u where u.email = :email and u.password = :clave")
//    Optional<Usuario> verificarAutenticacion(String email, String clave);

    Optional<Usuario> findByEmailAndPassword(String email, String clave);

    Page<Usuario> findAll(Pageable paginador);
}
