package Traducción;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Crear_usuario extends JFrame {

	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField Contraseña;
	private JPasswordField repetir_contraseña;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crear_usuario frame = new Crear_usuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Crear_usuario() {
		setTitle("Creación de usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 244);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCrearUsuario = new JLabel("Crear usuario:");
		lblCrearUsuario.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		lblCrearUsuario.setForeground(Color.WHITE);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblContrasea.setForeground(Color.WHITE);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir contraseña:");
		lblRepetirContrasea.setForeground(Color.WHITE);
		lblRepetirContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		usuario = new JTextField();
		usuario.setBorder(null);
		usuario.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBorder(null);
		btnAceptar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAceptar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			
			public void actionPerformed(ActionEvent arg0) {
				
				// lee la contraseña y la convierte en string
				char contraseña_sin_pasar[] = Contraseña.getPassword();
				String contraseña_pasada = new String(contraseña_sin_pasar).replaceAll(" ","");
				
				// lee la repeticion de la contraseña y la convierte en string
				char contraseña_sin_pasar_repetida[] = repetir_contraseña.getPassword();
				String contraseña_pasada_repetida = new String(contraseña_sin_pasar_repetida).replaceAll(" ","");
				
				// si las contraseñas son iguales y no hay nada vacio empieza a comprobar si puede crear el usuario
				if (contraseña_pasada.equals(contraseña_pasada_repetida) && usuario.getText().length() != 0 && Contraseña.getText().length() != 0 && repetir_contraseña.getText().length() != 0) {
					try{
						
						//consigue la direccion del desktop del usuario en cuestion
						String Usuario = usuario.getText().replaceAll(" ","");
						String direccion = System.getProperty("user.home");
						File archivo = new File(direccion + "\\Desktop\\usuarios.txt");
						
						//comprueba que el txt existe
						if (archivo.exists()) {
							Scanner s = null;
							try {
								s = new Scanner(archivo);
								while (s.hasNextLine()) {
									String [] linea_sin_separar = s.nextLine().split(" ");
									String linea = linea_sin_separar [0];
									
									// lee si el usuario existe ya en el txt
									if (linea.equals(Usuario)) {
										JOptionPane.showMessageDialog(null,"El usuario ya existe.");
										s.close();
										
									// si no existen usuarios con ese nombre lo escribe en el txt y luego vuelve a la portada
									}else if (!s.hasNextLine()){
										FileWriter escribir = new FileWriter(archivo,true);
										escribir.write(Usuario);
										escribir.write(" ");
										escribir.write(contraseña_pasada + "\r\n");
										escribir.close();
										s.close();
										Portada_de_programa nuevaventana = new Portada_de_programa();
										nuevaventana.setVisible(true);
										Crear_usuario.this.dispose();
									}
								}
							} catch (Exception ex) {
							} finally {
								try {
									if (s != null)
										s.close();
								} catch (Exception ex2) {
								}
							}
							
							// si el txt no existe entonces crea uno y escribe el nombre del usuario y la contraseña si cumplen las condiciones de arriba
						}else {	
							FileWriter escribir = new FileWriter(archivo,true);
							escribir.write(Usuario);
							escribir.write(" ");
							escribir.write(contraseña_pasada + "\r\n");
							escribir.close();
							Portada_de_programa nuevaventana = new Portada_de_programa();
							nuevaventana.setVisible(true);
							Crear_usuario.this.dispose();
						}
					}catch(Exception e){		
					}
					
					// si las contraseñas no coinciden
				}else if(contraseña_pasada != contraseña_pasada_repetida && usuario.getText().length() != 0 && Contraseña.getText().length() != 0 && repetir_contraseña.getText().length() != 0){
					JOptionPane.showMessageDialog(null,"Ambas contraseñas deben coincidir.");

					// si uno de los campos a rellenar esta vacio
				}else if (usuario.getText().length() == 0 || Contraseña.getText().length() == 0 || repetir_contraseña.getText().length() == 0){
					JOptionPane.showMessageDialog(null,"Introduce todos los campos antes de continuar.");	
				}
			}
		});
		btnAceptar.setForeground(Color.DARK_GRAY);
		btnAceptar.setBackground(Color.LIGHT_GRAY);

		Contraseña = new JPasswordField();
		Contraseña.setBorder(null);

		repetir_contraseña = new JPasswordField();
		repetir_contraseña.setBorder(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBorder(null);
		btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Portada_de_programa nuevaventana = new Portada_de_programa();
			nuevaventana.setVisible(true);
			Crear_usuario.this.dispose();
			}
		});
		btnVolver.setForeground(Color.DARK_GRAY);
		btnVolver.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRepetirContrasea)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(55)
									.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(107)
									.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(repetir_contraseña, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(usuario))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblContrasea)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Contraseña, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)))))
					.addGap(22))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(129)
					.addComponent(lblCrearUsuario)
					.addContainerGap(170, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblCrearUsuario)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(usuario, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(Contraseña, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblContrasea))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRepetirContrasea)
						.addComponent(repetir_contraseña, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(40))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
