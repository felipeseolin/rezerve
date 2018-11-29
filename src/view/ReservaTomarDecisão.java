/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ReservaRecursoController;
import controller.SituacaoRecursoController;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.Horario;
import model.Login;
import model.Usuario;
import model.Sala;
import model.Situacao;

/**
 *
 * @author Rafael
 */
public class ReservaTomarDecisão extends javax.swing.JFrame {

    private static ReservaRecursoController control = new ReservaRecursoController();
    private Usuario user;

    /**
     * Creates new form Cadastrar
     */
    public ReservaTomarDecisão() {
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

        painelBotoes = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        painelForm = new javax.swing.JPanel();
        labelHorarioInicial = new javax.swing.JLabel();
        labelHorarioFinal = new javax.swing.JLabel();
        labelSala = new javax.swing.JLabel();
        labelSituacao = new javax.swing.JLabel();
        cbHorarioInicial = new javax.swing.JComboBox<>();
        cbHorarioFinal = new javax.swing.JComboBox<>();
        cbSala = new javax.swing.JComboBox<>();
        cbSituacao = new javax.swing.JComboBox<>();
        labelData = new javax.swing.JLabel();
        labelMotivo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taMotivo = new javax.swing.JTextArea();
        dateData = new com.toedter.calendar.JDateChooser();
        labelId = new javax.swing.JLabel();
        spinId = new javax.swing.JSpinner();
        labelUsario = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        passSenha = new javax.swing.JPasswordField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Sala");
        setExtendedState(6);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelBotoesLayout = new javax.swing.GroupLayout(painelBotoes);
        painelBotoes.setLayout(painelBotoesLayout);
        painelBotoesLayout.setHorizontalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelBotoesLayout.createSequentialGroup()
                .addContainerGap(900, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(24, 24, 24))
        );
        painelBotoesLayout.setVerticalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelBotoesLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(28, 28, 28))
        );

        labelHorarioInicial.setText("Horário Inicial:");

        labelHorarioFinal.setText("Horário Final:");

        labelSala.setText("Sala:");

        labelSituacao.setText("Situação:");

        cbHorarioFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHorarioFinalActionPerformed(evt);
            }
        });

        labelData.setText("Data:");

        labelMotivo.setText("Motivo:");

        taMotivo.setColumns(20);
        taMotivo.setRows(5);
        jScrollPane1.setViewportView(taMotivo);

        dateData.setMaxSelectableDate(new java.util.Date(253370775669000L));
        dateData.setMinSelectableDate(new java.util.Date(1542852000000L));

        labelId.setText("Id:");

        labelUsario.setText("Usuário Requisitante:");

        labelEmail.setText("Email do Requisitante:");

        labelSenha.setText("Digite sua senha para confirmar:");

        javax.swing.GroupLayout painelFormLayout = new javax.swing.GroupLayout(painelForm);
        painelForm.setLayout(painelFormLayout);
        painelFormLayout.setHorizontalGroup(
            painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFormLayout.createSequentialGroup()
                        .addComponent(labelSenha)
                        .addGap(42, 42, 42)
                        .addComponent(passSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE))
                    .addGroup(painelFormLayout.createSequentialGroup()
                        .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHorarioInicial)
                            .addComponent(labelHorarioFinal)
                            .addComponent(labelData)
                            .addComponent(labelSala)
                            .addComponent(labelSituacao)
                            .addComponent(labelMotivo))
                        .addGap(79, 79, 79)
                        .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSala, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbHorarioFinal, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFormLayout.createSequentialGroup()
                        .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUsario)
                            .addComponent(labelId)
                            .addComponent(labelEmail))
                        .addGap(35, 35, 35)
                        .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbHorarioInicial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spinId))))
                .addGap(57, 57, 57))
        );
        painelFormLayout.setVerticalGroup(
            painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmail))
                .addGap(18, 18, 18)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMotivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelData, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbHorarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHorarioInicial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHorarioFinal)
                    .addComponent(cbHorarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSala)
                    .addComponent(cbSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSituacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSenha)
                    .addComponent(passSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        labelTitulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Tomar Decisão");

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
            .addComponent(labelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(painelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(71, 71, 71)
                .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbHorarioFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHorarioFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbHorarioFinalActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        decisao();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
        this.dispose();
        new ReservaLista().setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void menuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHomeMouseClicked
        new Home().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_menuHomeMouseClicked

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

    private void mItemRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemRelatoriosActionPerformed
        new RelatoriosHome().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemRelatoriosActionPerformed

    private void mItemEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemEditarUsuarioActionPerformed
        new UsuarioEditarMinhasInfo().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemEditarUsuarioActionPerformed

    private void mItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemSairActionPerformed
        Login.setAutenticado(false);
        Login.setUsuario(null);
        new LoginHome().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mItemSairActionPerformed

    // <editor-fold defaultstate="collapsed" desc=" AUX ">
    /**
     * Método responsável por tratar a requisição de quando o usuário pede para
     * inserir um novo registro
     */
    public void decisao() {
        ArrayList novaLista = new ArrayList();

        try {
            //Testa o login
            Login.setSenha(new String(passSenha.getPassword()));
            Login.doLogin();
            if (!Login.isAutenticado()) {
                JOptionPane.showMessageDialog(this, "Senha incorreta.");
                return;
            }
            //Informações dos campos
            int id = (int) spinId.getValue();
            Date data = dateData.getDate();
            Horario horarioInicial = (Horario) cbHorarioInicial.getSelectedItem();
            int valorHorarioInicial = Horario.valorHorario(horarioInicial);
            Horario horarioFinal = (Horario) cbHorarioFinal.getSelectedItem();
            int valorHorarioFinal = Horario.valorHorario(horarioFinal);
            Sala sala = (Sala) cbSala.getSelectedItem();

            //Logica que verifica reservas
            Situacao situacao = (Situacao) cbSituacao.getSelectedItem();//situacao
            if (situacao.getId() == 1) {
                ArrayList todasReservas = control.listarTodasReservas();
                if (todasReservas != null) {

                    Iterator it = todasReservas.iterator();
                    while (it.hasNext()) {
                        int idLista = (int) it.next();
                        String motivoLista = (String) it.next().toString();
                        Date dataLista = (Date) it.next();
                        Horario horarioInicialLista = (Horario) it.next();
                        int valorHorarioInicialLista = Horario.valorHorario(horarioInicialLista);
                        Horario horarioFinalLista = (Horario) it.next();
                        int valorHorarioFinalLista = Horario.valorHorario(horarioFinalLista);
                        boolean confirmadaLista = (boolean) it.next();
                        Usuario usuarioLista = (Usuario) it.next();
                        Sala salaLista = (Sala) it.next();
                        Situacao situacaoLista = (Situacao) it.next();
                        
                        if (idLista != id //id das reservas devem ser diferentes, para não se autoeliminar
                                && (situacaoLista.getId() == 1 || confirmadaLista) //a reserva da lista deve estar confirmada
                                && situacao.getId() == 1 //o usuario deve estar tentando confirmar essa reserva
                                && data.equals(dataLista) //a data deve ser a mesma
                                && sala.equals(salaLista)
                                && (verificaConflito(valorHorarioInicialLista, 
                                        valorHorarioFinalLista, 
                                        valorHorarioInicial, 
                                        valorHorarioFinal)
                                || (valorHorarioInicial >= valorHorarioInicialLista
                                    && valorHorarioFinal <= valorHorarioFinalLista))) {
                            String message = "Conflito!\n"
                                    + "Já há uma reserva confimada nestas condições, logo a sala estará ocupada.";
                            JOptionPane.showMessageDialog(this, message);
                            return;
                        }
                    }
                }
            }
            //Capturando informações e adicionando a uma lista
            novaLista.add(id);//id
            novaLista.add(taMotivo.getText());//motivo
            novaLista.add(data);//data
            novaLista.add(horarioInicial);//horario inicial
            novaLista.add(horarioFinal);//hoarario final
            if (situacao.getId() == 1) {
                novaLista.add(true);//Confirmada
            } else {
                novaLista.add(false);//Não confirmada
            }
            novaLista.add(user);//usuario
            novaLista.add(sala);//sala
            novaLista.add(cbSituacao.getSelectedItem());//situacao

            //Mandando para o Contoller
            if (control.editarReserva(novaLista)) {
                JOptionPane.showMessageDialog(this, "Sua decisão foi salva!");
                new Home().setVisible(true);
                this.setVisible(false);
                this.dispose();
            }
        } catch (HeadlessException error) {
            String msgErro = "Erro: " + error;
            JOptionPane.showMessageDialog(this, msgErro);
        }
    }
    
    public boolean verificaConflito(int horaInicialConfirmada,
            int horaFinalConfirmada, int horaInicialPretende,
            int horaFinalPretende) {
        boolean horaInicialEncontrada = false;
        boolean horaFinalEncontrada = false;
        for(int i = horaInicialPretende; i <= horaFinalPretende; i++) {
            if(i == horaInicialConfirmada) {
                horaInicialEncontrada = true;
            }
            else if(i == horaFinalConfirmada) {
                horaFinalEncontrada = true;
            }
            if(horaInicialEncontrada || horaFinalEncontrada) {
                return true;
            }
        }
        return false; 
    }

    public void iniciar(int id, String motivo, Date data, Horario horarioInicial,
            Horario horarioFinal, boolean confirmada, Usuario usuario,
            Sala sala, Situacao situacao) {
        this.user = usuario;
        spinId.setValue(id);
        spinId.setEnabled(false);

        taMotivo.setText(motivo);
        taMotivo.setEditable(false);

        dateData.setDate(data);
        dateData.setEnabled(false);

        cbHorarioInicial.addItem(horarioInicial);
        cbHorarioInicial.setSelectedItem(horarioInicial);
        cbHorarioInicial.setEditable(false);

        cbHorarioFinal.addItem(horarioFinal);
        cbHorarioFinal.setSelectedItem(horarioFinal);
        cbHorarioFinal.setEditable(false);

        cbSala.addItem(sala);
        cbSala.setSelectedItem(sala);
        cbSala.setEditable(false);

        tfUsuario.setText(usuario.getpNome() + " " + usuario.getuNome());
        tfUsuario.setEditable(false);

        tfEmail.setText(usuario.getEmail());
        tfEmail.setEditable(false);

        carregaComboBoxes();
    }

    private void carregaComboBoxes() {
        ArrayList lista;
        Iterator iterator;

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
            if (situacao.getId() == 2) {
                cbSituacao.setSelectedItem(situacao);
            }
        }
    }

    // </editor-fold>
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
            java.util.logging.Logger.getLogger(ReservaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservaCadastrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Object> cbHorarioFinal;
    private javax.swing.JComboBox<Object> cbHorarioInicial;
    private javax.swing.JComboBox<Object> cbSala;
    private javax.swing.JComboBox<Object> cbSituacao;
    private com.toedter.calendar.JDateChooser dateData;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelHorarioFinal;
    private javax.swing.JLabel labelHorarioInicial;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelMotivo;
    private javax.swing.JLabel labelSala;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelSituacao;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsario;
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
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelForm;
    private javax.swing.JPasswordField passSenha;
    private javax.swing.JSpinner spinId;
    private javax.swing.JTextArea taMotivo;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
