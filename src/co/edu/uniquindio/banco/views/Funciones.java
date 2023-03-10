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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Funciones extends JFrame {
	
	public Banco miBanco;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Funciones(Banco miBanco) {
		
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
		
		JLabel lblNewLabel = new JLabel("FUNCIONES ADICIONALES");
		panel.add(lblNewLabel);
	}

	public void generarPanelMedio() {
		// TODO Auto-generated method stub
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2,2));
		{
			JButton btnNewButton = new JButton("COMPARAR SALDO ENTRE CUENTAS");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						JOptionPane.showMessageDialog(null, String.valueOf(miBanco.compararSaldoEntreCuentas(JOptionPane.showInputDialog(null, "Ingrese el numero de la cuenta 1:"), miBanco.obtenerCuenta(JOptionPane.showInputDialog(null, "Ingrese el numero de la 2nda cuenta:")))));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			});
			panel_1.add(btnNewButton);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			panel_1.add(lblNewLabel_1);
		}
		{
			JButton btnNewButton_1 = new JButton("TRANSFERIR SALDO");
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String mensaje;
					try {
						mensaje = miBanco.tranferirSaldo(JOptionPane.showInputDialog(null, "Ingrese el numero de la cuenta emisora:"), Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor a transferir:")), miBanco.obtenerCuenta(JOptionPane.showInputDialog(null, "Ingrese el numero de la cuenta de destino:")));
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
			JLabel lblNewLabel_2 = new JLabel("");
			panel_1.add(lblNewLabel_2);
		}
	}

}
