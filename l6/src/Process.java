import java.util.Random;

public class Process {
    private static final Object mutex = new Object();
    private static Thread abstractProgram = new Thread(new AbstractProgram());


    static class AbstractProgram implements Runnable {
        private static State state = State.RUNNING;

        @Override
        public void run() {
            Thread daemon = new Thread(() -> {
                while (true) {
                    Utils.pause(1000, 3000);
                    if (abstractProgram.isInterrupted()) {
                        break;
                    }
                    synchronized (mutex) {
                        state = State.values()[new Random().nextInt(State.values().length)];
                        System.out.println("Daemon: abstract program state switched to " + state.toString());
                        mutex.notify();
                    }
                }
            });
            daemon.setDaemon(true);
            daemon.start();
            System.out.println("Abstract program: started working");
        }

    }

    static class Supervisor implements Runnable {

        @Override
        public void run() {
            System.out.println("Super visor: started working");
            abstractProgram.start();
            while (!abstractProgram.isInterrupted()) {
                synchronized (mutex) {
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    switch (AbstractProgram.state) {
                        case FATAL_ERROR -> stopProgram();
                        case UNKNOWN, STOPPING -> runProgram();
                        default -> System.out.println("Super visor: nothing");
                    }
                }
            }
        }

        private void runProgram() {
            AbstractProgram.state = State.RUNNING;
            System.out.println("Super visor: abstract program is restarted");
        }

        private void stopProgram() {
            abstractProgram.interrupt();
            System.out.println("Super visor: abstract program is stopped because of FATAL_ERROR");
        }
    }

    public static void main(String[] args) {
        new Thread(new Supervisor()).start();
    }
}
