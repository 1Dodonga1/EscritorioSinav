/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VIsta;
import Modelo.Materia;
import Controlador.Consultas;
/**
 *
 * @author Alma Cuevas
 */
public class BarraInmovil extends javax.swing.JPanel {

    /**
     * Creates new form BarraInmovil
     */
    Consultas c=new Consultas();
    public BarraInmovil() {
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

        jLabel1 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaMaterias = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logoP.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 279, -1));

        salir.setText("cerrar");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 660, 182, -1));

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Materias");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 110, -1));

        ListaMaterias.setBackground(new java.awt.Color(255, 102, 102));
        ListaMaterias.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        ListaMaterias.setForeground(new java.awt.Color(51, 51, 51));
        ListaMaterias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListaMaterias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListaMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaMateriasMouseClicked(evt);
            }
        });
        ListaMaterias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListaMateriasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListaMaterias);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 250, 230));

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("Agregar clase");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salirActionPerformed

    private void ListaMateriasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaMateriasValueChanged
        // TODO add your handling code here:
       
    }//GEN-LAST:event_ListaMateriasValueChanged

    private void ListaMateriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaMateriasMouseClicked
        // TODO add your handling code here:
       // Datos.Materia.setNombre(ListaMaterias.getSelectedValue());
    }//GEN-LAST:event_ListaMateriasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JList<String> ListaMaterias;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
