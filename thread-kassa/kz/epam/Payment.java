package kz.epam;

/**
 * <h1>Class of payment place, that is working with clients</h1>
 * Created by MRSPEC on 24/08/2015.
 */
public class Payment extends Thread {
    private int clientCount;
    private Clients clients;

    /**
     * <p>Clients count in payment, and clients object</p>
     * @param clientCount
     * @param clients
     */
    Payment(int clientCount, Clients clients) {
        this.clientCount = clientCount;
        this.clients = clients;
    }

    public int clientCount() {
        return clientCount;
    }

    /**
     * <p>Set client count in the payment place</p>
     * @param clientCount
     * @throws InterruptedException
     */
    public synchronized void setClientCount(int clientCount) throws InterruptedException {
        if(this.clientCount != clientCount)
            System.out.println("В кассе " + Thread.currentThread().getId() + " количество клиентов стало " + clientCount + " человек");

        if(clients.getCount() > 0)
            this.clientCount = clientCount;
    }

    /**
     * <p>Decreasing clients in payment place also from the Clients object</p>
     * @throws InterruptedException
     */
    public void decreaseClientCount() throws InterruptedException{
        if(clientCount > 0) {
            /** 1000ms is time of payment place for working with each client **/
            Thread.sleep(1000);
            clientCount = clientCount - 1;
            clients.setCount(clients.getCount()-1);
            System.out.println("В кассе " + Thread.currentThread().getId() + " количество клиентов уменьшилось на " + clientCount + " человек");
        }
        this.yield();
    }

    @Override
    public void run() {

        while(clients.getCount() != 0) {
            try {
                this.decreaseClientCount();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}