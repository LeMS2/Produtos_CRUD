import view.TelaPrincipal;

import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        javax.swing.SwingUtilities.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
}


// import: importa a classe TelaPrincipal que está no pacote(package) view, responsável pela interação do usuário
// public Main: declara a classe principal do programa
// public static void: define o metodo main que é o ponto de partida da aplicação java
// javax: garante que a interface gráfica seja criada na Thread de Interface do Swing
// setVisible: faz com que a janela seja exibida na tela
// tema Nimbus, padrão moderno do Java