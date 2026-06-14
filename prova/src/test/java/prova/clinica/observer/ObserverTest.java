package prova.clinica.observer;

import prova.clinica.decorator.ConsultaBase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObserverTest {

    private Atendimento atendimento;
    private NotificacaoTutor notifTutor;
    private NotificacaoVeterinario notifVet;
    private NotificacaoRecepcao notifRecepcao;

    @Before
    public void setUp() {
        atendimento = new Atendimento("AT-003", "Ana Souza", "Bolinha",
                          new ConsultaBase("Consulta geral", 120.0));

        notifTutor    = new NotificacaoTutor();
        notifVet      = new NotificacaoVeterinario();
        notifRecepcao = new NotificacaoRecepcao();

        notifTutor.registrar(atendimento);
        notifVet.registrar(atendimento);
        notifRecepcao.registrar(atendimento);
    }

    @Test
    public void semNotificacoesNoEstadoInicial() {
        assertEquals(0, notifTutor.getMensagens().size());
        assertEquals(0, notifVet.getMensagens().size());
        assertEquals(0, notifRecepcao.getMensagens().size());
    }

    @Test
    public void tutorRecebeNotificacaoAoIniciar() {
        atendimento.iniciar();

        assertEquals(1, notifTutor.getMensagens().size());
        assertEquals(
            "Tutor Ana Souza: atendimento de Bolinha iniciado.",
            notifTutor.getMensagens().get(0)
        );
    }

    @Test
    public void recepcaoRecebeNotificacaoAoFinalizar() {
        atendimento.iniciar();
        atendimento.finalizar();

        assertEquals(1, notifRecepcao.getMensagens().size());
        assertEquals(
            "Recepcao: atendimento de Bolinha finalizado. Valor: R$120.00",
            notifRecepcao.getMensagens().get(0)
        );
    }

    @Test
    public void veterinarioRecebeNotificacaoAoCancelar() {
        atendimento.cancelar();

        assertEquals(1, notifVet.getMensagens().size());
        assertEquals(
            "Veterinario avisado: atendimento de Bolinha cancelado.",
            notifVet.getMensagens().get(0)
        );
    }

    @Test
    public void tutorNaoENotificadoAoFinalizar() {
        atendimento.iniciar();
        int qtdAposIniciar = notifTutor.getMensagens().size();
        atendimento.finalizar();

        assertEquals(qtdAposIniciar, notifTutor.getMensagens().size());
    }

    @Test
    public void observerRemovidoNaoRecebeNotificacao() {
        atendimento.deleteObserver(notifTutor);
        atendimento.iniciar();

        assertEquals(0, notifTutor.getMensagens().size());
    }
}
