import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Cursor;

public class Index extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((screen.getWidth() - 600) /2);
		int y = (int) ((screen.getHeight() -600) /2);
		setTitle("SmartTicket");
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
		content.setBounds(192, 220, 200, 120);
		contentPane.add(content);
		content.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton buttonInsert = new JButton("INSERT MOVIE");
		buttonInsert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  // sýnýrlar içerisinde el resmi çýkar
		buttonInsert.setForeground(Color.WHITE);
		buttonInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonInsert.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonInsert.setPreferredSize(new Dimension(200, 40));
		buttonInsert.setIcon(new ImageIcon(Index.class.getResource("/images/buttons-bg.png")));
		buttonInsert.setFocusPainted(false);
		buttonInsert.setContentAreaFilled(false);
		buttonInsert.setBorderPainted(false);
		buttonInsert.setMargin(new Insets(0, 0, 0, 0));
		buttonInsert.setAlignmentY(Component.TOP_ALIGNMENT);
		buttonInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login lgn = new Login();
				lgn.setVisible(true);
				dispose();
			}
		});
		content.add(buttonInsert);
		
		JButton buttonView = new JButton("VIEW MOVIES");
		buttonView.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonView.setForeground(Color.WHITE);
		buttonView.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonView.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonView.setPreferredSize(new Dimension(200, 40));
		buttonView.setIcon(new ImageIcon(Index.class.getResource("/images/buttons-bg.png")));
		buttonView.setFocusPainted(false);
		buttonView.setContentAreaFilled(false);
		buttonView.setBorderPainted(false);
		buttonView.setMargin(new Insets(0, 0, 0, 0));
		buttonView.setAlignmentY(Component.TOP_ALIGNMENT);
		buttonView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Movies mvs = new Movies();
				mvs.setVisible(true);
				dispose();
			}
		});
		
		JLabel separator = new JLabel("");
		separator.setIcon(new ImageIcon(Index.class.getResource("/images/hr.jpg")));
		content.add(separator);
		content.add(buttonView);
	}
}
