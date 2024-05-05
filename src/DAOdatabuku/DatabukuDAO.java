/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatabuku;
import java.sql.*;
import java.util.*;
import connection.koneksi;
import Model.*;
import DAOImplement.Databukuimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Sofwan Fadilah
 */
public class DatabukuDAO implements Databukuimplement{
     Connection connection;
    
    final String select = "select * from dataperpus;";
    final String insert = "INSERT INTO dataperpus (judul, genre, penulis, penerbit, lokasi, stock) VALUES (?, ?, ?, ?, ?, ?);";
    final String update = "update dataperpus set judul=?, genre=?, penulis=?, penerbit=?, lokasi=?, stock=? where id=?";
    final String delete = "delete from dataperpus where id=?";

    public DatabukuDAO(){
        connection = koneksi.connection();
    }
    
    @Override
    public void insert(Databuku P) {
       PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, P.getJudul());
            statement.setString(2, P.getGenre());
            statement.setString(3, P.getPenulis());
            statement.setString(4, P.getPenerbit());
            statement.setString(5, P.getLokasi());
            statement.setString(6, P.getStock());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                P.setId(rs.getInt(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
            }
        }
    }

    @Override
    public void update(Databuku P) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, P.getJudul());
            statement.setString(2, P.getGenre());
            statement.setString(3, P.getPenulis());
            statement.setString(4, P.getPenerbit());
            statement.setString(5, P.getLokasi());
            statement.setString(6, P.getStock());
            statement.setInt(7, P.getId());
            statement.executeUpdate();
        }catch(SQLException ex){
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
            }
        }
    }

    public void delete(int id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Databuku> getAll() {
        List<Databuku> db = null;
        try{
            db = new ArrayList<>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                Databuku bu = new Databuku();
                bu.setId(rs.getInt("id"));
                bu.setJudul(rs.getString("judul"));
                bu.setGenre(rs.getString("genre"));
                bu.setPenulis(rs.getString("penulis"));
                bu.setPenerbit(rs.getString("penerbit"));
                bu.setLokasi(rs.getString("lokasi"));
                bu.setStock(rs.getString("stock"));
                db.add(bu);
                
            }
        }catch(SQLException ex){
            Logger.getLogger(DatabukuDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return db;
    }
}

