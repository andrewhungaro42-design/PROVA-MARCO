package prova.clinica.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class NotificacaoVeterinario implements Observer {

    private List<String> mensagens = new ArrayList<>();

    public void registrar(Atendimento atendimento) {
        atendimento.addObserver(this);
    }

    public void update(Observable atendimentoObs, Object arg) {
        Atendimento atendimento = (Atendimento) atendimentoObs;
        if ("Cancelado".equals(atendimento.getSituacao().getNome())) {
            mensagens.add("Veterinario avisado: atendimento de "
                + atendimento.getAnimalNome() + " cancelado.");
        }
    }

    public List<String> getMensagens() {
        return mensagens;
    }
}
