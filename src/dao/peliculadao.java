/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import metodos.metodos;
import modelo.pelicula;

/**
 *
 * @author Mabel
 */
public class peliculadao implements metodos<pelicula> {
private static final String SQL_INSERT = "INSERT INTO movie(1)(nombre,anio,director,pais,clasificacion,existencia) VALUES (?,?,?,?,?)";
private static final String SQL_UPDATE ="UPDATE movie(1) SET existencia =? WHERE nombre=?";
private static final String SQL_DELETE = "DELETE FROM movie(1) WHERE nombre=?";
private static final String SQL_READALL= "SELECT *FROM movie(1)";

private static final conexion con =conexion.conectar();


    @Override
    public boolean create(pelicula g) {
        PreparedStatement ps;
        try{
            ps= con.getCnx().prepareStatement(SQL_INSERT);
            ps.setString(1,g.getNombre());
            ps.setInt(2,g.getAnio());
            ps.setString(3,g.getDirector());
            ps.setString(4,g.getPais());
            ps.setString(5,g.getClasificacion());
            ps.setBoolean(6, true);
            if (ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(peliculadao.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }        

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try{
            ps=con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            
            if (ps.executeUpdate() >0){
                return true;
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(peliculadao.class.getName()).log(Level.SEVERE,null, ex);
        } finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(pelicula c) {
        PreparedStatement ps;
        try{
            System.out.println(c.getNombre());
            ps = con.getCnx().prepareStatement(SQL_UPDATE);
            ps.setBoolean(6,c.isDisponible());
            if (ps.executeUpdate()>0){
                
            }
        }
    }

    @Override
    public pelicula read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<pelicula> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
