/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BDController;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author DIPROSI-01
 */
public class RelatoriosHome extends javax.swing.JFrame {
    
    public static final String PDF
            = System.getProperty("user.dir") + "/src/relatorios/Relatorio001.pdf";
    public static final String RELATORIO
            = System.getProperty("user.dir") + "/src/relatorios/Relatorio001.jasper";
    
    /**
     * Creates new form RelatoriosHome
     */
    public RelatoriosHome() {
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        menuHome = new javax.swing.JMenu();
        menuGerenciarSalas = new javax.swing.JMenu();
        mItemCadastrarSala = new javax.swing.JMenuItem();
        mItemListarSalas = new javax.swing.JMenuItem();
        menuGerenciarUsuarios = new javax.swing.JMenu();
        mItemCadastrarUsuario = new javax.swing.JMenuItem();
        mItemListarUsuarios = new javax.swing.JMenuItem();
        menuGerenciarReservas = new javax.swing.JMenu();
        mItemCadastrarReserva = new javax.swing.JMenuItem();
        mItemListarTodasReservas = new javax.swing.JMenuItem();
        mItemListarMinhasReservas = new javax.swing.JMenuItem();
        mItemListarReservasDecisao = new javax.swing.JMenuItem();
        mItemRelatórios = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenu();
        mItemEditarUsuario = new javax.swing.JMenuItem();
        mItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relatórios");
        jLabel1.setToolTipText("");

        jButton1.setText("Relatório de Reservas Geral");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        barraMenu.setToolTipText("");

        menuHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Z25px.png"))); // NOI18N
        menuHome.setText("Home");
        menuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHomeMouseClicked(evt);
            }
        });
        menuHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHomeActionPerformed(evt);
            }
        });
        barraMenu.add(menuHome);

        menuGerenciarSalas.setText("Gerenciar Salas");

        mItemCadastrarSala.setText("Cadastrar Salas");
        mItemCadastrarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemCadastrarSalaActionPerformed(evt);
            }
        });
        menuGerenciarSalas.add(mItemCadastrarSala);

        mItemListarSalas.setText("Listar Salas");
        mItemListarSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemListarSalasActionPerformed(evt);
            }
        });
        menuGerenciarSalas.add(mItemListarSalas);

        barraMenu.add(menuGerenciarSalas);

        menuGerenciarUsuarios.setText("Gerenciar Usuários");

        mItemCadastrarUsuario.setText("Cadastrar Usuários");
        mItemCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemCadastrarUsuarioActionPerformed(evt);
            }
        });
        menuGerenciarUsuarios.add(mItemCadastrarUsuario);

        mItemListarUsuarios.setText("Listar Usuários");
        mItemListarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemListarUsuariosActionPerformed(evt);
            }
        });
        menuGerenciarUsuarios.add(mItemListarUsuarios);

        barraMenu.add(menuGerenciarUsuarios);

        menuGerenciarReservas.setText("Gerenciar Reservas");

        mItemCadastrarReserva.setText("Cadastrar Reserva");
        mItemCadastrarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemCadastrarReservaActionPerformed(evt);
            }
        });
        menuGerenciarReservas.add(mItemCadastrarReserva);

        mItemListarTodasReservas.setText("Listar todas Reservas");
        mItemListarTodasReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemListarTodasReservasActionPerformed(evt);
            }
        });
        menuGerenciarReservas.add(mItemListarTodasReservas);

        mItemListarMinhasReservas.setText("Listar minhas Reservas");
        mItemListarMinhasReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemListarMinhasReservasActionPerformed(evt);
            }
        });
        menuGerenciarReservas.add(mItemListarMinhasReservas);

        mItemListarReservasDecisao.setText("Listar reservas aguardando decisão");
        mItemListarReservasDecisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemListarReservasDecisaoActionPerformed(evt);
            }
        });
        menuGerenciarReservas.add(mItemListarReservasDecisao);

        mItemRelatórios.setText("Gerar Relatórios");
        mItemRelatórios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemRelatóriosActionPerformed(evt);
            }
        });
        menuGerenciarReservas.add(mItemRelatórios);

        barraMenu.add(menuGerenciarReservas);

        menuUsuario.setText("Usuario");

        mItemEditarUsuario.setText("Editar minhas informações");
        mItemEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemEditarUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(mItemEditarUsuario);

        mItemSair.setText("Sair");
        mItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemSairActionPerformed(evt);
            }
        });
        menuUsuario.add(mItemSair);

        barraMenu.add(menuUsuario);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addContainerGap(725, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHomeMouseClicked
        new LoginHome().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_menuHomeMouseClicked

    private void menuHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHomeActionPerformed
        new LoginHome().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_menuHomeActionPerformed

    private void mItemCadastrarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemCadastrarSalaActionPerformed

    }//GEN-LAST:event_mItemCadastrarSalaActionPerformed

    private void mItemListarSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemListarSalasActionPerformed

    }//GEN-LAST:event_mItemListarSalasActionPerformed

    private void mItemCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemCadastrarUsuarioActionPerformed

    }//GEN-LAST:event_mItemCadastrarUsuarioActionPerformed

    private void mItemListarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemListarUsuariosActionPerformed

    }//GEN-LAST:event_mItemListarUsuariosActionPerformed

    private void mItemCadastrarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemCadastrarReservaActionPerformed

    }//GEN-LAST:event_mItemCadastrarReservaActionPerformed

    private void mItemListarTodasReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemListarTodasReservasActionPerformed

    }//GEN-LAST:event_mItemListarTodasReservasActionPerformed

    private void mItemListarMinhasReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemListarMinhasReservasActionPerformed

    }//GEN-LAST:event_mItemListarMinhasReservasActionPerformed

    private void mItemListarReservasDecisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemListarReservasDecisaoActionPerformed

    }//GEN-LAST:event_mItemListarReservasDecisaoActionPerformed

    private void mItemEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemEditarUsuarioActionPerformed

    }//GEN-LAST:event_mItemEditarUsuarioActionPerformed

    private void mItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemSairActionPerformed

    }//GEN-LAST:event_mItemSairActionPerformed

    private void mItemRelatóriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemRelatóriosActionPerformed
        new RelatoriosHome().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemRelatóriosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JasperPrint impressao;
        try {
            BDController bd = new BDController();
            impressao = JasperFillManager.fillReport(
                    RELATORIO,
                    constroiParametros(),
                    bd.conectaBD());
            JasperExportManager.exportReportToPdfFile(impressao, PDF);
            JOptionPane.showMessageDialog(this, "Gerado o arquivo " + PDF);
        } catch (JRException ex) {
            System.err.println("Não foi possível exportar o relatório.\n\n");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private Map constroiParametros() {
        Map params = new HashMap();
        return params;
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
            java.util.logging.Logger.getLogger(RelatoriosHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatoriosHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatoriosHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatoriosHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatoriosHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem mItemCadastrarReserva;
    private javax.swing.JMenuItem mItemCadastrarSala;
    private javax.swing.JMenuItem mItemCadastrarUsuario;
    private javax.swing.JMenuItem mItemEditarUsuario;
    private javax.swing.JMenuItem mItemListarMinhasReservas;
    private javax.swing.JMenuItem mItemListarReservasDecisao;
    private javax.swing.JMenuItem mItemListarSalas;
    private javax.swing.JMenuItem mItemListarTodasReservas;
    private javax.swing.JMenuItem mItemListarUsuarios;
    private javax.swing.JMenuItem mItemRelatórios;
    private javax.swing.JMenuItem mItemSair;
    private javax.swing.JMenu menuGerenciarReservas;
    private javax.swing.JMenu menuGerenciarSalas;
    private javax.swing.JMenu menuGerenciarUsuarios;
    private javax.swing.JMenu menuHome;
    private javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables
}