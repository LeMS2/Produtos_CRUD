package view;

import DAO.ProdutoDAO;
import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TelaPrincipal extends JFrame {
    private JTextField campoId, campoNome, campoPreco, campoQuantidade;
    private JButton botaoSalvar, botaoListar, botaoExcluir, botaoEditar;
    private JTextArea areaTexto;

    public TelaPrincipal() {
        setTitle("Cadastro de Produtos");
        setLayout(new FlowLayout());
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        campoId = new JTextField(5);
        campoNome = new JTextField(20);
        campoPreco = new JTextField(10);
        campoQuantidade = new JTextField(5);
        botaoSalvar = new JButton("Salvar");
        botaoListar = new JButton("Listar/Atualizar");
        botaoEditar = new JButton("Editar");
        botaoExcluir = new JButton("Excluir");

        areaTexto = new JTextArea(10, 30);

        add(new JLabel("ID (para Editar/Excluir):"));
        add(campoId);
        add(new JLabel("Nome:"));
        add(campoNome);
        add(new JLabel("Preço:"));
        add(campoPreco);
        add(new JLabel("Quantidade:"));
        add(campoQuantidade);
        add(botaoSalvar);
        add(botaoListar);
        add(botaoExcluir);
        add(botaoEditar);
        add(new JScrollPane(areaTexto));

        botaoSalvar.addActionListener((ActionEvent e) -> {
            Produto p = new Produto();
            p.setNome(campoNome.getText());
            p.setPreco(Double.parseDouble(campoPreco.getText()));
            p.setQuantidade(Integer.parseInt(campoQuantidade.getText()));

            ProdutoDAO repositorio = new ProdutoDAO();
            try {
                repositorio.inserir(p);
                JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        botaoListar.addActionListener((ActionEvent e) -> {
            ProdutoDAO repositorio = new ProdutoDAO();
            try {
                List<Produto> produtos = repositorio.listar();
                areaTexto.setText("");
                for (Produto p : produtos) {
                    areaTexto.append(p.getId() + " - " + p.getNome() + " | Preço: " + p.getPreco() + " | Quantidade: " + p.getQuantidade() + "\n");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        botaoExcluir.addActionListener((ActionEvent e) -> {
            ProdutoDAO repositorio = new ProdutoDAO();
            try {
                int id = Integer.parseInt(campoId.getText());
                repositorio.excluir(id);
                JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Informe um ID válido para exclusão.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        botaoEditar.addActionListener((ActionEvent e) -> {
            ProdutoDAO repositorio = new ProdutoDAO();
            try {
                Produto p = new Produto();
                p.setId(Integer.parseInt(campoId.getText()));
                p.setNome(campoNome.getText());
                p.setPreco(Double.parseDouble(campoPreco.getText()));
                p.setQuantidade(Integer.parseInt(campoQuantidade.getText()));
                repositorio.atualizar(p);
                JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Preencha corretamente o ID e os outros campos.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });
    }
}

// bibliotecas Java: javax.swing.*: contém os elementos gráficos da interface (botões, campos, etc.)
// java.awt.*: lida com o layout e componentes gráficos
// java.awt.event.ActionEvent: usado para tratar cliques nos botões
// java.util.List: para armazenar listas de produtos ao listar
// campos de texto (JTextField) para digitar ID, nome, preço e quantidade
// botões(JButton) para ações do CRUD
// área de texto (JTextArea) para mostrar os produtos listados
// setTitle: define o título da janela
// setLayout: define o layout como FlowLayout, organiza os componentes da esquerda para a direita
// setSize: define o tamanho da janela
// setDefaultCloseOperation: programa é encerrado ao clicar no X
// campoId, campoNome e outros: cria os campos de texto
// botaoSalvar, botaoEditar e outros: cria os botões com os textos que serão exibidos
// add(): colocam os componentes na tela, primeiros os títulos com JLabel, depois os textos e botões
// após isso, vai mostrar os botões e suas determinadas funções
