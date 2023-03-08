package View;

import Model.ADT.MyDictionary;
import Model.Exceptions.MyException;
import View.Command;
import Model.ADT.InterDictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextMenu {
    private InterDictionary<String, Command> commands;

    public TextMenu() {
        commands = new MyDictionary<>();
    }

    public void addCommand(Command command) {
        commands.put(command.getKey(), command);
    }

    public void printMenu() {
        for (Command command : commands.values()) {
            String line = String.format("%4s : %s", command.getKey(), command.getDescription());
            System.out.println(line);
        }
        /* example: 1 : Open a file */
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.println("Input the option: ");
            String key = scanner.nextLine();

            Command command = commands.lookUp(key);
            command.execute();
        }
    }
}
