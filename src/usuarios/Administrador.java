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
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Walter
 */
public class Administrador extends Funcionario {

    public Administrador(String dataAdmissao, String dataDemissao, String id, String senha, String nome, String endereco, String telefone) {
        super(dataAdmissao, dataDemissao, id, senha, nome, endereco, telefone);
    }

    /**
     * Altera as informacoes da conta se existeir uma conta com o mesmo idConta
     * na List &lt;Conta&gt; passado como parametro.
     *
     * @param idConta
     * @param listaConta
     * @return List &lt;Conta&gt com a conta atualizada;
     */
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

    /**
     * Altera as informacoes do administrador se for encontrado um objeto com o
     * mesmo id que idAdmin. Se nao retorna a lista sem alteracoes.
     *
     * @param idAdmin
     * @param administrador
     * @return Administrador[]
     */
    public Administrador[] alterarAdmin(String idAdmin, Administrador[] administrador) {

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
                            admin.setDataAdmissao(valor);
                        }
                    }
                    case 6 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite a data de demição no formato dd/mm/aaaa: ", "Alterar senha",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            admin.setDataDemissao(valor);
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

    /**
     * Gera e retorna um objeto do tipo Administrador.
     *
     * @param dataAdmissao
     * @param dataDemissao
     * @param id
     * @param senha
     * @param nome
     * @param endereco
     * @param telefone
     * @return Administrador
     */
    public Administrador adicionarAdmin(String dataAdmissao, String dataDemissao,
            String id, String senha, String nome,
            String endereco, String telefone) {

        return new Administrador(dataAdmissao, dataDemissao, id, senha, nome, endereco, telefone);

    }

    /**
     * Remove da lista estatica um objeto Administrador que possuir o id =
     * idAdmin e retorna a lista estatica atualizada. Caso nao for encontrado
     * nenhum objeto correspondente entao sera retornada a lista sem nehuma
     * alteracao.
     *
     * @param idAdmin
     * @param administrador
     * @param listaAdministradores
     * @return Administrador[]
     */
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

    /**
     * Gera e retorna um objeto do tipo Cliente.
     *
     * @param id
     * @param senha
     * @param nome
     * @param endereco
     * @param telefone
     * @return Cliente
     */
    public Cliente adicionarCliente(String id, String senha, String nome, String endereco, String telefone) {
        return new Cliente(id, senha, nome, endereco, telefone);
    }

    /**
     * Remove da lista um objeto Cliente que possuir o id = idCliente e retorna
     * a lista atualizada. Caso nao for encontrado nenhum objeto correspondente
     * entao sera retornada a lista sem nehuma alteracao.
     *
     * @param idCliente
     * @param listaCliente
     * @return List &lt;Cliente&gt;
     */
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

    /**
     * Altera as informacoes do funcionario se for encontrado um objeto com o
     * mesmo id que idAdmin. Se nao retorna a lista sem alteracoes.
     *
     * @param idFuncionario
     * @param listaFuncionario
     * @return Funcionario[]
     */
    public Funcionario[] alterarFuncionario(String idFuncionario, Funcionario[] listaFuncionario) {

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
                            funcionario.setDataAdmissao(valor);
                        }
                    }
                    case 6 -> {
                        valor = JOptionPane.showInputDialog(null,
                                "Digite a data de demição no formato dd/mm/aaaa: ", "Alterar senha",
                                JOptionPane.QUESTION_MESSAGE);
                        if (valor != null) {
                            funcionario.setDataDemissao(valor);
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

    /**
     * Gera e retorna um objeto do tipo Funcionario.
     *
     * @param dataAdmissao
     * @param dataDemissao
     * @param id
     * @param senha
     * @param nome
     * @param endereco
     * @param telefone
     * @return Funcionario
     */
    public Funcionario adicionarFuncionario(String dataAdmissao,
            String dataDemissao, String id, String senha,
            String nome, String endereco, String telefone) {

        return new Funcionario(dataAdmissao, dataDemissao, id,
                senha, nome, endereco, telefone);

    }

    /**
     * Remove da lista um objeto Funcionario que possuir o id = idFuncionario e
     * retorna a lista estatica atualizada. Caso nao for encontrado nenhum
     * objeto correspondente entao sera retornada a lista estatica sem nehuma
     * alteracao.
     *
     *
     * @param idFuncionario
     * @param listaFuncionario
     * @return Funcionario[]
     */
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

    /**
     * Gera e retorna um objeto do tipo Agencia.
     *
     * @param nome
     * @param codigo
     * @param cidade
     * @param endereco
     * @return Agencia
     */
    public Agencia adicionarAgencia(String nome, int codigo, String cidade, String endereco) {
        return new Agencia(nome, codigo, cidade, endereco);
    }

    /**
     * Altera as informacoes da Agencia se for encontrado um objeto lista com o
     * mesmo codigo que o informado no parametro. Se nao retorna a lista sem
     * alteracoes.
     *
     * @param codigo
     * @param listaAgencia
     * @return List &lt;Agencia&gt;
     */
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

    /**
     * Remove da lista um objeto Agencia que possuir o codigo igual ao que foi
     * informado no parametro e retorna a lista atualizada. Caso nao for
     * encontrado nenhum objeto correspondente entao sera retornada a lista sem
     * nehuma alteracao.
     *
     * @param codigo
     * @param listaAgencia
     * @return List &lt;Agencia&gt;
     */
    public List<Agencia> removerAgencia(int codigo, List<Agencia> listaAgencia) {

        for (Agencia a : listaAgencia) {
            if (codigo == a.getCodigo()) {
                listaAgencia.remove(a);
                break;
            }
        }
        return listaAgencia;
    }
}
