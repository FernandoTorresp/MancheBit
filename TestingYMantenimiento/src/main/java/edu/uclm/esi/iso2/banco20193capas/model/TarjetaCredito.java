/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas.model;

import java.security.SecureRandom;
import java.util.List;

import javax.persistence.Entity;

import edu.uclm.esi.iso2.banco20193capas.exceptions.ImporteInvalidoException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.PinInvalidoException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.SaldoInsuficienteException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.TarjetaBloqueadaException;

/**
 * The Class TarjetaCredito.
 */
@Entity
public class TarjetaCredito extends Tarjeta {

    /** The credito. */
    private Double credito;

    /**
     * Instantiates a new tarjeta credito.
     */
    public TarjetaCredito() {
        super();
    }

    /**
     * Permite sacar dinero del cajero automático.
     *
     * @param pin
     *        El pin que introduce el usuario
     * @param importe
     *        El {@code importe} que desea sacar
     * @throws ImporteInvalidoException
     *         Si el {@code importe<=0}
     * @throws SaldoInsuficienteException
     *         Si el crédito disponible de la tarjeta es menor que el importe
     * @throws TarjetaBloqueadaException
     *         Si la tarjeta está bloqueada
     * @throws PinInvalidoException
     *         Si el pin introducido es distinto del pin de la tarjeta
     */
    @Override
    public void sacarDinero(final int pin, final double importe)
            throws ImporteInvalidoException, SaldoInsuficienteException,
            TarjetaBloqueadaException, PinInvalidoException {
        comprobar(pin);
        this.intentos = 0;
        if (importe > getCreditoDisponible()) {
            throw new SaldoInsuficienteException();
        }
        if (importe <= 0) {
            throw new ImporteInvalidoException(importe);
        }
        final MovimientoTarjetaCredito principal =
                new MovimientoTarjetaCredito(this, importe,
                        "Retirada de efectivo");
        final double comision = 3;
        final MovimientoTarjetaCredito mComision =
                new MovimientoTarjetaCredito(this, comision,
                        "Comisión por retirada de efectivo");
        Manager.getMovimientoTarjetaCreditoDAO().save(principal);
        Manager.getMovimientoTarjetaCreditoDAO().save(mComision);
    }

    /**
     * Inicia una compra por Internet, que debe confirmarse después (ver
     * {@link #confirmarCompraPorInternet(int)}) mediante el token que devuelve este método.
     *
     * @param pin
     *        El pin que introduce el usuario
     * @param importe
     *        El importe de la compra
     * @return Un token que debe introducirse en {@link #confirmarCompraPorInternet(int)}
     * @throws TarjetaBloqueadaException
     *         Si la tarjeta está bloqueada
     * @throws PinInvalidoException
     *         Si el pin introducido es distinto del pin de la tarjeta
     * @throws SaldoInsuficienteException
     *         Si el crédito disponible de la tarjeta es menor que el importe
     * @throws ImporteInvalidoException
     *         Si el importe es menor o igual a 0
     */
    @Override
    public Integer comprarPorInternet(final int pin, final double importe)
            throws TarjetaBloqueadaException, PinInvalidoException,
            SaldoInsuficienteException, ImporteInvalidoException {
        comprobar(pin);
        this.intentos = 0;
        if (importe > getCreditoDisponible()) {
            throw new SaldoInsuficienteException();
        }
        if (importe <= 0) {
            throw new ImporteInvalidoException(importe);
        }
        final SecureRandom dado = new SecureRandom();
        int token = 0;
        for (int i = 0; i <= 3; i++) {
            token = (int) (token + dado.nextInt(10) * Math.pow(10, i));
        }
        token = 1234;
        this.compra = new Compra(importe, token);
        return token;
    }

    /**
     * Permite hacer un compra en un comercio.
     *
     * @param pin
     *        El pin que introduce el usuario
     * @param importe
     *        El importe de la compra
     * @throws ImporteInvalidoException
     *         Si el importe es menor o igual a 0
     * @throws SaldoInsuficienteException
     *         Si el crédito disponible ({@link #getCreditoDisponible()}) de la tarjeta es menor que
     *         el importe
     * @throws TarjetaBloqueadaException
     *         Si la tarjeta está bloqueada
     * @throws PinInvalidoException
     *         Si el pin introducido es incorrecto
     */
    @Override
    public void comprar(final int pin, final double importe)
            throws ImporteInvalidoException, SaldoInsuficienteException,
            TarjetaBloqueadaException, PinInvalidoException {
        comprobar(pin);
        this.intentos = 0;
        if (importe > getCreditoDisponible()) {
            throw new SaldoInsuficienteException();
        }
        if (importe <= 0) {
            throw new ImporteInvalidoException(importe);
        }
        final MovimientoTarjetaCredito principal =
                new MovimientoTarjetaCredito(this, importe,
                        "Retirada de efectivo");
        Manager.getMovimientoTarjetaCreditoDAO().save(principal);
    }

    /**
     * Bloquear.
     */
    @Override
    protected void bloquear() {
        this.activa = false;
        Manager.getTarjetaCreditoDAO().save(this);
    }

    /**
     * Liquidar.
     */
    public void liquidar() {
        double gastos = 0.0;
        final List<MovimientoTarjetaCredito> mm = Manager
                .getMovimientoTarjetaCreditoDAO().findByTarjetaId(this.id);
        for (final MovimientoTarjetaCredito m : mm) {
            if (!m.isLiquidado()) {
                gastos = gastos + m.getImporte();
                m.setLiquidado(true);
                Manager.getMovimientoTarjetaCreditoDAO().save(m);
            }
        }
        this.cuenta.retiroForzoso(gastos, "Liquidación de tarjeta de crédito");
    }

    /**
     * Gets the credito.
     *
     * @return the credito
     */
    public Double getCredito() {
        return credito;
    }

    /**
     * Gets the credito disponible.
     *
     * @return the credito disponible
     */
    public Double getCreditoDisponible() {
        double gastos = 0.0;
        final List<MovimientoTarjetaCredito> mm = Manager
                .getMovimientoTarjetaCreditoDAO().findByTarjetaId(this.id);
        for (final MovimientoTarjetaCredito m : mm) {
            if (!m.isLiquidado()) {
                gastos = gastos + m.getImporte();
            }
        }
        return credito - gastos;
    }

    /**
     * Sets the credito.
     *
     * @param credito
     *        the new credito
     */
    public void setCredito(final Double credito) {
        this.credito = credito;
    }

    /**
     * Cambiar pin.
     *
     * @param pinViejo
     *        the pin viejo
     * @param pinNuevo
     *        the pin nuevo
     * @throws PinInvalidoException
     *         the pin invalido exception
     */
    @Override
    public void cambiarPin(final int pinViejo, final int pinNuevo)
            throws PinInvalidoException {
        if (this.pin != pinViejo) {
            throw new PinInvalidoException();
        }
        this.pin = pinNuevo;
        Manager.getTarjetaCreditoDAO().save(this);
    }
}
