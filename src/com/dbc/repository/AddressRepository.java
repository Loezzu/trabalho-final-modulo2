package com.dbc.repository;

import com.dbc.entities.Address;
import com.dbc.exceptions.BancoDeDadosException;

import java.sql.*;
import java.util.List;

public class AddressRepository implements Actions<Integer, Address>{

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT SEQ_ADDRESS.nextval mysequence FROM DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if(res.next()){
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public Address register(Address address) throws BancoDeDadosException {
        Connection con = null;
        try{
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            address.setIdAddress(proximoId);

            String sql = "INSERT INTO ADDRESS\n"
                    + "(ID_ADDRESS, STREET, CITY, HOUSE_NUMBER)\n"
                    + "VALUES (?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1,address.getIdAddress());
            stmt.setString(2,address.getStreet());
            stmt.setString(3,address.getCity());
            stmt.setInt(4,address.getNumber());

            int res = stmt.executeUpdate();
            System.out.println("Adicionar user.res = " + res);
            return address;

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
    public List<Address> listAll() throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean edit(Integer id, Address address) throws BancoDeDadosException {
        return false;
    }
}
