/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bsmvomeia.logica;

import br.com.bsmvomeia.dal.ModuloConexao;
import static br.com.bsmvomeia.telas.TelaPesquisaProduto.tabelaPesquisa;

import java.awt.HeadlessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mancan
 */
public class Produto {

    static Connection conexao = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;
    private JTextField nomeProduto;
    private JTextField preco, idProduto, custo, lucro;
    private JComboBox tipoProduto;

    public Produto(JTextField idProduto, JTextField nomeProduto, JComboBox tipoProduto, JTextField custo, JTextField lucro, JTextField preco) {
        this.nomeProduto = nomeProduto;
        this.tipoProduto = tipoProduto;
        this.custo = custo;
        this.lucro = lucro;
        this.preco = preco;
        this.idProduto = idProduto;
    }

    public int adicionarProduto() {

        conexao = ModuloConexao.conector();
        String sql = "insert into produtos(Nomep,tipo,Custo, Lucro, Preco) values (?,?,?,?,?)";
        int adicionado = 0;
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeProduto.getText());
            pst.setString(2, tipoProduto.getSelectedItem().toString());
            pst.setString(3, custo.getText());
            pst.setString(4, lucro.getText());
            pst.setString(5, preco.getText());

            if ((nomeProduto.getText().isEmpty()) || custo.getText().isEmpty() || lucro.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar esse produto. Certifique-se de ter inserido os dados corretamente!");
                //TelaProduto.lblmensagem.setVisible(true);

            } else {
                // confirmação ( serve de entendimento para o codigo
                adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    //JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso");

                }
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar esse produto. Certifique-se de ter inserido os dados corretamente!");
        }
        return adicionado;
    }

    public void pesquisarProduto(JTable tblProdutos, JTextField txtpesquisaProduto) {
        conexao = ModuloConexao.conector();
        String sql = "select produtoID as 'ID', nomep as 'Nome', preco as 'Preço de Venda' from produtos where nomep like ?";

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Nome", "Preço de Venda"};

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtpesquisaProduto.getText() + "%");
            rs = pst.executeQuery();
            rs.first();

            do {

                dados.add(new Object[]{rs.getString("ID"), rs.getString("Nome"), rs.getFloat("Preço de Venda")});

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
        tabelaPesquisa.getColumnModel().getColumn(2).setPreferredWidth(20);

        //tblProdutos.setModel(DbUtils.resultSetToTableModel(rs));
        //a linha abaixo usa a biblioteca para preencher os clientes
        //tabelaPesquisa.getColumnModel().getColumn(0).setPreferredWidth(20);
    }

    public void setarCampos(JTable tblProdutos) {

        // declarando variaveis que serão usadas para capturar informações do BD
        String idProduto;
        String nomeProduto;
        String tipo;
        String custo;
        String lucro;
        String preco;
        String sql = "select * from produtos where produtoID  = ?";

        conexao = ModuloConexao.conector();

        try {
            pst = conexao.prepareStatement(sql);

            int setar = tblProdutos.getSelectedRow();

            pst.setString(1, tblProdutos.getModel().getValueAt(setar, 0).toString());

            rs = pst.executeQuery();
            if (rs.next()) {

                //busca os dados do BD
                idProduto = rs.getString(1);
                nomeProduto = rs.getString(2);
                tipo = rs.getString(3);
                custo = rs.getString(4);
                lucro = rs.getString(5);
                preco = rs.getString(6);
                //busca os dados do BD

                //substitui os dados nos campos de texto
                this.idProduto.setText(idProduto);
                this.nomeProduto.setText(nomeProduto);
                this.tipoProduto.setSelectedItem(tipo);
                this.custo.setText(custo);
                this.lucro.setText(lucro);
                this.preco.setText(preco);

            }

        } catch (SQLException e) {
        }

        /* int setar = tblProdutos.getSelectedRow();
        idProduto.setText(tblProdutos.getModel().getValueAt(setar, 0).toString());
        nomeProduto.setText(tblProdutos.getModel().getValueAt(setar, 1).toString());
        tipoProduto.setText(tblProdutos.getModel().getValueAt(setar, 2).toString());
        custo.setText(tblProdutos.getModel().getValueAt(setar, 3).toString());
        lucro.setText(tblProdutos.getModel().getValueAt(setar, 4).toString());
        preco.setText(tblProdutos.getModel().getValueAt(setar, 5).toString());*/
    }

    public int alterarProduto() {
        conexao = ModuloConexao.conector();
        String sql = "update produtos set Nomep = ?, Tipo= ?, Custo =?, Lucro= ?, Preco = ?  where produtoID = ?";
        int alterado = 0;
        try {
            int setar = tabelaPesquisa.getSelectedRow();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeProduto.getText());
            pst.setString(2, tipoProduto.getSelectedItem().toString());
            pst.setString(3, custo.getText());
            pst.setString(4, lucro.getText());
            pst.setString(5, preco.getText());
            pst.setString(6, tabelaPesquisa.getModel().getValueAt(setar, 0).toString());

            if ((nomeProduto.getText().isEmpty()) || custo.getText().isEmpty() || lucro.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não foi possível alterar esse produto. Certifique-se de ter inserido os dados corretamente!");

            } else {
                // confirmação ( serve de entendimento para o codigo
                alterado = pst.executeUpdate();

                if (alterado > 0) {

                    //JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
                }
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Não foi possível alterar esse produto. Certifique-se de ter inserido os dados corretamente!");
        }
        return alterado;
    }

    public void removerProduto(JTable tblProdutos) {

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            //String SQL que deleta
            String sql = "delete from produtos where produtoID= ?";
            conexao = ModuloConexao.conector();
            try {

                pst = conexao.prepareStatement(sql);
                int setar = tblProdutos.getSelectedRow();
                pst.setString(1, tblProdutos.getModel().getValueAt(setar, 0).toString());

                int apagado = pst.executeUpdate();

                if (apagado > 0) {

                    //JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
                }
            } catch (HeadlessException | SQLException e) {

                JOptionPane.showMessageDialog(null, "Impossível excluir produto, pois existem vendas vinculadas a ele");
            }
        }
    }

    public void atualizarTabela(String sql) {
        conexao = ModuloConexao.conector();
        //String sql = "select produtoID as 'ID', nomep as 'Nome', preco as 'Preço de Venda'from produtos";
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Nome", "Preço de Venda"};

        try {
            pst = conexao.prepareStatement(sql);

            rs = pst.executeQuery();
            rs.first();

            do {

                dados.add(new Object[]{rs.getString("ID"), rs.getString("Nome"), rs.getFloat("Preço de Venda")});

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
        tabelaPesquisa.getColumnModel().getColumn(2).setPreferredWidth(20);

        //coloca os dados na tabela
    }

}
