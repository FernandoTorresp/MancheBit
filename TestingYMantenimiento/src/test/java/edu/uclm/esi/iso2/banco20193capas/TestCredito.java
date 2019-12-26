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
import edu.uclm.esi.iso2.banco20193capas.exceptions.ImporteInvalidoException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.PinInvalidoException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.SaldoInsuficienteException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.TarjetaBloqueadaException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.TokenInvalidoException;
import edu.uclm.esi.iso2.banco20193capas.model.Cliente;
import edu.uclm.esi.iso2.banco20193capas.model.Tarjeta;
import edu.uclm.esi.iso2.banco20193capas.model.TarjetaCredito;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class TestCredito.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCredito extends TestCase {

    /** The pepe. */
    private Cliente pepe;

    /** The cuenta pepe. */
    private Cuenta cuentaPepe;

    /** The tc pepe. */
    private TarjetaCredito tcPepe;

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

        this.pepe = new Cliente("12345X", "Pepe", "Pérez");
        this.pepe.insert();
        this.cuentaPepe = new Cuenta(1);

        try {
            this.cuentaPepe.addTitular(pepe);
            this.cuentaPepe.insert();
            this.cuentaPepe.ingresar(1000);
            this.tcPepe =
                    this.cuentaPepe.emitirTarjetaCredito(pepe.getNif(), 50);
            this.tcPepe.cambiarPin(tcPepe.getPin(), 1234);
        }
        catch (Exception e) {
            fail("Excepción inesperada en setUp(): " + e);
        }
    }

    /**
     * Test sacar dinero todo OK.
     */
    @Test
    public void testSacarDineroTodoOK() {
        try {
            tcPepe.sacarDinero(1234, 10);
        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }
    }

    /**
     * Test creditomenor importe.
     */
    @Test
    public void testCreditomenorImporte() {
        try {
            tcPepe.comprar(1234, 60);
            fail("Esperaba SaldoInsuficienteException");
        }
        catch (SaldoInsuficienteException e) {
        }
        catch (Exception e) {
            fail("Excepción inesperada: " + e.getMessage());
        }
    }

    /**
     * Test fallo importe.
     */
    @Test
    public void testFalloImporte() {
        try {
            tcPepe.sacarDinero(1234, 0);
            fail("Esperaba ImporteInvalidoException");
        }
        catch (ImporteInvalidoException e) {
        }
        catch (Exception e) {
            fail("Excepción inesperada: " + e.getMessage());
        }
    }

    /**
     * Test token invalido.
     */
    @Test
    public void TestTokenInvalido() {
        try {
            int token = tcPepe.comprarPorInternet(1234, 50);
            tcPepe.confirmarCompraPorInternet(50);
            fail("Esperaba TokenInvalidoException");
        }
        catch (TokenInvalidoException e) {
        }
        catch (Exception e) {
            fail("Excepción inesperada");
        }
    }

    /**
     * Pin invalido.
     */
    @Test
    public void PinInvalido() {
        try {
            this.tcPepe.comprar(-3210, 50);
        }
        catch (PinInvalidoException e) {
        }
        catch (Exception e) {
            fail("Esperaba PinInvalidoException");
        }
    }

    /**
     * Test bloqueo de tarjeta.
     */
    @Test
    public void testBloqueoDeTarjeta() {
        try {
            this.tcPepe.comprarPorInternet(-3210, 50);
        }
        catch (PinInvalidoException e) {
        }
        catch (Exception e) {
            fail("Esperaba PinInvalidoException");
        }
        try {
            this.tcPepe.comprarPorInternet(-3210, 50);
        }
        catch (PinInvalidoException e) {
        }
        catch (Exception e) {
            fail("Esperaba PinInvalidoException");
        }
        try {
            this.tcPepe.comprarPorInternet(-3210, 50);
        }
        catch (PinInvalidoException e) {
        }
        catch (Exception e) {
            fail("Esperaba PinInvalidoException");
        }
        try {
            this.tcPepe.comprarPorInternet(-3210, 50);
        }
        catch (TarjetaBloqueadaException e) {
        }
        catch (Exception e) {
            fail("Esperaba TarjetaBloqueadaException");
        }
    }

}
