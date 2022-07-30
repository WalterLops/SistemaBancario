/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import contas.ContaSalario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Walter
 */
public class Funcionario {

    private String id;
    private String senha;
    private String nome;
    private String endereco;
    private String telefone;
    private String dataAdmissao;
    private String dataDemissao;
    private final List<Integer> contasAssociadas = new ArrayList<>();

    public Funcionario(String dataAdmissao, String dataDemissao, String id, String senha, String nome, String endereco, String telefone) {
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

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(String dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public boolean setRemoverIdConta(int id) {
        for (Integer c : contasAssociadas) {
            if (c == id) {
                contasAssociadas.remove(c);
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @return todas as informacoes desse objeto.
     */
    @Override
    public String toString() {
        if ("null".equals(dataDemissao)) {

            return "\n===============================================\n"
                    + "ID: " + getId()
                    + "\nNome: " + getNome()
                    + "\nSenha: " + getSenha()
                    + "\nEndereco: " + getEndereco()
                    + "\nTelefone: " + getTelefone()
                    + "\nContasAssociadas: " + getsetIdConta()
                    + "\nData de admissao: " + getDataAdmissao()
                    + "\n===============================================\n";
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
                + "\n===============================================\n";
    }

    /**
     * Altera a senha de acesso
     * 
     * @param senha 
     */
    public void alterarSenhaAcesso(String senha) {
        setSenha(senha);
        JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
    }
    
    /**
     * adiciona a conta com base no codigo passado para o parametro 
     * <code>tipoConta</code>: 
     * <ul>
     * <li> 201 = ContaPoupanca;
     * <li> 205 = ContaSalario;
     * <li> 209 = ContaCorrente.
     * </ul>
     * 
     * @param tipoConta
     * @param idConta
     * @param agencia
     * @param numeroConta
     * @param saldo
     * @param limiteSaque
     * @param taxaManutenção
     * @param CNPJ
     * @return conta criada com base no codigo fornecido.
     */
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

    /**
     * Remove a conta cujo os dados foram passados por parametros. E retorna uma
     * lista atualizada. Se a conta nao for encontrada a lista e retornada da 
     * mesama maneira que foi recebida(sem nehuma alteracao).
     * 
     * @param idConta
     * @param numeroConta
     * @param agencia
     * @param listaConta
     * @return List &lt;Conta&gt;
     */
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

    /**
     * Altera os dados do cliente.
     * 
     * @param cliente
     * @return objeto do tipo Cliente com as informacoes alteradas.
     */
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
