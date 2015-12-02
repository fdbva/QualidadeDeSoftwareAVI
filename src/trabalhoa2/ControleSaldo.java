package trabalhoa2;

public class ControleSaldo {

    private int qtdNota5;
    private int qtdNota10;
    private int qtdNota20;
    private int qtdNota50;
    private int qtdNota100;

    public ControleSaldo() {
        this.qtdNota5=0;
        this.qtdNota10=0;
        this.qtdNota20=0;
        this.qtdNota50=0;
        this.qtdNota100=0;
    }
    
    public void addNotas(int qtdNota5, int qtdNota10, int qtdNota20, int qtdNota50, int qtdNota100) {
        this.qtdNota5+=qtdNota5;
        this.qtdNota10+=qtdNota10;
        this.qtdNota20+=qtdNota20;
        this.qtdNota50+=qtdNota50;
        this.qtdNota100+=qtdNota100;
    }

     public void removeNotas(int qtdNota5, int qtdNota10, int qtdNota20, int qtdNota50, int qtdNota100) {
        this.qtdNota5-=qtdNota5;
        this.qtdNota10-=qtdNota10;
        this.qtdNota20-=qtdNota20;
        this.qtdNota50-=qtdNota50;
        this.qtdNota100-=qtdNota100;
    }
    public float getSaldo() {
        return this.qtdNota5*5+qtdNota10*10+qtdNota20*20+qtdNota50*50+qtdNota100*100;
    }

    public int getQtdNota5() {
        return this.qtdNota5;
    }

    public int getQtdNota10() {
        return this.qtdNota10;
    }
    
    public int getQtdNota20() {
        return this.qtdNota20;
    }
    public int getQtdNota50() {
        return this.qtdNota50;
    }
    public int getQtdNota100() {
        return this.qtdNota100;
    }
}
