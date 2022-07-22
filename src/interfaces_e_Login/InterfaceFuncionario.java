/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces_e_Login;

import contas.Conta;
import java.util.List;
import usuarios.Cliente;

/**
 *
 * @author Walter
 */
public interface InterfaceFuncionario {
    
public void alterarSenhaAcesso(String senha);

public Conta adicionarConta(int tipoConta, int idConta, int agencia, int numeroConta, double saldo, double limiteSaque, double taxaManutenção, String CNPJ);
public List<Conta> removerConta(int idConta, int numeroConta, int agencia, List<Conta> listaConta);

public void acessarInfoCliente(String idCliente, List<Cliente> listaCleinte);
public Cliente alterarCliente(Cliente cliente);
    
}



