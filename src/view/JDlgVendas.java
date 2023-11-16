/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.pesquisas.JDlgVendasPesquisa;
import aulas.*;
import bean.ClientesJmbv;
import java.awt.Color;
import dao.Vendas_DAO;
import bean.VendasJmbv;
import bean.VendedorJmbv;
import dao.Clientes_DAO;
import dao.Produtos_DAO;
import dao.VendasProduto_DAO;
import dao.Vendedor_DAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tools.Util;
import view.pesquisas.ProdutosControle;
import view.pesquisas.VendasProdutoControle;

/**
 *
 * @author u05366703158
 */
public class JDlgVendas extends javax.swing.JDialog {

    private boolean incluindo;
    //private JDlgVendasJmbvProduto jDlgVendasJmbvProduto;

    /**
     * Creates new form JDlgVendasJmbv
     */
    public JDlgVendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        desabilitar();
        jBtnConfirmar.setEnabled(false);
        jBtnCancelar.setEnabled(false);
        setLocationRelativeTo(null);
        setTitle("VendasJmbv");
        //this.jDlgVendasJmbvProduto = jDlgVendasJmbvProduto;
        
        //clientes
        Clientes_DAO clientes_DAO = new Clientes_DAO();
        List listaClientes = clientes_DAO.listAll();
        for(int i = 0; i < listaClientes.size(); i++){
            jCboClientes.addItem((ClientesJmbv)listaClientes.get(i));
        }
        
        //vendedor
        Vendedor_DAO vendedor_DAO = new Vendedor_DAO();
        List listaVendedor = vendedor_DAO.listAll();
        for(int i = 0; i < listaVendedor.size(); i++){
            jCboVendedor.addItem((VendedorJmbv) listaVendedor.get(i));
        }
        
        
        
        VendasProduto_DAO vendasProduto_DAO = new VendasProduto_DAO();
        List lista = vendasProduto_DAO.listAll();
        VendasProdutoControle vendasprodutosControle = new VendasProdutoControle();
        //vendasprodutosControle = new VendasProdutoControle();//invoca o produtos controle para controla-lo
        vendasprodutosControle.setList(lista);
        jTable2.setModel(vendasprodutosControle);
        
    }

    public void habilitar() {
        jTxtNumPeido.setEnabled(true);
        jFmtData.setEnabled(true);
        jCboClientes.setEnabled(true);
        jCboVendedor.setEnabled(true);
        jTxtTotal.setEnabled(true);

        jBtnConfirmar.setEnabled(true);
        jBtnCancelar.setEnabled(true);

        jBtnIncluir.setEnabled(false);
        jBtnAlterar.setEnabled(false);
        jBtnExcluir.setEnabled(false);
        jBtnPesquisa.setEnabled(false);
        
        jBtnIncluirProd.setEnabled(true);
        jBtnAlterarProd.setEnabled(true);
        jBtnExcluirProd.setEnabled(true);
    }

    public void desabilitar() {
        jTxtNumPeido.setEnabled(false);
        jFmtData.setEnabled(false);
        jCboClientes.setEnabled(false);
        jCboVendedor.setEnabled(false);
        jTxtTotal.setEnabled(false);

        jBtnConfirmar.setEnabled(false);
        jBtnCancelar.setEnabled(false);

        jBtnIncluir.setEnabled(true);
        jBtnAlterar.setEnabled(true);
        jBtnExcluir.setEnabled(true);
        jBtnPesquisa.setEnabled(true);
        
        jBtnIncluirProd.setEnabled(false);
        jBtnAlterarProd.setEnabled(false);
        jBtnExcluirProd.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jNumVenda = new javax.swing.JLabel();
        jTxtNumPeido = new javax.swing.JTextField();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisa = new javax.swing.JButton();
        jData = new javax.swing.JLabel();
        jCboClientes = new javax.swing.JComboBox<ClientesJmbv>();
        jLblCliente = new javax.swing.JLabel();
        jCboVendedor = new javax.swing.JComboBox<VendedorJmbv>();
        jLblVendedor = new javax.swing.JLabel();
        jTxtTotal = new javax.swing.JTextField();
        jData1 = new javax.swing.JLabel();
        jBtnIncluirProd = new javax.swing.JButton();
        jBtnAlterarProd = new javax.swing.JButton();
        jBtnExcluirProd = new javax.swing.JButton();
        jFmtData = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jNumVenda.setText("Número da venda:");

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jBtnPesquisa.setText("Pesquisar");
        jBtnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisaActionPerformed(evt);
            }
        });

        jData.setText("Data:");

        jCboClientes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCboClientesPropertyChange(evt);
            }
        });

        jLblCliente.setText("Cliente:");

        jLblVendedor.setText("Vendedor:");

        jData1.setText("Total:");

        jBtnIncluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnIncluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirProdActionPerformed(evt);
            }
        });

        jBtnAlterarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarProdActionPerformed(evt);
            }
        });

        jBtnExcluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtnExcluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirProdActionPerformed(evt);
            }
        });

        try {
            jFmtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFmtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtDataActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jNumVenda)
                                    .addComponent(jTxtNumPeido, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jData)
                                        .addGap(105, 105, 105))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jFmtData)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLblCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLblVendedor)
                                    .addComponent(jCboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jData1)
                                    .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtnIncluirProd)
                                    .addComponent(jBtnAlterarProd)
                                    .addComponent(jBtnExcluirProd)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnPesquisa)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNumVenda)
                    .addComponent(jData)
                    .addComponent(jLblCliente)
                    .addComponent(jLblVendedor)
                    .addComponent(jData1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNumPeido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluirProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAlterarProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnExcluirProd))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

