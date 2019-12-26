/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas.exceptions;

/**
 * The Class ImporteInvalidoException.
 */
public class ImporteInvalidoException extends Exception {

    /**
     * Instantiates a new importe invalido exception.
     *
     * @param importe
     *        the importe
     */
    public ImporteInvalidoException(double importe) {
        super("El importe " + importe + " no es válido para esta operación");
    }
}
