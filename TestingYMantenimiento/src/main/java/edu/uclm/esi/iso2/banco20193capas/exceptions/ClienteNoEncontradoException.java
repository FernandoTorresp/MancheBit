/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas.exceptions;

/**
 * The Class ClienteNoEncontradoException.
 */
public class ClienteNoEncontradoException extends Exception {

    /**
     * Instantiates a new cliente no encontrado exception.
     *
     * @param nif
     *        the nif
     */
    public ClienteNoEncontradoException(String nif) {
        super("No se encuentra el cliente con NIF " + nif);
    }
}
