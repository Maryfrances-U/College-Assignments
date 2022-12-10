/* Maryfrances Umeora
   mumeora
   Project 03
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Fireworks extends JComponent implements ActionListener, ChangeListener, ItemListener {
	

	//instance variables things the user chooses
		double vel = 0;
		double ang = 45;
		double convertedAng = ang * (Math.PI/180);
		double time = 0;
		Color drawingColor = Color.BLACK;
		
	//instance variables components
		JButton drawb = new JButton("Launch");				//button to render
		JButton clear = new JButton("Clear");				//button to clear
		JSlider asl = new JSlider(0, 90);					//slider for angle
		JTextField vtf = new JTextField(15);				//text field for velocity
		JTextField ttf = new JTextField(15);				//text field for time
		JRadioButton redB = new JRadioButton("Red");		//radio boxes for colors	
		JRadioButton oraB = new JRadioButton("Orange");
		JRadioButton bluB = new JRadioButton("Blue");
		JRadioButton fw1 = new JRadioButton("Glitter");		//radio boxes for firework type
		JRadioButton fw2 = new JRadioButton("Swirly");
		JRadioButton fw3 = new JRadioButton("Basic Star");
		JRadioButton fw4 = new JRadioButton("Shiny Star");
		JRadioButton fw5 = new JRadioButton("Dave's Star");
	
	//instance variables labels
		JLabel imNote = new JLabel("Note: You have to click enter for the value of your velocity and time to change.");
		JLabel anglab = new JLabel("Angle");
		JLabel vellab = new JLabel("Velocity");
		JLabel timlab = new JLabel("Time");
		JLabel fwtype = new JLabel("Firework Type");
		
	//the x and y values of the firework launched
		int x;
		int y = getHeight();
		
		
		
	//constructor
	public Fireworks()	{
		super();
		
		
		//group the color radio boxes
		ButtonGroup colorgroup = new ButtonGroup();
		colorgroup.add(redB);
		colorgroup.add(bluB);
		colorgroup.add(oraB);
		
		//group the firework type radio boxes
		ButtonGroup fireworkgroup = new ButtonGroup();
		fireworkgroup.add(fw1);
		fireworkgroup.add(fw2);
		fireworkgroup.add(fw3);
		fireworkgroup.add(fw4);
		fireworkgroup.add(fw5);
		
		
		//external layout control
		setLayout(new BorderLayout());
		
		
		//panel for top
		JPanel topPanel = new JPanel();
		JPanel topPanelsub = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		topPanel.add(imNote);
		topPanelsub.add(drawb);
		topPanelsub.add(clear);
		topPanel.add(topPanelsub);
		add(topPanel, BorderLayout.NORTH);
		
		
		//panel for side
		JPanel sidePanel = new JPanel();
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		sidePanel.add(fwtype);
		sidePanel.add(fw1);
		sidePanel.add(fw2);
		sidePanel.add(fw3);
		sidePanel.add(fw4);
		sidePanel.add(fw5);
		add(sidePanel, BorderLayout.EAST);
		
		
		//panel for bottom
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(redB);
		bottomPanel.add(oraB);
		bottomPanel.add(bluB);
		bottomPanel.add(anglab);
		bottomPanel.add(asl);
		bottomPanel.add(vellab);
		bottomPanel.add(vtf);
		bottomPanel.add(timlab);
		bottomPanel.add(ttf);
		add(bottomPanel, BorderLayout.SOUTH);
		
		
		//adding action and item listeners
		drawb.addActionListener(this);
		clear.addActionListener(this);
		redB.addActionListener(this);
		oraB.addActionListener(this);
		bluB.addActionListener(this);
		fw1.addActionListener(this);
		fw2.addActionListener(this);
		fw3.addActionListener(this);
		fw4.addActionListener(this);
		fw5.addActionListener(this);
		asl.addChangeListener(this);
		vtf.addActionListener(this);
		ttf.addActionListener(this);
		
		
	}
	
	
	
	//action performed method
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == drawb)	{
			System.out.println("Boom!");
			drawTrajectory();
		}
		
		if (ae.getSource() == clear)	{
			repaint();
			vtf.setText("");
			ttf.setText("");
		}
		
		if (ae.getSource() == vtf) {
			vel = Double.parseDouble(vtf.getText());
			System.out.println("Your velocity is " + vel);
		}
		
		if (ae.getSource() == ttf) {
			time = Double.parseDouble(ttf.getText());
			System.out.println("Your time is " + time);
		}
		
		
		//select firework color
		if (redB.isSelected())	{
			System.out.println("Your firework will be red!");
			drawingColor = Color.RED;
		}
		
		else if (oraB.isSelected())	{
			System.out.println("Your firework will be orange!");
			drawingColor = Color.ORANGE;
		}
		
		else if (bluB.isSelected())	{
			System.out.println("Your firework will be blue!");
			drawingColor = Color.BLUE;
		}
	}
	
	
	//slider change event method
	public void stateChanged(ChangeEvent ce) {
		ang = asl.getValue();
		convertedAng = ang * (Math.PI/180);
		System.out.println("The angle is " + ang);
	}
	
	
	//item listener method
	public void itemStateChanged(ItemEvent e) { }	
			
	
	
	//draw trajectory
	public void drawTrajectory()	{
		Graphics g1 = this.getGraphics();
		g1.setColor(drawingColor);
		System.out.println(getHeight());
		
		//loop through x values while t < time
		for (int t = 0; t <= time; t++) {
			x = (int) (vel * Math.cos(convertedAng) * t);
			y = (int) (getHeight() - ( (vel * Math.sin(convertedAng) * t) - (0.5 * 9.8 * t * t) ));
			System.out.println("x @ t = " + t + " is " + x);
			System.out.println("y @ t = " + t + " is " + y);
			g1.fillOval(x, y, 10, 10);
		}
		
		drawFirework();
	}
	
	
	
	//draw firework
	public void drawFirework()	{
		Graphics g2 = this.getGraphics();
		g2.setColor(drawingColor);
		
		if (fw1.isSelected()) {
			//Glitter
			Random rand = new Random();
			int randx1;
			int randy1;
			for (int i = 0; i < 1000; i ++)	{
				/*randx1 = x + (rand.nextInt(50) + 1);     
		        randy1 = y + (rand.nextInt(60) - 30);*/
		        randx1 = x + (rand.nextInt((getWidth()/50) * 5) + 1);     
		        randy1 = y + (rand.nextInt((getHeight()/50) * 6)  - (getHeight()/50) * 3);
				g2.drawOval(randx1, randy1, 1, 1); 
			}
		}
		
		else if (fw2.isSelected()) {
			//Swirly
			for (int i = 1; i <= 6; i ++)	{
				g2.drawOval(x - 10*i, y - 10*i, 10 + (i*20), 10 + (i*20));
			}
		}
		
		else if (fw3.isSelected()) {
			//Basic Star
			int w5 = getWidth()/50 * 5;
			int h5 = getHeight()/50 * 5;
			/*g2.drawLine(x, y - 50, x, y + 50);
			g2.drawLine(x - 50, y, x + 50, y);
			g2.drawLine(x - 50, y - 50, x + 50, y + 50);
			g2.drawLine(x + 50, y -+50, x - 50, y + 50);*/
			g2.drawLine(x, y - h5, x, y + h5);
			g2.drawLine(x - w5, y, x + w5, y);
			g2.drawLine(x - w5, y - h5, x + w5, y + h5);
			g2.drawLine(x + w5, y -+h5, x - w5, y + h5);
		}
		
		else if (fw4.isSelected()) {
			//Shiny Star
			int w3 = getWidth()/50 * 3;
			int w6 = getWidth()/50 * 6;
			int h3 = getHeight()/50 * 3;
			int h6 = getHeight()/50 * 6; 
			/*g2.drawLine(x, y - 30, x - 30, y);
			g2.drawLine(x, y - 30, x + 30, y);
			g2.drawLine(x - 30, y, x - 60, y);
			g2.drawLine(x + 30, y, x + 60, y);
			g2.drawLine(x - 60, y, x - 30, y + 30);
			g2.drawLine(x + 60, y, x + 30, y + 30);
			g2.drawLine(x - 30, y + 30, x - 60, y + 60);
			g2.drawLine(x + 30, y + 30, x + 60, y + 60);
			g2.drawLine(x - 60, y + 60, x + 60, y + 60);*/
			g2.drawLine(x, y - h3, x - w3, y);
			g2.drawLine(x, y - h3, x + w3, y);
			g2.drawLine(x - w3, y, x - w6, y);
			g2.drawLine(x + w3, y, x + w6, y);
			g2.drawLine(x - w6, y, x - w3, y + h3);
			g2.drawLine(x + w6, y, x + w3, y + h3);
			g2.drawLine(x - w3, y + h3, x - w6, y + h6);
			g2.drawLine(x + w3, y + h3, x + w6, y + h6);
			g2.drawLine(x - w6, y + h6, x + w6, y + h6);
		}
		
		else if (fw5.isSelected()) {
			//Dave's Star
			int w3 = getWidth()/50 * 3;
			int h1 = getHeight()/50 * 1;
			int h3 = getHeight()/50 * 3;;
			int h4 = getHeight()/50 * 4;;
			/*g2.drawLine(x - 30, y - 10, x, y + 40);
			g2.drawLine(x + 30, y - 10, x, y + 40);
			g2.drawLine(x - 30, y - 10, x + 30, y - 10);
			g2.drawLine(x, y - 30, x - 30, y + 30);
			g2.drawLine(x, y - 30, x + 30, y + 30);
			g2.drawLine(x - 30, y + 30, x + 30, y + 30);*/
			g2.drawLine(x - w3, y - h1, x, y + h4);
			g2.drawLine(x + w3, y - h1, x, y + h4);
			g2.drawLine(x - w3, y - h1, x + w3, y - h1);
			g2.drawLine(x, y - h3, x - w3, y + h3);
			g2.drawLine(x, y - h3, x + w3, y + h3);
			g2.drawLine(x - w3, y + h3, x + w3, y + h3);
		}
		
		
	}
	
	
	
	//main
	public static void main(String [] args) {
		Fireworks instance = new Fireworks();
		JFrame frame = new JFrame();
		Container c = frame.getContentPane();
		frame.add(instance);
		frame.setTitle("Fireworks Launcher");
		frame.setSize(900, 500);
		c.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}


}
