import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class AddMovie extends JFrame {

	private JPanel contentPane;
	private JTextField textMovie;
	private JTextField textTheater;
	private JTextField textFromDate;
	private JTextField textToDate;
	private JTextField textSession;
	private JTextField textImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMovie frame = new AddMovie();
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
	public AddMovie() {
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
		
		JLabel copyright = new JLabel("(C) SmartTicket");
		copyright.setForeground(new Color(128, 128, 128));
		copyright.setFont(new Font("Tahoma", Font.BOLD, 11));
		copyright.setHorizontalAlignment(SwingConstants.CENTER);
		copyright.setBounds(247, 8, 90, 59);
		footer.add(copyright);
		
		JPanel main = new JPanel();
		main.setBackground(new Color(226, 226, 226));
		main.setBounds(123, 127, 337, 306);
		contentPane.add(main);
		
		textMovie = new JTextField();
		textMovie.setAlignmentY(Component.TOP_ALIGNMENT);
		textMovie.setAlignmentX(Component.LEFT_ALIGNMENT);
		textMovie.setPreferredSize(new Dimension(200, 35));
		textMovie.setMinimumSize(new Dimension(200, 35));
		textMovie.setMargin(new Insets(0, 0, 0, 0));
		textMovie.setBorder(new LineBorder(new Color(171, 173, 179)));
		textMovie.setColumns(10);
		
		textTheater = new JTextField();
		textTheater.setBorder(new LineBorder(new Color(171, 173, 179)));
		textTheater.setColumns(10);
		
		textFromDate = new JTextField();
		textFromDate.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFromDate.setColumns(10);
		
		textToDate = new JTextField();
		textToDate.setBorder(new LineBorder(new Color(171, 173, 179)));
		textToDate.setColumns(10);
		
		textSession = new JTextField();
		textSession.setBorder(new LineBorder(new Color(171, 173, 179)));
		textSession.setColumns(10);
		
		textImage = new JTextField();
		textImage.setBorder(new LineBorder(new Color(171, 173, 179)));
		textImage.setColumns(10);
		
		JButton button = new JButton("INSERT");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setPreferredSize(new Dimension(200, 40));
		button.setMinimumSize(new Dimension(200, 40));
		button.setMaximumSize(new Dimension(200, 40));
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setIcon(new ImageIcon(AddMovie.class.getResource("/images/buttons-bg.png")));
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		
		JLabel notification = new JLabel("The insertion process has been successful.");
		notification.setForeground(new Color(0, 128, 0));
		notification.setBorder(new LineBorder(new Color(0, 128, 0), 2));
		notification.setFont(new Font("Tahoma", Font.BOLD, 11));
		notification.setHorizontalAlignment(SwingConstants.CENTER);
		notification.setBounds(10, 86, 564, 30);
		notification.setVisible(false);
		contentPane.add(notification);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String m_name;
				String m_theater;
				String f_date;
				String t_date;
				String m_image;
				String session;
				m_name = textMovie.getText();
				m_theater = textTheater.getText();
				f_date = textFromDate.getText();
				t_date = textToDate.getText();
				m_image = textImage.getText();
				session = textSession.getText();
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_ticket", "root", "");
					Statement myStmt = myConn.createStatement();
					String sql = "insert into movies"
							   + "(name, movie_theater, from_date, to_date, session, image)"
							   + "values ('"+m_name+"', '"+m_theater+"', '"+f_date+"', '"+t_date+"', '"+session+"', '"+m_image+"')";
					myStmt.executeUpdate(sql);
					notification.setVisible(true);
					System.out.println("insert complete");
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_ticket", "root", "");
					Statement myStmt = myConn.createStatement();
					String sql = "insert into seats"
							   + "(a1, a2, a3, b1, b2, b3, c1, c2, c3)"
							   + "values ('0', '0', '0', '0', '0', '0', '0', '0', '0')";
					myStmt.executeUpdate(sql);
					System.out.println("insert complete (seat)");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JLabel movie_name = new JLabel("MOVIE NAME");
		movie_name.setForeground(SystemColor.controlDkShadow);
		movie_name.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel movie_theater = new JLabel("MOVIE THEATER");
		movie_theater.setForeground(SystemColor.controlDkShadow);
		movie_theater.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel from_date = new JLabel("FROM DATE");
		from_date.setForeground(SystemColor.controlDkShadow);
		from_date.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel to_date = new JLabel("TO DATE");
		to_date.setForeground(SystemColor.controlDkShadow);
		to_date.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel session = new JLabel("SESSION");
		session.setForeground(SystemColor.controlDkShadow);
		session.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_7 = new JLabel("IMAGE");
		lblNewLabel_7.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JSeparator separator = new JSeparator();
		
		JLabel title_1 = new JLabel("INSERT MOVIE");
		title_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_main = new GroupLayout(main);
		gl_main.setHorizontalGroup(
			gl_main.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_main.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_main.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
						.addGroup(gl_main.createSequentialGroup()
							.addGroup(gl_main.createParallelGroup(Alignment.LEADING)
								.addComponent(session)
								.addComponent(to_date)
								.addComponent(from_date)
								.addComponent(movie_theater)
								.addComponent(movie_name))
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addGroup(gl_main.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textSession)
								.addComponent(textMovie, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textTheater)
								.addComponent(textFromDate)
								.addComponent(textToDate, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
						.addGroup(gl_main.createSequentialGroup()
							.addComponent(lblNewLabel_7)
							.addGap(80)
							.addGroup(gl_main.createParallelGroup(Alignment.LEADING)
								.addComponent(textImage, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
								.addComponent(button, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
						.addComponent(title_1))
					.addContainerGap())
		);
		gl_main.setVerticalGroup(
			gl_main.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_main.createSequentialGroup()
					.addContainerGap()
					.addComponent(title_1)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_main.createParallelGroup(Alignment.BASELINE)
						.addComponent(textMovie, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(movie_name))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_main.createParallelGroup(Alignment.BASELINE)
						.addComponent(textTheater, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(movie_theater))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_main.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFromDate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(from_date))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_main.createParallelGroup(Alignment.BASELINE)
						.addComponent(textToDate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(to_date))
					.addGap(7)
					.addGroup(gl_main.createParallelGroup(Alignment.BASELINE)
						.addComponent(textSession, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(session))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_main.createParallelGroup(Alignment.BASELINE)
						.addComponent(textImage, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7))
					.addGap(6)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		main.setLayout(gl_main);
	}
}
