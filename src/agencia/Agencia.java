/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agencia;

/**
 *
 * @author Walter
 */
public class Agencia {
    private String nome;
    private int codigo;
    private String cidade;
    private String endereco;
    private double montanteTotal;
    
    public Agencia(String nome, int codigo, String cidade, String endereco) {
        this.nome = nome;
        this.codigo = codigo;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getMontanteTotal() {
        return montanteTotal;
    }
    
    public void setMontanteTotal(double montanteTotal) {
        this.montanteTotal += montanteTotal;
    }

    @Override
    public String toString() {
        return "\n======================================"
                + "\nNome: " + nome 
                + "\nCódigo: " + codigo 
                + "\nCidade: " + cidade 
                + "\nEndereço: " + endereco
                +"\n======================================";
    }
    
    
    
}
