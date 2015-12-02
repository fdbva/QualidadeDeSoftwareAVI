/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infnet.qualidadesoftware.av1;

import java.util.Scanner;

/**
 *
 * @author Felipe
 */
class GerenciadorInput {
    private Scanner entradaUsuario;
    private int valorEntrado;
    
    public GerenciadorInput(){
        entradaUsuario = new Scanner(System.in);
    }
    
    void lerEntradaUsuario() {
        valorEntrado = entradaUsuario.nextInt();
    }
    public int getValorEntrado(){
        return valorEntrado;
    }
    
}
