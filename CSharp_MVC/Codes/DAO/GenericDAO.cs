using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CadastroDeProdutos.Codes.DAL;
namespace CadastroDeProdutos.Codes.DAO
{
    abstract class GenericDAO
    {
        private ConnectionDataBase conexao;

        public GenericDAO()
        {
            this.conexao = new ConnectionDataBase();
            
        }

        public ConnectionDataBase Conexao { get => conexao; set => conexao = value; }

       protected void Save(string stringSql)
        {
            conexao.Connect();
            conexao.ExecuteSQLCommand(stringSql);
        }


        protected DataTable Find(String stringSql)
        {
            conexao.Connect();
            DataTable data = conexao.RetDataTable(stringSql);

            return data;
        } 
    }
}
