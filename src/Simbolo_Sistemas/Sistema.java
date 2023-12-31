package Simbolo_Sistemas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sistema extends javax.swing.JFrame {

    public Sistema() {
        initComponents();
        setLocationRelativeTo(this);
        reproducirMusica();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(204, 153, 255));
        jTextField1.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 480, 30));

        jLabel1.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("SIMBOLO DE SISTEMAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 240, 30));

        jTextArea1.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 650, 380));

        jToggleButton1.setBackground(new java.awt.Color(255, 204, 204));
        jToggleButton1.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton1.setText("ENTER");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Simbolo_Sistemas/detaylor.jpeg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 160, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   private void reproducirMusica() {
        try {
            File archivoMusica = new File("src/tay/theMan.wav");

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivoMusica);

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        String command = jTextField1.getText();
        String[] tokens = command.split(" ");

        File DirecActual = new File(System.getProperty("user.dir"));
        if (tokens.length == 0) {
            jTextArea1.append("\nError: Comando vacío\n");
            return;
        }
        String DirecName = tokens[0];
        switch (tokens[0]) {
            case "mkdir":
                if (tokens.length > 1) {
                    DirecName = tokens[1];
                    
                    String rutaNuevaCarpeta = DirecActual.getAbsolutePath() + File.separator + DirecName;

                    File newDirec = new File(rutaNuevaCarpeta);
                    if (newDirec.mkdir()) {
                        jTextArea1.append("\nCarpeta creada: " + newDirec.getAbsolutePath() + "\n");
                    } else {
                        jTextArea1.append("\nError al crear la carpeta.\n");
                    }
                }else{
                      jTextArea1.append(" NO SIRVEEEE");
                }
                break;

            case "mfile":
                 if (tokens.length > 1) {
                DirecName = tokens[1];
                String rutaNuevaCarpetaArchivo = DirecActual.getAbsolutePath() + File.separator + DirecName;
                File newFile = new File(rutaNuevaCarpetaArchivo);

                try {
                    if (newFile.createNewFile()) {
                        jTextArea1.append("\nArchivo creado: " + newFile.getAbsolutePath() + "\n");
                    } else {
                        jTextArea1.append("\nEl archivo ya existe o ha ocurrido un error.\n");
                    }
                } catch (IOException e) {
                    jTextArea1.append("\nError al crear el archivo.\n");
                }
                 }
                break;

            case "rm":
                 if (tokens.length > 1) {
                DirecName = tokens[1];

                String rutaCarpetaAEliminar = DirecActual.getAbsolutePath() + File.separator + DirecName;
                File carpetaAEliminar = new File(rutaCarpetaAEliminar);

                if (carpetaAEliminar.delete()) {
                    jTextArea1.append("\nCarpeta eliminada: " + carpetaAEliminar.getAbsolutePath() + "\n");
                } else {
                    jTextArea1.append("\nError al eliminar la carpeta\n");
                }
                 }
                break;

            case "cd":
                DirecName = tokens[1];

                File carpetaACambiar = new File(DirecName);
                if (carpetaACambiar.isDirectory()) {
                    System.setProperty("user.dir", carpetaACambiar.getAbsolutePath());
                    jTextArea1.append("\nCarpeta actual: " + carpetaACambiar.getAbsolutePath() + "\n");
                } else {
                    jTextArea1.append("\nError: " + DirecName + " no es una carpeta\n");
                }
                break;
            case "...":
                File carpetaAnterior = new File(System.getProperty("user.dir")).getParentFile();
                System.setProperty("user.dir", carpetaAnterior.getAbsolutePath());
                jTextArea1.append("\nCarpeta actual: " + carpetaAnterior.getAbsolutePath() + "\n");
                break;
            case "dir":
                File[] archivos = DirecActual.listFiles();
                Arrays.sort(archivos);

                String formatoFecha = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);

                String tabla = String.format("%-50s%-20s\n", "Nombre", "Fecha de creación");
                tabla += "------------------------------------------------------------------\n";

                for (File archivo : archivos) {
                    if (archivo.isDirectory()) {
                        String fecha = sdf.format(new Date(archivo.lastModified()));
                        tabla += String.format("%-50s%-20s\n", archivo.getName(), fecha);
                    }
                }
                jTextArea1.setText(tabla);

                break;
                 case "date":
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date date = new Date();
                jTextArea1.append("\nFecha actual: " + dateFormat.format(date) + "\n");
                break;
            case "time":
                DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                Date time = new Date();
                jTextArea1.append("\nHora actual: " + timeFormat.format(time) + "\n");
                break;
            default:
                jTextArea1.append("\nError: comando desconocido\n");
                break;
         case "wr":
   try {
        if (tokens.length > 1) {
            String nombreArchivo = tokens[1].trim();  
            if (!nombreArchivo.isEmpty()) { 
                int startIndex = command.indexOf(nombreArchivo) + nombreArchivo.length();
                String contenido = command.substring(startIndex).trim();

                if (!contenido.isEmpty()) { 
                    FileWriter escribir = new FileWriter(nombreArchivo);
                    escribir.write(contenido);
                    escribir.close();

                    jTextArea1.append("Texto escrito en el archivo.\n");
                } else {
                    jTextArea1.append("Texto vacio, no se escribio dato.\n");
                }
            } else {
                jTextArea1.append("Nombre de archivo invalido.\n");
            }
        } else {
            jTextArea1.append("Nombre de archivo faltante.\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    break;
case "rd":
    try {
        if (tokens.length > 1) {
            String fileName = tokens[1]; 

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedlector = new BufferedReader(fileReader);

            String line;
            StringBuilder fileContent = new StringBuilder("Contenido del archivo:\n");
            while ((line = bufferedlector.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            bufferedlector.close();

            jTextArea1.append(fileContent.toString());
        } else {
            jTextArea1.append("Nombre de archivo faltante.\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    break;

        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
