/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.util.List;
import java.util.Scanner;
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

    public static Cliente Logar(List<Cliente> list, Funcionario[] listaFuncionario, Administrador[] administrador) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o seu ID: ");
        String id = sc.next();



        System.out.print("Digite a sua senha: ");
        String senha = sc.next();

        if (list != null) {
            for (Cliente cliente : list) {
                if (id.equals(cliente.getId()) && senha.equals(cliente.getSenha())) {
                    return cliente;
                }
            }
        } else if (listaFuncionario != null) {
            for (Funcionario c : listaFuncionario) {
                if (id == c.getId() && senha == c.getSenha()) {
                    return c;
                }
            }

        } else if (administrador != null) {
            for (Administrador c : administrador) {
                if (id == c.getId() && senha == c.getSenha()) {
                    return c;
                }

            }
        }
        return null;
    }

    

    public void Logout() {

        System.out.println("Finalizando programa.");

    }

}
