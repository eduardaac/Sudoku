/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Eduarda
 */
public class Tabuleiro {

    public static int SIZE = 9;
    public static int VAZIO = 0;
    private final int[][] matriz = new int[SIZE][SIZE];
    private int[][] matrizInalterada = new int[SIZE][SIZE];

    public void lerValoresInserir(String leitura) {

        String[] entradas = leitura.split("\\)\\(");

        for (String entrada : entradas) {
            String[] valores = entrada.replace("(", "").replace(")", "").split(",");
            int linha = Integer.parseInt(valores[0]);
            int coluna = Integer.parseInt(valores[1]);
            int valor = Integer.parseInt(valores[2]);
            adicionarJogada(linha, coluna, valor);
        }
    }

    public void lerValoresCriarJogoDefinido(String leitura) {
        String[] entradas = leitura.split("\\)\\(");

        for (String entrada : entradas) {
            String[] valores = entrada.replace("(", "").replace(")", "").split(",");
            int linha = Integer.parseInt(valores[0]);
            int coluna = Integer.parseInt(valores[1]);
            int valor = Integer.parseInt(valores[2]);
            criarJogoDefinido(linha, coluna, valor);
        }
    }

    public void lerValoresRemover(String leitura) {
        String[] entradas = leitura.split("\\)\\(");

        for (String entrada : entradas) {
            String[] valores = entrada.replace("(", "").replace(")", "").split(",");
            int linha = Integer.parseInt(valores[0]);
            int coluna = Integer.parseInt(valores[1]);
            removerJogada(linha, coluna);
        }
    }

    public void criarJogoAleatorio(int numCasasAleatorias) {
        Random random = new Random();
        for (int i = 0; i < numCasasAleatorias; i++) {
            int linha = random.nextInt(SIZE);
            int coluna = random.nextInt(SIZE);
            int valor = random.nextInt(SIZE) + 1;

            while (!verificarJogada(linha, coluna, valor) || matriz[linha][coluna] != VAZIO) {
                linha = random.nextInt(SIZE);
                coluna = random.nextInt(SIZE);
                valor = random.nextInt(SIZE) + 1;
            }
            matriz[linha][coluna] = valor;
            matrizInalterada[linha][coluna] = 1;
        }
        imprimirTabuleiro();
    }

    private void criarJogoDefinido(int linha, int coluna, int valor) {
        linha = linha - 1;
        coluna = coluna - 1;
        if (!verificarJogada(linha, coluna, valor)) {
            System.out.println("Não segue as regras necessárias para o Sudoku");
        }
        if (matriz[linha][coluna] == VAZIO) {
            matriz[linha][coluna] = valor;
            matrizInalterada[linha][coluna] = 1;
            imprimirTabuleiro();
        }
    }

    private void adicionarJogada(int linha, int coluna, int valor) {
        linha = linha - 1;
        coluna = coluna - 1;
        if (matriz[linha][coluna] == VAZIO) {
            if (valor > 0 && valor < 10) {
                if (verificarJogada(linha, coluna, valor)) {
                    matriz[linha][coluna] = valor;
                    imprimirTabuleiro();
                } else {
                    System.out.println("Valor já existente na linha ou coluna ou matriz 3x3!");
                }
            } else {
                System.out.println("Valor inserido inválido!");
            }
        } else {
            System.out.println("Espaço já preenchido!");
        }
    }

    private void removerJogada(int linha, int coluna) {
        linha = linha - 1;
        coluna = coluna - 1;

        if (matriz[linha][coluna] != VAZIO) {
            if (matrizInalterada[linha][coluna] != 1) {
                matriz[linha][coluna] = VAZIO;
                imprimirTabuleiro();
            } else {
                System.out.println("Valor que deseja remover fixo!");
            }
        } else {
            System.out.println("Posição vázia!");
        }
    }

    private boolean verificarJogada(int linha, int coluna, int valor) {
        for (int i = 0; i < SIZE; i++) {
            if (matriz[linha][i] == valor || matriz[i][coluna] == valor) {
                return false;
            }
        }
        int l = (linha / 3) * 3;
        int c = (coluna / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[l + i][c + j] == valor) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean verificarJogoFinalizado() {
        int cont = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (matriz[i][j] != VAZIO) {
                    cont++;
                }
            }
        }
        if(cont == SIZE * SIZE) {
            return true;
        }
        return false;
    }

    public void dica() {
        Random random = new Random();
        int linha = random.nextInt(SIZE);
        int coluna = random.nextInt(SIZE);
        int valor = random.nextInt(SIZE) + 1;

        while (!verificarJogada(linha, coluna, valor) || matriz[linha][coluna] != VAZIO) {
            linha = random.nextInt(SIZE);
            coluna = random.nextInt(SIZE);
            valor = random.nextInt(SIZE) + 1;
        }
        System.out.println("\nDica de jogada...");
        linha = linha + 1;
        coluna = coluna + 1;
        System.out.println("linha:" + linha + ", coluna: " + coluna + ", valor: " + valor);
    }

    private void imprimirTabuleiro() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
