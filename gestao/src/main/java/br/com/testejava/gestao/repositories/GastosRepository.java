package br.com.testejava.gestao.repositories;

import br.com.testejava.gestao.model.Gastos;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class GastosRepository {

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    public GastosRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    public Gastos insert(Gastos gastos) {
        hashOperations.put("gastos", "gastos", gastos);
        return gastos;
    }

    public Map<String, Gastos> findAll() {
        return hashOperations.entries("gastos");
    }


    public Gastos findByDt(String dt) {
        return (Gastos) hashOperations.get("gastos", dt);
    }

    public Gastos findDescricao(String descricao) {
        return (Gastos) hashOperations.get("gastos", descricao);
    }

    public Gastos update(String dt) {
        Gastos gastos = findByDt(dt);
        return insert(gastos);
    }
}
