import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.Component;

public class Movies extends JFrame {

	private JPanel contentPane;
	public static int counter = 1;
	public static int secondCounter = 1;
	public String m_name;
	public String m_session;
	public String m_ID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movies frame = new Movies();
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
	public Movies() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((screen.getWidth() - 600) /2);
		int y = (int) ((screen.getHeight() -600) /2);
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
		
		JButton nextButton = new JButton("");
		nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nextButton.setIcon(new ImageIcon(Movies.class.getResource("/images/next-button-bg.png")));
		nextButton.setFocusPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setBorderPainted(false);
		
		JButton previousButton = new JButton("");
		previousButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		previousButton.setIcon(new ImageIcon(Movies.class.getResource("/images/previous-button-bg.png")));
		previousButton.setFocusPainted(false);
		previousButton.setContentAreaFilled(false);
		previousButton.setBorderPainted(false);
		JLabel banner = new JLabel("");
		JLabel dynamicSession = new JLabel("");
		
		JLabel dynamicFromDate = new JLabel();
		dynamicFromDate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		JLabel dynamicToDate = new JLabel();
		dynamicToDate.setFont(new Font("Tahoma", Font.PLAIN, 11));

		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_ticket", "root", "");
					Statement myStmt = myConn.createStatement();
					ResultSet myRs = myStmt.executeQuery("select * from movies where id=1+'"+ secondCounter++ +"'"); // FOR FOOTER
					while (myRs.next()) {
						String f_date = myRs.getString("from_date");
						String t_date = myRs.getString("to_date");
						String session = myRs.getString("session");
						dynamicFromDate.setText(f_date);
						dynamicToDate.setText(t_date);
						dynamicSession.setText(session);
					}
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
		
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (counter <= 0) {
					System.out.println("Wrong");
				}else {
					try {
						Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_ticket", "root", "");
						Statement myStmt = myConn.createStatement();
						ResultSet myRs = myStmt.executeQuery("select * from movies where id='"+ secondCounter-- +"'-1");
						while (myRs.next()) {
							String f_date = myRs.getString("from_date");
							String t_date = myRs.getString("to_date");
							String session = myRs.getString("session");
							dynamicFromDate.setText(f_date);
							dynamicToDate.setText(t_date);
							dynamicSession.setText(session);
						}
					}catch (Exception e){
						e.printStackTrace();
					}
				}
			}
		});
		
		dynamicFromDate.setBounds(81, 17, 60, 14);
		footer.add(dynamicFromDate);
		
		dynamicToDate.setBounds(63, 30, 60, 14);
		footer.add(dynamicToDate);
		
		JPanel content = new JPanel();
		content.setBounds(0, 75, 584, 410);
		contentPane.add(content);
		content.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_ticket", "root", "");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from movies where id='1'");
			while (myRs.next()) {
				m_name = myRs.getString("name");
				String img = myRs.getString("image");
				m_ID = myRs.getString("id");
				m_session = myRs.getString("session");
				String t_date = myRs.getString("to_date");
				String f_date = myRs.getString("from_date");
				banner.setIcon(new ImageIcon(Movies.class.getResource("/uploads/"+img)));
				dynamicToDate.setText(t_date);
				dynamicFromDate.setText(f_date);
				dynamicSession.setText(m_session);
				System.out.println("Film adý: " +m_name+ " ID: " +m_ID+ " Counter: " +counter+ " Session: " +m_session);
			}
		}catch (Exception e){
			e.printStackTrace();
		}

		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (counter <= 0) {
					System.out.println("Wrong");
				}else {
					try {
						Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_ticket", "root", "");
						Statement myStmt = myConn.createStatement();
						ResultSet myRs = myStmt.executeQuery("select * from movies where id='"+counter-- +"'-1");
						while (myRs.next()) {
							m_name = myRs.getString("name");
							String img = myRs.getString("image");
							m_ID = myRs.getString("id");
							m_session = myRs.getString("session");
							banner.setIcon(new ImageIcon(Movies.class.getResource("/uploads/"+img)));
							System.out.println("Film adý: " +m_name+ " ID: " +m_ID+ " Counter: " +counter+ " Session: " +m_session);
						}
					}catch (Exception e){
						e.printStackTrace();
					}
				}
			}
		});
		
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_ticket", "root", "");
					Statement myStmt = myConn.createStatement();
					ResultSet myRs = myStmt.executeQuery("select * from movies where id=1+'"+ counter++ +"'");
					while (myRs.next()) {
						m_name = myRs.getString("name");
						String img = myRs.getString("image");
						m_ID = myRs.getString("id");
						m_session = myRs.getString("session");
						banner.setIcon(new ImageIcon(Movies.class.getResource("/uploads/"+img)));
						System.out.println("Film adý: " +m_name+ " ID: " +m_ID+ " Counter: " +counter+ " Session: " +m_session);
					}
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
		
		JButton applyButton = new JButton("APPLY THIS MOVIE");
		applyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		applyButton.setForeground(Color.WHITE);
		applyButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		applyButton.setAlignmentY(Component.TOP_ALIGNMENT);
		applyButton.setHorizontalTextPosition(SwingConstants.CENTER);
		applyButton.setMargin(new Insets(0, 0, 0, 0));
		applyButton.setMinimumSize(new Dimension(200, 40));
		applyButton.setMaximumSize(new Dimension(200, 40));
		applyButton.setIcon(new ImageIcon(Movies.class.getResource("/images/button_2.png")));
		applyButton.setFocusPainted(false);
		applyButton.setContentAreaFilled(false);
		applyButton.setBorderPainted(false);
		
		applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order orderFrame = new Order(m_ID);
				orderFrame.getValues(m_name, m_session, m_ID);
				orderFrame.setVisible(true);
				dispose();
			}
		});

		applyButton.setBounds(374, 17, 200, 40);
		footer.add(applyButton);
		
		JLabel fromDate = new JLabel("FROM DATE:");
		fromDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		fromDate.setBounds(10, 17, 67, 14);
		footer.add(fromDate);
		
		JLabel toDate = new JLabel("TO DATE:");
		toDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		toDate.setBounds(10, 30, 50, 14);
		footer.add(toDate);
		
		JLabel session = new JLabel("SESSION:");
		session.setFont(new Font("Tahoma", Font.BOLD, 11));
		session.setBounds(10, 43, 50, 14);
		footer.add(session);
		

		dynamicSession.setFont(new Font("Tahoma", Font.PLAIN, 11));
		dynamicSession.setBounds(64, 43, 59, 14);
		footer.add(dynamicSession);

		content.add(previousButton);
		content.add(banner);
		content.add(nextButton);
	}
}
