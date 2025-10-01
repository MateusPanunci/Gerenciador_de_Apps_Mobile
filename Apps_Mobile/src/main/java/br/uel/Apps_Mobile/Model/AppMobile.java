package br.uel.Apps_Mobile.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "AppsMobile")
public class AppMobile {
    public AppMobile() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank(message = "O nome não pode estar em branco!")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres!")
    public String nome;


    @Positive(message = "Número deve ser positivo!")
    @NotNull(message = "O tamanho do App deve ser informado!")
    public Long tamanho;


    @NotBlank(message = "A unidade do tamanho deve ser informada!")
    public String unidadeTamanho;


    @NotBlank(message = "A empresa que desenvolveu é um campo obrigatório a ser preeenchido!")
    public String empresaDesenvolvedora;


    public String descricao;

    @Positive(message = "Número peve ser positivo!")
    @NotNull(message = "A versão do App deve ser informada!")
    public float versao;

    public Long getId() {return id;}

    public String getNome(){
        return nome;
    }

    public Long getTamanho(){
        return tamanho;
    }

    public String getUnidadeTamanho(){return unidadeTamanho;}

    public String getDescricao(){
        return descricao;
    }

    public String getEmpresaDesenvolvedora(){ return empresaDesenvolvedora;
    }

    public float getVersao(){return versao; }

    public void setId(Long id) {this.id = id;}

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setUnidadeTamanho(String unidade){unidadeTamanho = unidade;}

    public void setTamanho(Long tamanho){ this.tamanho = tamanho;
    }

    public void setEmpresaDesenvolvedora(String empresa){ this.empresaDesenvolvedora = empresa;
    }

    public void setVersao(float versao){
        this.versao = versao ;
    }

}
