/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contas;

/**
 * Classe que herda da classe conta.
 * 
 * @author Walter
 */
public class ContaSalario extends Conta {

    private String  cnpjEmpresa;

    public ContaSalario(String  cnpjEmpresa, int idConta, int agencia, int numeroConta, double saldo, String tipoConta) {
        super(idConta, agencia, numeroConta, saldo, tipoConta);
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(String  cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }
    
    /**
     *
     * @return todas as informacoes da conta.
     */
    @Override
    public String toString() {
        return super.toString() + "\n cnpjEmpresa=" + cnpjEmpresa
                                +"\n==================================================================";
    }

    
}
