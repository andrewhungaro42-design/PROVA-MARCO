package prova.clinica.state;

import prova.clinica.observer.Atendimento;

public class EmAtendimento extends SituacaoAtendimento {

    private EmAtendimento() {}
    private static EmAtendimento instance = new EmAtendimento();
    public static EmAtendimento getInstance() {
        return instance;
    }

    public String getNome() {
        return "EmAtendimento";
    }

    public boolean finalizar(Atendimento atendimento) {
        atendimento.setSituacao(Finalizado.getInstance());
        atendimento.notificarObservers();
        return true;
    }
}
