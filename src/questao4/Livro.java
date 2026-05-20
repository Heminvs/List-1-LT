package questao4;

import java.util.ArrayList;

class LivroNaoEncontradoException extends Exception {}
class EmprestimoInvalidoException extends Exception {}
class LimiteAcervoException extends Exception {}

class Livro {
    int id;
    String titulo;
    String autor;
    boolean estaEmprestado;

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.estaEmprestado = false;
    }
}

class Biblioteca {
    ArrayList<Livro> acervo = new ArrayList<>();
    int limite = 100;

    public void adicionarLivro(Livro livro) throws LimiteAcervoException {
        if (acervo.size() >= limite) {
            throw new LimiteAcervoException();
        }
        acervo.add(livro);
    }

    public Livro buscarPorId(int id) throws LivroNaoEncontradoException {
        for (Livro livro : acervo) {
            if (livro.id == id) {
                return livro;
            }
        }
        throw new LivroNaoEncontradoException();
    }

    public void emprestar(int id) throws LivroNaoEncontradoException, EmprestimoInvalidoException {
        Livro livro = buscarPorId(id);
        if (livro.estaEmprestado) {
            throw new EmprestimoInvalidoException();
        }
        livro.estaEmprestado = true;
    }

    public void devolver(int id) throws LivroNaoEncontradoException {
        Livro livro = buscarPorId(id);
        livro.estaEmprestado = false;
    }
}

 class Main {
    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca();
        Livro l1 = new Livro(1, "Dom Casmurro", "Machado de Assis");

        try {
            bib.adicionarLivro(l1);
        } catch (LimiteAcervoException e) {
            System.out.println("Erro!! Limite do acervo atingido.");
        }

        try {
            bib.emprestar(1);
            System.out.println("Livro emprestado com sucesso!");
        } catch (LivroNaoEncontradoException e) {
            System.out.println("Erro!! Livro não encontrado.");
        } catch (EmprestimoInvalidoException e) {
            System.out.println("Erro!! O livro já está emprestado.");
        } finally {
            System.out.println("Atendimento finalizado.");
        }

        try {
            bib.emprestar(1);
            System.out.println("Livro emprestado com sucesso!");
        } catch (LivroNaoEncontradoException e) {
            System.out.println("Erro!! Livro não encontrado.");
        } catch (EmprestimoInvalidoException e) {
            System.out.println("Erro!!O livro já está emprestado.");
        } finally {
            System.out.println("Atendimento finalizado.");
        }

        try {
            bib.buscarPorId(99);
            System.out.println("Livro encontrado!");
        } catch (LivroNaoEncontradoException e) {
            System.out.println("Erro!! Livro não encontrado.");
        }
    }
}