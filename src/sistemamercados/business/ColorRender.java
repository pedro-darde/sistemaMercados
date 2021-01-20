/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamercados.business;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Marcelo
 */
public class ColorRender extends DefaultTableCellRenderer {

    private final int codTabela; // tabela que sofrerá a ação
    private final int columnAlter; // coluna que sofrerá as ações junto com as linhas (pintando uma unica célula)

    public ColorRender(int codTabela, int columnAlter) {
        this.codTabela = codTabela;
        this.columnAlter = columnAlter;
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (isSelected) {
            // define cor e fonte caso a linha esteja selecionada      
            setBackground(table.getSelectionBackground());
            setForeground(Color.WHITE);
        } else {// caso não esteja selecionado...
            setForeground(Color.BLACK); // Volta para cor fonte default
            // define cor zebrada da tabela  
            if (row % 2 == 0) { // pinta a linha de branco quando a linha for par
                setBackground(Color.WHITE);
            } else { // pinta a  linha de cinza quando for impar
                setBackground(new Color(235, 235, 235));
            }
            // Abaixo possui as regras, poderá ser adicionado varias regras diferentes para varias tabelas, 
            try {
                if (codTabela == 1 || codTabela == 2) { //Regra da Tabela 1 e 2 , ambas pintam colunas
                    if (table.getValueAt(row, columnAlter).equals("Aberto")) { // Sempre que a coluna X possuir "Aberto", pinte:
                        if (column == columnAlter) { // Mais um regra: quero que pinte apenas a coluna selecionada pelo columnAlter
                            setFont(new java.awt.Font("Tahoma", 1, 12)); //fonte
                            setForeground(new java.awt.Color(102, 0, 0)); //cor da fonte
                        } else { // cor dos valores que não estão na coluna X, porém deram resultados verdadeiro
                            setForeground(Color.black);
                        }
                    }
                }
                if (codTabela == 3) { // Regra da tabela 3,  ela não possui filtro de coluna, ou seja, irá pintar a linha inteira
                    if (!table.getValueAt(row, 5).equals("")) { // Sempre que a coluna X não possuir valor, pinte:
                        setFont(new java.awt.Font("Tahoma", 1, 12));
                        setForeground(new Color(0, 153, 0));
                    }
                }
            } catch (java.lang.NullPointerException ex) {
            }
        }
        return this;
    }
}
