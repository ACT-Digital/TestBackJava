package br.com.testejava.gestao.repositories;

import br.com.testejava.gestao.model.Categoria;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CategoriaRepository  {

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    public CategoriaRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    public void insert(Categoria categoria) {
        hashOperations.put("categoria", categoria.getTipo_categoria(), categoria);
    }

    public Map<String, Categoria> findAll() {
        return hashOperations.entries("categoria");
    }


}
