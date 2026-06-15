import java.util.Scanner;

public class Main {

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

            System.out.print("Escolha: ");
            opcao = entrada.nextInt();

            if (opcao == 1) {

                System.out.print("ID: ");
                int id = entrada.nextInt();

                entrada.nextLine();

                System.out.print("Nome: ");
                String nome = entrada.nextLine();

                System.out.print("Idade: ");
                int idade = entrada.nextInt();

                Aluno aluno = new Aluno(id, nome, idade);

                service.cadastrar(aluno);

                System.out.println("Aluno cadastrado!");
            }

            else if (opcao == 2) {

                service.listar();

            }

            else if (opcao == 3) {

                System.out.print("ID do aluno a ser editado: ");
                int id = entrada.nextInt();

                entrada.nextLine();

                System.out.print("Novo nome: ");
                String novoNome = entrada.nextLine();

                System.out.print("Nova idade: ");
                int novaIdade = entrada.nextInt();

                service.editar(id, novoNome, novaIdade);

            }

            else if (opcao == 4) {

                System.out.print("ID do aluno a ser removido: ");
                int id = entrada.nextInt();

                service.excluir(id);

            }

            else if (opcao != 0) {

                System.out.println("Opção inválida!");

            }

        } while (opcao != 0);

        System.out.println("Programa encerrado.");

        entrada.close();
    }
}