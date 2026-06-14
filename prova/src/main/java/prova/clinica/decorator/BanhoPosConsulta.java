package prova.clinica.decorator;

public class BanhoPosConsulta extends ServicoDecorator {

    public BanhoPosConsulta(ServicoVeterinario servico) {
        super(servico);
    }

    public double getAcrescimo() {
        return 50.0;
    }

    public String getNomeServico() {
        return "Banho pos-consulta (+R$50,00)";
    }
}
