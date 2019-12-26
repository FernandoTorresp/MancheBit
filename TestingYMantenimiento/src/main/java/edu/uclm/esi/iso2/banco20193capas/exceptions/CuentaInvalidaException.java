/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas.exceptions;

/**
 * The Class CuentaInvalidaException.
 */
public class CuentaInvalidaException extends Exception {

    /**
     * Instantiates a new cuenta invalida exception.
     *
     * @param numero
     *        the numero
     */
    public CuentaInvalidaException(Long numero) {
        super("La cuenta " + numero + " no existe");
    }

}
