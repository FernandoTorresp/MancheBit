/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas.exceptions;

/**
 * The Class TarjetaBloqueadaException.
 */
public class TarjetaBloqueadaException extends Exception {

    /**
     * Instantiates a new tarjeta bloqueada exception.
     */
    public TarjetaBloqueadaException() {
        super("La tarjeta está bloqueada");
    }
}
