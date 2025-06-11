package view;

import DAO.ProdutoDAO;
import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TelaPrincipal extends JFrame {
    private JTextField campoNome, campoPreco, campoQuantidade;
    private JButton botaoSalvar, botaoListar;
    private JTextArea areaTexto;

    public TelaPrincipal() {
        setTitle("Cadastro de Produtos");
        setLayout(new FlowLayout());
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        campoNome = new JTextField(20);
        campoPreco = new JTextField(10);
        campoQuantidade = new JTextField(5);
        botaoSalvar = new JButton("Salvar");
        botaoListar = new JButton("Listar");
        areaTexto = new JTextArea(10, 30);

        add(new JLabel("Nome:"));
        add(campoNome);
        add(new JLabel("Preço:"));
        add(campoPreco);
        add(new JLabel("Quantidade:"));
        add(campoQuantidade);
        add(botaoSalvar);
        add(botaoListar);
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
    }
}
