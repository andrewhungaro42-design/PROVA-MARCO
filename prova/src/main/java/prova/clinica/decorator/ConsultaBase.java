package prova.clinica.decorator;

public class ConsultaBase implements ServicoVeterinario {

    public double valor;

    public ConsultaBase() {
    }

    public ConsultaBase(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String descricao;

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
