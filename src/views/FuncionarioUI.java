/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import views.FA.InfoAgenciaFA;
import contas.Conta;
import java.util.List;
import jsonOperations.Leitura;
import sistema.Sistema;
import usuarios.Cliente;
import usuarios.Funcionario;
import views.cliente.ValidarConta;
import views.funcionario.AdicionarConta;
import views.funcionario.AlterarInfoCliente;
import views.funcionario.AlterarSenha;
import views.funcionario.ContasCadastradas;
import views.funcionario.InfoCliente;
import views.funcionario.MeusDados;
import views.funcionario.RemoverConta;

/**
 *
 * @author Walter
 */
public class FuncionarioUI extends javax.swing.JFrame {
    
    private Funcionario funcionarioLogado;
    private String baseFuncionarios = "./src/baseDeDados/funcionarios.json";
    private String baseContas = "./src/baseDeDados/listaContas.json";
    private String baseClientes = "./src/baseDeDados/clientes.json";
    private String baseAgencias = "./src/baseDeDados/listaAgencias.json";

    Cliente clienteSelecionado = null;

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

    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    
    public void setFuncionarioLogado(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
    }
    
    public String getBaseAgencias() {
        return baseAgencias;
    }

    
    public void setBaseAgencias(String baseAgencias) {
        this.baseAgencias = baseAgencias;
    }

    /**
     * Remove todas as janelas do painel interno.
     */
    public void setLimparAreaDeTrabalho() {
        this.AreaDeTrabalho.removeAll();
    }

    /**
     * Adiciona ao painel interno uma janela do tipo AlterarInfoCliente
     * 
     * @param alterarInfoCliente 
     */
    public void setAlterarCliente(AlterarInfoCliente alterarInfoCliente) {
        this.AreaDeTrabalho.add(alterarInfoCliente);
    }

    /**
     * Adiciona ao painel interno uma janela do tipo InfoCliente
     * @param infoCliente 
     */
    public void setInfoCliente(InfoCliente infoCliente) {
        this.AreaDeTrabalho.add(infoCliente);
    }

