/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneoTenis_Vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import torneoTenis_Data.EncuentrosData;
import torneotenis.Conectar;
import torneotenis.Encuentros;

/**
 *
 * @author Administrador
 */
public class VistaFuturosEncuentros extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel();
    private EncuentrosData enc;
    private Conectar conn;

    /**
     * Creates new form VistaFuturosEncuentros
     */
    public VistaFuturosEncuentros() {
        initComponents();
        conn = new Conectar();
        enc = new EncuentrosData(conn);
        armarCabeceraTabla();
        cargarDatos();
    }
     public void armarCabeceraTabla() {
        jtEncFut.getTableHeader().setReorderingAllowed(false);
        
        ArrayList<Object> columnas = new ArrayList<Object>();
        
        columnas.add("ID");
        columnas.add("Fecha");
        columnas.add("Jugador 1");
        columnas.add("Jugador 2");
        
        for (Object it: columnas) {
            modelo.addColumn(it);
        }
        jtEncFut.setModel(modelo);
    }
     
      public void cargarDatos() {
       
        List<Encuentros> lista = enc.listaDeEncuentrosFuturos();
        for (Encuentros e: lista){
            modelo.addRow(new Object[] {e.getId_encuentro(), e.getFechaEnc(), e.getJugador1(), e.getJugador2()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtEncFut = new javax.swing.JTable();
        jlTitulo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jtEncFut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtEncFut);

        jlTitulo.setText("Futuros Encuentros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTable jtEncFut;
    // End of variables declaration//GEN-END:variables
}
