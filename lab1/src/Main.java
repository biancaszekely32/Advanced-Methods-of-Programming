public class Main {
    public static void main(String args[]) {
        int sum=0;
        for(int i=0; i<args.length; i++)
            sum=sum+ Integer.parseInt(args[i]);
        int average = sum/args.length;
        System.out.println("The average of " + args.length+ " numbers is " + average);
    }
}