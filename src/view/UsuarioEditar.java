/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DepartamentoRecursoController;
import controller.TipoUsuarioRecursoController;
import controller.UsuarioRecursoController;
import model.BCrypt;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.Departamento;
import model.Login;
import model.TipoUsuario;
import model.Usuario;

/**
 *
 * @author Rafael
 */
public class UsuarioEditar extends javax.swing.JFrame {

    private static UsuarioRecursoController control = new UsuarioRecursoController();

    /**
     * Creates new form Cadastrar
     */
    public UsuarioEditar() {
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
                    menuUsuario.setVisible(false);
                    mItemListarReservasDecisao.setVisible(false);
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

        painelForm = new javax.swing.JPanel();
        tfEmail = new javax.swing.JTextField();
        labelUNome = new javax.swing.JLabel();
        tfUNome = new javax.swing.JTextField();
        tfPNome = new javax.swing.JTextField();
        cbTipoUsuario = new javax.swing.JComboBox<>();
        labelEmail = new javax.swing.JLabel();
        spinId = new javax.swing.JSpinner();
        labeliD = new javax.swing.JLabel();
        checkAtivo = new javax.swing.JCheckBox();
        labelTipoUsuario = new javax.swing.JLabel();
        labelPNome = new javax.swing.JLabel();
        labelDepartamento = new javax.swing.JLabel();
        cbDepartamento = new javax.swing.JComboBox<>();
        labelSenha = new javax.swing.JLabel();
        passSenha = new javax.swing.JPasswordField();
        passConfirmarSenha = new javax.swing.JPasswordField();
        labelConfirmarSenha = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        painelBotoes = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar");
        setExtendedState(6);

        labelUNome.setText("Sobrenome:");

        labelEmail.setText("Email:");

        labeliD.setText("Identificação/SIAPE:");

        checkAtivo.setText("Ativo?");
        checkAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAtivoActionPerformed(evt);
            }
        });

        labelTipoUsuario.setText("Tipo de Usuário:");

        labelPNome.setText("Primeiro Nome:");

        labelDepartamento.setText("Departamento:");

        labelSenha.setText("Senha:");

        passSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passSenhaActionPerformed(evt);
            }
        });

        labelConfirmarSenha.setText("Confirmar Senha:");

        javax.swing.GroupLayout painelFormLayout = new javax.swing.GroupLayout(painelForm);
        painelForm.setLayout(painelFormLayout);
        painelFormLayout.setHorizontalGroup(
            painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFormLayout.createSequentialGroup()
                        .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDepartamento)
                            .addComponent(labelTipoUsuario))
                        .addGap(73, 73, 73)
                        .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTipoUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkAtivo, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)))
                    .addGroup(painelFormLayout.createSequentialGroup()
                        .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPNome)
                            .addComponent(labelUNome)
                            .addComponent(labelEmail)
                            .addComponent(labelSenha)
                            .addComponent(labelConfirmarSenha)
                            .addComponent(labeliD))
                        .addGap(62, 62, 62)
                        .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinId)
                            .addComponent(tfPNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfUNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passSenha)
                            .addComponent(passConfirmarSenha))))
                .addContainerGap())
        );
        painelFormLayout.setVerticalGroup(
            painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labeliD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelConfirmarSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDepartamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTipoUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        labelUsuario.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        labelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsuario.setText("Editar Usuário");

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
                .addContainerGap(473, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(32, 32, 32))
        );
        painelBotoesLayout.setVerticalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(28, 28, 28))
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkAtivoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        editar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
        this.dispose();
        new UsuarioLista().setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void passSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passSenhaActionPerformed

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
        this.setVisible(false);
        this.dispose();
        new LoginHome().setVisible(true);
    }//GEN-LAST:event_menuHomeMouseClicked

    // <editor-fold defaultstate="collapsed" desc=" AUX ">
    /**
     * Método responsável por tratar a requisição de quando o usuário pede para
     * inserir um novo registro
     */
    public void iniciar(int id, String pNome, String uNome, String email, 
            boolean ativo, Departamento departamento, TipoUsuario tipoUsuario) {
        spinId.setValue(id);
        spinId.setEnabled(false);
        tfPNome.setText(pNome);
        tfUNome.setText(uNome);
        tfEmail.setText(email);
        checkAtivo.setSelected(ativo);
        
        carregaComboBoxes(departamento, tipoUsuario);
    }

    public void editar() {
        try {
            
            int id = (int) spinId.getValue();
            String pNome = tfPNome.getText();
            String uNome = tfUNome.getText();
            String email = tfEmail.getText();
            String senha = new String(passSenha.getPassword());
            String senhaConfirmada = new String(passConfirmarSenha.getPassword());
            boolean senhasIguais = senha.equals(senhaConfirmada);

            if (!senhasIguais) {
                JOptionPane.showMessageDialog(this, "As senhas digitadas não são iguais.");
                return;
            }
            if (senha.length() > 20) {
                JOptionPane.showMessageDialog(this, "A senha informada deve conter menos de 20 caracteres");
                return;
            }
            
            String salGerado = BCrypt.gensalt();
            String senhaHasheada = BCrypt.hashpw(senha, salGerado);
            boolean ativo = checkAtivo.isSelected();
            Departamento departamento = (Departamento) cbDepartamento.getSelectedItem();
            TipoUsuario tipoUsuario = (TipoUsuario) cbTipoUsuario.getSelectedItem();

            ArrayList novaLista = new ArrayList();
            novaLista.add(id);
            novaLista.add(pNome);
            novaLista.add(uNome);
            novaLista.add(email);
            novaLista.add(senhaHasheada);
            novaLista.add(ativo);
            novaLista.add(departamento);
            novaLista.add(tipoUsuario);

            if (control.editarUsuario(novaLista)) {
                JOptionPane.showMessageDialog(this, "As alteracoes foram salvas com sucesso!");
                new UsuarioLista().setVisible(true);
                this.setVisible(false);
                this.dispose();
            }
        } catch (HeadlessException error) {
            JOptionPane.showMessageDialog(this, "Erro: " + error);
        }
    }

    private void carregaComboBoxes(Departamento departamentoSelecionado
            , TipoUsuario tipoUsuarioSelecionado) {
        DepartamentoRecursoController controlDepartamento = new DepartamentoRecursoController();
        ArrayList lista = controlDepartamento.listarDepartamento();
        Iterator iterator = lista.iterator();
        while (iterator.hasNext()) {
            Departamento departamento = new Departamento(
                    (int) iterator.next(),//ID
                    (String) iterator.next(),//Nome
                    (String) iterator.next(),//Sigla
                    (boolean) iterator.next()//Ativo
            );
            cbDepartamento.addItem(departamento);
            if(departamento.equals(departamentoSelecionado)) {
                cbDepartamento.setSelectedItem(departamento);
            }
        }

        
        TipoUsuarioRecursoController controlTipoUsuario = new TipoUsuarioRecursoController();
        lista = controlTipoUsuario.listarTipoUsuario();
        iterator = lista.iterator();
        while (iterator.hasNext()) {
            TipoUsuario tipoUsuario = new TipoUsuario(
                    (int) iterator.next(),//ID
                    (String) iterator.next(),//Sigla
                    (String) iterator.next()//Nome
            );
            cbTipoUsuario.addItem(tipoUsuario);
            if(tipoUsuario.equals(tipoUsuarioSelecionado)) {
                cbTipoUsuario.setSelectedItem(tipoUsuario);
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
            java.util.logging.Logger.getLogger(SalaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalaEditar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Object> cbDepartamento;
    private javax.swing.JComboBox<Object> cbTipoUsuario;
    private javax.swing.JCheckBox checkAtivo;
    private javax.swing.JLabel labelConfirmarSenha;
    private javax.swing.JLabel labelDepartamento;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelPNome;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelTipoUsuario;
    private javax.swing.JLabel labelUNome;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labeliD;
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
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelForm;
    private javax.swing.JPasswordField passConfirmarSenha;
    private javax.swing.JPasswordField passSenha;
    private javax.swing.JSpinner spinId;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfPNome;
    private javax.swing.JTextField tfUNome;
    // End of variables declaration//GEN-END:variables
}
