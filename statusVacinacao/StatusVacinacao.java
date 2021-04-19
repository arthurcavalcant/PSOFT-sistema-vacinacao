package statusVacinacao;

import entidades.Pessoa;

import java.util.Set;

public abstract class StatusVacinacao {

    protected Set<String> comorbidadesProritarias;
    protected Set<String> profissoesProritarias;
    protected int idadeMinima;

    public abstract String getStatus();
    public abstract String tomaPrimeiraDose(Pessoa pessoa, String dataPrimeiraDose);
    public abstract String tomaSegundaDose(Pessoa pessoa, String dataSegundaDose);
    public abstract void verificaStatus(Pessoa pessoa);

    public void setComorbidadesProritarias(Set<String> comorbidadesProritarias) {
        this.comorbidadesProritarias = comorbidadesProritarias;
    }

    public void setProfissoesProritarias(Set<String> profissoesProritarias) {
        this.profissoesProritarias = profissoesProritarias;
    }

    public void setIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }
}
