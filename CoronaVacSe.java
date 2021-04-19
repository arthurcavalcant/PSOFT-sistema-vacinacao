import controller.Sistema;

import java.util.Scanner;


public class CoronaVacSe {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        boolean finished = false;

        while (!finished) {
            imprimeMenu();
            finished = comandos(sistema, false);
        }

        System.out.println("Encerrando a aplicação...");
    }

    private static boolean comandos(Sistema sistema, boolean finished) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        input.nextLine();
        switch (num) {
            case 1:
                System.out.print("Nome da pessoa: ");
                String nome = input.nextLine();
                System.out.print("CPF da pessoa: ");
                String cpf = input.nextLine();
                System.out.print("Endereço da pessoa: ");
                String endereco = input.nextLine();
                System.out.print("Número do cartão do SUS da pessoa: ");
                String numeroCartao = input.nextLine();
                System.out.print("E-mail da pessoa: ");
                String email = input.nextLine();
                System.out.print("Telefone da pessoa: ");
                String telefone = input.nextLine();
                System.out.print("Profissão da pessoa: ");
                String profissao = input.nextLine();
                System.out.print("Comorbidades da pessoa (separe normalmente por vírgulas): ");
                String comorbidades = input.nextLine();
                System.out.print("Data de nascimento da pessoa: ");
                String dataNascimento = input.nextLine();
                System.out.println(sistema.cadastraPessoa(nome, cpf, endereco, numeroCartao, email, telefone, profissao,
                        comorbidades, dataNascimento));
                break;
            case 2:
                System.out.print("CPF da pessoa: ");
                cpf = input.nextLine();
                System.out.print("Nova(s) comorbidades (separe normalmente por vírgulas e lembre-se que isso irá substituir as previamente cadastradas): ");
                comorbidades = input.nextLine();
                sistema.editaComorbidadesPessoa(cpf, comorbidades);
                break;
            case 3:
                System.out.print("CPF da pessoa: ");
                cpf = input.nextLine();
                System.out.print("Profissao: ");
                profissao = input.nextLine();
                sistema.editaProfissaoPessoa(cpf, profissao);
                break;
            case 4:
                System.out.println("Caso alguma das informações não tenha mudado, apenas repita a informação em seu respectivo campo");
                System.out.print("CPF da pessoa: ");
                cpf = input.nextLine();
                System.out.print("Endereço da pessoa: ");
                endereco = input.nextLine();
                System.out.print("Número do cartão do SUS da pessoa: ");
                numeroCartao = input.nextLine();
                System.out.print("E-mail da pessoa: ");
                email = input.nextLine();
                System.out.print("Telefone da pessoa: ");
                telefone = input.nextLine();
                System.out.print("Profissão da pessoa: ");
                System.out.println(sistema.editaPessoa(cpf, endereco, numeroCartao, email, telefone));
                break;
            case 5:
                System.out.print("CPF da pessoa: ");
                cpf = input.nextLine();
                System.out.print("Data da primeira dose: ");
                String dataPrimeiraDose = input.nextLine();
                System.out.println(sistema.cadastraPrimeiraDose(cpf, dataPrimeiraDose));
                break;
            case 6:
                System.out.print("CPF da pessoa: ");
                cpf = input.nextLine();
                System.out.print("Data da segunda dose: ");
                String dataSegundaDose = input.nextLine();
                System.out.println(sistema.cadastraSegundaDose(cpf, dataSegundaDose));
                break;
            case 7:
                int idadeMinima = input.nextInt();
                sistema.configuraIdadeMinima(idadeMinima);
                break;
            case 8:
                String comorbidadePrioritaria = input.nextLine();
                sistema.adicionaComorbidade(comorbidadePrioritaria);
                break;
            case 9:
                String profissaoPrioritaria = input.nextLine();
                sistema.adicionaProfissao(profissaoPrioritaria);
                break;
            case 10:
                System.out.print("CPF da pessoa: ");
                String cpfCadastrado = input.nextLine();
                System.out.println(sistema.verificaStatus(cpfCadastrado));
                break;
            case 11:
                System.out.println();
                System.out.println(sistema.listaTodasPessoas());
                break;
            case 12:
                finished = true;
                break;
            default:
                System.out.println("Opção indisponível!");
        }
        return finished;
    }

    private static void imprimeMenu() {
        System.out.println("Opções disponíveis:");
        System.out.println("1 - Cadastrar uma pessoa");
        System.out.println("2 - Editar comorbidades no cadastro de uma pessoa");
        System.out.println("3 - Editar profissão no cadastro de uma pessoa");
        System.out.println("4 - Editar cadastro de uma pessoa");
        System.out.println("5 - Registrar primeira dose da vacina de uma pessoa");
        System.out.println("6 - Registrar segunda dose da vacina de uma pessoa");
        System.out.println("7 - Configurar idade mínima de vacinação");
        System.out.println("8 - Adicionar comorbidade para a lista de prioridades de vacinação");
        System.out.println("9 - Adicionar profissão para a lista de prioridades de vacinação");
        System.out.println("10 - Verificar o status de vacinação de uma pessoa a partir do CPF");
        System.out.println("11 - Listar todas as pessoas cadastradas com seus respectivos status");
        System.out.println("12 - Sair do aplicativo");
        System.out.print("Digite o número correspondente à ação desejada: ");
    }


}
