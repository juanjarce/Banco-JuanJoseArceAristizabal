package co.edu.uniquindio.banco.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.uniquindio.banco.model.Banco;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroBeneficiario extends JFrame {

	public Banco miBanco;
	private JPanel contentPane;
	private JTextField inputIdentificacion;
	private JTextField inputRangoInferior;
	private JTextField inputRangoSuperior;

	/**
	 * Create the frame.
	 */
	public RegistroBeneficiario(Banco miBanco) {
		
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

	private void generarPanelSuperior() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("REGISTRO BENEFICIARIO");
		panel.add(lblNewLabel);
	}

	private void generarPanelMedio() {
		// TODO Auto-generated method stub
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(7,2));
		{
			JLabel lblNewLabel_1 = new JLabel("Identificacion:");
			panel_1.add(lblNewLabel_1);
		}
		{
			inputIdentificacion = new JTextField();
			panel_1.add(inputIdentificacion);
			inputIdentificacion.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Rango Inferior:");
			panel_1.add(lblNewLabel_2);
		}
		{
			inputRangoInferior = new JTextField();
			panel_1.add(inputRangoInferior);
			inputRangoInferior.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Rango Superior:");
			panel_1.add(lblNewLabel_3);
		}
		{
			inputRangoSuperior = new JTextField();
			panel_1.add(inputRangoSuperior);
			inputRangoSuperior.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("CREAR BENEFICIARIO");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						String mensaje = miBanco.crearBeneficiario(inputIdentificacion.getText(), Double.parseDouble(inputRangoInferior.getText()), Double.parseDouble(inputRangoSuperior.getText()));
						JOptionPane.showMessageDialog(null, mensaje);
						inputIdentificacion.setText(null);
						inputRangoInferior.setText(null);
						inputRangoSuperior.setText(null);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			});
			panel_1.add(btnNewButton);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("");
			panel_1.add(lblNewLabel_4);
		}
		{
			JButton btnNewButton_1 = new JButton("BUSCAR BENEFICIARIO");
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						String mensaje = miBanco.devolverDatosBeneficiario(JOptionPane.showInputDialog(null, "Ingrese la identificacion del beneficiario:"));
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
			JLabel lblNewLabel_5 = new JLabel("");
			panel_1.add(lblNewLabel_5);
		}
		{
			JButton btnNewButton_2 = new JButton("MODIFICAR BENEFICIARIO");
			btnNewButton_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						String mensaje = miBanco.actualizarBeneficiario(JOptionPane.showInputDialog(null, "Ingrese la identificacion del beneficiario:"), Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el rango inferior del beneficiario:")), Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el rango superior del beneficiario:")));
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
			JLabel lblNewLabel_6 = new JLabel("");
			panel_1.add(lblNewLabel_6);
		}
		{
			JButton btnNewButton_3 = new JButton("ELIMINAR BENEFICIARIO");
			btnNewButton_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						String mensaje = miBanco.eliminarBeneficiario(JOptionPane.showInputDialog(null, "Ingrese la identificacion del beneficiario:"));
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
			JLabel lblNewLabel_7 = new JLabel("");
			panel_1.add(lblNewLabel_7);
		}
	}

}
