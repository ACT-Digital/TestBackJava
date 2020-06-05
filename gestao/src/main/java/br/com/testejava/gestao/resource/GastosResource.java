package br.com.testejava.gestao.resource;


import br.com.testejava.gestao.model.Gastos;
import br.com.testejava.gestao.serivce.GastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Map;

@RestController
@RequestMapping(value = "/gestao/gasto")
public class GastosResource {

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private GastosService service;

    @GetMapping(value = "/consulta")
    public ResponseEntity<Map<String, Gastos>> find() {
        Map<String, Gastos> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/consulta/data")
    public ResponseEntity<Gastos> findDt(
            @RequestParam(value = "data", defaultValue = "") String data) {
        String dt_param = data.length() == 8 ? formato.format(data) : "Não foi possivel converter data";

        Gastos obj = service.findData(dt_param);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping()
    public ResponseEntity<Gastos> insert(@Valid @RequestBody Gastos obj) {
        Gastos ifExistsCategoria = service.findDescricao(obj.getDescricao());
        Gastos gastos;
        if (ifExistsCategoria == null) {
            gastos = service.insert(obj);
        } else {
            obj.setCategoria(ifExistsCategoria.getCategoria());
            gastos = service.insert(obj);
        }
        return ResponseEntity.ok().body(gastos);
    }

    @PutMapping("/{data}")
    public ResponseEntity<Gastos> update(@PathVariable String data) {
        data = formato.format(data);
        Gastos obj = service.update(data);
        return ResponseEntity.ok().body(obj);
    }


}
