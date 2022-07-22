/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.pojo.Visitasweb;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ricardo.barrientos
 */
public interface visitasDao {

    public void saveVisita(Visitasweb visita);
    public List<Visitasweb> showAllVisitas();
    public Visitasweb showVisita(BigInteger id);
    public void updateVisita (BigInteger id, String usuario, BigInteger idpantalla, Date fecha);
    public void deleteVisita(Visitasweb visita);

}
