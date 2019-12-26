/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Class Cliente.
 */
@Entity
public class Cliente {

    /** The id. */
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO)
    private Long id;

    /** The nif. */
    @Column(
            unique = true)
    protected String nif;

    /** The nombre. */
    private String nombre;

    /** The apellidos. */
    private String apellidos;

    /**
     * Instantiates a new cliente.
     */
    public Cliente() {
    }

    /**
     * Crea un cliente.
     *
     * @param nif
     *        NIF del cliente
     * @param nombre
     *        Nombre del cliente
     * @param apellidos
     *        Apellidos del cliente
     */
    public Cliente(final String nif, final String nombre,
            final String apellidos) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
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
     * Gets the nif.
     *
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * Sets the nif.
     *
     * @param nif
     *        the new nif
     */
    public void setNif(final String nif) {
        this.nif = nif;
    }

    /**
     * Gets the nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre.
     *
     * @param nombre
     *        the new nombre
     */
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the apellidos.
     *
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Sets the apellidos.
     *
     * @param apellidos
     *        the new apellidos
     */
    public void setApellidos(final String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Inserta un cliente en la base de datos.
     */
    public void insert() {
        Manager.getClienteDAO().save(this);
    }
}
