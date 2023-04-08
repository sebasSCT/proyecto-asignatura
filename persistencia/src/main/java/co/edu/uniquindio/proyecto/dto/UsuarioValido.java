package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@ToString
public class UsuarioValido
{
    private String nombe;
    private String email;
    private LocalDate fechaNacimiento;
    private Ciudad ciudad;

}
