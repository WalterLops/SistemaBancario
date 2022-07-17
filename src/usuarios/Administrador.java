/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import contas.ContaSalario;
import interfaces_e_Login.InterfaceAdmin;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
                System.out.println("""
                                   Digite o código da operação:
                                   \n 1 - alterar agencia
                                   """);
                if ("Conta Poupança".equals(conta.getTipoConta())) {
                    System.out.println("2 - Alterar limite de saque");
                }
                if ("Conta Salário".equals(conta.getTipoConta())) {
                    System.out.println("2 - Alterar CNPJ da empresa");
                }
                if ("Conta Corrente".equals(conta.getTipoConta())) {
                    System.out.println("2 - Alterar taxa de manutencao");
                }
                System.out.print("Opção desejada: ");
                int option = sc.nextInt();

                // Trabalhando as opções
                if (option == 1) {
                    System.out.print("Digite o código da nova agência: ");
                    conta.setAgencia(sc.nextInt());
                }
                if (option == 2) {

                    if ("Conta Poupança".equals(conta.getTipoConta())) {
                        System.out.print("Digite o novo limite de saque");
                        double limite = sc.nextDouble();
                        if (conta instanceof ContaPoupanca contaPoupanca) {
                            contaPoupanca.setLimiteSaque(limite);
                        }

                    }
                    if ("Conta Salário".equals(conta.getTipoConta())) {
                        System.out.println("Digite o novo CNPJ da empresa: ");
                        int cnpj = sc.nextInt();
                        if (conta instanceof ContaSalario contaSalario) {
                            contaSalario.setCnpjEmpresa(cnpj);
                        }
                    }
                    if (conta.getTipoConta() == "Conta Corrente") {
                        System.out.println("Digite a nova taxa de manutencao: ");
                        double taxa = sc.nextDouble();
                        if (conta instanceof ContaCorrente contaCorrente) {
                            contaCorrente.setTaxaManutencao(taxa);
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
        for (Administrador admin : administrador) {
            if (admin.getId() == idAdmin) {
                System.out.print("Digite o código da operação desejada: "
                        + "\n 1 - alterar senha"
                        + "\n 2 - alterar nome"
                        + "\n 3 - alterar endereco"
                        + "\n 4 - alterar telefone"
                        + "\n 5 - alterar data de admição"
                        + "\n 6 - adicionar data de demição");
                int option = sc.nextInt();
                switch (option) {
                    case 1 -> {
                        System.out.print("Digite a nova senha: ");
                        admin.setSenha(sc.next());
                    }
                    case 2 -> {
                        System.out.print("Digite o novo nome: ");
                        admin.setNome(sc.nextLine());
                    }
                    case 3 -> {
                        System.out.print("Digite o novo endereco: ");
                        admin.setEndereco(sc.nextLine());
                    }
                    case 4 -> {
                        System.out.print("Digite o novo telefone: ");
                        admin.setEndereco(sc.next());
                    }
                    case 5 -> {
                        System.out.print("Digite a nova data de admição no formato dd/mm/aaaa: ");
                        admin.setDataAdmissao(sdf.parse(sc.next()));
                    }
                    case 6 -> {
                        System.out.print("Digite a data de demição no formato dd/mm/aaaa: ");
                        admin.setDataDemissao(sdf.parse(sc.next()));
                    }
                    default ->
                        throw new AssertionError();
                } 
            }
        }
        return administrador;
    }
    
    @Override
    public Administrador[] adcionarAdmin(Administrador[] listaAdministrador) throws ParseException {

        int cont = 0;
        for (Administrador listaAdministrador1 : listaAdministrador) {
            if (listaAdministrador1 == null) {
                cont++;
            }
        }
        if (listaAdministrador[0].numeroAdministradores == cont) {
            System.out.println("Não é´possível adcionar mais administradores");
        } else {
            System.out.println("Preencha os dados do novo Administrador: ");
            System.out.print("ID: ");
            String id = sc.next();
            System.out.print("Senha: ");
            String senha = sc.next();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Endereco: ");
            String endereco = sc.nextLine();
            System.out.print("Telefone: ");
            String telefone = sc.next();
            System.out.print("Data de admição no formato dd/mm/aaaa: ");
            Date dataAdmissao = sdf.parse(sc.next());
            Date dataDemissao = null;

            for (int i = 0; i < listaAdministrador.length; i++) {
                if (listaAdministrador[i] == null) {
                    listaAdministrador[i] = new Administrador(dataAdmissao, dataDemissao, id, senha, nome, endereco, telefone);
                    break;
                }
            }
        }
        return listaAdministrador;
    }
    
    @Override
    public Administrador[] removerAdmin(String idAdmin, Administrador[] administrador) {

        int cont = 0;
        for (int i = 0; i < administrador.length; i++) {
            if (administrador[i] == null) {
                cont++;
            }
        }
        if (cont < 2) {
            System.out.println("Não é possível remover mais administradores.");
        } else {
            for (int i = 0; i < administrador.length; i++) {
                if (administrador[i].getId() == idAdmin) {
                    administrador[i] = null;
                }
            }
        }
        return administrador;
    }
    
    @Override
    public List<Cliente> adicionarCliente(List<Cliente> listaCliente) {
        System.out.println("Preencha os dados do novo cliente: ");
        System.out.print("ID: ");
        String id = sc.next();
        System.out.print("Senha: ");
        String senha = sc.next();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Endereco: ");
        String endereco = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.next();
        listaCliente.add(new Cliente(id, senha, nome, endereco, telefone));
        return listaCliente;
    }
    
    @Override
    public List<Cliente> removerCliente(String idCliente, List<Cliente> listaCliente){
        for (Cliente cliente : listaCliente){
            if (cliente.getId() == idCliente){
                listaCliente.remove(cliente);
            }
        }
        return listaCliente;
    }
    
    @Override
    public Funcionario[] alterarFuncionario(String idFuncionario, Funcionario[] listaFuncionario) throws ParseException {
        for (Funcionario funcionario : listaFuncionario) {
            if (funcionario.getId() == idFuncionario) {
                System.out.print("Digite o código da operação desejada: "
                        + "\n 1 - alterar senha"
                        + "\n 2 - alterar nome"
                        + "\n 3 - alterar endereco"
                        + "\n 4 - alterar telefone"
                        + "\n 5 - alterar data de admição"
                        + "\n 6 - adicionar data de demição");
                int option = sc.nextInt();
                switch (option) {
                    case 1 -> {
                        System.out.print("Digite a nova senha: ");
                        funcionario.setSenha(sc.next());
                    }
                    case 2 -> {
                        System.out.print("Digite o novo nome: ");
                        funcionario.setNome(sc.nextLine());
                    }
                    case 3 -> {
                        System.out.print("Digite o novo endereco: ");
                        funcionario.setEndereco(sc.nextLine());
                    }
                    case 4 -> {
                        System.out.print("Digite o novo telefone: ");
                        funcionario.setEndereco(sc.next());
                    }
                    case 5 -> {
                        System.out.print("Digite a nova data de admição no formato dd/mm/aaaa: ");
                        funcionario.setDataAdmissao(sdf.parse(sc.next()));
                    }
                    case 6 -> {
                        System.out.print("Digite a data de demição no formato dd/mm/aaaa: ");
                        funcionario.setDataDemissao(sdf.parse(sc.next()));
                    }
                    default ->
                        throw new AssertionError();
                } 
            }
        }
        return listaFuncionario;
    }
    
    @Override
    public Funcionario[] adicionarFuncionario(Funcionario[] listaFuncionario) throws ParseException {

        int cont = 0;
        for (Funcionario funcionario : listaFuncionario) {
            if (funcionario == null) {
                cont++;
            }
        }
        if (listaFuncionario[0].numeroFuncionarios == cont) {
            System.out.println("Não é´possível adcionar mais funcionarios");
        } else {
            System.out.println("Preencha os dados do novo funcionario: ");
            System.out.print("ID: ");
            String id = sc.next();
            System.out.print("Senha: ");
            String senha = sc.next();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Endereco: ");
            String endereco = sc.nextLine();
            System.out.print("Telefone: ");
            String telefone = sc.next();
            System.out.print("Data de admição no formato dd/mm/aaaa: ");
            Date dataAdmissao = sdf.parse(sc.next());
            Date dataDemissao = null;

            for (int i = 0; i < listaFuncionario.length; i++) {
                if (listaFuncionario[i] == null) {
                    listaFuncionario[i] = new Administrador(dataAdmissao, dataDemissao, id, senha, nome, endereco, telefone);
                    break;
                }
            }
        }
        return listaFuncionario;
    }
    
    @Override
    public Funcionario[] removerFuncionario(String idFuncionario, Funcionario[] listaFuncionario){
        int cont = 0;
        for (int i = 0; i < listaFuncionario.length; i++) {
            if (listaFuncionario[i] == null) {
                cont++;
            }
        }
        if (cont < 5) {
            System.out.println("Não é possível remover mais funcionarios.");
        } else {
            for (int i = 0; i < listaFuncionario.length; i++) {
                if (listaFuncionario[i].getId() == idFuncionario) {
                    listaFuncionario[i] = null;
                }
            }
        }
        return listaFuncionario;
    }
    

}
