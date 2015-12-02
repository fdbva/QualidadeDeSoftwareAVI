/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infnet.qualidadesoftware.av1;

import java.util.InputMismatchException;

/**
 *
 * @author Felipe
 */
class TransacaoSaque {
    private int quantidadeCedulasValor5Sacadas;
    private int quantidadeCedulasValor10Sacadas;
    private int quantidadeCedulasValor20Sacadas;
    private int quantidadeCedulasValor50Sacadas;
    private int quantidadeCedulasValor100Sacadas;
    private int quantidadeTotalDeSaques;
    private int valorTotalDeSaques;
    
    public TransacaoSaque(){
        zerarQuantidadeCedulasSacadas();
        quantidadeTotalDeSaques = 0;
        valorTotalDeSaques = 0;
    }
    
    void efetuarSaque(int valorEntrado, ControleEstoqueCedulas controleEstoqueCedulas) {
        zerarQuantidadeCedulasSacadas();
        if(valorEntrado < controleEstoqueCedulas.calcularSaldo() || valorEntrado % 5 != 0){
            throw new InputMismatchException("\nQuantia inválida ou saldo insuficiente");
        }
        int valorRestante = valorEntrado;
        if (valorRestante >= 100)
        {
            quantidadeCedulasValor100Sacadas = (int) Math.floor(valorRestante/100);

            if (controleEstoqueCedulas.getQuantidadeCedulasValor100() < quantidadeCedulasValor100Sacadas){
                quantidadeCedulasValor100Sacadas = controleEstoqueCedulas.getQuantidadeCedulasValor100();
            }

            valorRestante = valorRestante - quantidadeCedulasValor100Sacadas*100;
        }

        if (valorRestante >= 50) 
        {
            quantidadeCedulasValor50Sacadas = (int) Math.floor(valorRestante/50);

            if (controleEstoqueCedulas.getQuantidadeCedulasValor50()<quantidadeCedulasValor50Sacadas){
                quantidadeCedulasValor50Sacadas = controleEstoqueCedulas.getQuantidadeCedulasValor50();
            }

            valorRestante = valorRestante - quantidadeCedulasValor50Sacadas*50;    
        }

        if (valorRestante >= 20)
        {
            quantidadeCedulasValor20Sacadas = (int) Math.floor(valorRestante/20);

            if (controleEstoqueCedulas.getQuantidadeCedulasValor20()<quantidadeCedulasValor20Sacadas){
                quantidadeCedulasValor20Sacadas = controleEstoqueCedulas.getQuantidadeCedulasValor20();
            }

            valorRestante = valorRestante - quantidadeCedulasValor20Sacadas*20;    
        }
        if (valorRestante >= 10)
        {
            quantidadeCedulasValor10Sacadas = (int) Math.floor(valorRestante/10);

            if (controleEstoqueCedulas.getQuantidadeCedulasValor10()<quantidadeCedulasValor10Sacadas){
                quantidadeCedulasValor10Sacadas = controleEstoqueCedulas.getQuantidadeCedulasValor10();
            }

            valorRestante = valorRestante - quantidadeCedulasValor10Sacadas*10;    
        }
        if (valorRestante >= 5)
        {
            quantidadeCedulasValor5Sacadas = (int) Math.floor(valorRestante/5);

            if (controleEstoqueCedulas.getQuantidadeCedulasValor5()<quantidadeCedulasValor5Sacadas){
                quantidadeCedulasValor5Sacadas = controleEstoqueCedulas.getQuantidadeCedulasValor5();
            }

            valorRestante = valorRestante - quantidadeCedulasValor5Sacadas*5;    
        }
        if (valorRestante != 0){
            throw new InputMismatchException("\nQuantidade de células não é múltiplo do valor solicitado");
        }
        else{
            quantidadeTotalDeSaques++;
            valorTotalDeSaques += valorEntrado;
            controleEstoqueCedulas.removerCedulasValor100(quantidadeCedulasValor100Sacadas);
            controleEstoqueCedulas.removerCedulasValor50(quantidadeCedulasValor50Sacadas);
            controleEstoqueCedulas.removerCedulasValor20(quantidadeCedulasValor20Sacadas);
            controleEstoqueCedulas.removerCedulasValor10(quantidadeCedulasValor10Sacadas);
            controleEstoqueCedulas.removerCedulasValor5(quantidadeCedulasValor5Sacadas);
        }
    }

    private void zerarQuantidadeCedulasSacadas() {
        quantidadeCedulasValor5Sacadas = 0;
        quantidadeCedulasValor10Sacadas = 0;
        quantidadeCedulasValor20Sacadas = 0;
        quantidadeCedulasValor50Sacadas = 0;
        quantidadeCedulasValor100Sacadas = 0;
    }
    
    int getquantidadeTotalDeSaques() {
        return quantidadeTotalDeSaques;
    }

    int getvalorTotalDeSaques() {
        return valorTotalDeSaques;
    }

    public int getQuantidadeCedulasValor5Sacadas() {
        return quantidadeCedulasValor5Sacadas;
    }

    public int getQuantidadeCedulasValor10Sacadas() {
        return quantidadeCedulasValor10Sacadas;
    }

    public int getQuantidadeCedulasValor20Sacadas() {
        return quantidadeCedulasValor20Sacadas;
    }

    public int getQuantidadeCedulasValor50Sacadas() {
        return quantidadeCedulasValor50Sacadas;
    }

    public int getQuantidadeCedulasValor100Sacadas() {
        return quantidadeCedulasValor100Sacadas;
    }

    
}
