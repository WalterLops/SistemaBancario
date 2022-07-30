/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema;

import agencia.Agencia;
import contas.Conta;
import contas.ContaCorrente;

import contas.ContaPoupanca;
import contas.ContaSalario;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import jsonOperations.Escrita;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Funcionario;

import static jsonOperations.Escrita.escreverAdmin;
import static jsonOperations.Escrita.escreverCliente;
import static jsonOperations.Escrita.escreverContas;
import static jsonOperations.Escrita.escreverFuncionario;
import jsonOperations.Leitura;
import views.LoginUI;
import views.SplashUI;

/**
 * Classe responsavel por controlar as chamdas iniciais das classes do aplicativo.
 * 
 * @author Walter
 */
public class Sistema {

    public static void main(String[] args) throws org.json.simple.parser.ParseException, ParseException {

            List<Cliente> listaCliente = new ArrayList<>();
            List<Conta> listaConta = new ArrayList<>();
            List<Agencia> listaAgencias = new ArrayList<>();
            Funcionario[] listaFuncionarios = new Funcionario[25];
            Administrador[] administradores = new Administrador[8];
            
            
            // Cadastro da agência
            listaAgencias.add(new Agencia("Sede WWBank", 709, "Belo Horizonte", "Av. Azul 249"));
            
            listaAgencias.add(new Agencia("WWBank 009", 809, "Campinas", "Av. Bonina 754"));
            
            listaAgencias.add(new Agencia("WWBank 009", 909, "Porto Alegre", "Av. Lilaz 568"));
            
            // Contas de Clientes
            Cliente c1 = new Cliente("C1020", "1234", "Pedro", "Rua R 255", "88888555");
            listaConta.add(new ContaPoupanca(1130, 709, 1000, 5850.98, "Conta Poupança"));
            c1.setIdConta(1130);
            c1.setIdConta(1158);
            c1.setIdConta(1172);
            c1.setIdConta(1184);
            listaCliente.add(c1);
            
            Cliente c2 = new Cliente("C1022", "1234", "Laura", "Rua F 258", "77888555");
            listaConta.add(new ContaPoupanca(1131, 709, 1000, 2500.48, "Conta Poupança"));
            c2.setIdConta(1131);
            listaCliente.add(c2);
            
            // Contas de Funcionários
            Funcionario f1 = new Funcionario(null, null, "F1020", "1234", "Ana S", "Rua B", "9999855");
            listaConta.add(new ContaSalario("115548", 1126, 709, 11445, 4500, "Conta Salário"));
            f1.setIdConta(1126);
            listaFuncionarios[0] = f1;
            
            Funcionario f2 = new Funcionario(null, null, "F1022", "1234", "João C", "Rua B", "9974555");
            listaConta.add(new ContaCorrente(1127, 709, 5105, 4500.00, "Conta Corrente"));
            f2.setIdConta(1127);
            listaFuncionarios[1] = f2;
            
            // Contas de Administradores
            Administrador a1 = new Administrador(null, null, "A1020", "1234", "Carla", "Rua B", "9997755");
            listaConta.add(new ContaCorrente(1128, 709, 5106, 4500.00, "Conta Corrente"));
            a1.setIdConta(1128);
            administradores[0] = a1;
            
            Administrador a2 = new Administrador(null, null, "A1022", "1234", "Lucas", "Rua K", "9988855");
            listaConta.add(new ContaCorrente(1129, 709, 517, 4500.00, "Conta Corrente"));
            a2.setIdConta(1129);
            administradores[1] = a2;
            
            String baseClientes = "./src/baseDeDados/clientes.json";
            if (!Leitura.arquivoExiste(baseClientes)) {
            escreverCliente(listaCliente, baseClientes);
            }
            
            String baseFuncionarios = "./src/baseDeDados/funcionarios.json";
            if (!Leitura.arquivoExiste(baseFuncionarios)) {
            escreverFuncionario(listaFuncionarios, baseFuncionarios);
            }
            
            String baseAdministradores = "./src/baseDeDados/administradores.json";
            if (!Leitura.arquivoExiste(baseAdministradores)) {
            escreverAdmin(administradores, baseAdministradores);
            }
            
            String baseContas = "./src/baseDeDados/listaContas.json";
            if (!Leitura.arquivoExiste(baseContas)) {
            escreverContas(listaConta, baseContas);
            }
            
            String baseAgencias = "./src/baseDeDados/listaAgencias.json";
            if (!Leitura.arquivoExiste(baseAgencias)) {
            Escrita.escreverAgencia(listaAgencias, listaConta, baseAgencias);
            }
            
            // Tela SplashUI
            SplashUI spl = new SplashUI();
            spl.setVisible(true);
            spl.eventoCarregando();
            spl.dispose();
            
            // Inicializando a tela de login
            LoginUI show = new LoginUI();
            show.setBaseClientes(baseClientes);
            show.setBaseFuncionarios(baseFuncionarios);
            show.setBaseAdministradores(baseAdministradores);
            show.setBaseAgencias(baseAgencias);
            show.setBaseContas(baseContas);
            show.setVisible(true);
        
    }
    /**
     * Metodo que obtem o numero de clientes instanciados a 
     * partir de um atributo de classe privado em cliente.
     * 
     * @return numero de instancias de cliente
     */
    public static int nInstanciasClienteP(){
        return Cliente.getInstanciasP();
    }
    
    /**
     * Metodo que obtem o numero de clientes instanciados a 
     * partir de um atributo de classe protegido em cliente.
     * 
     * @return numero de instancias de cliente
     */
    public static int nInstanciasClienteS(){
        return Cliente.getInstanciasS();
    }
}
