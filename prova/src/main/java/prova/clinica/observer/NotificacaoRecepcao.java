package prova.clinica.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class NotificacaoRecepcao implements Observer {

    private List<String> mensagens = new ArrayList<>();

    public void registrar(Atendimento atendimento) {
        atendimento.addObserver(this);
    }

    public void update(Observable atendimentoObs, Object arg) {
        Atendimento atendimento = (Atendimento) atendimentoObs;
        if ("Finalizado".equals(atendimento.getSituacao().getNome())) {
            mensagens.add("Recepcao: atendimento de " + atendimento.getAnimalNome()
                + " finalizado. Valor: R$" + String.format(java.util.Locale.US, "%.2f", atendimento.getValorFinal()));
        }
    }

    public List<String> getMensagens() {
        return mensagens;
    }
}
