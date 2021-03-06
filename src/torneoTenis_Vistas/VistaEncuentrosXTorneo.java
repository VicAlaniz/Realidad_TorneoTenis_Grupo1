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
import torneoTenis_Data.TorneoData;
import torneotenis.Conectar;
import torneotenis.Encuentros;
import torneotenis.Torneo;

/**
 *
 * @author Administrador
 */
public class VistaEncuentrosXTorneo extends javax.swing.JInternalFrame {
      private DefaultTableModel modelo = new DefaultTableModel();
    private EncuentrosData enc;
    private Conectar conn;
     private TorneoData tor;
    private ArrayList<Torneo> listaTorneos;

    /**
     * Creates new form VistaEncuentrosXTorneo
     */
    public VistaEncuentrosXTorneo() {
        initComponents();
        initComponents();
        conn = new Conectar();
        enc = new EncuentrosData(conn);
         tor = new TorneoData(conn);
        Torneo t = new Torneo();
        listaTorneos = (ArrayList) tor.listaDeTorneos();
        armarCabeceraTabla();
        cargarTorneos();
    }
    
      public void armarCabeceraTabla() {
        jtEnc.getTableHeader().setReorderingAllowed(false);
        
        ArrayList<Object> columnas = new ArrayList<Object>();
        
        columnas.add("ID");
        columnas.add("Fecha");
        columnas.add("Jugador 1");
        columnas.add("Jugador 2");
        
        for (Object it: columnas) {
            modelo.addColumn(it);
        }
        jtEnc.setModel(modelo);
    }
      public void cargarTorneos() {
        
        for(Torneo item: listaTorneos) {
            jcbTorneo.addItem(item);
        }
    }
    public void borrarFilasTabla() {
        int a = modelo.getRowCount()-1;
        
        for(int i=a; i>=0; i--) {
            modelo.removeRow(i);
        }
    }
     
      public void cargarDatos() {
        borrarFilasTabla();
        Torneo t = (Torneo)jcbTorneo.getSelectedItem();
        List<Encuentros> lista = enc.listaEncuentrosXTorneo(t.getId_torneo());
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

        jlTitulo = new javax.swing.JLabel();
        jcbTorneo = new javax.swing.JComboBox<>();
        jlTorneo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEnc = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jlTitulo.setText("Encuentros por Torneo");

        jcbTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTorneoActionPerformed(evt);
            }
        });

        jlTorneo.setText("Torneo:");

        jtEnc.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtEnc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jlTitulo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jlTorneo)
                                .addGap(18, 18, 18)
                                .addComponent(jcbTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jlTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTorneo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTorneoActionPerformed
        // TODO add your handling code here:
        cargarDatos();
    }//GEN-LAST:event_jcbTorneoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Torneo> jcbTorneo;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlTorneo;
    private javax.swing.JTable jtEnc;
    // End of variables declaration//GEN-END:variables
}
