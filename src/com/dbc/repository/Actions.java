package com.dbc.repository;


import com.dbc.exceptions.BancoDeDadosException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Actions<CHAVE, OBJETO> {

        Integer getProximoId(Connection connection) throws SQLException;
        OBJETO register(OBJETO object) throws BancoDeDadosException;
        List<OBJETO> listAll() throws BancoDeDadosException;
        boolean delete(CHAVE id) throws BancoDeDadosException;
        boolean edit(CHAVE id, OBJETO objeto) throws BancoDeDadosException;

}
