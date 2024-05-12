package br.com.vcsouza.sistema_de_cadastro.controller;

import br.com.vcsouza.sistema_de_cadastro.service.Cadastro;
import br.com.vcsouza.sistema_de_cadastro.service.Formulario;
import br.com.vcsouza.sistema_de_cadastro.service.Leitura;

import java.util.Scanner;

public class MenuPrincipal {
    public void menu(){
        Scanner read = new Scanner(System.in);
        Formulario formulario = new Formulario();
        Leitura leitura = new Leitura();

        System.out.println("""
                *****************************************************
                MENU PRINCIPAL
                
                1 - Cadastrar o usuário
                2 - Listar todos usuários cadastrados
                3 - Cadastrar nova pergunta no formulário
                4 - Deletar pergunta do formulário
                5 - Pesquisar usuário por nome ou idade ou email
                
                *****************************************************
                """);
        int opcao = read.nextInt();

        switch (opcao){
            case 1:
                Cadastro cadastro = new Cadastro();
                cadastro.cadastrar();
                break;
            case 2:
                leitura.listarTodosUsuarios();
                break;
            case 3:
                formulario.adicionarPergunta();
                break;
            case 4:
                formulario.removerPerguntas();
                break;
            case 5:
                leitura.procuraUsuarios();
                break;


        }

    }
}
