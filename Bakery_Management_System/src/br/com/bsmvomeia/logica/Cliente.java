/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bsmvomeia.logica;

import br.com.bsmvomeia.dal.ModuloConexao;
import static br.com.bsmvomeia.telas.TelaPesquisaCliente.tabelaPesquisa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mancan
 */
public class Cliente {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private final JTextField nomeCliente;
    private final JTextField enderecoCliente;
    private JTextField emailCliente, txtpesquisaCliente, idCliente;
    private JFormattedTextField dataNascimento, telefoneCliente;

    public Cliente(JTextField nomeCliente, JFormattedTextField telefoneCliente, JTextField enderecoCliente, JTextField emailCliente, JTextField idCliente, JFormattedTextField dataNascimento) {

        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.enderecoCliente = enderecoCliente;
        this.emailCliente = emailCliente;
        this.idCliente = idCliente;
        this.dataNascimento = dataNascimento;
    }

    public int adicionarCliente() {
        conexao = ModuloConexao.conector();
        String sql = "insert into clientes(nomec,telefone,endereco,email, dataNascimento) values (?,?,?,?,?)";
        int adicionado = 0;
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeCliente.getText());
            pst.setString(2, telefoneCliente.getText());
            pst.setString(3, enderecoCliente.getText());
            pst.setString(4, emailCliente.getText());
            pst.setString(5, dataNascimento.getText());

            if ((nomeCliente.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Erro ao efetuar cadastro, certifique-se de ter digitado todos os dados corretamente.");

            } else {
                // confirmação ( serve de entendimento para o codigo
                adicionado = pst.executeUpdate();

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao efetuar cadastro, certifique-se de ter digitado todos os dados corretamente.");
        }
        return adicionado;
    }

    public void pesquisarCliente(JTable tblClientes, JTextField txtpesquisaCliente) {
        conexao = ModuloConexao.conector();
        String sql = "select  clienteID as 'ID',  nomec as 'Nome', telefone as 'Nº Telefone' from clientes where nomec like ?";

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Nome", "Nº Telefone"};

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtpesquisaCliente.getText() + "%");
            rs = pst.executeQuery();
            rs.first();

