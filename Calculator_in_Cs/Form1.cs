using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class FrameCalculator : Form
    {
        private string operador;
        private double num;
        private Boolean limpo = true;
        private bool virgula = false;
            
        public FrameCalculator()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(limpo == true)
            { 
            textBox1.Text = "1";
            limpo = false;
            }
            else
            {
                textBox1.Text += "1";
            }
             
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (limpo == true)
            {
                textBox1.Text = "2";
                limpo = false;
            }
            else
            {
                textBox1.Text += "2";
            }
        }


        private void buttonLimpar_Click(object sender, EventArgs e)
        {
            textBox1.Text = "0,00";
            limpo = true;
            operador = String.Empty;
            virgula = false;

        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (limpo == true)
            {
                textBox1.Text = "3";
                limpo = false;
            }
            else
            {
                textBox1.Text += "3";
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            if (limpo == true)
            {
                textBox1.Text = "4";
                limpo = false;
            }
            else
            {
                textBox1.Text += "4";
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            if (limpo == true)
            {
                textBox1.Text = "5";
                limpo = false;
            }
            else
            {
                textBox1.Text += "5";
            }
          
        }

        private void button6_Click(object sender, EventArgs e)
        {
            if (limpo == true)
            {
                textBox1.Text = "6";
                limpo = false;
            }
            else
            {
                textBox1.Text += "6";
            }

        }
        private void button7_Click(object sender, EventArgs e)
        {
            if (limpo == true)
            {
                textBox1.Text = "7";
                limpo = false;
            }
            else
            {
                textBox1.Text += "7";
            }

        }
        private void button8_Click(object sender, EventArgs e)
        {
            if (limpo == true)
            {
                textBox1.Text = "8";
                limpo = false;
            }
            else
            {
                textBox1.Text += "8";
            }

        }
        private void button9_Click(object sender, EventArgs e)
        {
            if (limpo == true)
            {
                textBox1.Text = "9";
                limpo = false;
            }
            else
            {
                textBox1.Text += "9";
            }

        }

        private void button0_Click(object sender, EventArgs e)
        {
            if (limpo == true)
            {
                textBox1.Text = "0";
                limpo = false;
            }
            else
            {
                textBox1.Text += "0";
            }

        }

        private void buttonDecimal_Click(object sender, EventArgs e)
        {
            if (virgula == false)
            {
                textBox1.Text += ",";
                virgula = true;
            }
                

        }

        private void buttonSoma_Click(object sender, EventArgs e)
        {
            operador = "+";
            num = Convert.ToDouble(textBox1.Text);
            limpo = true;

        }

        private void buttonMenos_Click(object sender, EventArgs e)
        {
            operador = "-";
            num = Convert.ToDouble(textBox1.Text);
            limpo = true;
        }

        private void buttonVezes_Click(object sender, EventArgs e)
        {
            operador = "*";
            num = Convert.ToDouble(textBox1.Text);
            limpo = true;
        }

        private void buttonDividido_Click(object sender, EventArgs e)
        {
            operador = "/";
            num = Convert.ToDouble(textBox1.Text);
            limpo = true;
        }

        private void buttonEnter_Click(object sender, EventArgs e)
        {
            switch (operador)
            {
                case "+":
                    num = num + Convert.ToDouble(textBox1.Text);
                    textBox1.Text = Convert.ToString(num);
                    break;

                case "-":
                    num = num - Convert.ToDouble(textBox1.Text);
                    textBox1.Text = Convert.ToString(num);
                    break;

                case "*":
                    num = num * Convert.ToDouble(textBox1.Text);
                    textBox1.Text = Convert.ToString(num);
                    break;
                case "/":
                    num = num / Convert.ToDouble(textBox1.Text);
                    textBox1.Text = Convert.ToString(num);
                    break;
            }
        
        }
    }
}
