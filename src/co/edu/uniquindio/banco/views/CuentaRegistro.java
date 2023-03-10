package co.edu.uniquindio.banco.views;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.uniquindio.banco.model.Banco;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CuentaRegistro extends JFrame {
	
	public Banco miBanco;

	private JPanel contentPane;
	private JTextField inputIdentificacionTitular;
	private JTextField inputNumeroCuenta;
	private JTextField inputTipoCuenta;

	/**
	 * Create the frame.
	 */
	public CuentaRegistro(Banco miBanco) {
		
		this.miBanco = miBanco;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		generarPanelSuperior();
		generarPanelMedio();
	}

	public void generarPanelSuperior() {
		// TODO Auto-generated method stub
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("ACCIONES CUENTA");
		panel.add(lblNewLabel);
		
	}
	
	public void generarPanelMedio() {
		// TODO Auto-generated method stub
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(10,2));
		{
			JLabel lblNewLabel_1 = new JLabel("Identificacion del Titular:");
			panel_1.add(lblNewLabel_1);
		}
		{
			inputIdentificacionTitular = new JTextField();
			panel_1.add(inputIdentificacionTitular);
			inputIdentificacionTitular.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Numero de la Cuenta:");
			panel_1.add(lblNewLabel_3);
		}
		{
			inputNumeroCuenta = new JTextField();
			panel_1.add(inputNumeroCuenta);
			inputNumeroCuenta.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Tipo de la Cuenta:");
			panel_1.add(lblNewLabel_4);
		}
		{
			inputTipoCuenta = new JTextField();
			panel_1.add(inputTipoCuenta);
			inputTipoCuenta.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("CREAR CUENTA");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						String mensaje = miBanco.crearCuenta(miBanco.obtenerCliente(inputIdentificacionTitular.getText()), inputNumeroCuenta.getText(), inputTipoCuenta.getText());
						JOptionPane.showMessageDialog(null, mensaje);
						inputIdentificacionTitular.setText(null);
						inputNumeroCuenta.setText(null);
						inputTipoCuenta.setText(null);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			});
			panel_1.add(btnNewButton);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("");
			panel_1.add(lblNewLabel_5);
		}
		{
			JButton btnNewButton_1 = new JButton("IMPRIMIR DATOS CUENTA");
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						String mensaje = miBanco.devolverDatosCuenta(JOptionPane.showInputDialog(null, "Ingrese el numero de la cuenta:"));
						JOptionPane.showMessageDialog(null, mensaje);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			});
			panel_1.add(btnNewButton_1);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("");
			panel_1.add(lblNewLabel_6);
		}
		{
			JButton btnNewButton_2 = new JButton("CONSULTAR SALDO");
			btnNewButton_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						String mensaje = miBanco.consultarSaldoCuenta(JOptionPane.showInputDialog(null, "Ingrese el numero de la cuenta:"));
						JOptionPane.showMessageDialog(null, mensaje);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			});
			panel_1.add(btnNewButton_2);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("");
			panel_1.add(lblNewLabel_7);
		}
		{
			JButton btnNewButton_3 = new JButton("CONSIGNAR VALOR");
			btnNewButton_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						String mensaje = miBanco.consignarValorCuenta(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor a consignar:")), JOptionPane.showInputDialog(null, "Ingrese el numero de la cuenta a la que se va a consignar:"));
						JOptionPane.showMessageDialog(null, mensaje);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			});
			panel_1.add(btnNewButton_3);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("");
			panel_1.add(lblNewLabel_8);
		}
		{
			JButton btnNewButton_4 = new JButton("RETIRAR VALOR");
			btnNewButton_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						String mensaje = miBanco.retirarValorCuenta(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor a retirar:")), JOptionPane.showInputDialog(null, "Ingrese el numero de la cuenta de la que se va a retirar:"));
						JOptionPane.showMessageDialog(null, mensaje);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			});
			panel_1.add(btnNewButton_4);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("");
			panel_1.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_9 = new JLabel("");
			panel_1.add(lblNewLabel_9);
		}
		{
			JButton btnNewButton_5 = new JButton("ENLAZAR CUENTA CLIENTE");
			btnNewButton_5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						String mensaje = miBanco.asociarCuentaCliente(JOptionPane.showInputDialog(null, "Ingrese la identificacion del cliente:"), JOptionPane.showInputDialog(null, "Ingrese el numero de la cuenta:"));
						JOptionPane.showMessageDialog(null, mensaje);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			});
			panel_1.add(btnNewButton_5);
		}
		{
			JLabel lblNewLabel_10 = new JLabel("");
			panel_1.add(lblNewLabel_10);
		}
		{
			JButton btnNewButton_6 = new JButton("ENLAZAR CUENTA BENEFICIARIO");
			btnNewButton_6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						String mensaje = miBanco.asociarBeneficiarioCuenta(JOptionPane.showInputDialog(null, "Ingrese la identificacion del beneficiario:"), JOptionPane.showInputDialog(null, "Ingrese el numero de la cuenta:"));
						JOptionPane.showMessageDialog(null, mensaje);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			});
			panel_1.add(btnNewButton_6);
		}
		
	}

	

}
