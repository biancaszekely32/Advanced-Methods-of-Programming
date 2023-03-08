package Repository;
import Model.MyI;


public class Repository implements MyIRepo{
    private MyI[] vehicles;
    private int size;

    public Repository(int maxsize) {
        this.size = 0;
        this.vehicles = new MyI[maxsize];
    }
    public void add(MyI vehicle){
        try{
            this.vehicles[this.size]= vehicle;
            this.size++;
        }catch(Exception e)
        {
            System.out.println(e.toString());
        }


    }
    public void remove(int idx){
        try {
            for(int i=idx+1;i<this.size;++i){
                this.vehicles[i-1]=this.vehicles[i];
            }
            this.size--;
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }
    public MyI[] getAll(){
        return this.vehicles;
    }
}
