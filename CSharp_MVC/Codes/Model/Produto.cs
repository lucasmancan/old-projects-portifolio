using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CadastroDeProdutos.Codes.Model
{
    class Produto
    {


        private int id;
        private string nome;
        private double preco;

        public int Id { get => id; set => id = value; }
        public string Nome { get => nome; set => nome = value; }
        public double Preco { get => preco; set => preco = value; }

        public Produto(int id, string nome, double preco)
        {
            this.Id = id;
            this.Nome = nome;
            this.Preco = preco;
        }
        public Produto(){ }
    }

   
}
