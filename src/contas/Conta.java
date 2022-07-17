/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contas;

import java.text.SimpleDateFormat;
import java.util.Date;

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
            System.out.println("Operação realizada com sucesso. "
                    + "\nNovo valor da conta: " + getSaldo());
            return true;
        } else {
            System.out.println("Você não tem saldo suficiente para essa operação."
                    + "\nPor favor, tente novamente.");
            return false;
        }

    }

    public void depositar(double valorDeposito) {
        double novoSaldo = getSaldo() + valorDeposito;
        setSaldo(novoSaldo);
    }

    public void transferir(double valorTranferir, Conta contaDestino) {
        if (sacar(valorTranferir)){
        contaDestino.depositar(valorTranferir);
        }
        
    }

    @Override
    public String toString() { //extratoConta
        return "\n=================================================================="
                + "\nWW Bank" + "  Extro " + getTipoConta()
                + "\nAgência: " + getAgencia() + " Data: " + data.format(new Date()) + " Hora: " + hora.format(new Date())
                + "\nConta: " + getIdConta()
                + "\nSaldo: " + getSaldo();
                
    }

}
