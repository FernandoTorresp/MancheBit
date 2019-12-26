/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.uclm.esi.iso2.banco20193capas.model.Cliente;
import edu.uclm.esi.iso2.banco20193capas.model.Manager;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class TestCliente.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCliente extends TestCase {

    /** The pepe. */
    private Cliente pepe;

    /** The id 1. */
    private Long id1 = -9223372036854775808l;

    /** The id 2. */
    private Long id2 = -90000l;

    /** The id 3. */
    private Long id3 = 0l;

    /** The id 4. */
    private Long id4 = 123456l;

    /** The id 5. */
    private Long id5 = 9223372036854775807l;

    /**
     * Sets the up.
     */
    @Override
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
    }

    /**
     * Test set cliente pair wise 1.
     */
    @Test
    public void testSetClientePairWise1() {
        try {

            pepe.setId(id1);
            pepe.setNif("01111111A");

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }
        try {

            pepe.setId(id2);
            pepe.setNif("01111111A");

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }
        try {

            pepe.setId(id3);
            pepe.setNif("01111111A");

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }
        try {

            pepe.setId(id4);
            pepe.setNif("01111111A");

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }
        try {

            pepe.setId(id5);
            pepe.setNif("01111111A");

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }

    }

    /**
     * Test set cliente pair wise 2.
     */
    @Test
    public void testSetClientePairWise2() {
        try {

            pepe.setId(id1);
            pepe.setNombre("José");

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }
        try {

            pepe.setId(id2);
            pepe.setNombre("José");

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }
        try {

            pepe.setId(id3);
            pepe.setNombre("José");

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }
        try {

            pepe.setId(id4);
            pepe.setNombre("José");

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }
        try {

            pepe.setId(id5);
            pepe.setNombre("José");

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }

    }

    /**
     * Test set cliente pair wise 3.
     */
    @Test
    public void testSetClientePairWise3() {
        try {

            pepe.setId(id1);
            pepe.setApellidos("Pérez");

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }
        try {

            pepe.setId(id2);
            pepe.setApellidos("Pérez");

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }
        try {

            pepe.setId(id3);
            pepe.setApellidos("Pérez");

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }
        try {

            pepe.setId(id4);
            pepe.setApellidos("Pérez");

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }
        try {

            pepe.setId(id5);
            pepe.setApellidos("Pérez");

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }

    }

    /**
     * Gets the nombre apellidos.
     */
    @Test
    public void getNombreApellidos() {
        try {
            pepe.getNombre();
            pepe.getApellidos();

        }
        catch (Exception e) {
            fail("No se esperaba excepción");
        }
    }

}
