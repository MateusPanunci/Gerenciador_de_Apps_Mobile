package br.uel.Apps_Mobile.Service;

import br.uel.Apps_Mobile.Model.Usuario;
import br.uel.Apps_Mobile.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticar(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }
}
