/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas.exceptions;

/**
 * The Class SaldoInsuficienteException.
 */
public class SaldoInsuficienteException extends Exception {

    /**
     * Instantiates a new saldo insuficiente exception.
     */
    public SaldoInsuficienteException() {
        super("Saldo insuficiente para el importe solicitado");
    }
}
