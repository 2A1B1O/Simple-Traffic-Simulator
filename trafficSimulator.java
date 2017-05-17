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
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JMenu;
import java.awt.Color;
//filloval function w,ll be used

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
		Map myMap = new Map();
		JMenuItem mn�tmRoad = new JMenuItem("Road");
		class CreateRoadListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
				Graphics g = panel.getGraphics();
				Line a = new Line(200, 0, 100, 150);
				Road r= new Road();
				r.setLine(a);
				myMap.AddRoad(r);
				g.drawLine(a.getX(), a.getY(), a.getX1(), a.getY1());
				
				
					JTextField densityOfRoad = new JTextField();
					JTextField laneNum=new JTextField();
					
					final JComponent[] inputs = new JComponent[] {
					        new JLabel("Density"),
					        densityOfRoad,
					        new JLabel("Number Of Lanes"),
					        laneNum,
					       
					};
					int result = JOptionPane.showConfirmDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
					    myMap.getMyRoads().get(1).setCapacity(Integer.parseInt(densityOfRoad.getText()));
					}
					
				} catch (Exception E) {
					System.out.println(E.getMessage());
				}

			}
		}
		mn�tmRoad.addActionListener(new CreateRoadListener());
		mnCreate.add(mn�tmRoad);

		JMenuItem mn�tmRoundabout = new JMenuItem("Roundabout");
		mnCreate.add(mn�tmRoundabout);

		JMenuItem mn�tmNode = new JMenuItem("Node");
		mnCreate.add(mn�tmNode);

		JMenu mnDelete = new JMenu("Delete");
		menuBar.add(mnDelete);

		JMenu mnSave = new JMenu("Save");
		JMenuItem mn�tmSave = new JMenuItem("Save current map...");
		mnSave.add(mn�tmSave);
		class SaveButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					JTextField fileName = new JTextField();
					
					
					final JComponent[] inputs = new JComponent[] {
					        new JLabel("File name"),
					        fileName
					};
					int result = JOptionPane.showConfirmDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
					    System.out.println("You entered " +
					            fileName.getText());
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
		mn�tmSave.addActionListener(new SaveButtonListener());
		menuBar.add(mnSave);

		JMenu mnOpen = new JMenu("Open");
		JMenuItem mn�tmOpen = new JMenuItem("Choose and existing map...");
		class OpenButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
			

				try { JFileChooser fc= new JFileChooser();
				      switch (fc.showOpenDialog(trafficSimulator.this)){
				      case JFileChooser.APPROVE_OPTION:
				    	FileInputStream  fin = new FileInputStream(fc.getSelectedFile());
				    	ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fin));
				    	System.out.println("hata1");
				    	
				    	Map mapToOpen=(Map) ois.readObject();
				    	System.out.println("hata2");
				    	Graphics g = panel.getGraphics();
				    	Road roadToDraw= mapToOpen.getMyRoads().get(1);
						g.drawLine(roadToDraw.getLine().getX(),roadToDraw.getLine().getY(),roadToDraw.getLine().getX1(),roadToDraw.getLine().getY1());
						
				    	
				    	  //JOptionPane.showMessageDialog(trafficSimulator.this, "selected: "+ fc.getSelectedFile(),"TrafficSimulator", JOptionPane.OK_OPTION );
				    	 
				      }
				

				} catch (Exception E) {
					System.out.println(E.getMessage());
				}
			}
		}
		mn�tmOpen.addActionListener(new OpenButtonListener());
		menuBar.add(mnOpen);
		mnOpen.add(mn�tmOpen);
	}

}
