package edu.uclm.esi.iso2.banco20193capas;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.uclm.esi.iso2.banco20193capas.model.Cuenta;
import edu.uclm.esi.iso2.banco20193capas.model.Manager;
import edu.uclm.esi.iso2.banco20193capas.exceptions.CuentaInvalidaException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.CuentaSinTitularesException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.CuentaYaCreadaException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.ImporteInvalidoException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.PinInvalidoException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.SaldoInsuficienteException;
import edu.uclm.esi.iso2.banco20193capas.model.Cliente;
import edu.uclm.esi.iso2.banco20193capas.model.Tarjeta;
import edu.uclm.esi.iso2.banco20193capas.model.TarjetaCredito;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCliente extends TestCase {
	
	private Cliente pepe;
	long id = 054321;
	
	@Before
	public void setUp() {
		Manager.getMovimientoDAO().deleteAll();
		Manager.getMovimientoTarjetaCreditoDAO().deleteAll();
		Manager.getTarjetaCreditoDAO().deleteAll();
		Manager.getTarjetaDebitoDAO().deleteAll();
		Manager.getCuentaDAO().deleteAll();
		Manager.getClienteDAO().deleteAll();
		
		this.pepe = new Cliente("12345X", "Pepe", "Pérez"); this.pepe.insert();
	}
	
	
	@Test
	public void testCambioNombreApellidosOK() {
		try {
			
			pepe.setId(id);
			pepe.setNif("12346X");
			pepe.setNombre("José");
			pepe.setApellidos("Gómez");		
			
		}catch(Exception e) {
			fail("Excepción inesperada " + e.getMessage());
		}
		
	}
	
	@Test
	public void testObtenerNombreApellidosOK() {
		try {
			
			pepe.getNombre();
			pepe.getApellidos();
			
		}catch(Exception e) {
			fail("Excepción intesperada " + e.getMessage());
		}
		
	}
	

}
