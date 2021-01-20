/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamercados.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sistemamercados.business.Produtos;
import sistemamercados.business.Vendas;
import sistemamercados.dao.ProdutoDao;
import sistemamercados.dao.VendasDao;

/**
 *
 * @author Marcelo
 */
public class InternalVendas extends javax.swing.JInternalFrame {

    KeyEvent e;

    public InternalVendas() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(modelo));
        jTextField3.setEditable(false);
        jTextField1.setEditable(false);
        tf_quantidade.setEditable(false);
        tf_produto.setEditable(false);
        tf_preco.setEditable(false);
        keyPressed();

    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public void readJTable() {
        double precoPago = Double.parseDouble(tf_quantidade.getText()) * Double.parseDouble(tf_preco.getText());
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.addRow(new Object[]{jTextField2.getText(), tf_produto.getText(), tf_quantidade.getText(), precoPago});
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return dateFormat.format(date);
    }

    public void alteraQuantidade() {

        Produtos pro = new Produtos();
        ProdutoDao dao = new ProdutoDao();
        dao.search(jTextField2.getText()).forEach(d1 -> {

            pro.setQuantidade(d1.getQuantidade() - Integer.parseInt(tf_quantidade.getText()));
            pro.setCodProd(Integer.parseInt(jTextField2.getText()));
            dao.updateQuantidade(pro);

        });
    }

    public Date MostraData() {
        //pega data do computador
        Date data = new Date(System.currentTimeMillis());
        //cria o formatador
        SimpleDateFormat dformatador = new SimpleDateFormat("dd/MM/yyyy");
        // cria a string para armazenar data
        dformatador.format(data);

        //retorna o pedido
        return data;

    }

    public void keyPressed() {
        jTextField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent arg0) {
                if (arg0.getKeyCode() == KeyEvent.VK_F5) {
                    tf_quantidade.setEditable(true);
                    tf_quantidade.requestFocus();
                }
            }
        });

    }
