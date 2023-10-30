package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> users_data = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        String s = "";


        try {
            System.out.println("Введите фамилию пользователя");
            s = scanner.nextLine();
            users_data.add("<" + s + ">");
            if (s == "" || s.length() < 3) {
                throw new UserInputException("Некорректная фамилия пользователя");
            }

            System.out.println("Введите имя пользователя");
            s = scanner.nextLine();
            users_data.add("<" + s + ">");
            if (s == "" || s.length() < 3) {
                throw new UserInputException("Некорректное имя пользователя");
            }

            System.out.println("Введите отчетсво пользователя");
            s = scanner.nextLine();
            users_data.add("<" + s + ">");
            if (s == "" || s.length() < 3) {
                throw new UserInputException("Некорректное отчество пользователя");
            }

            System.out.println("Введите дату рождения пользователя в формате dd.mm.yyyy");
            s = scanner.nextLine();
            users_data.add("<" + s + ">");
            if (s.charAt(2) != '.' || s.charAt(5) != '.' || s.length() != 10  || Integer.parseInt(s.substring(0, 2)) > 31 || Integer.parseInt(s.substring(3, 5)) > 12) {
                throw new UserInputException("Некорректная дата рождения пользователя");
            }

            System.out.println("Введите телефон пользователя 11 цифр");
            s = scanner.nextLine();
            users_data.add("<" + s + ">");
            if (s.length() != 11) {
                throw new UserInputException("Некорректный телефон пользователя");
            }

            System.out.println("Введите пол пользователя f или m");
            s = scanner.nextLine();
            users_data.add("<" + s + ">");
            if (!Objects.equals(s, "m") && !Objects.equals(s, "f")) {
                throw new UserInputException("Некорректный пол пользователя");
            }

                try {
                    ToFile(users_data.get(0).replaceAll("[<>]*", ""), users_data);
                } catch (IOException e) {
                    e.printStackTrace();
                }

        } catch (UserInputException e) {
            e.printStackTrace();
        }


    }

    public static void ToFile(String name1, ArrayList list) throws IOException {


        String path = System.getProperty("user.dir");
        File f = new File(path + "\\" + name1);

        if (f.exists()) {
            File file = new File(path + "\\" + name1);
            FileWriter fr = new FileWriter(file, true);
            fr.write(String.valueOf(list) + "\n");
            fr.close();
        } else {
            Files.createFile(Path.of(path + "\\" + name1));
            File file = new File(path + "\\" + name1);
            FileWriter fr = new FileWriter(file, true);
            fr.write(String.valueOf(list) + "\n");
            fr.close();
        }
        System.out.println("Создана запись: " + path + "\\" + name1);
    }

}



