/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import agencia.Agencia;
import contas.Conta;
import java.util.ArrayList;
import java.util.List;
import jsonOperations.Leitura;
import org.json.simple.parser.ParseException;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Funcionario;

/**
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

    public Cliente getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Cliente usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public int Logar(String id, String senha) throws ParseException {
        
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
                    usuarioLogado = c;
                    return 2;
                }
            }

        } 
        if (administradores != null) {
            for (Administrador c : administradores) {
                if (id.equals(c.getId()) && senha.equals(c.getSenha())) {
                    usuarioLogado = c;
                    return 3;
                }
            }
        }
        return 0;
    }
    
    public String getExemploUsuarios(){
        return  """
                Cliente 
                ID: C1022
                Senha: 1234
                
                Funcionário
                ID: F1022
                Senha: 1234
                
                Administrador
                ID: A1020
                Senha: 1234""";
    }
}



