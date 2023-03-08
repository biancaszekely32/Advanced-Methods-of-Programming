/*
package View;

import Controller.Controller;
import Model.ADT.*;
import Model.Expression.ArithmeticExpression;
import Model.Expression.VariableExpression;
import Model.Expression.ValueExpression;
import Model.Exceptions.MyException;
import Model.PrgState;
import Model.Statement.*;
import Model.Type.IntType;
import Model.Type.BoolType;
import Model.Value.IValue;
import Model.Value.IntValue;
import Model.Value.BoolValue;
import Repo.IRepo;
import Repo.Repo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void printMenu(){
        System.out.println("1. int v; v=2; Print(v)");
        System.out.println("2. int a; int b; a=2+3*5; b=a+1; Print(b)");
        System.out.println("3. bool a; int v; a=true; If(a)Then(v=2)Else(v=3); Print(v)");
        System.out.println("0. exit");
    }

    private static void example1() throws MyException {
        Repo repository = new Repo();
        Controller controller = new Controller(repository);
        IStatement program1 =
                new CompoundStatement(
                        new VariableDeclarationStatement("v", new IntType()),
                        new CompoundStatement(
                                new AssignmentStatement("v", new ValueExpression(new IntValue(2))),
                                new PrintStatement(new VariableExpression("v"))
                        )
                );

        MyIStack<IStatement> executionStack = new MyStack<>();
        executionStack.push(program1);

        MyIDictionary<String, IValue> symbolTable = new MyDictionary<>();
        MyIList<IValue> out = new MyList<>();

        PrgState myProgramState = new PrgState(executionStack, symbolTable, out, program1);

        controller.addProgram(myProgramState);

        controller.allStep();
    }

    private static void example2() throws MyException {
        Repo repository = new Repo();
        Controller controller = new Controller(repository);
        IStatement program1 =
                new CompoundStatement(
                        new VariableDeclarationStatement("a", new IntType()),
                        new CompoundStatement(
                                new VariableDeclarationStatement("b",new IntType()),
                                new CompoundStatement(
                                        new AssignmentStatement("a",
                                                new ArithmeticExpression(
                                                        new ValueExpression(new IntValue(2)),
                                                        new ArithmeticExpression(
                                                                new ValueExpression(new IntValue(3)),
                                                                new ValueExpression(new IntValue(5)),
                                                                3),
                                                        1)
                                        ),
                                        new CompoundStatement(
                                                new AssignmentStatement("b",
                                                        new ArithmeticExpression(
                                                                new VariableExpression("a"),
                                                                new ValueExpression(new IntValue(1)),
                                                                1
                                                        )
                                                ),
                                                new PrintStatement(new VariableExpression("b"))
                                        )
                                )
                        )
                );

        MyIStack<IStatement> executionStack = new MyStack<>();
        executionStack.push(program1);

        MyIDictionary<String, IValue> symbolTable = new MyDictionary<>();
        MyIList<IValue> out = new MyList<>();

        PrgState myProgramState = new PrgState(executionStack, symbolTable, out, program1);

        controller.addProgram(myProgramState);

        controller.allStep();
    }

    private static void example3() throws MyException {
        Repo repository = new Repo();
        Controller controller = new Controller(repository);
        IStatement program1 =
                new CompoundStatement(
                        new VariableDeclarationStatement("a", new BoolType()),
                        new CompoundStatement(
                                new VariableDeclarationStatement("v",new IntType()),
                                new CompoundStatement(
                                        new AssignmentStatement("a",new ValueExpression(new BoolValue(true))),
                                        new CompoundStatement(
                                                new IfStatement(
                                                        new VariableExpression("a"),
                                                        new AssignmentStatement("v",new ValueExpression(new IntValue(2))),
                                                        new AssignmentStatement("v",new ValueExpression(new IntValue(3)))
                                                ),
                                                new PrintStatement(new VariableExpression("v"))
                                        )
                                )
                        )
                );

        MyIStack<IStatement> executionStack = new MyStack<>();
        executionStack.push(program1);

        MyIDictionary<String, IValue> symbolTable = new MyDictionary<>();
        MyIList<IValue> out = new MyList<>();

        PrgState myProgramState = new PrgState(executionStack, symbolTable, out, program1);

        controller.addProgram(myProgramState);

        controller.allStep();
    }

    public static void main(String[] args){

        int choiceIndex;

        while(true){
            try {
                printMenu();

                Scanner scanner = new Scanner(System.in);

                System.out.print("> ");
                choiceIndex = scanner.nextInt();
                switch (choiceIndex) {
                    default -> System.out.println("The number you introduced is not part of the options\n");
                    case 0 -> System.exit(0);
                    case 1 -> {
                        try {
                            example1();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    case 2 -> {
                        try {
                            example2();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    case 3 -> {
                        try {
                            example3();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
            }catch (InputMismatchException e){
                System.out.println("You did not give an integer\n");
            }
        }
    }
}
*/
