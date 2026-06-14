package prova.clinica.state;

public class Finalizado extends SituacaoAtendimento {

    private Finalizado() {}
    private static Finalizado instance = new Finalizado();
    public static Finalizado getInstance() {
        return instance;
    }

    public String getNome() {
        return "Finalizado";
    }
}
