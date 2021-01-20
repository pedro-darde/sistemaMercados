/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamercados.business;

/**Classe para objetos do tipo Fornecedores, onde será contidos métodos para,criação e recebimento de
 * atributos relacionados aos fornecedores.
* @author Pedro Heissler Darde
* @version 1.05
* @since Release 02 da aplicação
*/
public class Fornecedor {
    private Integer codigoFornecedor;
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String email;
    
    public Fornecedor(){
        
    }
 /** Método para receber o codigo do Fornecedor
     * @return B*/
    public Integer getCodigoFornecedor() {
        return codigoFornecedor;
    }
/** Método para criação do código do Fornecedo
     * @param codigoFornecedor*/
    public void setCodigoFornecedor(Integer codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }
 /** Método para receber o nome do Fornecedor
     * @return B*/
    public String getNome() {
        return nome;
    }
/** Método para criação do nome do Fornecedor     
 * @param nome*/
    public void setNome(String nome) {
        this.nome = nome;
    }
 /** Método para receber o cnpj do Fornecedor
     * @return CNPJ*/
    public String getCnpj() {
        return cnpj;
    }
/** Método para criação do cnpj do Fornecedor
     * @param cnpj*/
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
