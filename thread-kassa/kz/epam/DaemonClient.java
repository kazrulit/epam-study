package kz.epam;

/**
 * <h1>Class of Daemon thread, that will create the objects
 * of payment threads, and will be looking that all the payments will
 * have right count of clients</h1>
 *
 * Created by MRSPEC on 24/08/2015.
 */
public class DaemonClient extends Thread {
    private int clientCount;
    private Clients clients;
    private boolean isStarted = false;

    Payment[] pm;

    DaemonClient() {

    }

    DaemonClient(Clients clients) {
        this.clients = clients;
    }

    /**
     * <p>Retrieveing Clients object and setting the aggregate of payment places</p>
     * @param clients
     * @param paymentCount
     */
    DaemonClient(Clients clients, int paymentCount) {
        this.clients = clients;
        pm = new Payment[paymentCount];
    }

    /**
     * <p>Setting aggregate of payment places</p>
     * @param paymentCount
     */
    public void setPaymentCount(int paymentCount) {
        pm = new Payment[paymentCount];
    }

    @Override
    public void run() {
        while(clients.getCount() != 0) {
            /** Dividing the aggregate of clients for each payment place **/
            int count = Math.round(clients.getCount()/pm.length);

            /** Checking if Thread is started **/
            if (isStarted == false) {

                /** Creating the payment threads **/
                for (int i = 0; i < pm.length; i++) {
                    pm[i] = new Payment(count, clients);
                }

                /** Starting the payment threads **/
                for (int i = 0; i < pm.length; i++) {
                    pm[i].start();
                }

                System.out.println("Кассы открылись, клиенты идут!!!");
                isStarted = true;

            } else {
                try {
                    /** Time for checking the aggregate of clients**/
                    Thread.sleep(1000);

                    /** Dividing all clients to each payment place so that everywhere will be equal **/
                    for (int i = 0; i < pm.length; i++) {
                        pm[i].setClientCount(count);
                    }

                    System.out.println(clients.getCount());

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }
}