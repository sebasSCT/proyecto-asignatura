package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Autor;
import co.edu.uniquindio.proyecto.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepo extends JpaRepository<Autor, String>
{
    @Query("select a.nombre, l from Autor a left join a.libros l")
    List<Object[]> listarLibrosYAutores ();


    @Query("select distinct l.autores from Autor a join a.libros l where a.codigo = :codigo")
    List<List<Autor>> listarAutoresLibros(String codigo);
}
