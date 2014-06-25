/**
 * 
 */
package _corepackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Random;

import javax.swing.JPanel;

/**
 * @author kf002285
 *
 */
public class Facial extends JPanel {

    public void paint(Graphics g) {
    	System.out.println("paintComponent");
        g.setColor(Color.white);
        Dimension size = getSize();
        Insets insets = getInsets();

        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;

        Random r = new Random();
        int x,y,z,t;

        for (int i = 0; i < 3; i++) {

            x = Math.abs(r.nextInt()) % w;
            y = Math.abs(r.nextInt()) % h;
            z = Math.abs(r.nextInt()) % w;
            t = Math.abs(r.nextInt()) % h;
            g.fillOval(x, y, z, t);
            System.out.println("draw");
        }
    }
}
