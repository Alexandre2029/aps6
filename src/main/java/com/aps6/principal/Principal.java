package com.aps6.principal;


import com.aps6.imagens.Imagem;
import com.aps6.usuario.Usuario;
import com.aps6.usuario.UsuarioRepository;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private UsuarioRepository usuarioRepository;

    public Principal(UsuarioRepository use){

        this.usuarioRepository = use;

    }


    public void menu() throws IOException {
        var opcao =0;
        while (opcao != 9){
            var menu = """
                    *** menu da aps ***                    
                                        
                    1- Cadastrar usuario
                    2- acesso a arquivos de lv1
                    3- acesso a arquivos de lv2
                    5- acesso a arquivos de lv3
                                    
                    9 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("cadastrando um usuario...");
                    cadastroUsuario();

                    break;
                case 2:
                    System.out.println("O nome do usuario");
                    findusuario();

                    break;
                case 3:
                    comparaDigital();

                    break;
                case 4:

                    break;

                default:
                    System.out.println("Opção inválida!");

            }

        }
    }

    public void cadastroUsuario(){
        Usuario teste = new Usuario("bruno","DIRETOR DE DIVISÃO","d2.jpg");
        usuarioRepository.save(teste);

    }

    public void findusuario(){



        List<Usuario> teste= usuarioRepository.findByNome("ALEXANDRE")  ;

        System.out.println(teste.get(0).getDigital());


        teste.forEach(System.out::println);

    }

    public void comparaDigital() throws IOException {

        Imagem ig = new Imagem();

        System.out.println("digite seu nome: ");
        String nome = leitura.next();
        leitura.nextLine();


        List<Usuario> testee= usuarioRepository.findByNome(nome);

        BufferedImage imgB = ig.retorna_img(testee.get(0).getDigital());

        System.out.println("digite sua digital: ");
        String digital = leitura.next();
        leitura.nextLine();

		BufferedImage imgA = ig.retorna_img(digital);


		String diferenca = ig.difereca(imgA, imgB);
		 System.out.println(diferenca);
    }

}
