 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamercados.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistemamercados.business.Produtos;
import sistemamercados.business.Vendas;
import sistemamercados.connection.ConectionFactory;

/**Classe para objetos do tipo VendaDao, onde serão contidos, gravação,pesquisa,exclusao.leitura de Fornecedores.
* @author Pedro Heissler Darde
* @version 1.05
* @since Release 02 da aplicação
*/
public class VendasDao {
     /** Método para criação de Vendas no DB
     * @param v*/
         public void create(Vendas v){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO tabela_vendas (idCompra,idProd,descricao,preco,quantidade,data,totalVenda,prodVendidos,quantidadeVendas,precoProduto) VALUES(?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1,v.getIdCompra());
            stmt.setInt(2,v.getCodProduto());
            stmt.setString(3, v.getDescProduto());
            stmt.setDouble(4,v.getPrecoPago());
            stmt.setInt(5,v.getQuantidade());
            stmt.setDate(6, v.getDataVenda());
            stmt.setDouble(7,v.getTotalVenda());
            stmt.setInt(8,v.getProdVendidos());
            stmt.setInt(9,v.getQuantidadeVendas());
            stmt.setDouble(10, v.getPrecoProduto());
            stmt.executeUpdate();
            
            //JOptionPane.showMessageDialog(null,  " Salvo com sucesso");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,  " Erro ao salvar " + ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt);
        }
    }
    
   /** Método que retorna a lista de vendas contidos no DB
     * @return */  
    public List<Vendas> read() {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Vendas> v = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_vendas");
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                Vendas venda = new Vendas();
                venda.setCodProduto(rs.getInt("idProd"));
                venda.setDescProduto(rs.getString("descricao"));
                venda.setPrecoPago(rs.getDouble("preco"));
                venda.setQuantidade(rs.getInt("quantidade"));
                venda.setDataVenda(rs.getDate("data"));
                venda.setTotalVenda(rs.getDouble("totalVenda"));
                venda.setProdVendidos(rs.getInt("prodVendidos"));
                venda.setQuantidadeVendas(rs.getInt("quantidadeVendas"));
                venda.setPrecoProduto(rs.getDouble("precoProduto"));
                venda.setIdCompra(rs.getInt("idCompra"));
                venda.setCodVenda(rs.getInt("idtabela_vendas"));
                
                v.add(venda);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return v; 
                
    }
       /** Método que faz a pesquisa por descricao na tabela_vendas
     * @param busca
     * @return */ 
     public List<Vendas> searchByDesc(String busca) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Vendas> v = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_vendas WHERE descricao LIKE ? ");
            stmt.setString(1, "%" + busca + "%");
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                Vendas venda = new Vendas();
                venda.setCodProduto(rs.getInt("idProd"));
                venda.setIdCompra(rs.getInt("idCompra"));
                venda.setDescProduto(rs.getString("descricao"));
                venda.setPrecoPago(rs.getDouble("preco"));
                venda.setQuantidade(rs.getInt("quantidade"));
                venda.setDataVenda(rs.getDate("data"));
          
                
                v.add(venda);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return v; 
                
    }
      
     
          /** Método que faz a pesquisa por mes na tabela_vendas
     * @param mes
     * @return */
     public List<Vendas> searchByData(int mes) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Vendas> v = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_vendas WHERE MONTH(data) = ?");
            stmt.setInt(1,  mes );
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                Vendas venda = new Vendas();
                venda.setCodProduto(rs.getInt("idProd"));
                venda.setCodVenda(rs.getInt("idtabela_vendas"));
                venda.setDescProduto(rs.getString("descricao"));
                venda.setPrecoPago(rs.getDouble("preco"));
                venda.setQuantidade(rs.getInt("quantidade"));
                venda.setDataVenda(rs.getDate("data"));
                venda.setIdCompra(rs.getInt("idCompra"));
                
                v.add(venda);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return v; 
                
    }
      /** Método que faz a pesquisa por dia e mes na tabela_vendas
     * @param mes
     * @param dia
     * @return */
 
     public List<Vendas> searchByDataEspecifica(int mes, int dia) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Vendas> v = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_vendas WHERE MONTH(data) = ? AND DAY(data) = ? ");
            stmt.setInt(1,  mes );
            stmt.setInt(2,  dia );
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
               Vendas venda = new Vendas();
                venda.setIdCompra(rs.getInt("idCompra"));
                venda.setCodProduto(rs.getInt("idProd"));
                venda.setCodVenda(rs.getInt("idtabela_vendas"));
                venda.setDescProduto(rs.getString("descricao"));
                venda.setPrecoPago(rs.getDouble("preco"));
                venda.setQuantidade(rs.getInt("quantidade"));
                venda.setDataVenda(rs.getDate("data"));
                venda.setTotalVenda(rs.getDouble("totalVenda"));
                venda.setProdVendidos(rs.getInt("prodVendidos"));
                venda.setQuantidadeVendas(rs.getInt("quantidadeVendas"));
                venda.setPrecoProduto(rs.getDouble("precoProduto"));
               
                
                v.add(venda);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return v; 
                
    }
        /** Método que faz a pesquisa por código na tabela_vendas
     * @param busca
     * @return */
          public List<Vendas> searchByCodVenda(String busca) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Vendas> v = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_vendas WHERE idCompra LIKE ? ");
            stmt.setString(1, "%" + busca + "%");
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                Vendas venda = new Vendas();
                venda.setCodProduto(rs.getInt("idProd"));
                venda.setCodVenda(rs.getInt("idtabela_vendas"));
                venda.setDescProduto(rs.getString("descricao"));
                venda.setPrecoPago(rs.getDouble("preco"));
                venda.setQuantidade(rs.getInt("quantidade"));
                venda.setPrecoProduto(rs.getDouble("precoProduto"));
                venda.setDataVenda(rs.getDate("data"));
                venda.setIdCompra(rs.getInt("idCompra"));
                
                v.add(venda);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return v; 
                
    }
             /** Método que faz a pesquisa por id's diferentes da coluna idtabela_vendas na tabela_vendas
     * @return */
               public List<Vendas> searchByDifference() {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Vendas> v = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_vendas GROUP BY idCompra");
  
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                Vendas venda = new Vendas();
                venda.setCodProduto(rs.getInt("idProd"));
                venda.setCodVenda(rs.getInt("idtabela_vendas"));
                venda.setDescProduto(rs.getString("descricao"));
                venda.setPrecoPago(rs.getDouble("preco"));
                venda.setQuantidade(rs.getInt("quantidade"));
                venda.setDataVenda(rs.getDate("data"));
                venda.setIdCompra(rs.getInt("idCompra"));
                venda.setTotalVenda(rs.getDouble("totalVenda"));
                v.add(venda);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return v; 
                
    }
                   public int getLastId() throws SQLException{
      Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; 
    int lastId;
       
          stmt = con.prepareStatement("SELECT MAX(idCompra) as id FROM tabela_vendas");
          rs = stmt.executeQuery();
          rs.next();
          lastId = rs.getInt("id");
         rs.close();
	stmt.close();
		
	return lastId;
}
}
