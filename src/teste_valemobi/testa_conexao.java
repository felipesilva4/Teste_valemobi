/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste_valemobi;

import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 *
 * @author Felipe Alves
 */
// Classe para testar conexão
public class testa_conexao {
    public static void main(String[] args) { 
        Scanner entrada = new Scanner(System.in);
        Conexao conexao = new Conexao();
        int opc; // varialvel que armazena a opção do switch
        System.out.println("Iniciando Conexão...\n\n");
        conexao.conectar();
        // Swicth para o desvio encadeado
        while (true){
            try{
              opc=Integer.parseInt(JOptionPane.showInputDialog("[1] - Inserir registro\n[2] - Media total\n[3] - Imprimir registros\n[4] - SAIR\n"));
            switch (opc) {
                case 1:
                    int id_customer = Integer.parseInt(JOptionPane.showInputDialog("Digite o id","Digite aqui"));
                    String cpf_cnpj =  JOptionPane.showInputDialog("Digite o CPF ou Cppj","Digite aqui");
                    String nm_customer = JOptionPane.showInputDialog("Digite o nome","Digite aqui");
                    String is_active = JOptionPane.showInputDialog("Está ativo?","Digite aqui");
                    float vl_total =Float.parseFloat (JOptionPane.showInputDialog("valor total","Digite aqui"));
                    conexao.inserir(id_customer, cpf_cnpj, nm_customer, is_active, vl_total);
                    break;
                case 2:
                    conexao.media();
                    break;
                case 3:
                    conexao.exibir ();
                    break;
                case 4:
                conexao.desconectar(); 
                 Exit (0);
                 break;
        }  }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Digite apenas numeros!","Erro!",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void Exit(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
