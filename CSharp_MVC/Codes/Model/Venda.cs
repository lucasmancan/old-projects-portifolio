using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CadastroDeProdutos.Codes.Model


{
    class Venda
    {
   

        public int id { get => id; set => id = value; }
        public double desconto { get => desconto; set => desconto = value; }
        public double valor { get => valor; set => valor = value; }
        public string status { get => status; set => status = value; }

        public Venda(int id, double desconto, double valor, string status)
        {
            this.id = id;
            this.desconto = desconto;
            this.valor = valor;
            this.status = status;
        }

        public Venda()
        {
        }
    }
}
