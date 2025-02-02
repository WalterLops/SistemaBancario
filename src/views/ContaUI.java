/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import contas.Conta;
import java.util.List;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Funcionario;
import views.conta.Transferir;
import views.conta.Depositar;
import views.conta.Extrato;
import views.conta.Sacar;

/**
 * Interface da conta bancaria
 * 
 * @author Walter
 */
public class ContaUI extends javax.swing.JFrame {

    Conta contaSelecionada;
    ClienteUI clienteUI = null;
    FuncionarioUI funcionarioUI = null;
    AdministradorUI administradorUI = null;
    private Cliente clienteLogado = null;
    private Funcionario funcionarioLogado = null;
    private Administrador administradorLogado = null;
    List<Conta> listaContas;

    public ClienteUI getClienteUI() {
        return clienteUI;
    }

    public List<Conta> getListaContas() {
        return listaContas;
    }

    public void setListaContas(List<Conta> listaContas) {
        this.listaContas = listaContas;
    }

    public void setClienteUI(ClienteUI clienteUI) {
        this.clienteUI = clienteUI;
    }

    public Conta getContaSelecionada() {
        return contaSelecionada;
    }

    public void setContaSelecionada(Conta contaSelecionada) {
        this.contaSelecionada = contaSelecionada;
        this.ShowSaldo.setText("R$ " + Double.toString(contaSelecionada.getSaldo()));
    }

    public void atualizarSaldo(String novoValor) {
        this.ShowSaldo.setText(novoValor);
    }

    public FuncionarioUI getFuncionarioUI() {
        return funcionarioUI;
    }

    public void setFuncionarioUI(FuncionarioUI funcionarioUI) {
        this.funcionarioUI = funcionarioUI;
    }

    public AdministradorUI getAdministradorUI() {
        return administradorUI;
    }

    public void setAdministradorUI(AdministradorUI administradorUI) {
        this.administradorUI = administradorUI;
    }

    public Cliente getClienteLogado() {
        return clienteLogado;
    }

    public void setClienteLogado(Cliente clienteLogado) {
        this.clienteLogado = clienteLogado;
    }

    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    public void setFuncionarioLogado(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
    }

    public Administrador getAdministradorLogado() {
        return administradorLogado;
    }

    public void setAdministradorLogado(Administrador administradorLogado) {
        this.administradorLogado = administradorLogado;
    }
        
    /**
     * Metodo reponsavel por processar o extrato bancario da conta selecionada
     * para interagir com essa interface.
     * 
     * @param retornarLinhas
     * @return String com os extratos se o parametro retornarLinhas == false ou 
     * se o se o parametro retornarLinhas == true return String com o numero 
     * de linhas a ser exibido no text area da nova janela.
     * 
     */
    private String setExtrato(boolean retornarLinhas) {
        StringBuilder sb = new StringBuilder();

        if (retornarLinhas == false) {
            for (String extrato : contaSelecionada.getExtratos()) {
                sb.append(extrato);
            }
            return sb.toString();
        } else {
            return Integer.toString(contaSelecionada.getExtratos().size() + 20);
        }
    }

