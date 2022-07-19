/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsonOperations;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import contas.ContaSalario;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Funcionario;

/**
 *
 * @author Walter
 */
public class Escrita {

    private static JSONArray array = new JSONArray();
    private static JSONArray arrayContas = new JSONArray();
    private static JSONObject jsonObject = new JSONObject();

    private static void escreverJSON(String caminho) {

        try ( FileWriter file = new FileWriter(caminho)) {
            file.write(array.toJSONString());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro desconhecido!");
        } finally {
            array = new JSONArray();
            arrayContas = new JSONArray();
            jsonObject = new JSONObject();
            System.gc();
        }
    }

    public static void escreverCliente(List<Cliente> clientes, String caminho) {

        for (Cliente f : clientes) {
            if (f != null) {
                jsonObject.put("ID", f.getId());
                jsonObject.put("senha", f.getSenha());
                jsonObject.put("nome", f.getNome());
                jsonObject.put("endereco", f.getEndereco());
                jsonObject.put("telefone", f.getTelefone());
                for (Integer i : f.getsetIdConta()) {
                    arrayContas.add(i);
                }
                jsonObject.put("nContas", f.getsetIdConta().size());
                jsonObject.put("ContasAssociadas", arrayContas);

                array.add(jsonObject);
                jsonObject = new JSONObject();
                arrayContas = new JSONArray();
                System.gc();
            }
        }
        System.gc();
        escreverJSON(caminho);
    }

    public static void escreverFuncionario(Funcionario funcionarios[], String caminho) {

        for (Funcionario f : funcionarios) {
            if (f != null) {
                jsonObject.put("ID", f.getId());
                jsonObject.put("senha", f.getSenha());
                jsonObject.put("nome", f.getNome());
                jsonObject.put("endereco", f.getEndereco());
                jsonObject.put("telefone", f.getTelefone());
                for (Integer i : f.getsetIdConta()) {
                    arrayContas.add(i);
                }
                jsonObject.put("nContas", f.getsetIdConta().size());
                jsonObject.put("ContasAssociadas", arrayContas);

                array.add(jsonObject);
                jsonObject = new JSONObject();
                arrayContas = new JSONArray();
                System.gc();
            }
        }
        System.gc();
        escreverJSON(caminho);
    }

    public static void escreverAdmin(Administrador administradores[], String caminho) {

        for (Administrador f : administradores) {
            if (f != null) {
                jsonObject.put("ID", f.getId());
                jsonObject.put("senha", f.getSenha());
                jsonObject.put("nome", f.getNome());
                jsonObject.put("endereco", f.getEndereco());
                jsonObject.put("telefone", f.getTelefone());
                for (Integer i : f.getsetIdConta()) {
                    arrayContas.add(i);
                }
                jsonObject.put("nContas", f.getsetIdConta().size());
                jsonObject.put("ContasAssociadas", arrayContas);

                array.add(jsonObject);
                jsonObject = new JSONObject();
                arrayContas = new JSONArray();
                System.gc();
            }
        }
        System.gc();
        escreverJSON(caminho);
    }

    public static void escreverContas(List<Conta> listaContas, String caminho) {

        for (Conta f : listaContas) {
            if (f != null) {
                jsonObject.put("idConta", f.getIdConta());
                jsonObject.put("agencia", f.getAgencia());
                jsonObject.put("numeroConta", f.getNumeroConta());
                jsonObject.put("saldo", f.getSaldo());
                jsonObject.put("tipoConta", f.getTipoConta());
                if (f instanceof ContaPoupanca contaPoupanca) {
                    //double limiteSaque;
                    jsonObject.put("limiteSaque", contaPoupanca.getLimiteSaque());
                }
                if (f instanceof ContaCorrente contaCorrente) {
                    //double taxaManutencao;
                    jsonObject.put("taxaManutencao", contaCorrente.getTaxaManutencao());
                }
                if (f instanceof ContaSalario contaSalario) {
                    //int cnpjEmpresa;
                    jsonObject.put("cnpjEmpresa", contaSalario.getCnpjEmpresa());
                }
                array.add(jsonObject);
                jsonObject = new JSONObject();
                arrayContas = new JSONArray();
                System.gc();
            }
        }
        System.gc();
        escreverJSON(caminho);
    }
}
