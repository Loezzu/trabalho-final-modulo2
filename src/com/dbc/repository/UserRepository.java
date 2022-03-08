package com.dbc.repository;


import com.dbc.entities.User;
import com.dbc.enums.Gender;
import com.dbc.enums.Pref;
import com.dbc.enums.ProgLangs;
import com.dbc.exceptions.BancoDeDadosException;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class UserRepository implements Actions<Integer, User> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT SEQ_TINDEV_USER.nextval mysequence FROM DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if(res.next()){
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public User register(User user) throws BancoDeDadosException {
        Connection con = null;
        try{
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            user.setUserId(proximoId);

            String sql = "INSERT INTO TINDEV_USER\n"
            + "(USER_ID, USER_TYPE, USERNAME, PASSWORD, PERSOINFO_ID_PERSOINFO, ADDRESS_ID_ADDRESS, PROGLANGS, GENDER, PREF, WHATSAPP)\n"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1,user.getUserId());
            stmt.setInt(2,user.getUserType());
            stmt.setString(3,user.getUsername());
            stmt.setString(4,user.getPassword());
            stmt.setInt(5,user.getPersoInfo().getIdPersoInfo());
            stmt.setInt(6,user.getAddress().getIdAddress());
            stmt.setString(7, user.getProgLangs().toString());
            stmt.setString(8, user.getGender().toString());
            stmt.setString(9, user.getPref().toString());
            stmt.setString(10, user.getWhats());

            int res = stmt.executeUpdate();
            System.out.println("Adicionar user.res = " + res);
            return user;

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
    public List listAll() throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean edit(Integer id, User user) throws BancoDeDadosException {
        return false;
    }
}
