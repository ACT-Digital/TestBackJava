package br.com.testejava.gestao.resource;

import br.com.testejava.gestao.model.Categoria;
import br.com.testejava.gestao.model.Usuario;
import br.com.testejava.gestao.serivce.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/gestao/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping()
    public ResponseEntity<Map<String ,Categoria>> find() {
        Map<String, Categoria> obj = service.find();
        return ResponseEntity.ok().body(obj);
    }

}
