/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import model.Login;
import model.Usuario;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel;

/**
 *
 * @author Seolin
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        if(Login.isAutenticado()) {
            Usuario usuario = Login.getUsuario();
            menuUsuario.setText(usuario.toString());
            String sigla = usuario.getTipoUsuario().getSigla();
            switch (sigla) {
                case "ADMIN":
                    mItemListarReservasDecisao.setVisible(false);
                    btnReservasDecisoes.setVisible(false);
                    btnReservasDecisoes.setEnabled(false);
                    btnReservasDecisoes.setVisible(false);
                    break;
                case "COORD":
                    mItemCadastrarSala.setVisible(false);
                    mItemCadastrarUsuario.setVisible(false);
                    break;
                case "COMUM":
                    mItemCadastrarSala.setVisible(false);
                    menuGerenciarUsuarios.setVisible(false);
                    btnGerenciarUsuários.setVisible(false);
                    btnReservasDecisoes.setVisible(false);
                    mItemListarReservasDecisao.setVisible(false);
                    btnReservasDecisoes.setEnabled(false);
                    btnReservasDecisoes.setVisible(false);
                    mItemRelatorios.setEnabled(false);
                    mItemRelatorios.setVisible(false);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Usuário não logado!");
                    System.exit(-1);
                    break;
            }
        } else {
            this.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGerenciarSalas = new javax.swing.JButton();
        btnGerenciarUsuários = new javax.swing.JButton();
        btnGerenciarReservas = new javax.swing.JButton();
        btnGerenciarMinhasReservas = new javax.swing.JButton();
        btnReservasDecisoes = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
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
        mItemRelatorios = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenu();
        mItemEditarUsuario = new javax.swing.JMenuItem();
        mItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rezerve");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(6);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png"))
        );

        btnGerenciarSalas.setText("Gerenciar Salas");
        btnGerenciarSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarSalasActionPerformed(evt);
            }
        });

        btnGerenciarUsuários.setText("Gerenciar Usuários");
        btnGerenciarUsuários.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarUsuáriosActionPerformed(evt);
            }
        });

        btnGerenciarReservas.setText("Gerenciar Reservas");
        btnGerenciarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarReservasActionPerformed(evt);
            }
        });

        btnGerenciarMinhasReservas.setText("Gerenciar Minhas Reservas");
        btnGerenciarMinhasReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarMinhasReservasActionPerformed(evt);
            }
        });

        btnReservasDecisoes.setText("Reservas Aguardando Minha Decisão");
        btnReservasDecisoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservasDecisoesActionPerformed(evt);
            }
        });

        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo3.png"))); // NOI18N

        barraMenu.setToolTipText("");

        menuHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo3Menu.png"))); // NOI18N
        menuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHomeMouseClicked(evt);
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

        mItemRelatorios.setText("Gerar Relatórios");
        mItemRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemRelatoriosActionPerformed(evt);
            }
        });
        menuGerenciarReservas.add(mItemRelatorios);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(btnGerenciarUsuários)
                .addGap(61, 61, 61)
                .addComponent(btnGerenciarSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btnGerenciarReservas)
                .addGap(61, 61, 61)
                .addComponent(btnGerenciarMinhasReservas)
                .addGap(62, 62, 62)
                .addComponent(btnReservasDecisoes)
                .addGap(398, 398, 398))
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(labelTitulo)
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGerenciarSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerenciarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerenciarMinhasReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReservasDecisoes, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerenciarUsuários, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerenciarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarReservasActionPerformed
        new ReservaListaFiltros().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnGerenciarReservasActionPerformed

    private void btnGerenciarUsuáriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarUsuáriosActionPerformed
        new UsuarioLista().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnGerenciarUsuáriosActionPerformed

    private void btnGerenciarSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarSalasActionPerformed
        new SalaListaFiltros().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnGerenciarSalasActionPerformed

    private void mItemCadastrarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemCadastrarSalaActionPerformed
        new SalaCadastrar().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemCadastrarSalaActionPerformed

    private void mItemListarSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemListarSalasActionPerformed
        new SalaListaFiltros().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemListarSalasActionPerformed

    private void mItemCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemCadastrarUsuarioActionPerformed
        new UsuarioCadastrar().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemCadastrarUsuarioActionPerformed

    private void mItemListarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemListarUsuariosActionPerformed
        new UsuarioLista().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemListarUsuariosActionPerformed

    private void mItemCadastrarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemCadastrarReservaActionPerformed
        new ReservaCadastrar().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemCadastrarReservaActionPerformed

    private void mItemListarTodasReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemListarTodasReservasActionPerformed
        new ReservaListaFiltros().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemListarTodasReservasActionPerformed

    private void btnGerenciarMinhasReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarMinhasReservasActionPerformed
        new ReservaListaMinhas().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnGerenciarMinhasReservasActionPerformed

    private void btnReservasDecisoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservasDecisoesActionPerformed
        new ReservaListaDecisoes().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnReservasDecisoesActionPerformed

    private void mItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemSairActionPerformed
        Login.setAutenticado(false);
        Login.setUsuario(null);
        new LoginHome().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemSairActionPerformed

    private void mItemListarMinhasReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemListarMinhasReservasActionPerformed
        new ReservaListaMinhas().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemListarMinhasReservasActionPerformed

    private void mItemListarReservasDecisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemListarReservasDecisaoActionPerformed
        new ReservaListaDecisoes().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemListarReservasDecisaoActionPerformed

    private void mItemEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemEditarUsuarioActionPerformed
        new UsuarioEditarMinhasInfo().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemEditarUsuarioActionPerformed

    private void mItemRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemRelatoriosActionPerformed
        new RelatoriosHome().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemRelatoriosActionPerformed

    private void menuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHomeMouseClicked
        new Home().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_menuHomeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new SubstanceGraphiteLookAndFeel());
                } catch (Exception e) {
                    System.out.println("Substance Graphite failed to initialize");
                }
            }
        });
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Home().setVisible(true);
                }
            });
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnGerenciarMinhasReservas;
    private javax.swing.JButton btnGerenciarReservas;
    private javax.swing.JButton btnGerenciarSalas;
    private javax.swing.JButton btnGerenciarUsuários;
    private javax.swing.JButton btnReservasDecisoes;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JMenuItem mItemCadastrarReserva;
    private javax.swing.JMenuItem mItemCadastrarSala;
    private javax.swing.JMenuItem mItemCadastrarUsuario;
    private javax.swing.JMenuItem mItemEditarUsuario;
    private javax.swing.JMenuItem mItemListarMinhasReservas;
    private javax.swing.JMenuItem mItemListarReservasDecisao;
    private javax.swing.JMenuItem mItemListarSalas;
    private javax.swing.JMenuItem mItemListarTodasReservas;
    private javax.swing.JMenuItem mItemListarUsuarios;
    private javax.swing.JMenuItem mItemRelatorios;
    private javax.swing.JMenuItem mItemSair;
    private javax.swing.JMenu menuGerenciarReservas;
    private javax.swing.JMenu menuGerenciarSalas;
    private javax.swing.JMenu menuGerenciarUsuarios;
    private javax.swing.JMenu menuHome;
    private javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables
}
