package com.dbc;

import com.dbc.entities.Address;
import com.dbc.entities.PersoInfo;
import com.dbc.entities.User;
import com.dbc.enums.Gender;
import com.dbc.enums.Pref;
import com.dbc.enums.ProgLangs;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.AddressRepository;
import com.dbc.repository.UserRepository;
import com.dbc.service.AddressService;
import com.dbc.service.PersoInfoService;
import com.dbc.service.UserService;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

    Scanner scan = new Scanner(System.in);

    UserService userService = new UserService();
    AddressService addressService = new AddressService();
    PersoInfoService persoInfoService = new PersoInfoService();

    UserRepository userRepo = new UserRepository();
    AddressRepository addressRepo = new AddressRepository();
    PersoInfo persoInfoRepo = new PersoInfo();

    User user = new User();
    Address address = new Address();
    PersoInfo persoInfo = new PersoInfo();

    public void appInit() throws BancoDeDadosException {
        System.out.println("""
                \n[HOME]
                Bem vindo(a) ao TinDev!
                Digite a opção desejada:
                1 - Login
                2 - Cadastro""");

        int menu = Integer.parseInt(scan.next());

        switch (menu) {
            case 1 -> {
                login();
            }
            case 2 -> {
                registerUser();
            }
            default -> {
                System.out.println("Tente novamente.");
                appInit();
            }
        }
    }

    public void login() throws BancoDeDadosException {
        List<User> userList = userService.loginList();

        System.out.println("""
                \n[LOGIN]
                Username:""");
        String userLogin = scan.next();

        for (int i=0; i<userList.size(); i++) {
                for (User user : userList) {
                    if (userLogin.equalsIgnoreCase(user.getUsername())) {
                        System.out.println("Senha:");
                        String userPassword = scan.next();
                        if (userPassword.equals(user.getPassword())) {
                            System.out.println("\nBem-vindo, " + user.getPersoInfo().getRealName() + "!");
                            userMenu(user);
                        } else {
                            System.out.println("Senha inválida.");
                            appInit();
                        }
                    }
                }
                System.out.println("Usuário inválido.");
                appInit();
            }
        }

    private void registerUser() {
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
    }

    private void userMenu(User user) throws BancoDeDadosException {
        System.out.println("""
                    \n[MENU]
                    1 - Procurar parceiros
                    2 - Editar seu perfil
                    3 - Mostrar seu perfil
                    4 - Deletar perfil
                    9 - Fazer logout""");
        int userMenu = scan.nextInt();
        scan.nextLine();

        switch (userMenu) {
            case 1 -> tinDev(user);
            case 2 -> updateUser(user);
            case 3 -> printUser(user);
            case 8 -> deleteUser(user);
            case 9 -> appInit();
            default -> userMenu(user);
        }
    }

    private void tinDev(User user) {
    }

    private void printUser(User user) {
    }

    private void updateUser(User user) {
    }

    private void deleteUser(User user) {
    }
}
