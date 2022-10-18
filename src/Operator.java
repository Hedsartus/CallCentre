public class Operator implements Runnable {
    private final static int PROCESSING = 3000;
    private final Ats ats;
    private final int idOperator;

    public Operator(Ats ats, int idOperator) {
        this.ats = ats;
        this.idOperator = idOperator;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(PROCESSING);
                if (this.ats.getWaiting() != 0) {
                    System.out.println("Обработан звонок №" + this.ats.getCall());
                } else {
                    System.out.println("Оператор " + this.idOperator + ": Все звонки обработаны!");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
