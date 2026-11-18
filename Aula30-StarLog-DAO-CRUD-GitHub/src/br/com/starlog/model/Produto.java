package br.com.starlog.model;

public class Produto {
    private Long id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        validar(nome, preco, estoque);
        this.nome = nome.trim();
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(Long id, String nome, double preco, int estoque) {
        this(nome, preco, estoque);
        this.id = id;
    }

    private void validar(String nome, double preco, int estoque) {
        if (nome == null || nome.trim().length() < 3) {
            throw new IllegalArgumentException("Nome do produto nao pode ser nulo e deve ter no minimo 3 caracteres.");
        }
        if (preco <= 0.0) {
            throw new IllegalArgumentException("O preco do produto deve ser maior que zero.");
        }
        if (estoque < 0) {
            throw new IllegalArgumentException("O estoque nao pode ser negativo.");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().length() < 3) {
            throw new IllegalArgumentException("Nome do produto nao pode ser nulo e deve ter no minimo 3 caracteres.");
        }
        this.nome = nome.trim();
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0.0) {
            throw new IllegalArgumentException("O preco do produto deve ser maior que zero.");
        }
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("O estoque nao pode ser negativo.");
        }
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return String.format("ID: %-3d | Nome: %-25s | Preco: R$ %8.2f | Estoque: %3d un",
                id != null ? id : 0L, nome, preco, estoque);
    }
}
