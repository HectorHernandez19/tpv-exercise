package oop.inheritance;

import java.time.LocalDateTime;

import oop.inheritance.core.*;
import oop.inheritance.data.Card;
import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.SupportedTerminal;
import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;
import oop.inheritance.ingenico.IngenicoCardSwipper;
import oop.inheritance.ingenico.IngenicoChipReader;
import oop.inheritance.ingenico.IngenicoDisplay;
import oop.inheritance.ingenico.IngenicoEthernet;
import oop.inheritance.ingenico.IngenicoGPS;
import oop.inheritance.ingenico.IngenicoKeyboard;
import oop.inheritance.ingenico.IngenicoModem;
import oop.inheritance.ingenico.IngenicoPrinter;
import oop.inheritance.verifone.v240m.VerifoneV240mDisplay;

public class Application {

    private CommunicationType communicationType = CommunicationType.ETHERNET;
    private SupportedTerminal supportedTerminal;
    private TPVFactory tpvFactory;

    public Application(SupportedTerminal supportedTerminal) {
        this.supportedTerminal = supportedTerminal;
    }

    public void showMenu() {
        TPVDisplay tpvDisplay = tpvFactory.getDisplayInstance();

        tpvDisplay.showMessage(5, 5, "MENU");
        tpvDisplay.showMessage(5, 10, "1. VENTA");
        tpvDisplay.showMessage(5, 13, "2. DEVOLUCION");
        tpvDisplay.showMessage(5, 16, "3. REPORTE");
        tpvDisplay.showMessage(5, 23, "4. CONFIGURACION");

    }

    public String readKey() {
        TPVKeyboard tpvKeyboard = tpvFactory.getKeyboardInstance();

        return tpvKeyboard.get();
    }

    public void doSale() {
        IngenicoCardSwipper cardSwipper = new IngenicoCardSwipper();
        IngenicoChipReader chipReader = new IngenicoChipReader();
        IngenicoDisplay ingenicoDisplay = IngenicoDisplay.getInstance();
        IngenicoKeyboard ingenicoKeyboard = IngenicoKeyboard.getInstance();
        Card card;

        do {
            card = cardSwipper.readCard();
            if (card == null) {
                card = chipReader.readCard();
            }
        } while (card == null);

        ingenicoDisplay.clear();
        ingenicoDisplay.showMessage(5, 20, "Capture monto:");

        String amount = ingenicoKeyboard.get(); //Amount with decimal point as string

        Transaction transaction = new Transaction();

        transaction.setLocalDateTime(LocalDateTime.now());
        transaction.setCard(card);
        transaction.setAmountInCents(Integer.parseInt(amount.replace(".", "")));

        TransactionResponse response = sendSale(transaction);

        if (response.isApproved()) {
            ingenicoDisplay.showMessage(5, 25, "APROBADA");
            printReceipt(transaction, response.getHostReference());
        } else {
            ingenicoDisplay.showMessage(5, 25, "DENEGADA");
        }
    }

    private void printReceipt(Transaction transaction, String hostReference) {
        IngenicoPrinter ingenicoPrinter = new IngenicoPrinter();
        Card card = transaction.getCard();

        ingenicoPrinter.print(5, "APROBADA");
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, card.getAccount());
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, "" + transaction.getAmountInCents());
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, "________________");

    }

    private TransactionResponse sendSale(Transaction transaction) {
        TPVModem modem = tpvFactory.getModemInstance();
        TPVEthernet ethernet = tpvFactory.getEthernetInstance();
        TPVGPS gps = tpvFactory.getGPSInstance();
        TransactionResponse transactionResponse = null;

        //Esto se puede mejorar, pero lo hare en otra ocasion
        switch (communicationType) {
            case ETHERNET:
                ethernet.open();
                ethernet.send(transaction);
                transactionResponse = ethernet.receive();
                ethernet.close();
                break;
            case GPS:
                gps.open();
                gps.send(transaction);
                transactionResponse = gps.receive();
                gps.close();
                break;
            case MODEM:
                modem.open();
                modem.send(transaction);
                transactionResponse = modem.receive();
                modem.close();
                break;
        }

        return transactionResponse;
    }

    public void doRefund() {
    }

    public void printReport() {
    }

    public void showConfiguration() {
    }

    public void clearScreen() {
        TPVDisplay tpvDisplay = tpvFactory.getDisplayInstance();
        tpvDisplay.clear();
    }
}
