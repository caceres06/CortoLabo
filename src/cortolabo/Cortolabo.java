/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cortolabo;

import dao.peliculadao;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.pelicula;

/**
 *
 * @author Mabel
 */
public class Cortolabo {

    public JLabel lblnombre, lblanio,lbldirector,lblpais, lblclasificacion,lblexistencia;
    public JTextField nombre, anio, director,pais;
    public JComboBox clasificacion;
    
    //ButtonGroup existencia = new ButtonGroup();
   // public JRadioButton si;
   // public JRadioButton no;
    public JRadioButton existencia;
    public JTable resultados;
    public JPanel table;
    public JButton agregar, borrar, actualizar, buscar;
    
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
       setSize(600,600);
       eventos();
    }
    public final void agregarLabels(){
        lblnombre= new JLabel("Nombre");
        lblanio= new JLabel("Anio");
        lbldirector= new JLabel("Director");
        lblpais= new JLabel("País");
        lblclasificacion= new JLabel("Clasificacion");
        lblexistencia= new JLabel("Existecia");
        lblnombre.setBounds(10,10,ANCHOC, ALTOC);
        lblanio.setBounds(10,40,ANCHOC, ALTOC);
        lbldirector.setBounds(10,80,ANCHOC, ALTOC);
        lblpais.setBounds(10,120,ANCHOC, ALTOC);
        lblclasificacion.setBounds(10,160,ANCHOC, ALTOC);
        lblexistencia.setBounds(10,200,ANCHOC, ALTOC);
        resultados = new JTable();
    }
    public final void proyeccion(){
        nombre= new JTextField();
        director= new JTextField();
        pais= new JTextField();
        anio= new JTextField();
        clasificacion= new JComboBox();
        existencia = new JRadioButton();
        agregar= new JButton("Agregar");
        buscar= new JButton("Buscar");
        actualizar= new JButton("Actualizar");
        borrar= new JButton("Borrar");
        table = new JPanel();
        
        clasificacion.addItem("G");
        clasificacion.addItem("PG");
        clasificacion.addItem("14A");
        clasificacion.addItem("18A");
        clasificacion.addItem("R");
        clasificacion.addItem("A");
        
        nombre.setBounds(140,10,ANCHOC,ALTOC);
        director.setBounds(140,80,ANCHOC,ALTOC);
        pais.setBounds(140,120,ANCHOC,ALTOC);
        anio.setBounds(140,40,ANCHOC,ALTOC);
        clasificacion.setBounds(140,160,ANCHOC,ALTOC);
        existencia.setBounds(140,200,ANCHOC,ALTOC);
        
        agregar.setBounds(300,10,ANCHOC,ALTOC);
        buscar.setBounds(10,210,ANCHOC,ALTOC);
        actualizar.setBounds(150,210,ANCHOC,ALTOC);
        borrar.setBounds(300,210,ANCHOC,ALTOC);
        resultados = new JTable();
        table.setBounds(10,250,500,200);
        table.add(new JScrollPane(resultados));
    }
    public void llenarTabla(){
        tm = new DefaultTableModel(){
           public Class<?> getColumnClass(int column){
               switch(column){
                   case 0:
                       return String.class;
                   case 1:
                       return String.class;
                   case 2:
                       return String.class;
                   case 3:
                       return String.class;
                   case 4:
                       return String.class;
                   case 5:
                       return Integer.class;
                   case 6:
                       return Boolean.class;
               }
               return null;
           } 
        };
        tm.addColumn("Nombre");
        tm.addColumn("Director");
        tm.addColumn("País");
        tm.addColumn("Clasificacion");
        tm.addColumn("Año");
        tm.addColumn("En Proyección");
        peliculadao pd = new peliculadao();
        ArrayList<pelicula> pelicula = pd.readAll();
        
        for (pelicula pe: pelicula){
            tm.addRow(new Object[]{pe.getNombre(),pe.getDirector(),pe.getPais(),pe.getClasificacion(),pe.getAnio(),pe.isDisponible()});
        }
        
        resultados.setModel(tm);
    }
    public void eventos(){
        agregar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                peliculadao pd = new peliculadao();
                pelicula p = new pelicula(nombre.getText(),Integer.parseInt(anio.getText()),director.getText(),pais.getText(),clasificacion.getSelectedItem().toString(),true);  
                
                if (existencia.isSelected()){
                    p.setDisponible(true);
                }
                if (pd.create(p)){
                    JOptionPane.showMessageDialog(null, "Pelicula registrada con exito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problem al momento de agregar el filtro");
                }
            }
            
        });
        
        actualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               peliculadao pd = new peliculadao();
                pelicula p = new pelicula(nombre.getText(),Integer.parseInt(anio.getText()),director.getText(),pais.getText(),clasificacion.getSelectedItem().toString(),true);
                
                if(existencia.isSelected()){
                    p.setDisponible(true);
                }
               if (pd.update(p)){
                    JOptionPane.showMessageDialog(null, "Pelicula modificada con exito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problem al momento de modificar el filtro");
                }
            }
            
        });
        
        borrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                peliculadao pd = new peliculadao();
                if(pd.delete(nombre.getText())){
                    JOptionPane.showMessageDialog(null, "Pelicula eliminada con exito");
                    limpiarCampos();
                    llenarTabla();
                } else{
                    JOptionPane.showMessageDialog(null, "Ocurrio un problem al momento de eliminar el filtro");
                }
            }
        });
        
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peliculadao pd = new peliculadao();
                pelicula p = pd.read(nombre.getText());
               if ( p==null){
                   JOptionPane.showMessageDialog(null, "La pelicula buscada no se ha encontrado");
               } else {
               director.setText("");
               clasificacion.setSelectedItem("G");
               pais.setText("");
               }
            }
        });
 
 }
    public void limpiarCampos(){
        nombre.setText("");
        clasificacion.setSelectedItem("G");
        existencia.setText("");    
    }
              
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater((new Runnable(){
            @Override
            public void run(){
                new Cortolabo().setVisible(true);
            }
        }));
    }
}
