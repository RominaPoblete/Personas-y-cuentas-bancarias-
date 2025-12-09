package clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class CuentaBancaria {
	private double saldo;
	private Persona titular;
	private int numeroCuenta;

	public static ArrayList<CuentaBancaria> listaDeCuentasBancarias = new ArrayList<>();
	private static Set<Integer> numerosUsados = new HashSet<>();

	public CuentaBancaria(double saldo, Persona titular) {
		this.saldo = saldo;
		this.titular = titular;
		this.numeroCuenta = generarNumeroCuentaUnico();
		listaDeCuentasBancarias.add(this);
	}

	private int generarNumeroCuentaUnico() {
		int numero;
		do {
			numero = ThreadLocalRandom.current().nextInt(100000, 1000000);
		} while (numerosUsados.contains(numero));
		numerosUsados.add(numero);
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Persona getTitular() {
		return titular;
	}

	public void setTitular(Persona titular) {
		this.titular = titular;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	// Métodos de operación
	public void depositar(double monto) {
		if (monto <= 0) {
			System.out.println("El monto a depositar debe ser mayor que 0");
			return;
		}
		saldo += monto;
	}

	public void retirar(double monto) {
		if (monto <= 0) {
			System.out.println("El monto a retirar debe ser mayor que 0");
			return;
		}
		if (saldo >= monto) {
			saldo -= monto;
		} else {
			System.out.println("Fondos insuficientes para retirar $" + String.format("%.2f", monto));
		}
	}

	public void despliegaInformacion() {
		System.out.println("=== Información de la Cuenta ===");
		System.out.println("Número de Cuenta: " + numeroCuenta);
		System.out.println("Saldo: $" + String.format("%.2f", saldo));
		System.out.println("Titular:");
		titular.despliegaInformacion();
	}

	public static void imprimeInformacionDeTodasLasCuentas() {
		System.out.println("\n--- Todas las Cuentas Registradas ---");
		for (CuentaBancaria c : listaDeCuentasBancarias) {
			c.despliegaInformacion();
			System.out.println();
		}
	}
}
