package com.dbc.repository;


import com.dbc.exceptions.BancoDeDadosException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Actions<KEY, OBJECT> {

        Integer getProximoId(Connection connection) throws SQLException;
        OBJECT register(OBJECT object) throws BancoDeDadosException;
        List<OBJECT> list() throws BancoDeDadosException;
        boolean edit(KEY id, OBJECT OBJECT) throws BancoDeDadosException;
        boolean delete(KEY id) throws BancoDeDadosException;

}