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

    private static void imprimirMenuPrincipal() {
        StringBuilder menuPrincipal = new StringBuilder();
        menuPrincipal.append("\n---------------------------------------\n");
        menuPrincipal.append("Caixa Eletrônico - Menu de Opções\n");
        menuPrincipal.append("---------------------------------------\n");
        menuPrincipal.append("1- Repor\n");
        menuPrincipal.append("2- Sacar\n");
        menuPrincipal.append("3- Consultar saldo\n");
        menuPrincipal.append("4- Fim\n");
        menuPrincipal.append("Opção: ");
        System.out.print(menuPrincipal);
    }

    private void consultarSaldo() {
        gerenciadorInterface.imprimirCabecalhoSaldo();
        gerenciadorInterface.imprimirSaldoTotal();
        gerenciadorInterface.imprimirQuantidadeDeSaques();
        gerenciadorInterface.imprimirValorTotalSaques();
        gerenciadorInterface.imprimirTotalCedulasValor5(controleEstoqueCedulas.getQuantidadeCedulasValor5);
        gerenciadorInterface.imprimirTotalCedulasValor10(controleEstoqueCedulas.getQuantidadeCedulasValor10);
        gerenciadorInterface.imprimirTotalCedulasValor20(controleEstoqueCedulas.getQuantidadeCedulasValor20);
        gerenciadorInterface.imprimirTotalCedulasValor50(controleEstoqueCedulas.getQuantidadeCedulasValor50);
        gerenciadorInterface.imprimirTotalCedulasValor100(controleEstoqueCedulas.getQuantidadeCedulasValor100);
    }

    private void sacarDinheiro() {
        GerenciadorInterface.imprimirCabecalhoSaque();
        gerenciadorInput.lerEntradaUsuario();
        try {
            transacaoSaque.efetuarSaque(gerenciadorInput.getValorEntrado());
            gerenciadorInterface.imprimirCabecalhoSaque();
            gerenciadorInterface.imprimirTotalCedulasValor5(transacaoSaque.getQuantidadeCedulasValor5Sacadas());
            gerenciadorInterface.imprimirTotalCedulasValor10(transacaoSaque.getQuantidadeCedulasValor10Sacadas());
            gerenciadorInterface.imprimirTotalCedulasValor20(transacaoSaque.getQuantidadeCedulasValor20Sacadas());
            gerenciadorInterface.imprimirTotalCedulasValor50(transacaoSaque.getQuantidadeCedulasValor50Sacadas());
            gerenciadorInterface.imprimirTotalCedulasValor100(transacaoSaque.getQuantidadeCedulasValor100Sacadas());
        } catch (Exception e) { //TODO criar exception para quantia inválida ou insuficiente E cédulas não é multiplo do valor solicitado
            //imprimir erro retornado pelo gerenciador de interface?
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
