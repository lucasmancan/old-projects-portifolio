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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mancan
 */
public class Venda {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    //variaveis
    private JTextField idCliente, desconto;
    private JLabel precofinal, lbldata, lblCliente;
    private JComboBox pagamento;

    public Venda(JTextField idCliente, JTextField desconto, JLabel precofinal, JComboBox pagamento) {
        this.idCliente = idCliente;
        this.desconto = desconto;
        this.precofinal = precofinal;
        this.pagamento = pagamento;
    }

    public Venda() {
    }

    //metodos para a classe venda
    public int adcionarVenda(JTextField txtidCliente) {
        conexao = ModuloConexao.conector();
        int adicionado = 0;
        String sql = "insert into vendas() values ()";
        try {
            pst = conexao.prepareStatement(sql);
            //pst.setString(1, txtidCliente.getText());

            // confirmação ( serve de entendimento para o codigo
            adicionado = pst.executeUpdate();

            if (adicionado > 0) {
                //JOptionPane.showMessageDialog(null, "Venda adicionada com sucesso");

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return adicionado;
    }

    public int alterarVenda(JTextField txtidVenda) {
        conexao = ModuloConexao.conector();
        int adicionado = 0;
        String sql = "update vendas set clienteID = ?, desconto = ?, valor = ?, pagamento = ?  where idvenda = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, idCliente.getText());
            pst.setString(2, desconto.getText());
            pst.setString(3, precofinal.getText());
            pst.setString(4, pagamento.getSelectedItem().toString());
            pst.setString(5, txtidVenda.getText());

            // confirmação ( serve de entendimento para o codigo
            adicionado = pst.executeUpdate();

            if (adicionado > 0) {
                // JOptionPane.showMessageDialog(null, "Venda salva com sucesso");

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao adicionar venda. Certifique-se de ter inserido os dados corretamente.");
        }
        return adicionado;
    }

    public int removerVenda(JTextField txtidVenda) {
        int vendaremovido = 0;
        conexao = ModuloConexao.conector();
        //primeiro remove os itens vinculados a venda, depois a venda
        String sql = "delete from vendas where idvenda = ?";
        String sql2 = "delete from itens_venda where idvenda = ?";
        try {
            pst = conexao.prepareStatement(sql2);
            pst.setString(1, txtidVenda.getText());

            // confirmação ( serve de entendimento para o codigo
            int removido = pst.executeUpdate();

            // confirmação ( serve de entendimento para o codigo
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtidVenda.getText());
            vendaremovido = pst.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return vendaremovido;
    }

    public void atualizarTabelaVenda(JTable tblVenda) throws SQLException {

        conexao = ModuloConexao.conector();
        ArrayList vendas = new ArrayList();

        String sql = "select  o.idvenda, o.data as 'Data', b.nomec as 'Nome do Cliente', o.valor as 'Valor da Venda', o.pagamento as 'Forma de Pagamento' from  vendas o inner join clientes b where o.clienteID = b.clienteID;";

        pst = conexao.prepareStatement(sql);
        String[] colunas = new String[]{"ID", "Data", "Nome do Cliente", "Valor de venda", "Forma de Pagamento"};
        rs = pst.executeQuery();

        while (rs.next()) {

            vendas.add(new Object[]{rs.getInt("idvenda"), rs.getString("Data"), rs.getString("Nome do Cliente"), rs.getFloat("Valor da Venda"), rs.getString("Forma de Pagamento")});

        }
        ModeloTabela modelo = new ModeloTabela(vendas, colunas);
        tblVenda.setModel(modelo);
        tblVenda.getColumnModel().getColumn(0).setMaxWidth(0);
        tblVenda.getColumnModel().getColumn(0).setMinWidth(0);

        tblVenda.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblVenda.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblVenda.getColumnModel().getColumn(1).setPreferredWidth(70);
        tblVenda.getColumnModel().getColumn(3).setPreferredWidth(10);
        tblVenda.getColumnModel().getColumn(3).setPreferredWidth(40);
        rs.close();
        pst.close();

    }

    public void atualizarTabelaClientesVenda(JTable tabelaCliente) {
        conexao = ModuloConexao.conector();
        ArrayList clientes = new ArrayList();
        String[] colunas = new String[]{"Nome", "ID"};
        String sql = "select nomec as 'Nome', clienteID as 'ID' from  clientes;";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            //coloca os dados na tabela

            while (rs.next()) {

                clientes.add(new Object[]{rs.getString("Nome"), rs.getString("ID")});

            }
            ModeloTabela modelo = new ModeloTabela(clientes, colunas);
            tabelaCliente.setModel(modelo);
            tabelaCliente.getColumnModel().getColumn(1).setMaxWidth(0);
            tabelaCliente.getColumnModel().getColumn(1).setMinWidth(0);
            tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(0);
            //a linha abaixo usa a biblioteca para preencher os clientes

        } catch (Exception e) {
        }

    }

    public void setarClienteVenda(JTable tbl_produtos, JTextField txtNomeCliente) {
        int setar = tbl_produtos.getSelectedRow();
        idCliente.setText(tbl_produtos.getModel().getValueAt(setar, 1).toString());
        txtNomeCliente.setText(tbl_produtos.getModel().getValueAt(setar, 0).toString());
    }

    public void setarCamposClientevenda(JTable tabelaClienteVenda, JTextField txtidCliente) {

        String sql = "select clienteID from clientes where nomec like ?";
        conexao = ModuloConexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            int setar = tabelaClienteVenda.getSelectedRow();
            pst.setString(1, tabelaClienteVenda.getModel().getValueAt(setar, 0).toString());
            rs = pst.executeQuery();

            if (rs.next()) {
                String clienteID;

                clienteID = rs.getString(1);
                txtidCliente.setText(clienteID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setarCamposEditarVenda(JTable tabelaVenda, JTextField txtidCliente, JTextField txtCliente, JTextField txtData, JLabel lblvalor, JTextField txtidVenda) throws SQLException {

        String sql = "select * from vendas where idvenda= ?";

        conexao = ModuloConexao.conector();

        pst = conexao.prepareStatement(sql);
        int setar = tabelaVenda.getSelectedRow();
        pst.setString(1, tabelaVenda.getModel().getValueAt(setar, 0).toString());
        rs = pst.executeQuery();
        //procura um id cliente cujo nome combina com o nome presente na tabela, se encontrar, seleciona tudo
        if (rs.next()) {
            ///fazendo uma nova pesquisa no banco de dados

            String idVenda;
            String data;
            String Desconto;
            String valor;
            //
            idVenda = rs.getString(1);
            data = rs.getString(2);
            String idcliente = rs.getString(3);
            Desconto = rs.getString(5);
            valor = rs.getString(4);
            txtCliente.setText(tabelaVenda.getModel().getValueAt(setar, 2).toString());
            txtidVenda.setText(idVenda);
            txtidCliente.setText(idcliente);
            txtData.setText(data);
            desconto.setText(Desconto);
            lblvalor.setText(valor);
        }
    }

    public void atualizarTabelaClientesVendaPesquisa(JTable tabelaCliente, JTextField txtPesquisa) {
        conexao = ModuloConexao.conector();
        ArrayList clientes = new ArrayList();
        String[] colunas = new String[]{"Nome", "ID"};
        String sql = "select nomec as 'Nome', clienteID as 'ID' from  clientes where nomec like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPesquisa.getText() + "%");
            rs = pst.executeQuery();
            //coloca os dados na tabela
            while (rs.next()) {

                clientes.add(new Object[]{rs.getString("Nome"), rs.getString("ID")});

            }
            ModeloTabela modelo = new ModeloTabela(clientes, colunas);
            tabelaCliente.setModel(modelo);
            tabelaCliente.getColumnModel().getColumn(1).setMaxWidth(0);
            tabelaCliente.getColumnModel().getColumn(1).setMinWidth(0);
            tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(0);

            //a linha abaixo usa a biblioteca para preencher os clientes
        } catch (Exception e) {
        }

    }

    public void atualizarTabelaProdutosVenda(JTable tabelaProduto) {
        conexao = ModuloConexao.conector();
        ArrayList produtos = new ArrayList();
        String[] colunas = new String[]{"ID", "Nome", "Preco"};

        String sql = "select produtoID as 'ID', Nomep as 'Nome', Preco as 'Preço'  from  produtos;";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            //coloca os dados na tabela
            while (rs.next()) {

                produtos.add(new Object[]{rs.getInt("ID"), rs.getString("Nome"), rs.getFloat("Preço")});

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

    public void atualizarTabelaProdutosVendaPesquisa(JTable tabelaProduto, JTextField txtPesquisa) {
        conexao = ModuloConexao.conector();
        ArrayList produtos = new ArrayList();
        String[] colunas = new String[]{"ID", "Nome", "Preco"};
        String sql = "select produtoID as 'ID', Nomep as 'Nome', Preco as 'Preço' from  produtos where Nomep like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPesquisa.getText() + "%");
            rs = pst.executeQuery();
            //coloca os dados na tabela

            while (rs.next()) {

                produtos.add(new Object[]{rs.getInt("ID"), rs.getString("Nome"), rs.getFloat("Preço")});

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

    public void ultimaVenda(JTextField txtidVenda) {
        int idVenda = 0;
        conexao = ModuloConexao.conector();
        String sql = "select * from vendas";
        try {

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            //coloca os dados na tabela

            rs.last();
            txtidVenda.setText(Integer.toString(rs.getInt("idvenda")));
            //a linha abaixo usa a biblioteca para preencher os clientes

        } catch (Exception e) {
        }

    }

    public void somarColuna(JTable tbl_ItensVenda, JLabel lblValor) {
        double soma = 0;
        for (int i = 0; i < tbl_ItensVenda.getRowCount(); i++) {
            Double valor = Double.parseDouble(tbl_ItensVenda.getValueAt(i, 3).toString());
            soma += valor;
        }
        //soma = NumberFormat.getInstance().parse(soma).doubleValue;
        if (soma < 0) {
            soma = 0;
        }

        Locale l = new Locale("pt", "BR");
        NumberFormat nf = NumberFormat.getInstance(l);
//NumberFormat nf = NumberFormat.getCurrencyInstance(l); se for moeda

        lblValor.setText(nf.format(soma));
    }

}
