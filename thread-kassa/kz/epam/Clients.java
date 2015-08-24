package kz.epam;

/**
 * <h1>Class of clients</h1>
 * Created by MRSPEC on 24/08/2015.
 */
public class Clients {
    private static volatile int count;

    Clients() {

    }

    /**
     * <p>Setting the aggregate of all clients</p>
     * @param count
     */
    Clients(int count) {
        this.count = count;
    }

    /**
     * <p>Setting the aggregate of all clients</p>
     * @param count
     */
    public synchronized void setCount(int count) {
        if(count >= 0)
            this.count = count;
    }

    /**
     * <p>Getting the aggregate of clients</p>
     * @return
     */
    public int getCount() {
        return this.count;
    }
}
