import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JButton;
//filloval function will be used

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
		panel.setBackground(Color.gray);
		panel.setBounds(49, 43, 738, 365);
		contentPane.add(panel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBounds(0, 0, 799, 36);
		contentPane.add(menuBar);

		JMenu mnCreate = new JMenu("Create");
		menuBar.add(mnCreate);
		Map myMap = new Map();
		JMenuItem mnýtmRoad = new JMenuItem("Road");
		

		
		
		
		
		
		class CreateRoadListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Line a = new Line(0, 0, 0, 0);
					Road r = new Road();
					r.setLine(a);
					myMap.AddRoad(r);
					
					panel.addMouseListener(new MouseAdapter() {  	//PANEL LISTENER BEGINS
						int oldX;
						int oldY;
						int newX;
						int newY;
						
						// global bir state // design pattern
						// ilk başta public enum State { NONE, ROAD, ROUNDABOUT };
						// private State myState = NONE;

						public void mousePressed(MouseEvent e1) {
							oldX = e1.getX();
							oldY = e1.getY();
							System.out.println("Source X is: " + oldX + ", Source Y is: " + oldY);
						}

						public void mouseReleased(MouseEvent e2) {
							newX = e2.getX();
							newY = e2.getY();
							System.out.println("Destination X is: " + newX + ", Destination Y is: " + newY);
							Graphics g = panel.getGraphics();
							g.drawLine(oldX, oldY, newX, newY);
							a.setX(oldX);
							a.setY(oldY);
							a.setX1(newX);
							a.setY1(newY);

							JTextField densityOfRoad = new JTextField();
							JTextField laneNum = new JTextField();

							final JComponent[] inputs = new JComponent[] { new JLabel("Density"), densityOfRoad,
									new JLabel("Number Of Lanes"), laneNum,
									

							};
							int result = JOptionPane.showConfirmDialog(null, inputs, "Road Values",
									JOptionPane.PLAIN_MESSAGE);

							if (result == JOptionPane.OK_OPTION) {
								myMap.getMyRoads().get(1).setCapacity(Integer.parseInt(densityOfRoad.getText()));
								
							}
							

						} // MOUSE LISTENER ENDS
						
					}); // ACTION LISTENER ENDS
					
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

			}
			
		}
		mnýtmRoad.addActionListener(new CreateRoadListener());
		mnCreate.add(mnýtmRoad);

		JMenuItem mnýtmRoundabout = new JMenuItem("Roundabout");

		class CreateRoundaboutListener implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				try {
					panel.addMouseListener(new MouseAdapter() { // PANEL
																// LISTENER
																// BEGIN
						int roundX;
						int roundY;

						public void mouseClicked(MouseEvent e3) {
							roundX = e3.getX();
							roundY = e3.getY();
							Graphics g = panel.getGraphics();
							g.fillOval(roundX, roundY, 20, 20);
						}
					}); // PANEL LISTENER ENDS
				} catch (Exception a) {
					System.out.println(a.getMessage());
				}

			}
		}

		mnýtmRoundabout.addActionListener(new CreateRoundaboutListener());
		mnCreate.add(mnýtmRoundabout);

		JMenuItem mnýtmNode = new JMenuItem("Node");
		mnCreate.add(mnýtmNode);

		JMenu mnDelete = new JMenu("Delete");
		menuBar.add(mnDelete);

		JMenu mnSave = new JMenu("Save");
		JMenuItem mnýtmSave = new JMenuItem("Save current map...");
		mnSave.add(mnýtmSave);
		class SaveButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					JTextField fileName = new JTextField();

					final JComponent[] inputs = new JComponent[] { new JLabel("File name"), fileName };
					int result = JOptionPane.showConfirmDialog(null, inputs, "My custom dialog",
							JOptionPane.PLAIN_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						System.out.println("You entered " + fileName.getText());
						System.out.println("User canceled / closed the dialog, result = " + result);
					}
					FileOutputStream fos = new FileOutputStream(fileName.getText());
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(myMap);
					oos.close();
				} catch (Exception E) {
					System.out.println(E.getMessage());
				}
			}
		}
		mnýtmSave.addActionListener(new SaveButtonListener());
		menuBar.add(mnSave);

		JMenu mnOpen = new JMenu("Open");
		JMenuItem mnýtmOpen = new JMenuItem("Choose and existing map...");
		class OpenButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				try {
					File workingDirectory = new File(System.getProperty("user.dir"));

					JFileChooser fc = new JFileChooser(workingDirectory);
					switch (fc.showOpenDialog(trafficSimulator.this)) {
					case JFileChooser.APPROVE_OPTION:
						FileInputStream fin = new FileInputStream(fc.getSelectedFile());
						ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fin));
						System.out.println("hata1");

						Map mapToOpen = (Map) ois.readObject();
						if(mapToOpen.getMyRoads()!=null){
							for( int i =0;i<mapToOpen.getMyRoads().size();i++){
								Road r=mapToOpen.getMyRoads().get(i);
								Line l=r.getLine();
								Graphics g = panel.getGraphics();
								System.out.println(l.getX()+" "+l.getX1());
								g.drawLine(l.getX(), l.getY(), l.getX1(), l.getY1());
								
								
								
							}
						}
						
						// JOptionPane.showMessageDialog(trafficSimulator.this,
						// "selected: "+
						// fc.getSelectedFile(),"TrafficSimulator",
						// JOptionPane.OK_OPTION );

					}

				} catch (Exception E) {
					System.out.println(E.getMessage());
				}
			}
		}
		mnýtmOpen.addActionListener(new OpenButtonListener());
		menuBar.add(mnOpen);
		mnOpen.add(mnýtmOpen);
	}
}
