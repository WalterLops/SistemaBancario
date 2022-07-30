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
public class ContaCorrente extends Conta {

    private double taxaManutencao;

    public ContaCorrente(int idConta, int agencia, int numeroConta, double saldo, String tipoConta) {
        super(idConta, agencia, numeroConta, saldo, tipoConta);
    }

	public double getTaxaManutencao() {
		return taxaManutencao;
	}

	public void setTaxaManutencao(double taxaManutencao) {
		this.taxaManutencao = taxaManutencao;
	}
        
    /**
     *
     * @return todas as informacoes da conta.
     */
    @Override
    public String toString() {
        return super.toString()+"\n==================================================================";
    }

}
