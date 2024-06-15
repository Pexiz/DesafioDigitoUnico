package org.example.controller;

import org.example.model.Usuario;
import org.example.request.DigitoUnicoRequest;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.example.service.DigitoUnico.digitoUnico;

@RestController
@RequestMapping("/digitoUnico")
public class DigitoUnicoController {

    @Autowired
    private UserController userController;
    @Autowired
    private UserService userService;

    @PostMapping("/{id}")
    public ResponseEntity<Usuario> postResultFromDigitoUnicoUsuarioId(@PathVariable Long id,
                                                                      @RequestBody DigitoUnicoRequest request) throws Exception {

        ResponseEntity<Usuario> usuario = userController.getUsuarioById(id);

        int resultado = digitoUnico(request.getNumero(), request.getMultiplicador());

        userService.addResultadoToUsuario(id, request.getNumero(), request.getMultiplicador(), resultado, request.isBool());

        return ResponseEntity.ok(usuario.getBody());

    }
}
