/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas.exceptions;

/**
 * The Class CuentaSinTitularesException.
 */
public class CuentaSinTitularesException extends Exception {

    /**
     * Instantiates a new cuenta sin titulares exception.
     */
    public CuentaSinTitularesException() {
        super("Falta indicar el titular o titulares");
    }
}
