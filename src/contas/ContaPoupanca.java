/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contas;

import javax.swing.JOptionPane;

/**
 * Classe que herda da classe conta.
 * 
 * @author Walter
 */
public class ContaPoupanca extends Conta {

    private double limiteSaque;

    public ContaPoupanca(int idConta, int agencia, int numeroConta, double saldo, String tipoConta) {
        super(idConta, agencia, numeroConta, saldo, tipoConta);
    }

    public double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }
    
    /**
     *
     * @param valorSaque
     * @return true se o saque foi realizado com sucesso ou false se o saque não
     * puder ser efetuado. Registra na conta atual o extrato das operacoes
     * realizadas.
     */
    @Override
    public boolean sacar(double valorSaque) {
        if (valorSaque <= getSaldo() && limiteSaque <= valorSaque) {
            double novoSaldo = getSaldo() - valorSaque;
            setSaldo(novoSaldo);
            JOptionPane.showMessageDialog(null, """
                                                Operação realizada com sucesso. 
                                                Novo valor da conta: """ + getSaldo());
            
            setRegistrarExtrato(valorSaque, "saque");
            
            return true;
        } else if (limiteSaque > valorSaque) {
            JOptionPane.showMessageDialog(null, "Limite de saque insuficiente para essa operação.");
            return false;
        } else if (getSaldo() < valorSaque) {
            JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente para essa operação.");
            return false;
        }
        return false;
    }

    /**
     *
     * @return todas as informacoes da conta.
     */
    @Override
    public String toString() {
        return super.toString() + "\nlimiteSaque: " + limiteSaque
                + "\n==================================================================";
    }

}
