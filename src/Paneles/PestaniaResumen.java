package Paneles;

import utils.Persona;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PestaniaResumen extends JPanel implements ActionListener {
    JLabel txtClave, txtNombre, txtApellidos, txtEdad, txtCalle, txtNumero, txtCP;
    JTextField  etiqNombre, etiqClave, etiqApellido, etiqEdad, etiqCalle, etiqNumero, etiqCP;
    JButton btnAlta, btnBaja;

    TitledBorder borderDatos;

    JTable tabla;
    DefaultTableModel modeloTabla;

    JPanel panelTabla, panelInferior, panelCentro;

    public PestaniaResumen() {
        initGUI();
    }

    public void initGUI(){
        instancias();
        configurarPanel();
    }

    private void instancias() {

        txtClave = new JLabel("Nombre:");
        txtNombre = new JLabel("Clave");
        txtApellidos = new JLabel("Apellidos:");
        txtEdad = new JLabel("Edad:");
        txtCalle = new JLabel("Calle:");
        txtNumero = new JLabel("Número:");
        txtCP = new JLabel("Codigo Postal:");

        etiqClave = new JTextField();
        etiqNombre = new JTextField();
        etiqApellido = new JTextField();
        etiqEdad = new JTextField();
        etiqCalle = new JTextField();
        etiqNumero = new JTextField();
        etiqCP = new JTextField();

        btnAlta = new JButton("Dar de Alta");
        btnBaja = new JButton("Dar de Baja");

        borderDatos = new TitledBorder("Datos");

        tabla = new JTable(modeloTabla);

        panelCentro = new JPanel();
        panelInferior= new JPanel();
        panelTabla= new JPanel();
    }
    public void configurarConstraint(int posX, int posY,int fill, int anchor
            ,double pesX, double pesY, int tamX, int tamY, JComponent component){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = posY;
        constraints.fill = fill ;
        constraints.anchor= anchor;
        constraints.weightx = pesX;
        constraints.weighty = pesY;
        constraints.gridwidth= tamX;
        constraints.gridheight= tamY;
        add(component,constraints);
    }

    private void configurarPanel() {
        this.setLayout(new GridBagLayout());
        configurarConstraint(0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,
                0.3,0.3,1,1,configurarPanelTabla());
        configurarConstraint(0,1,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,
                0.3,0.3,1,1,configurarCentro());
        configurarConstraint(0,2,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,
                0.3,0.3,1,1,configurarInferior());

        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(tabla), BorderLayout.NORTH);
        this.add(configurarCentro(), BorderLayout.CENTER);
        this.add(configurarInferior(), BorderLayout.SOUTH);
    }

    private JPanel configurarPanelTabla() {
        String [] columnas =  {"Nombre", "Apellido", "Telefono"};
        Object [][] datosT = {   {"Nombre 1", "Apellido 1", 111},
                {"Nombre 2", "Apellido 2", 212},
                {"Nombre 3", "Apellido 3", 333}};

        modeloTabla = new DefaultTableModel(datosT, columnas);
        tabla = new JTable(modeloTabla);
        return panelTabla;
    }

    private JPanel configurarInferior() {
        panelInferior.add(btnAlta);
        panelInferior.add(btnBaja);
        return panelInferior;
    }

    private JPanel configurarCentro() {
        panelCentro.setLayout(new GridLayout(7,2,40,5));
        panelCentro.setBorder(borderDatos);
        panelCentro.add(txtClave);
        panelCentro.add(etiqClave);
        panelCentro.add(txtNombre);
        panelCentro.add(etiqNombre);
        panelCentro.add(txtApellidos);
        panelCentro.add(etiqApellido);
        panelCentro.add(txtEdad);
        panelCentro.add(etiqEdad);
        panelCentro.add(txtCalle);
        panelCentro.add(etiqCalle);
        panelCentro.add(txtNumero);
        panelCentro.add(etiqNumero);
        panelCentro.add(txtCP);
        panelCentro.add(etiqCP);
        return panelCentro;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAlta){
            String nombre = etiqNombre.getText();
            String apellido = etiqApellido.getText();
            String clave = etiqClave.getText();
            String calle = etiqCalle.getText();
            int numero = Integer.valueOf(etiqNumero.getText());
            int edad = Integer.valueOf(etiqEdad.getText());
            int cp = Integer.valueOf(etiqCP.getText());
        }else if (e.getSource() == btnBaja){
            if (tabla.getSelectedRow() !=1) {

            }
        }
    }
}
