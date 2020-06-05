package br.com.testejava.gestao.serivce;

import br.com.testejava.gestao.model.Gastos;
import br.com.testejava.gestao.repositories.GastosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GastosService {

    @Autowired
    private GastosRepository gastosRepository;

    public Map<String,Gastos> findAll() {
        return gastosRepository.findAll();
    }

    public Gastos findData(String dt_param) {
        return gastosRepository.findByDt(dt_param);
    }

    public Gastos findDescricao(String categoria) {
        return gastosRepository.findDescricao(categoria);
    }

    public Gastos insert(Gastos gastos){
        return gastosRepository.insert(gastos);
    }

    public Gastos update(String data){
        return gastosRepository.update(data);
    }
}
