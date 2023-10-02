 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;
import MODEL.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Microsoft
 */
public class PessoaController {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Pessoa> list = new ArrayList<>();
    
    public void insertPessoa(Pessoa objPessoa){
        String sql = "INSERT INTO tbpessoa (nome, cpf, datanascimento) VALUES (?, ?, ?)";
       conn = new ConnectionDataBase().connectionBD();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objPessoa.getNome().toUpperCase());
            pstm.setLong(2, objPessoa.getCpf());
            pstm.setString(3, objPessoa.getDatanascimento());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Cadastro salvo !");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null,"O CPF informado já pertence a uma Pessoa"+ error, "Comunique o TI", 0);
        }
    }
    
    public  ArrayList<Pessoa> PesquisarPessoa(){
        String sql = "SELECT * FROM tbpessoa";
        conn = new ConnectionDataBase().connectionBD();
        try {
           pstm = conn.prepareStatement(sql);
           rs = pstm.executeQuery(sql);
            while (rs.next()) {                
                Pessoa objPessoa = new Pessoa();
                objPessoa.setIdPessoa(rs.getInt("idPessoa"));
                objPessoa.setNome(rs.getString("nome"));
                objPessoa.setCpf(rs.getLong("cpf"));
                objPessoa.setDatanascimento(rs.getString("datanascimento"));
                list.add(objPessoa);
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "CONTROLLER, PessoaController, método listPessoa() => "+ error, "Comunique o TI", 0);
        }     
        return list;       
    }
    
    public  void updateRegister(Pessoa objPessoa){
        String sql = "UPDATE tbpessoa SET nome = ?, cpf = ?, datanascimento = ? WHERE idpessoa = ?";
        conn = new ConnectionDataBase().connectionBD();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objPessoa.getNome().toUpperCase());
            pstm.setLong(2, objPessoa.getCpf());
            pstm.setString(3, objPessoa.getDatanascimento());
            pstm.setInt(4, objPessoa.getIdPessoa());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "ALTERADO COM SUCESSO !");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null,"CONTROLLER, PessoaController, método updateRegister() => "+  error, "Comunique o TI", 0);
        }
    }    
        
    public void deleteRegistration(Pessoa objPessoa){
        String sql = "DELETE FROM tbpessoa WHERE idpessoa = ?";
        conn = new ConnectionDataBase().connectionBD();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objPessoa.getIdPessoa());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso !", "Aviso",1);
            System.out.println("Cadastro Excluído !");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null,"CONTROLLER, PessoaController, método deleteRegistration => "+  error, "Comunique o TI", 0);
        }           
    }
}
