

public class Philosopher implements Runnable{
    private Object leftFork;
    private Object rightFork;
    private int hungryLevel = 10;

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
            while(hungryLevel>0){
                doAction("Hungry level : "+this.hungryLevel+"   : Thinking" );
                synchronized (leftFork){
                    doAction("Hungry level : "+this.hungryLevel+" : Picked up left fork");
                    synchronized (rightFork){
                        doAction("Hungry level : "+this.hungryLevel+" : Picked up right fork and started eating" );
                        doAction("Hungry level : "+this.hungryLevel+" : Put down right fork");
                        this.hungryLevel-=1;
                    }
                    doAction("Hungry level : "+this.hungryLevel+" : Put down left fork and start thinking");
                }
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }
    }
}
