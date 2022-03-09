package com.dbc;

import com.dbc.entities.Address;
import com.dbc.entities.Like;
import com.dbc.entities.PersoInfo;
import com.dbc.entities.User;
import com.dbc.enums.Gender;
import com.dbc.enums.Pref;
import com.dbc.enums.ProgLangs;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.service.AddressService;
import com.dbc.service.LikeService;
import com.dbc.service.PersoInfoService;
import com.dbc.service.UserService;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws BancoDeDadosException {
//        Menu menu = new Menu();

        Scanner scan = new Scanner(System.in);
        UserService userService = new UserService();
        AddressService addressService = new AddressService();
        PersoInfoService persoInfoService = new PersoInfoService();
        LikeService likeService = new LikeService();

        User user = new User();
        Address address = new Address();
        PersoInfo persoInfo = new PersoInfo();
        Like like = new Like();

        System.out.println("""
                [CADASTRO]
                Digite seu Username:""");
        String username = scan.next().toLowerCase(Locale.ROOT);
        scan.nextLine();
        user.setUsername(username);
        System.out.println("Digite sua senha: ");
        String password = scan.nextLine();
        user.setPassword(password);

        System.out.println("Digite seu nome verdadeiro: ");
        String name = scan.nextLine();
        persoInfo.setRealName(name);
        System.out.println("Digite sua idade: ");
        Integer age = Integer.valueOf(scan.next());
        persoInfo.setAge(age);
        System.out.println("Digite seu email: ");
        String email = scan.next();
        scan.nextLine();
        persoInfo.setEmail(email);

        System.out.println("Digite seu endereço: \n" +
                "Rua: ");
        String street = scan.nextLine();
        address.setStreet(street);
        System.out.println("Cidade: ");
        String city = scan.nextLine();
        address.setCity(city);
        System.out.println("Numero da casa: ");
        Integer housenumber = Integer.valueOf(scan.next());
        address.setNumber(housenumber);

        System.out.println("""
                Qual sua linguagem de programação favorita?
                1 - JAVASCRIPT
                2 - JAVA
                3 - PHP
                4 - C
                5 - PYTHON
                6 - TYPESCRIPT
                7 - RUBY""");
        ProgLangs progLangs = ProgLangs.values()[scan.nextInt() - 1];
        user.setProgLangs(progLangs);

        System.out.println("""
                Qual seu Genero?
                1 - MASCULINO
                2 - FEMININO""");
        Gender gender = Gender.values()[scan.nextInt() - 1];
        user.setGender(gender);

        System.out.println("""
                Qual sua preferencia?
                1 - HOMEM
                2 - MULHER
                3 - AMBOS""");
        Pref pref = Pref.values()[scan.nextInt() - 1];
        user.setPref(pref);

        user.setPersoInfo(persoInfo);
        user.setAddress(address);

        addressService.addAddress(address);
        persoInfoService.addPersoInfo(persoInfo);
        userService.addUser(user);

        System.out.println("Cadastro realizado com sucesso!");
        List<User> users = userService.listarUsuariosDisponiveis(user);
        likeService.listCandidates(users, user);
        likeService.printLikes(user);

//        System.out.println("=================================================================");
//        List<User> users2 = userService.listarUsuariosDisponiveis(user);
//        likeService.listCandidates(users2, user);



//        menu.appInit();
    }
}
