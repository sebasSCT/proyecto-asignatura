package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Autor extends Persona implements Serializable
{
    @Column(nullable = false)
    private Integer anioNacimiento;

    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;
}
