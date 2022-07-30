/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views.funcionario;

import agencia.Agencia;
import contas.Conta;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import jsonOperations.Escrita;
import jsonOperations.Leitura;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Funcionario;
import views.ApenasNumeros;

/**
 * Adiciona uma nova conta bancaria
 * 
 * @author Walter
 */
public class AdicionarConta extends javax.swing.JInternalFrame {

    private List<Conta> listaContas;
    private Funcionario funcionarioLogado = null;
    private String baseContas;

    private List<Cliente> listaCliente;
    private Funcionario[] listaFuncionarios;
    private Administrador[] listaAdministradors;
    private String baseClientes = "./src/baseDeDados/clientes.json";
    private String baseFuncionarios = "./src/baseDeDados/funcionarios.json";
    private String baseAdministradores = "./src/baseDeDados/administradores.json";
    private String baseAgencias = "./src/baseDeDados/listaAgencias.json";

    private Cliente clienteProprietario = null;
    private Funcionario funcionarioProprietario = null;
    private Administrador administradorProprietario = null;

    private Administrador administradorLogado = null;

    public Administrador getAdministradorLogado() {
        return administradorLogado;
    }

    public void setAdministradorLogado(Administrador administradorLogado) {
        this.administradorLogado = administradorLogado;
    }

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

    public String getBaseClientes() {
        return baseClientes;
    }

    public void setBaseClientes(String baseClientes) {
        this.baseClientes = baseClientes;
    }

    public String getBaseAdministradores() {
        return baseAdministradores;
    }

    public void setBaseAdministradores(String baseAdministradores) {
        this.baseAdministradores = baseAdministradores;
    }

    public Administrador getAdministradorProprietario() {
        return administradorProprietario;
    }

    public void setAdministradorProprietario(Administrador administradorProprietario) {
        this.administradorProprietario = administradorProprietario;
    }

    public String getBaseAgencias() {
        return baseAgencias;
    }

    public void setBaseAgencias(String baseAgencias) {
        this.baseAgencias = baseAgencias;
    }
    
    

    private void setListaContas() {
        this.listaContas = Leitura.lerContas(baseContas);
    }
    
    /**
     * Associando a nova conta bancaria criada ao Cliente, Funcionario
     * ou Adminstrador. O ID da conta e adicionado as contas associadas do
     * usuario.
     * 
     * @param novaConta 
     */
    private void setAssociarContaProprietario(Conta novaConta) {

        if (listaCliente != null) {
            for (Cliente c : listaCliente) {
                if (clienteProprietario.getId().equals(c.getId())) {
                    c.setIdConta(novaConta.getIdConta());
                }
            }
            Escrita.escreverCliente(listaCliente, baseClientes);
        } else if (listaFuncionarios != null) {
            for (Funcionario c : listaFuncionarios) {
                if (funcionarioProprietario.getId().equals(c.getId())) {
                    c.setIdConta(novaConta.getIdConta());
                }
            }
            Escrita.escreverFuncionario(listaFuncionarios, baseFuncionarios);
        } else {
            for (Administrador c : listaAdministradors) {
                if (administradorProprietario.getId().equals(c.getId())) {
                    c.setIdConta(novaConta.getIdConta());
                }
            }
            Escrita.escreverAdmin(listaAdministradors, baseAdministradores);
        }
    }
    
