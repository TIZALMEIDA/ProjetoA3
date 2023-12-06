
package projetoa3;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;

    public class TelaLoginComBanco extends JFrame {
        private JTextField campoUsuario;
        private JPasswordField campoSenha;

        public TelaLoginComBanco() {
            // Configurações da janela
            setTitle("Tela de Login com Banco de Dados");
            setSize(300, 150);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

        // Painel principal
            JPanel painelPrincipal = new JPanel();
            painelPrincipal.setLayout(new GridLayout(3, 2));

        // Componentes
            JLabel labelUsuario = new JLabel("Usuário:");
            JLabel labelSenha = new JLabel("Senha:");
            campoUsuario = new JTextField();
            campoSenha = new JPasswordField();
            JButton botaoLogin = new JButton("Login");

        // Adiciona componentes ao painel
            painelPrincipal.add(labelUsuario);
            painelPrincipal.add(campoUsuario);
            painelPrincipal.add(labelSenha);
            painelPrincipal.add(campoSenha);
            painelPrincipal.add(new JLabel()); // Espaço em branco
            painelPrincipal.add(botaoLogin);

        // Adiciona ação ao botão de login
            botaoLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                       realizarLogin();
                }

                //private void realizarLogin() {
                //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                //}
            });

        // Adiciona o painel principal à janela
            add(painelPrincipal);

        // Torna a janela visível
            setVisible(true);
        }

        private void realizarLogin() {
            String usuario = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());

            // Lógica de autenticação com banco de dados
            try {
                String filename = "bancodados.db";
                Connection connection = DriverManager.getConnection("jdbc:sqlite:"+filename);

                String query = "SELECT * FROM login WHERE usuario = ? AND senha = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, usuario);
                preparedStatement.setString(2, senha);

                ResultSet resultSet = preparedStatement.executeQuery();
                
                if (resultSet.next()) {
                    Menu menu = new Menu();
                    menu.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Login falhou. Tente novamente.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
                }

                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new TelaLoginComBanco();
                }
            });
        }
}
