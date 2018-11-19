package Traducción;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class Usuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField jpassClave;
	static public String usuario;
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios frame = new Usuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Usuarios() {
		setTitle("Inicio de sesión");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 261);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBorder(null);
		btnAceptar.setForeground(Color.DARK_GRAY);
		btnAceptar.setBackground(Color.LIGHT_GRAY);
		btnAceptar.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnAceptar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent evt) {
				
				// lee la contraseña y la convierte en string
				char clave[] = jpassClave.getPassword();
				String clave_pasada = new String(clave).replaceAll(" ","");
				
				//consigue la direccion del desktop del usuario en cuestion
				String direccion = System.getProperty("user.home");
				File fichero = new File(direccion + "\\Desktop\\usuarios.txt");
				if (fichero.exists()) {
				Scanner s = null;
				try {
					s = new Scanner(fichero);
					
					while (s.hasNextLine()) {
						
						// lee la linea y la separa en usuario y contraseña
						String [] linea = s.nextLine().split(" ");
						String usuario_txt = linea[0];
						String contraseña_txt = linea[1];
						
						// junta el usuario un espacio y la contraseña del txt 
						String comparador = usuario_txt + " " + contraseña_txt;
						
						//coge el nombre del usuario que el usuario ha metido y le suma un espacio y la contraseña
						usuario = txtUsuario.getText().replaceAll(" ","");
						String completo = usuario + " " + clave_pasada;
						
						// comprueba si el usuario más el espcio más la contraseña del txt y lo que el usuario ha introducido coinciden y si es asi pasa a la siguiente ventena
						if (comparador.equals(completo)) {
							Menu_de_resistencias nuevaventana = new Menu_de_resistencias();
							nuevaventana.setVisible(true);
							Usuarios.this.dispose();
							s.close();
							
							// si uno de los campos esta sin rellenar lo notifica
						}else if((txtUsuario.getText().length() == 0 || jpassClave.getText().length() == 0)){
							JOptionPane.showMessageDialog(null,"Introduce todos los valores antes de continuar.");
							
							// si el usuario existe en el txt pero la contraseña no es la del txt lo notifica
						}else if (!s.hasNextLine() && usuario.equals(usuario_txt)){
							JOptionPane.showMessageDialog(null,"Contraseña erronea.");
							
							// si el usuario introducido en no se encuentra en el txt de usuario sse notifica que el usuario no existe
					}else if (!s.hasNextLine() && !usuario.equals(usuario_txt)){
						JOptionPane.showMessageDialog(null,"El usuario no existe.");
					
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
				
				// si no existe el txt de usuarios el programa notifica que antes de iniciar sesión se debe crear un usuario
			}else{
				JOptionPane.showMessageDialog(null,"No existen usuarios, crea un usuario.");
			}
			}
		});
		
		JLabel lblUsuario = new JLabel(" Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		
		txtUsuario = new JTextField();
		txtUsuario.setBorder(null);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		
		jpassClave = new JPasswordField();
		jpassClave.setBorder(null);
		
		JLabel lblIniciarSesin = new JLabel("Iniciar sesión");
		lblIniciarSesin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblIniciarSesin.setForeground(Color.WHITE);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBorder(null);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Portada_de_programa nuevaventana = new Portada_de_programa();
				nuevaventana.setVisible(true);
				Usuarios.this.dispose();
			}
		});
		btnVolver.setForeground(Color.DARK_GRAY);
		btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnVolver.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(28)
									.addComponent(lblUsuario))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblContrasea)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
								.addComponent(jpassClave, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(14)
									.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(56)
									.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(154)
							.addComponent(lblIniciarSesin)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblIniciarSesin)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(jpassClave, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
					.addGap(59))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
