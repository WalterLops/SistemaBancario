/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import views.FA.InfoFA;
import views.FA.AlterarInfoFA;
import views.FA.RemoverFA;
import java.util.List;
import jsonOperations.Leitura;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Funcionario;
import views.administrador.RemoverCliente;
import views.funcionario.AlterarInfoCliente;
import views.funcionario.InfoCliente;

/**
 * Classe responsavel por validar osbjetos do tipo de: Cliente, Funcionario, 
 * Administrador. E repassa um desses objetos para as interfaces posteriores.
 * 
 * @author Walter
 */
public class ValidarUsuariosUI extends javax.swing.JFrame {

    
    private String baseClientes = "./src/baseDeDados/clientes.json";
    private String baseFuncionarios = "./src/baseDeDados/funcionarios.json";
    private String baseAdministradores = "./src/baseDeDados/administradores.json";
    private Cliente clienteSelecionado;
    private Funcionario funcionarioSelecionado = null;
    private Administrador administradorSelecionado = null;
    
    private FuncionarioUI funcionarioUI;
    private Funcionario funcionarioLogado = null;
    
    private AdministradorUI administradorUI;
    private Administrador administradorLogado = null;
    
    private InfoCliente infoCliente = null;
    private InfoFA infoFA = null;
    private AlterarInfoFA alterarInfoFA = null;
    
    private AlterarInfoCliente alterarInfoCliente = null;
    private RemoverCliente removerCliente = null;
    private RemoverFA removerFA = null;

    public Funcionario getFuncionarioSelecionado() {
        return funcionarioSelecionado;
    }

