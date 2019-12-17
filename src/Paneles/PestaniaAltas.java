package Paneles;

import utils.Persona;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PestaniaAltas extends JPanel implements ActionListener {
    JLabel txtClave, txtNombre, txtApellido, txtEdad, txtCalle, txtNumero, txtCP;
    JTextField etiqClave, etiqNombre, etiqApellido, etiqEdad;
    JTextArea taCalle, taNumero, taCP;
    JButton btnAlta;

    TitledBorder borderDatosPersonales, borderDireccion;

    JPanel panelSuperior, panelInferior, panelCentro;

    public PestaniaAltas() {
        initGUI();
    }

    public void initGUI() {
        instancias();
        configurarContainer();
        acciones();
    }

    private void instancias() {
        txtClave = new JLabel("Clave:");
        txtNombre = new JLabel("Nombre:");
        txtApellido = new JLabel("Apellidos:");
        txtEdad = new JLabel("Edad:");
        txtCalle = new JLabel("Calle: ");
        txtNumero = new JLabel("Número: ");
        txtCP = new JLabel("Codigo Postal: ");

        etiqClave = new JTextField();
        etiqNombre = new JTextField();
        etiqApellido = new JTextField();
        etiqEdad = new JTextField();

        taCalle = new JTextArea();
        taNumero = new JTextArea();
        taCP = new JTextArea();

        borderDatosPersonales = new TitledBorder("Datos Personales");
        borderDireccion = new TitledBorder("Direccion");

        btnAlta = new JButton("Dar de Alta");

        panelInferior = new JPanel();
        panelSuperior = new JPanel();
        panelCentro = new JPanel();
    }

    private void configurarContainer() {
        this.setLayout(new BorderLayout());
        this.add(configurarSuperior(), BorderLayout.NORTH);
        this.add(configurarCentro(), BorderLayout.CENTER);
        this.add(configurarInferior(), BorderLayout.SOUTH);
    }

    private JPanel configurarInferior() {
        panelInferior.add(btnAlta);
        return panelInferior;
    }

    private JPanel configurarCentro() {
        panelCentro.setLayout(new GridLayout(3, 2, 40, 10));
        panelCentro.setBorder(borderDireccion);
        panelCentro.add(txtCalle);
        panelCentro.add(taCalle);
        panelCentro.add(txtNumero);
        panelCentro.add(taNumero);
        panelCentro.add(txtCP);
        panelCentro.add(taCP);
        panelCentro.add(configurarInferior(), BorderLayout.SOUTH);
        return panelCentro;
    }

    private JPanel configurarSuperior() {
        panelSuperior.setLayout(new GridLayout(4, 2, 40, 5));
        panelSuperior.setBorder(borderDatosPersonales);
        panelSuperior.add(txtClave);
        panelSuperior.add(etiqClave);
        panelSuperior.add(txtNombre);
        panelSuperior.add(etiqNombre);
        panelSuperior.add(txtApellido);
        panelSuperior.add(etiqApellido);
        panelSuperior.add(txtEdad);
        panelSuperior.add(etiqEdad);
        return panelSuperior;
    }

    private void acciones() {
        btnAlta.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAlta) {
            if (etiqClave.getText().isEmpty() ||
                    etiqNombre.getText().isEmpty() ||
                    etiqApellido.getText().isEmpty() ||
                    etiqEdad.getText().isEmpty() ||
                    taCalle.getText().isEmpty() ||
                    taNumero.getText().isEmpty() ||
                    taCP.getText().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Mensaje WARNING",
                        "El campo está vacío", JOptionPane.INFORMATION_MESSAGE, null);
            } else {
                String nombre = etiqNombre.getText();
                String apellido = etiqApellido.getText();
                String clave = etiqClave.getText();
                String calle = taCalle.getText();
                int numero = Integer.valueOf(taNumero.getText());
                int edad = Integer.valueOf(etiqEdad.getText());
                int cp = Integer.valueOf(taCP.getText());

                //panel2.getModelo().addElement(new Persona(clave, nombre, apellido, calle, edad, numero, cp));
                //panel3.getModelo().addElement(new Persona(clave, nombre, apellido, calle, edad, numero, cp));
                //panel4.getModelo().addElement(new Persona(clave, nombre, apellido, calle, edad, numero, cp));
            }
        }
    }
}
