/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamercados.business;

/**
 *
 * @author Marcelo
 */
public class Pedidos {
   private Integer idtabela_pedidos;
   private Integer numeroPedido;
   private int quantidade;
   private int quantidadeTotal;
   private String produto;
   private boolean status;
   private double precoPago;
   private double precoTotal;
   private double pesoPedido;
   private double pesoProduto;
   private double frete;
   private String fornecedor;
  
    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
   
   
   
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPrecoPago() {
        return precoPago;
    }

    public void setPrecoPago(double precoPago) {
        this.precoPago = precoPago;
    }

    public double getPesoPedido() {
        return pesoPedido;
    }

    public void setPesoPedido(double pesoPedido) {
        this.pesoPedido = pesoPedido;
    }

    public double getPesoProduto() {
        return pesoProduto;
    }

    public void setPesoProduto(double pesoProduto) {
        this.pesoProduto = pesoProduto;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Integer getIdtabela_pedidos() {
        return idtabela_pedidos;
    }

    public void setIdtabela_pedidos(Integer idtabela_pedidos) {
        this.idtabela_pedidos = idtabela_pedidos;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "numeroPedido :" + numeroPedido + "\n quantidade=" + quantidade + "\nquantidadeTotal=" + quantidadeTotal + "\n Produto=" + this.getProduto() + "\n status=" + status + "\nprecoPago=" + precoPago + ", \n precoTotal=" + precoTotal + "\n pesoPedido=" + pesoPedido + "\n pesoProduto=" + pesoProduto + "\n frete=" + frete + "\n fornecedor=" + fornecedor + '}';
    }
   
   
   
   
}
