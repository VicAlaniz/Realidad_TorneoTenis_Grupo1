/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneoTenis_Vistas;

import javax.swing.JOptionPane;
import torneoTenis_Data.PatrocinioData;
import torneoTenis_Data.SponsorData;
import torneotenis.Conectar;
import torneotenis.Patrocinio;
import torneotenis.Sponsor;

/**
 *
 * @author Familia
 */
public class VistaSponsorPatrocinio extends javax.swing.JInternalFrame {
    private SponsorData sponsorData;
    private PatrocinioData patrocinioData;
    private Conectar conn;

    /**
     * Creates new form VistaSponsorPatrocinio
     */
    public VistaSponsorPatrocinio() {
        initComponents();
        conn = new Conectar();
        sponsorData = new SponsorData(conn);
        patrocinioData = new PatrocinioData(conn);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtIdSpon = new javax.swing.JTextField();
        jtMarca = new javax.swing.JTextField();
        jtIndumentaria = new javax.swing.JTextField();
        jchbActivo = new javax.swing.JCheckBox();
        jbGuardarSpon = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbEliminarSpon = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcbJugador = new javax.swing.JComboBox<>();
        jtIdPat = new javax.swing.JTextField();
        jcbSponsor = new javax.swing.JComboBox<>();
        jbBuscar = new javax.swing.JButton();
        jbGuardarPat = new javax.swing.JButton();
        jbEliminarPat = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jchbActivoP = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("SPONSOR");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("PATROCINIO");

        jLabel3.setText("ID Sponsor:");

        jLabel4.setText("Marca:");

        jLabel5.setText("Indumentaria:");

        jLabel6.setText("Activo");

        jbGuardarSpon.setText("Guardar");
        jbGuardarSpon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarSponActionPerformed(evt);
            }
        });

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbEliminarSpon.setText("Eliminar");
        jbEliminarSpon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarSponActionPerformed(evt);
            }
        });

        jLabel7.setText("ID Patrocinio:");

        jLabel8.setText("Sponsor:");

        jLabel9.setText("Jugador:");

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbGuardarPat.setText("Guardar");
        jbGuardarPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarPatActionPerformed(evt);
            }
        });

        jbEliminarPat.setText("Eliminar");
        jbEliminarPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarPatActionPerformed(evt);
            }
        });

        jLabel10.setText("Activo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jtIdSpon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jchbActivo)
                                    .addComponent(jtIndumentaria))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jtIdPat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(jbBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jcbJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbSponsor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jchbActivoP))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jbGuardarSpon, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbEliminarSpon, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbActualizar))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbGuardarPat)
                        .addGap(72, 72, 72)
                        .addComponent(jbEliminarPat)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtIdSpon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jtIdPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jcbSponsor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtIndumentaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jchbActivo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jchbActivoP))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jbGuardarSpon)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbGuardarPat)
                            .addComponent(jbEliminarPat))
                        .addGap(1, 1, 1)))
                .addComponent(jbActualizar)
                .addGap(18, 18, 18)
                .addComponent(jbEliminarSpon)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarSponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarSponActionPerformed
        // TODO add your handling code here:
        String marca = jtMarca.getText();
        String indumentaria = jtIndumentaria.getText();
        boolean activo=jchbActivo.isEnabled();
        
        Sponsor sponsor = new Sponsor(marca, indumentaria, activo);
        sponsorData.guardarSponsor(sponsor);
        jtIdSpon.setText(sponsor.getId_sponsor()+"");
        
    }//GEN-LAST:event_jbGuardarSponActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
        if(jtIdSpon.getText()!=null){
            int id_sponsor=Integer.parseInt(jtIdSpon.getText());
            String marca = jtMarca.getText();
            String indumentaria = jtIndumentaria.getText();
            boolean activo = jchbActivo.isEnabled();
        
            Sponsor sponsor = new Sponsor(id_sponsor, marca, indumentaria, activo);
            sponsorData.actualizarSponsor(sponsor);
        }else{
            JOptionPane.showMessageDialog(this,"No se encontraron datos");
        }
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbEliminarSponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarSponActionPerformed
        // TODO add your handling code here:
        int id_sponsor = Integer.parseInt(jtIdSpon.getText());
        sponsorData.borrarSponsor(id_sponsor);
    }//GEN-LAST:event_jbEliminarSponActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
        int id_patrocinio = Integer.parseInt(jtIdPat.getText());
        Patrocinio patrocinio = patrocinioData.obtenerPatrocinioXJugador(id);
      
        
        if(patrocinio != null){
            jtIdPat.setText(patrocinio.getId_patrocinio()+"");
            jcbSponsor.setSelectedItem(patrocinio.getSponsor()+"");
            jcbJugador.setSelectedItem(patrocinio.getJugador()+"");
            jchbActivo.setSelected(patrocinio.isActivo());
        }else{
            JOptionPane.showMessageDialog(this,"No se encontraron datos");
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbGuardarPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarPatActionPerformed
        // TODO add your handling code here:
        String Sponsor = (String) jcbSponsor.getSelectedItem();
        String Jugador = (String) jcbJugador.getSelectedItem();
        boolean activo = jchbActivoP.isEnabled();
        
        Patrocinio patrocinio = new Patrocinio(id_patrocinio, sponsor, jugador);
        patrocinioData.guardarPatrocinio(patrocinio);
        jtIdPat.setText(patrocinio.getId_patrocinio()+"");
        
    }//GEN-LAST:event_jbGuardarPatActionPerformed

    private void jbEliminarPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarPatActionPerformed
        // TODO add your handling code here:
        int id_patrocinio = Integer.parseInt(jtIdPat.getText());
        patrocinioData.borrarPatrocinio(id_patrocinio, ERROR);
    }//GEN-LAST:event_jbEliminarPatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminarPat;
    private javax.swing.JButton jbEliminarSpon;
    private javax.swing.JButton jbGuardarPat;
    private javax.swing.JButton jbGuardarSpon;
    private javax.swing.JComboBox<String> jcbJugador;
    private javax.swing.JComboBox<String> jcbSponsor;
    private javax.swing.JCheckBox jchbActivo;
    private javax.swing.JCheckBox jchbActivoP;
    private javax.swing.JTextField jtIdPat;
    private javax.swing.JTextField jtIdSpon;
    private javax.swing.JTextField jtIndumentaria;
    private javax.swing.JTextField jtMarca;
    // End of variables declaration//GEN-END:variables
}
