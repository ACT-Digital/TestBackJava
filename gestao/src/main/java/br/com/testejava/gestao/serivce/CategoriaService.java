package br.com.testejava.gestao.serivce;

import br.com.testejava.gestao.model.Categoria;
import br.com.testejava.gestao.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;



    public Map<String, Categoria> find() {

        return categoriaRepository.findAll();
    }
}
