import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
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
		copyright.setBounds(10, 11, 564, 53);
		footer.add(copyright);
		
		JPanel content = new JPanel();
		content.setBackground(new Color(226, 226, 226));
		content.setBounds(142, 198, 300, 165);
		contentPane.add(content);
		
		JLabel title_1 = new JLabel("LOGIN");
		title_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JSeparator separator = new JSeparator();
		
		JLabel labelUsername = new JLabel("USERNAME");
		labelUsername.setForeground(SystemColor.controlDkShadow);
		labelUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		username = new JTextField();
		username.setBorder(new LineBorder(new Color(171, 173, 179)));
		username.setAlignmentY(Component.TOP_ALIGNMENT);
		username.setAlignmentX(Component.LEFT_ALIGNMENT);
		username.setMargin(new Insets(0, 10, 0, 10));
		username.setMinimumSize(new Dimension(200, 30));
		username.setColumns(10);
		
		password = new JTextField();
		password.setBorder(new LineBorder(new Color(171, 173, 179)));
		password.setAlignmentY(Component.TOP_ALIGNMENT);
		password.setAlignmentX(Component.LEFT_ALIGNMENT);
		password.setMargin(new Insets(0, 10, 0, 10));
		password.setPreferredSize(new Dimension(200, 30));
		password.setColumns(10);
		
		JLabel labelPassword = new JLabel("PASSWORD");
		labelPassword.setForeground(SystemColor.controlDkShadow);
		labelPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		loginButton.setForeground(Color.WHITE);
		loginButton.setHorizontalTextPosition(SwingConstants.CENTER);
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginButton.setMinimumSize(new Dimension(200, 40));
		loginButton.setMaximumSize(new Dimension(200, 40));
		loginButton.setMargin(new Insets(0, 0, 0, 0));
		loginButton.setIcon(new ImageIcon(Login.class.getResource("/images/buttons-bg.png")));
		loginButton.setFocusPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setBorderPainted(false);
		loginButton.setAlignmentY(Component.TOP_ALIGNMENT);
		
		JLabel badLogin = new JLabel("Your username or your password is incorrect. Please try again.");
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass;
				String user;
				user = username.getText();
				pass = password.getText();

				if(user.equals("demo") && pass.equals("1234") ){
					AddMovie add_movie = new AddMovie();
					add_movie.setVisible(true);
					dispose();
				    System.out.println("Succesful Entry.");
				}
				else{
					badLogin.setVisible(true);
				    System.out.println("Wrong Entry!");
				}  
			}
		});
		GroupLayout gl_content = new GroupLayout(content);
		gl_content.setHorizontalGroup(
			gl_content.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_content.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_content.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
						.addComponent(title_1)
						.addGroup(Alignment.TRAILING, gl_content.createSequentialGroup()
							.addComponent(labelUsername, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
							.addComponent(username, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_content.createSequentialGroup()
							.addComponent(labelPassword, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
							.addComponent(password, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addComponent(loginButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_content.setVerticalGroup(
			gl_content.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_content.createSequentialGroup()
					.addContainerGap()
					.addComponent(title_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_content.createParallelGroup(Alignment.BASELINE)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelUsername, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_content.createParallelGroup(Alignment.BASELINE)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelPassword, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		content.setLayout(gl_content);

		badLogin.setHorizontalAlignment(SwingConstants.CENTER);
		badLogin.setBorder(new LineBorder(Color.RED, 2));
		badLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		badLogin.setForeground(Color.RED);
		badLogin.setBounds(10, 86, 564, 35);
		badLogin.setVisible(false);
		contentPane.add(badLogin);
	}
}
