/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import contas.ContaSalario;
import interfaces_e_Login.InterfaceFuncionario;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Walter
 */
public class Funcionario extends Cliente implements InterfaceFuncionario {

    private Date dataAdmissao;
    private Date dataDemissao;
    public static int numeroFuncionarios;
    protected final Scanner sc = new Scanner(System.in);

    public Funcionario(Date dataAdmissao, Date dataDemissao, String id, String senha, String nome, String endereco, String telefone) {
        super(id, senha, nome, endereco, telefone);
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        Funcionario.numeroFuncionarios += 1;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    //----------Definição dos métodos do funcionário-----------
    @Override
    public void alterarSenhaAcesso(String senha) {
        setSenha(senha);
    }

    @Override
    public Conta adicionarConta() {
        System.out.println("""
                           Escolha o código do tipo de conta a ser cadastrada: 
                            \n 301 = Conta poupança
                            \n 305 = Conta Salário
                            \n 309 = Conta corrente""");
        int option = sc.nextInt();

        if (option != 301 && option != 301 && option != 301) {
            System.out.println("Código inválido");
            return null;
        }
        System.out.print("Digite o id da conta: ");
        int idConta = sc.nextInt();
        System.out.print("Digite o número da agência:");
        int agencia = sc.nextInt();
        System.out.print("Digite o número da Conta: ");
        int numeroConta = sc.nextInt();
        System.out.print("Digite o saldo inicial da conta: ");
        double saldo = sc.nextDouble();

        switch (option) {
            case 301 -> {
                return new ContaPoupanca(idConta, agencia, numeroConta, saldo, "Conta Poupança");
            }
            case 305 -> {
                System.out.print("Digite o CNPJ da empresa: ");
                int cnpjEmpresa = sc.nextInt();
                return new ContaSalario(cnpjEmpresa, idConta, agencia, numeroConta, saldo, "Conta Salário");
            }
            case 309 -> {
                return new ContaCorrente(idConta, agencia, numeroConta, saldo, "Conta Corrente");
            }
        }
        return null;
    }

    @Override
    public List<Conta> removerConta(int idConta, List<Conta> listaConta) {
        for (Conta conta : listaConta) {
            if (conta.getIdConta() == idConta) {
                listaConta.remove(conta);
            }
        }
        return listaConta;
    }

    @Override
    public void acessarInfoCliente(String idCliente, List<Cliente> listaCleinte) {
        for (Cliente cliente : listaCleinte) {
            if (idCliente == cliente.getId()) {
                System.out.println(cliente.toString());
            }
        }
    }

    @Override
    public List<Cliente> alterarCliente(String idCliente, List<Cliente> listaCliente) {
        for (Cliente cliente : listaCliente) {
            if (cliente.getId() == idCliente) {
                System.out.print("Digite o código da operação desejada: "
                        + "1 - alterar senha"
                        + "2 - alterar nome"
                        + "3 - alterar endereco"
                        + "4 - alterar telefone");
                int option = sc.nextInt();
                switch (option) {
                    case 1 -> {
                        System.out.print("Digite a nova senha: ");
                        cliente.setSenha(sc.next());
                    }
                    case 2 -> {
                        System.out.print("Digite o novo nome: ");
                        cliente.setNome(sc.nextLine());
                    }
                    case 3 -> {
                        System.out.print("Digite o novo endereco: ");
                        cliente.setEndereco(sc.nextLine());
                    }
                    case 4 -> {
                        System.out.print("Digite o novo telefone: ");
                        cliente.setEndereco(sc.next());
                    }
                    default ->
                        throw new AssertionError();
                }

            }
        }
        return listaCliente;
    }

}
