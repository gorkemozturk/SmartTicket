import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Detail extends JFrame {

	private JPanel contentPane;
	public static String oID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Detail frame = new Detail(toString());
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
		System.out.println(m_ID);
	}
	
	public Detail(String m_ID) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((screen.getWidth() - 600) /2);
		int y = (int) ((screen.getHeight() -600) /2);
		JLabel dynamicOrderNumber = new JLabel("");
		
		JLabel dynamicOwner = new JLabel("");
		dynamicOwner.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel dynamicMovie = new JLabel("");
		dynamicMovie.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel dynamicSession = new JLabel("");
		dynamicSession.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel dynamicSeat = new JLabel("");
		dynamicSeat.setFont(new Font("Tahoma", Font.PLAIN, 11));
		dynamicOrderNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		System.out.println(m_ID);
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_ticket", "root", "");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from orders order by id desc limit 1");
			while (myRs.next()) {
				int orderID = myRs.getInt("id");
				String owner = myRs.getString("owner");
				String movie = myRs.getString("movie");
				String session = myRs.getString("session");
				String seat = myRs.getString("seat");
				
				dynamicOrderNumber.setText(""+orderID);
				dynamicOwner.setText(owner);
				dynamicMovie.setText(movie);
				dynamicSession.setText(session);
				dynamicSeat.setText(seat);
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
		content.setBounds(126, 210, 332, 140);
		contentPane.add(content);

		
		JLabel orderNumber = new JLabel("ORDER NUMBER #");
		orderNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		orderNumber.setForeground(SystemColor.controlDkShadow);
		
		JLabel owner = new JLabel("NAME / SURNAME");
		owner.setFont(new Font("Tahoma", Font.BOLD, 11));
		owner.setForeground(SystemColor.controlDkShadow);
		
		JLabel movie = new JLabel("MOVIE");
		movie.setFont(new Font("Tahoma", Font.BOLD, 11));
		movie.setForeground(SystemColor.controlDkShadow);
		
		JLabel session = new JLabel("SESSION");
		session.setFont(new Font("Tahoma", Font.BOLD, 11));
		session.setForeground(SystemColor.controlDkShadow);
		
		JLabel seat = new JLabel("SEATS");
		seat.setFont(new Font("Tahoma", Font.BOLD, 11));
		seat.setForeground(SystemColor.controlDkShadow);
		
		JSeparator separator = new JSeparator();
		
		JLabel pageTitle = new JLabel("ORDER DETAIL");
		pageTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		GroupLayout gl_content = new GroupLayout(content);
		gl_content.setHorizontalGroup(
			gl_content.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_content.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_content.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
						.addGroup(gl_content.createSequentialGroup()
							.addComponent(orderNumber)
							.addGap(18)
							.addComponent(dynamicOrderNumber))
						.addComponent(pageTitle)
						.addGroup(gl_content.createSequentialGroup()
							.addGroup(gl_content.createParallelGroup(Alignment.LEADING)
								.addComponent(owner)
								.addComponent(movie)
								.addComponent(session)
								.addComponent(seat))
							.addGap(18)
							.addGroup(gl_content.createParallelGroup(Alignment.LEADING)
								.addComponent(dynamicSeat)
								.addComponent(dynamicSession)
								.addComponent(dynamicMovie)
								.addComponent(dynamicOwner))))
					.addContainerGap())
		);
		gl_content.setVerticalGroup(
			gl_content.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_content.createSequentialGroup()
					.addContainerGap()
					.addComponent(pageTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_content.createParallelGroup(Alignment.BASELINE)
						.addComponent(orderNumber)
						.addComponent(dynamicOrderNumber))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_content.createParallelGroup(Alignment.BASELINE)
						.addComponent(owner)
						.addComponent(dynamicOwner))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_content.createParallelGroup(Alignment.BASELINE)
						.addComponent(movie)
						.addComponent(dynamicMovie))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_content.createParallelGroup(Alignment.BASELINE)
						.addComponent(session)
						.addComponent(dynamicSession))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_content.createParallelGroup(Alignment.BASELINE)
						.addComponent(seat)
						.addComponent(dynamicSeat))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		content.setLayout(gl_content);
	}
}
