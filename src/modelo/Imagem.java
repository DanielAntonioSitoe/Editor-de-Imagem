/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Imagem {

    private long tempo_fim;
    private long tempo_inicio;
    private static ArrayList<Image> pilha_imagem_direita = new ArrayList<Image>();
    private static ArrayList<Image> pilha_imagem_esquerda = new ArrayList<Image>();
    private static ArrayList<Image> buffer_image_tela = new ArrayList<Image>();
    private static boolean esquerda = true;
    
    public long tempoProcessamento(){
        return tempo_fim-tempo_inicio;
    }
    public void setTempo_fim(){
        this.tempo_fim = System.currentTimeMillis();
    }
    public void setTempo_inicio(){
        this.tempo_inicio = System.currentTimeMillis();
    }
    public static ArrayList<Image> pilha_imagem_direita(){
        return pilha_imagem_direita;
    }
    public static ArrayList<Image> pilha_imagem_esquerda(){
        return pilha_imagem_esquerda;
    }
    public static ArrayList<Image> imagem_tela(){
        return buffer_image_tela;
    }

    public static boolean isEsquerda() {
        return esquerda;
    }

    public static void setEsquerda(boolean esquerda) {
        Imagem.esquerda = esquerda;
    }
    
}
