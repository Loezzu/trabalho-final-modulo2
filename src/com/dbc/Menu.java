package com.dbc;

import com.dbc.model.Address;
import com.dbc.model.PersoInfo;
import com.dbc.model.User;
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

public class Menu {

    Scanner scan = new Scanner(System.in);

    UserService userService = new UserService();
    AddressService addressService = new AddressService();
    PersoInfoService persoInfoService = new PersoInfoService();
    LikeService likeService = new LikeService();

    User user = new User();
    Address address = new Address();
    PersoInfo persoInfo = new PersoInfo();

    public void appInit() throws BancoDeDadosException {
        System.out.println("""
                \n[HOME]
                Bem vindo(a) ao TinDev!
                Digite a opção desejada:
                1 - Login
                2 - Cadastro
                3 - Listar Todos Usuarios
                4 - Encerrar Programa""");

        int menu = Integer.parseInt(scan.next());

        switch (menu) {
            case 1 -> login();
            case 2 -> registerUser();
            case 3 -> {
                userService.listUsers();
                appInit();
            }
            case 4 -> System.exit(1);
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

    private void registerUser() throws BancoDeDadosException {
        List<User> userList = userService.loginList();

        System.out.println("""
                [CADASTRO]
                Digite seu Username:""");
        String usernameCheck = scan.next().toLowerCase(Locale.ROOT);

        for (int i = 0; i < userList.size(); i++) {
            while (usernameCheck.equals(userList.get(i).getUsername())) {
                System.out.println("Username já cadastrado. Escolha outro:");
                usernameCheck = scan.next();
                i = 0;
            }
        }
        String username = usernameCheck;
        user.setUsername(username);
        System.out.println("Digite sua senha: ");
        String password = scan.next();
        user.setPassword(password);

        System.out.println("Digite seu nome verdadeiro: ");
        String name = scan.next();
        persoInfo.setRealName(name);
        System.out.println("Digite sua idade: ");
        Integer age = Integer.valueOf(scan.next());
        persoInfo.setAge(age);
        System.out.println("Digite seu email: ");
        String emailCheck = scan.next().toLowerCase(Locale.ROOT);
        for (int i = 0; i < userList.size(); i++) {
            while (emailCheck.equals(userList.get(i).getPersoInfo().getEmail())) {
                System.out.println("E-mail já cadastrado. Escolha outro:");
                emailCheck = scan.next();
                i = 0;
            }
        }
        String email = emailCheck;
        persoInfo.setEmail(email);

        System.out.println("Digite seu endereço: \n" +
                "Rua: ");
        String street = scan.next();
        scan.nextLine();
        address.setStreet(street);
        System.out.println("Cidade: ");
        String city = scan.nextLine();
        address.setCity(city);
        System.out.println("Numero da casa: ");
        Integer housenumber = scan.nextInt();
        scan.nextLine();
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
        appInit();
    }

    public void userMenu(User user) throws BancoDeDadosException {
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
            case 4 -> deleteUser(user);
            case 9 -> appInit();
            default -> userMenu(user);
        }
    }

    private void tinDev(User user) throws BancoDeDadosException {
        System.out.println("""
                    \n[TINDEV]
                    1 - Listar candidatos
                    2 - Imprimir meus Likes
                    3 - Deletar Meus Likes
                    9 - Ir para o menu anterior""");
        int userMenu = scan.nextInt();
        scan.nextLine();

        switch (userMenu) {
            case 1 -> {
                List<User> userList = userService.listarUsuariosDisponiveis(user);
                likeService.listCandidates(userList, user);
                tinDev(user);
            }
            case 2 -> {
                likeService.printLikes(user.getUserId());
                tinDev(user);
            }
            case 3 -> {
                System.out.println("Qual Like deseja Remover? (Escolha pelo ID_LIKE)");
                likeService.printLikes(user.getUserId());
                int option = scan.nextInt();
                likeService.deleteLikeById(option);
                tinDev(user);
            }
            default -> userMenu(user);
        }
    }

    private void printUser(User user) throws BancoDeDadosException {
        userService.printMyUser(user);
        userMenu(user);
    }

    private void updateUser(User user) throws BancoDeDadosException {
        System.out.println("""
                1 - Editar Dados do Usuário
                2 - Editar Dados Pessoais
                3 - Editar Endereço
                """);
        int option = scan.nextInt();
        switch (option){
            case 1 -> {
                User newUser = new User();
                System.out.println("Digite seu novo Username: ");
                String username = scan.next();
                scan.nextLine();
                newUser.setUsername(username);
                System.out.println("Digite sua nova Senha: ");
                String senha = scan.next();
                scan.nextLine();
                newUser.setPassword(senha);
                System.out.println("""
                Qual sua nova linguagem de programação favorita?
                1 - JAVASCRIPT
                2 - JAVA
                3 - PHP
                4 - C
                5 - PYTHON
                6 - TYPESCRIPT
                7 - RUBY""");
                ProgLangs progLangs = ProgLangs.values()[scan.nextInt() - 1];
                newUser.setProgLangs(progLangs);
                System.out.println("""
                Qual sua nova preferencia?
                1 - HOMEM
                2 - MULHER
                3 - AMBOS""");
                Pref pref = Pref.values()[scan.nextInt() - 1];
                newUser.setPref(pref);
                userService.editarUsuario(user, newUser);
                userMenu(user);
            }
            case 2 -> {
                PersoInfo newPersoInfo = new PersoInfo();
                System.out.println("Digite seu nome verdadeiro: ");
                String name = scan.next();
                scan.nextLine();
                newPersoInfo.setRealName(name);
                System.out.println("Digite sua nova idade: ");
                Integer age = Integer.valueOf(scan.next());
                newPersoInfo.setAge(age);
                System.out.println("Digite seu novo email: ");
                String email = scan.next();
                scan.nextLine();
                newPersoInfo.setEmail(email);
                persoInfoService.editarPersoInfo(user.getPersoInfo(), newPersoInfo);
                userMenu(user);
            }
            case 3 -> {
                Address newAddress = new Address();
                System.out.println("Digite seu novo endereço: \n" +
                        "Rua: ");
                String street = scan.next();
                scan.nextLine();
                newAddress.setStreet(street);
                System.out.println("Cidade: ");
                String city = scan.next();
                scan.nextLine();
                newAddress.setCity(city);
                System.out.println("Numero da casa: ");
                Integer housenumber = Integer.valueOf(scan.next());
                newAddress.setNumber(housenumber);
                addressService.editarEndereco(user.getAddress(), newAddress);
                userMenu(user);
            }
        }
    }

    private void deleteUser(User user) throws BancoDeDadosException {
        userService.removeUserById(user.getUserId());
        addressService.removeAddressById(user.getAddress().getIdAddress());
        persoInfoService.removePersoInfoById(user.getPersoInfo().getIdPersoInfo());
        appInit();
    }
}
