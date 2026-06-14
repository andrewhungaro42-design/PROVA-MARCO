package prova.clinica.decorator;

public abstract class ServicoDecorator implements ServicoVeterinario {

    private ServicoVeterinario servico;

    public ServicoDecorator(ServicoVeterinario servico) {
        this.servico = servico;
    }

    public ServicoVeterinario getServico() {
        return servico;
    }

    public void setServico(ServicoVeterinario servico) {
        this.servico = servico;
    }

    public abstract double getAcrescimo();

    public double getValor() {
        return this.servico.getValor() + this.getAcrescimo();
    }

    public abstract String getNomeServico();

    public String getDescricao() {
        return this.servico.getDescricao() + " + " + this.getNomeServico();
    }
}
