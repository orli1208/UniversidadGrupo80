package universidadgrupo80.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadgrupo80.accesoADatos.AlumnoData;
import universidadgrupo80.accesoADatos.InscripcionData;
import universidadgrupo80.accesoADatos.MateriaData;
import universidadgrupo80.entidades.Alumno;
import universidadgrupo80.entidades.Inscripcion;
import universidadgrupo80.entidades.Materia;

public class FormularioDeInscripcion extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private AlumnoData aluDat;
    private InscripcionData inscData;
    private MateriaData matData;
    private List<Materia> listaM;

    public FormularioDeInscripcion() {
        initComponents();
        aluDat = new AlumnoData();
        matData = new MateriaData();
        inscData = new InscripcionData();
        aluDat.listarAlumnos().forEach(alumno -> jCbAlumnos.addItem(alumno));
        modelo = (DefaultTableModel) jTincripcion.getModel();
        /*for (Alumno alum : aluDat.listarAlumnos()) {
            
        }*/

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jBInscribir = new javax.swing.JButton();
        jBAnularIns = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jRMateriasInscriptas = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jCbAlumnos = new javax.swing.JComboBox<>();
        jRMateriasNoInscriptas = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTincripcion = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setPreferredSize(new java.awt.Dimension(512, 380));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Formulario de inscripcion");
        jLabel1.setAutoscrolls(true);

        jBInscribir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jBInscribir.setText("Inscribir");
        jBInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInscribirActionPerformed(evt);
            }
        });

        jBAnularIns.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jBAnularIns.setText("Anular inscripcion");
        jBAnularIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAnularInsActionPerformed(evt);
            }
        });

        jBSalir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRMateriasInscriptas);
        jRMateriasInscriptas.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jRMateriasInscriptas.setText("Materias inscriptas");
        jRMateriasInscriptas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRMateriasInscriptasItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel2.setText("Seleccionar alumno:");

        buttonGroup1.add(jRMateriasNoInscriptas);
        jRMateriasNoInscriptas.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jRMateriasNoInscriptas.setText("Materias no inscriptas");
        jRMateriasNoInscriptas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRMateriasNoInscriptasItemStateChanged(evt);
            }
        });

        jTincripcion.setAutoCreateRowSorter(true);
        jTincripcion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTincripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Año"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTincripcion);
        if (jTincripcion.getColumnModel().getColumnCount() > 0) {
            jTincripcion.getColumnModel().getColumn(0).setResizable(false);
            jTincripcion.getColumnModel().getColumn(1).setResizable(false);
            jTincripcion.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBInscribir)
                        .addGap(66, 66, 66)
                        .addComponent(jBAnularIns)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSalir)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRMateriasInscriptas)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRMateriasNoInscriptas)
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jCbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRMateriasInscriptas)
                    .addComponent(jRMateriasNoInscriptas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBInscribir)
                    .addComponent(jBAnularIns)
                    .addComponent(jBSalir))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInscribirActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = jTincripcion.getSelectedRow();
        if (filaSeleccionada != -1) {
            Alumno a = (Alumno) jCbAlumnos.getSelectedItem();
            int idMateria = (Integer) modelo.getValueAt(filaSeleccionada, 0);
            String nombreMateria = (String) modelo.getValueAt(filaSeleccionada, 1);
            int anio = (Integer) modelo.getValueAt(filaSeleccionada, 2);
            Materia m = new Materia(idMateria, nombreMateria, anio, true);

            Inscripcion i = new Inscripcion(a, m, 0);
            inscData.guardarInscripcion(i);
            borrarFilaTabla();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla.");
        }
    }//GEN-LAST:event_jBInscribirActionPerformed

    private void jBAnularInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnularInsActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = jTincripcion.getSelectedRow();
        if (filaSeleccionada != -1) {
            Alumno a = (Alumno) jCbAlumnos.getSelectedItem();
            int idMateria = (Integer) modelo.getValueAt(filaSeleccionada, 0);

            inscData.borrarInscripcionMateriaAlumno(a.getIdAlumno(), idMateria);
            borrarFilaTabla();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla.");
        }
    }//GEN-LAST:event_jBAnularInsActionPerformed

    private void jRMateriasNoInscriptasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRMateriasNoInscriptasItemStateChanged
        cargaDatosNoInscriptas();
        jBAnularIns.setEnabled(false);
        jBInscribir.setEnabled(true);
    }//GEN-LAST:event_jRMateriasNoInscriptasItemStateChanged

    private void jRMateriasInscriptasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRMateriasInscriptasItemStateChanged
       cargaDatosInscriptas();
       jBAnularIns.setEnabled(true);
       jBInscribir.setEnabled(false);
    }//GEN-LAST:event_jRMateriasInscriptasItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBAnularIns;
    private javax.swing.JButton jBInscribir;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Alumno> jCbAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRMateriasInscriptas;
    private javax.swing.JRadioButton jRMateriasNoInscriptas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTincripcion;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos(Materia mat) {
        modelo.addRow(new Object[]{mat.getIdMateria(), mat.getNombre(), mat.getAño()});

    }

    private void borrarFilaTabla() {
        int indice = modelo.getRowCount() - 1;

        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void cargaDatosNoInscriptas() {
        borrarFilaTabla();
        Alumno selec = (Alumno) jCbAlumnos.getSelectedItem();
        inscData.obtenerMateriasNOCursadas(selec.getIdAlumno()).forEach(materia -> cargarDatos(materia));
    }

    private void cargaDatosInscriptas() {
        borrarFilaTabla();
        Alumno selec = (Alumno) jCbAlumnos.getSelectedItem();
        inscData.obtenerMateriasCursadas(selec.getIdAlumno()).forEach(materia -> cargarDatos(materia));
    }
}
