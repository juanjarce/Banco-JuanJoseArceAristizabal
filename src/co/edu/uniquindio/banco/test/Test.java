package co.edu.uniquindio.banco.test;

import co.edu.uniquindio.banco.model.Banco;

public class Test {
	public static void main(String args[]) {
		
		Banco miBanco = new Banco("Bancolombia", "Cr 15N #20-07", "12345");
		
		//crear clientes para prueba
		try {
			String mensaje = miBanco.crearCliente("Juan Jose", "Arce Aristizabal", "1092851015");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.crearCliente("Jaidiver Nallybe", "Aristizabal Cardona", "41945090");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.crearCliente("Cesar Augusto", "Arce Vargas", "18494175");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.crearCliente("Juan Jose", "Arce Aristizabal", "1092851015");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//crear Beneficiario
		try {
			String mensaje = miBanco.crearBeneficiario("1092854299", 15000, 50000);
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.crearBeneficiario("1092854299", 15000, 50000);
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//crear cuentas para prueba
		try {
			String mensaje = miBanco.crearCuenta(miBanco.obtenerCliente("1092851015"), "1234", "ahorros");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.crearCuenta(miBanco.obtenerCliente("41945090"), "4321", "ahorros");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.crearCuenta(miBanco.obtenerCliente("1092851015"), "1234", "ahorros");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//devolver datos de cuenta prueba
		try {
			String mensaje = miBanco.devolverDatosCuenta("1234");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//asociar cuenta a clientes prueba
		try {
			String mensaje = miBanco.asociarCuentaCliente("1092851015", "1234");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.asociarCuentaCliente("18494175", "1234");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.asociarCuentaCliente("18494175", "4321");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.asociarCuentaCliente("18494175", "1234");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//devolver datos del cliente prueba
		try {
			String mensaje = miBanco.devolverDatosCliente("18494175");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//consignar valor a una cuenta prueba
		try {
			String mensaje = miBanco.consignarValorCuenta(50000, "1234");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.consignarValorCuenta(10000, "4321");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.consignarValorCuenta(5000, "448984");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//retirar valor de una cuenta prueba
		try {
			String mensaje = miBanco.retirarValorCuenta(10000, "1234");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.retirarValorCuenta(90000, "1234");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.retirarValorCuenta(2000, "4321");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.retirarValorCuenta(10000, "484878");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//consultar saldo de cuentas prueba
		try {
			String mensaje = miBanco.consultarSaldoCuenta("1234");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.consultarSaldoCuenta("4321");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.consultarSaldoCuenta("484848");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//compara saldo entre cuentas prueba
		try {
			boolean centinela = miBanco.compararSaldoEntreCuentas("1234", miBanco.obtenerCuenta("4321"));
			System.out.println(centinela);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			boolean centinela = miBanco.compararSaldoEntreCuentas("4321", miBanco.obtenerCuenta("1234"));
			System.out.println(centinela);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			boolean centinela = miBanco.compararSaldoEntreCuentas("548484", miBanco.obtenerCuenta("4321"));
			System.out.println(centinela);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//transferir saldo entre cuentas prueba
		try {
			String mensaje = miBanco.tranferirSaldo("1234", 10000, miBanco.obtenerCuenta("4321"));
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.tranferirSaldo("4321", 15000, miBanco.obtenerCuenta("1234"));
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.tranferirSaldo("1234", 500000, miBanco.obtenerCuenta("4321"));
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.tranferirSaldo("1234", 5000, miBanco.obtenerCuenta("515454"));
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//consultar saldo de las cuentas
		try {
			String mensaje = miBanco.consultarSaldoCuenta("1234");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.consultarSaldoCuenta("4321");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//asociar beneficiario a cuenta
		try {
			String mensaje = miBanco.asociarBeneficiarioCuenta("1092854299", "1234");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.asociarBeneficiarioCuenta("1092854299", "1234");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.asociarBeneficiarioCuenta("15454848", "1234");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//imprimir atributos de las cuentas
		try {
			String mensaje = miBanco.devolverDatosCuenta("1234");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.devolverDatosCuenta("4321");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			String mensaje = miBanco.devolverDatosCuenta("54548");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
