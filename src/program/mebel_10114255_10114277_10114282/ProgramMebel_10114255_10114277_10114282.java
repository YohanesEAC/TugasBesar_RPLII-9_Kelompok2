/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.mebel_10114255_10114277_10114282;

import Form.Login;
import Form.SplashScreen;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author YEAC
 */
public class ProgramMebel_10114255_10114277_10114282 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SplashScreen s=new SplashScreen();
        s.setVisible(true);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProgramMebel_10114255_10114277_10114282.class.getName()).log(Level.SEVERE, null, ex);
        }
        s.dispose();
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                Login utama = new Login();
                utama.setVisible(true);
            }
        });
    }
    
}