import java.awt.EventQueue; // Aslıhan Öztürk- Save File System 
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
		panel.setBounds(10, 59, 777, 339);
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
					myMap.AddRoad(r);                         // location info of road to be drawn will be kept in myMap object to be able to re-draw it again 
					panel.addMouseListener(new MouseAdapter() { //PANEL LISTENER BEGINS

						int oldX;
						int oldY;
						int newX;
						int newY;

						public void mousePressed(MouseEvent evt) {
							oldX = evt.getX();
							oldY = evt.getY();
							System.out.println("Source X is: " + oldX + ", Source Y is: " + oldY);
						}

						public void mouseReleased(MouseEvent e2) {
							newX = e2.getX();
							newY = e2.getY();
							System.out.println("Destination X is: " + newX + ", Destination Y is: " + newY);
							Graphics g = panel.getGraphics();
							g.drawLine(oldX, oldY, newX, newY);
							a.setX(oldX);           // location info is passed to the road of myMap...
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

						}

					});

				} catch (Exception E) {
					System.out.println(E.getMessage());
				}

			}
		}
		mnýtmRoad.addActionListener(new CreateRoadListener());
		mnCreate.add(mnýtmRoad);

		JMenuItem mnýtmRoundabout = new JMenuItem("Roundabout");

		class CreateRoundaboutListener implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				try {
					panel.addMouseListener(new MouseAdapter() {

						int roundX;
						int roundY;

						public void mouseClicked(MouseEvent e3) {
							roundX = e3.getX();
							roundY = e3.getY();
							Graphics g = panel.getGraphics();
							g.fillOval(roundX, roundY, 20, 20);
							Dot merkez = new Dot(); // roundabout that was drawn
													// onto panel needs to be
													// saved as an object to
													// save a file .
							merkez.setX(roundX); // getting location info of
													// roundabout to be able to
													// draw it again on the same
													// place while reading a
													// file.
							merkez.setY(roundY);
							Circle c = new Circle();
							c.setCenter(merkez);
							Roundabout r = new Roundabout();
							r.setLocation(c);
							myMap.AddRoundabout(r);

						}
					});
				} catch (Exception e) {
					System.out.println(e.getMessage());
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

				try { // FILE SAVE SYSTEM CODES...
					File workingDirectory = new File(System.getProperty("user.dir"));

					JFileChooser fc = new JFileChooser(workingDirectory);
					switch (fc.showOpenDialog(trafficSimulator.this)) {
					case JFileChooser.APPROVE_OPTION:
						FileInputStream fin = new FileInputStream(fc.getSelectedFile());
						ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fin));
						System.out.println("hata1");

						Map mapToOpen = (Map) ois.readObject();
						if (mapToOpen.getMyRoads() != null) { // READING THE
																// ROADS ARRAY
																// FROM THE MAP
																// CLASS OBJECT
																// THAT WAS
																// SAVED IN A
																// FILE
							for (int i = 0; i < mapToOpen.getMyRoads().size(); i++) {
								Road r = mapToOpen.getMyRoads().get(i);
								Line l = r.getLine();
								Graphics g = panel.getGraphics();
								System.out.println(l.getX() + " " + l.getX1());
								g.drawLine(l.getX(), l.getY(), l.getX1(), l.getY1());

							}
						}
						if (mapToOpen.getMyRoundabouts() != null) { // READING
																	// ROUNDABOUTS
																	// FROM THE
																	// MAP CLASS
																	// OBJECT...
							for (int i = 0; i < mapToOpen.getMyRoundabouts().size(); i++) {
								Roundabout r = mapToOpen.getMyRoundabouts().get(i);
								Circle l = r.getLocation();
								Dot merkez = l.getCenter();
								Graphics g = panel.getGraphics();
								g.fillOval(merkez.getX(), merkez.getY(), 20, 20);

							}
						}

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
