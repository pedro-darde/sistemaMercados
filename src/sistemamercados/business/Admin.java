/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamercados.business;

/**Classe para objetos do tipo Admin, onde serão contidos, valores e métodos para o mesmo.
* @author Pedro Heissler Darde
* @version 1.05
* @since Release 02 da aplicação
*/
public class Admin {

    private  String usuario = "root";

    private  String senha = "pass123";
 /** Método para retorno do nome do usuário
 * @return String - usuario*/
    public String getUsuario() {
        return usuario;
    }
    /**Método que define o nome de usuár
     * @param usuario*/
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
  /** Método para retorno da senha do usuário
 * @return String - senha*/
    public String getSenha() {
        return senha;
    }
  /** Método para definir da senha do usuário
     * @param senha
 */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
