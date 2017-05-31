import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;
import java.awt.Cursor;
import java.awt.Dimension;

public class Order extends JFrame {

	private JPanel contentPane;
	public static String oID;
	
	private JTextField textSession;
	private JTextField textMovie;
	private JTextField textName;
	
	private int a1;
	private int a2;
	private int a3;
	private int b1;
	private int b2;
	private int b3;
	private int c1;
	private int c2;
	private int c3;
	
	private String owner;
	private String movie;
	private String session;
	
	private int controlA1;
	private int controlA2;
	private int controlA3;
	private int controlB1;
	private int controlB2;
	private int controlB3;
	private int controlC1;
	private int controlC2;
	private int controlC3;
	
	private String inputA1;
	private String inputA2;
	private String inputA3;
	private String inputB1;
	private String inputB2;
	private String inputB3;
	private String inputC1;
	private String inputC2;
	private String inputC3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order(toString());
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
	void getValues(String string, String string2, String m_ID) {
		textSession.setText(string2);
		textMovie.setText(string);
		System.out.println(m_ID);
	}
	
	public Order(String m_ID) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((screen.getWidth() - 600) /2);
		int y = (int) ((screen.getHeight() -600) /2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_ticket", "root", "");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from seats where id='"+ m_ID +"'");
			while (myRs.next()) {
				a1 = myRs.getInt("a1");
				a2 = myRs.getInt("a2");
				a3 = myRs.getInt("a3");
				b1 = myRs.getInt("b1");
				b2 = myRs.getInt("b2");
				b3 = myRs.getInt("b3");
				c1 = myRs.getInt("c1");
				c2 = myRs.getInt("c2");
				c3 = myRs.getInt("c3");
				
				System.out.println("A1: " + a1);
				System.out.println("A2: " + a2);
				System.out.println("A3: " + a3);
				System.out.println("B1: " + b1);
				System.out.println("B2: " + b2);
				System.out.println("B3: " + b3);
				System.out.println("C1: " + c1);
				System.out.println("C2: " + c2);
				System.out.println("C3: " + c3);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(226, 226, 226));
		header.setBounds(0, 0, 584, 75);
		contentPane.add(header);
		header.setLayout(null);
		
