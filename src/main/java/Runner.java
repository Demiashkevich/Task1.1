import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - new game\n2 - load game");

        int game = scanner.nextInt();

        Thread thread = new Thread(() -> {
            switch (game) {
                case 1:
                    new Combiner().combine();
                    break;
                case 2:
                    new IndexStream().readIndex();
                    new Combiner().combineSave(QueryIndex.getIndexes());
                    break;
            }
        });
        thread.setDaemon(true);
        thread.start();

        while (true) {
            String next = scanner.next();
            if (next.equals("s")) {
                thread.interrupt();
                new IndexStream().writeIndex();
                break;
            }
        }


    }

}
