package prova.clinica.decorator;

public class TaxaDomiciliar extends ServicoDecorator {

    public TaxaDomiciliar(ServicoVeterinario servico) {
        super(servico);
    }

    public double getAcrescimo() {
        return 80.0;
    }

    public String getNomeServico() {
        return "Taxa domiciliar (+R$80,00)";
    }
}
