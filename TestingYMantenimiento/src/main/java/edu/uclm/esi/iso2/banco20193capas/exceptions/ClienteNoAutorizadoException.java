/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas.exceptions;

/**
 * The Class ClienteNoAutorizadoException.
 */
public class ClienteNoAutorizadoException extends Exception {

    /**
     * Instantiates a new cliente no autorizado exception.
     *
     * @param nif
     *        the nif
     * @param id
     *        the id
     */
    public ClienteNoAutorizadoException(final String nif, final Long id) {
        super("El cliente con NIF " + nif
                + " no está autorizado para operar en la cuenta " + id);
    }
}
