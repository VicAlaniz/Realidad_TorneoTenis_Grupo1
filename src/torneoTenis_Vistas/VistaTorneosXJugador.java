/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneoTenis_Vistas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import torneoTenis_Data.EncuentrosData;
import torneoTenis_Data.JugadorData;
import torneoTenis_Data.TorneoData;
import torneotenis.Conectar;
import torneotenis.Jugador;
import torneotenis.Torneo;

/**
 *
 * @author Administrador
 */
public class VistaTorneosXJugador extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modelo = new DefaultTableModel();
    private EncuentrosData enc;
    private TorneoData tor;
    private JugadorData jugador;
    private Conectar conn;
    private ArrayList<Torneo> listaTorneos;
    private ArrayList<Jugador> listaJugadores;

    /**
     * Creates new form VistaTorneosXJugador
     */
    public VistaTorneosXJugador() {
        initComponents();
        conn = new Conectar();
        enc = new EncuentrosData(conn);
        tor = new TorneoData(conn);
        jugador = new JugadorData(conn);
        Torneo t = new Torneo();
        listaJugadores = (ArrayList) jugador.listaDeJugadores();

        
        armarCabeceraTabla();
        cargarJugadores();
    }
    
      public void armarCabeceraTabla() {
        jtTorneos.getTableHeader().setReorderingAllowed(false);
        
        ArrayList<Object> columnas = new ArrayList<Object>();
        
        columnas.add("ID");
        columnas.add("Nombre");

        
        for (Object it: columnas) {
            modelo.addColumn(it);
        }
        jtTorneos.setModel(modelo);
    }
    
    public void cargarJugadores() {
        
        for(Jugador item: listaJugadores) {
            jcbJugador.addItem(item);
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
        
        Jugador j = (Jugador)jcbJugador.getSelectedItem();
        listaTorneos = (ArrayList)tor.listaTorneosXJugador(j.getId_jugador());

        for (Torneo t: listaTorneos){
            modelo.addRow(new Object[] {t.getId_torneo(), t.getNombre()});
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
        jtTorneos = new javax.swing.JTable();
        jcbJugador = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jtTorneos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtTorneos);

        jcbJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbJugadorActionPerformed(evt);
            }
        });

        jLabel1.setText("Jugador");

        jLabel2.setText("Torneos por Jugador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbJugadorActionPerformed
        // TODO add your handling code here:
        cargarDatos();
    }//GEN-LAST:event_jcbJugadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Jugador> jcbJugador;
    private javax.swing.JTable jtTorneos;
    // End of variables declaration//GEN-END:variables
}