            do {

                dados.add(new Object[]{rs.getString("ID"), rs.getString("Nome"), rs.getString("Nº Telefone")});

            } while (rs.next());

        } catch (SQLException ex) {
            //Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }

        //tabelaPesquisa.setModel(DbUtils.resultSetToTableModel(rs));
        //a linha abaixo usa a biblioteca para preencher os clientes
        //tabelaPesquisa.getColumnModel().getColumn(0).setPreferredWidth(20);
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tabelaPesquisa.setModel(modelo);
        tabelaPesquisa.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelaPesquisa.getColumnModel().getColumn(0).setMinWidth(0);
        tabelaPesquisa.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabelaPesquisa.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabelaPesquisa.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    public void setarCamposCliente(JTable tblClientes) {

        /*String idCliente_buscaBD;
        String nomeCliente_buscaBD;
        String dataNascimento_bd;
        String telefone;
        String email;
        String endereco;*/
        String sql = "select * from clientes where clienteID = ?";

        conexao = ModuloConexao.conector();

        try {
            pst = conexao.prepareStatement(sql);

            int setar = tblClientes.getSelectedRow();

            pst.setString(1, tblClientes.getModel().getValueAt(setar, 0).toString());
            rs = pst.executeQuery();

            if (rs.next()) {
                //busca os dados do BD

                /* String idCliente_buscaBD = rs.getString(1);
                String nomeCliente_buscaBD = rs.getString(2);
                String telefone = rs.getString(3);
                String endereco = rs.getString(4);
                String email = rs.getString(5);
                String dataNascimento_bd = rs.getString(6);*/
                //busca os dados do BD
                //substitui os dados nos campos de texto
                idCliente.setText(rs.getString(1));
                nomeCliente.setText(rs.getString(2));
                telefoneCliente.setText(rs.getString(3));
                enderecoCliente.setText(rs.getString(4));
                emailCliente.setText(rs.getString(5));
                dataNascimento.setText(rs.getString(6));

            } else {
                JOptionPane.showMessageDialog(null, "Nenhum valor encontrado");
            }

        } catch (SQLException e) {
        }

        // int setar = tblClientes.getSelectedRow();
        //   idCliente.setText(tblClientes.getModel().getValueAt(setar, 0).toString());
        //  nomeCliente.setText(tblClientes.getModel().getValueAt(setar, 1).toString());
        //  telefoneCliente.setText(tblClientes.getModel().getValueAt(setar, 2).toString());
        //  enderecoCliente.setText(tblClientes.getModel().getValueAt(setar, 3).toString());
        //  emailCliente.setText(tblClientes.getModel().getValueAt(setar, 4).toString());
        //  dataNascimento.setText(tblClientes.getModel().getValueAt(setar, 5).toString());
    }

    public int alterarCliente(JTable tblClientes) {
        conexao = ModuloConexao.conector();
        String sql = "update clientes set nomec = ?, telefone= ?, endereco=?, email=?, dataNascimento=? where clienteID = ?";
        int alterado = 0;
        try {
            int setar = tblClientes.getSelectedRow();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeCliente.getText());
            pst.setString(2, telefoneCliente.getText());
            pst.setString(3, enderecoCliente.getText());
            pst.setString(4, emailCliente.getText());
            pst.setString(5, dataNascimento.getText());
            pst.setString(6, tblClientes.getModel().getValueAt(setar, 0).toString());

            if ((nomeCliente.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Erro ao efetuar alteração, certifique-se de ter digitado todos os dados corretamente.");

            } else {
                // confirmação ( serve de entendimento para o codigo
                alterado = pst.executeUpdate();

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao efetuar alteração, certifique-se de ter digitado todos os dados corretamente.");
        }
        return alterado;
    }

    public void removerCliente(JTable tblClientes) {
        int setar = tblClientes.getSelectedRow();

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            //String SQL que deleta
            String sql = "delete from clientes where clienteID= ?";

            conexao = ModuloConexao.conector();
            try {

                pst = conexao.prepareStatement(sql);
                pst.setString(1, tblClientes.getModel().getValueAt(setar, 0).toString());

                int apagado = pst.executeUpdate();

                if (apagado > 0) {

                    /*pst = conexao.prepareStatement(sql);
                    pst.setString(1, tblClientes.getModel().getValueAt(setar, 0).toString());

                    int vendaapagado = pst.executeUpdate();*/
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Impossivel excluir cliente, pois existem vendas vinculadas a ele(a)");
            }
//"Impossivel excluir cliente ,pois existem vendas vinculadas a ele(a)"
        }

    }

    public void atualizarTabelaClientes() {
        conexao = ModuloConexao.conector();
        String sql = "select  clienteID as 'ID', nomec as 'Nome', telefone as 'Nº Telefone'  from clientes";
        conexao = ModuloConexao.conector();
        //String sql = "select produtoID as 'ID', nomep as 'Nome', preco as 'Preço de Venda'from produtos";
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Nome", "Nº Telefone"};

        try {
            pst = conexao.prepareStatement(sql);

            rs = pst.executeQuery();
            rs.first();

            do {

                dados.add(new Object[]{rs.getString("ID"), rs.getString("Nome"), rs.getString("Nº Telefone")});

            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }

        //tabelaPesquisa.setModel(DbUtils.resultSetToTableModel(rs));
        //a linha abaixo usa a biblioteca para preencher os clientes
        //tabelaPesquisa.getColumnModel().getColumn(0).setPreferredWidth(20);
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tabelaPesquisa.setModel(modelo);
        tabelaPesquisa.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelaPesquisa.getColumnModel().getColumn(0).setMinWidth(0);
        tabelaPesquisa.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabelaPesquisa.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabelaPesquisa.getColumnModel().getColumn(2).setPreferredWidth(30);

    }

}
