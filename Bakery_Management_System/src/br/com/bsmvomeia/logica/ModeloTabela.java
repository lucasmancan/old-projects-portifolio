/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bsmvomeia.logica;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mancan
 */
public class ModeloTabela extends AbstractTableModel {

    public ArrayList linhas = null;

    public String[] colunas = null;

    public ModeloTabela(ArrayList linhas, String[] colunas) {
        setLinhas(linhas);
        setColunas(colunas);

    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList dados) {
        linhas = dados;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] nomes) {
        colunas = nomes;
    }

    public int getColumnCont() {
        return colunas.length;
    }

    public int getRowCont() {
        return linhas.size();
    }

    public String getColumnName(int numCol) {
        return colunas[numCol];
    }

    public Object getValueAt(int numLinha, int numColuna) {
        Object linha[] = (Object[]) getLinhas().get(numLinha);
        return linha[numColuna];

    }

    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return colunas.length;
    }

}
