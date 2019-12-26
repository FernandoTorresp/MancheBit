/*
 * 
 */

package edu.uclm.esi.iso2.banco20193capas.dao;

import org.springframework.data.repository.CrudRepository;

import edu.uclm.esi.iso2.banco20193capas.model.Cuenta;

/**
 * Patrón DAO de la clase Cuenta.
 */
public interface CuentaDAO extends CrudRepository<Cuenta, Long> {

}
