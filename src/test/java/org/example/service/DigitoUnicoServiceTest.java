package org.example.service;

import org.example.model.Usuario;
import org.example.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class DigitoUnicoServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private DigitoUnicoService digitoUnicoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Teste");

        Mockito.when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);

        Usuario savedUsuario = digitoUnicoService.saveUsuario(usuario);

        Assertions.assertNotNull(savedUsuario);
        Assertions.assertEquals(1L, savedUsuario.getId());
        Assertions.assertEquals("Teste", savedUsuario.getNome());
    }

    @Test
    public void testGetUsuarioById() {
        Long id = 1L;
        Usuario usuario = new Usuario();
        usuario.setNome("Teste");

        Mockito.when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));

        Optional<Usuario> result = digitoUnicoService.getUsuarioById(id);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("Teste", result.get().getNome());
    }

    @Test
    public void testDeleteUsuario() {
        Long id = 1L;

        Mockito.doNothing().when(usuarioRepository).deleteById(id);

        digitoUnicoService.deleteUsuario(id);

        Mockito.verify(usuarioRepository, Mockito.times(1)).deleteById(id);
    }
}
