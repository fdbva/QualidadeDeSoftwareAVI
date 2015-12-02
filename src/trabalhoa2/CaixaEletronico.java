package trabalhoa2;

public class CaixaEletronico {

    private ControleSaldo cs;
    private int qtdSaques;
    private float valorTotalSaques;

    public CaixaEletronico() {
        this.cs = new ControleSaldo();
        this.qtdSaques = 0;
        this.valorTotalSaques = 0;
    }
    
    public String getSaldo() {
        String retorno = "";
        retorno = "\n---------------------------------------";
        retorno = retorno + "\nCaixa Eletrônico - Consulta de Saldo";
        retorno = retorno + "\n---------------------------------------";
        retorno = retorno + "\nO Saldo é: " + String.valueOf(cs.getSaldo()) + "\nQuantidade de saques: ";
        retorno = retorno + String.valueOf(this.qtdSaques) + "\nValor dos saques: ";
        retorno = retorno + String.valueOf(this.valorTotalSaques)+ "\nTotal notas de 5: ";
        retorno = retorno + String.valueOf(cs.getQtdNota5())+ "\nTotal notas de 10: ";
        retorno = retorno + String.valueOf(cs.getQtdNota10())+ "\nTotal notas de 20: ";
        retorno = retorno + String.valueOf(cs.getQtdNota20())+ "\nTotal notas de 50: ";
        retorno = retorno + String.valueOf(cs.getQtdNota50())+ "\nTotal notas de 100: ";
        retorno = retorno + String.valueOf(cs.getQtdNota100())+ ".";        
                
        return retorno;
    }

    public void depositar(int qtdNota5, int qtdNota10, int qtdNota20, int qtdNota50, int qtdNota100) {
        cs.addNotas(qtdNota5, qtdNota10, qtdNota20, qtdNota50, qtdNota100);
    }

    public String sacar(int quantiaOriginal) {
        
        String retorno = "";
        int quantia = quantiaOriginal;
        if (quantia > 0 && cs.getSaldo() >= quantia)
        {
            int qtdNota5 = 0;
            int qtdNota10 = 0;
            int qtdNota20 = 0;
            int qtdNota50 = 0;
            int qtdNota100 = 0;
            
            if (quantia >= 100)
            {
                qtdNota100 = (int) Math.floor(quantia/100);
                
                if (cs.getQtdNota100()<qtdNota100)
                    qtdNota100 = cs.getQtdNota100();
                    
                quantia = quantia - qtdNota100*100;    
            }

            if (quantia >= 50) 
            {
                qtdNota50 = (int) Math.floor(quantia/50);
                
                if (cs.getQtdNota50()<qtdNota50)
                    qtdNota50 = cs.getQtdNota50();
                    
                quantia = quantia - qtdNota50*50;    
            }

            if (quantia >= 20)
            {
                qtdNota20 = (int) Math.floor(quantia/20);
                
                if (cs.getQtdNota20()<qtdNota20)
                    qtdNota20 = cs.getQtdNota20();
                    
                quantia = quantia - qtdNota20*20;    
            }
            if (quantia >= 10)
            {
                qtdNota10 = (int) Math.floor(quantia/10);
                
                if (cs.getQtdNota10()<qtdNota10)
                    qtdNota10 = cs.getQtdNota10();
                    
                quantia = quantia - qtdNota10*10;    
            }
            if (quantia >= 5)
            {
                qtdNota5 = (int) Math.floor(quantia/5);
                
                if (cs.getQtdNota5()<qtdNota5)
                    qtdNota5 = cs.getQtdNota5();
                    
                quantia = quantia - qtdNota5*5;    
            }
            
            if (quantia == 0)
            {
                retorno = "\n---------------------------------------";
                retorno = retorno + "\nCaixa Eletrônico - Saque";
                retorno = retorno + "\n---------------------------------------";
                retorno = retorno + "\nSaque realiazado com sucesso! ";
                retorno = retorno + "\nTotal notas de 5: ";
                retorno = retorno + String.valueOf(qtdNota5)+ "\nTotal notas de 10: ";
                retorno = retorno + String.valueOf(qtdNota10)+ "\nTotal notas de 20: ";
                retorno = retorno + String.valueOf(qtdNota20)+ "\nTotal notas de 50: ";
                retorno = retorno + String.valueOf(qtdNota50)+ "\nTotal notas de 100: ";
                retorno = retorno + String.valueOf(qtdNota100)+ ".";        
                
                this.qtdSaques += 1;
                this.valorTotalSaques += quantiaOriginal;
                cs.removeNotas(qtdNota5, qtdNota10, qtdNota20, qtdNota50, qtdNota100);
                
            }
            else
               retorno = "\nQuantidade de células não é múltiplo do valor solicitado";
                
                
        }
        else
            retorno = "\nQuantia inválida ou saldo insuficiente";
        
        return retorno;
    }
}
