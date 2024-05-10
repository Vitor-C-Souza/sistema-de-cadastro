package service;

import exception.formatAlturaInvalidException;
import exception.formatEmailInvalidException;
import exception.idadeInvalidException;
import exception.nomeLengthException;
import model.Usuario;

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

            Arquivo file = new Arquivo();
            file.gravarCadastro(usuario);
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
