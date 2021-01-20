/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamercados.business;

import java.sql.Date;

/**
 *
 * @author Marcelo
 */
public class VendaAtual {
   // private int codVenda;
    private int codProduto;
    private String descProduto;
    private double precoPago;
    private int quantidade;
    private Date dataVenda;
    
//    public int getCodVenda() {
//        return codVenda;
//    }
//
//    public void setCodVenda(int codVenda) {
//        this.codVenda = codVenda;
//    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public double getPrecoPago() {
        return precoPago;
    }

    public void setPrecoPago(double precoPago) {
        this.precoPago = precoPago;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }


  
}
