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
    GerenciadorInterface gerenciadorInterface;
    ControleEstoqueCedulas controleEstoqueCedulas;
    TransacaoSaque transacaoSaque;
    
    public CaixaEletronico(){
        gerenciadorInput = new GerenciadorInput();
        gerenciadorInterface = new GerenciadorInterface();
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
        gerenciadorInterface.imprimirMenuPrincipal();
    }

    private void consultarSaldo() { //usar a classe ou o objeto para fazer a chamada dos métodos static?
        GerenciadorInterface.imprimirCabecalhoSaldo();
        GerenciadorInterface.imprimirSaldoTotal(controleEstoqueCedulas.calcularSaldo());
        gerenciadorInterface.imprimirQuantidadeDeSaques(transacaoSaque.getquantidadeTotalDeSaques());
        gerenciadorInterface.imprimirValorTotalSaques(transacaoSaque.getvalorTotalDeSaques());
        gerenciadorInterface.imprimirQuantidadeCedulasValor5(controleEstoqueCedulas.getQuantidadeCedulasValor5());
        gerenciadorInterface.imprimirQuantidadeCedulasValor10(controleEstoqueCedulas.getQuantidadeCedulasValor10());
        gerenciadorInterface.imprimirQuantidadeCedulasValor20(controleEstoqueCedulas.getQuantidadeCedulasValor20());
        gerenciadorInterface.imprimirQuantidadeCedulasValor50(controleEstoqueCedulas.getQuantidadeCedulasValor50());
        gerenciadorInterface.imprimirQuantidadeCedulasValor100(controleEstoqueCedulas.getQuantidadeCedulasValor100());
    }

    private void sacarDinheiro() {
        GerenciadorInterface.imprimirCabecalhoSaque();
        gerenciadorInput.lerEntradaUsuario();
        try {
            transacaoSaque.efetuarSaque(gerenciadorInput.getValorEntrado(), controleEstoqueCedulas);
            gerenciadorInterface.imprimirCabecalhoSaque();
            gerenciadorInterface.imprimirQuantidadeCedulasValor5(transacaoSaque.getQuantidadeCedulasValor5Sacadas());
            gerenciadorInterface.imprimirQuantidadeCedulasValor10(transacaoSaque.getQuantidadeCedulasValor10Sacadas());
            gerenciadorInterface.imprimirQuantidadeCedulasValor20(transacaoSaque.getQuantidadeCedulasValor20Sacadas());
            gerenciadorInterface.imprimirQuantidadeCedulasValor50(transacaoSaque.getQuantidadeCedulasValor50Sacadas());
            gerenciadorInterface.imprimirQuantidadeCedulasValor100(transacaoSaque.getQuantidadeCedulasValor100Sacadas());
        } catch (Exception e) { //não sei se a exception foi criada corretamente
            System.out.println(e.getMessage());
        }
    }
    
    private void reporEstoqueCedulas() {
        gerenciadorInterface.imprimirCabecalhoReposicaoEstoque();
        gerenciadorInterface.imprimirPerguntaQuantidadeNotasValor5();
        gerenciadorInput.lerEntradaUsuario();
        controleEstoqueCedulas.inserirCedulasValor5(gerenciadorInput.getValorEntrado());
        
        gerenciadorInterface.imprimirPerguntaQuantidadeNotasValor10();
        gerenciadorInput.lerEntradaUsuario();
        controleEstoqueCedulas.inserirCedulasValor10(gerenciadorInput.getValorEntrado());
        
        gerenciadorInterface.imprimirPerguntaQuantidadeNotasValor20();
        gerenciadorInput.lerEntradaUsuario();
        controleEstoqueCedulas.inserirCedulasValor20(gerenciadorInput.getValorEntrado());
        
        gerenciadorInterface.imprimirPerguntaQuantidadeNotasValor50();
        gerenciadorInput.lerEntradaUsuario();
        controleEstoqueCedulas.inserirCedulasValor50(gerenciadorInput.getValorEntrado());
        
        gerenciadorInterface.imprimirPerguntaQuantidadeNotasValor100();
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
