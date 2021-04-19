package statusVacinacao;

import entidades.Pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HabilitadaPrimeiraDose extends StatusVacinacao{
    @Override
    public String getStatus() {
                return "Habilitada para a primeira dose";
    }

    @Override
    public String tomaPrimeiraDose(Pessoa pessoa, String dataPrimeiraDose) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        pessoa.setPrimeiraDose(LocalDate.parse(dataPrimeiraDose, formatter));
        verificaStatus(pessoa);
        return "Pessoa tomou primeira dose da vacina no dia " + dataPrimeiraDose;
    }

    @Override
    public String tomaSegundaDose(Pessoa pessoa, String dataSegundaDose) {
        return "Pessoa não habilitada para segunda dose da vacina";
    }

    @Override
    public void verificaStatus(Pessoa pessoa) {
        if (pessoa.getPrimeiraDose() != null){
            pessoa.setStatusAtual(new TomadaPrimeiraDose());
        }
    }
}
