package WindowBuilderTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogoGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogoGUI window = new LogoGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JPanel panel = new JPanel();
		BackgroundPanel panel = new BackgroundPanel("../Icons/logo-bus.png");
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton planTrajetButton = new JButton("Planifier un trajet");
		planTrajetButton.setBounds(112, 25, 244, 29);
		panel.add(planTrajetButton);
		
		planTrajetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InterfaceGUI();
                //fenetreSecondaire.setVisible(true);
			}
		});
		
	}

}
