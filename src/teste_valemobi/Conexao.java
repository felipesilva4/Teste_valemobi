/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste_valemobi;

/**
 *
 * @author Felipe Alves
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Alves
 */
// Classe para se conectar ao JDBC MySQL
public class Conexao {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    final String url = "jdbc:mysql://localhost/tb_customer_account";

    public void conectar() {
        try {
            con = DriverManager.getConnection(url, "root", "");
            System.out.println("Conexão realizada com Sucesso!!!\n\n");
        } catch (SQLException e) {
            System.out.println("Erro na Conexão\n" + e);
        }
    }
// Função para inserir dados no JDBC
public  void inserir (int id_customer,String cpf_cnpj,String nm_customer,String is_active,Float vl_total){
         String reg = "\n";
         try{            
             String comando= "INSERT INTO tb_customer_account (id_customer, cpf_cnpj, nm_customer, is_active, vl_total) VALUES  ('"+id_customer+"','"+cpf_cnpj+"','"+nm_customer+"','"+is_active+"','"+vl_total+"')";
             st=con.createStatement();
             st.executeUpdate(comando);
             st.close();
         }catch (SQLException e){
              JOptionPane.showMessageDialog(null,"Erro ao cadastrar!");
         }
  }

// Percorrer o banco de dados e calcular sua media
 public void media() {
        try {
            String reg = "";
            String comando = "SELECT * FROM tb_customer_account where id_customer> 1499 and id_customer <2701 and vl_total > 560 " ;
            st = con.createStatement();
            rs = st.executeQuery(comando);
            float vl_total =0;
            int i = 0;
            while (rs.next()){
              reg+=rs.getFloat("vl_total");                
              vl_total = rs.getFloat("vl_total") + vl_total;
              i++;
            }
            
            System.out.println("i "+i);
            float media = vl_total /i;
            JOptionPane.showMessageDialog(null,"Media: " + media);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao Consultar");
        }
    }
 // Função para desconectar do banco de dados.
 public void desconectar() {
        try {
            con.close();
            JOptionPane.showMessageDialog(null,"Encerrado com Sucesso!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao Encerrar\n" + e);
            
        }
    }
 // Função  para percorrer o  banco de dados e imprimir os regustros com id entre 1500 a 2700 e a variavel vl_total sperior a 560
    public void exibir () {
        try {
            String reg = "";
            String comando = "SELECT * FROM tb_customer_account where id_customer BETWEEN 1500 and 2700 and vl_total > 560 order by vl_total DESC; " ;
            st = con.createStatement();
            rs = st.executeQuery(comando);
            while (rs.next()) {
                reg += "\tRA: " + rs.getInt("id_customer") + " CPF/CNPJ " + rs.getString("cpf_cnpj") + " Nome: " + rs.getString("nm_customer") + " esta ativo? " + rs.getString("is_active") + "  Valor total:  " + rs.getFloat("vl_total") +  "\n" ;
            }
            JOptionPane.showMessageDialog(null,"\n*** LISTA DE CLIENTES *** \n\n" + reg);
            JOptionPane.showMessageDialog(null,"Consulta Realizada com Sucesso!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao Consultar");
        }
    }
    }
    