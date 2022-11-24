/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahasiswa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class model_mahasiswa {
  
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    
    boolean respons;
    
    public model_mahasiswa() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver load.");
        } catch (ClassNotFoundException ex) {
            System.out.println("driver tidak ditemukan");
            Logger.getLogger(model_mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
//            String jdbcDriver = "com.mysql.jdbc.Driver";
            String dbUrl = "jdbc:mysql://localhost/db_mahasiswa";
            String user = "root";
            String password = "";
  
            con = DriverManager.getConnection(dbUrl, user, password);
            st = con.createStatement();
            System.out.println("berhasil terkoneksi dengan mysql");
        } catch (SQLException ex) {
            System.out.println("gagal terkoneksi, periksa config mysql!");
            Logger.getLogger(model_mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean insertMhs(String nim, String nama, String program, String fakultas) {
        try {
                    String query = "insert into tbl_mahasiswa (nim, nama, program_studi, fakultas) values ('" + nim + "','" + nama + "','" + program + "','" + fakultas + "')";
                    st.execute(query);
                    JOptionPane.showMessageDialog(null, "Berhasil Insert Data Mahasiswa");
//            ps.executeUpdate();
//            respons = true;
            System.out.println("sukses insert.");
        } catch (SQLException ex) {
            respons = false;
            System.out.println("gagal insert.");
            Logger.getLogger(model_mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respons; 
    }
}
