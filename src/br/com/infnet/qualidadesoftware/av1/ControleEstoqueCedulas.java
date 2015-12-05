/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infnet.qualidadesoftware.av1;

/**
 *
 * @author Felipe e Gustavo
 */
class ControleEstoqueCedulas {
    private int quantidadeCedulasValor5;
    private int quantidadeCedulasValor10;
    private int quantidadeCedulasValor20;
    private int quantidadeCedulasValor50;
    private int quantidadeCedulasValor100;
    
    public ControleEstoqueCedulas(){
        quantidadeCedulasValor5 = 0;
        quantidadeCedulasValor10 = 0;
        quantidadeCedulasValor20 = 0;
        quantidadeCedulasValor50 = 0;
        quantidadeCedulasValor100 = 0;
    }
    
    public int calcularSaldo() {
        return quantidadeCedulasValor5*5
                +quantidadeCedulasValor10*10
                +quantidadeCedulasValor20*20
                +quantidadeCedulasValor50*50
                +quantidadeCedulasValor100*100;
    }


    public void inserirCedulasValor5(int quantidade) {
        quantidadeCedulasValor5 += quantidade;
    }

    public void inserirCedulasValor10(int quantidade) {
        quantidadeCedulasValor10 += quantidade;
    }

    public void inserirCedulasValor20(int quantidade) {
        quantidadeCedulasValor20 += quantidade;
    }

    public void inserirCedulasValor50(int quantidade) {
        quantidadeCedulasValor50 += quantidade;
    }

    public void inserirCedulasValor100(int quantidade) {
        quantidadeCedulasValor100 += quantidade;
    }
    
    public void removerCedulasValor5(int quantidade) {
        quantidadeCedulasValor5 -= quantidade;
    }

    public void removerCedulasValor10(int quantidade) {
        quantidadeCedulasValor10 -= quantidade;
    }

    public void removerCedulasValor20(int quantidade) {
        quantidadeCedulasValor20 -= quantidade;
    }

    public void removerCedulasValor50(int quantidade) {
        quantidadeCedulasValor50 -= quantidade;
    }

    public void removerCedulasValor100(int quantidade) {
        quantidadeCedulasValor100 -= quantidade;
    }

    public int getQuantidadeCedulasValor5() {
        return quantidadeCedulasValor5;
    }

    public int getQuantidadeCedulasValor10() {
        return quantidadeCedulasValor10;
    }

    public int getQuantidadeCedulasValor20() {
        return quantidadeCedulasValor20;
    }

    public int getQuantidadeCedulasValor50() {
        return quantidadeCedulasValor50;
    }

    public int getQuantidadeCedulasValor100() {
        return quantidadeCedulasValor100;
    }
    
}
