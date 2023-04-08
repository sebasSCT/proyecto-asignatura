package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Autor;
import co.edu.uniquindio.proyecto.entidades.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepo extends JpaRepository<Libro, String>
{
    Page<Libro> findAll(Pageable pageable);

    @Query("select l.autores from Libro l where l.isbn = :isbn")
    List<Autor> obtenerAutores(String isbn);
}
