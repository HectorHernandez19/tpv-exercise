package oop.inheritance.core;

import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;

public interface TPVModem {
    boolean open();
    boolean send(Transaction message);
    TransactionResponse receive();
    void close();
}