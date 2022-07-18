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
import java.util.ArrayList;
import java.util.List;
import jsonOperations.Escrita;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Funcionario;

import static jsonOperations.Escrita.ecreverAdmin;
import static jsonOperations.Escrita.ecreverFuncionario;

import views.LoginUI;

/**
 *
 * @author Walter
 */
public class Sistema {

    public static void main(String[] args) throws org.json.simple.parser.ParseException {

        List<Cliente> listaCliente = new ArrayList<>();
        List<Conta> listaConta = new ArrayList<>();
        List<Agencia> listaAgencias = new ArrayList<>();
        Funcionario[] listaFuncionarios = new Funcionario[25];
        Administrador[] administradores = new Administrador[8];

        // Cadastro da agência
        listaAgencias.add(new Agencia("Sede WWBanck", 709, "Belo Horizonte", "Av. Azul 249"));

        // Contas de Clientes
        Cliente c1 = new Cliente("C1020", "1234", "Pedro", "Rua R 255", "88888555");
        listaConta.add(new ContaPoupanca(1130, 709, 1000, 5850.98, "Conta Poupança"));
        c1.setIdConta(1130);
        listaCliente.add(c1);

        Cliente c2 = new Cliente("C1022", "1234", "Laura", "Rua F 258", "77888555");
        listaConta.add(new ContaPoupanca(1131, 709, 1000, 2500.48, "Conta Poupança"));
        c2.setIdConta(1131);
        listaCliente.add(c2);

        String baseClientes = "./src/baseDeDados/clientes.json";
        Escrita.ecreverCliente(listaCliente, baseClientes);

        // Contas de Funcionários
        Funcionario f1 = new Funcionario(null, null, "F1020", "1234", "Ana S", "Rua B", "9999855");
        listaConta.add(new ContaSalario(115548, 1126, 709, 11445, 4500, "Conta Salário"));
        f1.setIdConta(1126);
        listaFuncionarios[0] = f1;

        Funcionario f2 = new Funcionario(null, null, "F1022", "1234", "João C", "Rua B", "9974555");
        listaConta.add(new ContaCorrente(1127, 709, 5105, 4500.00, "Conta Corrente"));
        f2.setIdConta(1127);
        listaFuncionarios[1] = f2;

        String baseFuncionarios = "./src/baseDeDados/funcionarios.json";
        ecreverFuncionario(listaFuncionarios, baseFuncionarios);

        // Contas de Administradores
        Administrador a1 = new Administrador(null, null, "A1020", "1234", "Carla", "Rua B", "9997755");
        listaConta.add(new ContaCorrente(1128, 709, 5106, 4500.00, "Conta Corrente"));
        a1.setIdConta(1128);
        administradores[0] = a1;

        Administrador a2 = new Administrador(null, null, "A1022", "1234", "Lucas", "Rua K", "9988855");
        listaConta.add(new ContaCorrente(1129, 709, 517, 4500.00, "Conta Corrente"));
        a2.setIdConta(1128);
        administradores[1] = a2;

        String baseAdministradores = "./src/baseDeDados/administradores.json";
        ecreverAdmin(administradores, baseAdministradores);

        // Inicializando a tela de login
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUI().setVisible(true);
            }
        });

    }
}
