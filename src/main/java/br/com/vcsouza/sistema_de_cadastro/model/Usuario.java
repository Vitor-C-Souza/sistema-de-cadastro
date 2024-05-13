package br.com.vcsouza.sistema_de_cadastro.model;

import br.com.vcsouza.sistema_de_cadastro.exception.*;
import br.com.vcsouza.sistema_de_cadastro.service.Leitura;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class Usuario {
    private String nome;
    private String email;
    private int idade;
    private double altura;
    private List<String> extra;

    public Usuario(List<String> respostas) {
        Leitura verifica = new Leitura();
        if(respostas.getFirst().length()<10){
            throw new nomeLengthException("o nome não pode conter menos de 10 caracteres");
        }
        this.nome = respostas.getFirst();
        if (!respostas.get(1).contains("@")){
            throw new formatEmailInvalidException("Formato do email invalido");
        }
        boolean conclusion = verifica.verificarEmailUnico(respostas.get(1));
        if(conclusion){
            throw new duplicidadeDeEmailException("Email ja cadastrado no sistema");
        }
        email = respostas.get(1);
        if (Integer.parseInt(respostas.get(2))<18){
            throw new idadeInvalidException("Proibido menor de 18 anos de se cadastrar");
        }
        this.idade = Integer.parseInt(respostas.get(2));
        if (!respostas.get(3).contains(".")){
            throw new formatAlturaInvalidException("Formato de altura informada invalido");
        }
        this.altura = Double.parseDouble(respostas.get(3));
        this.extra = respostas.subList(4, respostas.size());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome).append("\n")
                .append(email).append("\n")
                .append(idade).append("\n")
                .append(altura).append("\n");
        for (String item: extra){
            sb.append(item).append("\n");
        }

        return sb.toString();
    }
}