    /**
     * Creates new form AdministradorUI
     */
    public FuncionarioUI() {
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
        MinhaConta = new javax.swing.JMenu();
        MeusDados = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        AlterarSenha = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        Sair = new javax.swing.JMenuItem();
        Contas = new javax.swing.JMenu();
        contasCadastradas = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        addConta = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        removerConta = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        Clientes = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        acessarInfoCliente = new javax.swing.JMenuItem();
        Separator = new javax.swing.JPopupMenu.Separator();
        alterarInfoCliente = new javax.swing.JMenuItem();
        nCli = new javax.swing.JMenuItem();
        DadosAgencia = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interface Funcionário - WWBank");
        setMinimumSize(new java.awt.Dimension(780, 580));
        setPreferredSize(new java.awt.Dimension(780, 620));
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

        MinhaConta.setText("Minha Conta");
        MinhaConta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MinhaConta.setMaximumSize(new java.awt.Dimension(100, 22));
        MinhaConta.setMinimumSize(new java.awt.Dimension(100, 22));
        MinhaConta.setPreferredSize(new java.awt.Dimension(100, 22));
        MinhaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinhaContaActionPerformed(evt);
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
        MinhaConta.add(MeusDados);
        MinhaConta.add(jSeparator2);

        AlterarSenha.setText("Alterar senha");
        AlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarSenhaActionPerformed(evt);
            }
        });
        MinhaConta.add(AlterarSenha);
        MinhaConta.add(jSeparator4);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        MinhaConta.add(Sair);

        jMenuBar1.add(MinhaConta);

        Contas.setText("Contas");
        Contas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Contas.setMaximumSize(new java.awt.Dimension(100, 22));
        Contas.setMinimumSize(new java.awt.Dimension(100, 22));
        Contas.setPreferredSize(new java.awt.Dimension(100, 22));
        Contas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContasActionPerformed(evt);
            }
        });

        contasCadastradas.setText("Contas cadastradas");
        contasCadastradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contasCadastradasActionPerformed(evt);
            }
        });
        Contas.add(contasCadastradas);
        Contas.add(jSeparator5);

        addConta.setText("Adicionar conta");
        addConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addContaActionPerformed(evt);
            }
        });
        Contas.add(addConta);
        Contas.add(jSeparator3);

        removerConta.setText("Remover conta");
        removerConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerContaActionPerformed(evt);
            }
        });
        Contas.add(removerConta);
        Contas.add(jSeparator7);

        jMenuItem1.setText("Ir para minha conta bancária");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Contas.add(jMenuItem1);

        jMenuBar1.add(Contas);

        Clientes.setText("Clientes");
        Clientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Clientes.setMaximumSize(new java.awt.Dimension(100, 22));
        Clientes.setPreferredSize(new java.awt.Dimension(100, 22));

        jMenuItem9.setText("Clientes cadastrados");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        Clientes.add(jMenuItem9);
        Clientes.add(jSeparator6);

        acessarInfoCliente.setText("Acessar informações do cliente");
        acessarInfoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acessarInfoClienteActionPerformed(evt);
            }
        });
        Clientes.add(acessarInfoCliente);
        Clientes.add(Separator);

        alterarInfoCliente.setText("Alterar informações do cliente");
        alterarInfoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarInfoClienteActionPerformed(evt);
            }
        });
        Clientes.add(alterarInfoCliente);

        nCli.setText("Numero de clientes cadastrados");
        nCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nCliActionPerformed(evt);
            }
        });
        Clientes.add(nCli);

        jMenuBar1.add(Clientes);

        DadosAgencia.setText("Visualizar informações de agência");
        DadosAgencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DadosAgenciaMouseClicked(evt);
            }
        });
        DadosAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DadosAgenciaActionPerformed(evt);
            }
        });
        jMenuBar1.add(DadosAgencia);

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
        MeusDados show = new MeusDados();
        show.setShowMeusDados(funcionarioLogado.toString());
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show);
        show.setVisible(true);
    }//GEN-LAST:event_MeusDadosActionPerformed

    private void AlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarSenhaActionPerformed
        AlterarSenha show = new AlterarSenha();
        show.setFuncionarioUI(this);
        show.setBaseFuncionarios(baseFuncionarios);
        show.setFuncionarioLogado(funcionarioLogado);
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show);
        show.setVisible(true);
    }//GEN-LAST:event_AlterarSenhaActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SairActionPerformed

    private void contasCadastradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contasCadastradasActionPerformed
        List<Conta> listaContas = Leitura.lerContas(baseContas);
        StringBuilder sb = new StringBuilder();
        int linhas = 7;
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

    private void addContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addContaActionPerformed
        AdicionarConta show = new AdicionarConta();
        show.setFuncionarioLogado(funcionarioLogado);
        show.setBaseContas(baseContas);
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show);
        show.setVisible(true);
    }//GEN-LAST:event_addContaActionPerformed

    private void removerContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerContaActionPerformed
        RemoverConta show = new RemoverConta();
        show.setFuncionarioLogado(funcionarioLogado);
        show.setBaseContas(baseContas);
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show);
        show.setVisible(true);
    }//GEN-LAST:event_removerContaActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
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

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void acessarInfoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acessarInfoClienteActionPerformed
        ValidarUsuariosUI show = new ValidarUsuariosUI();
        show.setFuncionarioLogado(funcionarioLogado);
        show.setInfoCliente(new InfoCliente());
        show.setFuncionarioUI(this);
        this.AreaDeTrabalho.removeAll();
        show.setVisible(true);

    }//GEN-LAST:event_acessarInfoClienteActionPerformed

    private void alterarInfoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarInfoClienteActionPerformed
        ValidarUsuariosUI show = new ValidarUsuariosUI();
        show.setFuncionarioLogado(funcionarioLogado);
        show.setAlterarInfoCliente(new AlterarInfoCliente());
        show.setFuncionarioUI(this);
        this.AreaDeTrabalho.removeAll();
        show.setVisible(true);
    }//GEN-LAST:event_alterarInfoClienteActionPerformed

    private void MinhaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinhaContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MinhaContaActionPerformed

    private void ContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContasActionPerformed

    }//GEN-LAST:event_ContasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ValidarConta show = new ValidarConta();
        this.AreaDeTrabalho.removeAll();
        show.setFuncionarioUI(this);
        show.setFuncionarioLogado(funcionarioLogado);
        show.setContasCliente(funcionarioLogado.getsetIdConta());
        show.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void DadosAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DadosAgenciaActionPerformed
       
    }//GEN-LAST:event_DadosAgenciaActionPerformed

    private void DadosAgenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DadosAgenciaMouseClicked
        InfoAgenciaFA show = new InfoAgenciaFA();
       show.setBaseAgencias(baseAgencias);
       show.setShowDadosAgencia();
       show.setVisible(true);
       this.AreaDeTrabalho.removeAll();
       this.AreaDeTrabalho.add(show);
    }//GEN-LAST:event_DadosAgenciaMouseClicked

    private void nCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nCliActionPerformed
        StringBuilder sb = new StringBuilder();
        sb.append("Número de Clientes com atributo private: "+Sistema.nInstanciasClienteP());
        sb.append("\nNúmero de Clientes com atributo protegido: "+Sistema.nInstanciasClienteS());
        UsuariosCadastrados show = new UsuariosCadastrados();
        show.setShowContas(sb.toString(), 20);
        this.AreaDeTrabalho.removeAll();
        this.AreaDeTrabalho.add(show);
        show.setVisible(true);
    }//GEN-LAST:event_nCliActionPerformed

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
            java.util.logging.Logger.getLogger(FuncionarioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionarioUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AlterarSenha;
    private javax.swing.JPanel AreaDeTrabalho;
    private javax.swing.JMenu Clientes;
    private javax.swing.JMenu Contas;
    private javax.swing.JMenu DadosAgencia;
    private javax.swing.JMenuItem MeusDados;
    private javax.swing.JMenu MinhaConta;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JPopupMenu.Separator Separator;
    private javax.swing.JMenuItem acessarInfoCliente;
    private javax.swing.JMenuItem addConta;
    private javax.swing.JMenuItem alterarInfoCliente;
    private javax.swing.JMenuItem contasCadastradas;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JMenuItem nCli;
    private javax.swing.JMenuItem removerConta;
    // End of variables declaration//GEN-END:variables
}
