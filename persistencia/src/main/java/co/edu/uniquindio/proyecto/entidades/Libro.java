package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Libro implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 50)
    private String isbn;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Integer unidades;

    @Positive
    @Column(nullable = false)
    private Integer anio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroLibro genero;

    @ManyToMany(mappedBy = "libros")
    private List<Prestamo> prestamos;

    @ManyToMany
    private List<Autor> autores;

}
