/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.pesquisas.JDlgUsuariosPesquisa;
import aulas.*;
import bean.UsuariosJmbv;
import dao.Usuarios_DAO;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author u05366703158
 */
public class JDlgUsuarios extends javax.swing.JDialog {

    private boolean incluindo;//aqui pra ser global

    MaskFormatter mascaraCpf;
    MaskFormatter mascaraDataNascimento;

    //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * Creates new form JDlgUsuarios
     */
    public JDlgUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Util.habilitar(false, jTxtCodigo_jmbv, jTxtNome_jmbv, jTxtApelido_jmbv, jFmtCpf_jmbv, jFmtDataNascimento_jmbv, jPwfSenha_jmbv, jCboNivel_jmbv, jChbAtivo_jmbv, jBtnConfirmar_jmbv, jBtnCancelar_jmbv);
        Util.habilitar(true, jBtnIncluir_jmbv, jBtnAlterar_jmbv, jBtnExcluir_jmbv, jBtnAlterar_jmbv);
        setLocationRelativeTo(null);
        setTitle("Cadastro de Usuários");
        //fazendo a mascara por codigo
        try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraDataNascimento = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtCpf_jmbv.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf));
        jFmtDataNascimento_jmbv.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNascimento));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtCodigo_jmbv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtNome_jmbv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtApelido_jmbv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jFmtCpf_jmbv = new javax.swing.JFormattedTextField();
        jFmtDataNascimento_jmbv = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jPwfSenha_jmbv = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCboNivel_jmbv = new javax.swing.JComboBox<>();
        jChbAtivo_jmbv = new javax.swing.JCheckBox();
        jBtnIncluir_jmbv = new javax.swing.JButton();
        jBtnAlterar_jmbv = new javax.swing.JButton();
        jBtnExcluir_jmbv = new javax.swing.JButton();
        jBtnConfirmar_jmbv = new javax.swing.JButton();
        jBtnCancelar_jmbv = new javax.swing.JButton();
        jBtnPesquisa_jmbv = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código");

        jTxtCodigo_jmbv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtCodigo_jmbvFocusGained(evt);
            }
        });
        jTxtCodigo_jmbv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodigo_jmbvActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel3.setText("Apelido");

        jTxtApelido_jmbv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtApelido_jmbvActionPerformed(evt);
            }
        });

        jLabel4.setText("CpF");

        try {
            jFmtCpf_jmbv.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFmtCpf_jmbv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtCpf_jmbvActionPerformed(evt);
            }
        });

        try {
            jFmtDataNascimento_jmbv.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Data de Nascimento");

        jPwfSenha_jmbv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPwfSenha_jmbvActionPerformed(evt);
            }
        });

        jLabel6.setText("Senha");

        jLabel7.setText("Nível");

        jCboNivel_jmbv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Convidado", "Financeiro" }));
        jCboNivel_jmbv.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jCboNivel_jmbvComponentAdded(evt);
            }
        });
        jCboNivel_jmbv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboNivel_jmbvActionPerformed(evt);
            }
        });

        jChbAtivo_jmbv.setText("Ativo");
        jChbAtivo_jmbv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChbAtivo_jmbvActionPerformed(evt);
            }
        });

        jBtnIncluir_jmbv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnIncluir_jmbv.setText("Incluir");
        jBtnIncluir_jmbv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluir_jmbvActionPerformed(evt);
            }
        });

        jBtnAlterar_jmbv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterar_jmbv.setText("Alterar");
        jBtnAlterar_jmbv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterar_jmbvActionPerformed(evt);
            }
        });

        jBtnExcluir_jmbv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtnExcluir_jmbv.setText("Excluir");
        jBtnExcluir_jmbv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluir_jmbvActionPerformed(evt);
            }
        });

        jBtnConfirmar_jmbv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
        jBtnConfirmar_jmbv.setText("Confirmar");
        jBtnConfirmar_jmbv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmar_jmbvActionPerformed(evt);
            }
        });

        jBtnCancelar_jmbv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelar_jmbv.setText("Cancelar");
        jBtnCancelar_jmbv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelar_jmbvActionPerformed(evt);
            }
        });

        jBtnPesquisa_jmbv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jBtnPesquisa_jmbv.setText("Pesquisar");
        jBtnPesquisa_jmbv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisa_jmbvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluir_jmbv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAlterar_jmbv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnExcluir_jmbv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnConfirmar_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCancelar_jmbv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnPesquisa_jmbv)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTxtNome_jmbv)
                            .addComponent(jTxtApelido_jmbv, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jFmtCpf_jmbv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                                        .addComponent(jPwfSenha_jmbv, javax.swing.GroupLayout.Alignment.LEADING))
                                                    .addComponent(jLabel6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jCboNivel_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jTxtCodigo_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jFmtDataNascimento_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5)
                                            .addComponent(jChbAtivo_jmbv))))
                                .addGap(0, 134, Short.MAX_VALUE)))
                        .addGap(126, 126, 126))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtCodigo_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtNome_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtApelido_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFmtCpf_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtDataNascimento_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPwfSenha_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboNivel_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChbAtivo_jmbv))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnConfirmar_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnCancelar_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnPesquisa_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnExcluir_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnAlterar_jmbv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnIncluir_jmbv, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFmtCpf_jmbvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtCpf_jmbvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtCpf_jmbvActionPerformed

    private void jCboNivel_jmbvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboNivel_jmbvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboNivel_jmbvActionPerformed

    private void jChbAtivo_jmbvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChbAtivo_jmbvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jChbAtivo_jmbvActionPerformed

    private void jPwfSenha_jmbvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPwfSenha_jmbvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPwfSenha_jmbvActionPerformed

    private void jTxtApelido_jmbvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtApelido_jmbvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtApelido_jmbvActionPerformed

