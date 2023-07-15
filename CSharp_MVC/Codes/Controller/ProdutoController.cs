using CadastroDeProdutos.Codes.DAO;
using CadastroDeProdutos.Codes.Model;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CadastroDeProdutos.Codes.Controller
{
    class ProdutoController
    {

        public void Salvar(String nome, double preco)  
        {
            try
            {
                
                Produto produto = new Produto();
                produto.Nome = nome.Replace("'", "''");
                produto.Preco = preco;

                new ProdutoDAO().Inserir(produto);
            }catch(Exception e)
            {
                MessageBox.Show("Erro ao encontrar registros: " + e.Message);
            }
            
        }
        public void Alterar(int id, String nome, double preco)
        {
            try
            {
                Produto produto = new Produto();
                produto.Id = id;
                produto.Nome = nome;
                produto.Preco = preco;

                new ProdutoDAO().Alterar(produto);
            }
            catch (Exception e)
            {
                MessageBox.Show("Erro ao cadastrar registro: " + e.Message);
            }

        }

        public void Excluir(int id, String nome, double preco)
        {
            try
            {
                Produto produto = new Produto();
                produto.Id = id;
                produto.Nome = nome;
                produto.Preco = preco;

                new ProdutoDAO().Remover(produto);
            }
            catch (Exception e)
            {
                MessageBox.Show("Erro ao Excluir registros: " + e.Message);
            }

        }

        public DataTable FindProduto( String nome)
        {
            try
            {
                Produto produto = new Produto();
                produto.Nome = nome;
                

               DataTable dataTable =  new ProdutoDAO().FindByName(produto.Nome);
                return dataTable;
            }
            catch (Exception e)
            {
                MessageBox.Show("Erro ao encontrar registros: " + e.Message);
                return null;
            }

        }

        public DataTable ShowProduto()
        {
            try
            {
                DataTable dataTable = new ProdutoDAO().ShowProdutos();
                return dataTable;
            }
            catch (Exception e)
            {
                MessageBox.Show("Erro ao encontrar registros: " + e.Message);
                return null;
            }

        }


    }
}
