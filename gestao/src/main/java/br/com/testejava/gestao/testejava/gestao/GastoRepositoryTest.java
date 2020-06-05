package br.com.testejava.gestao.testejava.gestao;


import br.com.testejava.gestao.repositories.GastosRepository;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class GastoRepositoryTest {

    @Autowired
    private GastosRepository gastosRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


}