    public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
        this.funcionarioSelecionado = funcionarioSelecionado;
    }

    public Administrador getAdministradorSelecionado() {
        return administradorSelecionado;
    }

    public void setAdministradorSelecionado(Administrador administradorSelecionado) {
        this.administradorSelecionado = administradorSelecionado;
    }

    public InfoFA getInfoFA() {
        return infoFA;
    }

    public void setInfoFA(InfoFA infoFA) {
        this.infoFA = infoFA;
    }
    
    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    public void setFuncionarioLogado(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
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

    public Administrador getAdministradorLogado() {
        return administradorLogado;
    }

    public void setAdministradorLogado(Administrador administradorLogado) {
        this.administradorLogado = administradorLogado;
    }
    
    public AlterarInfoCliente getAlterarInfoCliente() {
        return alterarInfoCliente;
    }

    public void setAlterarInfoCliente(AlterarInfoCliente alterarInfoCliente) {
        this.alterarInfoCliente = alterarInfoCliente;
    }

    public InfoCliente getInfoCliente() {
        return infoCliente;
    }

    public void setInfoCliente(InfoCliente infoCliente) {
        this.infoCliente = infoCliente;
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public RemoverCliente getRemoverCliente() {
        return removerCliente;
    }

    public void setRemoverCliente(RemoverCliente removerCliente) {
        this.removerCliente = removerCliente;
    }

    public String getBaseClientes() {
        return baseClientes;
    }

    public void setBaseClientes(String baseClientes) {
        this.baseClientes = baseClientes;
    }

    public String getBaseFuncionarios() {
        return baseFuncionarios;
    }

    public void setBaseFuncionarios(String baseFuncionarios) {
        this.baseFuncionarios = baseFuncionarios;
    }

    public String getBaseAdministradores() {
        return baseAdministradores;
    }

    public void setBaseAdministradores(String baseAdministradores) {
        this.baseAdministradores = baseAdministradores;
    }

    public AlterarInfoFA getAlterarInfoFA() {
        return alterarInfoFA;
    }

    public void setAlterarInfoFA(AlterarInfoFA alterarInfoFA) {
        this.alterarInfoFA = alterarInfoFA;
    }

    public RemoverFA getRemoverFA() {
        return removerFA;
    }

    public void setRemoverFA(RemoverFA removerFA) {
        this.removerFA = removerFA;
    }
    
    
    /**
     * Metodo responsavel por pesquisar e definir objeto clienteSelecionado para as 
     * operacoes da interface e interfaces posteriores.
     */
    public void setValidarCliente() {
        String id = this.cxID.getText();
        List<Cliente> listaCliente = Leitura.lerClientes(baseClientes);
        for (Cliente c : listaCliente){
            if(c.getId().equals(id)){
                clienteSelecionado = c;
            }
        }
    }
    
    /**
     * Metodo responsavel por pesquisar e definir objeto funcionarioSelecionado para as 
     * operacoes da interface e interfaces posteriores.
     */
    public void setValidarFuncionario() {
        String id = this.cxID.getText();
        Funcionario [] listaFuncionarios = Leitura.lerFuncionarios(baseFuncionarios);
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getId().equals(id)){
                funcionarioSelecionado = funcionario;
            }
        }
    }
    
    /**
     * Metodo responsavel por pesquisar e definir objeto administradorSelecionado para as 
     * operacoes da interface e interfaces posteriores.
     */
     public void setValidarAdministrador(){
         String id = this.cxID.getText();
         Administrador [] listaAdministradores = Leitura.lerAdministradores(baseAdministradores);
         for (Administrador administrador : listaAdministradores) {
             if (administrador.getId().equals(id)){
                 administradorSelecionado = administrador;
             }
         }
     }
    
     /**
      * Metodo do botao Ir. Seleciona uma das janelas em que for diferente de null: 
      * <ul>
      * <li> infoCliente
      * <li> funcionarioUI
      * <li> administradorUI
      * <li> alterarInfoCliente
      * <li> removerCliente
      * <li> infoFA
      * <li> administradorUI
      * <li> removerFA
      * </ul>
      * <br>
      * <ul>
      * <li> Com base nos objetos em que for diferente de null: 
      * <li> clienteSelecionado;
      * <li> funcionarioLogado;
      * <li> administradorSelecionado; 
      * <li> administradorLogado
      * </ul>
      */
    public void prosseguir(){
        setValidarCliente();
        
        if (infoCliente != null){ // visualizar informacoes do cliente
            infoCliente.setClienteSelecionado(clienteSelecionado);
            infoCliente.setVisible(true);
            
            if (funcionarioLogado != null){
                funcionarioUI.setClienteSelecionado(clienteSelecionado);
                funcionarioUI.setLimparAreaDeTrabalho();
                funcionarioUI.setInfoCliente(infoCliente);
            }
            
            if (administradorLogado != null){
                administradorUI.setClienteSelecionado(clienteSelecionado);
                administradorUI.setLimparAreaDeTrabalho();
                administradorUI.setInfoCliente(infoCliente); 
            }
            
            this.dispose();
        }
        else if (alterarInfoCliente != null){ // alterar informacoes do cliente a partir do funcionario
            
            if (funcionarioLogado != null){
                alterarInfoCliente.setFuncionarioLogado(funcionarioLogado);
                alterarInfoCliente.setClienteSelecionado(clienteSelecionado);
                alterarInfoCliente.setBaseClientes(baseClientes);
                alterarInfoCliente.setVisible(true);
                funcionarioUI.setClienteSelecionado(clienteSelecionado);
                funcionarioUI.setLimparAreaDeTrabalho();
                funcionarioUI.setAlterarCliente(alterarInfoCliente);
            }

            if (administradorLogado != null){ // alterar informacoes do cliente a partir do administrador
                alterarInfoCliente.setFuncionarioLogado(administradorLogado);
                alterarInfoCliente.setClienteSelecionado(clienteSelecionado);
                alterarInfoCliente.setBaseClientes(baseClientes);
                alterarInfoCliente.setVisible(true);
                administradorUI.setClienteSelecionado(clienteSelecionado);
                administradorUI.setLimparAreaDeTrabalho();
                administradorUI.setAlterarCliente(alterarInfoCliente);
            }
            
            this.dispose();
        }
        else if (removerCliente != null){ // remover cliente a partir do funcionario
            removerCliente.setClienteSelecionado(clienteSelecionado);
            removerCliente.setInfoCliente();
            removerCliente.setBaseClientes(baseClientes);
            removerCliente.setAdiministradorLogado(administradorLogado);
            removerCliente.setVisible(true);
            administradorUI.setRemoverCliente(removerCliente);
            this.dispose();
        }
        else if (infoFA != null){ // mostra as informacoes do funcionario ou cliente
            setValidarFuncionario();
            setValidarAdministrador();
            if (funcionarioSelecionado != null){ // mostra as informacoes do funcionario
                infoFA.setFuncionarioSelecionado(funcionarioSelecionado);
                infoFA.setShowDados();
                infoFA.setVisible(true);
                administradorUI.setLimparAreaDeTrabalho();
                administradorUI.setInfoFA(infoFA);
                this.dispose();
            }
            else if(administradorSelecionado != null){ // mostra as informacoes administrador
                infoFA.setFuncionarioSelecionado(administradorSelecionado);
                infoFA.setShowDados();
                infoFA.setVisible(true);
                administradorUI.setLimparAreaDeTrabalho();
                administradorUI.setInfoFA(infoFA);
                this.dispose();
            }
        }
        else if (alterarInfoFA != null){ // altera as informacoes do fucionario ou admistrador.
            setValidarFuncionario();
            setValidarAdministrador();
            if (funcionarioSelecionado != null){ // altera as informacoes do fucionario.
                alterarInfoFA.setFuncionarioSelecionado(funcionarioSelecionado);
                alterarInfoFA.setAdministradorLogado(administradorLogado);
                alterarInfoFA.setShowDados();
                alterarInfoFA.setVisible(true);
                administradorUI.setLimparAreaDeTrabalho();
                administradorUI.setAlterarInfoFA(alterarInfoFA);
                this.dispose();
            }
            else if(administradorSelecionado != null){ // altera as informacoes do admistrador.
                alterarInfoFA.setAdministradorSelecionado(administradorSelecionado);
                alterarInfoFA.setAdministradorLogado(administradorLogado);
                alterarInfoFA.setShowDados();
                alterarInfoFA.setVisible(true);
                administradorUI.setLimparAreaDeTrabalho();
                administradorUI.setAlterarInfoFA(alterarInfoFA);
                this.dispose();
            }
        }
        else if (removerFA != null){ // remove fucionario ou admistrador.
            setValidarFuncionario();
            setValidarAdministrador();
            if (funcionarioSelecionado != null){ // remove fucionario.
                removerFA.setFuncionarioSelecionado(funcionarioSelecionado);
                removerFA.setAdministradorLogado(administradorLogado);
                removerFA.setShowDados();
                removerFA.setVisible(true);
                administradorUI.setLimparAreaDeTrabalho();
                administradorUI.setRemoverFA(removerFA);
                this.dispose();
            }
            else if(administradorSelecionado != null){ // remove admistrador.
                removerFA.setAdministradorSelecionado(administradorSelecionado);
                removerFA.setAdministradorLogado(administradorLogado);
                removerFA.setShowDados();
                removerFA.setVisible(true);
                administradorUI.setLimparAreaDeTrabalho();
                administradorUI.setRemoverFA(removerFA);
                this.dispose();
            }
        }
        
    }
    
    /**
     * Creates new form ValidarConta
     */
    public ValidarUsuariosUI() {
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
        btnProsseguir = new javax.swing.JButton();
        cxID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 180));
        setMinimumSize(new java.awt.Dimension(700, 400));

        jPanel1.setBackground(new java.awt.Color(2, 78, 148));
        jPanel1.setMaximumSize(new java.awt.Dimension(700, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));

        btnProsseguir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnProsseguir.setForeground(new java.awt.Color(2, 78, 148));
        btnProsseguir.setText("IR");
        btnProsseguir.setMaximumSize(new java.awt.Dimension(120, 23));
        btnProsseguir.setMinimumSize(new java.awt.Dimension(120, 23));
        btnProsseguir.setPreferredSize(new java.awt.Dimension(120, 23));
        btnProsseguir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProsseguirMouseClicked(evt);
            }
        });
        btnProsseguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsseguirActionPerformed(evt);
            }
        });

        cxID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cxID.setForeground(new java.awt.Color(2, 78, 148));
        cxID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxIDActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID do usuario");

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(2, 78, 148));
        btnCancelar.setText("Cancelar");
        btnCancelar.setMaximumSize(new java.awt.Dimension(120, 23));
        btnCancelar.setMinimumSize(new java.awt.Dimension(120, 23));
        btnCancelar.setPreferredSize(new java.awt.Dimension(120, 23));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(cxID, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProsseguir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cxID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProsseguir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(127, 127, 127))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cxIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxIDActionPerformed

    private void btnProsseguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsseguirActionPerformed
       
    }//GEN-LAST:event_btnProsseguirActionPerformed

    private void btnProsseguirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProsseguirMouseClicked
        prosseguir();
    }//GEN-LAST:event_btnProsseguirMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(ValidarUsuariosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValidarUsuariosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ValidarUsuariosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValidarUsuariosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ValidarUsuariosUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnProsseguir;
    private javax.swing.JTextField cxID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
