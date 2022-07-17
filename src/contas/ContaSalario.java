/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contas;

/**
 *
 * @author Walter
 */
public class ContaSalario extends Conta {

    private int cnpjEmpresa;

    public ContaSalario(int cnpjEmpresa, int idConta, int agencia, int numeroConta, double saldo, String tipoConta) {
        super(idConta, agencia, numeroConta, saldo, tipoConta);
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public int getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(int cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    @Override
    public String toString() {
        return super.toString() + "\n cnpjEmpresa=" + cnpjEmpresa
                                +"\n==================================================================";
    }

    
}
