package com.lucasrodrigues.gestao_de_gastos.querys.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lucasrodrigues.gestao_de_gastos.domian.Usuario;

public interface UsuarioQueryRepository  extends MongoRepository<Usuario, Integer>{

}