/////////////////////////////////////////////////////////////////////////BOTÕES////////////////////////////////////////////////////////////////////////

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        // TODO add your handling code here:
        habilitar();
        //limparCampos();
        incluindo = true;
    }//GEN-LAST:event_jBtnIncluirActionPerformed


    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        // TODO add your handling code here:
        habilitar();
        incluindo = false;
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        // TODO add your handling code here:

        VendasJmbv vendas = viewBean();

        Vendas_DAO vendas_DAO = new Vendas_DAO();//executa o dao
        if (incluindo == true) {
        vendas_DAO.insert(vendas);
        } else {
        vendas_DAO.update(vendas);
        }
        desabilitar();
        limparCampos();
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        desabilitar();
        limparCampos();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmar", JOptionPane.YES_NO_OPTION);//null centraliza no meio do monitor//mensagem//titulo//os botoes

        //if(resp == 0){//0 e o sim
        if (resp == JOptionPane.YES_OPTION) {//constante serve pra deixar  o codigo mais claro//classe usando um metodo estatico, estatico nao precisa instanciar a classe

            VendasJmbv vendas = viewBean();
            Vendas_DAO vendas_DAO = new Vendas_DAO();//executa o dao
            vendas_DAO.delete(vendas);

            //vendas_DAO.insert(viewBean());//pra fazer direto
        } else {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada.", "Alerta", 2);
        }
        limparCampos();
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisaActionPerformed
        // TODO add your handling code here:
