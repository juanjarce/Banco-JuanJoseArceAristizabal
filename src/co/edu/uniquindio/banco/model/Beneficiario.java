package co.edu.uniquindio.banco.model;

import java.util.ArrayList;
import java.util.List;

public class Beneficiario {

	public List<Cuenta> listaCuentasAsociadas;
	String identificacion;
	private Double rangoInferior;
	private Double rangoSuperior;
	
	public Beneficiario() {
		
	}
	/**
	 * Metodo constructor clase beneficiario
	 * @param rangoInferior
	 * @param rangoSuperior
	 */
	public Beneficiario(String identificacion, Double rangoInferior, Double rangoSuperior) {
		super();
		this.identificacion = identificacion;
		this.rangoInferior = rangoInferior;
		this.rangoSuperior = rangoSuperior;
		this.listaCuentasAsociadas = new ArrayList<Cuenta>();
	}
	
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public List<Cuenta> getListaCuentasAsociadas() {
		return listaCuentasAsociadas;
	}
	public void setListaCuentasAsociadas(List<Cuenta> listaCuentasAsociadas) {
		this.listaCuentasAsociadas = listaCuentasAsociadas;
	}
	public Double getRangoInferior() {
		return rangoInferior;
	}
	public void setRangoInferior(Double rangoInferior) {
		this.rangoInferior = rangoInferior;
	}
	public Double getRangoSuperior() {
		return rangoSuperior;
	}
	public void setRangoSuperior(Double rangoSuperior) {
		this.rangoSuperior = rangoSuperior;
	}
}
