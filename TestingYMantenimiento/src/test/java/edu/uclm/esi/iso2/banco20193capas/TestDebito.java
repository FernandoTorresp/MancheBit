package edu.uclm.esi.iso2.banco20193capas;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.uclm.esi.iso2.banco20193capas.exceptions.ImporteInvalidoException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.PinInvalidoException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.SaldoInsuficienteException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.TarjetaBloqueadaException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.TokenInvalidoException;
import edu.uclm.esi.iso2.banco20193capas.model.Cliente;
import edu.uclm.esi.iso2.banco20193capas.model.Cuenta;
import edu.uclm.esi.iso2.banco20193capas.model.Manager;
import edu.uclm.esi.iso2.banco20193capas.model.TarjetaCredito;
import edu.uclm.esi.iso2.banco20193capas.model.TarjetaDebito;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDebito extends TestCase{
	private Cuenta cuentaPepe;
	private Cliente pepe;
	private TarjetaDebito tdPepe;

	@Before
	public void setUp() {
		Manager.getMovimientoDAO().deleteAll();
		Manager.getMovimientoTarjetaCreditoDAO().deleteAll();
		Manager.getTarjetaCreditoDAO().deleteAll();
		Manager.getTarjetaDebitoDAO().deleteAll();
		Manager.getCuentaDAO().deleteAll();
		Manager.getClienteDAO().deleteAll();
		
		this.pepe = new Cliente("12345X", "Pepe", "Pérez"); this.pepe.insert();
		this.cuentaPepe = new Cuenta(1);
		try {
			this.cuentaPepe.addTitular(pepe); this.cuentaPepe.insert(); this.cuentaPepe.ingresar(1000);
			this.tdPepe = this.cuentaPepe.emitirTarjetaDebito(pepe.getNif());
			this.tdPepe.cambiarPin(tdPepe.getPin(), 1234);
		}
		catch (Exception e) {
			fail("Excepción inesperada en setUp(): " + e);
		}
	}
	
	
	@Test
	public void testCompraConTDSaldoInsuficiente() {
		try {
			tdPepe.comprar(1234,1001);
			fail("Esperaba SaldoInsuficienteException");
		} catch (SaldoInsuficienteException e) {
		} catch (Exception e) {
			fail("Excepción inesperada: " + e.getMessage());
		}
	}
	
	@Test
	public void testCompraConTDImporteIncorrecto() {
		try {
			tdPepe.comprar(1234,-1);
			fail("Esperaba ImporteInvalidoException");
		} catch (ImporteInvalidoException e) {
		} catch (Exception e) {
			fail("Excepción inesperada: " + e.getMessage());
		}
	}
	
	@Test
	public void testCompraConTDPinIncorrecto() {
		try {
			tdPepe.comprar(234,999);
			fail("Esperaba PinInvalidoException");
		} catch (PinInvalidoException e) {
		} catch (Exception e) {
			fail("Excepción inesperada: " + e.getMessage());
		}
	}
	
	
	@Test
	public void testSacarDineroConTDSaldoInsuficiente() {
		try {
			tdPepe.sacarDinero(1234,1001);
			fail("Esperaba SaldoInsuficienteException");
		} catch (SaldoInsuficienteException e) {
		} catch (Exception e) {
			fail("Excepción inesperada: " + e.getMessage());
		}
	}
	
	@Test
	public void testSacarDineroConTDImporteIncorrecto() {
		try {
			tdPepe.sacarDinero(1234,-1);
			fail("Esperaba ImporteInvalidoException");
		} catch (ImporteInvalidoException e) {
		} catch (Exception e) {
			fail("Excepción inesperada: " + e.getMessage());
		}
	}
	
	@Test
	public void testSacarDineroConTDPinIncorrecto() {
		try {
			tdPepe.sacarDinero(234,999);
			fail("Esperaba PinInvalidoException");
		} catch (PinInvalidoException e) {
		} catch (Exception e) {
			fail("Excepción inesperada: " + e.getMessage());
		}
	}
	
	
	@Test
	public void testRetiradaDebitoSinSaldo() {
		try {
			int token=this.tdPepe.comprarPorInternet(1234, 1001);
			tdPepe.confirmarCompraPorInternet(token);
			fail("Esperaba SaldoInsuficienteException");
		} catch (SaldoInsuficienteException e) {
		} catch (Exception e) {
			fail("Excepción inesperada");
		}
	}
	
	@Test
	public void testRetiradaDebitoPinInvalido() {
		try {
			int token=this.tdPepe.comprarPorInternet(234, 999);
			tdPepe.confirmarCompraPorInternet(token);
			fail("Esperaba PinInvalidoException");
		} catch (PinInvalidoException e) {
		} catch (Exception e) {
			fail("Excepción inesperada");
		}
	}
	
	@Test
	public void testRetiradaDebitoSaldoIncorrecto() {
		try {
			int token=this.tdPepe.comprarPorInternet(1234, -1);
			tdPepe.confirmarCompraPorInternet(token);
			fail("Esperaba ImporteInvalidoException");
		} catch (ImporteInvalidoException e) {
		} catch (Exception e) {
			fail("Excepción inesperada");
		}
	}
	
	
	@Test
	public void testTokenInvalido() {
		try {
			int token=this.tdPepe.comprarPorInternet(1234, 500);
			tdPepe.confirmarCompraPorInternet(100);
			fail("Esperaba TokenInvalidoException");
		}
		catch (TokenInvalidoException e) {
		}
		catch (Exception e) {
			fail("Excepción inesperada");
		}
	}
	
	
	@Test
	public void testCambiarPin() {
		try {
			this.tdPepe.cambiarPin(1234, 2345);
		}catch (Exception e) {
			fail("Excepción inesperada");
		}
	}
	
	@Test
	public void testCambiarPinInvalido() {
		try {
			this.tdPepe.cambiarPin(2345, 2345);
			fail("Esperaba PinInvalidoException");
		}catch (PinInvalidoException e) {
		}catch (Exception e) {
			fail("Excepción inesperada");
		}
	}
	
	@Test
	public void testBloqueoDeTarjeta() {
		try {
			this.tdPepe.comprarPorInternet(5678, 100);
		} catch (PinInvalidoException e) {
		} catch (Exception e) {
			fail("Esperaba PinInvalidoException");
		} 
		try {
			this.tdPepe.comprarPorInternet(5678, 100);
		} catch (PinInvalidoException e) {
		} catch (Exception e) {
			fail("Esperaba PinInvalidoException");
		}
		try {
			this.tdPepe.comprarPorInternet(5678, 100);
		} catch (PinInvalidoException e) {
		} catch (Exception e) {
			fail("Esperaba PinInvalidoException");
		}
		try {
			this.tdPepe.comprarPorInternet(1234, 100);
		} catch (TarjetaBloqueadaException e) {
		} catch (Exception e) {
			fail("Esperaba TarjetaBloqueadaException");
		}
	}

}
