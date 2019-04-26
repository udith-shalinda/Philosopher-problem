

public class Philosopher implements Runnable{
    private Object leftFork;
    private Object rightFork;
    private int food = 10;

    public Philosopher(Object leftFork,Object rightFork){
        this.leftFork= leftFork;
        this.rightFork= rightFork;
    }

    public void doAction(String action) throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" "+action);
        Thread.sleep((int)(Math.random()*100));

    }


    @Override
    public void run() {
        try{
            while(food>=0){
                doAction(" : Thinking ,food left :" +this.food);
                synchronized (leftFork){
                    doAction(" : Picked up left fork");
                    synchronized (rightFork){
                        doAction(" : Picked up right fork and started eating ,food left :" + this.food);
                        doAction(" : Put down right fork");
                        this.food-=1;
                    }
                    doAction(" : Put down left fork and start thinking");
                }
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }
    }
}
