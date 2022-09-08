/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.util.ArrayList;
import java.util.List;
import jsonOperations.Leitura;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Funcionario;

/**
 * Classe responsavel por fazer a autenticacao do usuario ao sistema.
 * 
 * @author Walter
 */
public class Login {

    public Login() {
    }

    private static List<Cliente> listaCliente = new ArrayList<>();
    private static Funcionario[] listaFuncionarios = new Funcionario[25];
    private static Administrador[] administradores = new Administrador[8];

    private String baseAdministradores = "./src/baseDeDados/administradores.json";
    private String baseFuncionarios = "./src/baseDeDados/funcionarios.json";
    private String baseClientes = "./src/baseDeDados/clientes.json";

    private Cliente usuarioLogado;
    private Funcionario funcionarioLogado;

    public Cliente getUsuarioLogado() {
        return usuarioLogado;
    }

    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    /**
     * Método responsavel por realizar a autenticacao do usuario no sistema.
     *
     * @param id
     * @param senha
     * @return codigo de 1 - 3 para identificar o tipo de usuario: 1 = Cliente;
     * 2 = Funcionario; 3 = Administrador.
     */
    public int Logar(String id, String senha) {

        listaCliente = Leitura.lerClientes(baseClientes);
        listaFuncionarios = Leitura.lerFuncionarios(baseFuncionarios);
        administradores = Leitura.lerAdministradores(baseAdministradores);

        if (listaCliente != null) {
            for (Cliente cli : listaCliente) {
                if (id.equals(cli.getId()) && senha.equals(cli.getSenha())) {
                    usuarioLogado = cli;
                    return 1;
                }
            }
        }
        if (listaFuncionarios != null) {
            for (Funcionario c : listaFuncionarios) {
                if (id.equals(c.getId()) && senha.equals(c.getSenha())) {
                    funcionarioLogado = c;
                    return 2;
                }
            }

        }
        if (administradores != null) {
            for (Administrador c : administradores) {
                if (id.equals(c.getId()) && senha.equals(c.getSenha())) {
                    funcionarioLogado = c;
                    return 3;
                }
            }
        }
        return 0;
    }

    /**
     *
     * @return um exemplo com <code> id </code> e <code> senha </code> de cada
     * tipo de usuario para teste do sistema.
     */
    public String getExemploUsuarios() {
        listaCliente = Leitura.lerClientes(baseClientes);
        listaFuncionarios = Leitura.lerFuncionarios(baseFuncionarios);
        administradores = Leitura.lerAdministradores(baseAdministradores);
        return "Cliente "
                + "\nID: " + listaCliente.get(0).getId()
                + "\nSenha: " + listaCliente.get(0).getSenha()
                + "\n"
                + "\nFuncionário "
                + "\nID: " + listaFuncionarios[0].getId()
                + "\nSenha: " + listaFuncionarios[0].getSenha()
                + "\n"
                + "\nAdministrador"
                + "\nID: " + administradores[0].getId()
                + "\nSenha: " + administradores[0].getSenha();
    }
}
