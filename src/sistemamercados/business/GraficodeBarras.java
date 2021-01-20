/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamercados.business;

import java.awt.Dimension;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Marcelo
 */
public class GraficodeBarras {
    
    public CategoryDataset createDataSet(List<Vendas> listaDeVendas){
            DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
            for(Vendas venda : listaDeVendas){
                dataSet.addValue(venda.getTotalVenda(),String.valueOf(venda.getIdCompra()),venda.getDescProduto());
                
            }
            return dataSet;
    }
    
    public JFreeChart createBarChart(CategoryDataset dataSet){
        JFreeChart graficoBarras = ChartFactory.createBarChart( " Vendas ", " Código das vendas ",  " Valores" , dataSet,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        
        return graficoBarras;
        
    }
    public ChartPanel criarGráfico(List<Vendas> listaDeVendas){
        
    CategoryDataset dataSet = this.createDataSet(listaDeVendas);
    
    JFreeChart grafico = this.createBarChart(dataSet);
    
    ChartPanel painelDoGrafico = new ChartPanel(grafico);
    
    painelDoGrafico.setPreferredSize(new Dimension(400,400));
    
    
    return painelDoGrafico;
    }
}
