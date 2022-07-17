/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contas;

/**
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

    @Override
    public String toString() {
        return super.toString() + "\nlimiteSaque=" + limiteSaque
                                +"\n==================================================================";
    }
    
    
}
