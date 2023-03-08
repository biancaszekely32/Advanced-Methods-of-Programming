package View;
import Controller.Controller;
import Model.MyI;
import Model.Bicycle;
import Model.Car;
import Model.Motorcycle;
import Repository.MyIRepo;
import Repository.Repository;



public class View {
    public static void main(String[] args) {
        MyI v1= new Car("pink");
        MyI v2=new Car("blue");
        MyI v3= new Bicycle("red");
        MyI v4= new Motorcycle("red");
        MyI v5= new Bicycle("green");

        MyIRepo repo= new Repository(3);
        Controller controller= new Controller(repo);

        try{
            controller.add(v1);
            controller.add(v2);
            controller.add(v3);
            controller.add(v4);
            controller.add(v5);
            controller.remove(3);//remove v4
            controller.add(v4);
            //controller.add(v4);
        }catch (Exception e)
        {
            System.out.println(e.toString());
        }

        controller.printAll("red");
    }
}
