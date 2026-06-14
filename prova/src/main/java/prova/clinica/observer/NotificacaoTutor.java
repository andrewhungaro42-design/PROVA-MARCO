package prova.clinica.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class NotificacaoTutor implements Observer {

    private List<String> mensagens = new ArrayList<>();

    public void registrar(Atendimento atendimento) {
        atendimento.addObserver(this);
    }

    public void update(Observable atendimentoObs, Object arg) {
        Atendimento atendimento = (Atendimento) atendimentoObs;
        if ("EmAtendimento".equals(atendimento.getSituacao().getNome())) {
            mensagens.add("Tutor " + atendimento.getTutorNome()
                + ": atendimento de " + atendimento.getAnimalNome() + " iniciado.");
        }
    }

    public List<String> getMensagens() {
        return mensagens;
    }
}
