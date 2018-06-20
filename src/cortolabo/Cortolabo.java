/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cortolabo;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Mabel
 */
public class Cortolabo {

    public JLabel lblnombre, lblanio,lbldirector,lblpais, lblclasificacion,lblexistencia;
    public JTextField nombre, anio, director,pais;
    public JComboBox clasificaion;
    
    ButtonGroup existencia = new ButtonGroup();
    public JRadioButton si;
    public JRadioButton no;
    
    public JButton Agregar, Borrar, Actualizar, Buscar;
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
