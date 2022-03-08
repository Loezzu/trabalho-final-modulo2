package com.dbc;

import com.dbc.entities.Address;
import com.dbc.entities.PersoInfo;
import com.dbc.entities.User;
import com.dbc.enums.Gender;
import com.dbc.enums.Pref;
import com.dbc.enums.ProgLangs;
import com.dbc.service.AddressService;
import com.dbc.service.PersoInfoService;
import com.dbc.service.UserService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserService userService = new UserService();
        AddressService addressService = new AddressService();
        PersoInfoService persoInfoService = new PersoInfoService();

        User user = new User();
        Address address = new Address();
        PersoInfo persoInfo = new PersoInfo();

        userService.listUsers();
        userService.removeUserById(2);
        persoInfoService.removePersoInfoById(2);
        addressService.removeAddressById(2);

        userService.listUsers();
        persoInfoService.listPersoInfos();
        addressService.listAddress();




//        //Criando e adicionando endereço
//        System.out.println("Digite seu endereço: ");
//        System.out.println("Rua: ");
//        String rua = sc.nextLine();
//        address.setStreet(rua);
//        System.out.println("Cidade: ");
//        String cidade = sc.nextLine();
//        address.setCity(cidade);
//        System.out.println("Numero da casa: ");
//        Integer numero = sc.nextInt();
//        sc.nextLine();
//        address.setNumber(numero);
//        addressService.addAddress(address);
//
//        //Criando e adicionando info do usuario
//        System.out.println("Digite seu nome verdadeiro: ");
//        String nome = sc.next();
//        persoInfo.setRealName(nome);
//        System.out.println("Digite sua idade: ");
//        Integer idade = sc.nextInt();
//        persoInfo.setAge(idade);
//        System.out.println("Digite seu email: ");
//        String email = sc.next();
//        persoInfo.setEmail(email);
//        persoInfoService.addPersoInfo(persoInfo);
//
//        System.out.println("Que tipo de Usuario você quer ser? 0 - Free, 1 - Pro");
//        Integer userType = sc.nextInt();
//        user.setUserType(userType);
//        System.out.println("Digite seu Username: ");
//        String username = sc.next();
//        user.setUsername(username);
//        System.out.println("Digite sua senha: ");
//        String password = sc.next();
//        user.setPassword(password);
//
//        System.out.println("Qual sua linguagem de programação favorita? "
//                + "1 - JAVASCRIPT, "
//                + "2 - JAVA, "
//                + "3 - PHP, "
//                + "4 - C, "
//                + "5 - PYTHON, "
//                + "6 - TYPESCRIPT, "
//                + "7 - RUBY");
//        ProgLangs progLangs = ProgLangs.values()[sc.nextInt() - 1];
//        user.setProgLangs(progLangs);
//
//        System.out.println("Qual seu Genero? 1 - MASCULINO, 2 - FEMININO");
//        Gender gender = Gender.values()[sc.nextInt() - 1];
//        user.setGender(gender);
//
//        System.out.println("Qual sua preferencia? 1 - HOMEM, 2 - MULHER, 3 - AMBOS");
//        Pref pref = Pref.values()[sc.nextInt() - 1];
//        user.setPref(pref);
//
//        System.out.println("Digite seu whats: ");
//        user.setWhats(sc.next());
//
//        user.setPersoInfo(persoInfo);
//        user.setAddress(address);
//        userService.addUser(user);
//
//        System.out.println("LISTANDO ENDEREÇOS: ");
//        addressService.listAddress();
//        System.out.println();
//        System.out.println("LISTANDO PERSOINFOS: ");
//        persoInfoService.listPersoInfos();
//        System.out.println("Listando Usuarios: ");
//        userService.listUsers();
        sc.close();
    }
}
