/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import agencia.Agencia;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import contas.ContaSalario;
import interfaces_e_Login.InterfaceAdmin;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Walter
 */
public class Administrador extends Funcionario implements InterfaceAdmin {

    public static int numeroAdministradores;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Administrador(Date dataAdmissao, Date dataDemissao, String id, String senha, String nome, String endereco, String telefone) {
        super(dataAdmissao, dataDemissao, id, senha, nome, endereco, telefone);
        Administrador.numeroAdministradores += 1;
    }

    //----------Definição dos métodos do Administrador-----------
    @Override
    public void acessarInfoConta(int idConta, List<Conta> listaConta) {
        for (Conta conta : listaConta) {
            if (idConta == conta.getIdConta()) {
                conta.toString();
            }
        }
    }

    @Override
    public List<Conta> alterarConta(int idConta, List<Conta> listaConta) {
        for (Conta conta : listaConta) {
            if (idConta == conta.getIdConta()) {

                String[] itens = new String[2];

                itens[0] = "1 - alterar agencia";
                if (null != conta.getTipoConta()) {
                    switch (conta.getTipoConta()) {
                        case "Conta Poupança":
                            itens[1] = "2 - Alterar limite de saque";
                            break;
                        case "Conta Salário":
                            itens[1] = "2 - Alterar CNPJ da empresa";
                            break;
                        case "Conta Corrente":
                            itens[1] = "2 - Alterar taxa de manutencao";
                            break;
                        default:
                            break;
                    }
                }

                String valor;
                String listaResult = JOptionPane.showInputDialog(null,
                        "Escolha a ação desejada", "Ação",
                        JOptionPane.QUESTION_MESSAGE, null,
                        itens, itens[0]).toString();
                int option = Integer.parseInt(listaResult.replaceAll("[^0-9]", ""));

                // Trabalhando as opções
                if (option == 1) {
                    valor = JOptionPane.showInputDialog(null,
                            "Digite o código da nova agência:", "Alterar agência",
                            JOptionPane.QUESTION_MESSAGE);
                    if (valor != null) {
                        conta.setAgencia(Integer.parseInt(valor));
                    }
                }
                if (option == 2) {

                    if ("Conta Poupança".equals(conta.getTipoConta())) {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite o novo limite de saque:", "Alterar limite de saque",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            if (conta instanceof ContaPoupanca contaPoupanca) {
                                contaPoupanca.setLimiteSaque(Double.parseDouble(valor));
                            }
                        }

                    }
                    if ("Conta Salário".equals(conta.getTipoConta())) {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite o novo CNPJ da empresa:", "Alterar CNPJ da empresa",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null);
                        if (conta instanceof ContaSalario contaSalario) {
                            contaSalario.setCnpjEmpresa(valor);
                        }
                    }
                    if ("Conta Corrente".equals(conta.getTipoConta())) {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite a nova taxa de manutencao:", "Alterar taxa de manutencao",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            if (conta instanceof ContaCorrente contaCorrente) {
                                contaCorrente.setTaxaManutencao(Double.parseDouble(valor));
                            }
                        }
                    }

                }

            }
        }
        return listaConta;
    }

    @Override
    public void acessarInfoAdmin(String idAdmin, Administrador[] administrador) {
        for (Administrador admin : administrador) {
            if (admin.getId() == idAdmin) {
                admin.toString();
            }
        }
    }

    @Override
    public Administrador[] alterarAdmin(String idAdmin, Administrador[] administrador) throws ParseException {

        String valor = null;

        for (Administrador admin : administrador) {
            if (admin.getId().equals(idAdmin)) { //admin
                Object[] itens = {"1 - alterar senha",
                    "2 - alterar nome",
                    "3 - alterar endereco",
                    "4 - alterar telefone",
                    "5 - alterar data de admição",
                    "6 - adicionar data de demição"};
                String listaResult = JOptionPane.showInputDialog(null,
                        "Escolha a ação desejada", "Ação",
                        JOptionPane.QUESTION_MESSAGE, null,
                        itens, itens[0]).toString();
                int option = Integer.parseInt(listaResult.replaceAll("[^0-9]", ""));

                switch (option) {
                    case 1 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite a nova senha:", "Alterar senha",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            admin.setSenha(valor);
                        }
                    }
                    case 2 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite o novo nome: ", "Alterar nome",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            admin.setNome(valor);
                        }
                    }
                    case 3 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite o novo endereco: ", "Alterar endereco",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            admin.setEndereco(valor);
                        }
                    }
                    case 4 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite o novo telefone: ", "Alterar telefone",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            admin.setEndereco(valor);
                        }
                    }
                    case 5 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite a nova data de admição no formato dd/mm/aaaa: ", "Alterar senha",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            admin.setDataAdmissao(sdf.parse(valor));
                        }
                    }
                    case 6 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite a data de demição no formato dd/mm/aaaa: ", "Alterar senha",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            admin.setDataDemissao(sdf.parse(valor));
                        }
                    }
                }
            }
        }
        if (valor != null) {
            JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!");
        }
        return administrador;
    }

    @Override
    public Administrador adicionarAdmin(Date dataAdmissao, Date dataDemissao,
            String id, String senha, String nome,
            String endereco, String telefone) throws ParseException {

        return new Administrador(dataAdmissao, dataDemissao, id, senha, nome, endereco, telefone);

    }

    @Override
    public Administrador[] removerAdmin(String idAdmin, Administrador administrador, Administrador[] listaAdministradores) {

        if (listaAdministradores.length < 2) {

            JOptionPane.showMessageDialog(null, "Não é possível remover mais administradores.");

        } else if (idAdmin.equals(administrador.getId())) {

            JOptionPane.showMessageDialog(null, "Não é possível remover a sua própria conta.");

        } else {

            Administrador[] novaLista = new Administrador[listaAdministradores.length - 1];

            int j = 0; // indice j para não acessar posição indevida
            for (int i = 0; i < listaAdministradores.length; i++) {

                if (!listaAdministradores[i].getId().equals(idAdmin)) {
                    novaLista[j++] = listaAdministradores[i];
                }

            }
            return novaLista;
        }

        return null;
    }

    @Override
    public Cliente adicionarCliente(String id, String senha, String nome, String endereco, String telefone) {
        return new Cliente(id, senha, nome, endereco, telefone);
    }

    @Override
    public List<Cliente> removerCliente(String idCliente, List<Cliente> listaCliente) {
        int tamanhoInicial = listaCliente.size();
        for (Cliente cliente : listaCliente) {
            if (cliente.getId().equals(idCliente)) {
                listaCliente.remove(cliente);
                break;
            }
        }
        if (tamanhoInicial > listaCliente.size()) {
            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
        }
        return listaCliente;
    }

    @Override
    public Funcionario[] alterarFuncionario(String idFuncionario, Funcionario[] listaFuncionario) throws ParseException {

        String valor = null;

        for (Funcionario funcionario : listaFuncionario) {
            if (funcionario.getId().equals(idFuncionario)) {

                Object[] itens = {"1 - alterar senha",
                    "2 - alterar nome",
                    "3 - alterar endereco",
                    "4 - alterar telefone",
                    "5 - alterar data de admição",
                    "6 - adicionar data de demição"};
                String listaResult = JOptionPane.showInputDialog(null,
                        "Escolha a ação desejada", "Ação",
                        JOptionPane.QUESTION_MESSAGE, null,
                        itens, itens[0]).toString();
                int option = Integer.parseInt(listaResult.replaceAll("[^0-9]", ""));

                switch (option) {
                    case 1 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite a nova senha:", "Alterar senha",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            funcionario.setSenha(valor);
                        }
                    }
                    case 2 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite o novo nome: ", "Alterar nome",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            funcionario.setNome(valor);
                        }
                    }
                    case 3 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite o novo endereco: ", "Alterar endereco",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            funcionario.setEndereco(valor);
                        }
                    }
                    case 4 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite o novo telefone: ", "Alterar telefone",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            funcionario.setEndereco(valor);
                        }
                    }
                    case 5 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite a nova data de admição no formato dd/mm/aaaa: ", "Alterar senha",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            funcionario.setDataAdmissao(sdf.parse(valor));
                        }
                    }
                    case 6 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite a data de demição no formato dd/mm/aaaa: ", "Alterar senha",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            funcionario.setDataDemissao(sdf.parse(valor));
                        }
                    }
                }
            }
        }
        if (valor != null) {
            JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!");
        }
        return listaFuncionario;
    }

    @Override
    public Funcionario adicionarFuncionario(Date dataAdmissao, Date dataDemissao, String id, String senha, String nome, String endereco, String telefone) throws ParseException {

        return new Funcionario(dataAdmissao, dataDemissao, id, senha, nome, endereco, telefone);

    }

    @Override
    public Funcionario[] removerFuncionario(String idFuncionario, Funcionario[] listaFuncionario) {

        if (listaFuncionario.length < 2) {

            JOptionPane.showMessageDialog(null, "Não é possível remover mais funcionarios.");

        } else {

            Funcionario[] novaLista = new Funcionario[listaFuncionario.length - 1];

            int j = 0;  // indice j para não acessar posição indevida
            for (int i = 0; i < listaFuncionario.length; i++) {

                if (!listaFuncionario[i].getId().equals(idFuncionario)) {
                    novaLista[j++] = listaFuncionario[i];
                }

            }
            JOptionPane.showMessageDialog(null, "Funcionáro removido com sucesso!");
            return novaLista;
        }

        return null;
    }
    
    @Override
    public Agencia adicionarAgencia(String nome, int codigo, String cidade, String endereco) {
        return new Agencia(nome, codigo, cidade, endereco);
    }
    
    @Override
    public List<Agencia> alterarAgencia(int codigo, List<Agencia> listaAgencia) {

        String valor = null;
        for (Agencia a : listaAgencia) {
            if (codigo == a.getCodigo()) {

                Object[] itens = {"1 - alterar nome",
                    "2 - alterar cidade",
                    "3 - alterar endereco"};
                String listaResult = JOptionPane.showInputDialog(null,
                        "Escolha a ação desejada", "Ação",
                        JOptionPane.QUESTION_MESSAGE, null,
                        itens, itens[0]).toString();
                int option = Integer.parseInt(listaResult.replaceAll("[^0-9]", ""));

                switch (option) {
                    case 1 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite o novo nome:", "Alterar nome",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            a.setNome(valor);
                        }
                    }
                    case 2 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite a nova cidade: ", "Alterar cidade",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            a.setCidade(valor);
                        }
                    }
                    case 3 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite o novo endereco: ", "Alterar endereco",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            a.setEndereco(valor);
                        }
                    }
                }
            }
        }
        if (valor != null) {
            JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!");
        }
        return listaAgencia;
    }

    @Override
    public List<Agencia> removerAgencia(int codigo, List<Agencia> listaAgencia) {
        
        for (Agencia a : listaAgencia){
            if (codigo == a.getCodigo()){
                listaAgencia.remove(a);
                break;
            }
        }
        return listaAgencia;
    }
}
