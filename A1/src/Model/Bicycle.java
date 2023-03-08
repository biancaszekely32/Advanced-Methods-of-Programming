package Model;

public class Bicycle implements MyI{
    private String color;

    public Bicycle(String color)
    {
        this.color=color;
    }

    public String getColor()
    {return color;}

    public void setColor(String color)
    {
        this.color=color;
    }

    @Override
    public String toString(){
        return "Bicycle{ color = " + color + " }";
    }

    @Override
    public boolean result(String color){
        if(this.color.compareTo(color)==0)
            return true;
        else return false;
    }
}
