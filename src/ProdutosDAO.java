/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ResultSet rs;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto (ProdutosDTO produto){
 
    try (Connection conn = new conectaDAO().connectDB(); 
         PreparedStatement prep = conn.prepareStatement("INSERT INTO produtos (nome, valor) VALUES(?,?)")){
               
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.executeUpdate();
            return true;
            } catch (SQLException e) {
                System.out.println("Erro ao conectar.");         
        }       return false;
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

