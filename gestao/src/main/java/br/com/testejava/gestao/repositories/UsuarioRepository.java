package br.com.testejava.gestao.repositories;

import br.com.testejava.gestao.model.Usuario;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    public UsuarioRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    public Usuario save(Usuario user) {
        try {
            hashOperations.put("usuario", user.getId(), user);
            return user;
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void update(Usuario user) {
        save(user);
    }

}
