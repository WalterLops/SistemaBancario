/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema;


import agencia.Agencia;
import contas.Conta;

import contas.ContaPoupanca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Funcionario;

import static jsonOperations.Escrita.ecreverAdmin;
import static jsonOperations.Escrita.ecreverFuncionario;
import static jsonOperations.Leitura.carregarAdministradores;
import static jsonOperations.Leitura.carregarFuncionarios;

/**
 *
 * @author Walter
 */
public class Sistema {

    public static void main(String[] args) throws org.json.simple.parser.ParseException {

        
        Login login = new Login();
        List<Cliente> lsitaCliente = new ArrayList<>();
        List<Conta> listaConta = new ArrayList<>();
        List<Agencia> listaAgencias = new ArrayList<>();
        Funcionario[] listaFuncionarios = new Funcionario[3]; //[25];
        //Administrador[] administradores = new Administrador[5];
        
        

        /*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Administrador adm = new Administrador(null, null, 1010, "123", "João", "Rua A", "991234567");
        //(Date dataAdmissao, Date dataDemissao, int id, int senha, String nome, String endereco, String telefone)
        ContaCorrente crAdmin = new ContaCorrente(1145, 501, 9876, 5000, "Conta corrente");
        //(int idConta, int agencia, int numeroConta, double saldo, String tipoConta)
        adm.setIdConta(1145);
        cliente.add(adm);
        conta.add(crAdmin);*/
        Funcionario f1 = new Funcionario(null, null, "1020", "1234", "Ana", "Rua B", "9999855");
        //Conta crFunc = new ContaSalario(115548, 1126, 502, 11445, 4500, "Conta Salário");
        f1.setIdConta(1126);
        listaFuncionarios[0] = f1;
        //conta.add(crFunc);

        Funcionario f2 = new Funcionario(null, null, "1021", "1234", "Maria C", "Rua B", "9999855");
        f2.setIdConta(1127);
        listaFuncionarios[1] = f2;

        Funcionario f3 = new Funcionario(null, null, "1022", "1234", "João", "Rua B", "9999855");
        f3.setIdConta(1128);
        listaFuncionarios[2] = f3;

        String baseFuncionarios = "./src/baseDeDados/funcionarios.json";
        ecreverFuncionario(listaFuncionarios, baseFuncionarios);

        for (Funcionario f : carregarFuncionarios(3, baseFuncionarios)) {
            System.out.println(f);
        }

        Administrador[] administradores = new Administrador[2];
        Administrador a1 = new Administrador(null, null, "1020", "1234", "Carla", "Rua B", "9999855");
        a1.setIdConta(1126);
        administradores[0] = a1;

        Administrador a2 = new Administrador(null, null, "1021", "1234", "Leticia", "Rua B", "9999855");
        a2.setIdConta(1127);
        administradores[1] = a2;

        Cliente cli = new Cliente("05", "455", "Cliente Gabriela", "Rua R 255", "77888555");
        cli.setIdConta(455);
        lsitaCliente.add(cli);
        listaConta.add(new ContaPoupanca(455, 309, 1000, 5850.98, "Conta Corrente"));
        listaConta.add(new ContaPoupanca(500, 309, 1000, 100.00, "Conta Poupança"));

        String baseAdministradores = "./src/baseDeDados/administradores.json";
        ecreverAdmin(administradores, baseAdministradores);
        System.out.println("\n====================");
        for (Administrador a : carregarAdministradores(2, baseAdministradores)) {
            System.out.println(a);
        }

        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (option != 4) {

            Cliente a = login.Logar(lsitaCliente, listaFuncionarios, administradores);
            System.out.println("\n---------------------------------------------\n");
            System.out.println("Logado como: " + a.getNome());
            System.out.println("\n---------------------------------------------\n");

            if (a instanceof Cliente) {
                System.out.println("Digite o número de uma operação: "
                        + "\n 1 - Sacar"
                        + "\n 2 - Depositar"
                        + "\n 3 - Transferir"
                        + "\n 4 - Sair");
                int operation = sc.nextInt();
                int idconta;
                double valor;
                switch (operation) {
                    
                    case 1:
                        System.out.println("\nSuas contas associadas: ");
                        for (Integer contas : a.getsetIdConta()) {
                            System.out.println(contas);
                        }
                        System.out.print("Selecione uma conta: ");
                        idconta = sc.nextInt();
                        System.out.println("Digite o valor do saque: ");
                        valor = sc.nextDouble();
                        for (Conta cont : listaConta) {
                            if (idconta == cont.getIdConta()) {
                                cont.sacar(valor);
                                System.out.println("\nEstado atual da conta:");
                                System.out.println(cont);
                            }
                        }
                        break;
                        
                        case 2:
                        System.out.println("\nSuas contas associadas: ");
                        for (Integer contas : a.getsetIdConta()) {
                            System.out.println(contas);
                        }
                        System.out.print("Selecione uma conta: ");
                        idconta = sc.nextInt();
                        System.out.println("Digite o valor do Depósito: ");
                        valor = sc.nextDouble();
                        for (Conta cont : listaConta) {
                            if (idconta == cont.getIdConta()) {
                                cont.sacar(valor);
                                System.out.println("\nEstado atual da conta:");
                                System.out.println(cont);
                            }
                        }
                        break;
                        
                    case 3:
                        System.out.println("\nSuas contas associadas: ");
                        for (Integer contas : a.getsetIdConta()) {
                            System.out.println(contas);
                        }
                        System.out.print("Selecione uma conta: ");
                        idconta = sc.nextInt();

                        for (Conta cont : listaConta) {
                            if (idconta == cont.getIdConta()) {
                                System.out.print("Digite o id da conta destino: ");
                                int id = sc.nextInt();
                                
                                System.out.print("Digite o valor a transferir: ");
                                valor = sc.nextDouble();
                                for (Conta cont1 : listaConta) {
                                    if (idconta == cont.getIdConta()) {
                                        cont.transferir(valor, cont1);
                                    }
                                }
                                System.out.println("\nEstado atual da conta:");
                                System.out.println(cont);
                                for (Conta result : listaConta) {
                                    if (id == result.getIdConta()) {
                                        System.out.println("\nEstado atual da conta destino:");
                                        System.out.println(result);
                                    }
                                }
                            }
                        }
                        break;
                    case 4:
                        option = operation;
                        break;

                    default:
                        throw new AssertionError();
                }
            }

            for (Integer idconta : a.getsetIdConta()) {

            }

        }

    }
}
