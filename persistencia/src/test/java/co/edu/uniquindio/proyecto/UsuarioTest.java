package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.GeneroPersona;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest
{
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private CiudadRepo ciudadRepo;
    @Test
    public void registrarTest ()
    {
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre("Armenia");
        ciudadRepo.save(ciudad);

        Usuario usuario = new Usuario();
        usuario.setCodigo("123");
        usuario.setNombre("Petito");
        usuario.setEmail("petito@gmail.com");
        usuario.setGenero(GeneroPersona.FEMENINO);
        usuario.setFechaNacimiento(LocalDate.now());
        usuario.setCiudad(ciudad);

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "987");
        telefonos.put("celular", "8889");

        usuario.setNumTelefonos(telefonos);

        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        Assertions.assertNotNull(usuarioGuardado);
    }

    @Test
    public void eliminarTest ()
    {
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre("Armenia");
        ciudadRepo.save(ciudad);

        Usuario usuario = new Usuario();
        usuario.setCodigo("123");
        usuario.setNombre("Petito");
        usuario.setEmail("petito@gmail.com");
        usuario.setGenero(GeneroPersona.FEMENINO);
        usuario.setFechaNacimiento(LocalDate.now());
        usuario.setCiudad(ciudad);

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "987");
        telefonos.put("celular", "8889");

        usuario.setNumTelefonos(telefonos);

        usuarioRepo.save(usuario);

        usuarioRepo.deleteById("123");

        Usuario usuarioBuscado = usuarioRepo.findById("123").orElse(null);

        Assertions.assertNull(usuarioBuscado);
    }

    @Test
    public void actualizarTest ()
    {
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre("Armenia");
        ciudadRepo.save(ciudad);

        Usuario usuario = new Usuario();
        usuario.setCodigo("123");
        usuario.setNombre("Petito");
        usuario.setEmail("petito@gmail.com");
        usuario.setGenero(GeneroPersona.FEMENINO);
        usuario.setFechaNacimiento(LocalDate.now());
        usuario.setCiudad(ciudad);

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "987");
        telefonos.put("celular", "8889");

        usuario.setNumTelefonos(telefonos);

        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        usuarioGuardado.setEmail("elgaysupremo8000@gmail.com");

        usuarioRepo.save(usuarioGuardado);

        Usuario usuarioBuscado = usuarioRepo.findById("123").orElse(null);

        Assertions.assertEquals("elgaysupremo8000@gmail.com", usuarioBuscado.getEmail());

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listar ()
    {
//        Ciudad ciudad = new Ciudad();
//        ciudad.setNombre("Armenia");
//        ciudadRepo.save(ciudad);
//
//        Map<String, String> telefonos = new HashMap<>();
//        telefonos.put("casa", "987");
//        telefonos.put("celular", "8889");
//
//        Usuario usuario = new Usuario("123", "Petito",
//                LocalDate.now(), GeneroPersona.FEMENINO, "petitoalberto@gmail.com", telefonos, ciudad);
//
//        usuarioRepo.save(usuario);
        List<Usuario> usuarios = usuarioRepo.findAll();

        usuarios.forEach(usuario -> System.out.println(usuario));

        //Assertions.assertEquals(3, usuarios.size());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void filtrarNombreTest ()
    {
        List<Usuario> lista = usuarioRepo.findAllByNombre("FOR");

        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void filtrarEmailTest ()
    {
        Optional<Usuario> usuario = usuarioRepo.findAllByEmail("for@gmail.com");

        if (usuario.isPresent())
        {
            System.out.println(usuario.get());
            return;
        }
        System.out.println("El correo no corresponde a ningún usuario");
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void paginarListaTest ()
    {
        Pageable vaginador = PageRequest.of(0, 2);

        Page<Usuario> lista = usuarioRepo.findAll(vaginador);

//        List<Usuario> respuesta = new ArrayList<>();

        System.out.println(lista.stream().collect(Collectors.toList()));
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void ordenarListaTest ()
    {
        List<Usuario> lista = usuarioRepo.findAll(Sort.by("nombre"));
        System.out.println(lista);
    }
}
