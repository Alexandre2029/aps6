package com.aps6.principal;


import com.aps6.imagens.Imagem;
import com.aps6.usuario.Usuario;
import com.aps6.usuario.UsuarioRepository;

import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.List;
import java.util.Scanner;

public class Principal {

    final Scanner leitura = new Scanner(System.in);
    final UsuarioRepository usuarioRepository;

    public Principal(UsuarioRepository use){

        this.usuarioRepository = use;

    }


    public void menu() throws IOException {
        var opcao =0;
        while (opcao != 4){
            var menu = """
                    *** menu da aps ***
                 
                    1- acesso a arquivos de lv1
                    2- acesso a arquivos de lv2
                    3- acesso a arquivos de lv3
                    4 - Sair
                    "DIGITE SUA OPÇÃO: "
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("ARQUIVOS DE LV 1");

                    if (!(validacao().equals("DIGITAL INVALIDA"))){
                        System.out.println("AQUI ESTAO OS ARQUIVOS DE NIVEL 1");
                    }else {
                        System.out.println("Digital incompativel com a digital salva no cadastro");
                    }

                    break;
                case 2:
                    System.out.println("ARQUIVOS DE LV 2");
                      switch (validacao()){
                          case "ACESSO LIBERADO NIVEL 2":
                             System.out.println("AQUI ESTÃO OS ARQUIVOS DE NIVEL 2");
                          break;

                          case"ACESSO LIBERADO NIVEL 3":
                              System.out.println("MINISTROS NÃO TEM ACESSO AOS ARQUIVOS DESSE NIVEL");
                          break;

                          case"ACESSO LIBERADO NIVEL 1":
                              System.out.println("APENAS DIRETORES TEM ACESSO ");
                              break;


                          case"DIGITAL INVALIDA":
                              System.out.println("DIGITAL DIVERGENTE DA DIGITAL SALVA NO CADASTRO");
                              break;
                      }
                    menu();
                    break;
                case 3:
                    System.out.println("ARQUIVOS DE LV 3");

                    switch (validacao()){
                        case"ACESSO LIBERADO NIVEL 3":
                            System.out.println("AQUI ESTÃO OS ARQUIVOS DE NIVEL 3" );
                            break;

                        case "ACESSO LIBERADO NIVEL 2":
                            System.out.println("DIRETORES NÃO TEM ACESSO AOS ARQUIVOS DESSE NIVEL");
                            break;

                        case"ACESSO LIBERADO NIVEL 1":
                            System.out.println("APENAS MINISTROS TEM ACESSO ");
                            break;


                        case"DIGITAL INVALIDA":
                            System.out.println("DIGITAL DIVERGENTE DA DIGITAL SALVA NO CADASTRO");
                            break;

                    }
                    menu();
                    break;
                case 4:
                    System.out.println("fechando...");
                    System.runFinalization();


                default:
                    System.out.println();

            }

        }
    }


    public String comparaCargo(String cargo){


        if (  cargo.equals("DIRETOR DE DIVISÃO") ){
            return"ACESSO LIBERADO NIVEL 2";
            
        } else if (cargo.equals("MINISTRO DO MEIO AMBIENTE")) {
            return"ACESSO LIBERADO NIVEL 3";

        }else
            return "ACESSO LIBERADO NIVEL 1";

    }


    public String validacao() throws IOException {
        Imagem ig = new Imagem();

        System.out.println("digite seu nome: ");
        String nome = leitura.next();
        leitura.nextLine();
        List<Usuario> Usuario1= usuarioRepository.findByNome(nome);

        BufferedImage imgA = ig.retorna_img(Usuario1.get(0).getDigital());

        System.out.println("digite sua digital: ");
        String digital = leitura.next();
        leitura.nextLine();
        BufferedImage imgB = ig.retorna_img(digital);

        if (ig.verificaDigital(imgA, imgB)){

            return comparaCargo(Usuario1.get(0).getCargo());

        } else if (!ig.verificaDigital(imgA, imgB)) {
            return  "DIGITAL INVALIDA";
        }else
            return "ERRO";

    }


    //FUNÇÃO PARA CADASTRO DE USUARIOS NO BANCO DE DADOS

    public void cadastroUsuario(){
        Usuario teste = new Usuario("LUCAS","ESTAGIARIO","d3.jpg");
        usuarioRepository.save(teste);

    }

}
