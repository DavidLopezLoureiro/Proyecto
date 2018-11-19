package Traducción;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Resultado extends JFrame {

	private JPanel contentPane;
	private JTextField res_t;
	private JTextField int_t;
	public static float resistencia_total;
	public static float intensidad_total;



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultado frame = new Resultado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Resultado() {
		setTitle("Resultados");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 216);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		float resistencia_total = Casos.Resistencia();
		String resistencia_t = Float.toString(resistencia_total);
		res_t = new JTextField(resistencia_t + " kilo Ohmios.");
		res_t.setBorder(null);
		res_t.setEditable(false);
		res_t.setColumns(10);
		
		// halla la intensidad total dividiendo el voltaje total entre la resistencia total
		intensidad_total = Introduccion_de_datos.voltaje_total / resistencia_total;
		String intensidad_t = Float.toString(intensidad_total);
		int_t = new JTextField(intensidad_t + " mili Amperios.");
		int_t.setBorder(null);
		int_t.setEditable(false);
		int_t.setColumns(10);

		
		JLabel lblResultdoo = new JLabel("Resultados:");
		lblResultdoo.setForeground(Color.WHITE);
		lblResultdoo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

		// pasa a la ventana de volver
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBorder(null);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Volver nuevaventana = new Volver();
				nuevaventana.setVisible(true);
				Resultado.this.dispose();
			}
		});
		btnAceptar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAceptar.setBackground(Color.LIGHT_GRAY);
		btnAceptar.setForeground(Color.DARK_GRAY);
		
		JLabel lblIntensidadTotal = new JLabel("Intensidad total:");
		lblIntensidadTotal.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblIntensidadTotal.setForeground(Color.WHITE);
		lblIntensidadTotal.setBackground(Color.WHITE);
		
		JLabel lblResistencia = new JLabel("Resistencia total:\r\n");
		lblResistencia.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblResistencia.setForeground(Color.WHITE);
		
		
		JButton btnguardar = new JButton("Guardar");
		btnguardar.setBorder(null);
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// guarda los datos del sistema
				String res_1 = Float.toString(Introduccion_de_datos.valor_de_resistencia_1);
				String res_2 = Float.toString(Introduccion_de_datos.valor_de_resistencia_2);
				String res_3 = Float.toString(Introduccion_de_datos.valor_de_resistencia_3);
				String res_4 = Float.toString(Introduccion_de_datos.valor_de_resistencia_4);
				String vol_t = Float.toString(Introduccion_de_datos.voltaje_total);
				String res_t = Float.toString(resistencia_total);
				String int_t = Float.toString(Resultado.intensidad_total);
				try
				{
					
					// crea un txt con el nombre del usuario y escribe en el los datos 
					// si el txt ya existe escribe los datos tras el ultimo circuito
					String direccion = System.getProperty("user.home");
					File archivo = new File(direccion + "\\Desktop\\" + Usuarios.usuario + ".txt");
					
					FileWriter escribir=new FileWriter(archivo,true);
					
					//escribe los datos en el txt
					escribir.write("-------------------------------------------------------------------------- "  + "\r\n");
					escribir.write("Ecuación: " + Menu_de_resistencias.ecuacion + "\r\n");
					escribir.write("Resistencia 1:  " + res_1 + " kilo Ohmios." + "\r\n");
					escribir.write("Resistencia 2:  " + res_2 + " kilo Ohmios." + "\r\n");
					escribir.write("Resistencia 3:  " + res_3 + " kilo Ohmios." + "\r\n");
					escribir.write("Resistencia 4:  " + res_4 + " kilo Ohmios." + "\r\n");
					escribir.write("Voltaje total:  " + vol_t + " Voltios." + "\r\n");
					escribir.write(" " + "\r\n");
					escribir.write("Resultados: " + "\r\n");
					escribir.write("Resistencia total:  " + res_t + " kilo Ohmios." + "\r\n");
					escribir.write("Intensidad total:  " + int_t + " mili Amperios."  + "\r\n");
					escribir.close();
				
				}
				catch(Exception e)
				{
				}
				     
				// pasa a la ventana de volver
				Volver nuevaventana = new Volver();
				nuevaventana.setVisible(true);
				Resultado.this.dispose();
				}
			});
		btnguardar.setForeground(Color.DARK_GRAY);
		btnguardar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnguardar.setBackground(Color.LIGHT_GRAY);
		
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblResistencia)
								.addComponent(lblIntensidadTotal))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(int_t, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
								.addComponent(res_t, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(104)
							.addComponent(lblResultdoo))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
							.addComponent(btnguardar, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addComponent(lblResultdoo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblResistencia, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(res_t, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIntensidadTotal, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(int_t, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnguardar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(28))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
