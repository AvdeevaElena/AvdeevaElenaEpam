package SE07;

import java.util.Random;


public class IntegerSetterGetter extends Thread{
    private SharedResource resource;
    private boolean run;
    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        try {
            while (run) {
                if (rand.nextBoolean()) {
                    getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }
            System.out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;
        synchronized (resource) {
            System.out.println("Поток " + getName() + " хочет извлечь число.");
            number = resource.getElement();
            for (int i = 0; i < 10 && number == null; i++) {
                System.out.println("Поток " + getName() + " ждет пока очередь заполнится.");
                resource.wait(100);
                System.out.println("Поток " + getName() + " возобновил работу.");
                number = resource.getElement();
            }
            if (number == null) {
                System.out.println("Поток " + getName() + " не извлек число");
            } else {
                System.out.println("Поток " + getName() + " извлек число " + number);
            }
        }
    }

    private void setIntegersIntoResource() throws InterruptedException {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число " + number);
            resource.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SharedResource res = new SharedResource();

        IntegerSetterGetter t1 = new IntegerSetterGetter("1", res);
        IntegerSetterGetter t2 = new IntegerSetterGetter("2", res);
        IntegerSetterGetter t3 = new IntegerSetterGetter("3", res);
        IntegerSetterGetter t4 = new IntegerSetterGetter("4", res);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread.sleep(100);

        t1.stopThread();
        t2.stopThread();
        t3.stopThread();
        t4.stopThread();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("main");
    }
}