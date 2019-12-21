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

import java.math.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCliente extends TestCase {
	
	private Cliente pepe;

	private Long id1=-9223372036854775808l;
	private Long id2=-90000l;
	private Long id3=0l;
	private Long id4=123456l;
	private Long id5=9223372036854775807l;
		
	
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
	public void testSetClientePairWise1() {
		try {
			
			pepe.setId(id1);
			pepe.setNif("01111111A");
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}
		try {
			
			pepe.setId(id2);
			pepe.setNif("01111111A");
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}
		try {
			
			pepe.setId(id3);
			pepe.setNif("01111111A");
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}
		try {
			
			pepe.setId(id4);
			pepe.setNif("01111111A");
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}
		try {
			
			pepe.setId(id5);
			pepe.setNif("01111111A");
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}		
		
	}
	
	@Test
	public void testSetClientePairWise2() {
		try {
			
			pepe.setId(id1);
			pepe.setNombre("José");
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}
		try {
			
			pepe.setId(id2);
			pepe.setNombre("José");
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}
		try {
			
			pepe.setId(id3);
			pepe.setNombre("José");
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}
		try {
			
			pepe.setId(id4);
			pepe.setNombre("José");
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}
		try {
			
			pepe.setId(id5);
			pepe.setNombre("José");
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}		
		
	}
	
	@Test
	public void testSetClientePairWise3() {
		try {
			
			pepe.setId(id1);
			pepe.setApellidos("Pérez");
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}
		try {
			
			pepe.setId(id2);
			pepe.setApellidos("Pérez");
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}
		try {
			
			pepe.setId(id3);
			pepe.setApellidos("Pérez");
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}
		try {
			
			pepe.setId(id4);
			pepe.setApellidos("Pérez");
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}
		try {
			
			pepe.setId(id5);
			pepe.setApellidos("Pérez");
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}		
		
	}
	
	@Test
	public void getNombreApellidos() {
		try {
			pepe.getNombre();
			pepe.getApellidos();
			
		}catch(Exception e) {
			fail("No se esperaba excepción");
		}
	}

}