/////////////////////////////////////////////////////////////////////////BOTÕES////////////////////////////////////////////////////////////////////////

    private void jBtnIncluir_jmbvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluir_jmbvActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, jTxtCodigo_jmbv, jTxtNome_jmbv, jTxtApelido_jmbv, jFmtCpf_jmbv, jFmtDataNascimento_jmbv, jPwfSenha_jmbv, jCboNivel_jmbv, jChbAtivo_jmbv, jBtnConfirmar_jmbv, jBtnCancelar_jmbv);
        Util.habilitar(false, jBtnIncluir_jmbv, jBtnAlterar_jmbv, jBtnExcluir_jmbv, jBtnAlterar_jmbv);
        Util.limparCampos(jTxtCodigo_jmbv, jTxtNome_jmbv, jTxtApelido_jmbv, jFmtCpf_jmbv, jFmtDataNascimento_jmbv, jPwfSenha_jmbv, jCboNivel_jmbv, jChbAtivo_jmbv, jBtnConfirmar_jmbv, jBtnCancelar_jmbv);
        incluindo = true;
    }//GEN-LAST:event_jBtnIncluir_jmbvActionPerformed


    private void jBtnAlterar_jmbvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterar_jmbvActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, jTxtCodigo_jmbv, jTxtNome_jmbv, jTxtApelido_jmbv, jFmtCpf_jmbv, jFmtDataNascimento_jmbv, jPwfSenha_jmbv, jCboNivel_jmbv, jChbAtivo_jmbv, jBtnConfirmar_jmbv, jBtnCancelar_jmbv);
        Util.habilitar(false, jBtnIncluir_jmbv, jBtnAlterar_jmbv, jBtnExcluir_jmbv, jBtnAlterar_jmbv);
        incluindo = false;
    }//GEN-LAST:event_jBtnAlterar_jmbvActionPerformed

    private void jBtnConfirmar_jmbvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmar_jmbvActionPerformed
        // TODO add your handling code here:

        UsuariosJmbv usuarios = viewBean();
        //jCboNivel.setSelectedIndex
        //int cbo = );//convernte de string pra int
        Usuarios_DAO usuarios_DAO = new Usuarios_DAO();//executa o dao
        if (incluindo == true) {

            usuarios_DAO.insert(usuarios);

            //Double.parseDouble(String,String) double;
        } else {

            usuarios_DAO.update(usuarios);

        }
        Util.habilitar(false, jTxtCodigo_jmbv, jTxtNome_jmbv, jTxtApelido_jmbv, jFmtCpf_jmbv, jFmtDataNascimento_jmbv, jPwfSenha_jmbv, jCboNivel_jmbv, jChbAtivo_jmbv, jBtnConfirmar_jmbv, jBtnCancelar_jmbv);
        Util.habilitar(true, jBtnIncluir_jmbv, jBtnAlterar_jmbv, jBtnExcluir_jmbv, jBtnAlterar_jmbv);
        Util.limparCampos(jTxtCodigo_jmbv, jTxtNome_jmbv, jTxtApelido_jmbv, jFmtCpf_jmbv, jFmtDataNascimento_jmbv, jPwfSenha_jmbv, jCboNivel_jmbv, jChbAtivo_jmbv, jBtnConfirmar_jmbv, jBtnCancelar_jmbv);
    }//GEN-LAST:event_jBtnConfirmar_jmbvActionPerformed

    private void jBtnCancelar_jmbvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelar_jmbvActionPerformed
        // TODO add your handling code here:
        Util.habilitar(false, jTxtCodigo_jmbv, jTxtNome_jmbv, jTxtApelido_jmbv, jFmtCpf_jmbv, jFmtDataNascimento_jmbv, jPwfSenha_jmbv, jCboNivel_jmbv, jChbAtivo_jmbv, jBtnConfirmar_jmbv, jBtnCancelar_jmbv);
        Util.habilitar(true, jBtnIncluir_jmbv, jBtnAlterar_jmbv, jBtnExcluir_jmbv, jBtnAlterar_jmbv);

        //limparCampos();
        Util.limparCampos(jTxtCodigo_jmbv, jTxtNome_jmbv, jTxtApelido_jmbv, jFmtCpf_jmbv, jFmtDataNascimento_jmbv, jPwfSenha_jmbv, jCboNivel_jmbv, jChbAtivo_jmbv, jBtnConfirmar_jmbv, jBtnCancelar_jmbv);//limparCampos();
        Util.mensagem("Operação cancelada.");
    }//GEN-LAST:event_jBtnCancelar_jmbvActionPerformed

    private void jBtnExcluir_jmbvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluir_jmbvActionPerformed
        // TODO add your handling code here:
        //int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmar", JOptionPane.YES_NO_OPTION);//null centraliza no meio do monitor//mensagem//titulo//os botoes

        //if(resp == 0){//0 e o sim
        if(Util.perguntar("Deseja excluir o registro") == true){
        //constante serve pra deixar  o codigo mais claro//classe usando um metodo estatico, estatico nao precisa instanciar a classe

            UsuariosJmbv usuarios = viewBean();
            Usuarios_DAO usuarios_DAO = new Usuarios_DAO();//executa o dao
            usuarios_DAO.delete(usuarios);

            //usuarios_DAO.insert(viewBean());//pra fazer direto
        } else {
            //JOptionPane.showMessageDialog(null, "Exclusão cancelada.", "Alerta", 2);
            Util.mensagem("Exclusão cancelada.");
        }
        Util.limparCampos(jTxtCodigo_jmbv, jTxtNome_jmbv, jTxtApelido_jmbv, jFmtCpf_jmbv, jFmtDataNascimento_jmbv, jPwfSenha_jmbv, jCboNivel_jmbv, jChbAtivo_jmbv, jBtnConfirmar_jmbv, jBtnCancelar_jmbv);
    }//GEN-LAST:event_jBtnExcluir_jmbvActionPerformed

    private void jCboNivel_jmbvComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jCboNivel_jmbvComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboNivel_jmbvComponentAdded

    private void jBtnPesquisa_jmbvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisa_jmbvActionPerformed
        // TODO add your handling code here:
