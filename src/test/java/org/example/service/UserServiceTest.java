package org.example.service;

import org.example.model.Resultado;
import org.example.model.Usuario;
import org.example.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddResultadoToUsuario() throws Exception {
        Long id = 1L;
        String numero = "9875";
        Integer multiplicador = 4;
        int numeroUnico = 8;

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setResultados(new ArrayList<>());

        Resultado resultado = new Resultado(numero, multiplicador, numeroUnico);
        resultado.setParametroNumero(numero);
        resultado.setParametroMultiplicador(multiplicador);
        resultado.setResultado(numeroUnico);

        Mockito.when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));
        Mockito.when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);

        Usuario savedUsuario = userService.addResultadoToUsuario(id, numero, multiplicador, numeroUnico, true);

        Assertions.assertNotNull(savedUsuario);
        Assertions.assertEquals(1, savedUsuario.getResultados().size());
        Assertions.assertEquals(numero, savedUsuario.getResultados().get(0).getParametroNumero());
        Assertions.assertEquals(multiplicador, savedUsuario.getResultados().get(0).getParametroMultiplicador());
        Assertions.assertEquals(numeroUnico, savedUsuario.getResultados().get(0).getResultado());
    }

    @Test
    public void testSaveUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Teste");

        Mockito.when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);

        Usuario savedUsuario = userService.saveUsuario(usuario);

        Assertions.assertNotNull(savedUsuario);
        Assertions.assertEquals(1L, savedUsuario.getId());
        Assertions.assertEquals("Teste", savedUsuario.getNome());
    }

    @Test
    public void testGetAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setNome("Teste 1");
        usuarios.add(usuario);

        Usuario usuario2 = new Usuario();
        usuario.setNome("Teste 1");
        usuarios.add(usuario2);

        Mockito.when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> result = userService.getAllUsuarios();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Teste 1", result.get(0).getNome());
    }

    @Test
    public void testGetUsuarioById() {
        Long id = 1L;
        Usuario usuario = new Usuario();
        usuario.setNome("Teste");

        Mockito.when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));

        Optional<Usuario> result = userService.getUsuarioById(id);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("Teste", result.get().getNome());
    }

    @Test
    public void testDeleteUsuario() {
        Long id = 1L;

        Mockito.doNothing().when(usuarioRepository).deleteById(id);

        userService.deleteUsuario(id);

        Mockito.verify(usuarioRepository, Mockito.times(1)).deleteById(id);
    }

}
