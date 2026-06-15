import java.util.ArrayList;

public class AlunoService {

    private ArrayList<Aluno> alunos = new ArrayList<>();

    public void cadastrar(Aluno aluno) {
        alunos.add(aluno);
    }

    public void listar() {

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    public void editar(int id, String novoNome, int novaIdade) {

        for (Aluno aluno : alunos) {

            if (aluno.getId() == id) {

                aluno.setNome(novoNome);
                aluno.setIdade(novaIdade);

                System.out.println("Aluno atualizado!");
                return;
            }
        }

        System.out.println("Aluno não encontrado.");
    }

    public void excluir(int id) {

        for (int i = 0; i < alunos.size(); i++) {

            if (alunos.get(i).getId() == id) {

                alunos.remove(i);

                System.out.println("Aluno removido!");
                return;
            }
        }

        System.out.println("Aluno não encontrado.");
    }
}