/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamercados.business;

/**
 *
 * @author T-Gamer
 */
public class User {
    private String nomePessoa;
    private String endereçoPessoa;
    private String usuario;
    private String senha;

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getEndereçoPessoa() {
        return endereçoPessoa;
    }

    public void setEndereçoPessoa(String endereçoPessoa) {
        this.endereçoPessoa = endereçoPessoa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
