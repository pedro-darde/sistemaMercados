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
import sistemamercados.business.Produtos;
import sistemamercados.connection.ConectionFactory;

/**Classe para objetos do tipo ProdutoDao, onde serão contidos, gravação,pesquisa,exclusao.leitura de Fornecedores.
* @author Pedro Heissler Darde
* @version 1.05
* @since Release 02 da aplicação
*/
public class ProdutoDao {
    /** Método para criação de produtos no DB
     * @param p*/
     public void create(Produtos p){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO tabela_produtos (descricao,quantidade,preco,imagemProduto,fornecedor,precoVenda,percentualLucro) VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1,p.getDescricao());
            stmt.setInt(2, p.getQuantidade());
            stmt.setDouble(3, p.getPreco());
            stmt.setBytes(4, p.getImagemProduto());
            stmt.setString(5,p.getFornecedor());
            stmt.setDouble(6, p.getPrecoVenda());
            stmt.setDouble(7,p.getPercentualLucro());
       
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,  " Salvo com sucesso");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,  " Erro ao salvar " + ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt);
        }
    }
    
     /** Método que retorna a lista de produtos contidos no DB
     * @return */
    public List<Produtos> read() {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Produtos> p = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_produtos");
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                Produtos produtos= new Produtos();
                produtos.setCodProd(rs.getInt("idtabela_produtos"));
                produtos.setDescricao(rs.getString("descricao"));
                produtos.setPreco(rs.getDouble("preco"));
                produtos.setQuantidade(rs.getInt("quantidade"));
                produtos.setImagemProduto(rs.getBytes("imagemProduto"));
                produtos.setFornecedor(rs.getString("fornecedor"));
                produtos.setPrecoVenda(rs.getDouble("precoVenda"));
                produtos.setPercentualLucro(rs.getDouble("percentualLucro"));
                p.add(produtos);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return p; 
                
    }
     /** Método que atualiza a tabela de produtos no DB
     * @param p */
       public void update(Produtos p){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE tabela_produtos SET descricao = ?,quantidade = ?,preco = ?,imagemProduto = ?,fornecedor = ? ,precoVenda = ?, percentualLucro = ? WHERE idtabela_produtos = ? ");
            stmt.setString(1,p.getDescricao());
            stmt.setInt(2, p.getQuantidade());
            stmt.setDouble(3, p.getPreco());
            stmt.setBytes(4, p.getImagemProduto());
            stmt.setString(5,p.getFornecedor());
            stmt.setDouble(6, p.getPrecoVenda());
            stmt.setDouble(7, p.getPercentualLucro());
            stmt.setInt(8, p.getCodProd());

            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,  " Atualizado com sucesso ");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,  " Erro ao atualizar " + ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt);
        }
    }
              public void updateQuantidade(Produtos p){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE tabela_produtos SET quantidade = ? WHERE idtabela_produtos = ? ");
            
            stmt.setInt(1, p.getQuantidade());
            stmt.setInt(2, p.getCodProd());
   

            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,  " Atualizado com sucesso ");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,  " Erro ao atualizar " + ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt);
        }
    }
          /** Método que remove produto do DB
     * @param p */
              public void delete(Produtos p){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM tabela_produtos WHERE idtabela_produtos = ? ");

            stmt.setInt(1, p.getCodProd());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,  " Deletado com sucesso");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,  " Erro ao realizar a exclusão" + ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt);
        }
    }
                /** Método que faz a pesquisa por idtabela_produtos no DB
     * @param busca
     * @return  */
                public List<Produtos> search(String busca) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Produtos> p = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_produtos WHERE idtabela_produtos LIKE ? ");
            stmt.setString(1, "%" + busca + "%");
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                Produtos produto = new Produtos();
                produto.setCodProd(rs.getInt("idtabela_produtos"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setImagemProduto(rs.getBytes("imagemProduto"));
                produto.setFornecedor(rs.getString("fornecedor"));
                  produto.setPrecoVenda(rs.getDouble("precoVenda"));
                produto.setPercentualLucro(rs.getDouble("percentualLucro"));
                p.add(produto);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return p; 
                
    }
                  /** Método que faz a pesquisa por descricao no DB
     * @param busca
     * @return  */
                                public List<Produtos> searchbyDesc(String busca) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Produtos> p = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_produtos WHERE descricao LIKE ? ");
            stmt.setString(1, "%" + busca + "%");
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                Produtos produto = new Produtos();
                produto.setCodProd(rs.getInt("idtabela_produtos"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setImagemProduto(rs.getBytes("imagemProduto"));
                produto.setFornecedor(rs.getString("fornecedor"));
                produto.setPrecoVenda(rs.getDouble("precoVenda"));
                produto.setPercentualLucro(rs.getDouble("percentualLucro"));
                
                p.add(produto);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return p; 
                
    }
//                public List<Dados> searchByCod(String busca) {
//        Connection con = ConectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//          List<Dados> d = new ArrayList<>();
//        try {
//            stmt = con.prepareStatement("SELECT * FROM tabela_dados WHERE idempresa LIKE ? ");
//            stmt.setString(1, "%" + busca + "%");
//            rs = stmt.executeQuery();
//            
//          
//            while(rs.next()){
//                Dados dados = new Dados();
//                dados.setIDCADASTRO(rs.getInt("idtabela_dados"));
//                dados.setBAIRRO(rs.getString("bairro"));
//                dados.setCELULAR(rs.getString("celular"));
//                dados.setCEP(rs.getString("cep"));
//                dados.setCIDADE(rs.getString("cidade"));
//                dados.setCNPJ(rs.getString("cnpj"));
//                dados.setCOMPLEMENTO(rs.getString("complemento"));
//                dados.setEMAIL(rs.getString("email"));
//                dados.setFACEBOOK(rs.getString("facebook"));
//                dados.setNOME(rs.getString("nome"));
//                dados.setNUMERO(rs.getInt("numero"));
//                dados.setRUA(rs.getString("rua"));
//                dados.setTELEFONEFIXO(rs.getString("fixo"));
//                dados.setRAMO(rs.getString("ramo"));
//                dados.setCodigoEmpresa(rs.getInt("idempresa"));
//                d.add(dados);
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DadosDao.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            ConectionFactory.closeConnection(con, stmt, rs);
//        }
//        return d; 
//                
//    }
//                 public List<Dados> searchByName(String busca,String busca2) {
//        Connection con = ConectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//          List<Dados> d = new ArrayList<>();
//        try {
//            stmt = con.prepareStatement("SELECT * FROM tabela_dados WHERE nome LIKE ? AND idempresa LIKE ? ");
//            stmt.setString(1, "%" + busca + "%");
//            stmt.setString(2, "%" + busca2 + "%");
//            rs = stmt.executeQuery();
//            
//          
//            while(rs.next()){
//                Dados dados = new Dados();
//                dados.setIDCADASTRO(rs.getInt("idtabela_dados"));
//                dados.setBAIRRO(rs.getString("bairro"));
//                dados.setCELULAR(rs.getString("celular"));
//                dados.setCEP(rs.getString("cep"));
//                dados.setCIDADE(rs.getString("cidade"));
//                dados.setCNPJ(rs.getString("cnpj"));
//                dados.setCOMPLEMENTO(rs.getString("complemento"));
//                dados.setEMAIL(rs.getString("email"));
//                dados.setFACEBOOK(rs.getString("facebook"));
//                dados.setNOME(rs.getString("nome"));
//                dados.setNUMERO(rs.getInt("numero"));
//                dados.setRUA(rs.getString("rua"));
//                dados.setTELEFONEFIXO(rs.getString("fixo"));
//                dados.setRAMO(rs.getString("ramo"));
//                d.add(dados);
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DadosDao.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            ConectionFactory.closeConnection(con, stmt, rs);
//        }
//        return d; 
//                
//    }
//                 public List<Dados> searchByRamo(String busca) {
//        Connection con = ConectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//          List<Dados> d = new ArrayList<>();
//        try {
//            stmt = con.prepareStatement("SELECT * FROM tabela_dados WHERE ramo LIKE ? ");
//            stmt.setString(1, "%" + busca + "%");
//            rs = stmt.executeQuery();
//            
//          
//            while(rs.next()){
//                Dados dados = new Dados();
//                dados.setIDCADASTRO(rs.getInt("idtabela_dados"));
//                dados.setBAIRRO(rs.getString("bairro"));
//                dados.setCELULAR(rs.getString("celular"));
//                dados.setCEP(rs.getString("cep"));
//                dados.setCIDADE(rs.getString("cidade"));
//                dados.setCNPJ(rs.getString("cnpj"));
//                dados.setCOMPLEMENTO(rs.getString("complemento"));
//                dados.setEMAIL(rs.getString("email"));
//                dados.setFACEBOOK(rs.getString("facebook"));
//                dados.setNOME(rs.getString("nome"));
//                dados.setNUMERO(rs.getInt("numero"));
//                dados.setRUA(rs.getString("rua"));
//                dados.setTELEFONEFIXO(rs.getString("fixo"));
//                dados.setRAMO(rs.getString("ramo"));
//                d.add(dados);
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DadosDao.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            ConectionFactory.closeConnection(con, stmt, rs);
//        }
//        return d; 
//                
//    }
//                 public List<Dados> searchName(String busca) {
//        Connection con = ConectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//          List<Dados> d = new ArrayList<>();
//        try {
//            stmt = con.prepareStatement("SELECT * FROM tabela_dados WHERE nome LIKE ? ");
//            stmt.setString(1, "%" + busca + "%");
//            rs = stmt.executeQuery();
//            
//          
//            while(rs.next()){
//                Dados dados = new Dados();
//                dados.setIDCADASTRO(rs.getInt("idtabela_dados"));
//                dados.setBAIRRO(rs.getString("bairro"));
//                dados.setCELULAR(rs.getString("celular"));
//                dados.setCEP(rs.getString("cep"));
//                dados.setCIDADE(rs.getString("cidade"));
//                dados.setCNPJ(rs.getString("cnpj"));
//                dados.setCOMPLEMENTO(rs.getString("complemento"));
//                dados.setEMAIL(rs.getString("email"));
//                dados.setFACEBOOK(rs.getString("facebook"));
//                dados.setNOME(rs.getString("nome"));
//                dados.setNUMERO(rs.getInt("numero"));
//                dados.setRUA(rs.getString("rua"));
//                dados.setTELEFONEFIXO(rs.getString("fixo"));
//                dados.setRAMO(rs.getString("ramo"));
//                d.add(dados);
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DadosDao.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            ConectionFactory.closeConnection(con, stmt, rs);
//        }
//        return d; 
//                
//    }
}
