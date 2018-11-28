/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ReservaRecursoController;
import controller.SalaRecursoController;
import controller.SituacaoRecursoController;
import controller.UsuarioRecursoController;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Bloco;
import model.Departamento;
import model.Horario;
import model.Sala;
import model.Situacao;
import model.Usuario;
import model.Login;
import model.TipoSala;
import model.TipoUsuario;

/**
 *
 * @author Rafael
 */
public class ReservaListaFiltros extends javax.swing.JFrame {

    private static ReservaRecursoController control = new ReservaRecursoController();

    /**
     * Creates new form Home
     */
    public ReservaListaFiltros() {
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
                    break;
                case "COMUM":
                    mItemCadastrarSala.setVisible(false);
                    menuGerenciarUsuarios.setVisible(false);
                    mItemListarReservasDecisao.setVisible(false);
                    cbUsuario.setVisible(false);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Usuário não logado!");
                    System.exit(-1);
                    break;
            }
        } else {
            this.dispose();
        }
        carregaComboBox();
        iniciar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        scrollPane = new javax.swing.JScrollPane();
        tabelaReserva = new javax.swing.JTable();
        labelTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelDataInicial = new javax.swing.JLabel();
        labelHorarioInicial = new javax.swing.JLabel();
        labelHorarioFinal = new javax.swing.JLabel();
        labelSala = new javax.swing.JLabel();
        labelSituacao = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        dateDataInicial = new com.toedter.calendar.JDateChooser();
        cbHorarioInicial = new javax.swing.JComboBox<>();
        cbHorarioFinal = new javax.swing.JComboBox<>();
        cbSala = new javax.swing.JComboBox<>();
        cbSituacao = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        labelDataFinal = new javax.swing.JLabel();
        dateDataFinal = new com.toedter.calendar.JDateChooser();
        checkConfirmada = new javax.swing.JCheckBox();
        cbUsuario = new javax.swing.JComboBox<>();
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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reserva de Salas");
        setExtendedState(6);

        tabelaReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Motivo", "Data", "Horário Inicial", "Horário Final", "Confirmada", "Usuário", "Sala", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane.setViewportView(tabelaReserva);

        labelTitulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Gerenciar Reservas");

        labelDataInicial.setText("Data Inicial:");

        labelHorarioInicial.setText("Horário Inicial:");

        labelHorarioFinal.setText("Horário Final:");

        labelSala.setText("Sala:");

        labelSituacao.setText("Situação:");

        labelUsuario.setText("Usuário:");

        cbHorarioInicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));

        cbHorarioFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        labelDataFinal.setText("Data Final:");

        checkConfirmada.setText("Confirmada?");

        cbUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelDataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(183, 183, 183))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(165, 165, 165))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbUsuario, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateDataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelDataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(142, 142, 142))
                            .addComponent(dateDataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbSala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(54, 54, 54)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelSituacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelHorarioInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                .addGap(46, 46, 46))
                            .addComponent(cbHorarioInicial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelHorarioFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                .addGap(53, 53, 53))
                            .addComponent(cbHorarioFinal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cbSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(63, 63, 63)
                        .addComponent(checkConfirmada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDataFinal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelDataInicial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelHorarioInicial)
                            .addComponent(labelHorarioFinal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbHorarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbHorarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario)
                    .addComponent(labelSala)
                    .addComponent(labelSituacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)
                        .addComponent(checkConfirmada)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        filtra();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbUsuarioActionPerformed

    // <editor-fold defaultstate="collapsed" desc=" CRUD ">
    private void carregaComboBox() {
        ArrayList lista;
        Iterator iterator;
        
        cbHorarioInicial.addItem(Horario.M1);
        cbHorarioInicial.addItem(Horario.M2);
        cbHorarioInicial.addItem(Horario.M3);
        cbHorarioInicial.addItem(Horario.M4);
        cbHorarioInicial.addItem(Horario.M5);
        cbHorarioInicial.addItem(Horario.M6);
        cbHorarioInicial.addItem(Horario.T1);
        cbHorarioInicial.addItem(Horario.T2);
        cbHorarioInicial.addItem(Horario.T3);
        cbHorarioInicial.addItem(Horario.T4);
        cbHorarioInicial.addItem(Horario.T5);
        cbHorarioInicial.addItem(Horario.T6);
        cbHorarioInicial.addItem(Horario.N1);
        cbHorarioInicial.addItem(Horario.N2);
        cbHorarioInicial.addItem(Horario.N3);
        cbHorarioInicial.addItem(Horario.N4);
        cbHorarioInicial.addItem(Horario.N5);

        cbHorarioFinal.addItem(Horario.M1);
        cbHorarioFinal.addItem(Horario.M2);
        cbHorarioFinal.addItem(Horario.M3);
        cbHorarioFinal.addItem(Horario.M4);
        cbHorarioFinal.addItem(Horario.M5);
        cbHorarioFinal.addItem(Horario.M6);
        cbHorarioFinal.addItem(Horario.T1);
        cbHorarioFinal.addItem(Horario.T2);
        cbHorarioFinal.addItem(Horario.T3);
        cbHorarioFinal.addItem(Horario.T4);
        cbHorarioFinal.addItem(Horario.T5);
        cbHorarioFinal.addItem(Horario.T6);
        cbHorarioFinal.addItem(Horario.N1);
        cbHorarioFinal.addItem(Horario.N2);
        cbHorarioFinal.addItem(Horario.N3);
        cbHorarioFinal.addItem(Horario.N4);
        cbHorarioFinal.addItem(Horario.N5);

        cbSala.addItem(new Sala());
        SalaRecursoController controlSala = new SalaRecursoController();
        lista = controlSala.listarSala();
        iterator = lista.iterator();
        while (iterator.hasNext()) {
            Sala sala = new Sala(
                    (String) iterator.next(),//ID
                    (int) iterator.next(),//Numero
                    (int) iterator.next(),//Numero de Cadeiras
                    (int) iterator.next(),//Numero de Computadores
                    (String) iterator.next(),//Detalhes
                    (boolean) iterator.next(),//Ativa
                    (TipoSala) iterator.next(),//TipoSala
                    (Departamento) iterator.next(),//Departamento
                    (Bloco) iterator.next()//Bloco
            );
            cbSala.addItem(sala);
        }

        cbSituacao.addItem(new Situacao());
        SituacaoRecursoController controlSituacao = new SituacaoRecursoController();
        lista = controlSituacao.listarSituacoes();
        iterator = lista.iterator();
        while (iterator.hasNext()) {
            Situacao situacao = new Situacao(
                    (int) iterator.next(),//ID
                    (String) iterator.next(),//Nome
                    (String) iterator.next()//Mensagem
            );
            cbSituacao.addItem(situacao);
        }

        cbUsuario.addItem(new Usuario());
        UsuarioRecursoController controlUsuario = new UsuarioRecursoController();
        lista = controlUsuario.listarUsuarios();
        iterator = lista.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = new Usuario(
                    (int) iterator.next(),//ID
                    (String) iterator.next(),//PNome
                    (String) iterator.next(),//UNome
                    (String) iterator.next(),//email
                    (boolean) iterator.next(),//ativo
                    (Departamento) iterator.next(),//departamento
                    (TipoUsuario) iterator.next()//tipo de usuario
            );
            cbUsuario.addItem(usuario);
            cbUsuario.setSelectedIndex(0);
        }
    }

    public void filtra() {
        ArrayList lista = new ArrayList();
        Date dataInicial = dateDataInicial.getDate();
        Date dataFinal = dateDataFinal.getDate();
        if( dataInicial != null && dataFinal != null
                && dataFinal.before(dataInicial)) {
            String erro = "Erro! \nA data final é menor que a inicial.";
            JOptionPane.showMessageDialog(this, erro);
            return;
        }
        lista.add(dataInicial);
        lista.add(dataFinal);
       
        if(cbHorarioInicial.getSelectedItem().getClass() != String.class 
                && cbHorarioFinal.getSelectedItem().getClass() != String.class) {
            int horaInicial = Horario.valorHorario((Horario) cbHorarioInicial.getSelectedItem());
            int horaFinal = Horario.valorHorario((Horario) cbHorarioFinal.getSelectedItem());
            if(horaInicial > horaFinal) {
                String erro = "Erro! \nO horário final é menor que o horário inicial.";
                JOptionPane.showMessageDialog(this, erro);    
                return;
            }
        }
        lista.add(
                cbHorarioInicial.getSelectedItem().getClass() == String.class
                ? null : (Horario) cbHorarioInicial.getSelectedItem()
        );
        lista.add(
                cbHorarioFinal.getSelectedItem().getClass() == String.class
                ? null : (Horario) cbHorarioFinal.getSelectedItem()
        );
        lista.add((boolean) checkConfirmada.isSelected());
        lista.add(
                cbUsuario.getSelectedItem().getClass() == String.class
                ? null : (Usuario) cbUsuario.getSelectedItem()
        );
        lista.add(
                cbSala.getSelectedItem().getClass() == String.class
                ? null : (Sala) cbSala.getSelectedItem()
        );
        lista.add(
                cbSituacao.getSelectedItem().getClass() == String.class
                ? null : (Situacao) cbSituacao.getSelectedItem()
        );
        DefaultTableModel tabela = (DefaultTableModel) tabelaReserva.getModel();
        tabela.setNumRows(0);
        listar(control.listarTodasReservasComFiltro(lista));
    }

    /**
     * Método responsável por tratar a requisição de quando o usuário pede para
     * inserir um novo registro
     */
    public void listar(ArrayList registros) {
        preencheTabela(registros);
    }

    public void iniciar() {
        ArrayList registros = control.listarTodasReservas();
        preencheTabela(registros);
    }

    public void preencheTabela(ArrayList registros) {
        if (registros == null) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(this, "Não há itens.");
            return;
        }
        Iterator iterator = registros.iterator();
        DefaultTableModel tabela = (DefaultTableModel) tabelaReserva.getModel();
        tabela.setNumRows(0);

        while (iterator.hasNext()) {

            int id = (int) iterator.next();
            String motivo = (String) iterator.next().toString();
            Date data = (Date) iterator.next();
            Horario horarioInicial = (Horario) iterator.next();
            Horario horarioFinal = (Horario) iterator.next();
            boolean confirmada = (boolean) iterator.next();
            Usuario usuario = (Usuario) iterator.next();
            Sala sala = (Sala) iterator.next();
            Situacao situacao = (Situacao) iterator.next();

            Object[] dados = {id, motivo, data, horarioInicial, horarioFinal,
                confirmada, usuario, sala, situacao};
            tabela.addRow(dados);
        }
    }

    public void excluir() {
        try {
            int selectedRowIndex = tabelaReserva.getSelectedRow();
            if (selectedRowIndex >= 0) {
                int id = (int) tabelaReserva.getModel().getValueAt(selectedRowIndex, 0);
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Deseja realmente excluir a reserva " + id + "?");
                if (confirm == 0) {
                    DefaultTableModel tabela = (DefaultTableModel) tabelaReserva.getModel();
                    control.excluirReserva(id);
                    tabela.removeRow(selectedRowIndex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhuma reserva selecionada");
            }
        } catch (HeadlessException error) {
            String msgError = "Erro: " + error;
            JOptionPane.showMessageDialog(this, error);
        }
    }

    public void editar() {
        DefaultTableModel tabela = (DefaultTableModel) tabelaReserva.getModel();
        int selectedRowIndex = tabelaReserva.getSelectedRow();

        int id = Integer.parseInt(tabela.getValueAt(selectedRowIndex, 0).toString());
        String motivo = tabela.getValueAt(selectedRowIndex, 1).toString();
        Date data = (Date) tabela.getValueAt(selectedRowIndex, 2);
//        Horario horarioInicial = (Horario) tabela.getValueAt(selectedRowIndex, 3);
//        Horario horarioFinal = (Horario) tabela.getValueAt(selectedRowIndex, 4);
        boolean confirmada = Boolean.parseBoolean(tabela.getValueAt(selectedRowIndex, 6).toString());
//        Usuario usuario = (Usuario) tabela.getValueAt(selectedRowIndex, 6);
//        Sala sala = (Sala) tabela.getValueAt(selectedRowIndex, 7);
//        Situacao situacao = (Situacao) tabela.getValueAt(selectedRowIndex, 8);

        SalaEditar ed = new SalaEditar();
//        ed.iniciar(id, num, cadeiras, computadores, detalhes, ativa);
        ed.setVisible(true);

    }

    // </editor-fold>
    /**
     * @param args
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
            java.util.logging.Logger.getLogger(ReservaListaFiltros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservaListaFiltros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservaListaFiltros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservaListaFiltros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservaListaFiltros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<Object> cbHorarioFinal;
    private javax.swing.JComboBox<Object> cbHorarioInicial;
    private javax.swing.JComboBox<Object> cbSala;
    private javax.swing.JComboBox<Object> cbSituacao;
    private javax.swing.JComboBox<Object> cbUsuario;
    private javax.swing.JCheckBox checkConfirmada;
    private com.toedter.calendar.JDateChooser dateDataFinal;
    private com.toedter.calendar.JDateChooser dateDataInicial;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelDataFinal;
    private javax.swing.JLabel labelDataInicial;
    private javax.swing.JLabel labelHorarioFinal;
    private javax.swing.JLabel labelHorarioInicial;
    private javax.swing.JLabel labelSala;
    private javax.swing.JLabel labelSituacao;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsuario;
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
    private javax.swing.JTable tabelaReserva;
    // End of variables declaration//GEN-END:variables
}
