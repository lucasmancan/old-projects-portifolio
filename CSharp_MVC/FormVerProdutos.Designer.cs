namespace prodSystem
{
    partial class FormVerProdutos
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle7 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle8 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle9 = new System.Windows.Forms.DataGridViewCellStyle();
            this.GridViewProdutos = new System.Windows.Forms.DataGridView();
            this.btnNovo = new System.Windows.Forms.Button();
            this.btnRemover = new System.Windows.Forms.Button();
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.txtIdProduto = new System.Windows.Forms.TextBox();
            this.txtNomeProduto = new System.Windows.Forms.TextBox();
            this.txtPrecoProduto = new System.Windows.Forms.MaskedTextBox();
            ((System.ComponentModel.ISupportInitialize)(this.GridViewProdutos)).BeginInit();
            this.SuspendLayout();
            // 
            // GridViewProdutos
            // 
            this.GridViewProdutos.AllowUserToAddRows = false;
            this.GridViewProdutos.AllowUserToDeleteRows = false;
            dataGridViewCellStyle7.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle7.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle7.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle7.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle7.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle7.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle7.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.GridViewProdutos.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle7;
            this.GridViewProdutos.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewCellStyle8.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle8.BackColor = System.Drawing.SystemColors.Window;
            dataGridViewCellStyle8.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle8.ForeColor = System.Drawing.SystemColors.ControlText;
            dataGridViewCellStyle8.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle8.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle8.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
            this.GridViewProdutos.DefaultCellStyle = dataGridViewCellStyle8;
            this.GridViewProdutos.GridColor = System.Drawing.SystemColors.AppWorkspace;
            this.GridViewProdutos.Location = new System.Drawing.Point(320, 25);
            this.GridViewProdutos.MultiSelect = false;
            this.GridViewProdutos.Name = "GridViewProdutos";
            this.GridViewProdutos.ReadOnly = true;
            this.GridViewProdutos.RowHeadersBorderStyle = System.Windows.Forms.DataGridViewHeaderBorderStyle.Single;
            dataGridViewCellStyle9.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle9.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle9.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle9.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle9.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle9.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle9.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.GridViewProdutos.RowHeadersDefaultCellStyle = dataGridViewCellStyle9;
            this.GridViewProdutos.RowHeadersVisible = false;
            this.GridViewProdutos.RowHeadersWidthSizeMode = System.Windows.Forms.DataGridViewRowHeadersWidthSizeMode.AutoSizeToAllHeaders;
            this.GridViewProdutos.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.GridViewProdutos.ShowCellErrors = false;
            this.GridViewProdutos.ShowCellToolTips = false;
            this.GridViewProdutos.ShowEditingIcon = false;
            this.GridViewProdutos.ShowRowErrors = false;
            this.GridViewProdutos.Size = new System.Drawing.Size(289, 304);
            this.GridViewProdutos.TabIndex = 0;
            this.GridViewProdutos.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.GridViewProdutos_CellContentClick);
            // 
            // btnNovo
            // 
            this.btnNovo.BackColor = System.Drawing.Color.LimeGreen;
            this.btnNovo.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btnNovo.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Bold);
            this.btnNovo.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.btnNovo.Location = new System.Drawing.Point(183, 287);
            this.btnNovo.Name = "btnNovo";
            this.btnNovo.Size = new System.Drawing.Size(90, 42);
            this.btnNovo.TabIndex = 1;
            this.btnNovo.Text = "Salvar";
            this.btnNovo.UseVisualStyleBackColor = false;
            this.btnNovo.Click += new System.EventHandler(this.btnNovo_Click);
            // 
            // btnRemover
            // 
            this.btnRemover.BackColor = System.Drawing.Color.Crimson;
            this.btnRemover.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btnRemover.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Bold);
            this.btnRemover.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.btnRemover.Location = new System.Drawing.Point(34, 287);
            this.btnRemover.Name = "btnRemover";
            this.btnRemover.Size = new System.Drawing.Size(90, 42);
            this.btnRemover.TabIndex = 3;
            this.btnRemover.Text = "Remover";
            this.btnRemover.UseVisualStyleBackColor = false;
            this.btnRemover.Click += new System.EventHandler(this.btnRemover_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.label3.Location = new System.Drawing.Point(22, 142);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(50, 20);
            this.label3.TabIndex = 13;
            this.label3.Text = "Preço";
            this.label3.Click += new System.EventHandler(this.label3_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.label2.Location = new System.Drawing.Point(22, 63);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(59, 20);
            this.label2.TabIndex = 12;
            this.label2.Text = "Código";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.label1.Location = new System.Drawing.Point(30, 100);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(51, 20);
            this.label1.TabIndex = 11;
            this.label1.Text = "Nome";
            // 
            // txtIdProduto
            // 
            this.txtIdProduto.Enabled = false;
            this.txtIdProduto.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.txtIdProduto.Location = new System.Drawing.Point(91, 63);
            this.txtIdProduto.Name = "txtIdProduto";
            this.txtIdProduto.ReadOnly = true;
            this.txtIdProduto.Size = new System.Drawing.Size(32, 26);
            this.txtIdProduto.TabIndex = 8;
            this.txtIdProduto.TextChanged += new System.EventHandler(this.txtIdProduto_TextChanged);
            // 
            // txtNomeProduto
            // 
            this.txtNomeProduto.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.txtNomeProduto.Location = new System.Drawing.Point(92, 100);
            this.txtNomeProduto.MaxLength = 45;
            this.txtNomeProduto.Name = "txtNomeProduto";
            this.txtNomeProduto.Size = new System.Drawing.Size(201, 26);
            this.txtNomeProduto.TabIndex = 16;
            // 
            // txtPrecoProduto
            // 
            this.txtPrecoProduto.Culture = new System.Globalization.CultureInfo("");
            this.txtPrecoProduto.Location = new System.Drawing.Point(91, 144);
            this.txtPrecoProduto.Mask = "999,999.00";
            this.txtPrecoProduto.Name = "txtPrecoProduto";
            this.txtPrecoProduto.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.txtPrecoProduto.Size = new System.Drawing.Size(100, 20);
            this.txtPrecoProduto.TabIndex = 18;
            this.txtPrecoProduto.TextMaskFormat = System.Windows.Forms.MaskFormat.ExcludePromptAndLiterals;
            // 
            // FormVerProdutos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CausesValidation = false;
            this.ClientSize = new System.Drawing.Size(624, 368);
            this.Controls.Add(this.txtPrecoProduto);
            this.Controls.Add(this.txtNomeProduto);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtIdProduto);
            this.Controls.Add(this.GridViewProdutos);
            this.Controls.Add(this.btnRemover);
            this.Controls.Add(this.btnNovo);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Name = "FormVerProdutos";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "FormVerProdutos";
            ((System.ComponentModel.ISupportInitialize)(this.GridViewProdutos)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView GridViewProdutos;
        private System.Windows.Forms.Button btnNovo;
        private System.Windows.Forms.Button btnRemover;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtIdProduto;
        private System.Windows.Forms.TextBox txtNomeProduto;
        private System.Windows.Forms.MaskedTextBox txtPrecoProduto;
    }
}