package modelo;

import utils.Persona;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class modeloTabla extends AbstractTableModel {

    ArrayList<Persona> datoslista;

    private String[] columnas;
    private Class[] tipos = {String.class, String.class, String.class, Integer.class, Integer.class, String.class, Integer.class};
    public modeloTabla(ArrayList<Persona> datoslista) {
        this.datoslista = datoslista;
        this.columnas = new String[]{"Nombre", "Apellido", "Calle", "Clave", "Edad", "Numero", "Codigo Postal"};
    }


    @Override
    public int getRowCount() {
        return datoslista.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona actual= datoslista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return actual.getClave();
            case 1:
                return actual.getNombre();
            case 2:
                return actual.getApellido();
            case 3:
                return actual.getEdad();
            case 4:
                return actual.getNumero();
            case 5:
                return actual.getCalle();
            case 6:
                return actual.getCodigoPostal();
            default:
                return null;
        }
    }

    public void addDatos(Persona persona){
        datoslista.add(persona);
        fireTableDataChanged();
    }

    public void removeDatos(int index){
        datoslista.remove(index);
        fireTableDataChanged();
    }

    public Persona getPersona(int index){
        Persona encontrada = datoslista.get(index);
        return encontrada;
    }

    public Persona personaSeleccionada(int index){
        return datoslista.get(index);
    }

    public Persona[] getPersonaMultiple(int[] index){
        Persona[] personas= new Persona[index.length];
        for (int i=0; i<index.length;i++){
            personas[i]=getPersona(i);
        }
        return personas;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return tipos[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
