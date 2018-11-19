package Traducción;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Menu_de_resistencias extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public static String ecuacion;
	public String res_1; 
	public String res_2;
	public String res_3;
	public String res_4;
	public String vol_t;
	public String nada_2; 
	public String resultados;
	public String res_t;
	public String int_t;
	public static HashMap<Integer, String> guardados;
	public static String total;
	public int contador;
	public int contador_botones = 1;
	public static int res1_cargada_int;
	public static int res2_cargada_int;
	public static int res3_cargada_int;
	public static int res4_cargada_int;
	public static int vol_cargada_int;
	public static JLabel lblNewLabel;
	public static JLabel lblResistencia;
	public static JLabel lblResistencia_1;
	public static JLabel lblResistencia_2;
	public static JLabel lblResistencia_3;
	public static JLabel lblVoltajeTotal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_de_resistencias frame = new Menu_de_resistencias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Menu_de_resistencias() {
		
		//consigue la direccion del desktop del usuario en cuestion
		String direccion = System.getProperty("user.home");
		File fichero = new File(direccion + "\\Desktop\\" + Usuarios.usuario + ".txt");
		
		// comprueba si el txt de circuitos del usuario que haya iniciado sesión existe
		if (fichero.exists()) {
			Scanner s = null;
			try {
				String cambio = "-------------------------------------------------------------------------- ";
				s = new Scanner(fichero);
				contador = 0;
				guardados = new HashMap<Integer, String>();
				while (s.hasNextLine() ) { 
					
					// comprueba que la primera linea este bien y sea la adecuada
					String linea = s.nextLine();
					if (linea.equals(cambio)) {

						// guarda las diferentes lienas del txt
						ecuacion = s.nextLine();
						res_1 = s.nextLine();
						res_2 = s.nextLine();
						res_3 = s.nextLine();
						res_4 = s.nextLine();
						vol_t = s.nextLine();
						nada_2 = s.nextLine();
						resultados = s.nextLine();
						res_t = s.nextLine();
						int_t = s.nextLine();
						
						//total es un string en que junta todos los datos del cricuito leidos por el scanner
						total = ecuacion + "\r\n" + res_1 + "\r\n" + res_2 + "\r\n" + res_3 + "\r\n" + res_4 + "\r\n" + vol_t + "\r\n" + resultados + "\r\n" + res_t + "\r\n" + int_t;
						
						// contador se usa para saber cuantos sistemas tiene el usuario y enumerar todos ellos
						contador = contador + 1;
						guardados.put(contador,total);
					}					

				}


			} catch (Exception ex2) {

			} finally {


				try {
					if (s != null)
						s.close();
				} catch (Exception ex2) {
				}
			}
		}else{
		}

		setTitle("Menú de resistencias");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 390);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);

		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
										.addGap(18))))
				);

		// en caso de que el usuario nunca haya guardado un circuito se visualiza esto
		lblNewLabel = new JLabel("Ecuación: _________________");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBackground(Color.WHITE);

		lblResistencia = new JLabel("Resistencia 1: ______________");
		lblResistencia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblResistencia.setBackground(Color.WHITE);

		lblResistencia_1 = new JLabel("Resistencia 2: ______________");
		lblResistencia_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblResistencia_1.setBackground(Color.WHITE);

		lblResistencia_2 = new JLabel("Resistencia 3: ______________");
		lblResistencia_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblResistencia_2.setBackground(Color.WHITE);

		lblResistencia_3 = new JLabel("Resistencia 4: ______________");
		lblResistencia_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblResistencia_3.setBackground(Color.WHITE);

		lblVoltajeTotal = new JLabel("Voltaje total: _______________");
		lblVoltajeTotal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblVoltajeTotal.setBackground(Color.WHITE);

		// si el usuario si tiene un txt por lo cual si tiene circuitos se escriben los datos de este en las diferentes labels
		if (fichero.exists()) {
			String [] separado = guardados.get(contador_botones).split("\r\n");
			String ecua = separado [0];
			String res1 = separado [1];
			String res2 = separado [2];
			String res3 = separado [3];
			String res4 = separado [4];
			String volt = separado [5];
			lblNewLabel.setText(ecua);
			lblResistencia.setText(res1);
			lblResistencia_1.setText(res2);
			lblResistencia_2.setText(res3);
			lblResistencia_3.setText(res4);
			lblVoltajeTotal.setText(volt);
		}



		JLabel lblDatosDelCircuito = new JLabel("Datos del circuito:");
		lblDatosDelCircuito.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JButton btnCircuitoCompleto = new JButton("Circuito completo");
		btnCircuitoCompleto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCircuitoCompleto.setBorder(null);
		btnCircuitoCompleto.setForeground(Color.WHITE);
		btnCircuitoCompleto.setBackground(Color.GRAY);
		btnCircuitoCompleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//consigue la direccion del desktop del usuario en cuestion
				String direccion = System.getProperty("user.home");
				File fichero = new File(direccion + "\\Desktop\\" + Usuarios.usuario + ".txt");
				
				// busca si el txt del usuario existe
				if (fichero.exists()) {
					
					// si existe al pulsar el boton muestra el circuito que hemos elegido por medio de los botones de siguiente y anterior por pantalla
					JOptionPane.showMessageDialog(null,guardados.get(contador_botones));
					
					// si el usuario no tiene circuitos al intentar visualizarlo se notifica que no tiene circuitos
				}else {
					JOptionPane.showMessageDialog(null,"Tu usuario aun no tiene circuitos guardados.");
				}
			}
		});

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
									.addComponent(lblResistencia, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblResistencia_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblResistencia_2, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblResistencia_3, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblVoltajeTotal, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(50)
							.addComponent(lblDatosDelCircuito)
							.addGap(73))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(42)
							.addComponent(btnCircuitoCompleto, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnCircuitoCompleto, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addComponent(lblDatosDelCircuito)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblResistencia, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblResistencia_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblResistencia_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblResistencia_3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblVoltajeTotal, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		panel_2.setLayout(gl_panel_2);

		// boton del circuito 1
		JButton caso1 = new JButton("");
		caso1.setBorder(null);
		caso1.setForeground(Color.WHITE);
		caso1.setBackground(Color.WHITE);
		caso1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ecuacion = "[1,2,3,4]";
				Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
				nuevaventana.setVisible(true);
				Menu_de_resistencias.this.dispose();
			}
		});
		caso1.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource("/Traducción/1 caso - copia.jpg")));

		// boton del circuito 2
		JButton caso2 = new JButton("");
		caso2.setBorder(null);
		caso2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ecuacion = "[(1,2),3,4]";
				Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
				nuevaventana.setVisible(true);
				Menu_de_resistencias.this.dispose();
			}
		});
		caso2.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource("/Traducción/2 caso.jpg")));
		caso2.setForeground(Color.WHITE);
		caso2.setBackground(Color.WHITE);

		// boton del circuito 3
		JButton caso3 = new JButton("");
		caso3.setBorder(null);
		caso3.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource("/Traducción/3 caso.jpg")));
		caso3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ecuacion = "[(1,2,3),4]";
				Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
				nuevaventana.setVisible(true);
				Menu_de_resistencias.this.dispose();
			}
		});
		caso3.setForeground(Color.WHITE);
		caso3.setBackground(Color.WHITE);

		// boton del circuito 4
		JButton caso4 = new JButton("");
		caso4.setBorder(null);
		caso4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ecuacion = "(1,2,3,4)";
				Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
				nuevaventana.setVisible(true);
				Menu_de_resistencias.this.dispose();
			}
		});
		caso4.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource("/Traducción/4 caso.jpg")));
		caso4.setForeground(Color.WHITE);
		caso4.setBackground(Color.WHITE);

		// boton del circuito 5
		JButton caso5 = new JButton("");
		caso5.setBorder(null);
		caso5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ecuacion = "[(1,2),(3,4)]";
				Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
				nuevaventana.setVisible(true);
				Menu_de_resistencias.this.dispose();
			}
		});
		caso5.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource("/Traducción/5 caso.jpg")));
		caso5.setForeground(Color.WHITE);
		caso5.setBackground(Color.WHITE);

		// boton del circuito 6
		JButton caso6 = new JButton("");
		caso6.setBorder(null);
		caso6.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource("/Traducción/6 caso.jpg")));
		caso6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ecuacion = "([1,2],[3,4])";
				Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
				nuevaventana.setVisible(true);
				Menu_de_resistencias.this.dispose();
			}
		});
		caso6.setForeground(Color.WHITE);
		caso6.setBackground(Color.WHITE);

		// boton del circuito 7
		JButton caso7 = new JButton("");
		caso7.setBorder(null);
		caso7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ecuacion = "([1,2,3],4)";
				Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
				nuevaventana.setVisible(true);
				Menu_de_resistencias.this.dispose();
			}

		});
		caso7.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource("/Traducción/7 caso.jpg")));
		caso7.setForeground(Color.WHITE);
		caso7.setBackground(Color.WHITE);

		// boton del circuito 8
		JButton caso8 = new JButton("");
		caso8.setBorder(null);
		caso8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ecuacion = "([(1,2),3],4)";
				Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
				nuevaventana.setVisible(true);
				Menu_de_resistencias.this.dispose();
			}
		});
		caso8.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource("/Traducción/8 caso.jpg")));
		caso8.setForeground(Color.WHITE);
		caso8.setBackground(Color.WHITE);

		// boton del circuito 9
		JButton caso9 = new JButton("");
		caso9.setBorder(null);
		caso9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ecuacion = "(1,[2,3],4)";
				Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
				nuevaventana.setVisible(true);
				Menu_de_resistencias.this.dispose();
			}
		});
		caso9.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource("/Traducción/9 caso.jpg")));
		caso9.setForeground(Color.WHITE);
		caso9.setBackground(Color.WHITE);

		// boton del circuito 10
		JButton caso10 = new JButton("");
		caso10.setBorder(null);
		caso10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ecuacion = "[([1,2],3),4]";
				Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
				nuevaventana.setVisible(true);
				Menu_de_resistencias.this.dispose();
			}
		});
		caso10.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource("/Traducción/10 caso.jpg")));
		caso10.setForeground(Color.WHITE);
		caso10.setBackground(Color.WHITE);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
										.addComponent(caso1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
										.addComponent(caso3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(caso5, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(caso7, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(caso2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(caso4, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
										.addComponent(caso6, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(caso8, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(caso9, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(caso10, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(caso3, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(caso5, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(caso7, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(caso9, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(caso1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(caso4, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(caso2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(caso8, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(caso10, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(caso6, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE))
				);
		panel_1.setLayout(gl_panel_1);

		JLabel lblEscribeTuPropia = new JLabel("Escribe tu propio circuito:");
		lblEscribeTuPropia.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		//este boton escribe por pantalla las reglas de creación de ecuaciones de sistemas
		JButton btnReglas = new JButton("Reglas");
		btnReglas.setBorder(null);
		btnReglas.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnReglas.setBackground(Color.WHITE);
		btnReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btnReglas) {
					JOptionPane.showMessageDialog(null,"�	Los [ ] significan que lo que haya dentro de ellos son resistencias en línea.\r\n" + 
							"�	Los ( ) significan que lo que haya dentro de ellos son resistencias en paralelo.\r\n" + 
							"�	Puede haber anidaciones y se escribe coma antes de un ( o un [ siempre y cuando no sea el principio y se escribe coma al cerrar un ) o un ] siempre y cuando no sea el final.\r\n" + 
							"�	Usa siempre 4 resistencias, los números se escriben en orden (1,2,3,4) y sin espacios.\r\n" + 
							"�	Si la frase escrita da error puede ser que este mal escrita, que sea incorrecta o que el programa no haya contemplado dicha opción.	\r\n" + 
							"");
				}
			}
		});
		btnReglas.setForeground(Color.BLUE);

		textField = new JTextField();
		textField.setBorder(null);
		textField.setColumns(10);

		// lee la ecuación y dependienmdo de la ecuacion la pasa una ecuacion o otra
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBorder(null);
		btnAceptar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ecuacion = textField.getText();
				if (ecuacion.equals("[1,2,3,4]")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("[(1,2),3,4]")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("[1,(2,3),4]")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("[1,2,(3,4)]")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("[(1,2,3),4]")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("[1,(2,3,4)]")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("(1,2,3,4)")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("[(1,2),(3,4)]")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("([1,2],[3,4])")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("([1,2,3],4)")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("(1,[2,3,4])")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("([(1,2),3],4)")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("([1,(2,3)],4)")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("(1,[(2,3),4])")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("(1,[2,(3,4)])")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("(1,[2,3],4)")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("([1,2],3,4)")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("(1,2,[3,4])")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("[([1,2],3),4]")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("[(1,[2,3]),4]")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("[1,(2,[3,4])]")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
				}
				else if (ecuacion.equals("[1,([2,3],4)]")) {
					ecuacion = textField.getText();
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
					
					// si no hya nada escrito se notifica que no hay nada escrito
				}else if (ecuacion.length() == 0) {
					JOptionPane.showMessageDialog(null,"No se ha introducido ninguna ecuación.");
				}
				
				// si la ecuacion no es una de los 22 casos registrados o esta mal escrita lo notifica
				else {
					JOptionPane.showMessageDialog(null,"La ecuación introducida no sigue las normas de escritura o es incorrecta.");
				}
			}
		});
		btnAceptar.setForeground(Color.RED);

		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBorder(null);
		btnSiguiente.setMinimumSize(new Dimension(71, 23));
		btnSiguiente.setMaximumSize(new Dimension(71, 23));
		btnSiguiente.setPreferredSize(new Dimension(71, 23));
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//consigue la direccion del desktop del usuario en cuestion
				String direccion = System.getProperty("user.home");
				File fichero = new File(direccion + "\\Desktop\\" + Usuarios.usuario + ".txt");
				
				// busca si el txt existe si no existe lo notifica
				if (fichero.exists()) {
					
					// si no hay más circuitos despues del actual lo notifica
					if (contador_botones == contador) {
						JOptionPane.showMessageDialog(null,"No hay circuitos despues del actual.");
						
						// en caso de que exista escribe en las labels los datos del siguiente circuito
					}else {
						contador_botones = contador_botones + 1;
						String [] separado = guardados.get(contador_botones).split("\r\n");
						String ecua = separado [0];
						String res1 = separado [1];
						String res2 = separado [2];
						String res3 = separado [3];
						String res4 = separado [4];
						String volt = separado [5];
						lblNewLabel.setText(ecua);
						lblResistencia.setText(res1);
						lblResistencia_1.setText(res2);
						lblResistencia_2.setText(res3);
						lblResistencia_3.setText(res4);
						lblVoltajeTotal.setText(volt);
					}
					
					// busca si el txt existe si no existe lo notifica ya que eso quiere decir que el usuario no tiene circuitos
				}else{
					JOptionPane.showMessageDialog(null,"Tu usuario aun no tiene circuitos guardados.");
				}
			}
		});

		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSiguiente.setBackground(Color.GRAY);

		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setBorder(null);
		btnAnterior.setForeground(Color.WHITE);
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//consigue la direccion del desktop del usuario en cuestion
				String direccion = System.getProperty("user.home");
				File fichero = new File(direccion + "\\Desktop\\" + Usuarios.usuario + ".txt");
				
				// busca si el txt existe si no existe lo notifica
				if (fichero.exists()) {
					
					// si no hay más circuitos despues del actual lo notifica
					if (contador_botones == 1) {
						JOptionPane.showMessageDialog(null,"No hay circuitos antes del actual.");
						
						// en caso de que exista escribe en las labels los datos del siguiente circuito
					}else {
						contador_botones = contador_botones - 1;
						String [] separado = guardados.get(contador_botones).split("\r\n");
						String ecua = separado [0];
						String res1 = separado [1];
						String res2 = separado [2];
						String res3 = separado [3];
						String res4 = separado [4];
						String volt = separado [5];
						lblNewLabel.setText(ecua);
						lblResistencia.setText(res1);
						lblResistencia_1.setText(res2);
						lblResistencia_2.setText(res3);
						lblResistencia_3.setText(res4);
						lblVoltajeTotal.setText(volt);
					}
					
					// busca si el txt existe si no existe lo notifica ya que eso quiere decir que el usuario no tiene circuitos
				}else{
					JOptionPane.showMessageDialog(null,"Tu usuario aun no tiene circuitos guardados.");
				}
			}
		});

		btnAnterior.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAnterior.setBackground(Color.GRAY);
		
		// pone los valores base de la siguiente ventana a 0
		res1_cargada_int = 0;
		res2_cargada_int = 0;
		res3_cargada_int = 0;
		res4_cargada_int = 0;
		vol_cargada_int = 0;

		JButton btnCargarCircuito = new JButton("Cargar circuito");
		btnCargarCircuito.setBorder(null);
		btnCargarCircuito.setForeground(Color.BLACK);
		btnCargarCircuito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//consigue la direccion del desktop del usuario en cuestion
				String direccion = System.getProperty("user.home");
				File fichero = new File(direccion + "\\Desktop\\" + Usuarios.usuario + ".txt");
				
				// busca si el txt existe
				if (fichero.exists()) {
					
					// coje los valores escritos en el txt y los pasa a la siguiente ventana (incluida la ecuacion)
					String [] separado = guardados.get(contador_botones).split("\r\n");
					String ecu = separado [0];
					String re1 = separado [1];
					String re2 = separado [2];
					String re3 = separado [3];
					String re4 = separado [4];
					String vot = separado [5];


					String[] ecuacion_split = ecu.replaceAll(" ","").split(":");
					String ecuacion_cargada = ecuacion_split [1];


					String[] res1_split = re1.split(" ");
					String res1_cargada = res1_split [3];
					String res1_cargada_string = res1_cargada.replaceAll(".0","");
					res1_cargada_int = Integer.parseInt(res1_cargada_string);

					String[] res2_split = re2.split(" ");
					String res2_cargada = res2_split [3];
					String res2_cargada_string = res2_cargada.replaceAll(".0","");
					res2_cargada_int = Integer.parseInt(res2_cargada_string);


					String[] res3_split = re3.split(" ");
					String res3_cargada = res3_split [3];
					String res3_cargada_string = res3_cargada.replaceAll(".0","");
					res3_cargada_int = Integer.parseInt(res3_cargada_string);


					String[] res4_split = re4.split(" ");
					String res4_cargada = res4_split [3];
					String res4_cargada_string = res4_cargada.replaceAll(".0","");
					res4_cargada_int = Integer.parseInt(res4_cargada_string);


					String[] vol_split = vot.split(" ");
					String vol_cargada = vol_split [3];
					String vol_cargada_string = vol_cargada.replaceAll(".0","");
					vol_cargada_int = Integer.parseInt(vol_cargada_string);


					Menu_de_resistencias.ecuacion = ecuacion_cargada;
					Introduccion_de_datos nuevaventana = new Introduccion_de_datos();
					nuevaventana.setVisible(true);
					Menu_de_resistencias.this.dispose();
					
					// si el txt existe si no existe lo notifica
				}else{
					JOptionPane.showMessageDialog(null,"Tu usuario aun no tiene circuitos guardados.");
				}
			}
		});

		btnCargarCircuito.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCargarCircuito.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(14)
							.addComponent(lblEscribeTuPropia)
							.addGap(2)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReglas, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAnterior, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCargarCircuito, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSiguiente, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEscribeTuPropia, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReglas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnSiguiente, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAnterior, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCargarCircuito, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

	}
}
