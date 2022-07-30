/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsonOperations;

import agencia.Agencia;
import com.google.gson.Gson;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import contas.ContaSalario;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Funcionario;

/**
 * Classe reponsavel por fazer a escrita em arquivo JSON dos objetos dos tipos
 * de usuarios: Cliente, Funcionario, Administrador.
 * De Conta: ContaCorrente, ContaPoupanca, ContaSalario.
 * 
 * @author Walter
 */
public class Escrita {

    private static JSONArray array = new JSONArray();
    
    /**
     * Metodo resposavel por ler todo arquivo JSON existente na memoria e o 
     * transformar em um objeto do tipo JSONArray declarado globalmente 
     * nessa classe. Recebe o caminho completo para leitura do arquivo.
     * 
     * @param caminho 
     */
    private static void escreverJSON(String caminho) {

        try ( FileWriter file = new FileWriter(caminho)) {
            file.write(array.toJSONString());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro desconhecido!");
        } finally {
            array = new JSONArray();
            System.gc();
        }
    }

    /**
     * Metodo responsavel por escrever no arquivo JSON a lista de objetos 
     * recebida. O parametro <code>caminho</code> e onde deve ser passado o caminho completo
     * juntamente com o nome do arquivo a ser escrito. O parametro <code>clientes</code> e a 
     * lista que sera escrita no arquivo.
     * 
     * @param clientes
     * @param caminho 
     */
    public static void escreverCliente(List<Cliente> clientes, String caminho) {
       
        Collections.sort(clientes);
            
        for (Cliente f : clientes) {
            if (f != null) {
                array.add(new Gson().toJson(f));
            }
        }
        escreverJSON(caminho);
    }

    /**
     * Metodo responsavel por escrever no arquivo JSON a lista de objetos 
     * recebida. O parametro <code>caminho</code> e onde deve ser passado o caminho completo
     * juntamente com o nome do arquivo a ser escrito. O parametro <code>funcionarios</code> e a 
     * lista que sera escrita no arquivo.
     * 
     * @param funcionarios
     * @param caminho 
     */
    public static void escreverFuncionario(Funcionario funcionarios[], String caminho) {
        for (Funcionario f : funcionarios) {
            if (f != null) {
                array.add(new Gson().toJson(f));
            }
        }
        escreverJSON(caminho);
    }

    /**
     * Metodo responsavel por escrever no arquivo JSON a lista de objetos 
     * recebida. O parametro <code>caminho</code> e onde deve ser passado o caminho completo
     * juntamente com o nome do arquivo a ser escrito. O parametro <code>administradores</code> e a 
     * lista que sera escrita no arquivo.
     * 
     * @param administradores
     * @param caminho 
     */
    public static void escreverAdmin(Administrador administradores[], String caminho) {

        for (Administrador f : administradores) {
            if (f != null) {
                array.add(new Gson().toJson(f));
            }
        }
        escreverJSON(caminho);
    }

    /**
     * Metodo responsavel por escrever no arquivo JSON a lista de objetos 
     * recebida. O parametro <code>caminho</code> e onde deve ser passado o caminho completo
     * juntamente com o nome do arquivo a ser escrito. O parametro <code>listaContas</code> e a 
     * lista que sera escrita no arquivo.
     * 
     * @param listaContas
     * @param caminho 
     */
    public static void escreverContas(List<Conta> listaContas, String caminho) {

        for (Conta f : listaContas) {
            if (f != null) {
                
                if (f instanceof ContaPoupanca contaPoupanca) {
                    //double limiteSaque;
                    array.add(new Gson().toJson(f));
                }
                if (f instanceof ContaCorrente contaCorrente) {
                    //double taxaManutencao;
                    array.add(new Gson().toJson(f));
                }
                if (f instanceof ContaSalario contaSalario) {
                    //int cnpjEmpresa;
                    array.add(new Gson().toJson(f));
                }
            }
        }
        System.gc();
        escreverJSON(caminho);
    }

    /**
     * Metodo responsavel por escrever no arquivo JSON a lista de objetos 
     * recebida. O parametro <code>caminho</code> e onde deve ser passado o caminho completo
     * juntamente com o nome do arquivo a ser escrito. O parametro <code>listaAgencias</code> e a 
     * lista que sera escrita no arquivo.
     * 
     * @param listaAgencias
     * @param listaContas
     * @return 
     */
    private static List<Agencia> atualizarMontante(List<Agencia> listaAgencias, List<Conta> listaContas) {
        for (Agencia a : listaAgencias) {
            for (Conta c : listaContas) {
                if (c.getAgencia() == a.getCodigo()) {
                    a.setMontanteTotal(c.getSaldo());
                }
            }
        }
        return listaAgencias;
    }

    /**
     * 
     * Metodo responsavel por escrever no arquivo JSON a lista de objetos 
     * recebida. O parametro <code>caminho</code> e onde deve ser passado o caminho completo
     * juntamente com o nome do arquivo a ser escrito. 
     * O parametro <code>listaAgencias</code> e a lista que sera escrita no arquivo.
     * O parametro <code>listaContas</code> e para que seja feito a leitura 
     * das contas cadastradas e atualizacao do montante da agencia atual.
     * 
     * @param listaAgencias
     * @param listaContas
     * @param caminho 
     */
    public static void escreverAgencia(List<Agencia> listaAgencias, List<Conta> listaContas, String caminho) {
         
        Collections.sort(listaAgencias);
         
        listaAgencias = atualizarMontante(listaAgencias, listaContas);
        for (Agencia f: listaAgencias) {
            if (f != null) {
                array.add(new Gson().toJson(f));
            }
        }
        System.gc();
        escreverJSON(caminho);
    }

}
