package service;

import exception.answerNotRemoveException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Formulario {
    Scanner read = new Scanner(System.in);
    private final File formulario = new File("formulario.txt");

    public List<String> Responder() {
        try {
            Scanner scanner = new Scanner(formulario);
            Scanner read = new Scanner(System.in);
            List<String> respostas = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                respostas.add(read.nextLine());
            }
            scanner.close();

            return respostas;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void adicionarPergunta() {
        try {
            FileWriter formularioUpdate = new FileWriter(formulario.getName(), true);

            System.out.println("Digite uma nova pergunta: ");
            String novaPergunta = read.nextLine();

            BufferedReader formularioReader = new BufferedReader(new FileReader(formulario.getName()));
            int countLines = 1;
            while (formularioReader.readLine() != null) {
                countLines++;
            }
            formularioUpdate.write(countLines + " - " + novaPergunta + "\n");

            formularioUpdate.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removerPerguntas() {
        Scanner read = new Scanner(System.in);
        File fileTemp = new File("formularioTemp.txt");
        try {
            Scanner scanner = new Scanner(formulario);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
            System.out.println(" ");
            System.out.println("Digite escolha a pergunta que deseja remover (menos as perguntas de 1 a 4): ");
            int opcaoRemover = read.nextInt();

            if (opcaoRemover <= 4) {
                throw new answerNotRemoveException("Essa pergunta não pode ser removida ou não encontrada!!!!");
            }
            FileWriter writerTemp = getFileWriter(opcaoRemover, fileTemp);
            writerTemp.close();


           if(formulario.delete()){
               if(!fileTemp.renameTo(formulario)){
                   throw new IOException("Não foi possível renomear o arquivo temporário.");
               }
               System.out.println("Linha removida com sucesso.");
           } else{
               throw new IOException("Não foi possível excluir o arquivo original.");
           }
        } catch (IOException | answerNotRemoveException e) {
            System.out.println(e.getMessage());
        }
    }

    private FileWriter getFileWriter(int opcaoRemover, File fileTemp) throws IOException {
        FileWriter writerTemp = new FileWriter(fileTemp);

        BufferedReader formularioLeitura = new BufferedReader(new FileReader(formulario.getName()));

        String line;
        int countLines = 1;
        int nLine = countLines;
        while ((line = formularioLeitura.readLine()) != null) {

            if (countLines != opcaoRemover) {
                int indice = line.indexOf("-");
                String pergunta = line.substring(indice + 2).trim();
                writerTemp.write(nLine + " - " + pergunta + "\n");
                nLine++;
            }
            countLines++;
        }
        return writerTemp;
    }
}
