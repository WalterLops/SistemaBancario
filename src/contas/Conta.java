/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import jsonOperations.Escrita;
import jsonOperations.Leitura;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Funcionario;

/**
 *
 * @author Walter
 */
public class Conta {

    private int idConta;
    private int agencia;
    private int numeroConta;
    private double saldo;
    private String tipoConta;
    protected SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
    protected SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");

    public Conta(int idConta, int agencia, int numeroConta, double saldo, String tipoConta) {
        this.idConta = idConta;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    // Métodos específicos 
    public boolean sacar(double valorSaque) {
        if (valorSaque <= getSaldo()) {
            double novoSaldo = getSaldo() - valorSaque;
            setSaldo(novoSaldo);
            JOptionPane.showMessageDialog(null, "Operação realizada com sucesso. "
                    + "\nNovo valor da conta: " + getSaldo());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente para essa operação.");
            return false;
        }

    }

    public void depositar(double valorDeposito) {
        double novoSaldo = getSaldo() + valorDeposito;
        setSaldo(novoSaldo);
        JOptionPane.showMessageDialog(null, "Valor depositado com sucesso!");
    }

    public Conta transferir(double valorTranferir, Conta contaDestino) {
        if (sacar(valorTranferir)){
        contaDestino.depositar(valorTranferir);
        }
        return contaDestino;
    }
    
    public String infoConta(){
        return "\n=================================================================="
                + "\nTipo da conta: " + getTipoConta()
                + "\nAgência: " + getAgencia()
                + "\nID da Conta: " + getIdConta()
                + "\nNumero da Conta: " + getNumeroConta()
                + "\nSaldo: " + getSaldo()
                +"\n==================================================================";
    }
    
    public void setRegistrarExtrato(double valor, String operacao, Conta conta){
        String baseClientes = "./src/baseDeDados/clientes.json";
        String baseFuncionarios = "./src/baseDeDados/funcionarios.json";
        String baseAdministradores = "./src/baseDeDados/administradores.json";
        String baseContas = "./src/baseDeDados/listaContas.json";
        
        List<Cliente> listaClientes = Leitura.lerClientes(baseClientes);
        Funcionario[] listaFuncionarios = Leitura.lerFuncionarios(baseFuncionarios);
        Administrador[] listaAdministradors = Leitura.lerAdministradores(baseAdministradores);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String extrato = String.format(
                "\n"+sdf.format(new Date())+" - "+operacao+" - R$"+valor
                        +" Saldo total da conta: R$ "+conta.getSaldo());
        int index = 0;
        for (Cliente c : listaClientes){
            for (Integer i : c.getsetIdConta()){
                if(conta.getIdConta() == i){
                    c.setExtratos(extrato);
                    index = 1;
                    break;
                }
            }
        }
        for (Funcionario f : listaFuncionarios){
            for (Integer i : f.getsetIdConta()){
                if(conta.getIdConta() == i){
                    f.setExtratos(extrato);
                    index = 2;
                    break;
                }
            }
        }
        for (Administrador a : listaAdministradors){
            for (Integer i : a.getsetIdConta()){
                if(conta.getIdConta() == i){
                    a.setExtratos(extrato);
                    index = 3;
                    break;
                }
            }
        }
        switch (index) {
            case 1 -> {
                Escrita.escreverCliente(listaClientes, baseClientes);
            }
            case 2 -> {
                 Escrita.escreverFuncionario(listaFuncionarios, baseFuncionarios);
            }
            case 3 -> {
                 Escrita.escreverAdmin(listaAdministradors, baseAdministradores);
            }
        }
        listaClientes = null;
        listaFuncionarios = null;
        listaAdministradors = null;
        System.gc();
    }

    @Override
    public String toString() { //extratoConta
        return "\n=================================================================="
                + "\nWW Bank" + "  Extro " + getTipoConta()
                + "\nAgência: " + getAgencia() + " Data: " + data.format(new Date()) + " Hora: " + hora.format(new Date())
                + "\nID da Conta: " + getIdConta()
                + "\nNumero da Conta: " + getNumeroConta()
                + "\nSaldo: " + getSaldo(); 
    }
}
