package WindowBuilderTest;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Toolkit;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;

public class InterfaceGUI {

	private JFrame frame;

	static Random rand = new Random();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGUI window = new InterfaceGUI();
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
	public InterfaceGUI() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/macbookpro/Downloads/logo-bus.png"));
		frame.setSize(600,680);
		frame.setTitle("Interface");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		//BackgroundPanel panel = new BackgroundPanel("../Icons/logo-bus.png");
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane(panel,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.getContentPane().add(scrollPane);

		JLabel welcomeLabel = new JLabel("Bienvenue dans notre application");
		welcomeLabel.setBounds(129, 6, 219, 38);
		panel.add(welcomeLabel);

		JLabel pointDLabel = new JLabel("Choisir votre point de départ");
		pointDLabel.setBounds(6, 52, 187, 16);
		panel.add(pointDLabel);

		JLabel pointALabel = new JLabel("Choisir un point d'arrivé");
		pointALabel.setBounds(6, 104, 187, 16);
		panel.add(pointALabel);

		JButton submitButton = new JButton("Rechercher");
		submitButton.setBounds(171, 143, 117, 29);
		panel.add(submitButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(78, 176, 274, 6);
		panel.add(separator);

		JLabel choixTrajetLabel = new JLabel("Veuillez choisir un itinéraire");
		choixTrajetLabel.setBounds(130, 182, 194, 26);
		choixTrajetLabel.setVisible(false);
		panel.add(choixTrajetLabel);

		JRadioButton trajetA_radioButton = new JRadioButton("Itinéraire A");
		trajetA_radioButton.setBounds(6, 230, 165, 23);
		trajetA_radioButton.setVisible(false);
		panel.add(trajetA_radioButton);

		JRadioButton trajetB_radioButton = new JRadioButton("Itinéraire B");
		trajetB_radioButton.setBounds(299, 230, 176, 23);
		trajetB_radioButton.setVisible(false);
		panel.add(trajetB_radioButton);

		JLabel detailIti_Label = new JLabel("Détails de l'itinéraire");
		detailIti_Label.setBounds(6, 271, 187, 16);
		detailIti_Label.setVisible(false);
		panel.add(detailIti_Label);

		JScrollPane scrollPane_1 = new JScrollPane();
		//scrollPane_1.setVisible(false);
		scrollPane_1.setBounds(6, 288, 279, 62);
		panel.add(scrollPane_1);

		JTextArea detailIti_textArea = new JTextArea();
		//passagesH_textArea.setVisible(false);
		scrollPane_1.setViewportView(detailIti_textArea);

		JLabel incidentsLabel = new JLabel("Incidents de parcours");
		incidentsLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		incidentsLabel.setBounds(6, 424, 558, 16);
		incidentsLabel.setVisible(false);
		panel.add(incidentsLabel);

		JLabel stationsList_Label = new JLabel("Liste des stations");
		stationsList_Label.setBounds(324, 271, 187, 16);
		panel.add(stationsList_Label);

		JTextArea passagesReel_textArea = new JTextArea("");
		passagesReel_textArea.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		passagesReel_textArea.setBounds(326, 290, 238, 131);
		//passagesReel_textArea.setVisible(false);
		panel.add(passagesReel_textArea);

		JComboBox pointA_comboBox = new JComboBox();
		pointA_comboBox.setBounds(262, 85, 165, 46);

		JComboBox pointD_comboBox = new JComboBox();
		pointD_comboBox.setBounds(262, 48, 165, 27);
		panel.add(pointD_comboBox);

		//ajouter des lieux a nos checkbox
		ArrayList<String> lieux = new ArrayList<>(Arrays.asList("A. UQO","B. CENTRE-RIDEAU","C. UOTTAWA","D. GALERIE-HULL","E. PROMENADES","F. HOPITAL-HULL","G. BOSTON-PIZZA"));
		for (int i=0; i<lieux.size(); i++) {
			pointA_comboBox.addItem(lieux.get(i).toString());
			pointD_comboBox.addItem(lieux.get(i).toString());
			passagesReel_textArea.append(lieux.get(i)+"\n");
		}
		panel.add(pointA_comboBox);


		JLabel bus1_icon = new JLabel("");
		bus1_icon.setBounds(94, 452, 101, 92);
		bus1_icon.setVisible(false);
		panel.add(bus1_icon);

		JLabel bus1_label = new JLabel("Vérifier places");
		bus1_label.setBounds(6, 490, 101, 16);
		panel.add(bus1_label);

		JLabel bus2_label = new JLabel("Bus b2");
		bus2_label.setBounds(224, 490, 61, 16);
		bus2_label.setVisible(false);
		panel.add(bus2_label);

		JLabel bus2_icon = new JLabel("");
		//bus2_icon.setIcon(new ImageIcon("/Users/macbookpro/Library/CloudStorage/OneDrive-UniversitéduQuébecenOutaouais/UQO/Session 2/INF1573-01 Programmation II/ProjetSession_Codes/Icons/autobus_rouge.png"));
		bus2_icon.setBounds(275, 452, 102, 92);
		bus2_icon.setVisible(false);
		panel.add(bus2_icon);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 369, 282, 52);
		panel.add(scrollPane_2);

		JTextArea passageH_textArea = new JTextArea();
		scrollPane_2.setViewportView(passageH_textArea);

		JLabel passagesH_Label = new JLabel("Horaire prévu des bus");
		passagesH_Label.setBounds(6, 351, 148, 16);
		passagesH_Label.setVisible(false);
		panel.add(passagesH_Label);

		JLabel bus4_label = new JLabel("Bus b4");
		bus4_label.setBounds(6, 573, 61, 16);
		bus4_label.setVisible(false);
		panel.add(bus4_label);

		JLabel bus4_icon = new JLabel("");
		//bus4_icon.setIcon(new ImageIcon("/Users/macbookpro/Library/CloudStorage/OneDrive-UniversitéduQuébecenOutaouais/UQO/Session 2/INF1573-01 Programmation II/ProjetSession_Codes/Icons/autobus_rouge.png"));
		bus4_icon.setBounds(94, 543, 99, 90);
		bus4_icon.setVisible(false);
		panel.add(bus4_icon);

		JLabel bus5_label = new JLabel("Bus b5");
		bus5_label.setBounds(224, 573, 61, 16);
		bus5_label.setVisible(false);
		panel.add(bus5_label);

		JLabel bus5_icon = new JLabel("");
		//bus5_icon.setIcon(new ImageIcon("/Users/macbookpro/Library/CloudStorage/OneDrive-UniversitéduQuébecenOutaouais/UQO/Session 2/INF1573-01 Programmation II/ProjetSession_Codes/Icons/autobus_vert.png"));
		bus5_icon.setBounds(275, 544, 102, 89);
		bus5_icon.setVisible(false);
		panel.add(bus5_icon);

		JLabel bus3_label = new JLabel("Bus b3");
		bus3_label.setBounds(400, 490, 61, 16);
		bus3_label.setVisible(false);
		panel.add(bus3_label);

		JLabel bus3_icon = new JLabel("");
		//bus3_icon.setIcon(new ImageIcon("/Users/macbookpro/Library/CloudStorage/OneDrive-UniversitéduQuébecenOutaouais/UQO/Session 2/INF1573-01 Programmation II/ProjetSession_Codes/Icons/autobus_vert.png"));
		bus3_icon.setBounds(451, 460, 101, 84);
		bus3_icon.setVisible(false);
		panel.add(bus3_icon);

		JLabel bus6_label = new JLabel("Bus b6");
		bus6_label.setBounds(389, 573, 61, 16);
		bus6_label.setVisible(false);
		panel.add(bus6_label);

		JLabel bus6_icon = new JLabel("");
		//bus6_icon.setIcon(new ImageIcon("/Users/macbookpro/Library/CloudStorage/OneDrive-UniversitéduQuébecenOutaouais/UQO/Session 2/INF1573-01 Programmation II/ProjetSession_Codes/Icons/autobus_rouge.png"));
		bus6_icon.setBounds(451, 549, 101, 84);
		bus6_icon.setVisible(false);
		panel.add(bus6_icon);

		/*On créé notre reseau routier depuis la methode listeTrajets() dans
		 * dans la classe ReseauRoutier
		 */
		ReseauRoutier network = new ReseauRoutier();
		network.listeTrajets();

		/*On recupere les differents bus de nos stations puis
		 * puis s'ils ont de la places, on les affiche en vert
		 */
		Bus b1 = new Bus(network.stations.get(0).getBus().get(0).getID());
		Bus b2 = new Bus(network.stations.get(1).getBus().get(0).getID());
		Bus b3 = new Bus(network.stations.get(2).getBus().get(0).getID());
		Bus b4 = new Bus(network.stations.get(3).getBus().get(0).getID());
		Bus b5 = new Bus(network.stations.get(4).getBus().get(0).getID());
		Bus b6 = new Bus(network.stations.get(6).getBus().get(0).getID());

		bus1_icon.setIcon(Bus.iconBus(b1));
		bus2_icon.setIcon(Bus.iconBus(b2));		
		bus3_icon.setIcon(Bus.iconBus(b3));		
		bus4_icon.setIcon(Bus.iconBus(b4));		
		bus5_icon.setIcon(Bus.iconBus(b5));		
		bus6_icon.setIcon(Bus.iconBus(b6));		

		//Ecouteur d'evenement pour les boutons
		ActionListener actionListener = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				//affichage des differents elements cachés
				choixTrajetLabel.setVisible(true);
				trajetA_radioButton.setVisible(true);
				trajetB_radioButton.setVisible(true);
				detailIti_Label.setVisible(true);
				passagesH_Label.setVisible(true);
				stationsList_Label.setVisible(true);

				/*
				 * Recupérer et traiter les informations quand l'utilisateur 
				 * choisit une station
				 */
				int dist = 0; //va nous servir a calculer la distance la plus courte entre deux stations avec l'algo de Djisktra

				//on recupere les valeurs selectionnés
				String itemSelected_depart = (String)pointD_comboBox.getSelectedItem(); //station de depart
				String itemSelected_arrive = (String)pointA_comboBox.getSelectedItem(); //station d'arrivé
				String schema = "";	//va nous servir pour afficher l'itinéraire
				String horaire="";	//va nous servir pour afficher les horaires des bus
				String incident="";	//va nous servir l'etat de la route sur un trajet
				String schema_long="";
				int dist_normale = 0;	//pour afficher l'itinéraire normal

				switch(itemSelected_depart) {
				case "A. UQO": //point de depart est UQO = Station A
					ArrayList<Bus> listeBusA = new ArrayList<>();	//liste des bus de la station A
					listeBusA = network.stations.get(0).getBus();

					for(int i=0; i<lieux.size(); i++) {	

						if(itemSelected_arrive==lieux.get(i).toString()) {	//point arrivé va aller de Rideau(station B) a hopital(station F)
							dist = network.shortestPath(network.stations.get(0), network.stations.get(i));
							//ArrayList<Bus> listes = network.stations.get(i).getBus(); 
							schema = network.shortPath(network.stations.get(0), network.stations.get(i)); //pour achiffer l'itinéraire
							schema_long = network.findPathAsString(network.stations.get(0), network.stations.get(i));

							dist_normale = network.normalDist;

							horaire = network.busItinarySchedule(network.stations.get(0), network.stations.get(i));

							incident = network.incident;
						}
					}

					break;

				case "B. CENTRE-RIDEAU":
					for(int i=0; i<lieux.size(); i++) {

						if(itemSelected_arrive==lieux.get(i).toString()) {	//point arrivé va aller de Rideau(station B) a hopital(station F)
							//dist = network.shortestPath(network.trajets.get(1).startStation, network.trajets.get(i).endStation);
							dist = network.shortestPath(network.stations.get(1), network.stations.get(i));
							schema = network.shortPath(network.stations.get(1), network.stations.get(i)); //pour achiffer l'itinéraire
							schema_long = network.findPathAsString(network.stations.get(1), network.stations.get(i));
							horaire = network.busItinarySchedule(network.stations.get(1), network.stations.get(i));
							incident = network.incident;
						}
					}
					break;

				case "C. UOTTAWA":
					for(int i=0; i<lieux.size(); i++) {

						if(itemSelected_arrive==lieux.get(i).toString()) {	//point arrivé va aller de Rideau(station B) a hopital(station F)
							//dist = network.shortestPath(network.trajets.get(2).startStation, network.trajets.get(i).endStation);
							dist = network.shortestPath(network.stations.get(2), network.stations.get(i));
							//trajetA_radioButton.setText(network.trajets.get(1).startStation.getID()+";"+network.trajets.get(i).endStation.getID()+"="+lieux[i]+";"+dist+"km");
							schema = network.shortPath(network.stations.get(2), network.stations.get(i)); //pour achiffer l'itinéraire

							horaire = network.busItinarySchedule(network.stations.get(2), network.stations.get(i));
							incident = network.incident;
						}
					}
					break;

				case "D. GALERIE-HULL":
					for(int i=0; i<lieux.size(); i++) {

						if(itemSelected_arrive==lieux.get(i).toString()) {	//point arrivé va aller de Rideau(station B) a hopital(station F)
							//dist = network.shortestPath(network.trajets.get(3).startStation, network.trajets.get(i).endStation);
							dist = network.shortestPath(network.stations.get(3), network.stations.get(i));
							//trajetA_radioButton.setText(network.trajets.get(1).startStation.getID()+";"+network.trajets.get(i).endStation.getID()+"="+lieux[i]+";"+dist+"km");
							schema = network.shortPath(network.stations.get(3), network.stations.get(i)); //pour achiffer l'itinéraire

							horaire = network.busItinarySchedule(network.stations.get(3), network.stations.get(i));
							incident = network.incident;
						}

					}
					break;

				case "E. PROMENADES":
					for(int i=0; i<lieux.size(); i++) {

						if(itemSelected_arrive==lieux.get(i).toString()) {	//point arrivé va aller de Rideau(station B) a hopital(station F)
							//dist = network.shortestPath(network.trajets.get(4).startStation, network.trajets.get(i).endStation);
							dist = network.shortestPath(network.stations.get(4), network.stations.get(i));

							//trajetA_radioButton.setText(network.trajets.get(1).startStation.getID()+";"+network.trajets.get(i).endStation.getID()+"="+lieux[i]+";"+dist+"km");
							schema = network.shortPath(network.stations.get(4), network.stations.get(i)); //pour achiffer l'itinéraire
							horaire = network.busItinarySchedule(network.stations.get(4), network.stations.get(i));
							incident = network.incident;
						}
					}
					break;

				case "F. HOPITAL-HULL":
					for(int i=0; i<lieux.size(); i++) {

						if(itemSelected_arrive==lieux.get(i).toString()) {	//point arrivé va aller de Rideau(station B) a hopital(station F)
							//dist = network.shortestPath(network.trajets.get(5).startStation, network.trajets.get(i).endStation);
							dist = network.shortestPath(network.stations.get(5), network.stations.get(i));

							//trajetA_radioButton.setText(network.trajets.get(1).startStation.getID()+";"+network.trajets.get(i).endStation.getID()+"="+lieux[i]+";"+dist+"km");
							schema = network.shortPath(network.stations.get(5), network.stations.get(i)); //pour achiffer l'itinéraire

							horaire = network.busItinarySchedule(network.stations.get(5), network.stations.get(i));
							incident = network.incident;
						}

					}
				case "G. BOSTON-PIZZA":
					for(int i=0; i<lieux.size(); i++) {

						if(itemSelected_arrive==lieux.get(i).toString()) {	//point arrivé va aller de Rideau(station B) a hopital(station F)
							//dist = network.shortestPath(network.trajets.get(1).startStation, network.trajets.get(i).endStation);
							dist = network.shortestPath(network.stations.get(6), network.stations.get(i));
							schema = network.shortPath(network.stations.get(6), network.stations.get(i)); //pour achiffer l'itinéraire

							horaire = network.busItinarySchedule(network.stations.get(6), network.stations.get(i));
							incident = network.incident;
						}

					}
					break;

				default:
					throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
				}

				trajetA_radioButton.setText("Itinéraire A - "+dist+" km");
				trajetB_radioButton.setText("Itinéraire B - "+dist_normale+" km");

				if(trajetA_radioButton.isSelected()) {
					detailIti_textArea.setText(schema+"\n");
					passageH_textArea.setText(horaire.toString()+"\n");
					incidentsLabel.setVisible(true);
					incidentsLabel.setText(incident);

					bus1_icon.setVisible(true);
					bus2_icon.setVisible(true);
					bus3_icon.setVisible(true);
					bus4_icon.setVisible(true);
					bus5_icon.setVisible(true);
					bus6_icon.setVisible(true);

					bus1_label.setText("Bus b1");
					bus2_label.setVisible(true);
					bus3_label.setVisible(true);
					bus4_label.setVisible(true);
					bus5_label.setVisible(true);
					bus6_label.setVisible(true);

					int countedRedBus =0 ;

					if(!b1.estDispo)
						countedRedBus++;

					if(!b2.estDispo)
						countedRedBus++;

					if(!b3.estDispo)
						countedRedBus++;

					if(!b4.estDispo)
						countedRedBus++;

					if(!b5.estDispo)
						countedRedBus++;

					if(!b6.estDispo)
						countedRedBus++;

					if(countedRedBus>=4)
						JOptionPane.showMessageDialog(frame, "Bon nombres des bus n'ont plus de places. La STO en a été informé"
								+"\nEn attendant qu'ils reglent la situation, vous pouvez marcher, prendre un autre moyen de transport"
								+"\npour rendre dans les situations dont les bus ont de la place. Ou tout simplement les prochains bus");
				}

				if(trajetB_radioButton.isSelected()) {
					detailIti_textArea.setText(schema_long+"\n");
					passageH_textArea.setText(horaire.toString()+"\n");
					incidentsLabel.setVisible(true);
					incidentsLabel.setText(incident);

					bus1_icon.setVisible(true);
					bus2_icon.setVisible(true);
					bus3_icon.setVisible(true);
					bus4_icon.setVisible(true);
					bus5_icon.setVisible(true);
					bus6_icon.setVisible(true);

					bus1_label.setText("Bus b1");
					bus2_label.setVisible(true);
					bus3_label.setVisible(true);
					bus4_label.setVisible(true);
					bus5_label.setVisible(true);
					bus6_label.setVisible(true);

				}
			}
		};

		submitButton.addActionListener(actionListener);
		trajetA_radioButton.addActionListener(actionListener);
		trajetB_radioButton.addActionListener(actionListener);

		frame.setVisible(true);

		/*LayoutManagerRelativeSize.saveRelativeValues(frame);
		//LayoutManagerRelativeSize.fitFrameToScreen(frame);         //fit the JFrame to the usable screen size, and centers it. set false parameter to true for the frame to be fullscreen, or keep it false to maintain the jFrame aspect ratio
		LayoutManagerRelativeSize.resizeAll(frame);       	     //resize all the components in the JFrame in accordance to their previously saved relative position and sizes. 
		LayoutManagerRelativeSize.enableAutoResize(frame);       //enable auto resize on the JFrame whenever the jFrame is manually resized
		 */
	}

	public ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
