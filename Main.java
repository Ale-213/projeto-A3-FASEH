import java.util.Scanner;

public class Main {

    public static int lerNumero(Scanner entrada, String mensagem) {

        while (true) {

            try {

                System.out.print(mensagem);
                return Integer.parseInt(entrada.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Erro! Digite apenas números.");
            }
        }
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        AlunoService service = new AlunoService();

        int opcao;

        do {

            System.out.println("\n===== CADASTRO DE ALUNOS =====");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Editar aluno");
            System.out.println("4 - Excluir aluno");
            System.out.println("0 - Sair");

            opcao = lerNumero(entrada, "Escolha: ");

            if (opcao == 1) {

                int id = lerNumero(entrada, "ID: ");

                System.out.print("Nome: ");
                String nome = entrada.nextLine();

                int idade = lerNumero(entrada, "Idade: ");

                Aluno aluno = new Aluno(id, nome, idade);

                service.cadastrar(aluno);

                System.out.println("Aluno cadastrado!");

            } else if (opcao == 2) {

                service.listar();

            } else if (opcao == 3) {

                int id = lerNumero(entrada, "ID do aluno a ser editado: ");

                System.out.print("Novo nome: ");
                String novoNome = entrada.nextLine();

                int novaIdade = lerNumero(entrada, "Nova idade: ");

                service.editar(id, novoNome, novaIdade);

            } else if (opcao == 4) {

                int id = lerNumero(entrada, "ID do aluno a ser removido: ");

                service.excluir(id);

            } else if (opcao != 0) {

                System.out.println("Opção inválida!");

            }

        } while (opcao != 0);

        System.out.println("Programa encerrado.");

        entrada.close();
    }
}