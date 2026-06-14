package prova.clinica;

import prova.clinica.decorator.ServicoVeterinario;
import prova.clinica.observer.AtendimentoObserver;
import prova.clinica.state.Agendado;
import prova.clinica.state.SituacaoAtendimento;

import java.util.ArrayList;
import java.util.List;

public class Atendimento implements AtendimentoContext {

    private final String id;
    private final String tutorNome;
    private final String animalNome;
    private ServicoVeterinario servico;
    private SituacaoAtendimento situacao;
    private final List<AtendimentoObserver> observers = new ArrayList<>();

    public Atendimento(String id, String tutorNome, String animalNome, ServicoVeterinario servico) {
        this.id         = id;
        this.tutorNome  = tutorNome;
        this.animalNome = animalNome;
        this.servico    = servico;
        this.situacao   = new Agendado();
    }

    public void iniciar()   { situacao.iniciar(this); }
    public void finalizar() { situacao.finalizar(this); }
    public void cancelar()  { situacao.cancelar(this); }

    public void adicionarObserver(AtendimentoObserver o) { observers.add(o); }
    public void removerObserver(AtendimentoObserver o)   { observers.remove(o); }

    @Override
    public void notificarObservers() {
        observers.forEach(o -> o.atualizar(this));
    }

    @Override public String getId()          { return id; }
    @Override public String getTutorNome()   { return tutorNome; }
    @Override public String getAnimalNome()  { return animalNome; }
    @Override public double getValorFinal()  { return servico.getValor(); }
    @Override public SituacaoAtendimento getSituacao() { return situacao; }

    @Override
    public void setSituacao(SituacaoAtendimento situacao) { this.situacao = situacao; }
}
