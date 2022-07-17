/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsonOperations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Funcionario;

/**
 *
 * @author Walter
 */
public class Leitura {
    
    private static JSONParser parser = new JSONParser();
    private static String jsonString;
    private static JSONObject obj;
    private static JSONArray array = new JSONArray();
    private static JSONArray arrayContas = new JSONArray();
    private static String v;

    public static Funcionario[] carregarFuncionarios(int tamanho, String caminho) throws org.json.simple.parser.ParseException {
        Funcionario funcionarios[] = new Funcionario[tamanho];

        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            FileReader a = new FileReader(caminho);
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            array = (JSONArray) parser.parse(a);
            a.close();
            
        } //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    for (int i = 0; i< tamanho; i++) {

        jsonString = array.get(i).toString();
        obj = (JSONObject) parser.parse(jsonString);

        funcionarios[i] = new Funcionario(null, null, (String) obj.get("ID"), (String) obj.get("senha"), (String) obj.get("nome"), (String) obj.get("endereco"), (String) obj.get("telefone"));
        
        int n = Integer.parseInt(obj.get("nContas").toString());
        v = obj.get("ContasAssociadas").toString();
        arrayContas = (JSONArray) parser.parse(v);
        for (int h=0; h<n; h++){
        funcionarios[i].setIdConta(Integer.parseInt(arrayContas.get(h).toString()));
        }
    }
    return funcionarios ;
}
    
    
    public static Administrador[] carregarAdministradores (int tamanho, String caminho) throws org.json.simple.parser.ParseException {
        Administrador administrador[] = new Administrador[tamanho];

        try {
            FileReader a = new FileReader(caminho);
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            array = (JSONArray) parser.parse(a);
            a.close();
            
        } //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    for (int i = 0; i< tamanho; i++) {

        jsonString = array.get(i).toString();
        obj = (JSONObject) parser.parse(jsonString);

        administrador[i] = new Administrador(null, null, (String) obj.get("ID"), (String) obj.get("senha"), (String) obj.get("nome"), (String) obj.get("endereco"), (String) obj.get("telefone"));
        
        int n = Integer.parseInt(obj.get("nContas").toString());
        v = obj.get("ContasAssociadas").toString();
        arrayContas = (JSONArray) parser.parse(v);
        for (int h=0; h<n; h++){
        administrador[i].setIdConta(Integer.parseInt(arrayContas.get(h).toString()));
        }
    }
    return administrador ;
}
    
    
    public static List<Cliente> carregarClientes (int tamanho, String caminho) throws org.json.simple.parser.ParseException {
        List<Cliente> cliente= new ArrayList<>();

        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            FileReader a = new FileReader(caminho);
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            array = (JSONArray) parser.parse(a);
            a.close();
            
        } //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    for (int i = 0; i< tamanho; i++) {

        jsonString = array.get(i).toString();
        obj = (JSONObject) parser.parse(jsonString);
        
        Cliente novoCliente = new Cliente((String) obj.get("ID"), (String) obj.get("senha"), (String) obj.get("nome"), (String) obj.get("endereco"), (String) obj.get("telefone"));

        int n = Integer.parseInt(obj.get("nContas").toString());
        v = obj.get("ContasAssociadas").toString();
        arrayContas = (JSONArray) parser.parse(v);
        for (int h=0; h<n; h++){
        novoCliente.setIdConta(Integer.parseInt(arrayContas.get(h).toString()));
        }
        
        cliente.add(novoCliente);
    }
    return cliente;
}

}
