package View;

import Controller.Controller;
import Model.ADT.*;
import Model.Expression.ArithExpression;
import Model.Expression.ValueExpression;
import Model.Expression.VarExpression;
import Model.ProgramState;
import Model.Statement.*;
import Model.Type.BoolType;
import Model.Type.IntType;
import Model.Value.BoolValue;
import Model.Value.IntValue;
import Model.Value.InterValue;
import Model.Value.StringValue;
import Model.Type.StringType;
import Repo.Repository;
import Repo.InterRepository;
import View.ExitCommand;
import View.RunExaCommand;
import Model.Statement.CloseReadFile;
import Model.Statement.OpenReadFile;
import Model.Statement.ReadFile;
import java.io.BufferedReader;
import Model.Expression.RelatExpression;
import Model.Value.RefValue;
import Model.Type.RefType;
import Model.ADT.InterHeap;
import Model.Expression.ReadHeapExpression;


import java.io.IOException;

public class Interpreter {
    public static void main(String[] args) {
        // create the program state
        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));

        InterStatement ex1 = new CompStatement(new DeclStatement("v", new IntType()),
                new CompStatement(new AssignStatement("v", new ValueExpression(new IntValue(2))),
                        new PrintStatement(new VarExpression("v"))));

        // create the repository and the controller for the program state created
        ProgramState prg1 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), new MyHeap(), ex1);
        InterRepository repo1;

        try {
            repo1 = new Repository(prg1, "log1.txt");
            Controller ctrl1 = new Controller(repo1);
            menu.addCommand(new RunExaCommand("1", ex1.toString(), ctrl1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        InterStatement ex2 = new CompStatement(new DeclStatement("a", new IntType()),
                new CompStatement(new DeclStatement("b", new IntType()),
                        new CompStatement(new AssignStatement("a", new ArithExpression('+', new ValueExpression(new IntValue(2)), new
                                ArithExpression('*', new ValueExpression(new IntValue(3)), new ValueExpression(new IntValue(5))))),
                                new CompStatement(new AssignStatement("b", new ArithExpression('+', new VarExpression("a"), new ValueExpression(new
                                        IntValue(1)))), new PrintStatement(new VarExpression("b"))))));

        ProgramState prg2 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), new MyHeap(), ex2);
        InterRepository repo2;

        try {
            repo2 = new Repository(prg2, "log2.txt");
            Controller ctrl2 = new Controller(repo2);
            menu.addCommand(new RunExaCommand("2", ex2.toString(), ctrl2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        InterStatement ex3 = new CompStatement(new DeclStatement("a", new BoolType()),
                new CompStatement(new DeclStatement("v", new IntType()),
                        new CompStatement(new AssignStatement("a", new ValueExpression(new BoolValue(true))),
                                new CompStatement(new IfStatement(new VarExpression("a"),
                                        new AssignStatement("v", new ValueExpression(new IntValue(2))),
                                        new AssignStatement("v", new ValueExpression(new IntValue(3)))),
                                        new PrintStatement(new VarExpression("v"))))));

        ProgramState prg3 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), new MyHeap(), ex3);
        InterRepository repo3;

        try {
            repo3 = new Repository(prg3, "log3.txt");
            Controller ctrl3 = new Controller(repo3);
            menu.addCommand(new RunExaCommand("3", ex3.toString(), ctrl3));
        } catch (Exception e) {
            e.printStackTrace();
        }

        InterStatement ex4 = new CompStatement(new DeclStatement("varf", new StringType()),
                new CompStatement(new AssignStatement("varf", new ValueExpression(new StringValue("test.in"))),
                        new CompStatement(new OpenReadFile(new VarExpression("varf")),
                                new CompStatement(new DeclStatement("varc", new IntType()),
                                        new CompStatement(new ReadFile(new VarExpression("varf"), "varc"),
                                                new CompStatement(new PrintStatement(new VarExpression("varc")),
                                                        new CompStatement(new ReadFile(new VarExpression("varf"), "varc"),
                                                                new CompStatement(new PrintStatement(new VarExpression("varc")),
                                                                        new CloseReadFile(new VarExpression("varf"))))))))));

        ProgramState prg4 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), new MyHeap(), ex4);
        InterRepository repo4;

        try {
            repo4 = new Repository(prg4, "log4.txt");
            Controller ctrl4 = new Controller(repo4);
            menu.addCommand(new RunExaCommand("4", ex4.toString(), ctrl4));
        } catch (Exception e) {
            e.printStackTrace();
        }

        InterStatement ex5 = new CompStatement(new DeclStatement("a", new IntType()),
                new CompStatement(new DeclStatement("b", new IntType()),
                        new CompStatement(new AssignStatement("a", new ValueExpression(new IntValue(5))),
                                new CompStatement(new AssignStatement("b", new ValueExpression(new IntValue(7))),
                                        new IfStatement(new RelatExpression(">", new VarExpression("a"),
                                                new VarExpression("b")), new PrintStatement(new VarExpression("a")),
                                                new PrintStatement(new VarExpression("b")))))));

        ProgramState prg5 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), new MyHeap(), ex5);
        InterRepository repo5;

        try {
            repo5 = new Repository(prg5, "log5.txt");
            Controller ctrl5 = new Controller(repo5);
            menu.addCommand(new RunExaCommand("5", ex5.toString(), ctrl5));
        } catch (Exception e) {
            e.printStackTrace();
        }



        InterStatement ex7 = new CompStatement(new DeclStatement("v", new IntType()),
                new CompStatement(new AssignStatement("v", new ValueExpression(new IntValue(4))),
                        new CompStatement(new Model.Statement.WhileStatement(new RelatExpression(">", new VarExpression("v"), new ValueExpression(new IntValue(0))),
                                new CompStatement(new PrintStatement(new VarExpression("v")), new AssignStatement("v",new ArithExpression('-', new VarExpression("v"), new ValueExpression(new IntValue(1)))))),
                                new PrintStatement(new VarExpression("v")))));


        ProgramState prg7 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), new MyHeap(), ex7);
        InterRepository repo7;

        try {
            repo7 = new Repository(prg7, "log6.txt");
            Controller controller7 = new Controller(repo7);
            menu.addCommand(new RunExaCommand("6", ex7.toString(), controller7));
        } catch (IOException e) {
            e.printStackTrace();
        };

        InterStatement ex8 = new CompStatement(new DeclStatement("v", new RefType(new IntType())),
                new CompStatement(new Model.Statement.NewStatement("v", new ValueExpression(new IntValue(20))),
                        new CompStatement(new DeclStatement("a", new RefType(new RefType(new IntType()))),
                                new CompStatement(new Model.Statement.NewStatement("a", new VarExpression("v")),
                                        new CompStatement(new PrintStatement(new VarExpression("v")), new PrintStatement(new VarExpression("a")))))));

        ProgramState prg8 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), new MyHeap(), ex8);
        InterRepository repo8;

        try {
            repo8 = new Repository(prg8, "log7.txt");
            Controller controller8 = new Controller(repo8);
            menu.addCommand(new RunExaCommand("7", ex8.toString(), controller8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        InterStatement ex9 = new CompStatement(new DeclStatement("v", new RefType(new IntType())),
                new CompStatement(new Model.Statement.NewStatement("v", new ValueExpression(new IntValue(20))),
                        new CompStatement(new DeclStatement("a", new RefType(new RefType(new IntType()))),
                                new CompStatement(new Model.Statement.NewStatement("a", new VarExpression("v")),
                                        new CompStatement(new PrintStatement(new ReadHeapExpression(new VarExpression("v"))),
                                                new PrintStatement(new ArithExpression('+',new ReadHeapExpression(new ReadHeapExpression(new VarExpression("a"))), new ValueExpression(new IntValue(5)))))))));

        ProgramState prg9 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), new MyHeap(), ex9);
        InterRepository repo9;

        try {
            repo9 = new Repository(prg9, "log8.txt");
            Controller controller9 = new Controller(repo9);
            menu.addCommand(new RunExaCommand("8", ex9.toString(), controller9));
        } catch (IOException e) {
            e.printStackTrace();
        }

        InterStatement ex10 = new CompStatement(new DeclStatement("v", new RefType(new IntType())),
                new CompStatement(new Model.Statement.NewStatement("v", new ValueExpression(new IntValue(20))),
                        new CompStatement( new PrintStatement(new ReadHeapExpression(new VarExpression("v"))),
                                new CompStatement(new Model.Statement.WriteHeapStatement("v", new ValueExpression(new IntValue(30))),
                                        new PrintStatement(new ArithExpression('+', new ReadHeapExpression(new VarExpression("v")), new ValueExpression(new IntValue(5))))))));

        ProgramState prg10 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), new MyHeap(), ex10);
        InterRepository repo10;

        try {
            repo10 = new Repository(prg10, "log9.txt");
            Controller controller10 = new Controller(repo10);
            menu.addCommand(new RunExaCommand("9", ex10.toString(), controller10));
        } catch (IOException e) {
            e.printStackTrace();
        }

       InterStatement ex11 = new CompStatement(new DeclStatement("v", new RefType(new IntType())),
                new CompStatement(new Model.Statement.NewStatement("v", new ValueExpression(new IntValue(20))),
                        new CompStatement(new DeclStatement("a", new RefType(new RefType(new IntType()))),
                                new CompStatement(new Model.Statement.NewStatement("a", new VarExpression("v")),
                                        new CompStatement(new Model.Statement.NewStatement("v", new ValueExpression(new IntValue(30))),
                                                new PrintStatement(new ReadHeapExpression(new ReadHeapExpression(new VarExpression("a")))))))));

        ProgramState prg11 = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), new MyHeap(), ex11);
        InterRepository repo11;

        try {
            repo11 = new Repository(prg11, "log10.txt");
            Controller controller11 = new Controller(repo11);
            menu.addCommand(new RunExaCommand("10", ex11.toString(), controller11));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // add the commands to the menu
        menu.show();
    }
}