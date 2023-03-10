package co.edu.uniquindio.banco.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cuenta {

	public Cliente clienteTitular;
	private String numeroCuenta;
	private String tipoCuenta;
	private Double saldoCuenta;
	public List<Beneficiario> listaBeneficiarios;
	
	public Cuenta() {
		
	}
	/**
	 * Metodo constructor de la clase Cuenta
	 * @param nombresTitular
	 * @param apellidosTitular
	 * @param numeroCuenta
	 * @param tipoCuenta
	 */
	public Cuenta(Cliente clienteTitular, String numeroCuenta, String tipoCuenta) {
		super();
		this.clienteTitular = clienteTitular;
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldoCuenta = 0.0;
		this.listaBeneficiarios = new ArrayList<Beneficiario>();
	}
	
	public Cliente getClienteTitular() {
		return clienteTitular;
	}
	public void setClienteTitular(Cliente clienteTitular) {
		this.clienteTitular = clienteTitular;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public Double getSaldoCuenta() {
		return saldoCuenta;
	}
	public void setSaldoCuenta(Double saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}
	public List<Beneficiario> getListaBeneficiarios() {
		return listaBeneficiarios;
	}
	public void setListaBeneficiarios(List<Beneficiario> listaBeneficiarios) {
		this.listaBeneficiarios = listaBeneficiarios;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numeroCuenta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return Objects.equals(numeroCuenta, other.numeroCuenta);
	}
	
	/**
	 * Cambia el valor actual de la cuenta, sumandole la consignacion
	 * @param valor
	 */
	public void consignarValor(double valor) {
		double valorNuevo=getSaldoCuenta()+valor;
		setSaldoCuenta(valorNuevo);
	}
	
	/**
	 * Verifica si el saldo de la cuenta es mayor al valor a retirar
	 * @param valor
	 * @return
	 */
	public boolean verificarSaldo(double valor) {
		// TODO Auto-generated method stub
		boolean centinela=false;
		if(getSaldoCuenta()>=valor) {
			centinela=true;
		}
		return centinela;
	}
	/**
	 * Modifica el saldo restandole el valor retirado
	 * @param valor
	 */
	public void modificarSaldo(double valor) {
		// TODO Auto-generated method stub
		double valorNuevo=getSaldoCuenta()-valor;
		setSaldoCuenta(valorNuevo);
	}
	/**
	 * Verifica si el saldo de la cuenta es mayor o igual a la cuenta del parametro
	 * @param cuenta2
	 * @return
	 */
	public boolean compararSaldo(Cuenta cuenta2) {
		// TODO Auto-generated method stub
		boolean centinela=false;
		if(getSaldoCuenta()>=cuenta2.getSaldoCuenta()) {
			centinela=true;
		}
		return centinela;
	}
	
	
}
