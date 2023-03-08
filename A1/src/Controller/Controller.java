package Controller;
import Model.MyI;
import Model.Car;
import Model.Bicycle;
import Model.Motorcycle;
import Repository.MyIRepo;


public class Controller {
    private MyIRepo repo;

    public Controller(MyIRepo repo) {this.repo=repo;}
    public void add(MyI vehicle){
        this.repo.add(vehicle);
    }

    public void remove(int idx){
        this.repo.remove(idx);
    }
    public void printAll(String color){
        MyI[] vehicles= this.repo.getAll();
        for(MyI v:vehicles){
            if(v.result(color)){
                System.out.println(v.toString());
            }
        }
        System.out.println("\n");
    }


}
