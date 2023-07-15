/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bsmvomeia.logica;

import br.com.bsmvomeia.dal.ModuloConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
//Classe separada qeu adiciona elementos no banco de dados

/**
 *
 * @author Mancan
 */
public class Usuario {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private final JTextField idUsuario;
    private final JTextField nomeUsuario;
    private final JTextField foneUsuario;
    private final JTextField loginUsuario;
    private final JTextField senhaUsuario;
    private final JComboBox comboPerfilUsuario;

    public Usuario(JTextField idUsuario, JTextField nomeUsuario, JTextField foneUsuario, JTextField loginUsuario, JTextField senhaUsuario, JComboBox comboPerfilUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.foneUsuario = foneUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.comboPerfilUsuario = comboPerfilUsuario;
    }

    //CREATE (Adiciona Usuario no sistema)
    public int adicionarUsuario() {
        conexao = ModuloConexao.conector();
        String sql = "insert into login( user, fone, login, senha, perfil) values (?,?,?,?,?)";
        int adicionado = 0;
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, nomeUsuario.getText());
            pst.setString(2, foneUsuario.getText());
            pst.setString(3, loginUsuario.getText());
            pst.setString(4, senhaUsuario.getText());
            pst.setString(5, comboPerfilUsuario.getSelectedItem().toString());

            if ((nomeUsuario.getText().isEmpty()) || (loginUsuario.getText().isEmpty()) || (senhaUsuario.getText().isEmpty()) || (comboPerfilUsuario.getSelectedItem().toString().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Erro ao adicionar usuário, certifique-se de ter digitado os dados corretamente.");

            } else {
                // confirmação ( serve de entendimento para o codigo
                adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    //JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");

                }
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao adicionar usuário, certifique-se de ter digitado os dados corretamente. E de não repetir a mesma identificação de acesso.");
        }
        return adicionado;
    }

    // Update (Edita os Usuários do sistema)
    public int alterarUsuario() {
        conexao = ModuloConexao.conector();
        String sql = "update login set user = ?, fone= ?, login=?, senha=?, perfil = ? where iduser = ?";
        int alterado = 0;
        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeUsuario.getText());
            pst.setString(2, foneUsuario.getText());
            pst.setString(3, loginUsuario.getText());
            pst.setString(4, senhaUsuario.getText());
            pst.setString(5, comboPerfilUsuario.getSelectedItem().toString());

            pst.setString(6, idUsuario.getText());

            if ((idUsuario.getText().isEmpty()) || (nomeUsuario.getText().isEmpty()) || (loginUsuario.getText().isEmpty()) || (senhaUsuario.getText().isEmpty()) || (comboPerfilUsuario.getSelectedItem().toString().isEmpty())) {

            } else {
                // confirmação ( serve de entendimento para o codigo
                alterado = pst.executeUpdate();

                if (alterado > 0) {
                    //JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso");

                }
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return alterado;
    }

    // adiciona Usuários no sistema com base nas entradas da interface
    // caso algum campo não tenha sido preenchido, o sistema informará um erro
    //  CREATE
    /**
     */
    //DELETE  ( Remove os usuários que estão cadastrados no sistema)
    public void removerUsuario(JTable tblClientes) {

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            //String SQL que deleta
            String sql = "delete from login where user like ?";
            int setar = tblClientes.getSelectedRow();

            conexao = ModuloConexao.conector();

            if (tblClientes.getModel().getValueAt(setar, 0).toString().equals(FazerLogin.User)) {
                JOptionPane.showMessageDialog(null, "Impossível excluir o atual usuário do sistema. Entre com uma conta diferente e tente novamente.");
            } else {
                try {

                    pst = conexao.prepareStatement(sql);
                    pst.setString(1, tblClientes.getModel().getValueAt(setar, 0).toString());
                    int apagado = pst.executeUpdate();

                    if (apagado > 0) {

                        //JOptionPane.showMessageDialog(null, "Usuário removido com secesso");
                    }
                } catch (SQLException e) {

                    JOptionPane.showMessageDialog(null, e);
                }
            }

        }
    }

    public void atualizarTabelaUsuarios(JTable tabelaUsuario) {
        conexao = ModuloConexao.conector();
        String sql = "select user as 'Usuários' from  login;";
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{""};

        try {
            pst = conexao.prepareStatement(sql);

            rs = pst.executeQuery();
            rs.first();

            do {

                dados.add(new Object[]{rs.getString("Usuários")});

            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }

        //tabelaPesquisa.setModel(DbUtils.resultSetToTableModel(rs));
        //a linha abaixo usa a biblioteca para preencher os clientes
        //tabelaPesquisa.getColumnModel().getColumn(0).setPreferredWidth(20);
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tabelaUsuario.setModel(modelo);
    }

    //metodo que irá setar os campos da Tela do usuario
    public void setarCamposUsuario(JTable tblUsuario) {
        int setar = tblUsuario.getSelectedRow();

        conexao = ModuloConexao.conector();
        String sql = "select * from login where user Like ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tblUsuario.getModel().getValueAt(setar, 0).toString());
            rs = pst.executeQuery();
            if (rs.next()) {
                idUsuario.setText(rs.getString(1));
                nomeUsuario.setText(rs.getString(2));
                foneUsuario.setText(rs.getString(3));
                loginUsuario.setText(rs.getString(4));
                senhaUsuario.setText(rs.getString(5));
                // se refere ao combo box
                comboPerfilUsuario.setSelectedItem(rs.getString(6));

            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado", "Erro no Cadastro", JOptionPane.ERROR_MESSAGE);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
