/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infnet.qualidadesoftware.av1;

/**
 *
 * @author Felipe
 */

public class CaixaEletronico {
    GerenciadorInput gerenciadorInput;
    ControleEstoqueCedulas controleEstoqueCedulas;
    TransacaoSaque transacaoSaque;
    
    public CaixaEletronico(){
        gerenciadorInput = new GerenciadorInput();
        controleEstoqueCedulas = new ControleEstoqueCedulas();
        transacaoSaque = new TransacaoSaque();
    }
    
    public void startSistema(){
        do
        {
            imprimirMenuPrincipal();
            gerenciadorInput.lerEntradaUsuario();
            
            switch(gerenciadorInput.getValorEntrado())
            {
                case 1:
                    reporEstoqueCedulas();
                    break;
                case 2:
                    sacarDinheiro();
                    break;
                case 3:                         
                    consultarSaldo();
                    break;
                case 4:
                    notificarFechamentoSistema();
                    break;
                default:
                    notificarOpcaoInvalida();
                    break;
            }
        } while (gerenciadorInput.getValorEntrado() != 4);
    }

    private void imprimirMenuPrincipal() {
        GerenciadorInterface.imprimirMenuPrincipal();
    }

    private void consultarSaldo() { //usar a classe ou o objeto para fazer a chamada dos métodos static?
        GerenciadorInterface.imprimirCabecalhoSaldo();
        GerenciadorInterface.imprimirSaldoTotal(controleEstoqueCedulas.calcularSaldo());
        GerenciadorInterface.imprimirQuantidadeDeSaques(transacaoSaque.getquantidadeTotalDeSaques());
        GerenciadorInterface.imprimirValorTotalSaques(transacaoSaque.getvalorTotalDeSaques());
        GerenciadorInterface.imprimirQuantidadeCedulasValor5(controleEstoqueCedulas.getQuantidadeCedulasValor5());
        GerenciadorInterface.imprimirQuantidadeCedulasValor10(controleEstoqueCedulas.getQuantidadeCedulasValor10());
        GerenciadorInterface.imprimirQuantidadeCedulasValor20(controleEstoqueCedulas.getQuantidadeCedulasValor20());
        GerenciadorInterface.imprimirQuantidadeCedulasValor50(controleEstoqueCedulas.getQuantidadeCedulasValor50());
        GerenciadorInterface.imprimirQuantidadeCedulasValor100(controleEstoqueCedulas.getQuantidadeCedulasValor100());
    }

    private void sacarDinheiro() {
        GerenciadorInterface.imprimirCabecalhoSaquePergunta();
        gerenciadorInput.lerEntradaUsuario();
        try {
            transacaoSaque.efetuarSaque(gerenciadorInput.getValorEntrado(), controleEstoqueCedulas);
            GerenciadorInterface.imprimirCabecalhoSaqueRealizado();
            GerenciadorInterface.imprimirQuantidadeCedulasValor5(transacaoSaque.getQuantidadeCedulasValor5Sacadas());
            GerenciadorInterface.imprimirQuantidadeCedulasValor10(transacaoSaque.getQuantidadeCedulasValor10Sacadas());
            GerenciadorInterface.imprimirQuantidadeCedulasValor20(transacaoSaque.getQuantidadeCedulasValor20Sacadas());
            GerenciadorInterface.imprimirQuantidadeCedulasValor50(transacaoSaque.getQuantidadeCedulasValor50Sacadas());
            GerenciadorInterface.imprimirQuantidadeCedulasValor100(transacaoSaque.getQuantidadeCedulasValor100Sacadas());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void reporEstoqueCedulas() {
        GerenciadorInterface.imprimirCabecalhoReposicaoEstoque();
        GerenciadorInterface.imprimirPerguntaQuantidadeNotasValor5();
        gerenciadorInput.lerEntradaUsuario();
        controleEstoqueCedulas.inserirCedulasValor5(gerenciadorInput.getValorEntrado());
        
        GerenciadorInterface.imprimirPerguntaQuantidadeNotasValor10();
        gerenciadorInput.lerEntradaUsuario();
        controleEstoqueCedulas.inserirCedulasValor10(gerenciadorInput.getValorEntrado());
        
        GerenciadorInterface.imprimirPerguntaQuantidadeNotasValor20();
        gerenciadorInput.lerEntradaUsuario();
        controleEstoqueCedulas.inserirCedulasValor20(gerenciadorInput.getValorEntrado());
        
        GerenciadorInterface.imprimirPerguntaQuantidadeNotasValor50();
        gerenciadorInput.lerEntradaUsuario();
        controleEstoqueCedulas.inserirCedulasValor50(gerenciadorInput.getValorEntrado());
        
        GerenciadorInterface.imprimirPerguntaQuantidadeNotasValor100();
        gerenciadorInput.lerEntradaUsuario();
        controleEstoqueCedulas.inserirCedulasValor100(gerenciadorInput.getValorEntrado());
    }
    
    private static void notificarFechamentoSistema(){
        System.out.println("Sistema terminado"); //TODO gerenciadorInterface
    }
    
    private static void notificarOpcaoInvalida(){
        System.out.println("Opção inválida!"); //TODO gerenciadorInterface
    }
}
