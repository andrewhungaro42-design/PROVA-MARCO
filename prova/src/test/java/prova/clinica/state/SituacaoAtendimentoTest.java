package prova.clinica.state;

import prova.clinica.decorator.ConsultaBase;
import prova.clinica.observer.Atendimento;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SituacaoAtendimentoTest {

    Atendimento atendimento;

    @Before
    public void setUp() {
        atendimento = new Atendimento("AT-001", "Maria Silva", "Rex",
                          new ConsultaBase("Consulta geral", 150.0));
    }

    // Estado inicial

    @Test
    public void situacaoInicialDeveSerAgendado() {
        assertEquals(Agendado.getInstance(), atendimento.getSituacao());
    }

    // Agendado

    @Test
    public void deveIniciarAtendimentoAgendado() {
        assertTrue(atendimento.iniciar());
        assertEquals(EmAtendimento.getInstance(), atendimento.getSituacao());
    }

    @Test
    public void deveCancelarAtendimentoAgendado() {
        assertTrue(atendimento.cancelar());
        assertEquals(Cancelado.getInstance(), atendimento.getSituacao());
    }

    @Test
    public void naoDeveFinalizarAtendimentoAgendado() {
        assertFalse(atendimento.finalizar());
    }

    // EmAtendimento

    @Test
    public void deveFinalizarAtendimentoEmAndamento() {
        atendimento.iniciar();
        assertTrue(atendimento.finalizar());
        assertEquals(Finalizado.getInstance(), atendimento.getSituacao());
    }

    @Test
    public void naoDeveIniciarAtendimentoEmAndamento() {
        atendimento.iniciar();
        assertFalse(atendimento.iniciar());
    }

    @Test
    public void naoDeveCancelarAtendimentoEmAndamento() {
        atendimento.iniciar();
        assertFalse(atendimento.cancelar());
    }

    // Finalizado

    @Test
    public void naoDeveIniciarAtendimentoFinalizado() {
        atendimento.iniciar();
        atendimento.finalizar();
        assertFalse(atendimento.iniciar());
    }

    @Test
    public void naoDeveFinalizarAtendimentoFinalizado() {
        atendimento.iniciar();
        atendimento.finalizar();
        assertFalse(atendimento.finalizar());
    }

    @Test
    public void naoDeveCancelarAtendimentoFinalizado() {
        atendimento.iniciar();
        atendimento.finalizar();
        assertFalse(atendimento.cancelar());
    }

    // Cancelado

    @Test
    public void naoDeveIniciarAtendimentoCancelado() {
        atendimento.cancelar();
        assertFalse(atendimento.iniciar());
    }

    @Test
    public void naoDeveFinalizarAtendimentoCancelado() {
        atendimento.cancelar();
        assertFalse(atendimento.finalizar());
    }

    @Test
    public void naoDeveCancelarAtendimentoCancelado() {
        atendimento.cancelar();
        assertFalse(atendimento.cancelar());
    }
}
