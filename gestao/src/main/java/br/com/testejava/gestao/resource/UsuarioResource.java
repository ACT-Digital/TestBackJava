package br.com.testejava.gestao.resource;


import br.com.testejava.gestao.model.Usuario;
import br.com.testejava.gestao.serivce.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value="/gestao/cliente")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Usuario> insert(@Valid @RequestBody Usuario obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }


}
