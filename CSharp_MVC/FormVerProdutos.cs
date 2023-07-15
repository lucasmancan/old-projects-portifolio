using CadastroDeProdutos.Codes.Controller;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace prodSystem
{
    public partial class FormVerProdutos : Form
    {
        
        ProdutoController produto;
        public FormVerProdutos()
        {
            InitializeComponent();
            AtualizarTabela();
        }

        private void btnNovo_Click(object sender, EventArgs e)
        {
            if (txtIdProduto.Text == String.Empty && txtNomeProduto.Text != String.Empty && txtPrecoProduto.Text != String.Empty)
            {
                OnClickSalvar();
            }
            else
            {
                OnClickAlterar();
            }
        }


        public void OnClickSalvar()
        {
            
            produto = new ProdutoController();
            produto.Salvar(
                txtNomeProduto.Text.Replace("'", "''"),
             Double.Parse(txtPrecoProduto.Text.Replace(" ", "0")));

           AtualizarTabela();
            LimparCampos();
        }
        public void OnClickAlterar()
        {
           double precoItem;
            string siten = txtPrecoProduto.Text;

            Double.TryParse(siten, out precoItem);
               produto = new ProdutoController();
            produto.Alterar(
               int.Parse(txtIdProduto.Text),
                txtNomeProduto.Text.Replace(" ", "0"),
                precoItem);
                
            AtualizarTabela();
            LimparCampos();
        }

        public void OnClickRemover()
        {
            
            produto = new ProdutoController();
            produto.Excluir(int.Parse(txtIdProduto.Text),
                    txtNomeProduto.Text.Replace("'", "''"),
                     Double.Parse(txtPrecoProduto.Text.Replace(" ", "0")));
            AtualizarTabela();
            LimparCampos();
        }
        public void AtualizarTabela()
        {
             produto  = new ProdutoController();
            GridViewProdutos.DataSource = produto.ShowProduto();
            
        }

        private void txtIdProduto_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnRemover_Click(object sender, EventArgs e)
        {
            if (!(txtIdProduto.Text == ""))
            { 
            OnClickRemover();
            }
            else
            {
                MessageBox.Show("Selecione um cliente para remover");
            }
        }

        private void GridViewProdutos_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if(!(e.RowIndex <0))
            {
                txtIdProduto.Text = GridViewProdutos.Rows[e.RowIndex].Cells[0].Value.ToString();
                txtNomeProduto.Text = GridViewProdutos.Rows[e.RowIndex].Cells[1].Value.ToString();
                txtPrecoProduto.Text = GridViewProdutos.Rows[e.RowIndex].Cells[2].Value.ToString();

            }
            
                  }

        public void LimparCampos()
        {
            txtIdProduto.Text = "";
            txtNomeProduto.Text = "";
            txtPrecoProduto.Text = "";
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            MessageBox.Show(txtPrecoProduto.Text);
        }

        private void txtPrecoProduto_Leave(object sender, EventArgs e)
        {
         
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            MessageBox.Show(txtPrecoProduto.Text);
        }

        private void txtPrecoProduto_MaskInputRejected(object sender, MaskInputRejectedEventArgs e)
        {

        }
    }

   
}
