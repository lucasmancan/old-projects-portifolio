using MySql.Data.MySqlClient;
using System;
using System.Data;
using System.Windows.Forms;
using System.Xml;
namespace CadastroDeProdutos.Codes.DAL
{
    public class ConnectionDataBase
    {
       private MySqlConnection conexao;
        private DataTable data;
        private MySqlDataAdapter dataAdapter;
        private MySqlDataReader dataReader;
        private MySqlCommandBuilder commandBuilder;

        private string server = "localhost";
        private String user = "root";
        private string password = "";
        private string dataBase = "bdsistema";

        public void Connect()
        {
            if (conexao != null)
                conexao.Close();

            string connectionString = String.Format("server={0}; user id = {1}; password= {2}; database={3} ; pooling=false", server,user, password, dataBase);

            try
            {
                conexao = new MySqlConnection(connectionString);
                conexao.Open();
            }
            catch (MySqlException e)
            {
                throw new Exception(e.Message);
            }
            
        }

        public void ExecuteSQLCommand(String stringSQL)
        {
            MySqlCommand comando = new MySqlCommand(stringSQL, conexao);
            comando.ExecuteNonQuery();
            conexao.Close();
        }

        public DataTable RetDataTable(String stringSQL)
        {
            /*metodo irá retornar informações em uma tabela*/
            data = new DataTable();
            dataAdapter = new MySqlDataAdapter(stringSQL, conexao);
            commandBuilder = new MySqlCommandBuilder(dataAdapter);
            dataAdapter.Fill(data);

            return data;
        }

        public MySqlDataReader RetDataReader(String stringSQL)
        {
            MySqlCommand command = new MySqlCommand(stringSQL, conexao);
            MySqlDataReader dataReader = command.ExecuteReader();
            dataReader.Read();

            return dataReader;
        }

    }
}

