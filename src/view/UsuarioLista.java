/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UsuarioRecursoController;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Departamento;
import model.Login;
import model.TipoUsuario;
import model.Usuario;

/**
 *
 * @author Rafael
 */
public class UsuarioLista extends javax.swing.JFrame {

    private static UsuarioRecursoController control = new UsuarioRecursoController();

    /**
     * Creates new form Home
     */
    public UsuarioLista() {
        initComponents();
        if (Login.isAutenticado()) {
            Usuario usuario = Login.getUsuario();
            menuUsuario.setText(usuario.toString());
            String sigla = usuario.getTipoUsuario().getSigla();
            switch (sigla) {
                case "ADMIN":
                    mItemListarReservasDecisao.setVisible(false);
                    break;
                case "COORD":
                    mItemCadastrarSala.setVisible(false);
                    mItemCadastrarUsuario.setVisible(false);
                    btnCadastrar.setVisible(false);
                    btnEditar.setVisible(false);
                    btnExcluir.setVisible(false);
                    break;
                case "COMUM":
                    mItemCadastrarSala.setVisible(false);
                    menuGerenciarUsuarios.setVisible(false);
                    mItemListarReservasDecisao.setVisible(false);
                    btnCadastrar.setVisible(false);
                    btnEditar.setVisible(false);
                    btnExcluir.setVisible(false);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Usuário não logado!");
                    System.exit(-1);
                    break;
            }
        } else {
            this.dispose();
        }
        listar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        tabelaUsuario = new javax.swing.JTable();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
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
        menuUsuario = new javax.swing.JMenu();
        mItemEditarUsuario = new javax.swing.JMenuItem();
        mItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reserva de Salas");
        setExtendedState(6);

        tabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Primeiro Nome", "Sobrenome", "Email", "Ativo", "Departamento", "Tipo de Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tabelaUsuarioFocusLost(evt);
            }
        });
        tabelaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaUsuarioMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(tabelaUsuario);

        btnCadastrar.setText("Cadastrar Usuário");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        labelTitulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Gerenciar Usuários");

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
            .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnCadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelaUsuarioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaUsuarioFocusLost

    private void tabelaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaUsuarioMouseClicked
        /*DefaultTableModel tabela = (DefaultTableModel) tabelaSala.getModel();
        int selectedRowIndex = tabelaSala.getSelectedRow();

        tfId.setText(tabela.getValueAt(selectedRowIndex, 0).toString());
        spinNumero.setValue(Integer.parseInt(tabela.getValueAt(selectedRowIndex, 1).toString()));
        spinQuantidadeCadeiras.setValue(Integer.parseInt(tabela.getValueAt(selectedRowIndex, 2).toString()));
        spinQuantidadeComputadores.setValue(Integer.parseInt(tabela.getValueAt(selectedRowIndex, 3).toString()));
        taDetalhes.setText(tabela.getValueAt(selectedRowIndex, 4).toString());
        checkAtiva.setSelected(Boolean.parseBoolean(tabela.getValueAt(selectedRowIndex, 5).toString()));
        cbTipoSala.setSelectedItem(tabela.getValueAt(selectedRowIndex, 8));
        cbDepartamento.setSelectedItem(tabela.getValueAt(selectedRowIndex, 7));
        cbBloco.setSelectedItem(tabela.getValueAt(selectedRowIndex, 6));

        tfId.setEnabled(false);
        btnEditar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnInserir.setEnabled(false);
        JOptionPane.showMessageDialog(this, "Altere os dados desejados no campo acima \nou clique em excluir para apagar os dados.");*/
    }//GEN-LAST:event_tabelaUsuarioMouseClicked

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        new UsuarioCadastrar().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editar();
        listar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void menuHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHomeActionPerformed
        new Home().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_menuHomeActionPerformed

    private void mItemCadastrarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemCadastrarSalaActionPerformed
        new SalaCadastrar().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemCadastrarSalaActionPerformed

    private void mItemListarSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemListarSalasActionPerformed
        new SalaLista().setVisible(true);
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
        new ReservaLista().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemListarTodasReservasActionPerformed

    private void mItemListarMinhasReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemListarMinhasReservasActionPerformed
        this.setVisible(false);
        this.dispose();
        new ReservaListaMinhas().setVisible(true);
    }//GEN-LAST:event_mItemListarMinhasReservasActionPerformed

    private void mItemListarReservasDecisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemListarReservasDecisaoActionPerformed
        this.setVisible(false);
        this.dispose();
        new ReservaListaDecisoes().setVisible(true);
    }//GEN-LAST:event_mItemListarReservasDecisaoActionPerformed

    private void mItemEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemEditarUsuarioActionPerformed
        this.setVisible(false);
        this.dispose();
        new UsuarioEditarMinhasInfo().setVisible(true);
    }//GEN-LAST:event_mItemEditarUsuarioActionPerformed

    private void mItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemSairActionPerformed
        Login.setAutenticado(false);
        Login.setUsuario(null);
        this.setVisible(false);
        this.dispose();
        new LoginHome().setVisible(true);
    }//GEN-LAST:event_mItemSairActionPerformed

    private void menuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHomeMouseClicked
        new Home().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_menuHomeMouseClicked

    /**
     * @param args the command line arguments
     */
    // <editor-fold defaultstate="collapsed" desc=" CRUD ">
    /**
     * Método responsável por tratar a requisição de quando o usuário pede para
     * inserir um novo registro
     */
    public void listar() {
        ArrayList registros = control.listarUsuarios();
        if (registros == null) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(this, "Não há itens.");
            return;
        }
        Iterator iterator = registros.iterator();
        DefaultTableModel tabela = (DefaultTableModel) tabelaUsuario.getModel();
        tabela.setNumRows(0);

        while (iterator.hasNext()) {

            int id = (int) iterator.next();
            String pNome = (String) iterator.next().toString();
            String uNome = (String) iterator.next().toString();
            String email = (String) iterator.next().toString();
            boolean ativo = (boolean) iterator.next();
            Departamento departamento = (Departamento) iterator.next();
            TipoUsuario tipoUsuario = (TipoUsuario) iterator.next();

            Object[] dados = {id, pNome, uNome, email, ativo, departamento,
                tipoUsuario};
            tabela.addRow(dados);
        }
    }

    public void excluir() {
        try {
            int selectedRowIndex = tabelaUsuario.getSelectedRow();
            if (selectedRowIndex >= 0) {
                int id = (int) tabelaUsuario.getModel().getValueAt(selectedRowIndex, 0);
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Deseja realmente excluir o usuário " + id + "?");
                if (confirm == 0) {
                    DefaultTableModel tabela = (DefaultTableModel) tabelaUsuario.getModel();
                    control.excluirUsuario(id);
                    tabela.removeRow(selectedRowIndex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum usuário selecionado");
            }
        } catch (HeadlessException error) {
            String msgError = "Erro: " + error;
            JOptionPane.showMessageDialog(this, error);
        }
    }

    public void editar() {
        DefaultTableModel tabela = (DefaultTableModel) tabelaUsuario.getModel();
        int selectedRowIndex = tabelaUsuario.getSelectedRow();

        int id = Integer.parseInt(tabela.getValueAt(selectedRowIndex, 0).toString());
        String pNome = tabela.getValueAt(selectedRowIndex, 1).toString();
        String uNome = tabela.getValueAt(selectedRowIndex, 2).toString();
        String email = tabela.getValueAt(selectedRowIndex, 3).toString();
        boolean ativa = Boolean.parseBoolean(tabela.getValueAt(selectedRowIndex, 4).toString());
        Departamento departamento = (Departamento) tabela.getValueAt(selectedRowIndex, 5);
        TipoUsuario tipoUsuario = (TipoUsuario) tabela.getValueAt(selectedRowIndex, 6);

        UsuarioEditar janEditar = new UsuarioEditar();
        janEditar.iniciar(id, pNome, uNome, email, ativa, departamento, tipoUsuario);
        janEditar.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }

    // </editor-fold>
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
            java.util.logging.Logger.getLogger(UsuarioLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioLista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
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
    private javax.swing.JMenuItem mItemSair;
    private javax.swing.JMenu menuGerenciarReservas;
    private javax.swing.JMenu menuGerenciarSalas;
    private javax.swing.JMenu menuGerenciarUsuarios;
    private javax.swing.JMenu menuHome;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabelaUsuario;
    // End of variables declaration//GEN-END:variables
}
