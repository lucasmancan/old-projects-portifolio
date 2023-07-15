/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bsmvomeia.logica;

import br.com.bsmvomeia.dal.ModuloConexao;
import br.com.bsmvomeia.telas.TelaLogin;
import br.com.bsmvomeia.telas.TelaPrincipal;

import java.awt.Color;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mancan
 */
public class FazerLogin {

    //variaveis que participam do acesso ao banco de dados
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // variaveis locais que rebeberão os valores contidos nos campos de texto da tela de login
    private JTextField user;
    private JPasswordField password;
    static public String perfil;
    static public String User;

    // Na tentativa de desvincular a interface de sua função, essa classe "FazerLogin" foi criada
    //essa classe se conecta com o banco de dados e verifica as entradas do login
    //também faz a troca de telas, da principal para a tela de login
    public FazerLogin(JTextField user, JPasswordField password) {
        // variaveis locais que rebeberão os valores contidos nos campos de texto da tela de login
        this.user = user;
        this.password = password;
        // String sql que retorna se o user e password forem compativeis
        String sql = "select * from login where login= ? and senha = ?";
        int entrou = 0;
        try {

            //as linhas abaixo preparam o consulta ao banco em função do que foi digitado nas caixas de texto
            conexao = ModuloConexao.conector();
            //if (conexao != null) {
            // TelaLogin.lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/bsmvomeia/icones/dbok.png")));
            //} else {
            //  TelaLogin.lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/bsmvomeia/icones/dberror.png")));
            //}
            pst = conexao.prepareStatement(sql);
            pst.setString(1, user.getText());
            pst.setString(2, password.getText());

            rs = pst.executeQuery();

            if (rs.next()) {
                // a linha aabaixo obtem o conteudo do campo perfil
                //getString(numero da coluna do banco de dados)
                entrou = 1;
                perfil = rs.getString(6);
                User = rs.getString(2);

                // se o usuario for do tipo admin, poderá ter acesso a relatorios e cadastro de usuarios
                if (perfil.equals("admin")) {

                    TelaPrincipal principal = new TelaPrincipal();

                    principal.setVisible(true);
                    //principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    TelaPrincipal.MenuCadUsuarios.setEnabled(true);
                    //TelaPrincipal.Relatorio.setEnabled(true);
                    TelaPrincipal.txtUser.setText(rs.getString(2));
                    //TelaPrincipal.txtUser.setForeground(Color.red);
                    TelaLogin.telalogin.dispose();
                    conexao.close();
                } else {
                    // caso contrário somente podera manipular, clientes, produtos e vendas
                    TelaPrincipal principal = new TelaPrincipal();
                    TelaLogin.telalogin.dispose();
                    //principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    principal.setVisible(true);

                    TelaPrincipal.txtUser.setText(rs.getString(2));
                    new TelaLogin().dispose();
                    conexao.close();

                }

            } else {
                // tratamento de erros
                TelaLogin.lblMensagem.setVisible(true);
            }
        } catch (Exception e) {

            // se tudo der errado, uma caixa de dialogo mostrará o erro
            JOptionPane.showMessageDialog(null, e);
        }

    }
}
