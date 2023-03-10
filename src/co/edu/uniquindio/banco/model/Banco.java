package co.edu.uniquindio.banco.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Banco {

	private String nombre;
	private String direccion;
	private String nit;
	private List<Cliente> listaClientes;
	private List<Cuenta> listaCuentas;
	private List<Beneficiario> listaBeneficiarios;
	
	public Banco() {
		
	}
	/**
	 * Constructor de la clase Banco
	 * @param nombre
	 * @param direccion
	 * @param nit
	 */
	public Banco(String nombre, String direccion, String nit) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.nit = nit;
		this.listaClientes = new ArrayList<Cliente>();
		this.listaCuentas = new ArrayList<Cuenta>();
		this.listaBeneficiarios = new ArrayList<Beneficiario>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public List<Cuenta> getListaCuentas() {
		return listaCuentas;
	}
	public void setListaCuentas(List<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}
	
	@Override
	public String toString() {
		return "Banco [nombre=" + nombre + ", direccion=" + direccion + ", nit=" + nit + ", listaClientes="
				+ listaClientes + ", listaCuentas=" + listaCuentas + ", listaBeneficiarios=" + listaBeneficiarios + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banco other = (Banco) obj;
		return Objects.equals(nit, other.nit);
	}
	
	// CRUD de la clase Cliente
	/**
	 * Metodo para obtener Cliente en el Banco
	 * @param identificacion
	 * @return
	 */
	public Cliente obtenerCliente(String identificacion) {
		Cliente cliente = null;
		try {
			cliente = listaClientes.stream().filter(clienteAux -> clienteAux.getIdentificacion().equals(identificacion)).findFirst().get();
		}
		catch(Exception e) {
			
		}
		return cliente;
	}
	/**
	 * Metodo para verificar un Cliente en el Banco
	 * @param identificacion
	 * @return
	 */
	public boolean verificarCliente(String identificacion) {
		return listaClientes.stream().anyMatch(cliente -> cliente.getIdentificacion().equals(identificacion));
	}
	/**
	 * Metodo para crear un Cliente
	 * @param nombre
	 * @param apellido
	 * @param identificacion
	 * @return
	 * @throws Exception
	 */
	public String crearCliente(String nombre, String apellido, String identificacion) throws Exception {
		String mensaje;
		if(verificarCliente(identificacion)==false) {
			listaClientes.add(new Cliente(nombre, apellido, identificacion));
			mensaje = "Cliente creado exitosamente";
		}
		else {
			throw new Exception("El cliente ya esta registrado");
		}
		return mensaje;
	}
	/**
	 * Metodo para actualizar los atributos de un Cliente
	 * @param nombre
	 * @param apellido
	 * @param identificacion
	 * @return
	 * @throws Exception
	 */
	public String actualizarCliente(String nombre, String apellido, String identificacion) throws Exception {
		String mensaje;
		Cliente cliente = obtenerCliente(identificacion);
		if(cliente != null) {
			cliente.setNombre(nombre);
			cliente.setApellidos(apellido);
			mensaje = "El cliente fue modificado exitosamente";
		}
		else {
			throw new Exception("El cliente no esta registrado");
		}
		return mensaje;
	}
	/**
	 * Metodo para eliminar un Cliente
	 * @param identificacion
	 * @return
	 * @throws Exception
	 */
	public String eliminarCliente(String identificacion) throws Exception {
		String mensaje;
		Cliente cliente = obtenerCliente(identificacion);
		if(cliente != null) {
			listaClientes.remove(cliente);
			mensaje = "El cliente fue eliminado correctamente";
		}
		else {
			throw new Exception("El cliente no se encuentra registrado");
		}
		return mensaje;
	}
	/**
	 * Metodo para devolver los atributos de un Cliente
	 * @param identificacion
	 * @return
	 * @throws Exception
	 */
	public String devolverDatosCliente(String identificacion) throws Exception
	{
		String mensaje;
		Cliente cliente = obtenerCliente(identificacion);
		if(cliente==null)
		{
			throw new Exception("El cliente no esta registrado");
		}
		else
		{
			mensaje="Nombres:"+" "+cliente.getNombre()+"\n"+"Apellidos:"+" "+cliente.getApellidos()+"\n"+"Identificacion:"+" "+cliente.getIdentificacion()
			+"\n"+"Lista Cuentas:"+" "+cliente.getListaCuentas();
		}
		return mensaje;
	}
	
	// CRUD clase Cuenta
	public Cuenta obtenerCuenta(String numeroCuenta) {
		Cuenta cuenta = null;
		try {
			cuenta = listaCuentas.stream().filter(cuentaAux -> cuentaAux.getNumeroCuenta().equals(numeroCuenta)).findFirst().get();
		}
		catch(Exception e) {
			
		}
		return cuenta;
	}
	public boolean verificarCuenta(String numeroCuenta) {
		return listaCuentas.stream().anyMatch(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta));
	}
	public String crearCuenta(Cliente clienteTitular, String numeroCuenta, String tipoCuenta) throws Exception
	{
		String mensaje;
		if(tipoCuenta.toUpperCase().equals("AHORROS") || tipoCuenta.toUpperCase().equals("CORRIENTE")) {
			if(verificarCuenta(numeroCuenta)==false) {
				if(clienteTitular != null) {
					Cuenta cuenta = new Cuenta(clienteTitular, numeroCuenta, tipoCuenta );
					listaCuentas.add(cuenta);
					clienteTitular.listaCuentas.add(cuenta);
					mensaje="La cuenta fue creada exitosamente";
				}
				else {
					throw new Exception("El cliente titular de la cuenta no esta registrado");
				}
			}
			else {
				throw new Exception("La cuenta ya existe");
			}
		}
		else {
			throw new Exception("El tipo de cuenta es incorrecto");
		}
		return mensaje;
	}
	/**
	 * Metodo para devolver los atributos de la clase Cuenta
	 * @param numeroCuenta
	 * @return
	 * @throws Exception
	 */
	public String devolverDatosCuenta(String numeroCuenta) throws Exception
	{
		String mensaje;
		Cuenta cuenta = obtenerCuenta(numeroCuenta);
		if(cuenta==null)
		{
			throw new Exception("La cuenta no esta registrada");
		}
		else
		{
			mensaje="Cliente Titular:"+" "+cuenta.getClienteTitular().getIdentificacion()+"\n"+"Numero de la Cuenta:"+" "+cuenta.getNumeroCuenta()+"\n"+"Tipo de la Cuenta:"+" "+cuenta.getTipoCuenta()+"\n"
					+"Saldo Cuenta:"+" "+cuenta.getSaldoCuenta()+"\n"+"Beneficiarios:"+" "+cuenta.getListaBeneficiarios();
		}
		return mensaje;
	}
	
	//CRUD clase Beneficiario
	public Beneficiario obtenerBeneficiario(String identificacion) {
		Beneficiario beneficiario = null;
		try {
			beneficiario = listaBeneficiarios.stream().filter(beneficiarioAux -> beneficiarioAux.getIdentificacion().equals(identificacion)).findFirst().get();
		}
		catch(Exception e) {
			
		}
		return beneficiario;
	}
	public boolean verificarBeneficiario(String identificacion) {
		return listaBeneficiarios.stream().anyMatch(beneficiario -> beneficiario.getIdentificacion().equals(identificacion));
	}
	public String crearBeneficiario(String identificacion, double rangoInferior, double rangoSuperior) throws Exception {
		String mensaje;
		if(rangoInferior<rangoSuperior) {
			if(verificarBeneficiario(identificacion)==false) {
				listaBeneficiarios.add(new Beneficiario(identificacion, rangoInferior, rangoSuperior));
				mensaje = "Beneficiario creado exitosamente";
			}
			else {
				throw new Exception("El Beneficiario ya esta registrado");
			}
		}
		else {
			throw new Exception("El rango inferior debe de ser menor al rango superior");
		}
		return mensaje;
	}
	/**
	 * Metodo para actualizar los atributos de un Cliente
	 * @param nombre
	 * @param apellido
	 * @param identificacion
	 * @return
	 * @throws Exception
	 */
	public String actualizarBeneficiario(String identificacion, double rangoInferior, double rangoSuperior) throws Exception {
		String mensaje;
		Beneficiario beneficiario = obtenerBeneficiario(identificacion);
		if(beneficiario != null) {
			beneficiario.setRangoInferior(rangoInferior);
			beneficiario.setRangoSuperior(rangoSuperior);
			mensaje = "Beneficiario actualizado";
		}
		else {
			throw new Exception("El beneficiario no esta registrado");
		}
		return mensaje;
	}
	/**
	 * Metodo para eliminar un Cliente
	 * @param identificacion
	 * @return
	 * @throws Exception
	 */
	public String eliminarBeneficiario(String identificacion) throws Exception {
		String mensaje;
		Beneficiario beneficiario = obtenerBeneficiario(identificacion);
		if(beneficiario != null) {
			listaBeneficiarios.remove(beneficiario);
			mensaje = "El beneficiario fue eliminado correctamente";
		}
		else {
			throw new Exception("El beneficiario no se encuentra registrado");
		}
		return mensaje;
	}
	/**
	 * Metodo para devolver los atributos de un Cliente
	 * @param identificacion
	 * @return
	 * @throws Exception
	 */
	public String devolverDatosBeneficiario(String identificacion) throws Exception
	{
		String mensaje;
		Beneficiario beneficiario = obtenerBeneficiario(identificacion);
		if(beneficiario==null)
		{
			throw new Exception("El beneficiario no esta registrado");
		}
		else
		{
			mensaje="Identificaion:"+" "+beneficiario.getIdentificacion()+"\n"+"Rango Inferior:"+" "+beneficiario.getRangoInferior()+"\n"+"Rango Superior:"+" "+beneficiario.getRangoSuperior()
			+"\n"+"Cuentas Asociadas:"+" "+beneficiario.getListaCuentasAsociadas();
		}
		return mensaje;
	}
	
	//Funciones del Banco
	/**
	 * Metodo para consultar el saldo de una cuenta
	 * @param numeroCuenta
	 * @return
	 * @throws Exception
	 */
	public String consultarSaldoCuenta(String numeroCuenta) throws Exception {
		String mensaje;
		Cuenta cuenta = obtenerCuenta(numeroCuenta);
		if(cuenta != null) {
			mensaje="El saldo de la cuenta es:"+" "+"$"+" "+cuenta.getSaldoCuenta();
		}
		else {
			throw new Exception("La cuenta no esta registrada");
		}
		return mensaje;
	}
	/**
	 * Metodo para consignar un valor a una cuenta
	 * @param valor
	 * @param numeroCuenta
	 * @return
	 * @throws Exception
	 */
	public String consignarValorCuenta(double valor, String numeroCuenta) throws Exception {
		String mensaje;
		Cuenta cuenta=obtenerCuenta(numeroCuenta);
		if(cuenta!=null) {
			cuenta.consignarValor(valor);
			mensaje="El valor fue consignado a la cuenta";
		}
		else {
			throw new Exception("La cuenta a la que se va a consignar no esta regitrada");
		}
		return mensaje;
	}
	/**
	 * Metodo para retirar un valor de una cuenta
	 * @param valor
	 * @param numeroCuenta
	 * @return
	 * @throws Exception
	 */
	public String retirarValorCuenta(double valor, String numeroCuenta) throws Exception {
		String mensaje;
		Cuenta cuenta = obtenerCuenta(numeroCuenta);
		if(cuenta != null) {
			if(cuenta.verificarSaldo(valor)==true) {
				cuenta.modificarSaldo(valor);
				mensaje="Proceso Exitoso";
			}
			else {
				throw new Exception("La cuenta no tiene saldo suficiente");
			}
		}
		else {
			throw new Exception("La cuenta de la que se quiere retirar no se encuentra registrada");
		}
		return mensaje;
	}
	/**
	 * Metodo para compara el saldo entre cuentas
	 * @param numeroCuenta1
	 * @param cuenta2
	 * @return
	 * @throws Exception
	 */
	public boolean compararSaldoEntreCuentas(String numeroCuenta1, Cuenta cuenta2) throws Exception {
		if(obtenerCuenta(numeroCuenta1)==null) throw new Exception("La cuenta 1 no esta registrada");
		if(cuenta2 == null) throw new Exception("La cuenta 2 no esta registrada");
		boolean centinela = false;
		Cuenta cuenta1 = obtenerCuenta(numeroCuenta1);
		if(cuenta1.compararSaldo(cuenta2)==true) {
			centinela = true;
		}
		return centinela;
	}
	/**
	 * Metodo para transferir el saldo de una cuenta a otra
	 * @param numeroCuenta
	 * @param valor
	 * @param cuentaDestino
	 * @return
	 * @throws Exception
	 */
	public String tranferirSaldo(String numeroCuenta, double valor, Cuenta cuentaDestino) throws Exception {
		String mensaje;
		if(obtenerCuenta(numeroCuenta)==null) throw new Exception("La cuenta emisora no esta registrada");
		if(cuentaDestino == null) throw new Exception("La cuenta de destino no esta registrada");
		try {
			mensaje=retirarValorCuenta(valor, numeroCuenta);
			cuentaDestino.consignarValor(valor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mensaje = e.getMessage();
		}
		return mensaje;
	}
	/**
	 * Metodo para asociar una cuenta a un cliente
	 * @throws Exception 
	 */
	public String asociarCuentaCliente(String identificacion, String numeroCuenta) throws Exception {
		String mensaje="";
		Cliente cliente = obtenerCliente(identificacion);
		Cuenta cuenta = obtenerCuenta(numeroCuenta);
		
		if(cliente == null) {
			throw new Exception("El cliente no esta registrado");
		}
		if(cuenta == null) {
			throw new Exception("La cuenta no esta registrada");
		}
		if(cliente != null && cuenta!=null && verificarContieneCuenta(numeroCuenta, cliente.getListaCuentas())==false) {
			cliente.listaCuentas.add(cuenta);
			mensaje = "La cuenta fue asociada correctamente";
		}
		else {
			throw new Exception("La cuenta ya esta enlazada al cliente");
		}
		return mensaje;
	}
	/**
	 * Metodo para asociar un beneficiario a una cuenta
	 * @throws Exception 
	 */
	public String asociarBeneficiarioCuenta(String identificacion, String numeroCuenta) throws Exception {
		String mensaje="";
		Beneficiario beneficiario = obtenerBeneficiario(identificacion);
		Cuenta cuenta = obtenerCuenta(numeroCuenta);
		
		if(beneficiario == null) {
			throw new Exception("El beneficiario no esta registrado");
		}
		if(cuenta == null) {
			throw new Exception("La cuenta no esta registrada");
		}
		if(beneficiario != null && cuenta!=null && verificarContieneCuenta(numeroCuenta, beneficiario.getListaCuentasAsociadas())==false) {
			beneficiario.listaCuentasAsociadas.add(cuenta);
			cuenta.listaBeneficiarios.add(beneficiario);
			mensaje = "La cuenta fue asociada correctamente";
		}
		else {
			throw new Exception("La cuenta ya esta enlazada al beneficiario");
		}
		return mensaje;
	}
	/**
	 * metodo para verificar si un objeto contiene una cuenta
	 */
	public static boolean verificarContieneCuenta(String numeroCuenta, List<Cuenta> listaCuentas) {
		boolean centinela = false;
		for(Cuenta cuenta : listaCuentas) {
			if(cuenta.getNumeroCuenta().equals(numeroCuenta)) {
				centinela=true;
			}
		}
		return centinela;
	}
	
}
