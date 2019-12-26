/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas.exceptions;

/**
 * The Class CuentaYaCreadaException.
 */
public class CuentaYaCreadaException extends Exception {

    /**
     * Instantiates a new cuenta ya creada exception.
     */
    public CuentaYaCreadaException() {
        super("La cuenta está creada y no admite añadir titulares");
    }
}
