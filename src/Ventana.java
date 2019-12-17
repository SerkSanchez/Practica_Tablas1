import Paneles.PestaniaAltas;
import Paneles.PestaniaBajas;
import Paneles.PestaniaModificaciones;
import Paneles.PestaniaResumen;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    Container container;
    PestaniaAltas pestaniaAltas;
    PestaniaBajas pestaniaBajas;
    PestaniaModificaciones pestaniaModificaciones;
    PestaniaResumen pestaniaResumen;

    JTabbedPane panelPestanias;

    public void initGUI()
    {
        instancias();
        configurarContainer();
        setTitle("Ejercicio de Tablas");
        setSize(new Dimension(400, 400));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void configurarContainer() {
        //this.add(pestana);
        container.add(panelPestanias);

        //Agregar pestañas
        panelPestanias.addTab("Altas", pestaniaAltas); //Titulo, Icono, Tip
        panelPestanias.addTab("Bajas", pestaniaBajas); //Titulo, Icono, Tip
        panelPestanias.addTab("Modificaciones", pestaniaModificaciones); //Titulo, Icono, Tip
        panelPestanias.addTab("Resumen", pestaniaResumen); //Titulo, Icono, Tip
    }

    private void instancias() {
        container = getContentPane();

        pestaniaAltas = new PestaniaAltas();
        pestaniaBajas = new PestaniaBajas();
        pestaniaModificaciones = new PestaniaModificaciones();
        pestaniaResumen = new PestaniaResumen();

        panelPestanias = new JTabbedPane(SwingConstants.TOP);
    }
}
