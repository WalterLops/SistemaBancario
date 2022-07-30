/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsonOperations;

import agencia.Agencia;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import contas.ContaSalario;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Funcionario;
import com.google.gson.Gson;

/**
 * Classe responsavel por fazer a conversao de um arquivo JSON em lista 
 * de objetos do tipo de leitura solicitado.
 * 
 * @author Walter
 */
public class Leitura {

    private static final JSONParser parser = new JSONParser();
    private static String jsonString;
    private static JSONObject obj;
    private static JSONArray array = new JSONArray();
    
    /**
     * Metodo responsavel por ler o aquivo JSON que esta no endereco passado.
     * Se ocorrer qualquer erro esse metodo ja faz o tratamento.
     * O arquivo lido no formato FileReader e convertido em JSONArray.
     * 
     * @param caminho 
     */
    private static void lerJSON(String caminho) {

        try ( FileReader arquivoJSON = new FileReader(caminho)) {
            try {
                
                array = (JSONArray) parser.parse(arquivoJSON);

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao analisar a base de dados!");
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo JSON não encontrado!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro desconhecido!");
        }
    }
    
    /**
     * Metodo responsavel por ler o aquivo passado para o parametro 
     * <code>caminho</code> e retorna uma lista ordenada de objetos do tipo 
     * <code>Cliente</code> .
     * 
     * @param caminho
     * @return List &lt; Cliente &gt;
     */
    public static List<Cliente> lerClientes(String caminho) {

        lerJSON(caminho);

        List<Cliente> listaCliente = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
                jsonString = array.get(i).toString();
                Cliente novoCliente = new Gson().fromJson(jsonString, Cliente.class);
                listaCliente.add(novoCliente);
        }
        
        Collections.sort(listaCliente);
        
        return listaCliente;
    }
    
    /**
     * Metodo responsavel por ler o aquivo passado para o parametro 
     * <code>caminho</code> e retorna uma lista de objetos do tipo 
     * <code>Funcionario</code> .
     * 
     * @param caminho
     * @return Funcionario[]
     */
    public static Funcionario[] lerFuncionarios(String caminho) {
        lerJSON(caminho);

        Funcionario funcionarios[] = new Funcionario[array.size()];
        for (int i = 0; i < array.size(); i++) {
                jsonString = array.get(i).toString();
                funcionarios[i] = new Gson().fromJson(jsonString, Funcionario.class);
        }
        return funcionarios;
    }
    
    /**
     * Metodo responsavel por ler o aquivo passado para o parametro 
     * <code>caminho</code> e retorna uma lista de objetos do tipo 
     * <code>Administrador</code> .
     * 
     * @param caminho
     * @return Administrador[]
     */
    public static Administrador[] lerAdministradores(String caminho){

        lerJSON(caminho);

        Administrador administrador[] = new Administrador[array.size()];
        for (int i = 0; i < array.size(); i++) {

            jsonString = array.get(i).toString();
            administrador[i] = new Gson().fromJson(jsonString, Administrador.class);
            
        }
        
        return administrador;
    }
    
    /**
     * Metodo responsavel por ler o aquivo passado para o parametro 
     * <code>caminho</code> e retorna uma lista de objetos do tipo 
     * <code>Conta</code> .
     * 
     * @param caminho
     * @return List &lt; Conta &gt;
     */
    public static List<Conta> lerContas(String caminho){

        lerJSON(caminho);
        List<Conta> listaContas = new LinkedList<>();
        for (int i = 0; i < array.size(); i++) {

            try {
                jsonString = array.get(i).toString();
                obj = (JSONObject) parser.parse(jsonString);
                
                if (obj.get("tipoConta").equals("Conta Poupança")) {
                    ContaPoupanca conta = new Gson().fromJson(jsonString, ContaPoupanca.class);
                    listaContas.add(conta);
                }
                if (obj.get("tipoConta").equals("Conta Corrente")) {
                    ContaCorrente conta = new Gson().fromJson(jsonString, ContaCorrente.class);
                    listaContas.add(conta);
                }
                if (obj.get("tipoConta").equals("Conta Salário")) {
                    ContaSalario conta = new Gson().fromJson(jsonString, ContaSalario.class);
                    listaContas.add(conta);
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao converter os dados!");
            }
        }
        return listaContas;
    }

    /**
     * Metodo responsavel por ler o aquivo passado para o parametro 
     * <code>caminho</code> e retorna uma lista ordenada de objetos do tipo 
     * <code>Agencia</code> .
     * 
     * @param caminho
     * @return List &lt; Agencia &gt;
     */
    public static List<Agencia> lerAgencias(String caminho) {

        lerJSON(caminho);

        List<Agencia> agencia = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
                jsonString = array.get(i).toString();
                Agencia novaAgencia = new Gson().fromJson(jsonString, Agencia.class);
                agencia.add(novaAgencia);
        }
        
        Collections.sort(agencia);
        
        return agencia;
    }
    
    /**
     * Metodo responsavel avaliar se o arquivo passado para o parametro 
     * <code>caminho</code> existe e retorna <code>true</code> se existir ou 
     * <code>false</code> caso contrario.
     * 
     * @param caminho
     * @return <code> true </code> ou <code> false </code> 
     */
    public static boolean arquivoExiste(String caminho) {
        try ( FileReader arquivoJSON = new FileReader(caminho)) {
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro desconhecido!");
        }
        return false;
    }
}
