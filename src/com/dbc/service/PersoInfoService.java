package com.dbc.service;

import com.dbc.entities.Address;
import com.dbc.entities.PersoInfo;
import com.dbc.entities.User;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.PersoInfoRepository;

import java.sql.SQLException;
import java.util.List;

public class PersoInfoService {
    PersoInfoRepository persoInfoRepository = new PersoInfoRepository();

    public void addPersoInfo(PersoInfo persoInfo){
        try{
            PersoInfo newPersoInfo = persoInfoRepository.register(persoInfo);
            System.out.println("PersoInfo adicionado! " + newPersoInfo);
        } catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

    public void listPersoInfos(){
        try{
            List<PersoInfo> list = persoInfoRepository.listAll();
            list.forEach(System.out::println);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
