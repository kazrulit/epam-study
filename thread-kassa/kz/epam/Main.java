package kz.epam;

/**
 * Created by MRSPEC on 24/08/2015.
 */

public class Main {
    public static void main(String[] args) {
        Clients clients = new Clients(21);

        DaemonClient dm = new DaemonClient(clients);
        dm.setPaymentCount(3);
        dm.setDaemon(true);
        dm.start();

        try {
            dm.join();
            System.out.println("Больше клиентов нет");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
