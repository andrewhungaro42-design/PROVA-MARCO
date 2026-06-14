package prova.clinica.state;

import prova.clinica.observer.Atendimento;

public class Agendado extends SituacaoAtendimento {

    public Agendado() {}
    private static Agendado instance = new Agendado();
    public static Agendado getInstance() {
        return instance;
    }

    public String getNome() {
        return "Agendado";
    }

    public boolean iniciar(Atendimento atendimento) {
        atendimento.setSituacao(EmAtendimento.getInstance());
        atendimento.notificarObservers();
        return true;
    }

    public boolean cancelar(Atendimento atendimento) {
        atendimento.setSituacao(Cancelado.getInstance());
        atendimento.notificarObservers();
        return true;
    }
}
