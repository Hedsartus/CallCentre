import java.util.concurrent.PriorityBlockingQueue;

public class Ats extends Thread {
    private final int CALLSCOUNT = 60;
    private final int GAPCALL = 1000;

    PriorityBlockingQueue<Integer> queueCalls = new PriorityBlockingQueue<>();

    public Integer getCall() {
        return this.queueCalls.poll();
    }

    public int getWaiting() {
        return this.queueCalls.size();
    }

    private void addCall(int idCall) {
        this.queueCalls.add(idCall);
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            addCall(++count);
            printNewCalls(count);

            addCall(++count);
            printNewCalls(count);

            try {
                Thread.sleep(GAPCALL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (this.CALLSCOUNT == count) {
                break;
            }
        }
    }

    private void printNewCalls(int call) {
        System.out.println("АТС зарегистрировала новый звонок №" + call);
    }
}
