package com.dbc.repository;

import com.dbc.model.Like;
import com.dbc.model.User;
import com.dbc.exceptions.BancoDeDadosException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Like> getLikes(Integer id_user) throws BancoDeDadosException {
        Connection con = null;
        try{
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT * FROM LIKE_TINDEV_USER WHERE USER_ID = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id_user);

            ResultSet res = stmt.executeQuery();

            List<Like> likes = new ArrayList<>();

            while(res.next()){
                Like like = new Like();
                User user = new User();
                like.setId_like(res.getInt("ID_LIKE"));
                user.setUserId(res.getInt("USER_ID"));
                user.setUsername(res.getString("USERNAME"));
                like.setUser_id(user.getUserId());
                like.setUsername(user.getUsername());
                likes.add(like);
            }

            return likes;

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


    public boolean delete(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM LIKE_TINDEV_USER WHERE ID_LIKE = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerLikePorId.res=" + res);

            return res > 0;
        } catch (SQLException e) {
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