/*
        String resp = JOptionPane.showInputDialog(null, "Entre com o Código (PK): ");
        VendasJmbv_DAO vendas_DAO = new VendasJmbv_DAO();//executa o dao
        VendasJmbv vendas = (VendasJmbv) vendas_DAO.list(Integer.valueOf(resp));

        beanView(vendas);
        */


        JDlgVendasPesquisa jDlgVendasJmbvPesquisa = new JDlgVendasPesquisa(null, true);
        jDlgVendasJmbvPesquisa.setTelaPai(this);
        jDlgVendasJmbvPesquisa.setVisible(true);

    }//GEN-LAST:event_jBtnPesquisaActionPerformed

    private void jBtnIncluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirProdActionPerformed
        // TODO add your handling code here:
        
        JDlgVendasProduto jDlgVendasJmbvProduto = new JDlgVendasProduto(null, true);
        jDlgVendasJmbvProduto.setTitle("Incluir Produto");
        jDlgVendasJmbvProduto.setVisible(true);
    }//GEN-LAST:event_jBtnIncluirProdActionPerformed

    private void jBtnAlterarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarProdActionPerformed
        // TODO add your handling code here:
        JDlgVendasProduto jDlgVendasJmbvProduto = new JDlgVendasProduto(null, true);
        jDlgVendasJmbvProduto.setTitle("Alterar Produto");
        jDlgVendasJmbvProduto.setVisible(true);
    }//GEN-LAST:event_jBtnAlterarProdActionPerformed

    private void jBtnExcluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirProdActionPerformed
        // TODO add your handling code here:
        
        int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmar", JOptionPane.YES_NO_OPTION);//null centraliza no meio do monitor//mensagem//titulo//os botoes

        //if(resp == 0){//0 e o sim
        if (resp == JOptionPane.YES_OPTION) {//constante serve pra deixar  o codigo mais claro//classe usando um metodo estatico, estatico nao precisa instanciar a classe

            //VendasJmbv vendas = viewBean();
            //VendasJmbv_DAO vendas_DAO = new VendasJmbv_DAO();//executa o dao
            //vendas_DAO.delete(vendas);

            //vendas_DAO.insert(viewBean());//pra fazer direto
        } else {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada.", "Alerta", 2);
        }
    }//GEN-LAST:event_jBtnExcluirProdActionPerformed

    private void jFmtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtDataActionPerformed

    private void jCboClientesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCboClientesPropertyChange
        // TODO add your handling code here:
        System.out.println("valor " + jCboClientes.getSelectedIndex());
    }//GEN-LAST:event_jCboClientesPropertyChange

    public void limparCampos() {
        //apagar?
        jTxtNumPeido.setText("");
        jFmtData.setText("");
        jCboClientes.setSelectedIndex(-1);
        jCboVendedor.setSelectedIndex(-1);
        jTxtTotal.setText("");
        System.out.println("limpou");
    }

    ;
        
    public VendasJmbv viewBean() {
        VendasJmbv vendas = new VendasJmbv();
        vendas.setIdvendasJmbv(Util.strInt(jTxtNumPeido.getText()));
        vendas.setDataJmbv(Util.strDate(jFmtData.getText()));
        ClientesJmbv clientes1 = (ClientesJmbv) jCboClientes.getSelectedItem();
        vendas.setClienteJmbv(clientes1.getIdclientesJmbv());
        VendedorJmbv vendedor1 = (VendedorJmbv) jCboVendedor.getSelectedItem();
        vendas.setVendedorJmbv(vendedor1.getIdvendedorJmbv());
        vendas.setValorTotalJmbv(Util.strDouble(jTxtTotal.getText()));

        return vendas;
    }

    ;
    
    public VendasJmbv beanView(VendasJmbv vendas) {

        jTxtNumPeido.setText(String.valueOf(vendas.getIdvendasJmbv()));
        jFmtData.setText(Util.dateStr(vendas.getDataJmbv()));
        jCboClientes.setSelectedItem((vendas.getClienteJmbv()));
        System.out.println("ccliente" + vendas.getClienteJmbv());
        jCboVendedor.setSelectedItem(vendas.getVendedorJmbv());
        jTxtTotal.setText(Util.doubleStr(vendas.getValorTotalJmbv()));

        return vendas;
    }

    ;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgVendas dialog = new JDlgVendas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnAlterarProd;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnExcluirProd;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnIncluirProd;
    private javax.swing.JButton jBtnPesquisa;
    private javax.swing.JComboBox<ClientesJmbv> jCboClientes;
    private javax.swing.JComboBox<VendedorJmbv> jCboVendedor;
    private javax.swing.JLabel jData;
    private javax.swing.JLabel jData1;
    private javax.swing.JFormattedTextField jFmtData;
    private javax.swing.JLabel jLblCliente;
    private javax.swing.JLabel jLblVendedor;
    private javax.swing.JLabel jNumVenda;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTxtNumPeido;
    private javax.swing.JTextField jTxtTotal;
    // End of variables declaration//GEN-END:variables
}
