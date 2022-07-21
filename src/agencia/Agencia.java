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
    private static String nome;
    private static int codigo;
    private static String cidade;
    private static String endereco;
    private static double montanteTotal;
    
    public Agencia(String nome, int codigo, String cidade, String endereco) {
        Agencia.nome = nome;
        Agencia.codigo = codigo;
        Agencia.cidade = cidade;
        Agencia.endereco = endereco;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Agencia.nome = nome;
    }

    public static int getCodigo() {
        return codigo;
    }

    public static void setCodigo(int codigo) {
        Agencia.codigo = codigo;
    }

    public static String getCidade() {
        return cidade;
    }

    public static void setCidade(String cidade) {
        Agencia.cidade = cidade;
    }

    public static String getEndereco() {
        return endereco;
    }

    public static void setEndereco(String endereco) {
        Agencia.endereco = endereco;
    }

    public static double getMontanteTotal() {
        return montanteTotal;
    }

    public static void setMontanteTotal(double montanteTotal) {
        Agencia.montanteTotal += montanteTotal;
    }
    
}
