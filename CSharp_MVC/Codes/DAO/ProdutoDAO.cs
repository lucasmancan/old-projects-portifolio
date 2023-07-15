using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CadastroDeProdutos.Codes.Model;
using CadastroDeProdutos.Codes.DAL;
using System.Data;

namespace CadastroDeProdutos.Codes.DAO
{
    class ProdutoDAO: GenericDAO
    {
        Produto produto;
        String stringSql;
        public void Inserir(Produto produto)
        {
            this.produto = produto;
            stringSql =  "INSERT INTO PRODUTOS(ID_PRODUTO, NOME_PRODUTO, PRECO_PRODUTO) VALUES (" + produto.Id + ",'" + produto.Nome + "'," + produto.Preco + ");";
            Save(stringSql);
        }

        public void Alterar(Produto produto)
        {
            this.produto = produto;
            stringSql = "UPDATE PRODUTOS SET NOME_PRODUTO = '"+produto.Nome+"', PRECO_PRODUTO = "+produto.Preco+" WHERE ID_PRODUTO ="+produto.Id+"; ";
            Save(stringSql);
        }

        public void Remover(Produto produto)
        {
            this.produto = produto;
            stringSql = "DELETE FROM PRODUTOS WHERE ID_PRODUTO ="+ produto.Id +";";
            Save(stringSql);
        }

        public DataTable FindByName(String name)
        {
            stringSql = "SELECT * FROM PRODUTOS WHERE NOME_PRODUTO = "+name+";";
            DataTable tableProdutos = Find(name);

            return tableProdutos;
        }
        public DataTable ShowProdutos()
        {
            stringSql = "SELECT ID_PRODUTO AS ID, NOME_PRODUTO AS Nome, PRECO_PRODUTO AS Valor FROM PRODUTOS;";
            DataTable tableProdutos = Find(stringSql);

            return tableProdutos;
        }
    }
}
