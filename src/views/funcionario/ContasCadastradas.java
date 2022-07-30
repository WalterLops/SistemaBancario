/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views.funcionario;

/**
 * Mostra as informacoes das contas cadastradas
 * 
 * @author Walter
 */
public class ContasCadastradas extends javax.swing.JInternalFrame {

    /**
     * Metodo para mostar as informacoes das contas cadastradas
     * 
     * @param msg
     * @param linhas 
     */
    public void setShowContas(String msg, int linhas){
        this.showContas.setRows(linhas);
        this.showContas.setText(msg);
    }
    
    /**
     * Creates new form MeusDados
     */
    public ContasCadastradas() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        showContas = new javax.swing.JTextArea();

        setTitle("Contas Cadastradas");
        setMaximumSize(new java.awt.Dimension(700, 495));
        setMinimumSize(new java.awt.Dimension(700, 495));
        setPreferredSize(new java.awt.Dimension(700, 495));

        showContas.setColumns(20);
        showContas.setRows(5);
        showContas.setPreferredSize(new java.awt.Dimension(700, 495));
        jScrollPane1.setViewportView(showContas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea showContas;
    // End of variables declaration//GEN-END:variables
}