//            public void readJtable() {
//
//        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
//        modelo.setNumRows(0);
//        VendasDao dadao = new VendasDao();
//        dadao.read().forEach((d) -> {
//            modelo.addRow(new Object[]{
//                d.getCodVenda(),
//                d.getCodProduto(),
//                d.getDescProduto(),
//                d.getQuantidade(),
//                d.getPrecoPago(),
//                d.getDataVenda()
//      
//         
//
//            });
//        });
//        jTable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                int par = 2;
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    setBackground(Color.LIGHT_GRAY);
//                } else {
//                    setBackground(Color.WHITE);
//                }
//                return this;
//            }
//        });
//
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tf_produto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_preco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_quantidade = new javax.swing.JTextField();
        panelImagem = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Venda de Mercadoria");
        setAutoscrolls(true);

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel1.setText("Código Produto");

        jButton1.setText("Buscar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton1KeyTyped(evt);
            }
        });

        jButton2.setText("Finalizar Venda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("PRODUTO :");

        tf_produto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_produtoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("PREÇO :");

        jLabel6.setText("QUANTIDADE");

        javax.swing.GroupLayout panelImagemLayout = new javax.swing.GroupLayout(panelImagem);
        panelImagem.setLayout(panelImagemLayout);
        panelImagemLayout.setHorizontalGroup(
            panelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelImagemLayout.setVerticalGroup(
            panelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setText("TOTAL");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextField3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31))
        );

        jButton3.setText("Adicionar Item");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Produto", "Descrição", "Quantidade", "Preço"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton4.setText("F5- ALTERAR QUANTIDADE");
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton4KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tf_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(118, 118, 118))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(tf_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(103, 103, 103))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tf_produto, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(panelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tf_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(panelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_quantidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Date data = new Date(System.currentTimeMillis());
        VendasDao dao = new VendasDao();
        Vendas ve = new Vendas();

        try {
            ve.setIdCompra(dao.getLastId() + 1);
        } catch (SQLException ex) {
            Logger.getLogger(InternalVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProdutoDao dao1 = new ProdutoDao();
        dao1.search(jTextField2.getText()).forEach(d1 -> {
        double soma = 0;
            for (int i = 0; i <= jTable1.getRowCount() - 1; i++) {

                ve.setCodProduto(Integer.valueOf(jTable1.getValueAt(i, 0).toString()));
                ve.setDescProduto(jTable1.getValueAt(i, 1).toString());
                ve.setQuantidade(Integer.valueOf(jTable1.getValueAt(i, 2).toString()));
                soma+=Double.valueOf(jTable1.getValueAt(i, 2).toString());
                ve.setPrecoPago(Double.valueOf(jTable1.getValueAt(i, 3).toString()));
                ve.setTotalVenda(Double.parseDouble(jTextField3.getText()));
                ve.setQuantidadeVendas(jTable1.getRowCount());
                ve.setDataVenda(data);
                ve.setPrecoProduto(d1.getPreco());
                ve.setProdVendidos((int) soma);
                dao.create(ve);
            }
            
            try {

                File arquivo = new File("vendas.txt");
                if (arquivo.exists()) {
                    FileWriter arquivoTxt = new FileWriter(arquivo, true);
                    PrintWriter linhasTxt = new PrintWriter(arquivoTxt);
                    //ACREDITO QUE SO PODE TER 42 CARACTERES
                    linhasTxt.println("=======VENDA DE NÚMERO: " + ve.getIdCompra() + "==============");
                    linhasTxt.println("==========" + getDateTime() + "==============");
                    linhasTxt.println("     AMALFI INDUSTRIAS DE ALIMENTOS       ");
                    linhasTxt.println("===========================================");
                    linhasTxt.println("********** NAO E DOCUMENTO FISCAL *********");
                    linhasTxt.println("===========================================");
                    linhasTxt.println("PRODUTO             QTDE      VALOR UN.");
                    //dados da tabela
                    for (int x = 0; x < jTable1.getRowCount(); x++) {
                        linhasTxt.print(String.format("%3s    ", jTable1.getModel().getValueAt(x, 1)));
                        linhasTxt.print(String.format("%5s             ", jTable1.getModel().getValueAt(x, 2)));
                        linhasTxt.print(String.format("%5s            ", jTable1.getModel().getValueAt(x, 3)));
                        linhasTxt.println();
                    }
                    linhasTxt.println("===========================================");
                    linhasTxt.println("   INFORMACOES PARA FECHAMENTO DE CONTA    ");
                    linhasTxt.println("===========================================");
                    linhasTxt.println();
                    linhasTxt.println("===========================================");
                    linhasTxt.println("                   ------------------------");
                    linhasTxt.println("TOTAL R$ _____________________________  " + jTextField3.getText());
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
                Paragraph pTitulo = new Paragraph(new Phrase(20F, "VENDA" + "#000" + ve.getIdCompra(), FontFactory.getFont(FontFactory.HELVETICA, 18F)));
                pTitulo.setAlignment(Element.ALIGN_CENTER);
                document.add(new Paragraph());

                document.add(new Paragraph(pTitulo));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                for (int x = 0; x < jTable1.getRowCount(); x++) {
                    document.add(new Paragraph(("CÓDIGO: " + jTable1.getModel().getValueAt(x, 0).toString())));
                    document.add(new Paragraph(("DESCRIÇÃO: " + jTable1.getModel().getValueAt(x, 1).toString())));
                    document.add(new Paragraph(("QUANTIDADE: " + jTable1.getModel().getValueAt(x, 2).toString())));
                    document.add(new Paragraph(("PREÇO: " + jTable1.getModel().getValueAt(x, 3).toString())));
                    document.add(new Paragraph("-----------------------------------"));
                }
                document.add(new Paragraph("TOTAL DA VENDA : " + jTextField3.getText()));
                document.add(new Paragraph("TOTAL DE ITENS VENDIDOS : " + soma + " UN"));
                document.add(new Paragraph("DATA DA VENDA : " + getDateTime()));

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
            JOptionPane.showMessageDialog(null, " Salvo com sucesso");
            while (jTable1.getModel().getRowCount() > 0) {
                modelo.removeRow(0);
            }

        });


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyTyped

    }//GEN-LAST:event_jButton1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ProdutoDao dadao = new ProdutoDao();

        dadao.search(jTextField2.getText()).forEach(d1 -> {
            tf_produto.setText(d1.getDescricao());
            tf_preco.setText(String.valueOf(d1.getPrecoVenda()));
            tf_quantidade.setText(String.valueOf(1));
            jTextField1.setText(d1.getDescricao());
            ImageIcon icone = new ImageIcon(d1.getImagemProduto());
            icone.setImage(icone.getImage().getScaledInstance(panelImagem.getWidth(), panelImagem.getHeight(), 100));
            jLabel10.setIcon(icone);

        });


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased

    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed

    }//GEN-LAST:event_jTextField2KeyPressed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ProdutoDao dao = new ProdutoDao();

        dao.search(jTextField2.getText()).forEach(d1 -> {

            if (d1.verificaQuantidade(Integer.parseInt(tf_quantidade.getText()))) {

                alteraQuantidade();
                readJTable();
                double count = 0;

                for (int i = 0; i <= jTable1.getRowCount() - 1; i++) {
                    count += Double.parseDouble(jTable1.getValueAt(i, 3).toString());

                }
                jTextField3.setText(String.valueOf(count));
            } else {
                System.out.println(" erro ");
            }
        });
        tf_quantidade.setEditable(false);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_produtoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_produtoKeyTyped
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            tf_quantidade.setEditable(true);
            tf_quantidade.requestFocus();
        }
    }//GEN-LAST:event_tf_produtoKeyTyped

    private void jButton4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyTyped
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            tf_quantidade.setText("fodase");
        }
    }//GEN-LAST:event_jButton4KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel panelImagem;
    private javax.swing.JTextField tf_preco;
    private javax.swing.JTextField tf_produto;
    private javax.swing.JTextField tf_quantidade;
    // End of variables declaration//GEN-END:variables
}
