public class Main {

    public static void main(String[] args) throws Exception{
        Philosopher philosopher[] = new Philosopher[5];
        Object fork[] = new Object[5];

        for(int i=0;i<philosopher.length;i++){
            fork[i] = new Object();
        }

        for(int i=0;i<philosopher.length;i++){
            Object leftFork = fork[i];
            Object rightFork = fork[(i+1)%5];
            philosopher[i] = new Philosopher(leftFork,rightFork);
            Thread t = new Thread(philosopher[i] ," Philosopher "+(i+1));
            t.start();

        }
    }
}
