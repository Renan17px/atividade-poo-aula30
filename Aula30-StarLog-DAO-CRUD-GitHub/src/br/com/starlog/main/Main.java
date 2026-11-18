package br.com.starlog.main;

import br.com.starlog.dao.ProdutoDAO;
import br.com.starlog.dao.ProdutoDAOSqlite;
import br.com.starlog.model.Produto;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAOSqlite();

        System.out.println("=== 1. [CREATE] Cadastrando Produtos ===");
        Produto p1 = new Produto("Teclado Mecanico RGB", 320.00, 10);
        Produto p2 = new Produto("Mousepad Speed XL", 89.90, 25);
        dao.salvar(p1);
        dao.salvar(p2);
        System.out.println("Gerado ID p1: " + p1.getId() + " -> " + p1);
        System.out.println("Gerado ID p2: " + p2.getId() + " -> " + p2);

        System.out.println("\n=== 2. [READ] Listando Todos os Produtos ===");
        dao.listarTodos().forEach(System.out::println);

        System.out.println("\n=== 3. [UPDATE] Atualizando Teclado Mecanico RGB ===");
        p1.setEstoque(15);
        p1.setPreco(289.90);
        boolean atualizado = dao.atualizar(p1);
        System.out.println("Retorno atualizar(p1): " + atualizado);
        dao.buscarPorId(p1.getId()).ifPresent(p -> System.out.println("Registro atualizado: " + p));

        System.out.println("\n=== 4. [DELETE] Removendo Mousepad e Testando ID Inexistente ===");
        boolean excluidoReal = dao.excluir(p2.getId());
        System.out.println("Exclusao do Mousepad (ID " + p2.getId() + "): " + excluidoReal);

        boolean excluidoFalso = dao.excluir(888L);
        System.out.println("Tentativa de exclusao de ID inexistente (888L): " + excluidoFalso + " (tratado sem crash)");

        System.out.println("\n=== 5. [FINAL STATE] Estado Final do Banco ===");
        List<Produto> restantes = dao.listarTodos();
        System.out.println("Total restante no banco: " + restantes.size());
        restantes.forEach(System.out::println);
    }
}
