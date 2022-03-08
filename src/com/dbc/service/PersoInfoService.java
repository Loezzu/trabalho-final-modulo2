package com.dbc.service;

import com.dbc.entities.PersoInfo;
import com.dbc.entities.User;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.PersoInfoRepository;

public class PersoInfoService {
    PersoInfoRepository persoInfoRepository = new PersoInfoRepository();

    public void addPersoInfo(PersoInfo persoInfo){
        try{
            PersoInfo newPersoInfo = persoInfoRepository.register(persoInfo);
            System.out.println("User adicionado! " + persoInfo);
        } catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

}
