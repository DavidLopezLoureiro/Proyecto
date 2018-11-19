package Traducción;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Introduccion_de_datos extends JFrame{
	
	private JPanel contentPane;
	private JTextField r1;
	private JTextField r2;
	private JTextField r3;
	private JTextField r4;
	private JTextField vt;
	private JLabel lblNewLabel;
	private JLabel foto;
	public static float valor_de_resistencia_1;
	public static float valor_de_resistencia_2;
	public static float valor_de_resistencia_3;
	public static float valor_de_resistencia_4;
	public static float voltaje_total;


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Introduccion_de_datos frame = new Introduccion_de_datos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Introduccion_de_datos() {
		setTitle("Introducción de datos");
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 363);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// solo deja introducir numeros
		r1 = new JTextField(Menu_de_resistencias.res1_cargada_int + "");
		r1.setColumns(10);
		r1.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e) 
			{
				char caracter = e.getKeyChar();

				if(((caracter < '0')||
						(caracter > '9')) &&
						(caracter != '\b'))
				{
					e.consume();
				}
			}
		});

		// solo deja introducir numeros
		r2 = new JTextField(Menu_de_resistencias.res2_cargada_int + "");
		r2.setColumns(10);
		r2.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e) 
			{
				char caracter = e.getKeyChar();

				if(((caracter < '0')||
						(caracter > '9')) &&
						(caracter != '\b'))
				{
					e.consume();
				}
			}
		});
		
		// solo deja introducir numeros
		r3 = new JTextField(Menu_de_resistencias.res3_cargada_int + "");
		r3.setColumns(10);
		r3.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e) 
			{
				char caracter = e.getKeyChar();

				if(((caracter < '0')||
						(caracter > '9')) &&
						(caracter != '\b'))
				{
					e.consume();
				}
			}
		});
		
		// solo deja introducir numeros
		r4 = new JTextField(Menu_de_resistencias.res4_cargada_int + "");
		r4.setColumns(10);
		r4.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e) 
			{
				char caracter = e.getKeyChar();

				if(((caracter < '0')||
						(caracter > '9')) &&
						(caracter != '\b'))
				{
					e.consume();
				}
			}
		});
		
		// solo deja introducir numeros
		vt = new JTextField(Menu_de_resistencias.vol_cargada_int + "");
		vt.setColumns(10);
		vt.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e) 
			{
				char caracter = e.getKeyChar();

				if(((caracter < '0')||
						(caracter > '9')) &&
						(caracter != '\b'))
				{
					e.consume();
				}
			}
		});
		
		JLabel lblResistencia = new JLabel("Resistencia 1:");
		lblResistencia.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblResistencia.setForeground(Color.RED);
		
		JLabel lblResistencia_1 = new JLabel("Resistencia 2:");
		lblResistencia_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblResistencia_1.setForeground(Color.BLUE);
		
		JLabel lblResistencia_2 = new JLabel("Resistencia 3:");
		lblResistencia_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblResistencia_2.setForeground(Color.GREEN);
		
		JLabel lblResistencia_3 = new JLabel("Resistencia 4:");
		lblResistencia_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblResistencia_3.setForeground(Color.YELLOW);
		
		JLabel lblVoltajeTotal = new JLabel("Voltaje total:");
		lblVoltajeTotal.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblVoltajeTotal.setForeground(Color.WHITE);
		
		JLabel lblIntroduceLosValores = new JLabel("Introduce los valores de las resistencias del circuito y el voltaje total \r\ndel circuito.");
		lblIntroduceLosValores.setForeground(Color.WHITE);
		lblIntroduceLosValores.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBorder(null);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// si alguno de los campos esta sin rellenar lo notifica
				if  (r1.getText().length() == 0.0 || r2.getText().length() == 0.0 || r3.getText().length() == 0.0 || r4.getText().length() == 0.0 || vt.getText().length() == 0.0) {
					JOptionPane.showMessageDialog(null,"Introduce todos los valores antes de continuar.");
					
				// si alguno de los valores es 0 lo notifica, los 0 dan problemas a la hora de calcular
				}else if  (r1.getText().equals("0") || r2.getText().equals("0") || r3.getText().equals("0") || r4.getText().equals("0") || vt.getText().equals("0")) {
					JOptionPane.showMessageDialog(null,"No estan permitidos valores nulos.");
					
				//pasa los valores a la clase campos
				}else{
				valor_de_resistencia_1 = Float.parseFloat(r1.getText());
				valor_de_resistencia_2 = Float.parseFloat(r2.getText());
				valor_de_resistencia_3 = Float.parseFloat(r3.getText());
				valor_de_resistencia_4 = Float.parseFloat(r4.getText());
				voltaje_total = Float.parseFloat(vt.getText());
				Resultado nuevaventana = new Resultado();
				nuevaventana.setVisible(true);
				Introduccion_de_datos.this.dispose();}
			}
		});
		btnAceptar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAceptar.setBackground(Color.LIGHT_GRAY);
		btnAceptar.setForeground(Color.DARK_GRAY);
		
		lblNewLabel = new JLabel(Menu_de_resistencias.ecuacion);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setForeground(Color.WHITE);
		
		// si la ecuacion en cuestion es una de las generales muestra una imagen del circuito en cuestion
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
			hmap.put(1, "/Traducción/1 caso - copia.jpg");
			hmap.put(2, "/Traducción/2 caso.jpg");
			hmap.put(3, "/Traducción/3 caso.jpg");
			hmap.put(4, "/Traducción/4 caso.jpg");
			hmap.put(5, "/Traducción/5 caso.jpg");
			hmap.put(6, "/Traducción/6 caso.jpg");
			hmap.put(7, "/Traducción/7 caso.jpg");
			hmap.put(8, "/Traducción/8 caso.jpg");
			hmap.put(9, "/Traducción/9 caso.jpg");
			hmap.put(10, "/Traducción/10 caso.jpg");
		
		foto = new JLabel("");
		if (Menu_de_resistencias.ecuacion.equals("[1,2,3,4]")){
			foto.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource(hmap.get(1))));
		}
		if (Menu_de_resistencias.ecuacion.equals("[(1,2),3,4]")){
			foto.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource(hmap.get(2))));
		}
		if (Menu_de_resistencias.ecuacion.equals("[(1,2,3),4]")){
			foto.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource(hmap.get(3))));
		}
		if (Menu_de_resistencias.ecuacion.equals("(1,2,3,4)")){
			foto.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource(hmap.get(4))));
		}
		if (Menu_de_resistencias.ecuacion.equals("[(1,2),(3,4)]")){
			foto.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource(hmap.get(5))));
		}
		if (Menu_de_resistencias.ecuacion.equals("([1,2],[3,4])")){
			foto.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource(hmap.get(6))));
		}
		if (Menu_de_resistencias.ecuacion.equals("([1,2,3],4)")){
			foto.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource(hmap.get(7))));
		}
		if (Menu_de_resistencias.ecuacion.equals("([(1,2),3],4)")){
			foto.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource(hmap.get(8))));
		}
		if (Menu_de_resistencias.ecuacion.equals("(1,[2,3],4)")){
			foto.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource(hmap.get(9))));
		}
		if (Menu_de_resistencias.ecuacion.equals("[([1,2],3),4]")){
			foto.setIcon(new ImageIcon(Menu_de_resistencias.class.getResource(hmap.get(10))));
		}
		
		//vuelve al menu de resistencias
		JButton btnvolver = new JButton("Volver");
		btnvolver.setBorder(null);
		btnvolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_de_resistencias nuevaventana = new Menu_de_resistencias();
				nuevaventana.setVisible(true);
				Introduccion_de_datos.this.dispose();
			}
		});
		btnvolver.setForeground(Color.DARK_GRAY);
		btnvolver.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnvolver.setBackground(Color.LIGHT_GRAY);
		
		JLabel label = new JLabel("K Ohmios.");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		JLabel label_1 = new JLabel("K Ohmios.");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		JLabel label_2 = new JLabel("K Ohmios.");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		JLabel label_3 = new JLabel("K Ohmios.");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		JLabel lblVoltios = new JLabel("Voltios.");
		lblVoltios.setForeground(Color.WHITE);
		lblVoltios.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblVoltajeTotal, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
						.addComponent(lblResistencia_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblResistencia_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblResistencia_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblResistencia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(r2)
						.addComponent(r4)
						.addComponent(r3)
						.addComponent(vt)
						.addComponent(r1, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
							.addComponent(foto)
							.addGap(40))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVoltios, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
							.addGap(122))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(127)
							.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(112)
							.addComponent(btnvolver, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(182)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(270, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIntroduceLosValores, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(209, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIntroduceLosValores, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblResistencia)
						.addComponent(r1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(foto)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblResistencia_1)
								.addComponent(r2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(r3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblResistencia_2)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addGap(17)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblResistencia_3)
								.addComponent(r4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVoltajeTotal)
								.addComponent(vt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVoltios, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnvolver, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
