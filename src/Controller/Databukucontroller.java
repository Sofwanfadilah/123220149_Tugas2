/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.util.List;
import java.util.ArrayList;
import DAOdatabuku.DatabukuDAO;
import DAOImplement.Databukuimplement;
import Model.*;
import View.MainView;
/**
 *
 * @author Sofwan Fadilah
 */
public class Databukucontroller {
     Mainview frame;
    Databukuimplement implDatabuku;
    List<Databuku> db;
    
    public Databukucontroller(Mainview frame){
        this.frame = frame;
        implDatabuku = new DatabukuDAO();
        db = implDatabuku.getAll();
    }

    /**
     *
     */
    public void isitabel(){
        db = implDatabuku.getAll();
        Modeltabeldatabuku mp = new Modeltabeldatabuku(db);
        frame.getTabelDatabuku().setModel(mp);
    }
    
    public void insert(){
        Databuku db = new Databuku();
        db.setJudul(frame.getJtxtJudul().getText());
        db.setGenre(frame.getJtxtGenre().getText());
        db.setPenulis(frame.getJtxtPenulis().getText());
        db.setPenerbit(frame.getJtxtPenerbit().getText());
        db.setLokasi(frame.getJtxtLokasi().getText());
        db.setStock(frame.getJtxtStock().getText());
        implDatabuku.insert(P);
        
    }
    
    public void update(){
        Databuku db = new Databuku();
        db.setJudul(frame.getJtxtJudul().getText());
        db.setGenre(frame.getJtxtGenre().getText());
        db.setPenulis(frame.getJtxtPenulis().getText());
        db.setPenerbit(frame.getJtxtPenerbit().getText());
        db.setLokasi(frame.getJtxtLokasi().getText());
        db.setStock(frame.getJtxtStock().getText());
        db.setId(Integer.parseInt(frame.getJtxtID().getText()));
        implDatabuku.update(db);
    }
    
    public void delete(){
        int id = Integer.parseInt(frame.getJtxtID().getText());
        implDatabuku.delete(id);
    }
    
    public void cari(String keyword, String category) {
    List<Databuku> datasearch = new ArrayList<>();
    List<Databuku> allData = implDatabuku.getAll();

    for (Databuku buku : allData) {
        if (category.equalsIgnoreCase("Judul")) {
            if (buku.getJudul().toLowerCase().contains(keyword.toLowerCase())) {
                datasearch.add(buku);
            }
        } else if (category.equalsIgnoreCase("Genre")) {
            if (buku.getGenre().toLowerCase().contains(keyword.toLowerCase())) {
                datasearch.add(buku);
            }
        } else if (category.equalsIgnoreCase("Penulis")) {
            if (buku.getPenulis().toLowerCase().contains(keyword.toLowerCase())) {
                datasearch.add(buku);
            }
        } else if (category.equalsIgnoreCase("Penerbit")) {
            if (buku.getPenerbit().toLowerCase().contains(keyword.toLowerCase())) {
                datasearch.add(buku);
            }
        }
    }
    Modeltabeldatabuku Model = new Modeltabeldatabuku(datasearch);
    frame.getTabelDatabuku().setModel(Model);
}

    public void isitabel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