    /**
     * Metodo para preencher o comboBox com os codigos das agencias existentes
     */
    public void setInicializarAgencias(){
        List<Agencia> listaAgencias = Leitura.lerAgencias(baseAgencias);
        for (Agencia a : listaAgencias){
            this.cxAgencia.addItem(Integer.toString(a.getCodigo()));
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
        jLabel9 = new javax.swing.JLabel();
        cxIDProprietario = new javax.swing.JTextField();
        addID = new javax.swing.JButton();

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

        jLabel8.setText("Número da conta");

        cxNumeroConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxNumeroContaActionPerformed(evt);
            }
        });

        jLabel9.setText("ID do proprietário da conta");

        cxIDProprietario.setMaximumSize(new java.awt.Dimension(385, 2147483647));
        cxIDProprietario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cxIDProprietarioMouseClicked(evt);
            }
        });

        addID.setText("Adicionar ID");
        addID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                                .addComponent(jLabel4)
                                .addComponent(jLabel9))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cxSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addComponent(cxAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cxCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cxLimiteSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cxTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cxIDProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(31, 31, 31)
                                            .addComponent(addID)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cxTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cxLimiteSaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cxIDProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addID))
                .addGap(28, 28, 28)
                .addComponent(btnSalvar)
                .addGap(88, 88, 88))
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
                case 205 -> { // Conta salário
                    CNPJ = this.cxCNPJ.getText();

                }
                case 209 -> { // Conta corrente
                    taxaManutenção = Double.parseDouble(this.cxTaxa.getText());

                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro desconhecido");

                }
            }

            Conta novaConta = null;

            if (funcionarioLogado != null) {
                novaConta = funcionarioLogado.adicionarConta(
                        tipoConta, idConta, agencia, numeroConta, saldo,
                        limiteSaque, taxaManutenção, CNPJ);

                listaContas.add(novaConta);
            }

            if (administradorLogado != null) {
                novaConta = administradorLogado.adicionarConta(
                        tipoConta, idConta, agencia, numeroConta, saldo,
                        limiteSaque, taxaManutenção, CNPJ);
                listaContas.add(novaConta);
            }
            setAssociarContaProprietario(novaConta);
            Escrita.escreverContas(listaContas, baseContas);
            JOptionPane.showMessageDialog(null, "Nova conta adicionada com sucesso!");

        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite todos os dados");
        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cxSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxSaldoActionPerformed

    private void cxNumeroContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxNumeroContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxNumeroContaActionPerformed

    private void cxIDProprietarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cxIDProprietarioMouseClicked
        JOptionPane.showMessageDialog(null, "Digite as contas associadas separando por vírgula caso o cliente tenha mais de 1."
                + "\n Ex.: 00000, 00000");
    }//GEN-LAST:event_cxIDProprietarioMouseClicked

    private void addIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIDActionPerformed
        listaCliente = Leitura.lerClientes(baseClientes);
        listaFuncionarios = Leitura.lerFuncionarios(baseFuncionarios);
        listaAdministradors = Leitura.lerAdministradores(baseAdministradores);
        // procurando o proprietario da conta
        for (Cliente c : listaCliente) {
            if (this.cxIDProprietario.getText().equals(c.getId())) {
                clienteProprietario = c;
            }
        }
        for (Funcionario c : listaFuncionarios) {
            if (this.cxIDProprietario.getText().equals(c.getId())) {
                funcionarioProprietario = c;
            }
        }
        for (Administrador c : listaAdministradors) {
            if (this.cxIDProprietario.getText().equals(c.getId())) {
                administradorProprietario = c;
            }
        }
        
        // liberando a memoria com base nas listas lidas e o usuario proprietario encontrado
        int cont = 0;
        if (clienteProprietario == null) {
            listaCliente.clear();
            listaCliente = null;
            cont++;
        }
        if (funcionarioProprietario == null) {
            listaFuncionarios = null;
            cont++;
        }
        if (administradorProprietario == null) {
            listaAdministradors = null;
            cont++;
        }
        System.gc();
        if (cont == 3) {
            JOptionPane.showMessageDialog(null, "Usuário proprietário  não encontrado!");
        }
        else {
            JOptionPane.showMessageDialog(null, "ID do Usuário proprietário adicionado com sucesso!!");
        }
    }//GEN-LAST:event_addIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addID;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cxAgencia;
    private javax.swing.JTextField cxCNPJ;
    private javax.swing.JTextField cxID;
    private javax.swing.JTextField cxIDProprietario;
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
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
