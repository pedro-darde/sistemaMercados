/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamercados.business;

import java.awt.Image;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo
 */
public class Produtos {
   private Integer codProd;
   private String descricao;
   private double preco;
   private int quantidade;
   private int quantidadeTotal;
   private byte[] imagemProduto;
   private String fornecedor;
   private double precoVenda;
   private double percentualLucro;
   
   
   public Produtos(){
       
   }

    public Integer getCodProd() {
        return codProd;
    }

    public void setCodProd(Integer codProd) {
        this.codProd = codProd;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
   
  public boolean verificaQuantidade(int quantidade){
      if(quantidade > this.getQuantidade()  || this.getQuantidade() < 0){
          JOptionPane.showMessageDialog(null,  " Não há quantidades suficientes ");
          return false;
      }else{
        
          return true;
          
      }
  }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public byte[] getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(byte[] imagemProduto) {
        this.imagemProduto = imagemProduto;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getPercentualLucro() {
        return percentualLucro;
    }

    public void setPercentualLucro(double percentualLucro) {
        this.percentualLucro = percentualLucro;
    }
  
   
    
}
