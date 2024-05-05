/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;
import java.util.List;
import Model.*;
/**
 *
 * @author Sofwan Fadilah
 */
public interface Databukuimplement {
    public void insert(Databuku P);
    public void update(Databuku P);
    public void delete(int id);
    public List<Databuku> getAll();
}
