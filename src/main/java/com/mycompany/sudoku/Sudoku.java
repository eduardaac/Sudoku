/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sudoku;

import java.util.Scanner;

/**
 *
 * @author Eduarda
 */
public class Sudoku {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcao, menu;
        String leitura, sair = "sair";

        System.out.println("Bem Vindo ao Sudoku\nComo deseja jogar?");
        System.out.println("1-Gerar jogo aleatório. \n2-Definir jogo. \n3-Sair");
        opcao = teclado.nextInt();
        teclado.nextLine();

        while (opcao != 3) {
            Tabuleiro tabuleiro = new Tabuleiro();
            switch (opcao) {
                case 1:
                    System.out.println("\nCriando jogo aleatório...");
                    int numCasasAleatorias;
                    System.out.println("Quantidade de casas aleatórias que deseja criar");
                    numCasasAleatorias = teclado.nextInt();
                    tabuleiro.criarJogoAleatorio(numCasasAleatorias);

                    System.out.println("MENU \nO que deseja fazer?");
                    System.out.println("1- Adicionar jogada. \n2- Remover jogada. \n3-Dica. \n4-Sair.");
                    menu = teclado.nextInt();
                    teclado.nextLine();

                    while (menu != 4) {
                        switch (menu) {
                            case 1:
                                leitura = teclado.nextLine();
                                tabuleiro.lerValoresInserir(leitura);
                                break;
                            case 2:
                                leitura = teclado.nextLine();
                                tabuleiro.lerValoresRemover(leitura);
                                break;
                            case 3:
                                tabuleiro.dica();
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                        if (tabuleiro.verificarJogoFinalizado()) {
                            System.out.println("PARABÉNS VOCÊ VESCEU!");
                            System.out.println("Recomece o jogo...");
                            menu = 4;

                        } else {
                            System.out.println("\nMENU \nO que deseja fazer?");
                            System.out.println("1- Adicionar jogada. \n2- Remover jogada. \n3-Dica. \n4-Sair.");
                            menu = teclado.nextInt();
                            teclado.nextLine();
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nDefinir jogo...");
                    leitura = teclado.nextLine();
                    while (!leitura.equals(sair)) {
                        tabuleiro.lerValoresCriarJogoDefinido(leitura);
                        leitura = teclado.nextLine();
                    }
                    System.out.println("\nMENU \nO que deseja fazer?");
                    System.out.println("1- Adicionar jogada. \n2- Remover jogada.\n3-Dica. \n4-Sair.");
                    menu = teclado.nextInt();
                    teclado.nextLine();
                    while (menu != 4) {
                        switch (menu) {
                            case 1:
                                leitura = teclado.nextLine();
                                tabuleiro.lerValoresInserir(leitura);
                                break;
                            case 2:
                                leitura = teclado.nextLine();
                                tabuleiro.lerValoresRemover(leitura);
                                break;
                            case 3:
                                tabuleiro.dica();
                                break;

                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }

                        if (tabuleiro.verificarJogoFinalizado()) {
                            System.out.println("PARABÉNS VOCÊ VESCEU!");
                            System.out.println("Recomece o jogo...");
                            menu = 4;

                        } else {
                            System.out.println("\nMENU \nO que deseja fazer?");
                            System.out.println("1- Adicionar jogada. \n2- Remover jogada. \n3-Dica. \n4-Sair.");
                            menu = teclado.nextInt();
                            teclado.nextLine();
                        }
                    }
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
            System.out.println("\nBem Vindo ao Sudoku\nComo deseja jogar?");
            System.out.println("1-Gerar jogo aleatório. \n2-Definir jogo. \n3-Sair");
            opcao = teclado.nextInt();
            teclado.nextLine();
        }
    }
}
