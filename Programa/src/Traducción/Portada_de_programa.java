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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Portada_de_programa extends JFrame {
	java.util.Calendar calendario;
	int hora, minutos, segundos;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portada_de_programa frame = new Portada_de_programa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Portada_de_programa() {
		setTitle("Portada");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 289);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblCircuitosElectricos = new JLabel("Circuitos electricos ");
		lblCircuitosElectricos.setForeground(Color.WHITE);
		lblCircuitosElectricos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 43));

		// Te lleva a la pestaña de Crear usuario

		JButton btnCrearUsuario = new JButton("Crear usuario");
		btnCrearUsuario.setBorder(null);
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnCrearUsuario) {
					Crear_usuario nuevaventana = new Crear_usuario();
					nuevaventana.setVisible(true);
					Portada_de_programa.this.dispose();
				}
			}
		});
		btnCrearUsuario.setForeground(Color.DARK_GRAY);
		btnCrearUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnCrearUsuario.setBackground(Color.LIGHT_GRAY);

		// Te lleva a la pestaña de Iniciar sesión

		JButton btnIniciarSesion = new JButton("Iniciar sesión");
		btnIniciarSesion.setBorder(null);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnIniciarSesion) {
					Usuarios nuevaventana = new Usuarios();
					nuevaventana.setVisible(true);
					Portada_de_programa.this.dispose();
				}
			}
		});
		btnIniciarSesion.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnIniciarSesion.setForeground(Color.DARK_GRAY);
		btnIniciarSesion.setBackground(Color.LIGHT_GRAY);

		JLabel lblNewLabel = new JLabel("David López Loureiro");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setForeground(Color.WHITE);

		JLabel lblNewLabel_1 = new JLabel("Hora");
		lblNewLabel_1.setForeground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(46, Short.MAX_VALUE)
								.addComponent(lblCircuitosElectricos))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(36)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnCrearUsuario, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(btnIniciarSesion, GroupLayout.DEFAULT_SIZE, 364,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)))))
				.addGap(34))
				.addGroup(Alignment.LEADING,
						gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
								.addComponent(lblNewLabel).addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblCircuitosElectricos).addGap(26)
				.addComponent(btnCrearUsuario, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE).addGap(33)
				.addComponent(btnIniciarSesion, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE).addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(lblNewLabel))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
		calendario = new java.util.GregorianCalendar();
		segundos = calendario.get(Calendar.SECOND);
		javax.swing.Timer timer = new javax.swing.Timer(1, new java.awt.event.ActionListener() {

			// El Thread del reloj

			public void actionPerformed(java.awt.event.ActionEvent ae) {
				java.util.Date actual = new java.util.Date();
				calendario.setTime(actual);
				hora = calendario.get(Calendar.HOUR_OF_DAY);
				minutos = calendario.get(Calendar.MINUTE);
				segundos = calendario.get(Calendar.SECOND);
				String hour = String.format("%02d : %02d : %02d", hora, minutos, segundos);
				lblNewLabel_1.setText(" " + hour);
			}
		});
		timer.start();
	}
}
