
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamercados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistemamercados.business.Pedidos;
import sistemamercados.connection.ConectionFactory;

/**Classe para objetos do tipo FornecedoresDao, onde serão contidos, gravação,pesquisa,exclusao.leitura de Fornecedores.
* @author Pedro Heissler Darde
* @version 1.05
* @since Release 02 da aplicação
*/
public class PedidosDao {
    
 /** Método para criação de fornecedor no DB
     * @param p*/
     public void create(Pedidos p){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO tabela_pedidos (idPedido,quantidade,produto,status,precoPago,pesoPedido,pesoProduto,frete,precoTotal,quantidadeTotal,fornecedor) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1,p.getNumeroPedido());
            stmt.setInt(2, p.getQuantidade());
            stmt.setString(3,p.getProduto()); 
            stmt.setBoolean(4, p.getStatus());
            stmt.setDouble(5, p.getPrecoPago());
            stmt.setDouble(6,p.getPesoPedido());
            stmt.setDouble(7,p.getPesoProduto());
            stmt.setDouble(8,p.getFrete());
            stmt.setDouble(9,p.getPrecoTotal());
            stmt.setInt(10,p.getQuantidadeTotal());
            stmt.setString(11,p.getFornecedor());
       
            stmt.executeUpdate();
          
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,  " Erro ao salvar " + ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt);
        }
    }
           public void update(Pedidos p){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE tabela_pedidos SET status = ? WHERE idPedido = ? ");
            stmt.setBoolean(1,p.getStatus());
            stmt.setInt(2, p.getNumeroPedido());
        
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,  " Atualizado com sucesso ");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,  " Erro ao atualizar " + ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt);
        }
    }
                   public List<Pedidos> read() {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Pedidos> p = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_pedidos");
           
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                Pedidos pedido = new Pedidos();
                pedido.setIdtabela_pedidos(rs.getInt("idtabela_pedidos"));
                pedido.setFrete(rs.getDouble("frete"));
                pedido.setNumeroPedido(rs.getInt("idPedido"));
                pedido.setFornecedor(rs.getString("fornecedor"));
                pedido.setPesoPedido(rs.getDouble("pesoPedido"));
                pedido.setPesoProduto(rs.getDouble("pesoProduto"));
                pedido.setPrecoPago(rs.getDouble("precoPago"));
                pedido.setPrecoTotal(rs.getDouble("precoTotal"));
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedido.setStatus(rs.getBoolean("status"));
                pedido.setQuantidadeTotal(rs.getInt("quantidadeTotal"));
                p.add(pedido);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidosDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return p; 
                
    }

        public List<Pedidos> searchByStatus() {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Pedidos> p = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_pedidos WHERE status LIKE ?  GROUP BY idPedido ");
            stmt.setBoolean(1, false);
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                Pedidos pedido = new Pedidos();
                pedido.setIdtabela_pedidos(rs.getInt("idtabela_pedidos"));
                pedido.setFrete(rs.getDouble("frete"));
                pedido.setNumeroPedido(rs.getInt("idPedido"));
                pedido.setFornecedor(rs.getString("fornecedor"));
                pedido.setPesoPedido(rs.getDouble("pesoPedido"));
                pedido.setPesoProduto(rs.getDouble("pesoProduto"));
                pedido.setPrecoPago(rs.getDouble("precoPago"));
                pedido.setPrecoTotal(rs.getDouble("precoTotal"));
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedido.setStatus(rs.getBoolean("status"));
                pedido.setQuantidadeTotal(rs.getInt("quantidadeTotal"));
                p.add(pedido);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidosDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return p; 
                
    }

        public List<Pedidos> searchByIdPedido(String busca) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Pedidos> p = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_pedidos WHERE idPedido LIKE ?");
            stmt.setString(1, busca);
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                Pedidos pedido = new Pedidos();
                pedido.setIdtabela_pedidos(rs.getInt("idtabela_pedidos"));
                pedido.setFrete(rs.getDouble("frete"));
                pedido.setNumeroPedido(rs.getInt("idPedido"));
                pedido.setFornecedor(rs.getString("fornecedor"));
                pedido.setPesoPedido(rs.getDouble("pesoPedido"));
                pedido.setPesoProduto(rs.getDouble("pesoProduto"));
                pedido.setPrecoPago(rs.getDouble("precoPago"));
                pedido.setPrecoTotal(rs.getDouble("precoTotal"));
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedido.setStatus(rs.getBoolean("status"));
                pedido.setQuantidadeTotal(rs.getInt("quantidadeTotal"));
                pedido.setProduto(rs.getString("produto"));
                
                p.add(pedido);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidosDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return p; 
                
    }
                public List<Pedidos> searchByIdPedidoDiferente() {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Pedidos> p = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_pedidos GROUP BY idPedido");
    
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                Pedidos pedido = new Pedidos();
                pedido.setIdtabela_pedidos(rs.getInt("idtabela_pedidos"));
                pedido.setFrete(rs.getDouble("frete"));
                pedido.setNumeroPedido(rs.getInt("idPedido"));
                pedido.setFornecedor(rs.getString("fornecedor"));
                pedido.setPesoPedido(rs.getDouble("pesoPedido"));
                pedido.setPesoProduto(rs.getDouble("pesoProduto"));
                pedido.setPrecoPago(rs.getDouble("precoPago"));
                pedido.setPrecoTotal(rs.getDouble("precoTotal"));
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedido.setStatus(rs.getBoolean("status"));
                pedido.setQuantidadeTotal(rs.getInt("quantidadeTotal"));
                pedido.setProduto(rs.getString("produto"));
                
                p.add(pedido);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidosDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return p; 
                
    }
    public int getLastId() throws SQLException{
      Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; 
    int lastId;
       
          stmt = con.prepareStatement("SELECT MAX(idPedido) as id FROM tabela_pedidos");
          rs = stmt.executeQuery();
          rs.next();
          lastId = rs.getInt("id");
         rs.close();
	stmt.close();
		
	return lastId;
}
            public List<Pedidos> searchByStatusTrue() {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Pedidos> p = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_pedidos WHERE status LIKE ?");
            stmt.setBoolean(1, true);
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                Pedidos pedido = new Pedidos();
                pedido.setProduto(rs.getString("produto"));
                pedido.setIdtabela_pedidos(rs.getInt("idtabela_pedidos"));
                pedido.setFrete(rs.getDouble("frete"));
                pedido.setNumeroPedido(rs.getInt("idPedido"));
                pedido.setFornecedor(rs.getString("fornecedor"));
                pedido.setPesoPedido(rs.getDouble("pesoPedido"));
                pedido.setPesoProduto(rs.getDouble("pesoProduto"));
                pedido.setPrecoPago(rs.getDouble("precoPago"));
                pedido.setPrecoTotal(rs.getDouble("precoTotal"));
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedido.setStatus(rs.getBoolean("status"));
                pedido.setQuantidadeTotal(rs.getInt("quantidadeTotal"));
                p.add(pedido);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidosDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return p; 
                
    }
}
