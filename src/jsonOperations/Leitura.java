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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

/**
 *
 * @author Walter
 */
public class Leitura {

    private static final JSONParser parser = new JSONParser();
    private static String jsonString;
    private static JSONObject obj;
    private static JSONArray array = new JSONArray();
    private static JSONArray arrayContas = new JSONArray();
    private static String vetorJsonContas;
    private static JSONArray arrayExtratos = new JSONArray();
    private static String vetorJsonExtratos;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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

    public static List<Cliente> lerClientes(String caminho) {

        lerJSON(caminho);

        List<Cliente> listaCliente = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {

            try {
                jsonString = array.get(i).toString();
                obj = (JSONObject) parser.parse(jsonString);

                Cliente novoCliente = new Cliente((String) obj.get("ID"), (String) obj.get("senha"), (String) obj.get("nome"), (String) obj.get("endereco"), (String) obj.get("telefone"));

                vetorJsonContas = obj.get("ContasAssociadas").toString();
                arrayContas = (JSONArray) parser.parse(vetorJsonContas);
                for (int h = 0; h < arrayContas.size(); h++) {
                    novoCliente.setIdConta(Integer.parseInt(arrayContas.get(h).toString()));
                }
                
                vetorJsonExtratos = obj.get("extratos").toString();
                arrayExtratos = (JSONArray) parser.parse(vetorJsonExtratos);
                for (int h = 0; h < arrayExtratos.size(); h++) {
                    novoCliente.setExtratos(arrayExtratos.get(h).toString());
                }
                
                listaCliente.add(novoCliente);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao converter os dados do cliente!");
            }
        }
        return listaCliente;
    }

    public static Funcionario[] lerFuncionarios(String caminho) {

        lerJSON(caminho);

        Funcionario funcionarios[] = new Funcionario[array.size()];
        for (int i = 0; i < array.size(); i++) {
            try {
                jsonString = array.get(i).toString();
                obj = (JSONObject) parser.parse(jsonString);

                Date dataAdmissao = null;
                Date dataDemissao = null;
                if (!obj.get("dataAdmissao").equals("null")) {
                    dataAdmissao = sdf.parse(obj.get("dataAdmissao").toString());
                }
                if (!obj.get("dataDemissao").equals("null")) {
                    dataDemissao = sdf.parse(obj.get("dataDemissao").toString());
                }
                String id = obj.get("ID").toString();
                String senha = obj.get("senha").toString();
                String nome = obj.get("nome").toString();
                String endereco = obj.get("endereco").toString();
                String telefone = obj.get("telefone").toString();

                Funcionario f = new Funcionario(dataAdmissao, dataDemissao, id, senha, nome, endereco, telefone);
                
                vetorJsonExtratos = obj.get("extratos").toString();
                arrayExtratos = (JSONArray) parser.parse(vetorJsonExtratos);
                for (int h = 0; h < arrayExtratos.size(); h++) {
                    f.setExtratos(arrayExtratos.get(h).toString());
                }
                
                funcionarios[i] = f;

                int n = arrayContas.size();
                vetorJsonContas = obj.get("ContasAssociadas").toString();
                arrayContas = (JSONArray) parser.parse(vetorJsonContas);
                for (int h = 0; h < n; h++) {
                    funcionarios[i].setIdConta(Integer.parseInt(arrayContas.get(h).toString()));
                }
            } catch (java.text.ParseException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao ler as datas");
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao converter os dados!");
            }
        }
        return funcionarios;
    }

    public static Administrador[] lerAdministradores(String caminho){

        lerJSON(caminho);

        Administrador administrador[] = new Administrador[array.size()];
        for (int i = 0; i < array.size(); i++) {

            try {
                jsonString = array.get(i).toString();
                obj = (JSONObject) parser.parse(jsonString);

                Date dataAdmissao = null;
                Date dataDemissao = null;
                if (!obj.get("dataAdmissao").equals("null")) {
                    dataAdmissao = sdf.parse(obj.get("dataAdmissao").toString());
                }
                if (!obj.get("dataDemissao").equals("null")) {
                    dataDemissao = sdf.parse(obj.get("dataDemissao").toString());
                }

                administrador[i] = new Administrador(dataAdmissao, dataDemissao,
                        (String) obj.get("ID"), (String) obj.get("senha"),
                        (String) obj.get("nome"), (String) obj.get("endereco"),
                        (String) obj.get("telefone"));
                
                vetorJsonExtratos = obj.get("extratos").toString();
                arrayExtratos = (JSONArray) parser.parse(vetorJsonExtratos);
                for (int h = 0; h < arrayExtratos.size(); h++) {
                    administrador[i].setExtratos(arrayExtratos.get(h).toString());
                }
                
                vetorJsonContas = obj.get("ContasAssociadas").toString();
                arrayContas = (JSONArray) parser.parse(vetorJsonContas);
                for (int h = 0; h < arrayContas.size(); h++) {
                    administrador[i].setIdConta(Integer.parseInt(arrayContas.get(h).toString()));
                }
            } catch (java.text.ParseException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao converter os dados!");
            }
        }
        return administrador;
    }

    public static List<Conta> lerContas(String caminho){

        lerJSON(caminho);
        List<Conta> listaContas = new LinkedList<>();
        for (int i = 0; i < array.size(); i++) {

            try {
                jsonString = array.get(i).toString();
                obj = (JSONObject) parser.parse(jsonString);
                
                int idConta = Integer.parseInt(obj.get("idConta").toString());
                int agencia = Integer.parseInt(obj.get("agencia").toString());
                int numeroConta = Integer.parseInt(obj.get("numeroConta").toString());
                double saldo = Double.parseDouble(obj.get("saldo").toString());
                String tipoConta = (String) obj.get("tipoConta");
                
                if (obj.get("tipoConta").equals("Conta Poupança")) {
                    double limiteSaque = Double.parseDouble(obj.get("limiteSaque").toString());
                    ContaPoupanca conta = new ContaPoupanca(idConta, agencia, numeroConta, saldo, tipoConta);
                    conta.setLimiteSaque(limiteSaque);
                    listaContas.add(conta);
                }
                if (obj.get("tipoConta").equals("Conta Corrente")) {
                    double taxaManutencao = Double.parseDouble(obj.get("taxaManutencao").toString());
                    ContaCorrente conta = new ContaCorrente(idConta, agencia, numeroConta, saldo, tipoConta);
                    conta.setTaxaManutencao(taxaManutencao);
                    listaContas.add(conta);
                }
                if (obj.get("tipoConta").equals("Conta Salário")) {
                    String cnpjEmpresa = obj.get("cnpjEmpresa").toString();
                    ContaSalario conta = new ContaSalario(cnpjEmpresa, idConta, agencia, numeroConta, saldo, tipoConta);
                    conta.setCnpjEmpresa(cnpjEmpresa);
                    listaContas.add(conta);
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao converter os dados!");
            }
        }
        return listaContas;
    }

    public static List<Agencia> lerAgencias(String caminho) {

        lerJSON(caminho);

        List<Agencia> agencia = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {

            try {
                jsonString = array.get(i).toString();
                obj = (JSONObject) parser.parse(jsonString);
                
                Agencia novaAgencia = new Agencia((String) obj.get("nome"), Integer.parseInt(obj.get("codigo").toString()), (String) obj.get("cidade"), (String) obj.get("endereco"));
                agencia.add(novaAgencia);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao converter os dados!");
            }
        }
        return agencia;
    }

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
