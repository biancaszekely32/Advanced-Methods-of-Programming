package Repository;
import Model.MyI;


public interface MyIRepo {
    public void remove(int idx);
    public void add(MyI vehicle);
    public MyI[] getAll();

}
