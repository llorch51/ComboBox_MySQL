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
public class Localidades {
    
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
    
    public Vector<Localidades> mostrarLocalidades(Integer idMunicipio){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Vector<Localidades> datos = new Vector<>();
        Localidades dat = null;
        try {
            String sql = "select * from t_localidad where id_municipio = "+idMunicipio;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new Localidades();
            dat.setId(0);
            dat.setNombre("Selecciona Localidad");//la primera opcion para el combobox
            datos.add(dat);//añadir al vector
            //cbEstados.addItem("Seleccione estado");
            while (rs.next()) {
                //cbEstados.addItem(rs.getString("estado"));
                dat = new Localidades();
                dat.setId(rs.getInt("id_localidad"));
                dat.setNombre(rs.getString("localidad"));
                datos.add(dat);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return datos;
    }
    
    
}