    /**
     * Creates new form ContaCorrenteUI
     */
    public ContaUI() {
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

        ContaPainel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ShowSaldo = new javax.swing.JLabel();
        BarraMenuConta = new javax.swing.JMenuBar();
        Sacar = new javax.swing.JMenu();
        Depositar = new javax.swing.JMenu();
        Transferir = new javax.swing.JMenu();
        Extrato = new javax.swing.JMenu();
        telaInicial = new javax.swing.JMenu();
        Sair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conta - WWBanck");

        ContaPainel.setBackground(new java.awt.Color(0, 20, 73));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Saldo disponível");

        ShowSaldo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ShowSaldo.setForeground(new java.awt.Color(255, 255, 255));
        ShowSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ShowSaldo.setText("R$ 0,00");
        ShowSaldo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ContaPainelLayout = new javax.swing.GroupLayout(ContaPainel);
        ContaPainel.setLayout(ContaPainelLayout);
        ContaPainelLayout.setHorizontalGroup(
            ContaPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContaPainelLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(ContaPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(ShowSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(116, 116, 116))
        );
        ContaPainelLayout.setVerticalGroup(
            ContaPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContaPainelLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShowSaldo)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        Sacar.setForeground(new java.awt.Color(0, 20, 73));
        Sacar.setText("Sacar");
        Sacar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Sacar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickSacar(evt);
            }
        });
        Sacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SacarActionPerformed(evt);
            }
        });
        BarraMenuConta.add(Sacar);

        Depositar.setText("Depositar");
        Depositar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Depositar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickDepositar(evt);
            }
        });
        Depositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepositarActionPerformed(evt);
            }
        });
        BarraMenuConta.add(Depositar);

        Transferir.setText("Transferir");
        Transferir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Transferir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickTransferir(evt);
            }
        });
        BarraMenuConta.add(Transferir);

        Extrato.setText("Extrato da conta");
        Extrato.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Extrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickExtrato(evt);
            }
        });
        BarraMenuConta.add(Extrato);

        telaInicial.setText("Tela inicial");
        telaInicial.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        telaInicial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicktelaInicial(evt);
            }
        });
        telaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaInicialActionPerformed(evt);
            }
        });
        BarraMenuConta.add(telaInicial);

        Sair.setText("Sair");
        Sair.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickSair(evt);
            }
        });
        BarraMenuConta.add(Sair);

        setJMenuBar(BarraMenuConta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContaPainel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ContaPainel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SacarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_SacarActionPerformed

    private void clickSacar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickSacar
        Sacar show = new Sacar();
        listaContas.remove(contaSelecionada);
        show.setContaSelecionada(contaSelecionada);
        show.setListaContas(listaContas);
        show.setContaUI(this);
        this.setVisible(false);
        show.setVisible(true);
    }//GEN-LAST:event_clickSacar

    private void clickDepositar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickDepositar
        Depositar show = new Depositar();
        listaContas.remove(contaSelecionada);
        show.setContaSelecionada(contaSelecionada);
        show.setListaContas(listaContas);
        show.setContaUI(this);
        this.setVisible(false);
        show.setVisible(true);
    }//GEN-LAST:event_clickDepositar

    private void clickTransferir(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickTransferir
        Transferir show = new Transferir();
        listaContas.remove(contaSelecionada);
        show.setContaSelecionada(contaSelecionada);
        show.setListaContas(listaContas);
        show.setContaUI(this);
        this.setVisible(false);
        show.setVisible(true);
    }//GEN-LAST:event_clickTransferir

    private void clickExtrato(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickExtrato
        Extrato show = new Extrato();
        show.setContaUI(this);
        show.setListaContas(listaContas);
        show.setShowExtrato(setExtrato(false), Integer.parseInt(setExtrato(true)));
        show.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_clickExtrato

    private void clickSair(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickSair
        System.exit(0);

    }//GEN-LAST:event_clickSair

    private void DepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepositarActionPerformed

    }//GEN-LAST:event_DepositarActionPerformed

    private void clicktelaInicial(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicktelaInicial

        if (clienteUI != null) {
            clienteUI.setVisible(true);
        } else if (funcionarioUI != null) {
            funcionarioUI.setVisible(true);
        } else if (administradorUI != null) {
            administradorUI.setVisible(true);
        }
        this.dispose();

    }//GEN-LAST:event_clicktelaInicial

    private void telaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telaInicialActionPerformed

    }//GEN-LAST:event_telaInicialActionPerformed

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
            java.util.logging.Logger.getLogger(ContaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContaUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraMenuConta;
    private javax.swing.JPanel ContaPainel;
    private javax.swing.JMenu Depositar;
    private javax.swing.JMenu Extrato;
    private javax.swing.JMenu Sacar;
    private javax.swing.JMenu Sair;
    private javax.swing.JLabel ShowSaldo;
    private javax.swing.JMenu Transferir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu telaInicial;
    // End of variables declaration//GEN-END:variables
}
