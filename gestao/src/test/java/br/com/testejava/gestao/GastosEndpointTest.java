package br.com.testejava.gestao;

import br.com.testejava.gestao.model.Gastos;
import br.com.testejava.gestao.repositories.GastosRepository;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class GastosEndpointTest {

    @Autowired
    private GastosRepository gastosRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void insert(){
        Gastos gastos = new Gastos("Teste",4.2,"30/02/2020","Informatica");
        this.gastosRepository.insert(gastos);
        Assertions.assertThat(gastos.getData()).isNotNull();
        Assertions.assertThat(gastos.getDescricao()).isEqualTo("Teste");
        Assertions.assertThat(gastos.getCategoria()).isEqualTo("Informatica");
        Assertions.assertThat(gastos.getData()).isEqualTo("30/02/2020");
    }


}
