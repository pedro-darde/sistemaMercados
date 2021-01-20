/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamercados.view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author T-Gamer
 */
public class SimpleTableModel extends AbstractTableModel {

private ArrayList linhas = null;
	private String[] colunas = null;
	public String[] getColunas() {return colunas;}
	public ArrayList getLinhas() {return linhas;}
	public void setColunas(String[] strings) {colunas = strings;}
	public void setLinhas(ArrayList list) {linhas = list;}

@Override
	public int getRowCount() {return getLinhas().size();}
@Override
	public int getColumnCount() {return getColunas().length;}
	
@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String[] linha = (String[])getLinhas().get(rowIndex);
		return linha[columnIndex];
	}
	
	public SimpleTableModel(ArrayList dados, String[] colunas, boolean[] edicao) {
		setLinhas(dados);
		setColunas(colunas);
		colsEdicao = edicao;
	}
	
	private boolean[] colsEdicao;
	public boolean isCellEditable(int row, int col) {
		return colsEdicao[col];
	}
	
	public void setValueAt(Object value, int row, int col) {
		String[] linha = (String[])getLinhas().get(row);
		linha[col] = (String)value;
		fireTableCellUpdated(row,col);
	}
	
	public void addRow(String[] dadosLinha) {
		getLinhas().add(dadosLinha);
		int linha = getLinhas().size()-1;
		fireTableRowsInserted(linha,linha);
		return;
	}
	
	public String getColumnName(int col) {
		return getColunas()[col];
	}
	
	public void removeRow(int row) {
		getLinhas().remove(row);
		fireTableRowsDeleted(row,row);
	}
	
	public void limpaTabela() {
		getLinhas().clear();
		fireTableDataChanged();
	}
}
    

