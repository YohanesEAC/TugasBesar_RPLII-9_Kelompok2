/*
 * Es la ventana en la que se muestra la imagen principal y el progreso en la
 * barra de progreso.
 */
package Form;

import java.awt.Image;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author m2 - LiNuXiToS
 */
public class SplashScreen extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreen
     */
    @SuppressWarnings({"OverridableMethodCallInConstructor", "CallToThreadStartDuringObjectConstruction"})
    public SplashScreen() {
        setUndecorated(true);
        initComponents();
        ImageIcon ico = new ImageIcon("src/images/usuarios.png");
        setIconImage(ico.getImage());
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);
        Jprogres.setMinimum(0);
        Jprogres.setMaximum(100);
        Jprogres.setStringPainted(true);
        
        Thread t = new Thread() {
            @Override
            @SuppressWarnings("SleepWhileInLoop")
            public void run() {
                int i = 0;
                while (i <= 100) {
                    Jprogres.setValue(i);
                    if(i==0){
                        jpesan.setText("Loading....");
                    }
                    if(i==15){
                        jpesan.setText("Mengakses File....");
                    }
                    if(i==23){
                        jpesan.setText("Mengakses Database....");
                    }
                    if(i==37){
                        jpesan.setText("Membaca Database....");
                    }
                    if(i==67){
                        jpesan.setText("Konfigurasi Database....");
                    }
                    if(i==77){
                        jpesan.setText("Database Mebel....");
                    }
                    if(i==90){
                        jpesan.setText("Terimakasih, Selamat Datang :)");
                    }
                    try {
                        sleep(90);
                        new Login();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
            }
        };
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlblImage = new javax.swing.JLabel();
        Jprogres = new javax.swing.JProgressBar();
        jpesan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(70, 29, 0));

        jlblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgs.png.jpg"))); // NOI18N

        jpesan.setForeground(new java.awt.Color(255, 255, 255));
        jpesan.setText("Loading....");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jprogres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpesan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jlblImage)
                .addGap(5, 5, 5)
                .addComponent(jpesan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Jprogres, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar Jprogres;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlblImage;
    private javax.swing.JLabel jpesan;
    // End of variables declaration//GEN-END:variables
}
