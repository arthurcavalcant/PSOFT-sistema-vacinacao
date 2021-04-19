package entidades;

import statusVacinacao.NaoHabilitada;
import statusVacinacao.StatusVacinacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Pessoa {

    private String nome;
    private String cpf;
    private String endereco;
    private String numeroCartao;
    private String email;
    private String telefone;
    private String profissao;
    private List<String> comorbidades;
    private LocalDate dataNascimento;
    private LocalDate primeiraDose;
    private LocalDate segundaDose;
    private StatusVacinacao statusAtual;

    public Pessoa(String nome, String cpf, String endereco, String numeroCartao, String email, String telefone, String profissao, String comorbidades, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numeroCartao = numeroCartao;
        this.email = email;
        this.telefone = telefone;
        this.profissao = profissao;
        this.comorbidades = Arrays.asList(comorbidades.split(", "));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
        this.statusAtual = new NaoHabilitada();
    }


    public String getStatusAtual() {
        statusAtual.verificaStatus(this);
        return statusAtual.getStatus();
    }

    public void verificaStatusIdade(int idadeMinima) {
        statusAtual.setIdadeMinima(idadeMinima);
        statusAtual.verificaStatus(this);
    }

    public void verificaStatusComorbidade(Set<String> comorbidadesProritarias) {
        statusAtual.setComorbidadesProritarias(comorbidadesProritarias);
        statusAtual.verificaStatus(this);
    }

    public void verificaStatusProfissao(Set<String> profissoesProritarias) {
        statusAtual.setProfissoesProritarias(profissoesProritarias);
        statusAtual.verificaStatus(this);
    }

    public void setStatusAtual(StatusVacinacao novoStatusAtual) {
        this.statusAtual = novoStatusAtual;
    }

    public LocalDate getPrimeiraDose() {
        return primeiraDose;
    }

    public LocalDate getSegundaDose() {
        return segundaDose;
    }

    public void setPrimeiraDose(LocalDate primeiraDose) {
        this.primeiraDose = primeiraDose;
    }

    public void setSegundaDose(LocalDate segundaDose) {
        this.segundaDose = segundaDose;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public List<String> getComorbidades() {
        return comorbidades;
    }

    public String tomaPrimeiraDose(String dataPrimeiraDose) {

        return this.statusAtual.tomaPrimeiraDose(this, dataPrimeiraDose);
    }

    public String tomaSegundaDose(String dataSegundaDose) {
        return this.statusAtual.tomaSegundaDose(this, dataSegundaDose);
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setComorbidades(String comorbidades) {
        this.comorbidades = Arrays.asList(comorbidades.split(", "));
    }

    @Override
    public String toString() {
        return nome + " - CPF(" + cpf + ") - " + profissao + " - " + "comorbidades: " + comorbidades + " - " + this.getStatusAtual();
    }

    public void atualizaCadastro(String endereco, String numeroCartao, String email, String telefone) {
        this.endereco = endereco;
        this.numeroCartao = numeroCartao;
        this.email = email;
        this.telefone = telefone;
    }

    public String cadastroCompleto() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return  "nome = '" + nome + '\'' +
                ", cpf = '" + cpf + '\'' +
                ", endereco = '" + endereco + '\'' +
                ", numeroCartao = '" + numeroCartao + '\'' +
                ", email = '" + email + '\'' +
                ", telefone = '" + telefone + '\'' +
                ", profissao = '" + profissao + '\'' +
                ", comorbidades = " + comorbidades +
                ", data de nascimento = " + dataNascimento.format(formatter) +
                ", status atual = " + getStatusAtual();
    }
}
