/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Representa un movimiento en una cuenta bancaria.
 */
@Entity
public class MovimientoCuenta {

    /** The id. */
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO)
    private Long id;

    /** The cuenta. */
    @ManyToOne
    private Cuenta cuenta;

    /** The importe. */
    private double importe;

    /** The concepto. */
    private String concepto;

    /**
     * Instantiates a new movimiento cuenta.
     */
    public MovimientoCuenta() {
    }

    /**
     * Instantiates a new movimiento cuenta.
     *
     * @param cuenta
     *        the cuenta
     * @param importe
     *        the importe
     * @param concepto
     *        the concepto
     */
    public MovimientoCuenta(final Cuenta cuenta, final double importe,
            final String concepto) {
        this.importe = importe;
        this.concepto = concepto;
        this.cuenta = cuenta;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *        the new id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets the cuenta.
     *
     * @return the cuenta
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * Sets the cuenta.
     *
     * @param cuenta
     *        the new cuenta
     */
    public void setCuenta(final Cuenta cuenta) {
        this.cuenta = cuenta;
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
    public void setImporte(final double importe) {
        this.importe = importe;
    }

    /**
     * Gets the concepto.
     *
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Sets the concepto.
     *
     * @param concepto
     *        the new concepto
     */
    public void setConcepto(final String concepto) {
        this.concepto = concepto;
    }
}
