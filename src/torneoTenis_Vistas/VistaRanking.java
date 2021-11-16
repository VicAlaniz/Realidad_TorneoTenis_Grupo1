/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneoTenis_Vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import torneoTenis_Data.TorneoData;
import torneotenis.Conectar;
import torneotenis.Jugador;
import torneotenis.Resultado;
import torneotenis.Torneo;

/**
 *
 * @author Familia
 */
public class VistaRanking extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private TorneoData torneoData;
    private Conectar conn;
    private ArrayList<Jugador> listaJugadores;
    /**
     * Creates new form VistaRanking
     */
    public VistaRanking() {
        initComponents();
          
        conn = new Conectar();
        torneoData = new TorneoData(conn);
        
        armarCabeceraTabla();
        cargarDatos();
    }
    
     public void armarCabeceraTabla() {
        jtRanking.getTableHeader().setReorderingAllowed(false);
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("Id");
        columnas.add("Nombre");
        columnas.add("Puntaje");
        for(Object it: columnas){
            modelo.addColumn(it);
        }
        jtRanking.setModel(modelo);
    }
    public void borrarFilas() {
        int a = modelo.getRowCount()-1;
        for (int i=a; i>=0; i--){
            modelo.removeRow(i);
        }
    }
    
    public void cargarTorneos(){
        List<Torneo> torneos = torneoData.listaDeTorneos();
        for(Torneo t: torneos){
            jcbTorneos.addItem(t);
        }
    }
    
    public void cargarDatos(){
        borrarFilas();
 
        Torneo t = (Torneo) jcbTorneos.getSelectedItem();
        
        List<Jugador> lista = torneoData.listaJugadoresXTorneo(t.getId_torneo());
        List<Resultado> res = torneoData.calcularRanking(t.getId_torneo());
        
        for (Jugador j: lista) {
            modelo.addRow(new Object[] {j.getId_jugador(), j.getNombreApellido()});
        }
        for (Resultado r: res){
            if (r.getTorneo().getId_torneo()==t.getId_torneo()){
            modelo.addRow(new Object[] {r.getTotal()});
        }}
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
        jtRanking = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jcbTorneos = new javax.swing.JComboBox<>();

        jtRanking.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtRanking);

        jLabel1.setText("Id Torneo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jcbTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(300, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(103, 103, 103)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(103, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Torneo> jcbTorneos;
    private javax.swing.JTable jtRanking;
    // End of variables declaration//GEN-END:variables
}
