/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.uclm.esi.iso2.banco20193capas.model.Cliente;
import edu.uclm.esi.iso2.banco20193capas.model.Cuenta;

/**
 * The Class Lanzadora.
 */
@SpringBootApplication
public class Lanzadora {

    /**
     * The main method.
     *
     * @param args
     *        the arguments
     * @throws Exception
     *         the exception
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Lanzadora.class, args);

        try {
            Cliente pepe = new Cliente("12345X", "Pepe", "Pérez");
            pepe.insert();

            Cuenta cuenta = new Cuenta();
            cuenta.addTitular(pepe);
            cuenta.insert();

            cuenta.ingresar(1000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
