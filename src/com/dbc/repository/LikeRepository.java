package com.dbc.repository;

import com.dbc.entities.Like;
import com.dbc.entities.User;
import com.dbc.exceptions.BancoDeDadosException;

import java.sql.*;

public class LikeRepository {

    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT SEQ_LIKE_TINDEV_USER.nextval mysequence FROM DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if(res.next()){
            return res.getInt("mysequence");
        }
        return null;
    }

    public Like register(Like like, User user, String username) throws BancoDeDadosException {
        Connection con = null;
        try{
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            like.setId_like(proximoId);

            String sql = "INSERT INTO LIKE_TINDEV_USER\n"
                    + "(ID_LIKE, USER_ID, USERNAME)\n"
                    + "VALUES (?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, like.getId_like());
            stmt.setInt(2, user.getUserId());
            stmt.setString(3, username);

            int res = stmt.executeUpdate();
            System.out.println("Adicionar user.res = " + res);
            return like;

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

}
