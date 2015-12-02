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
class GerenciadorInterface {

    static void imprimirCabecalhoSaque() {
        StringBuilder cabecalhoSaque = new StringBuilder();
        cabecalhoSaque.append("\n---------------------------------------\n");
        cabecalhoSaque.append("\nCaixa Eletrônico - Saque\n");
        cabecalhoSaque.append("\n---------------------------------------\n");
        cabecalhoSaque.append("\nSaque realiazado com sucesso! \n");
        System.out.print(cabecalhoSaque);
    }

    static void imprimirCabecalhoSaldo() {
        StringBuilder cabecalhoSaldo = new StringBuilder();
        cabecalhoSaldo.append("\n---------------------------------------\n");
        cabecalhoSaldo.append("\nCaixa Eletrônico - Consulta de Saldo\n");
        cabecalhoSaldo.append("\n---------------------------------------\n");
        cabecalhoSaldo.append("\nSaque realiazado com sucesso! \n");
        System.out.print(cabecalhoSaldo);
    }

    static void imprimirSaldoTotal(int saldo) {
        imprimirTotal("\nO Saldo é: ", saldo);
    }

    static void imprimirQuantidadeDeSaques(int quantidadeSaques) {
        imprimirTotal("\nQuantidade de saques: ", quantidadeSaques);
    }
    static void imprimirValorTotalSaques(int totalSaques) {
        imprimirTotal("\nValor dos saques: ", totalSaques);
    }
    
    private static void imprimirTotal(String tipoTotal, int total){ //rever nomes
        StringBuilder mensagem = new StringBuilder();
        mensagem.append(tipoTotal);
        mensagem.append(total);
        System.out.println(mensagem);
    }

    static void imprimirCabecalhoReposicaoEstoque() {
        StringBuilder cabecalhoSaque = new StringBuilder();
        cabecalhoSaque.append("\n---------------------------------------\n");
        cabecalhoSaque.append("Caixa Eletrônico - Reposição de notas\n");
        cabecalhoSaque.append("\n---------------------------------------\n");
        System.out.print(cabecalhoSaque);
    }

    static void imprimirPerguntaQuantidadeNotasValor5() {
        System.out.print("Informa quantidade de notas de 5 reais: ");
    }

    static void imprimirPerguntaQuantidadeNotasValor10() {
        System.out.print("Informa quantidade de notas de 10 reais: ");
    }

    static void imprimirPerguntaQuantidadeNotasValor20() {
        System.out.print("Informa quantidade de notas de 20 reais: ");
    }

    static void imprimirPerguntaQuantidadeNotasValor50() {
        System.out.print("Informa quantidade de notas de 50 reais: ");
    }

    static void imprimirPerguntaQuantidadeNotasValor100() {
        System.out.print("Informa quantidade de notas de 100 reais: ");
    }

    static void imprimirQuantidadeCedulasValor5(int quantidadeCedulas) {
        imprimirQuantidadeCedulas("5", quantidadeCedulas);
    }
    static void imprimirQuantidadeCedulasValor10(int quantidadeCedulas) {
        imprimirQuantidadeCedulas("10", quantidadeCedulas);
    }
    static void imprimirQuantidadeCedulasValor20(int quantidadeCedulas) {
        imprimirQuantidadeCedulas("20", quantidadeCedulas);
    }
    static void imprimirQuantidadeCedulasValor50(int quantidadeCedulas) {
        imprimirQuantidadeCedulas("50", quantidadeCedulas);
    }
    static void imprimirQuantidadeCedulasValor100(int quantidadeCedulas) {
        imprimirQuantidadeCedulas("100", quantidadeCedulas);
        System.out.println("."); //println ou print?
    }
    static private void imprimirQuantidadeCedulas(String valor, int quantidadeCedulas){
        StringBuilder CedulasValor = new StringBuilder();
        CedulasValor.append("\nTotal notas de ");
        CedulasValor.append(valor);
        CedulasValor.append(": ");
        CedulasValor.append(quantidadeCedulas);
        System.out.print(CedulasValor);
    }

    static void imprimirMenuPrincipal() { //TODO: passar variavel para campo da classe e transformar em singleton?
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
    
}
