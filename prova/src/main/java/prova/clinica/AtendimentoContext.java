package prova.clinica;

import prova.clinica.state.SituacaoAtendimento;

public interface AtendimentoContext {
    String getId();
    String getTutorNome();
    String getAnimalNome();
    double getValorFinal();
    SituacaoAtendimento getSituacao();
    void setSituacao(SituacaoAtendimento situacao);
    void notificarObservers();
}
