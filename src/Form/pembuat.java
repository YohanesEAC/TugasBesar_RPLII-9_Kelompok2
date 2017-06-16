/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class pembuat extends JPanel {
    
        private Image pembuat;

    public pembuat() {
    pembuat = new ImageIcon(getClass().getResource          
    ("/images/wood.jpg")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawImage(pembuat, 0, 0,getWidth(),getHeight(),null);
        g2d.dispose();
    }

}