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
 * Representa un movimiento asociado a una tarjeta de crédito.
 */
@Entity
public class MovimientoTarjetaCredito {

    /** The id. */
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO)
    private Long id;

    /** The tarjeta. */
    @ManyToOne
    private TarjetaCredito tarjeta;

    /** The importe. */
    private double importe;

    /** The concepto. */
    private String concepto;

    /** The liquidado. */
    private boolean liquidado;

    /**
     * Instantiates a new movimiento tarjeta credito.
     */
    public MovimientoTarjetaCredito() {
    }

    /**
     * Instantiates a new movimiento tarjeta credito.
     *
     * @param tarjeta
     *        the tarjeta
     * @param importe
     *        the importe
     * @param concepto
     *        the concepto
     */
    public MovimientoTarjetaCredito(TarjetaCredito tarjeta, double importe,
            String concepto) {
        this.importe = importe;
        this.concepto = concepto;
        this.tarjeta = tarjeta;
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
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the tarjeta.
     *
     * @return the tarjeta
     */
    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    /**
     * Sets the tarjeta.
     *
     * @param tarjeta
     *        the new tarjeta
     */
    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
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
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * Checks if is liquidado.
     *
     * @return true, if is liquidado
     */
    public boolean isLiquidado() {
        return liquidado;
    }

    /**
     * Sets the liquidado.
     *
     * @param liquidado
     *        the new liquidado
     */
    public void setLiquidado(boolean liquidado) {
        this.liquidado = liquidado;
    }

}
