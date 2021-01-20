/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamercados.view;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sistemamercados.business.Pedidos;
import sistemamercados.dao.FornecedoresDao;
import sistemamercados.dao.PedidosDao;
import sistemamercados.dao.ProdutoDao;

/**
 *
 * @author Marcelo
 */
public class InternalPedido extends javax.swing.JInternalFrame {

    /**
     * Creates new form InternalPedido
     */
    public InternalPedido() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(modelo));
        FornecedoresDao dao = new FornecedoresDao();
        dao.read().forEach(d1 -> {
            jComboBox1.addItem(d1.getNome());
        });
        tf_quantidadeTotal.setEditable(false);
        tf_pesoTotal.setEditable(false);
        tf_valorTotal.setEditable(false);

    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    private void readJTable() {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.addRow(new Object[]{tf_produto.getText(), String.valueOf(jComboBox1.getSelectedItem()),
            tf_quantidade.getText(),
            tf_valorProduto.getText(),
            tf_peso.getText()
        });
        double count1 = 0;
        double count2 = 0;
        int count3 = 0;
        for (int i = 0; i <= jTable1.getRowCount() - 1; i++) {
            count1 += Double.parseDouble(jTable1.getValueAt(i, 2).toString()) * Double.parseDouble(jTable1.getValueAt(i, 3).toString());
            count2 += Double.parseDouble(jTable1.getValueAt(i, 2).toString()) * Double.parseDouble(jTable1.getValueAt(i, 4).toString());
            count3 += Integer.parseInt(jTable1.getValueAt(i, 2).toString());
        }

        tf_valorTotal.setText(String.valueOf(count1));
        tf_pesoTotal.setText(String.valueOf(count2));
        tf_quantidadeTotal.setText(String.valueOf(count3));

    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return dateFormat.format(date);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        tf_produto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tf_quantidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_peso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_frete = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tf_quantidadeTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_pesoTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf_valorTotal = new javax.swing.JTextField();
        tf_valorProduto = new javax.swing.JFormattedTextField();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setClosable(true);
        setTitle("Faça seu pedido");

        jLabel1.setText("Produto : ");

        jLabel2.setText("Fornecedor : ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE" }));

        jLabel3.setText("Quantidade : ");

        jLabel4.setText("Valor do Produto :");

        jLabel5.setText("Peso do Produto :");

        jLabel6.setText("Frete : ");

        jButton1.setText("Finalizar Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Fornecedor", "Quantidade", "Vlr Unitario", "Peso"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Adicionar Produto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Quantidade Total");

        jLabel8.setText("Peso Total Itens");

        jLabel9.setText("Valor Total");

        tf_valorProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_produto)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tf_quantidadeTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_pesoTotal))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jButton2)
                                    .addComponent(jButton1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(82, 82, 82)
                                        .addComponent(jLabel8)))
                                .addGap(0, 147, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(tf_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(tf_valorProduto))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(42, 42, 42))
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(tf_peso)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(tf_valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(80, 80, 80)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(tf_frete, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_valorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_quantidadeTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_frete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_pesoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PedidosDao dao = new PedidosDao();
        Pedidos pedidos = new Pedidos();
        
        try {
            pedidos.setNumeroPedido(dao.getLastId() + 1);
        } catch (SQLException ex) {
            Logger.getLogger(InternalPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
        pedidos.setStatus(false);
        pedidos.setPesoPedido(Double.parseDouble(tf_pesoTotal.getText()));
        pedidos.setQuantidadeTotal(Integer.parseInt(tf_quantidadeTotal.getText()));
        pedidos.setPrecoTotal(Double.parseDouble(tf_valorTotal.getText()));
        for (int i = 0; i <= jTable1.getRowCount() - 1; i++) {
            pedidos.setProduto(jTable1.getValueAt(i, 0).toString());
            pedidos.setFornecedor(jTable1.getValueAt(i, 1).toString());
            pedidos.setQuantidade(Integer.parseInt(jTable1.getValueAt(i, 2).toString().replace(".", ",")));
            pedidos.setPrecoPago(Double.parseDouble(jTable1.getValueAt(i, 3).toString()));
            pedidos.setPesoProduto(Double.parseDouble(jTable1.getValueAt(i, 4).toString()));
            pedidos.setFrete(Double.parseDouble(tf_frete.getText()));
            dao.create(pedidos);
        }
       } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos para poder realizar um pedido" + e);
        }
        
        try {

            File arquivo = new File("pedidos.txt");
            if (arquivo.exists()) {
                FileWriter arquivoTxt = new FileWriter(arquivo, true);
                PrintWriter linhasTxt = new PrintWriter(arquivoTxt);
                //ACREDITO QUE SO PODE TER 42 CARACTERES
                linhasTxt.println("==========" + getDateTime() + "==============");
                linhasTxt.println("PEDIDO DE NÚMER0 " + pedidos.getNumeroPedido() + "=======================");
                linhasTxt.println("===========================================");
                linhasTxt.println("********** NAO E DOCUMENTO FISCAL *********");
                linhasTxt.println("===========================================");
                linhasTxt.println("PRODUTO           QTDE    VALOR UN     PESO");
                //dados da tabela
                for (int x = 0; x < jTable1.getRowCount(); x++) {
                    linhasTxt.print(String.format("%3s    ", jTable1.getModel().getValueAt(x, 0)));
                    linhasTxt.print(String.format("%2s  ", jTable1.getModel().getValueAt(x, 2)));
                    linhasTxt.print(String.format("%2s  ", jTable1.getModel().getValueAt(x, 3)));
                    linhasTxt.print(String.format("%2s ", jTable1.getModel().getValueAt(x, 4)));
                    linhasTxt.println();
                }
                linhasTxt.println("===========================================");
                linhasTxt.println("   INFORMACOES PARA FECHAMENTO DE CONTA    ");
                linhasTxt.println("===========================================");
                linhasTxt.println();
                linhasTxt.println("===========================================");
                linhasTxt.println("                   ------------------------");
                linhasTxt.println("QUANTIDADE TOTAL     " + tf_quantidadeTotal.getText());
                linhasTxt.println("PESO TOTAL           " + tf_pesoTotal.getText());
                linhasTxt.println("VALOR TOTAL          " + tf_valorTotal.getText());
                linhasTxt.println("FRETE                " + tf_frete.getText());
                linhasTxt.println("===========================================");
                linhasTxt.println("       ABRAÇO E VOLTE SEMPRE        ");
                linhasTxt.println("   INFORMACOES PARA FECHAMENTO DE CONTA    ");

                int i = 0;
                while (i < 10) {
                    i++;
                    linhasTxt.println();
                }
                arquivoTxt.close();

                //emiteComanda();
            } else {
                //se naum existir
                arquivo.createNewFile();
                //criaTxt();

            }
        } catch (IOException error) {
            System.out.println("nao encontrei arquivo");
        }

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("documento.pdf"));

            document.open();
            Paragraph pTitulo = new Paragraph(new Phrase(20F, "PEDIDO" + "#000" + pedidos.getNumeroPedido(), FontFactory.getFont(FontFactory.HELVETICA, 18F)));
            pTitulo.setAlignment(Element.ALIGN_CENTER);
            document.add(new Paragraph());

            document.add(new Paragraph(pTitulo));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
            for (int x = 0; x < jTable1.getRowCount(); x++) {
                document.add(new Paragraph(("Produto : " + jTable1.getModel().getValueAt(x, 0).toString())));
                document.add(new Paragraph(("Fornecedor : " + jTable1.getModel().getValueAt(x, 1).toString())));
                document.add(new Paragraph(("Quantidade : " + jTable1.getModel().getValueAt(x, 2).toString())));
                document.add(new Paragraph(("Valor Unitario : " + jTable1.getModel().getValueAt(x, 3).toString())));
                document.add(new Paragraph(("Peso : " + jTable1.getModel().getValueAt(x, 4).toString())));
                document.add(new Paragraph("-----------------------------------"));
            }
            document.add(new Paragraph("TOTAL DE PRODUTOS : " + tf_quantidadeTotal.getText()));
            document.add(new Paragraph("PESO TOTAL : " + tf_pesoTotal.getText() + " KG"));
            document.add(new Paragraph("TOTAL DE PRODUTOS : " + " R$ " + tf_valorTotal.getText()));
            document.add(new Paragraph("FRETE : " + " R$ " + tf_frete.getText()));
            document.add(new Paragraph(getDateTime()));

        } catch (DocumentException | FileNotFoundException ex) {
            System.out.println("Error:" + ex);
        } finally {
            document.close();
        }

        try {
            Desktop.getDesktop().open(new File("documento.pdf"));
        } catch (IOException ex) {
            System.out.println("Error:" + ex);
        }

        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        JOptionPane.showMessageDialog(null, " Pedido Efetuado com sucesso ");
        while (jTable1.getModel().getRowCount() > 0) {
            modelo.removeRow(0);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        readJTable();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tf_frete;
    private javax.swing.JTextField tf_peso;
    private javax.swing.JTextField tf_pesoTotal;
    private javax.swing.JTextField tf_produto;
    private javax.swing.JTextField tf_quantidade;
    private javax.swing.JTextField tf_quantidadeTotal;
    private javax.swing.JFormattedTextField tf_valorProduto;
    private javax.swing.JTextField tf_valorTotal;
    // End of variables declaration//GEN-END:variables
}
