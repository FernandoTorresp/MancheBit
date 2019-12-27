/*
 * 
 */

package edu.uclm.esi.iso2.banco20193capas;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.uclm.esi.iso2.banco20193capas.model.Cuenta;
import edu.uclm.esi.iso2.banco20193capas.model.Manager;
import edu.uclm.esi.iso2.banco20193capas.exceptions.ClienteNoAutorizadoException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.ClienteNoEncontradoException;
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

// TODO: Auto-generated Javadoc
/**
 * The Class TestCuentaN.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCuentaN extends TestCase {

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        Manager.getMovimientoDAO().deleteAll();
        Manager.getMovimientoTarjetaCreditoDAO().deleteAll();
        Manager.getTarjetaCreditoDAO().deleteAll();
        Manager.getTarjetaDebitoDAO().deleteAll();
        Manager.getCuentaDAO().deleteAll();
        Manager.getClienteDAO().deleteAll();
    }

    /**
     * Test cliente inexistente.
     */
    @Test
    public void testClienteInexistente() {
        Cliente pepe = new Cliente("12345X", "Pepe", "Pérez");
        pepe.insert();

        Cuenta cuentaPepe = new Cuenta(1);
        TarjetaCredito tarjeta = new TarjetaCredito();
        try {
            cuentaPepe.addTitular(pepe);
            cuentaPepe.insert();
            tarjeta = cuentaPepe.emitirTarjetaCredito("12340X", 232);
            fail("Esperaba CuentaInvalidaException");
        }
        catch (ClienteNoEncontradoException e) {
        }
        catch (Exception e) {
            fail("Se ha lanzado una excepción inesperada: " + e);
        }
    }

    /**
     * Test cliente inexistente 2.
     */
    @Test
    public void testClienteInexistente2() {
        Cliente pepe = new Cliente("12345X", "Pepe", "Pérez");
        pepe.insert();

        Cuenta cuentaPepe = new Cuenta(1);
        TarjetaCredito tarjeta = new TarjetaCredito();
        try {
            cuentaPepe.addTitular(pepe);
            cuentaPepe.insert();
            tarjeta = cuentaPepe.emitirTarjetaCredito("12340X", 0);
            fail("Esperaba CuentaInvalidaException");
        }
        catch (ClienteNoEncontradoException e) {
        }
        catch (Exception e) {
            fail("Se ha lanzado una excepción inesperada: " + e);
        }
    }

    /**
     * Test cliente no autorizado.
     */
    @Test
    public void testClienteNoAutorizado() {
        Cliente pepe = new Cliente("12345X", "Pepe", "Pérez");
        Cliente ana = new Cliente("12340X", "Ana", "Gómez");
        pepe.insert();
        ana.insert();

        Cuenta cuentaPepe = new Cuenta(1);
        TarjetaCredito tarjeta = new TarjetaCredito();
        try {
            cuentaPepe.addTitular(pepe);
            cuentaPepe.insert();
            tarjeta = cuentaPepe.emitirTarjetaCredito("12340X", 232);
            fail("Esperaba CuentaNoAutorizadaException");
        }
        catch (ClienteNoAutorizadoException e) {
        }
        catch (Exception e) {
            System.out.println(e);
            fail("Se ha lanzado una excepción inesperada: " + e);
        }
    }

    /**
     * Test cliente no autorizado 2.
     */
    @Test
    public void testClienteNoAutorizado2() {
        Cliente pepe = new Cliente("12345X", "Pepe", "Pérez");
        Cliente ana = new Cliente("12340X", "Ana", "Gómez");
        pepe.insert();
        ana.insert();

        Cuenta cuentaPepe = new Cuenta(1);
        TarjetaCredito tarjeta = new TarjetaCredito();
        try {
            cuentaPepe.addTitular(pepe);
            cuentaPepe.insert();
            tarjeta = cuentaPepe.emitirTarjetaCredito("12340X", 0);
            fail("Esperaba CuentaNoAutorizadaException");
        }
        catch (ClienteNoAutorizadoException e) {
        }
        catch (Exception e) {
            System.out.println(e);
            fail("Se ha lanzado una excepción inesperada: " + e);
        }
    }

    /**
     * Test cliente no autorizado 3.
     */
    @Test
    public void testClienteNoAutorizado3() {
        Cliente pepe = new Cliente("12345X", "Pepe", "Pérez");
        Cliente ana = new Cliente("12340X", "Ana", "Gómez");
        pepe.insert();
        ana.insert();

        Cuenta cuentaPepe = new Cuenta(1);
        TarjetaCredito tarjeta = new TarjetaCredito();
        try {
            cuentaPepe.addTitular(pepe);
            cuentaPepe.insert();
            tarjeta = cuentaPepe.emitirTarjetaCredito("12348X", 232);
            fail("Esperaba CuentaNoAutorizadaException");
        }
        catch (ClienteNoEncontradoException e) {
        }
        catch (Exception e) {
            System.out.println(e);
            fail("Se ha lanzado una excepción inesperada: " + e);
        }
    }

    /**
     * Test cliente no autorizado 4.
     */
    @Test
    public void testClienteNoAutorizado4() {
        Cliente pepe = new Cliente("12345X", "Pepe", "Pérez");
        Cliente ana = new Cliente("12340X", "Ana", "Gómez");
        pepe.insert();
        ana.insert();

        Cuenta cuentaPepe = new Cuenta(1);
        TarjetaCredito tarjeta = new TarjetaCredito();
        try {
            cuentaPepe.addTitular(pepe);
            cuentaPepe.insert();
            tarjeta = cuentaPepe.emitirTarjetaCredito("12348X", 0);
            fail("Esperaba CuentaNoAutorizadaException");
        }
        catch (ClienteNoEncontradoException e) {
        }
        catch (Exception e) {
            System.out.println(e);
            fail("Se ha lanzado una excepción inesperada: " + e);
        }
    }
}
