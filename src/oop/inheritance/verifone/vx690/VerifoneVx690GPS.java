package oop.inheritance.verifone.vx690;

import oop.inheritance.core.TPVGPS;
import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;

public class VerifoneVx690GPS implements TPVGPS {
    private static VerifoneVx690GPS uniqueInstance;

    private VerifoneVx690GPS(){}

    public static VerifoneVx690GPS getInstance(){
        if(uniqueInstance == null){
            synchronized (VerifoneVx690GPS.class){
                if(uniqueInstance == null){
                    uniqueInstance = new VerifoneVx690GPS();
                }
            }
        }
        return uniqueInstance;
    }
    /**
     * Opens a connection using the GPS device
     *
     * @return true if the connection was successfully opened
     */
    public boolean open() {

        return true;
    }

    /**
     * Sends a message to the server
     *
     * @param message message to be sent to the server
     * @return true if the message was sent successfully, false otherwise
     */
    public boolean send(Transaction message) {
        return true;
    }

    /**
     * Method blocks until host send a response or until a timeout is reached.
     *
     * @return Message received from the host. In case of timeout it returns null
     */
    public TransactionResponse receive() {
        return new TransactionResponse(true, "132123");
    }

    /**
     * Closes the channel releasing every used resources
     */
    public void close() {

    }
}
