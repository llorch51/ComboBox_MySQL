/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author Thomas Anderson
 */
public class Estados {
    
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    public Vector<Estados> mostrarEstados(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Vector<Estados> datos = new Vector<>();
        Estados dat = null;
        try {
            String sql = "select * from t_estado";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new Estados();
            dat.setId(0);
            dat.setNombre("Selecciona Estado");//la primera opcion para el combobox
            datos.add(dat);//añadir al vector
            //cbEstados.addItem("Seleccione estado");
            while (rs.next()) {
                //cbEstados.addItem(rs.getString("estado"));
                dat = new Estados();
                dat.setId(rs.getInt("id_estado"));
                dat.setNombre(rs.getString("estado"));
                datos.add(dat);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return datos;
    }
    
    
}
