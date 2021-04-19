package statusVacinacao;

import entidades.Pessoa;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TomadaPrimeiraDose extends StatusVacinacao{
    @Override
    public String getStatus() {
        return "Pessoa já tomou a primeira dose";
    }

    @Override
    public String tomaPrimeiraDose(Pessoa pessoa, String dataPrimeiraDose) {
        return "Pessoa já tomou a primeira dose, não pode tomá-la novamente";
    }

    @Override
    public String tomaSegundaDose(Pessoa pessoa, String dataSegundaDose) {
        return "Pessoa não está habilitada para tomar a segunda dose";
    }

    @Override
    public void verificaStatus(Pessoa pessoa) {
        if (ChronoUnit.DAYS.between(pessoa.getPrimeiraDose(), LocalDate.now()) >= 20) {
            pessoa.setStatusAtual(new HabilitadaSegundaDose());
        }
    }
}
