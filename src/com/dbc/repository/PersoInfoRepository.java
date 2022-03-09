package com.dbc.repository;

import com.dbc.model.PersoInfo;
import com.dbc.exceptions.BancoDeDadosException;

import java.sql.*;
import java.util.ArrayList;
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

            stmt.executeUpdate();
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
    public List<PersoInfo> list() throws BancoDeDadosException {
        List<PersoInfo> persoInfos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM PERSOINFO";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                PersoInfo persoInfo = new PersoInfo();
                persoInfo.setIdPersoInfo(res.getInt("ID_PERSOINFO"));
                persoInfo.setRealName(res.getString("REALNAME"));
                persoInfo.setAge(res.getInt("AGE"));
                persoInfo.setEmail(res.getString("EMAIL"));
                persoInfos.add(persoInfo);
            }
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
        return persoInfos;
    }

    @Override
    public boolean delete(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM PERSOINFO WHERE ID_PERSOINFO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerPersoInfoPorId.res=" + res);

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

    @Override
    public boolean edit(PersoInfo persoInfo, PersoInfo newPersoInfo) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "UPDATE PERSOINFO SET " +
                    " REALNAME = ?," +
                    " AGE = ?," +
                    " EMAIL = ? " +
                    " WHERE ID_PERSOINFO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, newPersoInfo.getRealName());
            stmt.setInt(2, newPersoInfo.getAge());
            stmt.setString(3,newPersoInfo.getEmail());
            stmt.setInt(4, persoInfo.getIdPersoInfo());

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarPessoa.res=" + res);

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