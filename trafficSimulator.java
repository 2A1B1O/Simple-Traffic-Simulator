import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import java.awt.Color;

public class trafficSimulator extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
 public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					trafficSimulator frame = new trafficSimulator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public trafficSimulator() {
		setTitle("STS - Simple Traffic Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setBounds(10, 59, 777, 339);
		contentPane.add(panel);
	
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBounds(0, 0, 799, 36);
		contentPane.add(menuBar);
		
		JMenu mnCreate = new JMenu("Create");
		menuBar.add(mnCreate);
		
		JMenuItem mnýtmRoad = new JMenuItem("Road");
		class MenuActionListener implements ActionListener {
			  public void actionPerformed(ActionEvent e) {
			    Graphics g= panel.getGraphics();
			    g.drawLine(0, 0, 100, 150);

			  }
			}
		mnýtmRoad.addActionListener(new MenuActionListener());
		mnCreate.add(mnýtmRoad);
		
		JMenuItem mnýtmRoundabout = new JMenuItem("Roundabout");
		mnCreate.add(mnýtmRoundabout);
		
		JMenuItem mnýtmNode = new JMenuItem("Node");
		mnCreate.add(mnýtmNode);
		
		JMenu mnDelete = new JMenu("Delete");
		menuBar.add(mnDelete);
		
		JMenu mnSave = new JMenu("Save");
		menuBar.add(mnSave);
	}
	

}

