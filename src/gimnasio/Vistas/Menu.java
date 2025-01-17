
package gimnasio.Vistas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        ImageIcon icon = new ImageIcon(getClass().getResource("/gimnasio/Imagenes/imagenFondo.jpg"));
        Image image = icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){     public void paintComponent(Graphics g){         g.drawImage(image,0,0,getWidth(),getHeight(),this);     } };
        ImageIcon icon02 = new ImageIcon(getClass().getResource("/gimnasio/Iconos/banda.jpg"));
        Image image02 = icon02.getImage();
        menuLateral = new javax.swing.JDesktopPane(){     public void paintComponent(Graphics g){         g.drawImage(image02,0,0,getWidth(),getHeight(),this);     } };
        jbMenuMembresia = new javax.swing.JButton();
        jbMenuSocio = new javax.swing.JButton();
        jbMenuClase = new javax.swing.JButton();
        jbMenuEntrenador = new javax.swing.JButton();
        jbMenuAsistencia = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmGestionMembresia = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmGestionSocio = new javax.swing.JMenuItem();
        jmMenuEntrenador = new javax.swing.JMenu();
        jmGestionEntrenador = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmGestionClase = new javax.swing.JMenuItem();
        jmMenuAsistencia = new javax.swing.JMenu();
        jmAsistencia = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmAbout = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GIMNASIO \"FITNESS GYM\" - Proyecto Final Laboratorio de Programación 1");

        escritorio.setPreferredSize(new java.awt.Dimension(1140, 840));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        menuLateral.setPreferredSize(new java.awt.Dimension(145, 840));

        jbMenuMembresia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gimnasio/Iconos/botonMembresia01.png"))); // NOI18N
        jbMenuMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenuMembresiaActionPerformed(evt);
            }
        });

        jbMenuSocio.setBackground(new java.awt.Color(0, 0, 0));
        jbMenuSocio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbMenuSocio.setForeground(new java.awt.Color(255, 255, 255));
        jbMenuSocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gimnasio/Iconos/botonSocio2.png"))); // NOI18N
        jbMenuSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenuSocioActionPerformed(evt);
            }
        });

        jbMenuClase.setBackground(new java.awt.Color(255, 255, 255));
        jbMenuClase.setForeground(new java.awt.Color(255, 255, 255));
        jbMenuClase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gimnasio/Iconos/botonClase.png"))); // NOI18N
        jbMenuClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenuClaseActionPerformed(evt);
            }
        });

        jbMenuEntrenador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gimnasio/Iconos/botonEntrenador.png"))); // NOI18N
        jbMenuEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenuEntrenadorActionPerformed(evt);
            }
        });

        jbMenuAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gimnasio/Iconos/botonAsistencia.png"))); // NOI18N
        jbMenuAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenuAsistenciaActionPerformed(evt);
            }
        });

        menuLateral.setLayer(jbMenuMembresia, javax.swing.JLayeredPane.DEFAULT_LAYER);
        menuLateral.setLayer(jbMenuSocio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        menuLateral.setLayer(jbMenuClase, javax.swing.JLayeredPane.DEFAULT_LAYER);
        menuLateral.setLayer(jbMenuEntrenador, javax.swing.JLayeredPane.DEFAULT_LAYER);
        menuLateral.setLayer(jbMenuAsistencia, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout menuLateralLayout = new javax.swing.GroupLayout(menuLateral);
        menuLateral.setLayout(menuLateralLayout);
        menuLateralLayout.setHorizontalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLateralLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbMenuAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbMenuEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbMenuClase, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbMenuSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbMenuMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        menuLateralLayout.setVerticalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLateralLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jbMenuMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbMenuSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbMenuClase, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbMenuEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbMenuAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Membresia");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jmGestionMembresia.setText("Gestión Membresia");
        jmGestionMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionMembresiaActionPerformed(evt);
            }
        });
        jMenu1.add(jmGestionMembresia);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Socio");

        jmGestionSocio.setText("Gestión Socio");
        jmGestionSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionSocioActionPerformed(evt);
            }
        });
        jMenu4.add(jmGestionSocio);

        jMenuBar1.add(jMenu4);

        jmMenuEntrenador.setText("Entrenador");

        jmGestionEntrenador.setText("Gestión Entrenador");
        jmGestionEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionEntrenadorActionPerformed(evt);
            }
        });
        jmMenuEntrenador.add(jmGestionEntrenador);

        jMenuBar1.add(jmMenuEntrenador);

        jMenu3.setText("Clase");

        jmGestionClase.setText("Gestión Clase");
        jmGestionClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionClaseActionPerformed(evt);
            }
        });
        jMenu3.add(jmGestionClase);

        jMenuBar1.add(jMenu3);

        jmMenuAsistencia.setText("Asistencia");

        jmAsistencia.setText("Formulario de Gestión de Asistencia");
        jmAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAsistenciaActionPerformed(evt);
            }
        });
        jmMenuAsistencia.add(jmAsistencia);

        jMenuBar1.add(jmMenuAsistencia);

        jMenu2.setText("Ayuda");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jmAbout.setText("About");
        jmAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAboutActionPerformed(evt);
            }
        });
        jMenu2.add(jmAbout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
            .addComponent(menuLateral)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jmGestionEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionEntrenadorActionPerformed
        // TODO add your handling code here:
        mostrarPestaña(new FormEntrenador());
    }//GEN-LAST:event_jmGestionEntrenadorActionPerformed

    private void jmGestionSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionSocioActionPerformed
        // TODO add your handling code here:
         mostrarPestaña(new FormSocio());
    }//GEN-LAST:event_jmGestionSocioActionPerformed

    private void jmGestionMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionMembresiaActionPerformed
        // TODO add your handling code here:
        mostrarPestaña(new FormMembresia());
    }//GEN-LAST:event_jmGestionMembresiaActionPerformed

    private void jmGestionClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionClaseActionPerformed
        // TODO add your handling code here:
         mostrarPestaña(new FormClase());
    }//GEN-LAST:event_jmGestionClaseActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jmAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAboutActionPerformed
        // TODO add your handling code here:
         JOptionPane.showMessageDialog(null, "Product Version: Gimnasio Version 1.00.01 \nAutor: Javier Martin\nAll rights reserved\nCopyright\nSite Under Construction...");
    }//GEN-LAST:event_jmAboutActionPerformed

    private void jmAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAsistenciaActionPerformed
        // TODO add your handling code here:
         mostrarPestaña(new FormAsistencia());
    }//GEN-LAST:event_jmAsistenciaActionPerformed

    private void jbMenuMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenuMembresiaActionPerformed
        mostrarPestaña(new FormMembresia());
    }//GEN-LAST:event_jbMenuMembresiaActionPerformed

    private void jbMenuSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenuSocioActionPerformed
        mostrarPestaña(new FormSocio());
    }//GEN-LAST:event_jbMenuSocioActionPerformed

    private void jbMenuClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenuClaseActionPerformed
         mostrarPestaña(new FormClase());
    }//GEN-LAST:event_jbMenuClaseActionPerformed

    private void jbMenuEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenuEntrenadorActionPerformed
        mostrarPestaña(new FormEntrenador());
    }//GEN-LAST:event_jbMenuEntrenadorActionPerformed

    private void jbMenuAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenuAsistenciaActionPerformed
         mostrarPestaña(new FormAsistencia());
    }//GEN-LAST:event_jbMenuAsistenciaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JButton jbMenuAsistencia;
    private javax.swing.JButton jbMenuClase;
    private javax.swing.JButton jbMenuEntrenador;
    private javax.swing.JButton jbMenuMembresia;
    private javax.swing.JButton jbMenuSocio;
    private javax.swing.JMenuItem jmAbout;
    private javax.swing.JMenuItem jmAsistencia;
    private javax.swing.JMenuItem jmGestionClase;
    private javax.swing.JMenuItem jmGestionEntrenador;
    private javax.swing.JMenuItem jmGestionMembresia;
    private javax.swing.JMenuItem jmGestionSocio;
    private javax.swing.JMenu jmMenuAsistencia;
    private javax.swing.JMenu jmMenuEntrenador;
    private javax.swing.JDesktopPane menuLateral;
    // End of variables declaration//GEN-END:variables
    private void mostrarPestaña(JInternalFrame x) {
        escritorio.removeAll();
        escritorio.repaint();
        JInternalFrame lpr;        
        x.setVisible(true);
        escritorio.add(x);
    }
    
    }