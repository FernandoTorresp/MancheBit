/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas.model;

/**
 * The Class Compra.
 */
public class Compra {

    /** The importe. */
    private double importe;

    /** The token. */
    private int token;

    /**
     * Instantiates a new compra.
     *
     * @param importe
     *        the importe
     * @param token
     *        the token
     */
    public Compra(double importe, int token) {
        this.importe = importe;
        this.token = token;
    }

    /**
     * Gets the importe.
     *
     * @return the importe
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Sets the importe.
     *
     * @param importe
     *        the new importe
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }

    /**
     * Gets the token.
     *
     * @return the token
     */
    public int getToken() {
        return token;
    }

    /**
     * Sets the token.
     *
     * @param token
     *        the new token
     */
    public void setToken(int token) {
        this.token = token;
    }

}
