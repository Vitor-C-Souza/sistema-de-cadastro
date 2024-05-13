package br.com.vcsouza.sistema_de_cadastro.service;

import br.com.vcsouza.sistema_de_cadastro.exception.formatAlturaInvalidException;
import br.com.vcsouza.sistema_de_cadastro.exception.formatEmailInvalidException;
import br.com.vcsouza.sistema_de_cadastro.exception.idadeInvalidException;
import br.com.vcsouza.sistema_de_cadastro.exception.nomeLengthException;
import br.com.vcsouza.sistema_de_cadastro.model.Usuario;
import br.com.vcsouza.sistema_de_cadastro.repository.UsuarioRespository;

import java.util.List;

public class Cadastro {
    public void cadastrar() {
        Formulario formulario = new Formulario();
        List<String> respostas = formulario.Responder();

        for (String resposta : respostas) {
            System.out.println(resposta);
        }

        try {
            Usuario usuario = new Usuario(respostas);

//            Arquivo file = new Arquivo();
//            file.gravarCadastro(usuario);
            UsuarioRespository.save(usuario);
        } catch (nomeLengthException e){
            System.out.println(e.getMessage());
        } catch(formatEmailInvalidException e){
            System.out.println(e.getMessage());
        } catch(idadeInvalidException e){
            System.out.println(e.getMessage());
        } catch(formatAlturaInvalidException e){
            System.out.println(e.getMessage());
        }


    }


}
