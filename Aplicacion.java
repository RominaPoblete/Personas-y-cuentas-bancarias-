import clases.Persona;
import clases.CuentaBancaria;

//Probar sistema de gestión de cuentas bancarias
public class Aplicacion {
	public static void main(String[] args) {
		System.out.println("╔════════════════════════════════════════════════════╗");
		System.out.println("║     SISTEMA DE GESTIÓN DE CUENTAS BANCARIAS       ║");
		System.out.println("╚════════════════════════════════════════════════════╝\n");

		System.out.println("--- Creando Personas ---");
		Persona persona1 = new Persona("Juan Pérez", 30);
		Persona persona2 = new Persona("María González", 25);
		Persona persona3 = new Persona("Carlos Rodríguez", 40);
		System.out.println("✓ Personas creadas exitosamente\n");
        
		System.out.println("--- Creando Cuentas Bancarias ---");
		CuentaBancaria cuenta1 = new CuentaBancaria(5000.00, persona1);
		System.out.println("✓ Cuenta creada para " + persona1.getNombre());
        
		CuentaBancaria cuenta2 = new CuentaBancaria(3500.50, persona2);
		System.out.println("✓ Cuenta creada para " + persona2.getNombre());
        
		CuentaBancaria cuenta3 = new CuentaBancaria(10000.00, persona3);
		System.out.println("✓ Cuenta creada para " + persona3.getNombre());
        
		System.out.println("\n" + "=".repeat(60));
		System.out.println("OPERACIONES BANCARIAS");
		System.out.println("=".repeat(60));
        
		// Operaciones para cuenta 1
		System.out.println("\n--- Operaciones en Cuenta de " + persona1.getNombre() + " ---");
		System.out.println("Saldo inicial: $" + cuenta1.getSaldo());
		cuenta1.depositar(1500.00);
		cuenta1.retirar(2000.00);
        
		// Operaciones para cuenta 2
		System.out.println("\n--- Operaciones en Cuenta de " + persona2.getNombre() + " ---");
		System.out.println("Saldo inicial: $" + cuenta2.getSaldo());
		cuenta2.depositar(500.00);
		cuenta2.retirar(1000.00);
		cuenta2.retirar(5000.00); 
        
		// Operaciones para cuenta 3
		System.out.println("\n--- Operaciones en Cuenta de " + persona3.getNombre() + " ---");
		System.out.println("Saldo inicial: $" + cuenta3.getSaldo());
		cuenta3.retirar(3000.00);
		cuenta3.depositar(2500.00);
        
		// Saldos
		System.out.println("\n" + "=".repeat(60));
		System.out.println("SALDO ACTUAL DE CADA CUENTA");
		System.out.println("=".repeat(60));
        
		System.out.println("\nCuenta de " + persona1.getNombre() + 
		                " (#" + cuenta1.getNumeroCuenta() + "): $" + 
				        String.format("%.2f", cuenta1.getSaldo()));
        
		System.out.println("Cuenta de " + persona2.getNombre() + 
		                " (#" + cuenta2.getNumeroCuenta() + "): $" + 
				        String.format("%.2f", cuenta2.getSaldo()));
        
		System.out.println("Cuenta de " + persona3.getNombre() + 
						" (#" + cuenta3.getNumeroCuenta() + "): $" + 
						String.format("%.2f", cuenta3.getSaldo()));
        
		CuentaBancaria.imprimeInformacionDeTodasLasCuentas();
        
		System.out.println("\n╔════════════════════════════════════════════════════╗");
		System.out.println("║         FIN DEL PROGRAMA - ¡Gracias!              ║");
		System.out.println("╚════════════════════════════════════════════════════╝");
	}
}
