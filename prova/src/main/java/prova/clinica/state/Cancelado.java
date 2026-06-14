package prova.clinica.state;

public class Cancelado extends SituacaoAtendimento {

    private Cancelado() {}
    private static Cancelado instance = new Cancelado();
    public static Cancelado getInstance() {
        return instance;
    }

    public String getNome() {
        return "Cancelado";
    }
}
