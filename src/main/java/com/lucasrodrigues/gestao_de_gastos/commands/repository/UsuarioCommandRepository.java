package com.lucasrodrigues.gestao_de_gastos.commands.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucasrodrigues.gestao_de_gastos.domian.Usuario;

@Repository
public interface UsuarioCommandRepository extends MongoRepository<Usuario, Integer>{

}
