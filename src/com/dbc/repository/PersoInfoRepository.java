package com.dbc.repository;

import com.dbc.entities.PersoInfo;
import com.dbc.exceptions.BancoDeDadosException;

import java.sql.*;
import java.util.List;

public class PersoInfoRepository implements Actions<Integer, PersoInfo>{

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT SEQ_PERSOINFO.nextval mysequence FROM DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if(res.next()){
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public PersoInfo register(PersoInfo persoInfo) throws BancoDeDadosException {
        Connection con = null;
        try{
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            persoInfo.setIdPersoInfo(proximoId);

            String sql = "INSERT INTO PERSOINFO\n"
                    + "(ID_PERSOINFO, REALNAME, AGE, EMAIL)\n"
                    + "VALUES (?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1,persoInfo.getIdPersoInfo());
            stmt.setString(2,persoInfo.getRealName());
            stmt.setInt(3,persoInfo.getAge());
            stmt.setString(4,persoInfo.getEmail());

            int res = stmt.executeUpdate();
            System.out.println("Adicionar user.res = " + res);
            return persoInfo;

        }catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<PersoInfo> listAll() throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean edit(Integer id, PersoInfo persoInfo) throws BancoDeDadosException {
        return false;
    }
}
