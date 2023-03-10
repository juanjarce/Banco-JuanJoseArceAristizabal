package co.edu.uniquindio.banco.views;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.uniquindio.banco.model.Banco;

public class VentanaPrincipal extends JFrame {
	
	public Banco miBanco = new Banco("Catavento Tecnologia", "Calle 31N #20-10", "18494175");

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cuenta");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CuentaRegistro newFrame = new CuentaRegistro(miBanco);
				newFrame.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_2 = new JMenu("Cliente");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClienteRegistro newFrame = new ClienteRegistro(miBanco);
				newFrame.setVisible(true);
			}
		});
		menuBar.add(mnNewMenu_2);
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Funciones");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Funciones newFrame = new Funciones(miBanco);
				newFrame.setVisible(true);
			}
		});
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_3 = new JMenu("Beneficiario");
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistroBeneficiario newFrame = new RegistroBeneficiario(miBanco);
				newFrame.setVisible(true);
			}
		});
		menuBar.add(mnNewMenu_3);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
