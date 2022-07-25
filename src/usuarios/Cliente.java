/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Walter
 */
public class Cliente {
   
    private String id; 
    private String senha; 
    private String nome;
    private String endereco;
    private String telefone;
    private final List<Integer> contasAssociadas = new ArrayList<>();
    private List<String> extratos = new ArrayList<>();
    private static int instanciasP;
    protected static int instanciasS;

    public Cliente(String id, String senha, String nome, String endereco, String telefone) {
        this.id = id;
        this.senha = senha;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        instanciasP += 1;
        instanciasS += 1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Integer> getsetIdConta() {
        return contasAssociadas;
    }

    public void setIdConta(Integer contasAssociadas) {
        this.contasAssociadas.add(contasAssociadas);
    }

    public List<String> getExtratos() {
        return extratos;
    }

    public void setExtratos(String extratos) {
        this.extratos.add(extratos);
    }

    public static int getInstanciasP() {
        return instanciasP;
    }

    public static void setInstanciasP(int instanciasP) {
        Cliente.instanciasP = instanciasP;
    }

    public static int getInstanciasS() {
        return instanciasS;
    }

    public static void setInstanciasS(int instanciasS) {
        Cliente.instanciasS = instanciasS;
    }
    
    public boolean setRemoverIdConta(int id){
        for (Integer c : contasAssociadas){
            if (c == id){
                contasAssociadas.remove(c);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "\n===============================================\n"
             + "ID: " + id
             + "\nNome: " + nome
             + "\nSenha: " + senha 
             + "\nEndereco: " + endereco
             + "\nTelefone: " + telefone
             + "\nContasAssociadas: " + contasAssociadas
             +"\n===============================================\n";
    }
    
    
    
}
