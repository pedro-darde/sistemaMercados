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
import sistemamercados.business.Fornecedor;
import sistemamercados.connection.ConectionFactory;

/**Classe para objetos do tipo FornecedoresDao, onde serão contidos, gravação,pesquisa,exclusao.leitura de Fornecedores.
* @author Pedro Heissler Darde
* @version 1.05
* @since Release 02 da aplicação
*/
public class FornecedoresDao {
    
 /** Método para criação de fornecedor no DB
     * @param f*/
     public void create(Fornecedor f){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO tabela_fornecedores (nomeFornecedor,cnpjFornecedor,enderecoFornecedor,telefoneFornecedor,emailFornecedor) VALUES(?,?,?,?,?)");
            stmt.setString(1,f.getNome());
            stmt.setString(2, f.getCnpj());
            stmt.setString(3, f.getEndereco());
            stmt.setString(4, f.getEndereco());
            stmt.setString(5, f.getEmail());
       
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,  " Salvo com sucesso");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,  " Erro ao salvar " + ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt);
        }
    }
    
 /** Método que retorna a lista de fornecedores contidos no DB
     * @return */
    public List<Fornecedor> read() {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Fornecedor> f = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_fornecedores");
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigoFornecedor(rs.getInt("codigoFornecedor"));
                fornecedor.setCnpj(rs.getString("cnpjFornecedor"));
                fornecedor.setEmail(rs.getString("emailFornecedor"));
                fornecedor.setEndereco(rs.getString("enderecoFornecedor"));
                fornecedor.setNome(rs.getString("nomeFornecedor"));
                fornecedor.setTelefone(rs.getString("telefoneFornecedor"));
                f.add(fornecedor);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornecedoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return f; 
                
    }
//       public void update(){
//        Connection con = ConectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        
//        try {
//            stmt = (PreparedStatement) con.prepareStatement("UPDATE tabela_produtos SET descricao = ?,quantidade = ?,preco = ?,imagemProduto = ? WHERE idtabela_produtos = ? ");
//            stmt.setString(1,p.getDescricao());
//            stmt.setInt(2, p.getQuantidade());
//            stmt.setDouble(3, p.getPreco());
//            stmt.setBytes(4, p.getImagemProduto());
//            stmt.setInt(5, p.getCodProd());
//
//            
//            
//            stmt.executeUpdate();
//            
//            JOptionPane.showMessageDialog(null,  " Atualizado com sucesso ");
//        } catch (SQLException ex) {
//             JOptionPane.showMessageDialog(null,  " Erro ao atualizar " + ex);
//        }finally{
//            ConectionFactory.closeConnection(con, stmt);
//        }
//    }
 /** Método que remove o Fornecedor do DB
     * @param f*/
              public void delete(Fornecedor f){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM tabela_fornecedores WHERE codigoFornecedor = ? ");

            stmt.setInt(1, f.getCodigoFornecedor());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,  " Deletado com sucesso");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,  " Erro ao realizar a exclusão" + ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt);
        }
    }
              /** Método que faz pesquisa por nome na tabela_fornecedor do DB
     * @param busca
     * @return */
                public List<Fornecedor> search(String busca) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
          List<Fornecedor> f = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela_fornecedores WHERE nomeFornecedor LIKE ? ");
            stmt.setString(1, "%" + busca + "%");
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                 Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigoFornecedor(rs.getInt("codigoFornecedor"));
                fornecedor.setCnpj(rs.getString("cnpjFornecedor"));
                fornecedor.setEmail(rs.getString("emailFornecedor"));
                fornecedor.setEndereco(rs.getString("enderecoFornecedor"));
                fornecedor.setNome(rs.getString("nomeFornecedor"));
                fornecedor.setTelefone(rs.getString("telefoneFornecedor"));
                f.add(fornecedor);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornecedoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return f; 
                
   }
//                                public List<Produtos> searchbyDesc(String busca) {
//        Connection con = ConectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//          List<Produtos> p = new ArrayList<>();
//        try {
//            stmt = con.prepareStatement("SELECT * FROM tabela_produtos WHERE descricao LIKE ? ");
//            stmt.setString(1, "%" + busca + "%");
//            rs = stmt.executeQuery();
//            
//          
//            while(rs.next()){
//                Produtos produto = new Produtos();
//                produto.setCodProd(rs.getInt("idtabela_produtos"));
//                produto.setDescricao(rs.getString("descricao"));
//                produto.setQuantidade(rs.getInt("quantidade"));
//                produto.setPreco(rs.getDouble("preco"));
//                produto.setImagemProduto(rs.getBytes("imagemProduto"));
//                p.add(produto);
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(FornecedoresDao.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            ConectionFactory.closeConnection(con, stmt, rs);
//        }
//        return p; 
//                
//    }
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
