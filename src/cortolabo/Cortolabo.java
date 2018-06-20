/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cortolabo;

import java.awt.Container;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mabel
 */
public class Cortolabo {

    public JLabel lblnombre, lblanio,lbldirector,lblpais, lblclasificacion,lblexistencia;
    public JTextField nombre, anio, director,pais;
    public JComboBox clasificacion;
    
    ButtonGroup existencia = new ButtonGroup();
    public JRadioButton si;
    public JRadioButton no;
    
    public JButton Agregar, Borrar, Actualizar, Buscar;
    
    private static final int ANCHOC = 160, ALTOC=40;
    
    DefaultTableModel tm;
    
    public Cortolabo(){
       super("Cine");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(null);
       agregarLabels();
       proyeccion();
       llenarTabla();
       Container container = getContetPane();
       container.add(lblnombre);
       container.add(lblanio);
       container.add(lbldirector);
       container.add(lblpais);
       container.add(lblclasificacion);
       container.add(lblexistencia);
       container.add(nombre);
       container.add(anio);
       container.add(director);
       container.add(pais);
       container.add(clasificacion);
       container.add(existencia);
       container.add(lblnombre);
       
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
