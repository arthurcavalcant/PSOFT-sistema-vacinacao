package controller;

import entidades.Pessoa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sistema {

    private Set<String> comorbidadesProritarias;
    private Set<String> profissoesProritarias;
    private Map<String, Pessoa> pessoas;
    private int idadeMinima;

    public Sistema(){
        this.comorbidadesProritarias = new HashSet<>();
        this.profissoesProritarias = new HashSet<>();
        this.pessoas = new HashMap<>();
    }


    public String cadastraPessoa(String nome, String cpf, String endereco, String numeroCartao, String email, String telefone, String profissao, String comorbidades, String dataNascimento) {
        Pessoa pessoa = new Pessoa(nome, cpf, endereco, numeroCartao, email, telefone, profissao, comorbidades, dataNascimento);
        this.pessoas.put(cpf, pessoa);
        atualizaStatusTodosCriterios(pessoa);
        return pessoa.cadastroCompleto();
    }

    public void configuraIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
        this.pessoas.forEach((Pessoa, pessoa) -> pessoa.verificaStatusIdade(this.idadeMinima));
    }

    public void adicionaComorbidade(String comorbidade) {
        this.comorbidadesProritarias.add(comorbidade);
        this.pessoas.forEach((Pessoa, pessoa) -> pessoa.verificaStatusComorbidade(this.comorbidadesProritarias));
    }

    public void adicionaProfissao(String profissao) {
        this.profissoesProritarias.add(profissao);
        this.pessoas.forEach((Pessoa, pessoa) -> pessoa.verificaStatusProfissao(this.profissoesProritarias));
    }

    public String verificaStatus(String cpf) {
        return this.pessoas.get(cpf).getStatusAtual();
    }

    private void atualizaStatusTodosCriterios(Pessoa pessoa){
        pessoa.verificaStatusIdade(this.idadeMinima);
        pessoa.verificaStatusComorbidade(this.comorbidadesProritarias);
        pessoa.verificaStatusProfissao(this.profissoesProritarias);
    }

    public String editaPessoa(String cpf, String endereco, String numeroCartao, String email, String telefone) {
        this.pessoas.get(cpf).atualizaCadastro(endereco, numeroCartao, email, telefone);
        return this.pessoas.get(cpf).cadastroCompleto();
    }

    public String cadastraPrimeiraDose(String cpf, String dataPrimeiraDose) {
        return this.pessoas.get(cpf).tomaPrimeiraDose(dataPrimeiraDose);
    }

    public String cadastraSegundaDose(String cpf, String dataSegundaDose) {
        return this.pessoas.get(cpf).tomaSegundaDose(dataSegundaDose);
    }

    public String listaTodasPessoas() {
        String lista = "";
        for (Pessoa pessoa : this.pessoas.values()){
            lista += (pessoa.toString() + System.lineSeparator());
        }
        return lista;
    }

    public void editaComorbidadesPessoa(String cpf, String comorbidades) {
        this.pessoas.get(cpf).setComorbidades(comorbidades);
    }

    public void editaProfissaoPessoa(String cpf, String profissao) {
        this.pessoas.get(cpf).setProfissao(profissao);
    }
}
