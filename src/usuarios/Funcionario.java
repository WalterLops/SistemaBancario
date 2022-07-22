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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Walter
 */
public class Funcionario extends Cliente implements InterfaceFuncionario {

    private Date dataAdmissao;
    private Date dataDemissao;
    public static int numeroFuncionarios;
    protected final Scanner sc = new Scanner(System.in);
    protected final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Funcionario(Date dataAdmissao, Date dataDemissao, String id, String senha, String nome, String endereco, String telefone) {
        super(id, senha, nome, endereco, telefone);
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        Funcionario.numeroFuncionarios += 1;
    }

    public String getDataAdmissao() {
        return sdf.format(dataAdmissao);
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getDataDemissao() {
        return sdf.format(dataDemissao);
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    //----------Definição dos métodos do funcionário-----------
    @Override
    public String toString() {
        if (dataDemissao == null) {
            return super.toString()
                    + "\nData de admissao: " + dataAdmissao;
        }
        return super.toString()
                + "\nData de admissao: " + dataAdmissao
                + "\nData de demissao: " + dataDemissao;
    }

    @Override
    public void alterarSenhaAcesso(String senha) {
        setSenha(senha);
        JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
    }

    @Override
    public Conta adicionarConta(int tipoConta, int idConta, int agencia,
            int numeroConta, double saldo, double limiteSaque,
            double taxaManutenção, String CNPJ) {

        int option = tipoConta;
        switch (option) {
            case 201 -> {
                return new ContaPoupanca(idConta, agencia, numeroConta, saldo, "Conta Poupança");
            }
            case 205 -> {
                System.out.print("Digite o CNPJ da empresa: ");
                String cnpjEmpresa = sc.next();
                return new ContaSalario(cnpjEmpresa, idConta, agencia, numeroConta, saldo, "Conta Salário");
            }
            case 209 -> {
                return new ContaCorrente(idConta, agencia, numeroConta, saldo, "Conta Corrente");
            }
        }
        return null;
    }

    @Override
    public List<Conta> removerConta(int idConta, int numeroConta, int agencia, List<Conta> listaConta) {
        int cont = listaConta.size();
        for (int i = 0; i < listaConta.size(); i++) {
            for (Conta c : listaConta) {
                if (c.getIdConta() == idConta && c.getNumeroConta() == numeroConta && c.getAgencia() == agencia) {
                    listaConta.remove(c);
                    JOptionPane.showMessageDialog(null, "Conta removida com sucesso!");
                    break;
                }
            }
            if (cont == listaConta.size()) {
                JOptionPane.showMessageDialog(null, "Conta não encontrada");
            }
        }
        return listaConta;
    }

    @Override
    public void acessarInfoCliente(String idCliente, List<Cliente> listaCleinte) {
        for (Cliente cliente : listaCleinte) {
            if (idCliente.equals(cliente.getId())) {
                System.out.println(cliente.toString());
            }
        }
    }

    @Override
    public Cliente alterarCliente(Cliente cliente) {

        Object[] itens = {"1 - alterar senha", "2 - alterar nome", "3 - alterar endereco", "4 - alterar telefone"};//QUESTION_MESSAGE
        String listaResult = JOptionPane.showInputDialog(null,
                "Escolha um item", "Opçao",
                JOptionPane.QUESTION_MESSAGE, null,
                itens, itens[0]).toString();
        int option = Integer.parseInt(listaResult.replaceAll("[^0-9]", ""));

        switch (option) {
            case 1 -> {
                String valor = JOptionPane.showInputDialog(null,
                        "Digite a nova senha: ", "Alterar senha",
                        JOptionPane.QUESTION_MESSAGE);
                if (valor != null) {
                    cliente.setSenha(valor);
                }
            }
            case 2 -> {
                String valor = JOptionPane.showInputDialog(null,
                        "Digite o novo nome:", "Alterar nome",
                        JOptionPane.QUESTION_MESSAGE);
                if (valor != null) {
                    cliente.setNome(valor);
                }
            }
            case 3 -> {
                String valor = JOptionPane.showInputDialog(null,
                        "Digite o novo endereco:", "Alterar endereco",
                        JOptionPane.QUESTION_MESSAGE);
                if (valor != null) {
                    cliente.setEndereco(valor);
                }
            }
            case 4 -> {
                String valor = JOptionPane.showInputDialog(null,
                        "Digite o novo telefone:", "Alterar telefone",
                        JOptionPane.QUESTION_MESSAGE);
                if (valor != null) {
                    cliente.setEndereco(valor);
                }
            }
            default ->
                throw new AssertionError();
        }
        return cliente;
    }
}
