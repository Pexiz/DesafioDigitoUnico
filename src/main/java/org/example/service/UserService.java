package org.example.service;

import org.example.model.Resultado;
import org.example.model.Usuario;
import org.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario addResultadoToUsuario(Long id, String numero, Integer multiplicador, int numeroUnico, boolean bool) throws Exception {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (!usuarioOpt.isPresent()) {
            throw new Exception("Usuário não encontrado");
        }

        Usuario usuario = usuarioOpt.get();
        Resultado resultado = new Resultado();

        resultado.setParametroNumero(numero);
        resultado.setParametroMultiplicador(multiplicador);
        resultado.setParametroNumero(numero);
        resultado.setResultado(numeroUnico);
        resultado.setId(id);
        usuario.getResultados().add(resultado);

        if (bool) {
            usuarioRepository.save(usuario);
            return usuario;
        }
        return usuario;

    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
