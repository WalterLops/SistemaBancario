/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.MenuContainer;
import views.conta.Transferir;
import views.conta.Depositar;
import views.conta.Sacar;

/**
 *
 * @author Walter
 */
public class ContaUI extends javax.swing.JFrame {

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
                .addContainerGap(199, Short.MAX_VALUE))
        );

        Sacar.setText("Sacar");
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
        Depositar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickDepositar(evt);
            }
        });
        BarraMenuConta.add(Depositar);

        Transferir.setText("Transferir");
        Transferir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickTransferir(evt);
            }
        });
        BarraMenuConta.add(Transferir);

        Extrato.setText("Extrato da conta");
        Extrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickExtrato(evt);
            }
        });
        BarraMenuConta.add(Extrato);

        Sair.setText("Sair");
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
        //this.ShowSaldo.setText("Clicou sacar");
        this.setVisible(false);
        new Sacar().setVisible(true);
    }//GEN-LAST:event_clickSacar

    private void clickDepositar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickDepositar
        //this.ShowSaldo.setText("Clicou Depositar1");
        this.setVisible(false);
        new Depositar().setVisible(true);
    }//GEN-LAST:event_clickDepositar

    private void clickTransferir(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickTransferir
        //this.ShowSaldo.setText("Clicou Transferir");
        this.setVisible(false);
        new Transferir().setVisible(true);
    }//GEN-LAST:event_clickTransferir

    private void clickExtrato(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickExtrato
        this.ShowSaldo.setText("Clicou Extrato");
    }//GEN-LAST:event_clickExtrato

    private void clickSair(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickSair
        //this.ShowSaldo.setText("Clicou Sair");
        System.exit(0);
    }//GEN-LAST:event_clickSair

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
    // End of variables declaration//GEN-END:variables
}
