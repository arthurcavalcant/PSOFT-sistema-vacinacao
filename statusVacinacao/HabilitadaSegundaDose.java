package statusVacinacao;

import entidades.Pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HabilitadaSegundaDose extends StatusVacinacao{
    @Override
    public String getStatus() {
        return "Habilitada para a segunda dose (considerando que a diferença entre a data da primeira dose e a data de hoje é de pelo menos 20 dias)";
    }

    @Override
    public String tomaPrimeiraDose(Pessoa pessoa, String dataPrimeiraDose) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Pessoa já tomou a primeira dose da vacina no dia " + pessoa.getPrimeiraDose().format(formatter);
    }

    @Override
    public String tomaSegundaDose(Pessoa pessoa, String dataSegundaDose) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        pessoa.setSegundaDose(LocalDate.parse(dataSegundaDose, formatter));
        verificaStatus(pessoa);
        return "Pessoa tomou segunda dose da vacina no dia " + dataSegundaDose;
    }

    @Override
    public void verificaStatus(Pessoa pessoa) {
        if (pessoa.getSegundaDose() != null){
            pessoa.setStatusAtual(new TomadaSegundaDose());
        }
    }
}
