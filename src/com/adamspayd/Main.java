package com.adamspayd;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static TextEditor editor;

    public static void main(String[] args) {

        int input;

        // Create the file and/or the directory
        System.out.println("Create new directory?\n" +
                "0 - no\n" +
                "1 - yes");

        input = scanner.nextInt();
        scanner.nextLine();
        String pathName, fileName;

        if(input == 1) {
            System.out.println("Path: ");
            pathName = scanner.nextLine();
        } else {
            pathName = "";
        }

        System.out.println("File name: ");
        fileName = scanner.nextLine();
        editor = new TextEditor(pathName, fileName);

        boolean quit = false;
        String text = "";

        showMenu();

        while (!quit) {

            input = scanner.nextInt();
            scanner.nextLine();

            switch(input) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    // TODO: Add write loop cycle
                    System.out.println("=========" + editor.getFileName() + "=========");
                    text = scanner.nextLine();
                    editor.write(text);
                    break;
                case 2:
                    System.out.println("=========" + editor.getFileName() + "=========");
                    text = scanner.nextLine();
                    editor.writeln(text);
                    break;
                case 3:
                    editor.readFile();
                    break;
                case 4:
                    if (editor.save()) {
                        editor.save();
                        System.out.println("Saving and closing " + editor.getFileName());
                    } else {
                        System.out.println("Error saving");
                    }
                    break;
                case 5:
                    showMenu();
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n======================");
        System.out.println("Press\n" +
                "0 - to quit\n" +
                "1 - to write\n" +
                "2 - to writeln\n" +
                "3 - to read the file\n" +
                "4 - to save and close file\n" +
                "5 - to print the menu\n======================");
    }
}
