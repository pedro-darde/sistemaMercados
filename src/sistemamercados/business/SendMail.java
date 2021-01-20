/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamercados.business;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JOptionPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;


/**
 *
 * @author Marcelo
 */
public class SendMail  {
 public void send(String caminho,String nome_arquivo, String endereco) throws EmailException,AddressException, MessagingException{
     MultiPartEmail email = new MultiPartEmail();
 
     //email.setAuthenticator(new DefaultAuthenticator("pedro.darde@universo.univates.br","Pedrobala123"));
     email.setFrom("pedro.darde@universo.univates.br");
     email.setSubject("  " );
     email.setMsg("     ");
     email.addTo(endereco);
     EmailAttachment attachament = new EmailAttachment();
     attachament.setPath(caminho);
     attachament.setDisposition(EmailAttachment.ATTACHMENT);
     //attachament.setDescription(desc_arquivo);
     attachament.setName(nome_arquivo);
     email.attach(attachament);
     email.send();
     JOptionPane.showMessageDialog(null, "O Email foi enviado para " +endereco + " com sucesso" );
     
 }   
}
