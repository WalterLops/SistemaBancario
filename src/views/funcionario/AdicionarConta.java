/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views.funcionario;

import contas.Conta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jsonOperations.Escrita;
import jsonOperations.Leitura;
import org.json.simple.parser.ParseException;
import usuarios.Funcionario;
import views.ApenasNumeros;
import views.FuncionarioUI;

/**
 *
 * @author Walter
 */
public class AdicionarConta extends javax.swing.JInternalFrame {

    private List<Conta> listaContas;
    private Funcionario funcionarioLogado;
    private String baseContas;
    
    

    public String getBaseContas() {
        return baseContas;
    }

    public void setBaseContas(String baseContas) {
        this.baseContas = baseContas;
    }

    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    public void setFuncionarioLogado(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
    }

    private void setListaContas() {
        try {
            this.listaContas = Leitura.lerContas(baseContas);
        } catch (ParseException ex) {
            Logger.getLogger(AdicionarConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form MeusDados
     */
    public AdicionarConta() {
        initComponents();
        this.cxLimiteSaque.setDocument(new ApenasNumeros());
        this.cxNumeroConta.setDocument(new ApenasNumeros());
        this.cxSaldo.setDocument(new ApenasNumeros());
        this.cxTaxa.setDocument(new ApenasNumeros());
        this.cxID.setDocument(new ApenasNumeros());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cxTipoConta = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cxCNPJ = new javax.swing.JTextField();
        cxSaldo = new javax.swing.JTextField();
        cxID = new javax.swing.JTextField();
        cxLimiteSaque = new javax.swing.JTextField();
        cxTaxa = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        cxAgencia = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cxNumeroConta = new javax.swing.JTextField();

        setTitle("Adicionar Conta");
        setMaximumSize(new java.awt.Dimension(700, 495));
        setMinimumSize(new java.awt.Dimension(700, 495));
        setPreferredSize(new java.awt.Dimension(700, 495));

        cxTipoConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "201 = Conta poupança", "205 = Conta Salário", "209 = Conta corrente" }));

        jLabel1.setText("Escolha o código da conta a ser cadastrada");

        jLabel2.setText("ID da conta");

        jLabel3.setText("Número da agência");

        jLabel4.setText("Saldo inicial da conta");

        jLabel5.setText("CNPJ da empresa (conta salário)");

        jLabel6.setText("Taxa de manutenção (conta corrente)");

        jLabel7.setText("Limite de saque (conta poupança)");

        cxSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxSaldoActionPerformed(evt);
            }
        });

        cxTaxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxTaxaActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        cxAgencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "709" }));

        jLabel8.setText("Número da conta");

        cxNumeroConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxNumeroContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cxNumeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cxID, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxTipoConta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cxSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cxCNPJ)
                                    .addComponent(cxLimiteSaque)
                                    .addComponent(cxTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(cxAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cxTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cxAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cxNumeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4))
                    .addComponent(cxSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cxCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cxTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(cxLimiteSaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnSalvar)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cxTaxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxTaxaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxTaxaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            this.setListaContas();

            int tipoConta = Integer.parseInt(this.cxTipoConta.getSelectedItem().toString().replaceAll("[^0-9]", ""));
            int agencia = Integer.parseInt(this.cxAgencia.getSelectedItem().toString());
            int idConta = Integer.parseInt(this.cxID.getText());
            int numeroConta = Integer.parseInt(this.cxNumeroConta.getText());
            double saldo = Double.parseDouble(this.cxSaldo.getText());
            double limiteSaque = 0.0;
            double taxaManutenção = 0.0;
            String CNPJ = "";

            switch (tipoConta) {
                case 201 -> { // Conta poupança
                    limiteSaque = Double.parseDouble(this.cxLimiteSaque.getText());

                }
                case 205 -> { // Conta corrente
                    taxaManutenção = Double.parseDouble(this.cxTaxa.getText());

                }
                case 209 -> { // Conta salário
                    CNPJ = this.cxCNPJ.getText();

                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro desconhecido");

                }
            }
            listaContas.add(this.funcionarioLogado.adicionarConta(
                    tipoConta, idConta, agencia, numeroConta, saldo, 
                    limiteSaque, taxaManutenção, CNPJ));
            Escrita.escreverContas(listaContas, baseContas);
            JOptionPane.showMessageDialog(null, "Nova conta adicionada com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Digite todos os dados");
        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cxSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxSaldoActionPerformed

    private void cxNumeroContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxNumeroContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxNumeroContaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cxAgencia;
    private javax.swing.JTextField cxCNPJ;
    private javax.swing.JTextField cxID;
    private javax.swing.JTextField cxLimiteSaque;
    private javax.swing.JTextField cxNumeroConta;
    private javax.swing.JTextField cxSaldo;
    private javax.swing.JTextField cxTaxa;
    private javax.swing.JComboBox<String> cxTipoConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
