public class Main {
    private final static int WORKERS = 4;

    public static void main(String[] args) {
        Ats ats = new Ats();
        ats.start();

        for (int i = 1; i <= WORKERS; i++) {
            new Thread(new Operator(ats, i)).start();
        }
    }
}
