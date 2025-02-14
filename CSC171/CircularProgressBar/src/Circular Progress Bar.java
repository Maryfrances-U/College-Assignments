import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class ProgressBar extends JComponent{
	private final static int MAX_PROGRESS_AMOUNT = 100;
    private static final int DELAY = 50;
    private Timer timer;
    private int prgValue = 0;
    
    public ProgressBar() {
        timer = new Timer(DELAY, new MyChangeListener());
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
           //Graphics2D g2 = (Graphics2D) g;
           //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
           if (prgValue <= MAX_PROGRESS_AMOUNT) {
                 g.setColor(Color.blue);
                 int angle = -(int) (((float) prgValue / MAX_PROGRESS_AMOUNT) * 360);
                 g.fillArc(0, 0, getWidth(), getHeight(), 90, angle);

          }
   }

   class MyChangeListener implements ActionListener {
       @Override
       public void actionPerformed(ActionEvent arg0) {
           prgValue++;
           repaint();
           if (prgValue >= MAX_PROGRESS_AMOUNT)
                timer.stop();
      }
  }
   
   public static void main(String [] args) {
	   JFrame frame = new JFrame("Circular Progress Bar by Harry Joy");
	   frame.add(new ProgressBar());
	   frame.setSize(350, 350);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setVisible(true);
   }

}
