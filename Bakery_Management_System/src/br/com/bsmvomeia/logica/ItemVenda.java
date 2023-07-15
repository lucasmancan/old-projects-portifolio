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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mancan
 */
public class ItemVenda {

    private JTextField produtoID, idVenda;
    private JSpinner quantidade;

    public ItemVenda(JTextField idVenda, JTextField produtoID, JSpinner quantidade) {
        this.quantidade = quantidade;
        this.produtoID = produtoID;
        this.idVenda = idVenda;
    }

    static Connection conexao = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;

    public int adicionarItemVenda(JTable tbl_ItensVenda) {
        int adicionado = 0;
        conexao = ModuloConexao.conector();
        String sql = "insert into ITENS_VENDA(idvenda,produtoID,quantidade) values (?,?,?)";
        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, idVenda.getText());
            pst.setString(2, produtoID.getText());
            pst.setString(3, quantidade.getValue().toString());

            // confirmação ( serve de entendimento para o codigo
            adicionado = pst.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao inserir produto. Cetifique-se de ter inserido os dados corretamente!");
        }
        return adicionado;
    }

    public void setarCamposEditItem(JTable tblProdutos, JTextField txtNomeProduto) {

        String sql = "select produtoID from produtos where Nomep like ?";

        try {
            int setar = tblProdutos.getSelectedRow();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tblProdutos.getModel().getValueAt(setar, 1).toString());

            rs = pst.executeQuery();

            if (rs.next()) {

                int idproduto = rs.getInt(1);

                produtoID.setText(Integer.toString(idproduto));
                txtNomeProduto.setText(tblProdutos.getModel().getValueAt(setar, 1).toString());
                quantidade.setValue(tblProdutos.getModel().getValueAt(setar, 2));
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int alterarItemVenda(JTable tbl_ItensVenda) {
        int alterado = 0;
        conexao = ModuloConexao.conector();

        String sql = "update ITENS_VENDA set produtoID = ?, quantidade = ?  where id = ?";

        try {
            int setar = tbl_ItensVenda.getSelectedRow();
            pst = conexao.prepareStatement(sql);

            pst.setString(1, produtoID.getText());
            pst.setString(2, quantidade.getValue().toString());

            pst.setString(3, tbl_ItensVenda.getModel().getValueAt(setar, 0).toString());

            // confirmação ( serve de entendimento para o codigo
            alterado = pst.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao alterar produto. Cetifique-se de ter inserido os dados corretamente!");
        }
        return alterado;
    }

    public void removerItemVenda(JTable tblProdutos, String id) {

        //int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover", "Atenção", JOptionPane.YES_NO_OPTION);
        //if (confirma == JOptionPane.YES_OPTION) {
        //String SQL que deleta
        String sql = "delete from ITENS_VENDA where id = ?";
        conexao = ModuloConexao.conector();
        try {

            pst = conexao.prepareStatement(sql);
            int setar = tblProdutos.getSelectedRow();
            pst.setString(1, id);

            int apagado = pst.executeUpdate();

            if (apagado > 0) {

                //JOptionPane.showMessageDialog(null, "Item removido com sucesso");
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void somarColuna(JTable tbl_ItensVenda, JLabel lblValor, JTextField desconto) {
        double soma = 0;
        for (int i = 0; i < tbl_ItensVenda.getRowCount(); i++) {
            Double valor = Double.parseDouble(tbl_ItensVenda.getValueAt(i, 2).toString()) * Double.parseDouble(tbl_ItensVenda.getValueAt(i, 3).toString());
            soma += valor;
        }
        soma = soma - Double.parseDouble(desconto.getText());
        if (soma < 0) {
            soma = 0;
        }
        lblValor.setText(String.valueOf(soma));
    }

    public void setarCamposItemVenda(JTable tbl_Produtos, JTextField txtNomeProduto) {
        int setar = tbl_Produtos.getSelectedRow();
        produtoID.setText(tbl_Produtos.getModel().getValueAt(setar, 0).toString());
        txtNomeProduto.setText(tbl_Produtos.getModel().getValueAt(setar, 1).toString());

    }

    public void atualizarTabelaItensVenda(JTable tabelaProduto, JTextField txtidVenda) {
        conexao = ModuloConexao.conector();
        ArrayList produtos = new ArrayList();
        String[] colunas = new String[]{"Código", "Produto", "Qt", "R$"};

        String sql = "select o.id as 'Código' , a.Nomep as 'Produto', o.quantidade as 'Quantidade' , a.Preco as 'Valor Unitário' from ITENS_VENDA o inner join produtos a where o.produtoID=a.produtoID and o.idvenda = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtidVenda.getText());
            rs = pst.executeQuery();
            //coloca os dados na tabela

            while (rs.next()) {

                produtos.add(new Object[]{rs.getInt("Código"), rs.getString("Produto"), rs.getFloat("Quantidade"), rs.getFloat("Valor Unitário")});

            }

            ModeloTabela modelo = new ModeloTabela(produtos, colunas);
            tabelaProduto.setModel(modelo);
            tabelaProduto.getColumnModel().getColumn(0).setMaxWidth(0);
            tabelaProduto.getColumnModel().getColumn(0).setMinWidth(0);
            tabelaProduto.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabelaProduto.getColumnModel().getColumn(1).setPreferredWidth(300);
            //a linha abaixo usa a biblioteca para preencher os clientes

        } catch (Exception e) {
        }

    }

    public void precoProduto(JTable tbl_Produtos) {
        int setar = tbl_Produtos.getSelectedRow();

    }

}
