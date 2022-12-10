/* Maryfrances Umeora
   mumeora
   HW 12
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.awt.*;

public class Canvas extends JFrame implements ActionListener, ChangeListener, ItemListener{
	
	
	//instance variables
	JButton button1 = new JButton("CLICK ME!");
	JButton button2 = new JButton("OFF");
	int but1p = 0;	//number of times button 1 pressed
	JLabel label1 = new JLabel("# of Times Button1 has been pressed: " + but1p);
	JLabel label2 = new JLabel("Value of Slider ");
	JTextField textfield = new JTextField(20);
	JSlider slider = new JSlider(0, 100);
	JCheckBox yesbox = new JCheckBox("Yes");
	JCheckBox nobox = new JCheckBox("No");
	
	
	//constructor
	public Canvas()	{
		super();
		setTitle("Frame");
		setSize(250, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		add(button1);
		button1.addActionListener(this);
		add(button2);
		button2.addActionListener(this);
		add(label1);
		add(textfield);
		textfield.addActionListener(this);
		add(label2);
		add(slider);
		slider.addChangeListener(this);
		add(yesbox);
		add(nobox);
		yesbox.addItemListener(this);
		nobox.addItemListener(this);
	}
	
	
	//action performed
	public void actionPerformed(ActionEvent e)	{
		if (e.getSource() == button1)	{
			System.out.println("You clicked the first button!");
			but1p += 1;
			label1.setText("# of Times Button1 has been pressed: " + but1p);
		}
		
		if (e.getSource() == button2)	{
			System.out.println("You clicked the second button!");
			if (button2.getText().equals("OFF"))	{
				button2.setText("ON");
			}
			else if (button2.getText().equals("ON"))	{
				button2.setText("OFF");
			}
		}
		
		if (e.getSource() == textfield) {
			label1.setText(textfield.getText());
		}
	}
	
	
	
	//change listener method
	public void stateChanged(ChangeEvent e) {
		label2.setText("Value of Slider " + slider.getValue());
	}
	
	
	//item listener method
	public void itemStateChanged(ItemEvent e) {
		
		if (yesbox.isSelected())	{
			System.out.println("The yes box is checked.");
		}
		else 
			System.out.println("The yes box is unchecked.");
		
		if (nobox.isSelected())	{
			System.out.println("The no box is checked.");
		}
		else 
			System.out.println("The no box is unchecked.");	
		
	}


	
	//main
	public static void main(String [] args) {
		Canvas canvasInstance = new Canvas();
		canvasInstance.setVisible(true);
	}

}

