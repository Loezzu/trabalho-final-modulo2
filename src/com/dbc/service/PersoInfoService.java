package com.dbc.service;

import com.dbc.model.PersoInfo;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.PersoInfoRepository;

import java.sql.SQLException;
import java.util.List;

public class PersoInfoService {
    PersoInfoRepository persoInfoRepository = new PersoInfoRepository();

    public void addPersoInfo(PersoInfo persoInfo){
        try{
            PersoInfo newPersoInfo = persoInfoRepository.register(persoInfo);
        } catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

    public void listPersoInfos(){
        try{
            List<PersoInfo> list = persoInfoRepository.list();
            list.forEach(System.out::println);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removePersoInfoById(Integer id){
        try{
            boolean conseguiuRemover = persoInfoRepository.delete(id);
            System.out.println("Conseguiu remover: " + conseguiuRemover + " | ID: " + id);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void editarPersoInfo(PersoInfo persoInfo, PersoInfo newPersoInfo) {
        try{
            boolean conseguiuEditar = persoInfoRepository.edit(persoInfo, newPersoInfo);
            System.out.println("Editou: " + conseguiuEditar);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}