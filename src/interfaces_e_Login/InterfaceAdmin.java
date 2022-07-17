/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces_e_Login;

import contas.Conta;
import java.text.ParseException;
import java.util.List;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Funcionario;

/**
 *
 * @author Walter
 */
public interface InterfaceAdmin {


    
public void acessarInfoConta(int idConta, List<Conta> listaConta);
public List<Conta> alterarConta(int idConta, List<Conta> listaConta);

public void acessarInfoAdmin(String idAdmin, Administrador[] administrador);
public Administrador[] alterarAdmin(String idAdmin, Administrador[] administrador) throws ParseException;
public Administrador[] adcionarAdmin(Administrador[] listaAdministrador) throws ParseException;
public Administrador[] removerAdmin(String idAdmin, Administrador[] administrador);

public List<Cliente> adicionarCliente(List<Cliente> listaCliente);
public List<Cliente> removerCliente(String idCliente, List<Cliente> listaCliente);

public Funcionario[] alterarFuncionario(String idFuncionario, Funcionario[] listaFuncionario) throws ParseException;
public Funcionario[] adicionarFuncionario(Funcionario[] listaFuncionario) throws ParseException;
public Funcionario[] removerFuncionario(String idFuncionario, Funcionario[] listaFuncionario);
    
}
