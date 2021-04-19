package statusVacinacao;

import entidades.Pessoa;

import java.time.format.DateTimeFormatter;

public class TomadaSegundaDose extends StatusVacinacao{
    @Override
    public String getStatus() {
        return "Pessoa já finalizou a vacinação";
    }

    @Override
    public String tomaPrimeiraDose(Pessoa pessoa, String dataPrimeiraDose) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Pessoa já finalizou a vacinação. Tomou a primeira dose da vacina no dia " + pessoa.getPrimeiraDose().format(formatter);
    }

    @Override
    public String tomaSegundaDose(Pessoa pessoa, String dataSegundaDose) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Pessoa já finalizou a vacinação. Tomou a segunda dose da vacina no dia " + pessoa.getSegundaDose().format(formatter);
    }

    @Override
    public void verificaStatus(Pessoa pessoa) {
    }
}
