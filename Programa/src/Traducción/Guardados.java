package Traducción;


import java.awt.EventQueue;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class Guardados extends JFrame {

	private JPanel contentPane;
	public String ecuacion;
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
	
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guardados frame = new Guardados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Guardados() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 474, 65);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		String direccion = System.getProperty("user.home");
		File fichero = new File(direccion + "\\Desktop\\" + Usuarios.usuario + ".txt");
		if (fichero.exists()) {
			Scanner s = null;
			try {
				String cambio = "-------------------------------------------------------------------------- ";
				s = new Scanner(fichero);
				contador = 0;
				guardados = new HashMap<Integer, String>();
				while (s.hasNextLine() ) { 
					String linea = s.nextLine();
					if (linea.equals(cambio)) {
						
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
						total = ecuacion + "\r\n" + res_1 + "\r\n" + res_2 + "\r\n" + res_3 + "\r\n" + res_4 + "\r\n" + vol_t + "\r\n" + resultados + "\r\n" + res_t + "\r\n" + int_t;
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
		
		
		JButton btnNewButton_1 = new JButton("Anterior");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (contador_botones == 1) {
					JOptionPane.showMessageDialog(null,"No hay circuitos antes del actual.");
				}else {
					contador_botones = contador_botones - 1;
				}
			}
		});
		
		JButton btnCargarCircuitos = new JButton("Cargar circuito");
		btnCargarCircuitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,guardados.get(contador_botones));
			}
		});
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (contador_botones == contador) {
					JOptionPane.showMessageDialog(null,"No hay circuitos despues del actual.");
				}else {
					contador_botones = contador_botones + 1;
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCargarCircuitos, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addGap(61))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCargarCircuitos, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}


