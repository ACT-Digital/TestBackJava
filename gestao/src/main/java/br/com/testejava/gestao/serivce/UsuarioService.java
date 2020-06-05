package br.com.testejava.gestao.serivce;

import br.com.testejava.gestao.model.Usuario;
import br.com.testejava.gestao.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario insert(Usuario usuario) {
    return usuarioRepository.save(usuario);
    }

}
