
package desafio;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 * Modelo de datos para la tabla del catálogo de películas.
 */
public class ModeloCatalogo extends AbstractTableModel {
    
   
    // Definir las columnas de la tabla
    private final String[] columnNames = {"Título"};

    // Definir los tipos de datos para cada columna
    private final Class<?>[] columnTypes = {String.class};

    // Definir los datos de la tabla (esto puede ser una lista de películas)
    private Object[][] data;

    /* Constructor */

    /**
     *
     * @param data
     */

    public ModeloCatalogo(Object[][] data) {
        this.data = data;
    }
    
    /* Método que actualiza los datos mostrados en la tabla */

    /**
     *
     * @param newData
     */

    public void setData(Object[][] newData) {
        this.data = newData;
        fireTableDataChanged();
    }

    /* Métodos para obtener información sobre la tabla */

    /**
     *
     * @return
     */

    @Override
    public int getRowCount() {
        return data.length;
    }

    /**
     *
     * @return
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    /* Métodos para obtener información sobre las columnas */

    /**
     *
     * @param column
     * @return
     */

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     *
     * @param columnIndex
     * @return
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnTypes[columnIndex];
    }

    /* Método para permitir o no la edición de celdas (en este caso, no permitimos la edición) */

    /**
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


    
}
