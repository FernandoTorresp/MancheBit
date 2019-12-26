/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas.model;

import java.security.SecureRandom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import edu.uclm.esi.iso2.banco20193capas.exceptions.ImporteInvalidoException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.PinInvalidoException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.SaldoInsuficienteException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.TarjetaBloqueadaException;
import edu.uclm.esi.iso2.banco20193capas.exceptions.TokenInvalidoException;

/**
 * Representa una tarjeta bancaria, bien de débito o bien de crédito. Una Tarjeta está asociada a un
 * Cliente y a una Cuenta.
 *
 */
@Entity
@Inheritance(
        strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Tarjeta {

    /** The id. */
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO)
    protected Long id;

    /** The pin. */
    protected Integer pin;

    /** The activa. */
    protected Boolean activa;

    /** The intentos. */
    protected Integer intentos;

    /** The compra. */
    @Transient
    protected Compra compra;

    /** The titular. */
    @ManyToOne
    protected Cliente titular;

    /** The cuenta. */
    @ManyToOne
    protected Cuenta cuenta;

    /**
     * Instantiates a new tarjeta.
     */
    public Tarjeta() {
        activa = true;
        this.intentos = 0;
        final SecureRandom dado = new SecureRandom();
        pin = 0;
        for (int i = 0; i <= 3; i++) {
            pin = (int) (pin + dado.nextInt(10) * Math.pow(10, i));
        }
    }

    /**
     * Comprobar.
     *
     * @param pin
     *        the pin
     * @throws TarjetaBloqueadaException
     *         the tarjeta bloqueada exception
     * @throws PinInvalidoException
     *         the pin invalido exception
     */
    protected void comprobar(final int pin)
            throws TarjetaBloqueadaException, PinInvalidoException {
        if (!this.isActiva()) {
            throw new TarjetaBloqueadaException();
        }
        if (this.pin != pin) {
            this.intentos++;
            if (intentos == 3) {
                bloquear();
            }
            throw new PinInvalidoException();
        }
    }

    /**
     * Permite confirmar una compra que se ha iniciado por Internet. El método
     * {@link #comprarPorInternet(int, double)} devuelve un token que debe ser introducido en este
     * método.
     *
     * @param token
     *        El token que introduce el usuario. Para que la compra se confirme, ha de coincidir con
     *        el token devuelto por {@link #comprarPorInternet(int, double)}
     * @throws TokenInvalidoException
     *         Si el {@code token} introducido es distinto del recibido desde
     *         {@link #comprarPorInternet(int, double)}
     * @throws ImporteInvalidoException
     *         Si el importe es menor o igual a 0
     * @throws SaldoInsuficienteException
     *         Si el saldo de la cuenta asociada a la tarjeta (en el caso de {@link TarjetaDebito})
     *         es menor que el importe, o si el crédito disponible en la tarjeta de crédito es menor
     *         que el importe
     * @throws TarjetaBloqueadaException
     *         Si la tarjeta está bloqueada
     * @throws PinInvalidoException
     *         Si el pin que se introdujo es inválido
     */
    public void confirmarCompraPorInternet(final int token)
            throws TokenInvalidoException, ImporteInvalidoException,
            SaldoInsuficienteException, TarjetaBloqueadaException,
            PinInvalidoException {
        if (token != this.compra.getToken()) {
            this.compra = null;
            throw new TokenInvalidoException();
        }
        this.comprar(this.pin, this.compra.getImporte());
    }

    /**
     * Bloquear.
     */
    protected abstract void bloquear();

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
     * Gets the pin.
     *
     * @return the pin
     */
    public Integer getPin() {
        return pin;
    }

    /**
     * Sets the pin.
     *
     * @param pin
     *        the new pin
     */
    public void setPin(final Integer pin) {
        this.pin = pin;
    }

    /**
     * Gets the titular.
     *
     * @return the titular
     */
    public Cliente getTitular() {
        return titular;
    }

    /**
     * Sets the titular.
     *
     * @param titular
     *        the new titular
     */
    public void setTitular(final Cliente titular) {
        this.titular = titular;
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
     * Checks if is activa.
     *
     * @return true si la tarjeta está activa; false si está bloqueada
     */
    public Boolean isActiva() {
        return activa;
    }

    /**
     * Sets the activa.
     *
     * @param activa
     *        the new activa
     */
    public void setActiva(final Boolean activa) {
        this.activa = activa;
    }

    /**
     * Sacar dinero.
     *
     * @param pin
     *        the pin
     * @param importe
     *        the importe
     * @throws ImporteInvalidoException
     *         the importe invalido exception
     * @throws SaldoInsuficienteException
     *         the saldo insuficiente exception
     * @throws TarjetaBloqueadaException
     *         the tarjeta bloqueada exception
     * @throws PinInvalidoException
     *         the pin invalido exception
     */
    public abstract void sacarDinero(int pin, double importe)
            throws ImporteInvalidoException, SaldoInsuficienteException,
            TarjetaBloqueadaException, PinInvalidoException;

    /**
     * Comprar por internet.
     *
     * @param pin
     *        the pin
     * @param importe
     *        the importe
     * @return the integer
     * @throws TarjetaBloqueadaException
     *         the tarjeta bloqueada exception
     * @throws PinInvalidoException
     *         the pin invalido exception
     * @throws SaldoInsuficienteException
     *         the saldo insuficiente exception
     * @throws ImporteInvalidoException
     *         the importe invalido exception
     */
    public abstract Integer comprarPorInternet(int pin, double importe)
            throws TarjetaBloqueadaException, PinInvalidoException,
            SaldoInsuficienteException, ImporteInvalidoException;

    /**
     * Comprar.
     *
     * @param pin
     *        the pin
     * @param importe
     *        the importe
     * @throws ImporteInvalidoException
     *         the importe invalido exception
     * @throws SaldoInsuficienteException
     *         the saldo insuficiente exception
     * @throws TarjetaBloqueadaException
     *         the tarjeta bloqueada exception
     * @throws PinInvalidoException
     *         the pin invalido exception
     */
    public abstract void comprar(int pin, double importe)
            throws ImporteInvalidoException, SaldoInsuficienteException,
            TarjetaBloqueadaException, PinInvalidoException;

    /**
     * Permite cambiar el pin de la tarjeta.
     *
     * @param pinViejo
     *        El pin actual
     * @param pinNuevo
     *        El pin nuevo (el que desea establecer el usuario)
     * @throws PinInvalidoException
     *         Si el {@code pinViejo} es incorrecto
     */
    public abstract void cambiarPin(int pinViejo, int pinNuevo)
            throws PinInvalidoException;
}
