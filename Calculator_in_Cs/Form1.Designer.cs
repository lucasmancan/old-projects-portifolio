namespace WindowsFormsApp1
{
    partial class FrameCalculator
    {
        /// <summary>
        /// Variável de designer necessária.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpar os recursos que estão sendo usados.
        /// </summary>
        /// <param name="disposing">true se for necessário descartar os recursos gerenciados; caso contrário, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código gerado pelo Windows Form Designer

        /// <summary>
        /// Método necessário para suporte ao Designer - não modifique 
        /// o conteúdo deste método com o editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrameCalculator));
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.button4 = new System.Windows.Forms.Button();
            this.button5 = new System.Windows.Forms.Button();
            this.button6 = new System.Windows.Forms.Button();
            this.button7 = new System.Windows.Forms.Button();
            this.button8 = new System.Windows.Forms.Button();
            this.button9 = new System.Windows.Forms.Button();
            this.buttonSoma = new System.Windows.Forms.Button();
            this.buttonMenos = new System.Windows.Forms.Button();
            this.buttonVezes = new System.Windows.Forms.Button();
            this.buttonDividido = new System.Windows.Forms.Button();
            this.button0 = new System.Windows.Forms.Button();
            this.buttonDecimal = new System.Windows.Forms.Button();
            this.buttonLimpar = new System.Windows.Forms.Button();
            this.buttonEnter = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // textBox1
            // 
            this.textBox1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textBox1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.textBox1.Location = new System.Drawing.Point(24, 15);
            this.textBox1.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.textBox1.MaxLength = 1;
            this.textBox1.Name = "textBox1";
            this.textBox1.ReadOnly = true;
            this.textBox1.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.textBox1.Size = new System.Drawing.Size(222, 31);
            this.textBox1.TabIndex = 13;
            this.textBox1.Text = "0,00";
            this.textBox1.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // button1
            // 
            this.button1.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.button1.Location = new System.Drawing.Point(24, 126);
            this.button1.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(45, 45);
            this.button1.TabIndex = 14;
            this.button1.Text = "1";
            this.button1.UseVisualStyleBackColor = false;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // button2
            // 
            this.button2.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.button2.Location = new System.Drawing.Point(83, 126);
            this.button2.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(45, 45);
            this.button2.TabIndex = 15;
            this.button2.Text = "2";
            this.button2.UseVisualStyleBackColor = false;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // button3
            // 
            this.button3.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.button3.Location = new System.Drawing.Point(142, 126);
            this.button3.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(45, 45);
            this.button3.TabIndex = 16;
            this.button3.Text = "3";
            this.button3.UseVisualStyleBackColor = false;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // button4
            // 
            this.button4.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.button4.Location = new System.Drawing.Point(24, 183);
            this.button4.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(45, 45);
            this.button4.TabIndex = 17;
            this.button4.Text = "4";
            this.button4.UseVisualStyleBackColor = false;
            this.button4.Click += new System.EventHandler(this.button4_Click);
            // 
            // button5
            // 
            this.button5.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.button5.Location = new System.Drawing.Point(83, 183);
            this.button5.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.button5.Name = "button5";
            this.button5.Size = new System.Drawing.Size(45, 45);
            this.button5.TabIndex = 18;
            this.button5.Text = "5";
            this.button5.UseVisualStyleBackColor = false;
            this.button5.Click += new System.EventHandler(this.button5_Click);
            // 
            // button6
            // 
            this.button6.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.button6.Location = new System.Drawing.Point(142, 183);
            this.button6.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.button6.Name = "button6";
            this.button6.Size = new System.Drawing.Size(45, 45);
            this.button6.TabIndex = 19;
            this.button6.Text = "6";
            this.button6.UseVisualStyleBackColor = false;
            this.button6.Click += new System.EventHandler(this.button6_Click);
            // 
            // button7
            // 
            this.button7.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.button7.Location = new System.Drawing.Point(24, 240);
            this.button7.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.button7.Name = "button7";
            this.button7.Size = new System.Drawing.Size(45, 45);
            this.button7.TabIndex = 20;
            this.button7.Text = "7";
            this.button7.UseVisualStyleBackColor = false;
            this.button7.Click += new System.EventHandler(this.button7_Click);
            // 
            // button8
            // 
            this.button8.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.button8.Location = new System.Drawing.Point(83, 240);
            this.button8.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.button8.Name = "button8";
            this.button8.Size = new System.Drawing.Size(45, 45);
            this.button8.TabIndex = 21;
            this.button8.Text = "8";
            this.button8.UseVisualStyleBackColor = false;
            this.button8.Click += new System.EventHandler(this.button8_Click);
            // 
            // button9
            // 
            this.button9.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.button9.Location = new System.Drawing.Point(142, 240);
            this.button9.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.button9.Name = "button9";
            this.button9.Size = new System.Drawing.Size(45, 45);
            this.button9.TabIndex = 22;
            this.button9.Text = "9";
            this.button9.UseVisualStyleBackColor = false;
            this.button9.Click += new System.EventHandler(this.button9_Click);
            // 
            // buttonSoma
            // 
            this.buttonSoma.BackColor = System.Drawing.Color.MediumSeaGreen;
            this.buttonSoma.Location = new System.Drawing.Point(24, 69);
            this.buttonSoma.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.buttonSoma.Name = "buttonSoma";
            this.buttonSoma.Size = new System.Drawing.Size(45, 45);
            this.buttonSoma.TabIndex = 23;
            this.buttonSoma.Text = "+";
            this.buttonSoma.UseVisualStyleBackColor = false;
            this.buttonSoma.Click += new System.EventHandler(this.buttonSoma_Click);
            // 
            // buttonMenos
            // 
            this.buttonMenos.BackColor = System.Drawing.Color.MediumSeaGreen;
            this.buttonMenos.Location = new System.Drawing.Point(83, 69);
            this.buttonMenos.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.buttonMenos.Name = "buttonMenos";
            this.buttonMenos.Size = new System.Drawing.Size(45, 45);
            this.buttonMenos.TabIndex = 24;
            this.buttonMenos.Text = "-";
            this.buttonMenos.UseVisualStyleBackColor = false;
            this.buttonMenos.Click += new System.EventHandler(this.buttonMenos_Click);
            // 
            // buttonVezes
            // 
            this.buttonVezes.BackColor = System.Drawing.Color.MediumSeaGreen;
            this.buttonVezes.Location = new System.Drawing.Point(142, 69);
            this.buttonVezes.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.buttonVezes.Name = "buttonVezes";
            this.buttonVezes.Size = new System.Drawing.Size(45, 45);
            this.buttonVezes.TabIndex = 25;
            this.buttonVezes.Text = "*";
            this.buttonVezes.UseVisualStyleBackColor = false;
            this.buttonVezes.Click += new System.EventHandler(this.buttonVezes_Click);
            // 
            // buttonDividido
            // 
            this.buttonDividido.BackColor = System.Drawing.Color.MediumSeaGreen;
            this.buttonDividido.Location = new System.Drawing.Point(201, 69);
            this.buttonDividido.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.buttonDividido.Name = "buttonDividido";
            this.buttonDividido.Size = new System.Drawing.Size(45, 45);
            this.buttonDividido.TabIndex = 26;
            this.buttonDividido.Text = "/";
            this.buttonDividido.UseVisualStyleBackColor = false;
            this.buttonDividido.Click += new System.EventHandler(this.buttonDividido_Click);
            // 
            // button0
            // 
            this.button0.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.button0.Location = new System.Drawing.Point(24, 297);
            this.button0.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.button0.Name = "button0";
            this.button0.Size = new System.Drawing.Size(104, 45);
            this.button0.TabIndex = 27;
            this.button0.Text = "0";
            this.button0.UseVisualStyleBackColor = false;
            this.button0.Click += new System.EventHandler(this.button0_Click);
            // 
            // buttonDecimal
            // 
            this.buttonDecimal.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.buttonDecimal.Location = new System.Drawing.Point(142, 297);
            this.buttonDecimal.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.buttonDecimal.Name = "buttonDecimal";
            this.buttonDecimal.Size = new System.Drawing.Size(45, 45);
            this.buttonDecimal.TabIndex = 28;
            this.buttonDecimal.Text = ",";
            this.buttonDecimal.UseVisualStyleBackColor = false;
            this.buttonDecimal.Click += new System.EventHandler(this.buttonDecimal_Click);
            // 
            // buttonLimpar
            // 
            this.buttonLimpar.BackColor = System.Drawing.Color.IndianRed;
            this.buttonLimpar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonLimpar.Location = new System.Drawing.Point(201, 126);
            this.buttonLimpar.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.buttonLimpar.Name = "buttonLimpar";
            this.buttonLimpar.Size = new System.Drawing.Size(45, 45);
            this.buttonLimpar.TabIndex = 29;
            this.buttonLimpar.Text = "CE";
            this.buttonLimpar.UseVisualStyleBackColor = false;
            this.buttonLimpar.Click += new System.EventHandler(this.buttonLimpar_Click);
            // 
            // buttonEnter
            // 
            this.buttonEnter.BackColor = System.Drawing.Color.MediumSeaGreen;
            this.buttonEnter.Location = new System.Drawing.Point(201, 183);
            this.buttonEnter.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.buttonEnter.Name = "buttonEnter";
            this.buttonEnter.Size = new System.Drawing.Size(45, 159);
            this.buttonEnter.TabIndex = 30;
            this.buttonEnter.Text = "=";
            this.buttonEnter.UseVisualStyleBackColor = false;
            this.buttonEnter.Click += new System.EventHandler(this.buttonEnter_Click);
            // 
            // FrameCalculator
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(12F, 24F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.BackColor = System.Drawing.SystemColors.GradientInactiveCaption;
            this.ClientSize = new System.Drawing.Size(268, 360);
            this.Controls.Add(this.buttonEnter);
            this.Controls.Add(this.buttonLimpar);
            this.Controls.Add(this.buttonDecimal);
            this.Controls.Add(this.button0);
            this.Controls.Add(this.buttonDividido);
            this.Controls.Add(this.buttonVezes);
            this.Controls.Add(this.buttonMenos);
            this.Controls.Add(this.buttonSoma);
            this.Controls.Add(this.button9);
            this.Controls.Add(this.button8);
            this.Controls.Add(this.button7);
            this.Controls.Add(this.button6);
            this.Controls.Add(this.button5);
            this.Controls.Add(this.button4);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.textBox1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.MaximizeBox = false;
            this.Name = "FrameCalculator";
            this.ShowIcon = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Calculator";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.Button button5;
        private System.Windows.Forms.Button button6;
        private System.Windows.Forms.Button button7;
        private System.Windows.Forms.Button button8;
        private System.Windows.Forms.Button button9;
        private System.Windows.Forms.Button buttonSoma;
        private System.Windows.Forms.Button buttonMenos;
        private System.Windows.Forms.Button buttonVezes;
        private System.Windows.Forms.Button buttonDividido;
        private System.Windows.Forms.Button button0;
        private System.Windows.Forms.Button buttonDecimal;
        private System.Windows.Forms.Button buttonLimpar;
        private System.Windows.Forms.Button buttonEnter;
    }
}