//
//        String resp = JOptionPane.showInputDialog(null, "Entre com o Código (PK): ");
//        Usuarios_DAO usuarios_DAO = new Usuarios_DAO();//executa o dao
//        Usuarios usuarios = (Usuarios) usuarios_DAO.list(Integer.valueOf(resp));//faz o polimorfismo pro object do list virar usuarios//(casting: fala que o usuarios que virou object ainda é um usuarios)
//
//        beanView(usuarios)
        /*
        if(jChbAtivo.isSelected() == true){
        usuarios.setAtivo("S");
        }else{
        usuarios.setAtivo("N");
        }

         */
        //usuarios_DAO.list(Integer.valueOf(jTxtCodigo.getText()));

        JDlgUsuariosPesquisa jDlgUsuariosPesquisa = new JDlgUsuariosPesquisa(null, true);
        jDlgUsuariosPesquisa.setTelaPai(this);
        jDlgUsuariosPesquisa.setVisible(true);
    }//GEN-LAST:event_jBtnPesquisa_jmbvActionPerformed

    private void jTxtCodigo_jmbvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCodigo_jmbvFocusGained
        // TODO add your handling code here:
        jTxtCodigo_jmbv.setBackground(Color.gray);
    }//GEN-LAST:event_jTxtCodigo_jmbvFocusGained

    private void jTxtCodigo_jmbvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodigo_jmbvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigo_jmbvActionPerformed

    //como fazer o limpar com o instanceof
    public UsuariosJmbv viewBean() {
        UsuariosJmbv usuarios = new UsuariosJmbv();
        usuarios.setIdusuariosJmbv(Util.strInt(jTxtCodigo_jmbv.getText()));
        usuarios.setNomeJmbv(jTxtNome_jmbv.getText());
        usuarios.setApelidoJmbv(jTxtApelido_jmbv.getText());
        usuarios.setCpfJmbv(jFmtCpf_jmbv.getText());
        //data
        usuarios.setDataNascimentoJmbv(Util.strDate(jFmtDataNascimento_jmbv.getText()));
        usuarios.setSenhaJmbv(jPwfSenha_jmbv.getText());
        usuarios.setNivelJmbv(Integer.valueOf(jCboNivel_jmbv.getSelectedIndex()));//e assim
        //pra inserir no chb
        if (jChbAtivo_jmbv.isSelected() == true) {
            usuarios.setAtivoJmbv("S");
        } else {
            usuarios.setAtivoJmbv("N");
        }

        return usuarios;
    }

    public UsuariosJmbv beanView(UsuariosJmbv usuarios) {
        jTxtCodigo_jmbv.setText(Util.intStr(usuarios.getIdusuariosJmbv()));
        jTxtNome_jmbv.setText(usuarios.getNomeJmbv());
        jTxtApelido_jmbv.setText(usuarios.getApelidoJmbv());
        jFmtCpf_jmbv.setText(usuarios.getCpfJmbv());
        //DATA
        jFmtDataNascimento_jmbv.setText(Util.dateStr(usuarios.getDataNascimentoJmbv()));

        jPwfSenha_jmbv.setText(usuarios.getSenhaJmbv());
        jCboNivel_jmbv.setSelectedIndex(usuarios.getNivelJmbv());//como é inteiro nao precisa converter
        //jCboNivel.setSelectedIndex(Integer.valueOf(usuarios.getApelido()));
        //Integer.valueOf(jCboNivel.getSelectedIndex()

        //pra converter por if
        if (usuarios.getAtivoJmbv().equals("S")) {
            jChbAtivo_jmbv.setSelected(true);
        } else {
            jChbAtivo_jmbv.setSelected(false);
        }

        //jChbAtivo.setSelected(usuarios.getAtivo().equals("S"));//faz direto numa linha
        return usuarios;
    }

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
            java.util.logging.Logger.getLogger(JDlgUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgUsuarios dialog = new JDlgUsuarios(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnAlterar_jmbv;
    private javax.swing.JButton jBtnCancelar_jmbv;
    private javax.swing.JButton jBtnConfirmar_jmbv;
    private javax.swing.JButton jBtnExcluir_jmbv;
    private javax.swing.JButton jBtnIncluir_jmbv;
    private javax.swing.JButton jBtnPesquisa_jmbv;
    private javax.swing.JComboBox<String> jCboNivel_jmbv;
    private javax.swing.JCheckBox jChbAtivo_jmbv;
    private javax.swing.JFormattedTextField jFmtCpf_jmbv;
    private javax.swing.JFormattedTextField jFmtDataNascimento_jmbv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPwfSenha_jmbv;
    private javax.swing.JTextField jTxtApelido_jmbv;
    private javax.swing.JTextField jTxtCodigo_jmbv;
    private javax.swing.JTextField jTxtNome_jmbv;
    // End of variables declaration//GEN-END:variables
}
