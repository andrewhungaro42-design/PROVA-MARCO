package prova.clinica.state;

import prova.clinica.observer.Atendimento;

public abstract class SituacaoAtendimento {

    public abstract String getNome();

    public boolean iniciar(Atendimento atendimento) {
        return false;
    }

    public boolean finalizar(Atendimento atendimento) {
        return false;
    }

    public boolean cancelar(Atendimento atendimento) {
        return false;
    }

    public void iniciar(prova.clinica.Atendimento atendimento) {
    }

    public void finalizar(prova.clinica.Atendimento atendimento) {
    }

    public void cancelar(prova.clinica.Atendimento atendimento) {
    }
}
