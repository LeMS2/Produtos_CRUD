package model;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto() {}

    public Produto(int id, String nome, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}


// cria uma classe chamada Produto, representa o produto e suas informações
// atributos da classe (id, nome, preco, quantidade)
// todos privados, não podem ser acessados diretamente fora da classe
// construtor com parametros, quando já sabe os dados do produto ao criar. This serve para diferenciar o atributo da classe do parametro do metodo
// ex: this.id = atributo, id é o parametro
// getters e setters, métodos que permitem acessar e modificar os dados mesmo que os atributos sejam privados
// getters = leitura, setters = modificação