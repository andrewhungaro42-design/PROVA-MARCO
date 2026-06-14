package prova.clinica.decorator;

public class DescontoAdotado extends ServicoDecorator {

    public DescontoAdotado(ServicoVeterinario servico) {
        super(servico);
    }

    public double getAcrescimo() {
        return this.getServico().getValor() * -0.15;
    }

    public String getNomeServico() {
        return "Desconto adotado (-15%)";
    }
}
