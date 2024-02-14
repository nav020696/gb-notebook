package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.util.Commands;
import notebook.util.UserValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class  UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        Commands com;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
//                    User u = createUser();
                    userController.saveUser(prompt());
                    break;
                case READ:
                    String id = prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case LIST:
                    System.out.println(userController.readAll());
                    break;
                case UPDATE:
                    String userId = prompt("Enter user id: ");
                    userController.updateUser(userId, prompt());
                    break;
                case DELETE:
                    String userDeleteId = prompt("Enter user id for delete: ");
                    userController.deleteUser(userDeleteId);
            }
        }
    }

    private List<String> prompt() {
        List<String> userData = new ArrayList<>();
        UserValidator validator = new UserValidator();
        Scanner in = new Scanner(System.in);
        System.out.print("Имя: ");
        userData.add(validator.isValid(in.nextLine()));
        System.out.print("Фамилия: ");
        userData.add(validator.isValid(in.nextLine()));
        System.out.print("Номер телефона: ");
        userData.add(validator.isValid(in.nextLine()));
        return userData;
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

}
