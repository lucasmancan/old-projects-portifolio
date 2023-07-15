using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CadastroDeProdutos.Codes.Model
{
    class itemVenda
    {
        public int id_itemVenda { get => id_itemVenda; set => id_itemVenda = value; }
        public int id_produto { get => id_produto; set => id_produto = value; }
        public int quantidade { get => quantidade; set => quantidade = value; }

        public itemVenda(int id_itemVenda, int id_produto, int quantidade)
        {
            this.id_itemVenda = id_itemVenda;
            this.id_produto = id_produto;
            this.quantidade = quantidade;
        }

        public itemVenda()
        {
        }
    }
}
