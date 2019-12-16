package Paneles;

import utils.Persona;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PestaniaBajas extends JPanel implements ActionListener {
    JLabel txtClave, txtNombre, txtApellidos, txtEdad, txtCalle, txtNumero, txtCP;
    JTextField  etiqNombre, etiqapellido, etiqEdad;
    JTextArea taCalle, taNumero, taCP;
    JButton btnBaja;

    TitledBorder borderDatosPersonales, borderDireccion, borderSeleccionClave;

    JComboBox comboClave;
    DefaultComboBoxModel modeloCombo;

    JPanel panelclave,panelInferior,panelCentro,panelSuperior;

    public PestaniaBajas() {
        initGUI();
    }

    public void initGUI(){
        instancias();
        configurarModeloCombo();
        configurarPanel();
    }

    private void configurarModeloCombo() {
        modeloCombo.addElement(new Persona("Sergio","Sanchez","Vallepardo",
                "okey",25,16,28229));

        modeloCombo.addElement(new Persona("Santi","Gala","Palomo",
                "chao",23,24,28400));
    }

    public void configurarConstraint(int posX, int posY,int fill, int anchor
            ,double pesX, double pesY, int tamX, int tamY, JComponent component) {
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
                0.3,0.3,1,1,configurarPanelClave());
        configurarConstraint(0,1,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,
                0.3,0.3,1,1,configurarPanelArriba());
        configurarConstraint(0,2,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,
                0.3,0.3,1,1,configurarPanelCentro());
        configurarConstraint(0,3,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,
                0,0,1,1,configurarPanelAbajo());
    }

    private JPanel configurarPanelAbajo(){
        panelInferior.add(btnBaja);
        return panelInferior;
    }

    private JPanel configurarPanelCentro() {
        panelCentro.setBorder(BorderFactory.createTitledBorder("Dirección"));
        panelCentro.setLayout(new GridLayout(3,2,5,5));
        panelCentro.add(txtCalle);
        panelCentro.add(taCalle);
        panelCentro.add(txtNumero);
        panelCentro.add(taNumero);
        panelCentro.add(txtCP);
        panelCentro.add(taCP);
        return panelCentro;
    }

    private JPanel configurarPanelArriba() {
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Datos personales"));
        panelSuperior.setLayout(new GridLayout(3,2,5,5));
        panelSuperior.add(txtNombre);
        panelSuperior.add(etiqNombre);
        panelSuperior.add(txtApellidos);
        panelSuperior.add(etiqapellido);
        panelSuperior.add(txtEdad);
        panelSuperior.add(etiqEdad);
        return panelSuperior;
    }

    private JPanel configurarPanelClave() {
        panelclave.setBorder(BorderFactory.createTitledBorder("Selección clave"));
        panelclave.setLayout(new GridLayout(1,2));
        panelclave.add(txtClave);
        panelclave.add(comboClave);
        return panelclave;
    }

    private void instancias() {
        modeloCombo = new DefaultComboBoxModel();
        comboClave = new JComboBox(modeloCombo);

        txtClave = new JLabel("Clave:");
        txtNombre = new JLabel("Nombre:");
        txtApellidos = new JLabel("Apellidos:");
        txtEdad = new JLabel("Edad:");
        txtCalle = new JLabel("Calle:");
        txtNumero = new JLabel("Número:");
        txtCP = new JLabel("Codigo Postal:");

        etiqNombre = new JTextField();
        etiqapellido = new JTextField();
        etiqEdad = new JTextField();

        taCalle = new JTextArea();
        taNumero = new JTextArea();
        taCP = new JTextArea();

        borderSeleccionClave = new TitledBorder("Seleccion Clave");
        borderDatosPersonales = new TitledBorder("Datos Personales");
        borderDireccion = new TitledBorder("Direccion");

        btnBaja = new JButton("Dar de Baja");

        panelInferior = new JPanel();
        panelSuperior = new JPanel();
        panelclave = new JPanel();
        panelCentro = new JPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void añadirPersona(String clave) {
        System.out.println(clave);
        //modelocombobox.addElement(clave);
    }
}
