/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
private static final String SQL_INSERT = "INSERT INTO movie(nombre,anio,director,pais,clasificacion,existencia) VALUES (?,?,?,?,?)";
private static final String SQL_UPDATE ="UPDATE movie SET existencia =? WHERE nombre=?";
private static final String SQL_DELETE = "DELETE FROM movie WHERE nombre=?";
private static final String SQL_READ = "SELECT *FROM movie WHERE nombre=?";
private static final String SQL_READALL= "SELECT *FROM movie";

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
                return true;
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(peliculadao.class.getName()).log(Level.SEVERE,null, ex);
        } finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public pelicula read(Object key) {
        pelicula p =null;
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps=con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1,key.toString());
            rs =ps.executeQuery();
            while(rs.next()){
                p= new pelicula(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getBoolean(6));
            }
            rs.close();
    } catch (SQLException ex){
        System.out.println(ex.getMessage());
        Logger.getLogger(peliculadao.class.getName()).log(Level.SEVERE,null, ex);
    } finally {
            con.cerrarConexion();
        }
        return p;
    }
    
    @Override
    public ArrayList<pelicula> readAll() {
        ArrayList<pelicula> all = new ArrayList();
        Statement s;
        ResultSet rs;
        try {
            s= con.getCnx().prepareStatement(SQL_READALL);
            rs = s.executeQuery(SQL_READALL);
            while(rs.next()){
                all.add(new pelicula(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getBoolean(6)));
            }
            rs.close();
        } catch(SQLException ex){
            Logger.getLogger(peliculadao.class.getName()).log(Level.SEVERE,null, ex);
        }
        return all;
    }
}
