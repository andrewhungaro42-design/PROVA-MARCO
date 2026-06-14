package prova.clinica.observer;

import prova.clinica.decorator.ServicoVeterinario;
import prova.clinica.state.Agendado;
import prova.clinica.state.SituacaoAtendimento;

import java.util.Observable;

public class Atendimento extends Observable {

    private String id;
    private String tutorNome;
    private String animalNome;
    private ServicoVeterinario servico;
    private SituacaoAtendimento situacao;

    public Atendimento(String id, String tutorNome, String animalNome, ServicoVeterinario servico) {
        this.id = id;
        this.tutorNome = tutorNome;
        this.animalNome = animalNome;
        this.servico = servico;
        this.situacao = Agendado.getInstance();
    }

    public boolean iniciar() {
        return situacao.iniciar(this);
    }

    public boolean finalizar() {
        return situacao.finalizar(this);
    }

    public boolean cancelar() {
        return situacao.cancelar(this);
    }

    public void notificarObservers() {
        setChanged();
        notifyObservers();
    }

    public String getId() {
        return id;
    }

    public String getTutorNome() {
        return tutorNome;
    }

    public String getAnimalNome() {
        return animalNome;
    }

    public double getValorFinal() {
        return servico.getValor();
    }

    public SituacaoAtendimento getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoAtendimento situacao) {
        this.situacao = situacao;
    }
}
