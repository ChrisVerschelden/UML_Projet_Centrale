package UML_Projet_Centrale;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.JPanel;


public class Terminal extends JPanel {

    private JFrame frame;
    private Centrale c;

    private static Color[] colors = {
        Color.red,
        Color.blue,
        Color.green,
        Color.CYAN,
        Color.LIGHT_GRAY,
        Color.MAGENTA,
        Color.ORANGE,
        Color.PINK,
        Color.DARK_GRAY,
        Color.yellow        
    };

	private Map<Color, Integer> bars =
            new LinkedHashMap<Color, Integer>();
	
	/**
	 * Add new bar to chart
	 * @param color color to display bar
	 * @param value size of bar
	 */
	public void addBar(Color color, int value)
	{
		bars.put(color, value);
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		// determine longest bar
		
		int max = Integer.MIN_VALUE;
		for (Integer value : bars.values())
		{
			max = Math.max(max, value);
		}
		
		// paint bars
		
		int width = (getWidth() / bars.size()) - 2;
		int x = 1;
		for (Color color : bars.keySet())
		{
			int value = bars.get(color);
			int height = (int) 
                            ((getHeight()-5) * ((double)value / max));
			g.setColor(color);
			g.fillRect(x, getHeight() - height, width, height);
			g.setColor(Color.black);
			g.drawRect(x, getHeight() - height, width, height);
			x += (width + 2);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(bars.size() * 10 + 2, 50);
	}

	public void launchTerminal(Centrale c)
	{
		JFrame frame = new JFrame("Bar Chart");
		Terminal chart = new Terminal();
        int i = 0;
        for (Objet o : c.getListeObjets()) {
            if (o instanceof Capteur){
                Capteur cap = (Capteur) o;
                chart.addBar(colors[i], cap.getValeur());
                i++;
            }
        }	

        frame.getContentPane().add(chart);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1920, 800);
		frame.setVisible(true);

        majAffichage();
	}

    public void majAffichage(){
        Terminal chart = new Terminal();
        int i = 0;
        for (Objet o : c.getListeObjets()) {
            if (o instanceof Capteur){
                Capteur cap = (Capteur) o;
                chart.addBar(colors[i], cap.getValeur());
                i++;
            }
        }	
        frame.getContentPane().add(chart);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1920, 800);
		frame.setVisible(true);

        majAffichage();
    } 
}
