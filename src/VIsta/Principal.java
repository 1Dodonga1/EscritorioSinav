/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIsta;

import Controlador.ConsultasSQLiteDB;
import Modelo.MateriasAlumno;
import VIsta.Materias;
import VIsta.Login;
import VIsta.PanelAlumno;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author Alma Cuevas
 */
public class Principal extends javax.swing.JFrame {

    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    Controlador.ConsultasDB conDB = new Controlador.ConsultasDB();
    Controlador.ConsultasSQLiteDB conSQLite = new Controlador.ConsultasSQLiteDB();
    Login PanelLogin = new Login();
    PanelAlumno panelAlumno = new PanelAlumno();
    PanelAlumno PA = new PanelAlumno();
    ArrayList<String> ListaDEid = new ArrayList<>();
    ArrayList<MateriasAlumno> ListaMaterias = new ArrayList<>();
    Materias mate = new Materias();

    public Principal() {
        inicio();
        elementodDeInicio();
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

        logo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logoP.png"))); // NOI18N
        logo.setText("jLabel1");

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondoPrin.jpg"))); // NOI18N
        fondo.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1279, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(logo))
            .addComponent(fondo)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    public void elementodDeInicio() {

        this.getContentPane().add(panelAlumno);
        this.getContentPane().add(PanelLogin);

        //evento de el boton salir de el panel principal
        panelAlumno.salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saliendo();
            }
        });

        ///panel login "editando el boton para logearse"
        PanelLogin.btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modelo.Usuarios usuario = null;
                try {
                    usuario = conSQLite.IniciarSecion(PanelLogin.returnTxtusuario(), PanelLogin.returnContaseña());
                } catch (SQLException ex) {
                    Logger.getLogger("ERROR EN EL EVENTO DE BTNENTRAR" + Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (usuario != null) {
                    try {
                        
                        //Obtener los IDmaterias 
                        ListaDEid = conSQLite.ObtenerIdMaterias(usuario.id);
                        //Materias
                        ListaMaterias = conSQLite.obtenerMaterias(ListaDEid);
                        panelAlumno.ListaDELasMaterias = ListaMaterias;
                        //Mandar a la Jlist
                        panelAlumno.RellenarLista(ListaMaterias);
                    } catch (Exception e3) {
                        System.out.println("HAY UN PROBLEMA EN LA PARTE DE CEREBRO PANEL ALUMNO" + e3);
                    }
                    Entro();
                } else {
                    JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTOS");
                }
            }
        });

        PanelLogin.btnAgregarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modelo.Usuarios usuario = null;

                try {
                    usuario = conSQLite.IniciarSecion(PanelLogin.returnTxtusuario(), PanelLogin.returnContaseña());
                } catch (SQLException ex) {
                    Logger.getLogger("ERROR EN EL EVENTO DE BTNAGREGARUSUARIO" + Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (usuario != null) {
                    JOptionPane.showMessageDialog(null, "EL USUARIO YA ESTA REGISTRADO");
                } else {

                    usuario = conDB.verificarUsuario(PanelLogin.returnTxtusuario(), PanelLogin.returnContaseña());

                    if (usuario != null) {
                        String id = usuario.id;

                        String usuarioN = usuario.usuario;

                        String contraseña = usuario.contraseña;

                        try {
                            conSQLite.Registrar_Nuevo_Usuario(id, usuarioN, contraseña);
                        } catch (Exception e3) {
                            JOptionPane.showMessageDialog(null, "HUVO UN ERROR AL AGREGAR EL NUEVO USUARIO" + e3);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "EL USUARIO NO EXISTE EN NUESTRO REGISTRO");
                    }

                }
            }
        });

    }

    public void inicio() {
        //elementos que deven estar en inicio
        this.getContentPane().setBackground(new java.awt.Color(204, 204, 204));
        this.setExtendedState(Principal.MAXIMIZED_BOTH);
        PanelLogin.setSize(309, 554);
        PanelLogin.setLocation(980, 160);
        PanelLogin.setVisible(true);
    }

    public void Entro() {
        //elementos de inicio  
        fondo.setVisible(false);
        logo.setVisible(false);
        PanelLogin.setVisible(false);
        //barra Lateral 
        panelAlumno.setSize(ancho, alto);
        panelAlumno.setVisible(true);

    }

    public void saliendo() {
        panelAlumno.setVisible(false);
        fondo.setVisible(true);
        logo.setVisible(true);
        PanelLogin.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
