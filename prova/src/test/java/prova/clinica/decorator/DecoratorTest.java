package prova.clinica.decorator;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecoratorTest {

    private static final double DELTA = 0.001;

    @Test
    public void deveRetornarValorConsultaBase() {
        ServicoVeterinario servico = new ConsultaBase("Consulta geral", 200.0);

        assertEquals(200.0, servico.getValor(), DELTA);
        assertEquals("Consulta geral", servico.getDescricao());
    }

    @Test
    public void deveRetornarValorComDescontoAdotado() {
        ServicoVeterinario servico = new DescontoAdotado(new ConsultaBase("Consulta geral", 200.0));

        assertEquals(170.0, servico.getValor(), DELTA);
    }

    @Test
    public void deveRetornarValorComTaxaDomiciliar() {
        ServicoVeterinario servico = new TaxaDomiciliar(new ConsultaBase("Consulta geral", 200.0));

        assertEquals(280.0, servico.getValor(), DELTA);
    }

    @Test
    public void deveRetornarValorComBanhoPosConsulta() {
        ServicoVeterinario servico = new BanhoPosConsulta(new ConsultaBase("Consulta geral", 200.0));

        assertEquals(250.0, servico.getValor(), DELTA);
    }

    @Test
    public void deveRetornarValorComDescontoMaisTaxa() {
        // 200 * 0.85 = 170; 170 + 80 = 250
        ServicoVeterinario servico = new TaxaDomiciliar(
            new DescontoAdotado(new ConsultaBase("Consulta ortopedica", 200.0))
        );

        assertEquals(250.0, servico.getValor(), DELTA);
    }

    @Test
    public void deveRetornarValorComTodasAsRegrasCombinadas() {
        // 200 * 0.85 = 170; +80 = 250; +50 = 300
        ServicoVeterinario servico = new BanhoPosConsulta(
            new TaxaDomiciliar(
                new DescontoAdotado(new ConsultaBase("Consulta ortopedica", 200.0))
            )
        );

        assertEquals(300.0, servico.getValor(), DELTA);
    }

    @Test
    public void deveRetornarDescricaoComDecoratorsAplicados() {
        ServicoVeterinario servico = new BanhoPosConsulta(
            new TaxaDomiciliar(
                new DescontoAdotado(new ConsultaBase("Consulta ortopedica", 200.0))
            )
        );

        String descricao = servico.getDescricao();
        assertTrue(descricao.contains("Consulta ortopedica"));
        assertTrue(descricao.contains("Desconto adotado"));
        assertTrue(descricao.contains("Taxa domiciliar"));
        assertTrue(descricao.contains("Banho pos-consulta"));
    }
}
