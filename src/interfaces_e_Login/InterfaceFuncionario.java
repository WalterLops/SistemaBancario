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

public contas.Conta adicionarConta();
public List<Conta> removerConta(int idConta, List<Conta> listaConta);

public void acessarInfoCliente(String idCliente, List<Cliente> listaCleinte);
public List<Cliente> alterarCliente(String idCliente, List<Cliente> listaCliente);
    
}



