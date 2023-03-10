package View;

import Controller.Controller;
import Model.Exceptions.MyException;
import Model.ProgramState;
import Repo.InterRepository;

import java.util.Objects;
import java.util.Scanner;
import java.io.IOException;

public class RunExaCommand extends Command {
    private final Controller controller;

    public RunExaCommand(String key, String description, Controller controller) {
        super(key, description); /* call the constructor of the parent class */
        this.controller = controller;
    }

    @Override
    public void execute() {

        try {

            System.out.println("Do you want to display the steps?[Y/n]");
            Scanner readOption = new Scanner(System.in);
            String option = readOption.next();
            controller.setDisplayFlag(Objects.equals(option, "Y"));
            controller.allSteps();

            System.out.println("Result: " + controller.getRepository().getProgramStates().get(0).getOut().toString());
        } catch (MyException | IOException exception){
            System.out.println(exception.getMessage());
        }

    }
}