		JLabel title = new JLabel("SmartTicket");
		title.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 32));
		title.setBounds(10, 11, 156, 53);
		header.add(title);
		
		JLabel subtitle = new JLabel("BETA");
		subtitle.setForeground(new Color(128, 128, 128));
		subtitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		subtitle.setBounds(170, 40, 28, 14);
		header.add(subtitle);
		
		JButton homePageButton = new JButton("HOMEPAGE");
		homePageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index ind = new Index();
				ind.setVisible(true);
				dispose();
			}
		});
		homePageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homePageButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		homePageButton.setFocusPainted(false);
		homePageButton.setContentAreaFilled(false);
		homePageButton.setBorderPainted(false);
		homePageButton.setIcon(null);
		homePageButton.setBounds(481, 17, 100, 40);
		header.add(homePageButton);
		
		JPanel footer = new JPanel();
		footer.setBackground(new Color(226, 226, 226));
		footer.setBounds(0, 486, 584, 75);
		contentPane.add(footer);
		footer.setLayout(null);
		
		JLabel copyright = new JLabel("(C) SmartTicket");
		copyright.setForeground(new Color(128, 128, 128));
		copyright.setFont(new Font("Tahoma", Font.BOLD, 11));
		copyright.setHorizontalAlignment(SwingConstants.CENTER);
		copyright.setBounds(10, 10, 564, 53);
		footer.add(copyright);
		
		JPanel content = new JPanel();
		content.setForeground(Color.LIGHT_GRAY);
		content.setBackground(new Color(226, 226, 226));
		content.setBounds(126, 128, 332, 305);
		contentPane.add(content);
		
		textSession = new JTextField();
		textSession.setEditable(false);
		textSession.setColumns(10);
		
		textMovie = new JTextField();
		textMovie.setEditable(false);
		textMovie.setColumns(10);
		
		textName = new JTextField();
		textName.setBorder(new LineBorder(new Color(171, 173, 179)));
		textName.setColumns(10);
		
		JToggleButton toggleA1 = new JToggleButton("A1");
		
		JToggleButton toggleA2 = new JToggleButton("A2");
		
		JToggleButton toggleA3 = new JToggleButton("A3");
		
		JToggleButton toggleB1 = new JToggleButton("B1");
		
		JToggleButton toggleB2 = new JToggleButton("B2");
		
		JToggleButton toggleB3 = new JToggleButton("B3");
		
		JToggleButton toggleC1 = new JToggleButton("C1");
		
		JToggleButton toggleC2 = new JToggleButton("C2");
		
		JToggleButton toggleC3 = new JToggleButton("C3");
		
		if (a1 == 1) {
			toggleA1.setEnabled(false);
		} 
		if (a2 == 1) {
			toggleA3.setEnabled(false);
		}
		if (a3 == 1) {
			toggleA2.setEnabled(false);
		}
		if (b1 == 1) {
			toggleB1.setEnabled(false);
		}
		if (b2 == 1) {
			toggleB2.setEnabled(false);
		}
		if (b3 == 1) {
			toggleB3.setEnabled(false);
		}
		if (c1 == 1) {
			toggleC1.setEnabled(false);
		}
		if (c2 == 1) {
			toggleC2.setEnabled(false);
		}
		if (c3 == 1) {
			toggleC3.setEnabled(false);
		}
		
		JButton button = new JButton("BUY TICKET");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setIcon(new ImageIcon(Order.class.getResource("/images/buttons-bg.png")));
		button.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				owner = textName.getText();
				movie = textMovie.getText();
				session = textSession.getText();
				
				if (toggleA1.isSelected()) {
					inputA1 = "A1";
				}else { 
					inputA1 = ""; 
				}
				if (toggleA3.isSelected()) {
					inputA2 = "A2";
				}else { 
					inputA2 = ""; 
				}
				if (toggleA2.isSelected()) {
					inputA3 = "A3";
				}else { 
					inputA3 = ""; 
				}
				if (toggleB1.isSelected()) {
					inputB1 = "B1";
				}else { 
					inputB1 = ""; 
				}
				if (toggleB2.isSelected()) {
					inputB2 = "B2";
				}else { 
					inputB2 = ""; 
				}
				if (toggleB3.isSelected()) {
					inputB3 = "B3";
				}else { 
					inputB3 = ""; 
				}
				if (toggleC1.isSelected()) {
					inputC1 = "C1";
				}else { 
					inputC1 = ""; 
				}
				if (toggleC2.isSelected()) {
					inputC2 = "C2";
				}else { 
					inputC2 = ""; 
				}
				if (toggleC3.isSelected()) {
					inputC3 = "C3";
				}else { 
					inputC3 = ""; 
				}
				
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_ticket", "root", "");
					Statement myStmt = myConn.createStatement();
					String sql = "insert into orders"
							   + "(owner, movie, session, seat)"
							   + "values ('"+owner+"', '"+movie+"', '"+session+"', '"+inputA1+" "+inputA2+" "+inputA3+" "+inputB1+" "+inputB2+" "+inputB3+" "+inputC1+" "+inputC2+" "+inputC3+"')";
					myStmt.executeUpdate(sql);
					System.out.println("insert complete");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if (toggleA1.isSelected() || toggleA1.isEnabled() == false) {
					controlA1 = 1;
				}else { 
					controlA1 = 0; 
				}
				if (toggleA3.isSelected() || toggleA3.isEnabled() == false) {
					controlA2 = 1;
				}else { 
					controlA2 = 0; 
				}
				if (toggleA2.isSelected() || toggleA2.isEnabled() == false) {
					controlA3 = 1;
				}else { 
					controlA3 = 0; 
				}
				if (toggleB1.isSelected() || toggleB1.isEnabled() == false) {
					controlB1 = 1;
				}else { 
					controlB1 = 0; 
				}
				if (toggleB2.isSelected() || toggleB2.isEnabled() == false) {
					controlB2 = 1;
				}else { 
					controlB2 = 0; 
				}
				if (toggleB3.isSelected() || toggleB3.isEnabled() == false) {
					controlB3 = 1;
				}else { 
					controlB3 = 0; 
				}
				if (toggleC1.isSelected() || toggleC1.isEnabled() == false) {
					controlC1 = 1;
				}else { 
					controlC1 = 0; 
				}
				if (toggleC2.isSelected() || toggleC2.isEnabled() == false) {
					controlC2 = 1;
				}else { 
					controlC2 = 0; 
				}
				if (toggleC3.isSelected() || toggleC3.isEnabled() == false) {
					controlC3 = 1;
				}else { 
					controlC3 = 0; 
				}
				
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_ticket", "root", "");
					Statement myStmt = myConn.createStatement();
					String sql = "update seats set a1 = '"+controlA1+"', a2 = '"+controlA2+"', a3 = '"+controlA3+"', b1 = '"+controlB1+"', b2 = '"+controlB2+"', b3 = '"+controlB3+"',  c1 = '"+controlC1+"', c2 = '"+controlC2+"', c3 = '"+controlC3+"' where id = '"+m_ID+"'";
					myStmt.executeUpdate(sql);
					System.out.println("update complete");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Detail dtl = new Detail(m_ID );
				dtl.setVisible(true);
				dispose();
			}
		});
		

		
		JSeparator bottomSeparator = new JSeparator();
		
		JSeparator topSeparator = new JSeparator();
		
		JLabel title_1 = new JLabel("BUY TICKET");
		title_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblName = new JLabel("NAME / SURNAME");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setForeground(SystemColor.controlDkShadow);
		
		JLabel lblMovie = new JLabel("MOVIE");
		lblMovie.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMovie.setForeground(SystemColor.controlDkShadow);
		
		JLabel lblSession = new JLabel("SESSION");
		lblSession.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSession.setForeground(SystemColor.controlDkShadow);
		
		JLabel lblSeat = new JLabel("SEATS");
		lblSeat.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeat.setForeground(SystemColor.controlDkShadow);
		
		GroupLayout gl_content = new GroupLayout(content);
		gl_content.setHorizontalGroup(
			gl_content.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_content.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_content.createParallelGroup(Alignment.LEADING)
						.addComponent(topSeparator, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
						.addComponent(bottomSeparator, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_content.createSequentialGroup()
							.addComponent(lblSeat)
							.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
							.addGroup(gl_content.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_content.createSequentialGroup()
									.addGroup(gl_content.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_content.createSequentialGroup()
											.addComponent(toggleB1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(toggleB2))
										.addGroup(gl_content.createSequentialGroup()
											.addComponent(toggleC1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(toggleC2))
										.addGroup(gl_content.createSequentialGroup()
											.addComponent(toggleA1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(toggleA2)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_content.createParallelGroup(Alignment.TRAILING)
										.addComponent(toggleC3)
										.addComponent(toggleB3)
										.addComponent(toggleA3)))
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_content.createSequentialGroup()
							.addComponent(lblName)
							.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
							.addComponent(textName, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_content.createSequentialGroup()
							.addComponent(lblMovie)
							.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
							.addComponent(textMovie, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_content.createSequentialGroup()
							.addComponent(lblSession)
							.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
							.addComponent(textSession, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
						.addComponent(title_1))
					.addContainerGap())
		);
		gl_content.setVerticalGroup(
			gl_content.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_content.createSequentialGroup()
					.addContainerGap()
					.addComponent(title_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(topSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_content.createParallelGroup(Alignment.BASELINE)
						.addComponent(textName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_content.createParallelGroup(Alignment.BASELINE)
						.addComponent(textMovie, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMovie))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_content.createParallelGroup(Alignment.BASELINE)
						.addComponent(textSession, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSession))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_content.createParallelGroup(Alignment.BASELINE)
						.addComponent(toggleA3)
						.addComponent(toggleA2)
						.addComponent(toggleA1)
						.addComponent(lblSeat))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_content.createParallelGroup(Alignment.BASELINE)
						.addComponent(toggleB3)
						.addComponent(toggleB2)
						.addComponent(toggleB1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_content.createParallelGroup(Alignment.BASELINE)
						.addComponent(toggleC3)
						.addComponent(toggleC2)
						.addComponent(toggleC1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bottomSeparator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		content.setLayout(gl_content);
	}
}
