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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Walter
 */
public class Funcionario implements InterfaceFuncionario {
    
    private String id; 
    private String senha; 
    private String nome;
    private String endereco;
    private String telefone;
    private final List<Integer> contasAssociadas = new ArrayList<>();
    private List<String> extratos = new ArrayList<>();
    private Date dataAdmissao;
    private Date dataDemissao;
    public static int numeroFuncionarios;
    protected final Scanner sc = new Scanner(System.in);
    protected final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Funcionario(Date dataAdmissao, Date dataDemissao, String id, String senha, String nome, String endereco, String telefone) {
        this.id = id;
        this.senha = senha;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Integer> getsetIdConta() {
        return contasAssociadas;
    }

    public void setIdConta(Integer contasAssociadas) {
        this.contasAssociadas.add(contasAssociadas);
    }

    public List<String> getExtratos() {
        return extratos;
    }

    public void setExtratos(String extratos) {
        this.extratos.add(extratos);
    }

    public String getDataAdmissao() {
        if (dataAdmissao != null) {
            return sdf.format(dataAdmissao);
        } else {
            return "null";
        }
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getDataDemissao() {
        if (dataDemissao != null) {
            return sdf.format(dataDemissao);
        } else {
            return "null";
        }
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }
    
    public boolean setRemoverIdConta(int id){
        for (Integer c : contasAssociadas){
            if (c == id){
                contasAssociadas.remove(c);
                return true;
            }
        }
        return false;
    }

    //----------Definição dos métodos do funcionário-----------
    @Override
    public String toString() {
        String msg;
        if (dataDemissao == null) {
            
            return "\n===============================================\n"
             + "ID: " + getId()
             + "\nNome: " + getNome()
             + "\nSenha: " + getSenha()
             + "\nEndereco: " + getEndereco()
             + "\nTelefone: " + getTelefone()
             + "\nContasAssociadas: " + getsetIdConta()
             + "\nData de admissao: " + getDataAdmissao()
             +"\n===============================================\n";
        }
        return "\n===============================================\n"
             + "ID: " + getId()
             + "\nNome: " + getNome()
             + "\nSenha: " + getSenha()
             + "\nEndereco: " + getEndereco()
             + "\nTelefone: " + getTelefone()
             + "\nContasAssociadas: " + getsetIdConta()
             + "\nData de admissao: " + getDataAdmissao()
             + "\nData de demissao: " + getDataDemissao()
             +"\n===============================================\n";
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
                return new ContaSalario(CNPJ, idConta, agencia, numeroConta, saldo, "Conta Salário");
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
        for (int i = 0; i < 2; i++) {
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

        Object[] itens = {"1 - alterar senha", "2 - alterar nome", "3 - alterar endereco", "4 - alterar telefone"};
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
