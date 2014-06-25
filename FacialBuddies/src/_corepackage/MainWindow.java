package _corepackage;
import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.File;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Random;
import javax.swing.*;


public class MainWindow extends JFrame{

	private JPanel pPrim;
	private JPanel pSec;
	private JButton bFacial;
	private JButton bRecharger;
	private JButton bLoadImage;
	private int iFacialCounter;
	private File fImage;
	private JLabel lText;
	private JLabel lblImage;
	private JLabel lblSploutch;

	/**
	 * CONSTRUCTEURS
	 */
	public MainWindow(){
		super();
	}

	public MainWindow (String title) {
		this.setTitle(title);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(this.setSecPanel(), BorderLayout.CENTER);
		this.getContentPane().add(this.setMainPanel(), BorderLayout.SOUTH);
		this.setVisible(true);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.pack();
		this.iFacialCounter = 0;
	}


	/**
	 * MAIN FUNCTIONS
	 */
	private void setImage(File f){
		if (this.lblImage != null)
		{
			this.pSec.remove(this.lblImage);
			this.lblImage = null;
		}
		System.out.println("sisi tonton");
		this.lblImage = new JLabel((new ImageIcon(f.getPath())));
		this.pSec.setBackground(Color.LIGHT_GRAY);
		this.pSec.remove(this.lText);
		this.pSec.add(this.lblImage);
		pack();
	}

	private JPanel setMainPanel(){
		this.pPrim = new JPanel();
		this.pPrim.setLayout(new FlowLayout());

		this.bFacial = new JButton("Facial");
		this.pPrim.add(this.bFacial);
		this.bFacial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(iFacialCounter>=5)
					javax.swing.JOptionPane.showMessageDialog(null,"Get Refilled");
				else {
					//System.out.println("You clicked the Facial button");
					Graphics g = pSec.getGraphics(); //.drawOval(this.size, arg1, arg2, arg3)
					g.setColor(Color.white);
					Dimension size = getSize();
					Insets insets = getInsets();

					int w = size.width - insets.left - insets.right;
					int h = size.height - insets.top - insets.bottom;

					Random r = new Random();
					int iDiv;
					int x,y,z,t;

					for (int i = 0; i < 25; i++) {

						x = Math.abs(r.nextInt()) % w;
						y = Math.abs(r.nextInt()) % h;
						z = Math.abs(r.nextInt()) % w;
						t = Math.abs(r.nextInt()) % h;
						iDiv = 7+iFacialCounter*3 + (int)(Math.random() * 20+iFacialCounter*3);
						if (z!=0 && t != 0)
							g.fillOval(x, y, z/iDiv, t/iDiv);
						//System.out.println("trace");
					}
					/**lblSploutch.setText("SPLOUTCH !!");
					pack();**/
				}
				iFacialCounter++;
			}
		});  

		this.bRecharger = new JButton("Refill");
		this.pPrim.add(this.bRecharger);
		this.bRecharger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("You clicked the Recharger button");
				javax.swing.JOptionPane.showMessageDialog(null,"Wait for it !");
				try{
					Thread.sleep(3000);
				}catch(InterruptedException exc){
					System.out.println(exc.getMessage());
				}
				javax.swing.JOptionPane.showMessageDialog(null,"Almost here !");
				try{
					Thread.sleep(3000);
				}catch(InterruptedException exc){
					System.out.println(exc.getMessage());
				}
				iFacialCounter = 0;
				javax.swing.JOptionPane.showMessageDialog(null,"Balls are full man !");

			}
		}); 

		this.bLoadImage = new JButton("Load Picture");
		this.pPrim.add(this.bLoadImage);
		this.bLoadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//System.out.println("Click Load. Trace before");
				fImage = loadImage();
				if (fImage!=null)
					setImage(fImage);
				else
					System.out.println("No image selected");
			}
		}); 
		this.lblSploutch = new JLabel();
		this.pPrim.add(this.lblSploutch);

		return this.pPrim;
	}

	private JPanel setSecPanel(){
		this.pSec = new JPanel();
		this.pSec.setLayout(new FlowLayout());
		this.pSec.setBackground(Color.LIGHT_GRAY); 
		lText = new JLabel("Facial Buddies v1.0");
		lText.setForeground(Color.WHITE);
		this.pSec.add(lText);
		return this.pSec;
	}

	private File loadImage(){
		JFileChooser fcLoad = new JFileChooser();
		fcLoad.showOpenDialog(this);
		File Fichier = null;
		if (fcLoad.getSelectedFile()!=null)
			Fichier = fcLoad.getSelectedFile();
		return Fichier;
	}  
}
