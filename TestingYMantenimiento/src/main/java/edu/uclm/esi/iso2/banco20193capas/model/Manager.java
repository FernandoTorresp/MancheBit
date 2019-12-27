/*
 *
 */

package edu.uclm.esi.iso2.banco20193capas.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uclm.esi.iso2.banco20193capas.dao.ClienteDAO;
import edu.uclm.esi.iso2.banco20193capas.dao.CuentaDAO;
import edu.uclm.esi.iso2.banco20193capas.dao.MovimientoCuentaDAO;
import edu.uclm.esi.iso2.banco20193capas.dao.MovimientoTarjetaCreditoDAO;
import edu.uclm.esi.iso2.banco20193capas.dao.TarjetaCreditoDAO;
import edu.uclm.esi.iso2.banco20193capas.dao.TarjetaDebitoDAO;

/**
 * El Manager da acceso a las clases DAO asociadas a las clases de dominio.
 */
@Component
public class Manager {

    /** The cuenta DAO. */
    private static CuentaDAO cuentaDAO;

    /** The movimiento DAO. */
    private static MovimientoCuentaDAO movimientoDAO;

    /** The movimiento tarjeta credito DAO. */
    private static MovimientoTarjetaCreditoDAO movimientoTarjetaCreditoDAO;

    /** The cliente DAO. */
    private static ClienteDAO clienteDAO;

    /** The tarjeta debito DAO. */
    private static TarjetaDebitoDAO tarjetaDebitoDAO;

    /** The tarjeta credito DAO. */
    private static TarjetaCreditoDAO tarjetaCreditoDAO;

    /**
     * Instantiates a new manager.
     */
    private Manager() {
    }

    /**
     * Load DAO.
     *
     * @param cuentaDao
     *        the cuenta dao
     * @param movimientoDao
     *        the movimiento dao
     * @param clienteDAO
     *        the cliente DAO
     * @param movimientoTCDAO
     *        the movimiento TCDAO
     * @param tarjetaDebitoDAO
     *        the tarjeta debito DAO
     * @param tarjetaCreditoDAO
     *        the tarjeta credito DAO
     */
    @Autowired
    private void loadDAO(final CuentaDAO cuentaDao,
            final MovimientoCuentaDAO movimientoDao,
            final ClienteDAO clienteDAO,
            final MovimientoTarjetaCreditoDAO movimientoTCDAO,
            final TarjetaDebitoDAO tarjetaDebitoDAO,
            final TarjetaCreditoDAO tarjetaCreditoDAO) {
        Manager.cuentaDAO = cuentaDao;
        Manager.movimientoDAO = movimientoDao;
        Manager.clienteDAO = clienteDAO;
        Manager.movimientoTarjetaCreditoDAO = movimientoTCDAO;
        Manager.tarjetaDebitoDAO = tarjetaDebitoDAO;
        Manager.tarjetaCreditoDAO = tarjetaCreditoDAO;
    }

    /**
     * Gets the cuenta DAO.
     *
     * @return the cuenta DAO
     */
    public static CuentaDAO getCuentaDAO() {
        return cuentaDAO;
    }

    /**
     * Gets the movimiento DAO.
     *
     * @return the movimiento DAO
     */
    public static MovimientoCuentaDAO getMovimientoDAO() {
        return movimientoDAO;
    }

    /**
     * Gets the cliente DAO.
     *
     * @return the cliente DAO
     */
    public static ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    /**
     * Gets the movimiento tarjeta credito DAO.
     *
     * @return the movimiento tarjeta credito DAO
     */
    public static MovimientoTarjetaCreditoDAO
            getMovimientoTarjetaCreditoDAO() {
        return movimientoTarjetaCreditoDAO;
    }

    /**
     * Gets the tarjeta debito DAO.
     *
     * @return the tarjeta debito DAO
     */
    public static TarjetaDebitoDAO getTarjetaDebitoDAO() {
        return tarjetaDebitoDAO;
    }

    /**
     * Gets the tarjeta credito DAO.
     *
     * @return the tarjeta credito DAO
     */
    public static TarjetaCreditoDAO getTarjetaCreditoDAO() {
        return tarjetaCreditoDAO;
    }
}
