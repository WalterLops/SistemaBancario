/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit 
this template
 */
package contas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe generica conta.
 * 
 * @author Walter
 */
public class Conta {

    private int idConta;
    private int agencia;
    private int numeroConta;
    private double saldo;
    private String tipoConta;
    private List<String> extratos = new ArrayList<>();

    public Conta(int idConta, int agencia, int numeroConta,
            double saldo, String tipoConta) {
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

    public List<String> getExtratos() {
        return extratos;
    }

    public void setExtratos(String extratos) {
        this.extratos.add(extratos);
    }

    /**
     *
     * @param valorSaque
     * @return true se o saque foi realizado com sucesso ou false se o saque nao
     * puder ser efetuado. Registra na conta atual o extrato das operacoes
     * realizadas.
     */
    public boolean sacar(double valorSaque) {
        if (valorSaque <= getSaldo()) {
            double novoSaldo = getSaldo() - valorSaque;
            setSaldo(novoSaldo);
            //registrando o extrato bancario
            setRegistrarExtrato(valorSaque, "saque");

            JOptionPane.showMessageDialog(null,
                    "Operação realizada com sucesso. "
                    + "\nNovo valor da conta: " + getSaldo());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Você não tem saldo "
                    + "suficiente para essa operação.");
            return false;
        }

    }

    /**
     *
     * Realiza o deposito na conta. Registra na conta atual o extrato das
     * operacoes realizadas.
     *
     * @param valorDeposito.
     *
     */
    public void depositar(double valorDeposito) {
        double novoSaldo = getSaldo() + valorDeposito;
        setSaldo(novoSaldo);

        //registrando o extrato bancario
        setRegistrarExtrato(valorDeposito, "depósito");

        JOptionPane.showMessageDialog(null, "Valor depositado com sucesso!");
    }

    /**
     *
     * @param valorTranferir
     * @param contaDestino
     * @return conta destino com o valor depositado. Atualiza a conta atual
     * descontando o valor transferido. Registra na conta atual o extrato das
     * operacoes realizadas.
     */
    public Conta transferir(double valorTranferir, Conta contaDestino) {
        if (sacar(valorTranferir)) {
            contaDestino.receberTransferencia(valorTranferir);
            //registrando o extrato bancario
            setRegistrarExtrato(valorTranferir, "transferência");
        }
        return contaDestino;
    }

    /**
     * Recebe a transferencia fazendo o registro no extrato bancario.
     *
     * @param valor
     *
     */
    public void receberTransferencia(double valor) {
        setSaldo(valor);
        //registrando o extrato bancario
        setRegistrarExtrato(valor, "transferência recebida");
    }

    /**
     *
     * Registra na conta atual o extrato das operacoes realizadas com a conta
     * como saque, deposito, transferencia.
     *
     * @param valor
     * @param operacao
     *
     */
    protected void setRegistrarExtrato(double valor, String operacao) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String extrato = String.format(
                "\n" + sdf.format(new Date()) + " - " + operacao
                + " - R$" + valor
                + " Saldo total da conta: R$ " + getSaldo());

        setExtratos(extrato);
    }

    /**
     *
     * @return todas as informacoes da conta.
     */
    @Override
    public String toString() {
        return "\n======================================================="
                + "\nTipo da conta: " + getTipoConta()
                + "\nAgência: " + getAgencia()
                + "\nID da Conta: " + getIdConta()
                + "\nNumero da Conta: " + getNumeroConta()
                + "\nSaldo: " + getSaldo()
                + "\n=======================================================";
    }
}
