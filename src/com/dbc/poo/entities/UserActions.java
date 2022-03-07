package com.dbc.poo.entities;

import com.dbc.poo.enums.Gender;
import com.dbc.poo.enums.Pref;
import com.dbc.poo.enums.ProgLangs;
import com.dbc.poo.interfaces.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class UserActions implements Actions {
    public static List<User> userList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    @Override
    public void registerUser() {
        System.out.println("""
                \nVocê deseja assinar o plano pro?
                1 - SIM
                2 - NÃO""");
        int pro = scan.nextInt();
        scan.nextLine();

        String username = registerUsername();
        String password = registerPassword();
        PersoInfo persoInfo = registerPersoInfo();
        Address address = registerAddress();
        ProgLangs progLangs = registerProgLang();
        Gender gender = registerGender();
        Pref pref = registerPref();

        switch (pro) {
            case 1 -> {
                System.out.println("Digite seu WhatsApp:");
                String whatsApp = scan.next();
                User user = new ProUser(username, password, persoInfo, address, progLangs, gender, pref, whatsApp);
                userList.add(user);
                System.out.println("Cadastro efetuado com sucesso!");
                appInit();
            }
            case 2 -> {
                User user = new FreeUser(username, password, persoInfo, address, progLangs, gender, pref);
                userList.add(user);
                System.out.println("Cadastro efetuado com sucesso!");
                appInit();
            }
        }
    }

    public void listAllUsers() {
        for (int i = 0; i < userList.size(); i++) {
            System.out.println("id = " + i  + " | " + userList.get(i));

        }
    }
    @Override
    public void updateUser(User user) {
        int editMenu = 0;
        System.out.println("""
                        \n[EDITAR PERFIL]
                        1 - Username
                        2 - Senha
                        3 - Dados pessoais
                        4 - Endereço
                        5 - Gênero
                        6 - Linguagens
                        7 - Interesses
                        8 - WhatsApp (Somente Pro)
                        9 - Voltar ao menu anterior""");
        editMenu = scan.nextInt();
        if (editMenu < 9 && editMenu > 0) {
            switch (editMenu) {
                case 1: {
                    editUsername(user);
                    userMenu(user);
                    break;
                }
                case 2: {
                    editPassword(user);
                    userMenu(user);
                    break;
                }
                case 3: {
                    editPersoInfo(user);
                    userMenu(user);
                    break;
                }
                case 4: {
                    editAddress(user);
                    userMenu(user);
                    break;
                }
                case 5: {
                    editGender(user);
                    userMenu(user);
                    break;
                }
                case 6: {
                    editProgLang(user);
                    userMenu(user);
                    break;
                }
                case 7: {
                    editPref(user);
                    userMenu(user);
                    break;
                }
                case 8: {
                    editWhatsapp(user);
                    userMenu(user);
                    break;
                }
            }
        }
        else {
            userMenu(user);
        }
    }

    @Override
    public void deleteUser(User user) {
        int delOption = 0;
        System.out.println("""
                \nESTA AÇÃO É IRREVERSÍVEL!
                Você está certo de que quer deletar seu perfil?
                1 - SIM
                2 - NÃO""");
        delOption = scan.nextInt();
        scan.nextLine();
        if (delOption == 1) {
            userList.remove(user);
            System.out.println("Perfil deletado com sucesso!");
            appInit();
        }
        else {
            userMenu(user);
        }
    }


    public void login() {
        System.out.println("""
                \n[LOGIN]
                Username:""");
        String usernameLogin = scan.nextLine();
        for (User user : userList) {
            if (usernameLogin.equalsIgnoreCase(user.getUsername())) {
                System.out.println("Senha:");
                String passwordLogin = scan.nextLine();
                if (passwordLogin.equals(user.getPassword())) {
                    System.out.println("\nBem-vindo, " + user.getPersoInfo().getRealName() + "!\n");
                    userMenu(user);
                } else {
                    System.out.println("Senha inválida.");
                    login();
                }
            }
        }
        System.out.println("Usuário não encontrado.");
        appInit();
    }

    public void userMenu(User user) {
        System.out.println("""
                    \n[MENU]
                    1 - Procurar parceiros
                    2 - Editar seu perfil
                    3 - Mostrar seu perfil
                    4 - Mostrar todos usuarios
                    8 - Deletar perfil
                    9 - Fazer logout""");
        int userMenu = scan.nextInt();
        scan.nextLine();

        switch (userMenu) {
            case 1 -> tinDev(user);
            case 2 -> updateUser(user);
            case 3 -> {
                user.printMyInfo();
                userMenu(user);
            }
            case 4 -> {
                this.listAllUsers();
                userMenu(user);
            }
            case 8 -> deleteUser(user);
            case 9 -> appInit();
            default -> userMenu(user);
            }
    }

    public String registerUsername() {
        System.out.println("Defina seu username:");
        String usernameCheck = scan.nextLine();
        usernameCheck = usernameCheck.toLowerCase(Locale.ROOT);
        for (int i=0; i<userList.size(); i++) {
            while (usernameCheck.equals(userList.get(i).getUsername())) {
                System.out.println("Username já cadastrado. Escolha outro username para o cadastro:");
                usernameCheck = scan.nextLine();
                i=0;
            }
        }
        String username = usernameCheck;
        return username;
    }
    public String registerPassword() {
        System.out.println("Escolha uma senha:");
        String password = scan.nextLine();
        return password;
    }
    public PersoInfo registerPersoInfo() {
        System.out.println("Seu primeiro nome:");
        String realName = scan.nextLine();
        System.out.println("Sua idade:");
        int age = scan.nextInt();
        scan.nextLine();
        System.out.println("Seu e-mail:");
        String emailCheck = scan.nextLine();
        emailCheck = emailCheck.toLowerCase(Locale.ROOT);
        for (int i = 0; i < userList.size(); i++) {
            while (emailCheck.equals(userList.get(i).getPersoInfo().getEmail())) {
                System.out.println("E-mail já cadastrado. Escolha outro e-mail para o cadastro:");
                emailCheck = scan.nextLine();
                i = 0;
            }
        }
        String email = emailCheck;
        PersoInfo persoInfo = new PersoInfo(realName, age, email);
        return persoInfo;
    }
    public Address registerAddress() {
        System.out.println("Rua: ");
        String street = scan.nextLine();
        System.out.println("Número da casa: ");
        int number = scan.nextInt();
        scan.nextLine();
        System.out.println("Cidade: ");
        String city = scan.nextLine();

        Address address = new Address(street, number, city);
        return address;
    }
    public Gender registerGender() {
        System.out.println("""
                Qual seu gênero?
                1 - MASCULINO,
                2 - FEMININO;""");
        Gender gender = Gender.values()[scan.nextInt() - 1];
        return gender;
    }
    public ProgLangs registerProgLang() {
        System.out.println("""
                Qual sua linguagem de programação favorita?
                1 - JAVASCRIPT,
                2 - JAVA,
                3 - PHP,
                4 - C,
                5 - PYTHON,
                6 - TYPESCRIPT,
                7 - RUBY;""");
        ProgLangs progLangs = ProgLangs.values()[scan.nextInt() - 1];
        return progLangs;
    }
    public Pref registerPref() {
        System.out.println("""
                Você possui preferência por:
                1 - HOMENS,
                2 - MULHERES,
                3 - AMBOS;""");
        Pref pref = Pref.values()[scan.nextInt() - 1];
        return pref;
    }

    public void editUsername (User user) {
        System.out.println("Defina seu novo username:");
        String usernameCheck = scan.next();
        usernameCheck = usernameCheck.toLowerCase(Locale.ROOT);
        for (int i=0; i<userList.size(); i++) {
            while (usernameCheck.equals(userList.get(i).getUsername())) {
                System.out.println("Username já cadastrado. Escolha outro username para o cadastro:");
                usernameCheck = scan.next();
                i=0;
            }
        }
        String username = usernameCheck;
        user.setUsername(username);
        System.out.println("Username alterado com sucesso!");
    }
    public void editPassword (User user) {
        System.out.println("Digite sua senha atual:");
        String oldPassword = scan.next();
        if (oldPassword.equals(user.getPassword())) {
            System.out.println("Digite sua nova senha:");
            String newPassword = scan.next();
            user.setPassword(newPassword);
            System.out.println("Senha alterada com sucesso!");
        }
        else {
            System.out.println("Senha incorreta.");
            updateUser(user);
        }
    }
    public void editPersoInfo (User user) {
        int persoMenu = 0;
        System.out.println("""
                \nO que deseja editar?
                1 - Primeiro nome
                2 - Idade
                3 - Email""");
        persoMenu = scan.nextInt();
        scan.nextLine();
        switch (persoMenu) {
            case 1:
                System.out.println("Digite seu nome:");
                String newRealName = scan.next();
                user.getPersoInfo().setRealName(newRealName);
                System.out.println("Nome alterado com sucesso!");
                break;
            case 2:
                System.out.println("Digite sua idade:");
                int newAge = scan.nextInt();
                scan.nextLine();
                user.getPersoInfo().setAge(newAge);
                System.out.println("Idade alterada com sucesso!");
                break;
            case 3:
                String oldEmail = "";
                String newEmail = "";
                System.out.println("Digite seu e-mail atual:");
                oldEmail = scan.next();
                if (oldEmail.equals(user.getPersoInfo().getEmail())) {
                    System.out.println("Digite seu novo e-mail:");
                    newEmail = scan.next();
                    user.getPersoInfo().setEmail(newEmail);
                    System.out.println("E-mail alterado com sucesso!");
                }
                else {
                    System.out.println("E-mail incorreto.");
                    updateUser(user);
                }
                break;
            default:
                System.out.println("Digite uma opção válida.");
                updateUser(user);
        }
    }
    public void editAddress (User user) {
        System.out.println("""
                \nO que deseja editar?
                1 - Rua
                2 - Número da casa
                3 - Cidade""");
        int addrMenu = scan.nextInt();
        scan.nextLine();
        switch (addrMenu) {
            case 1:
                System.out.println("Digite a rua:");
                String newStreet = scan.next();
                user.getAddress().setStreet(newStreet);
                System.out.println("Rua alterada com sucesso!");
                break;
            case 2:
                System.out.println("Digite o número da casa:");
                int newNumber = scan.nextInt();
                scan.nextLine();
                user.getAddress().setNumber(newNumber);
                System.out.println("Número da casa alterado com sucesso!");
                break;
            case 3:
                System.out.println("Digite a cidade:");
                String newCity = scan.next();
                user.getAddress().setCity(newCity);
                System.out.println("Cidade alterada com sucesso!");
                break;
            default:
                System.out.println("Digite uma opção válida.");
                updateUser(user);
        }
    }
    public void editGender (User user) {
        System.out.println("""
                \nDigite o número correspondente ao seu gênero:
                1 - MASCULINO
                2 - FEMININO""");
        Gender newGender = Gender.values()[scan.nextInt() - 1];
        user.setGender(newGender);
        System.out.println("Gênero alterado com sucesso!");
    }
    public void editProgLang (User user) {
        System.out.println("""
                \nDigite o número correspondente à sua linguagem:
                1 - JAVASCRIPT,
                2 - JAVA,
                3 - PHP,
                4 - C,
                5 - PYTHON,
                6 - TYPESCRIPT,
                7 - RUBY""");
        ProgLangs newProgLangs = ProgLangs.values()[scan.nextInt() - 1];
        user.setProgLangs(newProgLangs);
        System.out.println("Linguagem alterada com sucesso!");
    }
    public void editPref (User user) {
        System.out.println("""
                \nDigite o número correspondente aos seus interesses:
                1 - HOMENS
                2 - MULHERES
                3 - AMBOS""");
        Pref newPref = Pref.values()[scan.nextInt() - 1];
        user.setPref(newPref);
        System.out.println("Interesses alterados com sucesso!");
    }
    public void editWhatsapp (User user) {
        if (user instanceof ProUser) {
            System.out.println("Digite seu novo numero de Whatsapp: ");
            String newWhatsapp = scan.next();
            ((ProUser) user).setWhatsApp(newWhatsapp);
            System.out.println("Número de whatsapp alterado com sucesso!");
        } else {
            System.out.println("Você não é um usuário Pro.");
        }
    }

    public void appInit() {
        System.out.println("""
            \nBem vindo(a) ao TinDev!
            Digite a opção desejada:
            1 - Login
            2 - Cadastro""");

        int menu = scan.nextInt();
        scan.nextLine();

        switch (menu) {
            case 1 -> {
                login();
            }
            case 2 -> {
                registerUser();
            }
            default -> {
                System.out.println("Tente novamente.");
                appInit ();
            }
        }
    }

    public void tinDev(User user) {
        Scanner scan = new Scanner(System.in);
        Like like = new Like();
        UserActions userActions = new UserActions();

        System.out.println("""
                    \n[TINDEV]
                    1 - Escolher candidatos
                    2 - Mostrar sua lista de matches
                    3 - Mostrar sua lista de likes
                    9 - Voltar ao menu anterior""");
        int tinMenu = scan.nextInt();
        scan.nextLine();
        switch(tinMenu) {
            case 1 -> {
                List<User> availableUsers = userActions.listAvailableUsers(user);
                like.listCandidates(availableUsers, user);
            }
            case 2 -> {
                user.printMyMatches();
                tinDev(user);
            }
            case 3 ->{
                user.printMyLikes();
                tinDev(user);
            }
            case 9 -> userActions.userMenu(user);
        }


    }

    @Override
    public List<User> listAvailableUsers(User user) {
        List<User> availableUsers = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            User currentUser = userList.get(i);
            if(currentUser.hashCode() == user.hashCode() || user.getMyLikes().contains(currentUser)){
                continue;
            }
            if(user.getPref().isCompatible(currentUser.getGender()) && currentUser.getPref().isCompatible(user.getGender())) {
                availableUsers.add(currentUser);
            }
        }
        return availableUsers;
    }

    @Override
    public void showUsers(List<User> users)  {
        for (int i=0; i<users.size(); i++) {
            System.out.println("ID: " +i+ " | " +users.get(i));
        }
    }

}