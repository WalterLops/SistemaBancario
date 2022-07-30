/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import views.FA.InfoFA;
import views.FA.InfoAgenciaFA;
import views.FA.AlterarInfoFA;
import views.FA.RemoverFA;
import contas.Conta;
import java.util.List;
import jsonOperations.Leitura;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Funcionario;
import views.administrador.AdicionarAdmin;
import views.administrador.AdicionarAgencia;
import views.administrador.AdicionarCliente;
import views.administrador.AdicionarFuncionario;
import views.administrador.AlterarConta;
import views.administrador.PesquisarAgencia;
import views.administrador.RemoverAgencia;
import views.administrador.RemoverCliente;
import views.cliente.ValidarConta;
import views.funcionario.AdicionarConta;
import views.funcionario.AlterarInfoCliente;
import views.funcionario.AlterarSenha;
import views.funcionario.ContasCadastradas;
import views.funcionario.InfoCliente;
import views.funcionario.MeusDados;
import views.funcionario.RemoverConta;

/**
 * Interface do administrador.
 * 
 * @author Walter
 */
public class AdministradorUI extends javax.swing.JFrame {

    private Administrador administradorLogado;
    
    private String baseClientes = "./src/baseDeDados/clientes.json";
    private String baseFuncionarios = "./src/baseDeDados/funcionarios.json";
    private String baseAdministradores = "./src/baseDeDados/administradores.json";
    private String baseContas = "./src/baseDeDados/listaContas.json";
    private String baseAgencias = "./src/baseDeDados/listaAgencias.json";
    
    private Cliente clienteSelecionado = null;

    public String getBaseAdministradores() {
        return baseAdministradores;
    }

    public void setBaseAdministradores(String baseAdministradores) {
        this.baseAdministradores = baseAdministradores;
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public String getBaseContas() {
        return baseContas;
    }

    public void setBaseContas(String baseContas) {
        this.baseContas = baseContas;
    }

    public String getBaseFuncionarios() {
        return baseFuncionarios;
    }

    public void setBaseFuncionarios(String baseFuncionarios) {
        this.baseFuncionarios = baseFuncionarios;
    }

    public Administrador getAdministradorLogado() {
        return administradorLogado;
    }

    public void setAdministradorLogado(Administrador administradorLogado) {
        this.administradorLogado = administradorLogado;
    }

    public String getBaseAgencias() {
        return baseAgencias;
    }

    public void setBaseAgencias(String baseAgencias) {
        this.baseAgencias = baseAgencias;
    }
    
    public void setLimparAreaDeTrabalho() {
        this.AreaDeTrabalho.removeAll();
    }

    public void setAlterarCliente(AlterarInfoCliente alterarInfoCliente) {
        this.AreaDeTrabalho.add(alterarInfoCliente);
    }

    public void setInfoCliente(InfoCliente infoCliente) {
        this.AreaDeTrabalho.add(infoCliente);
    }

    public void setInfoFA(InfoFA infoFA){
        this.AreaDeTrabalho.add(infoFA);
    }
    
    /**
     * Adiciona ao painel interno uma janela do tipo jInternalFrame AlterarInfoFA
     * 
     * @param alterarInfoFA 
     */
    public void setAlterarInfoFA(AlterarInfoFA alterarInfoFA){
        this.AreaDeTrabalho.add(alterarInfoFA);
    }
    
    /**
     * Remove todas as janelas jInternalFrame do painel interno e adiciona 
     * uma janela do tipo RemoverCliente
     * 
     * @param removerCliente 
     */
    public void setRemoverCliente(RemoverCliente removerCliente){
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(removerCliente);
    }
    
    /**
     * Adiciona ao painel interno uma janela do tipo RemoverFA
     * 
     * @param removerFA 
     */
    public void setRemoverFA(RemoverFA removerFA){
        this.AreaDeTrabalho.add(removerFA);
    }
    
    /**
     * Adiciona ao painel interno uma janela do tipo AlterarConta
     * 
     * @param alterarConta 
     */
    public void setAlterarConta(AlterarConta alterarConta){
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(alterarConta);
    }
    
    /**
     * Remove todas as janelas jInternalFrame do painel interno
     * 
     * @param removerAgencia 
     */
    public void setRemoverAgencia(RemoverAgencia removerAgencia){
        this.AreaDeTrabalho.add(removerAgencia);
    }
    
    /**
     * Creates new form AdministradorUI
     */
    public AdministradorUI() {
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

        jPanel1 = new javax.swing.JPanel();
        AreaDeTrabalho = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mMinhaConta = new javax.swing.JMenu();
        MeusDados = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        AlterarSenha = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        Sair = new javax.swing.JMenuItem();
        mContas = new javax.swing.JMenu();
        contasCadastradas = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        adicionarConta = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        alterarConta = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        removerConta = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        irParaMinhaConta = new javax.swing.JMenuItem();
        mClientes = new javax.swing.JMenu();
        clientesCadastrados = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        acessarInfoCliente = new javax.swing.JMenuItem();
        Separator = new javax.swing.JPopupMenu.Separator();
        alterarInfoCliente = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        AdicionarCliente = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        RemoverCliente = new javax.swing.JMenuItem();
        mFuncionarios = new javax.swing.JMenu();
        funcionariosCadastrados = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        addFuncionario = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        acessarInfoFuncionario = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        alterarInfoFuncionario = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        removerFuncionario = new javax.swing.JMenuItem();
        mAdministradores = new javax.swing.JMenu();
        administradoresCadastrados = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        addAdmin = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        acessarInfoAdmin = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        alterarInfoAdmin = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        RemoverAdmin = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        addAgencia = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        visualizarAgencia = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        removerAgencia = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interface Administrador - WWBanck");
        setMinimumSize(new java.awt.Dimension(780, 580));
        setSize(new java.awt.Dimension(780, 620));

        jPanel1.setBackground(new java.awt.Color(0, 20, 73));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 400));

