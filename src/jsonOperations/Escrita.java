/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsonOperations;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
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

    public static void ecreverFuncionario(Funcionario funcionarios[], String caminho) {

        for (Funcionario f : funcionarios) {

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
        System.gc();
        try {
            FileWriter file = new FileWriter(caminho);
            file.write(array.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            array = new JSONArray();
            arrayContas = new JSONArray();
            jsonObject = new JSONObject();
            System.gc();
        }
    }

    public static void ecreverAdmin(Administrador administradores[], String caminho) {

        for (Administrador f : administradores) {

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
        System.gc();

        try {
            FileWriter file = new FileWriter(caminho);
            file.write(array.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            array = new JSONArray();
            arrayContas = new JSONArray();
            jsonObject = new JSONObject();
            System.gc();
        }
    }

    public static void ecreverCliente(List<Cliente> clientes, String caminho) {

        for (Cliente f : clientes) {

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
        System.gc();
        try {
            FileWriter file = new FileWriter(caminho);
            file.write(array.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            array = new JSONArray();
            arrayContas = new JSONArray();
            jsonObject = new JSONObject();
            System.gc();
        }
    }
}
