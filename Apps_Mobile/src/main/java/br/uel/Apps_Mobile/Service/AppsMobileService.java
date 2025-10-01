package br.uel.Apps_Mobile.Service;


import br.uel.Apps_Mobile.Model.AppMobile;
import br.uel.Apps_Mobile.Repository.AppsMobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppsMobileService {
    @Autowired
    private AppsMobileRepository repository;

    public List<AppMobile> listar() {
        return repository.findAll(Sort.by("nome"));
    }

    //Usado para abrir a edição
    public AppMobile buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("App não encontrado com o nome " + id));
    }

    //Usado para pesquisar o nome da aplicação na NavBar
    public AppMobile buscar(String nome) {
        return repository.findByNome(nome).orElseThrow(() -> new RuntimeException("App não encontrado com o nome " + nome));
    }

    public void adicionar(AppMobile app) {
        repository.save(app);
    }


    public void remover(Long id) {
        if (!repository.existsById(id)){
            throw new RuntimeException("App não encontrado com o id: " + id);
        }
        repository.deleteById(id);
    }

    public AppMobile atualizar(Long id, AppMobile appAtualizado) {
        return repository.findById(id).map(app-> {
            app.setNome(appAtualizado.getNome());
            app.setTamanho(appAtualizado.getTamanho());
            app.setUnidadeTamanho(appAtualizado.getUnidadeTamanho());
            app.setDescricao(appAtualizado.getDescricao());
            app.setEmpresaDesenvolvedora(appAtualizado.getEmpresaDesenvolvedora());
            app.setVersao(appAtualizado.getVersao());
            return repository.save(app);
        }).orElseThrow(() -> new RuntimeException("App não encontrado!"));
    }
}