        AreaDeTrabalho.setMaximumSize(new java.awt.Dimension(700, 495));
        AreaDeTrabalho.setMinimumSize(new java.awt.Dimension(700, 495));

        javax.swing.GroupLayout AreaDeTrabalhoLayout = new javax.swing.GroupLayout(AreaDeTrabalho);
        AreaDeTrabalho.setLayout(AreaDeTrabalhoLayout);
        AreaDeTrabalhoLayout.setHorizontalGroup(
            AreaDeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        AreaDeTrabalhoLayout.setVerticalGroup(
            AreaDeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(AreaDeTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(AreaDeTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        mMinhaConta.setText("Minha Conta");
        mMinhaConta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mMinhaConta.setMaximumSize(new java.awt.Dimension(100, 22));
        mMinhaConta.setMinimumSize(new java.awt.Dimension(100, 22));
        mMinhaConta.setPreferredSize(new java.awt.Dimension(100, 22));
        mMinhaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mMinhaContaActionPerformed(evt);
            }
        });

        MeusDados.setText("Meus dados");
        MeusDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MeusDadosMouseClicked(evt);
            }
        });
        MeusDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeusDadosActionPerformed(evt);
            }
        });
        mMinhaConta.add(MeusDados);
        mMinhaConta.add(jSeparator2);

        AlterarSenha.setText("Alterar senha");
        AlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarSenhaActionPerformed(evt);
            }
        });
        mMinhaConta.add(AlterarSenha);
        mMinhaConta.add(jSeparator4);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        mMinhaConta.add(Sair);

        jMenuBar1.add(mMinhaConta);

        mContas.setText("Contas");
        mContas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mContas.setMaximumSize(new java.awt.Dimension(100, 22));
        mContas.setMinimumSize(new java.awt.Dimension(100, 22));
        mContas.setPreferredSize(new java.awt.Dimension(100, 22));
        mContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mContasActionPerformed(evt);
            }
        });

        contasCadastradas.setText("Contas cadastradas");
        contasCadastradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contasCadastradasActionPerformed(evt);
            }
        });
        mContas.add(contasCadastradas);
        mContas.add(jSeparator5);

        adicionarConta.setText("Adicionar conta");
        adicionarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarContaActionPerformed(evt);
            }
        });
        mContas.add(adicionarConta);
        mContas.add(jSeparator3);

        alterarConta.setText("Alterar conta");
        alterarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarContaActionPerformed(evt);
            }
        });
        mContas.add(alterarConta);
        mContas.add(jSeparator19);

        removerConta.setText("Remover conta");
        removerConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerContaActionPerformed(evt);
            }
        });
        mContas.add(removerConta);
        mContas.add(jSeparator7);

        irParaMinhaConta.setText("Ir para minha conta bancária");
        irParaMinhaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irParaMinhaContaActionPerformed(evt);
            }
        });
        mContas.add(irParaMinhaConta);

        jMenuBar1.add(mContas);

        mClientes.setText("Clientes");
        mClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mClientes.setMaximumSize(new java.awt.Dimension(100, 22));
        mClientes.setPreferredSize(new java.awt.Dimension(100, 22));

        clientesCadastrados.setText("Clientes cadastrados");
        clientesCadastrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesCadastradosActionPerformed(evt);
            }
        });
        mClientes.add(clientesCadastrados);
        mClientes.add(jSeparator6);

        acessarInfoCliente.setText("Acessar informações do cliente");
        acessarInfoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acessarInfoClienteActionPerformed(evt);
            }
        });
        mClientes.add(acessarInfoCliente);
        mClientes.add(Separator);

        alterarInfoCliente.setText("Alterar informações do cliente");
        alterarInfoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarInfoClienteActionPerformed(evt);
            }
        });
        mClientes.add(alterarInfoCliente);
        mClientes.add(jSeparator9);

        AdicionarCliente.setText("Adicionar Cliente");
        AdicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarClienteActionPerformed(evt);
            }
        });
        mClientes.add(AdicionarCliente);
        mClientes.add(jSeparator8);

        RemoverCliente.setText("Remover Cliente");
        RemoverCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverClienteActionPerformed(evt);
            }
        });
        mClientes.add(RemoverCliente);

        jMenuBar1.add(mClientes);

        mFuncionarios.setText("Funcionários");

        funcionariosCadastrados.setText("Funcionarios cadastrados");
        funcionariosCadastrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionariosCadastradosActionPerformed(evt);
            }
        });
        mFuncionarios.add(funcionariosCadastrados);
        mFuncionarios.add(jSeparator17);

        addFuncionario.setText("Adicionar Funcionário");
        addFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFuncionarioActionPerformed(evt);
            }
        });
        mFuncionarios.add(addFuncionario);
        mFuncionarios.add(jSeparator1);

        acessarInfoFuncionario.setText("Acessar informações do funcionário");
        acessarInfoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acessarInfoFuncionarioActionPerformed(evt);
            }
        });
        mFuncionarios.add(acessarInfoFuncionario);
        mFuncionarios.add(jSeparator10);

        alterarInfoFuncionario.setText("Alterar informações do funcionário");
        alterarInfoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarInfoFuncionarioActionPerformed(evt);
            }
        });
        mFuncionarios.add(alterarInfoFuncionario);
        mFuncionarios.add(jSeparator11);

        removerFuncionario.setText("Remover funcionário");
        removerFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerFuncionarioActionPerformed(evt);
            }
        });
        mFuncionarios.add(removerFuncionario);

        jMenuBar1.add(mFuncionarios);

        mAdministradores.setText("Administradores");

        administradoresCadastrados.setText("Administradores cadastrados");
        administradoresCadastrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administradoresCadastradosActionPerformed(evt);
            }
        });
        mAdministradores.add(administradoresCadastrados);
        mAdministradores.add(jSeparator18);

        addAdmin.setText("Adicionar administrador");
        addAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdminActionPerformed(evt);
            }
        });
        mAdministradores.add(addAdmin);
        mAdministradores.add(jSeparator12);

        acessarInfoAdmin.setText("Acessar informações do administrador");
        acessarInfoAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acessarInfoAdminActionPerformed(evt);
            }
        });
        mAdministradores.add(acessarInfoAdmin);
        mAdministradores.add(jSeparator13);

        alterarInfoAdmin.setText("Alterar informações do administrador");
        alterarInfoAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarInfoAdminActionPerformed(evt);
            }
        });
        mAdministradores.add(alterarInfoAdmin);
        mAdministradores.add(jSeparator14);

        RemoverAdmin.setText("Remover administrador");
        RemoverAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverAdminActionPerformed(evt);
            }
        });
        mAdministradores.add(RemoverAdmin);

        jMenuBar1.add(mAdministradores);

        jMenu1.setText("Agências");

        addAgencia.setText("Adicionar");
        addAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAgenciaActionPerformed(evt);
            }
        });
        jMenu1.add(addAgencia);
        jMenu1.add(jSeparator15);

        visualizarAgencia.setText("Visualizar");
        visualizarAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarAgenciaActionPerformed(evt);
            }
        });
        jMenu1.add(visualizarAgencia);
        jMenu1.add(jSeparator16);

        removerAgencia.setText("Remover");
        removerAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerAgenciaActionPerformed(evt);
            }
        });
        jMenu1.add(removerAgencia);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MeusDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeusDadosMouseClicked

    }//GEN-LAST:event_MeusDadosMouseClicked

    private void MeusDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeusDadosActionPerformed
        MeusDados show = new MeusDados(); // nova interna janela a ser inicializada
        show.setShowMeusDados(administradorLogado.toString()); // metodo mostrar informacoes em text area da nova janela
        this.AreaDeTrabalho.removeAll(); 
        this.AreaDeTrabalho.add(show); // Adiciona a nova janela ao painel dessa janela
        show.setVisible(true);
    }//GEN-LAST:event_MeusDadosActionPerformed

    private void AlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarSenhaActionPerformed
        AlterarSenha show = new AlterarSenha();
        show.setAdministradorUI(this);
        show.setBaseAdministradores(baseAdministradores);
        show.setAdministradorLogado(administradorLogado);
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show);
        show.setVisible(true);
    }//GEN-LAST:event_AlterarSenhaActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SairActionPerformed

    private void contasCadastradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contasCadastradasActionPerformed
        List<Conta> listaContas = Leitura.lerContas(baseContas);
        StringBuilder sb = new StringBuilder(); // stringBuilder para armazenar as informacoes da conta
        int linhas = 7; // quantidade de linhas a ser exibida no text area da nova janela
        for (Conta c : listaContas) {
            sb.append(c.toString());
            linhas += linhas;
        }
        ContasCadastradas show = new ContasCadastradas();
        show.setShowContas(sb.toString(), linhas);
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show);
        show.setVisible(true);
    }//GEN-LAST:event_contasCadastradasActionPerformed

    private void adicionarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarContaActionPerformed
        AdicionarConta show = new AdicionarConta();
        show.setAdministradorLogado(administradorLogado);
        show.setBaseContas(baseContas);
        show.setInicializarAgencias();
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show);
        show.setVisible(true);
    }//GEN-LAST:event_adicionarContaActionPerformed

    private void removerContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerContaActionPerformed
        RemoverConta show = new RemoverConta();
        show.setAdministradorLogado(administradorLogado);
        show.setBaseContas(baseContas);
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show);
        show.setVisible(true);
    }//GEN-LAST:event_removerContaActionPerformed

    private void clientesCadastradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesCadastradosActionPerformed
        List<Cliente> listaClientes = Leitura.lerClientes(baseClientes);
        StringBuilder sb = new StringBuilder(); // stringBuilder para armazenar as informacoes da Cliente
        int linhas = 7; // quantidade de linhas a ser exibida no text area da nova janela
        for (Cliente c : listaClientes) {
            sb.append(c.toString());
            linhas += linhas;
        }
        UsuariosCadastrados show = new UsuariosCadastrados();
        show.setShowContas(sb.toString(), linhas);
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show);
        show.setVisible(true);

    }//GEN-LAST:event_clientesCadastradosActionPerformed

    private void acessarInfoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acessarInfoClienteActionPerformed
        ValidarUsuariosUI show = new ValidarUsuariosUI();
        show.setAdministradorLogado(administradorLogado);
        show.setInfoCliente(new InfoCliente());
        show.setAdministradorUI(this);
        this.AreaDeTrabalho.removeAll();
        show.setVisible(true);
    }//GEN-LAST:event_acessarInfoClienteActionPerformed

    private void alterarInfoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarInfoClienteActionPerformed
        ValidarUsuariosUI show = new ValidarUsuariosUI();
        show.setAdministradorLogado(administradorLogado);
        show.setAlterarInfoCliente(new AlterarInfoCliente());
        show.setAdministradorUI(this);
        this.AreaDeTrabalho.removeAll();
        show.setVisible(true);
    }//GEN-LAST:event_alterarInfoClienteActionPerformed

    private void mMinhaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mMinhaContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mMinhaContaActionPerformed

    private void mContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mContasActionPerformed
        
    }//GEN-LAST:event_mContasActionPerformed

    private void irParaMinhaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irParaMinhaContaActionPerformed
        ValidarConta show = new ValidarConta();
        this.AreaDeTrabalho.removeAll();
        show.setAdministradorUI(this);
        show.setAdministradorLogado(administradorLogado);
        show.setContasCliente(administradorLogado.getsetIdConta());
        show.setVisible(true);
    }//GEN-LAST:event_irParaMinhaContaActionPerformed

    private void AdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarClienteActionPerformed
        AdicionarCliente show = new AdicionarCliente();
        show.setAdministradorLogado(administradorLogado);
        show.setBaseClientes(baseClientes);
        show.setVisible(true);
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show); 
    }//GEN-LAST:event_AdicionarClienteActionPerformed

    private void RemoverClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverClienteActionPerformed
        ValidarUsuariosUI show = new ValidarUsuariosUI();
        show.setAdministradorLogado(administradorLogado);
        show.setRemoverCliente(new RemoverCliente());
        show.setAdministradorUI(this);
        this.AreaDeTrabalho.removeAll();
        show.setVisible(true);
    }//GEN-LAST:event_RemoverClienteActionPerformed

    private void addAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdminActionPerformed
        AdicionarAdmin show = new AdicionarAdmin();
        show.setAdministradorLogado(administradorLogado);
        show.setBaseAdministradores(baseAdministradores);
        show.setVisible(true);
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show); 
    }//GEN-LAST:event_addAdminActionPerformed

    private void addFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFuncionarioActionPerformed
        AdicionarFuncionario show = new AdicionarFuncionario();
        show.setAdministradorLogado(administradorLogado);
        show.setBaseFuncionarios(baseFuncionarios);
        show.setVisible(true);
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show);
    }//GEN-LAST:event_addFuncionarioActionPerformed

    private void acessarInfoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acessarInfoFuncionarioActionPerformed
        ValidarUsuariosUI show = new ValidarUsuariosUI();
        show.setAdministradorUI(this);
        show.setAdministradorLogado(administradorLogado);
        show.setInfoFA(new InfoFA());
        show.setVisible(true);
        this.AreaDeTrabalho.removeAll();
    }//GEN-LAST:event_acessarInfoFuncionarioActionPerformed

    private void acessarInfoAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acessarInfoAdminActionPerformed
       
        ValidarUsuariosUI show = new ValidarUsuariosUI();
        show.setAdministradorUI(this);
        show.setAdministradorLogado(administradorLogado);
        show.setInfoFA(new InfoFA());
        show.setVisible(true);
        this.AreaDeTrabalho.removeAll();
        
    }//GEN-LAST:event_acessarInfoAdminActionPerformed

    private void alterarInfoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarInfoFuncionarioActionPerformed
        
        ValidarUsuariosUI show = new ValidarUsuariosUI();
        show.setAdministradorUI(this);
        show.setAdministradorLogado(administradorLogado);
        show.setAlterarInfoFA(new AlterarInfoFA());
        show.setVisible(true);
        this.AreaDeTrabalho.removeAll();
        
    }//GEN-LAST:event_alterarInfoFuncionarioActionPerformed

    private void alterarInfoAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarInfoAdminActionPerformed
       
        ValidarUsuariosUI show = new ValidarUsuariosUI();
        show.setAdministradorUI(this);
        show.setAdministradorLogado(administradorLogado);
        show.setAlterarInfoFA(new AlterarInfoFA());
        show.setVisible(true);
        this.AreaDeTrabalho.removeAll();
        
    }//GEN-LAST:event_alterarInfoAdminActionPerformed

    private void removerFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerFuncionarioActionPerformed
        
        ValidarUsuariosUI show = new ValidarUsuariosUI();
        show.setAdministradorUI(this);
        show.setAdministradorLogado(administradorLogado);
        show.setRemoverFA(new RemoverFA());
        show.setVisible(true);
        this.AreaDeTrabalho.removeAll();
        
    }//GEN-LAST:event_removerFuncionarioActionPerformed

    private void RemoverAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverAdminActionPerformed
        
        ValidarUsuariosUI show = new ValidarUsuariosUI();
        show.setAdministradorUI(this);
        show.setAdministradorLogado(administradorLogado);
        show.setRemoverFA(new RemoverFA());
        show.setVisible(true);
        this.AreaDeTrabalho.removeAll();
        
    }//GEN-LAST:event_RemoverAdminActionPerformed

    private void visualizarAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarAgenciaActionPerformed
        
       InfoAgenciaFA show = new InfoAgenciaFA();
       show.setBaseAgencias(baseAgencias);
       show.setShowDadosAgencia();
       show.setVisible(true);
       this.AreaDeTrabalho.removeAll();
       this.AreaDeTrabalho.add(show);
        
    }//GEN-LAST:event_visualizarAgenciaActionPerformed

    private void funcionariosCadastradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionariosCadastradosActionPerformed
        
        Funcionario[] listaFuncionarios = Leitura.lerFuncionarios(baseFuncionarios);
        StringBuilder sb = new StringBuilder(); // stringBuilder para armazenar as informacoes da Funcionario
        int linhas = 7; // quantidade de linhas a ser exibida no text area da nova janela
        for (Funcionario f : listaFuncionarios) {
            sb.append(f.toString());
            linhas += linhas;
        }
        UsuariosCadastrados show = new UsuariosCadastrados();
        show.setShowContas(sb.toString(), linhas);
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show);
        show.setVisible(true);
        
    }//GEN-LAST:event_funcionariosCadastradosActionPerformed

    private void administradoresCadastradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administradoresCadastradosActionPerformed
        
        Administrador[] listaAdministradores = Leitura.lerAdministradores(baseAdministradores);
        StringBuilder sb = new StringBuilder(); // stringBuilder para armazenar as informacoes da administrador
        int linhas = 7; // quantidade de linhas a ser exibida no text area da nova janela
        for (Administrador a : listaAdministradores) {
            sb.append(a.toString());
            linhas += linhas;
        }
        UsuariosCadastrados show = new UsuariosCadastrados();
        show.setShowContas(sb.toString(), linhas);
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show);
        show.setVisible(true);
        
    }//GEN-LAST:event_administradoresCadastradosActionPerformed

    private void alterarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarContaActionPerformed
        
        ValidarConta show = new ValidarConta();
        show.setAdministradorLogado(administradorLogado);
        show.setBaseContas(baseContas);
        show.setAlterarConta(new AlterarConta());
        show.setAdministradorUI(this);
        show.setVisible(true);
        this.AreaDeTrabalho.removeAll();
    }//GEN-LAST:event_alterarContaActionPerformed

    private void addAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAgenciaActionPerformed
        AdicionarAgencia show = new AdicionarAgencia();
        show.setAdministradorLogado(administradorLogado);
        show.setBaseAgencias(baseAgencias);
        show.setBaseContas(baseContas);
        show.setVisible(true);
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show);
    }//GEN-LAST:event_addAgenciaActionPerformed

    private void removerAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerAgenciaActionPerformed
        PesquisarAgencia show = new PesquisarAgencia();
        show.setAdministradorLogado(administradorLogado);
        show.setBaseAgencias(baseAgencias);
        show.setBaseContas(baseContas);
        show.setAdministradorUI(this);
        show.setVisible(true);
        this.AreaDeTrabalho.removeAll();
    }//GEN-LAST:event_removerAgenciaActionPerformed

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
            java.util.logging.Logger.getLogger(AdministradorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministradorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministradorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministradorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministradorUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AdicionarCliente;
    private javax.swing.JMenuItem AlterarSenha;
    private javax.swing.JPanel AreaDeTrabalho;
    private javax.swing.JMenuItem MeusDados;
    private javax.swing.JMenuItem RemoverAdmin;
    private javax.swing.JMenuItem RemoverCliente;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JPopupMenu.Separator Separator;
    private javax.swing.JMenuItem acessarInfoAdmin;
    private javax.swing.JMenuItem acessarInfoCliente;
    private javax.swing.JMenuItem acessarInfoFuncionario;
    private javax.swing.JMenuItem addAdmin;
    private javax.swing.JMenuItem addAgencia;
    private javax.swing.JMenuItem addFuncionario;
    private javax.swing.JMenuItem adicionarConta;
    private javax.swing.JMenuItem administradoresCadastrados;
    private javax.swing.JMenuItem alterarConta;
    private javax.swing.JMenuItem alterarInfoAdmin;
    private javax.swing.JMenuItem alterarInfoCliente;
    private javax.swing.JMenuItem alterarInfoFuncionario;
    private javax.swing.JMenuItem clientesCadastrados;
    private javax.swing.JMenuItem contasCadastradas;
    private javax.swing.JMenuItem funcionariosCadastrados;
    private javax.swing.JMenuItem irParaMinhaConta;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenu mAdministradores;
    private javax.swing.JMenu mClientes;
    private javax.swing.JMenu mContas;
    private javax.swing.JMenu mFuncionarios;
    private javax.swing.JMenu mMinhaConta;
    private javax.swing.JMenuItem removerAgencia;
    private javax.swing.JMenuItem removerConta;
    private javax.swing.JMenuItem removerFuncionario;
    private javax.swing.JMenuItem visualizarAgencia;
    // End of variables declaration//GEN-END:variables
}
