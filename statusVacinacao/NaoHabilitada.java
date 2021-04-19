package statusVacinacao;

import entidades.Pessoa;

import java.time.LocalDate;
import java.time.Period;

public class NaoHabilitada extends StatusVacinacao {
    @Override
    public String getStatus() {
        return "Não habilitada para vacina";
    }

    @Override
    public String tomaPrimeiraDose(Pessoa pessoa, String dataPrimeiraDose) {
        return "Pessoa não habilitada para vacina";
    }

    @Override
    public String tomaSegundaDose(Pessoa pessoa, String dataSegundaDose) {
        return "Pessoa não habilitada para vacina";
    }

    @Override
    public void verificaStatus(Pessoa pessoa) {
        Period periodo = Period.between(pessoa.getDataNascimento(), LocalDate.now());
        if (idadeMinima != 0 && periodo.getYears() >= idadeMinima) {
            pessoa.setStatusAtual(new HabilitadaPrimeiraDose());
        } else if (profissoesProritarias != null && profissoesProritarias.contains(pessoa.getProfissao())) {
                pessoa.setStatusAtual(new HabilitadaPrimeiraDose());
            }

        for (int i = 0; i < pessoa.getComorbidades().size(); i++) {
            if (comorbidadesProritarias != null && comorbidadesProritarias.contains(pessoa.getComorbidades().get(i))) {
                pessoa.setStatusAtual(new HabilitadaPrimeiraDose());
                break;
            }
        }
    }
}
