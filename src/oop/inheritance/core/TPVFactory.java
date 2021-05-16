package oop.inheritance.core;

import oop.inheritance.data.SupportedTerminal;
import oop.inheritance.ingenico.*;
import oop.inheritance.verifone.v240m.*;
import oop.inheritance.verifone.vx520.*;
import oop.inheritance.verifone.vx690.*;

public class TPVFactory {
    private SupportedTerminal supportedTerminal;

    public TPVFactory(SupportedTerminal supportedTerminal){
        this.supportedTerminal = supportedTerminal;
    }

    public TPVDisplay getDisplayInstance(){
        if(supportedTerminal == SupportedTerminal.INGENICO) {
            return IngenicoDisplay.getInstance();
        }
        else if (supportedTerminal == SupportedTerminal.VERIFONE_240) {
            return VerifoneV240mDisplay.getInstance();
        }
        else if (supportedTerminal == SupportedTerminal.VERIFONE_520){
            return VerifoneVx520Display.getInstance();
        }
        else if (supportedTerminal == SupportedTerminal.VERIFONE_690){
            return VerifoneVx690Display.getInstance();
        }
        return null;
    }
    public TPVKeyboard getKeyboardInstance(){
        if(supportedTerminal == SupportedTerminal.INGENICO) {
            return IngenicoKeyboard.getInstance();
        }
        else if (supportedTerminal == SupportedTerminal.VERIFONE_240) {
            return VerifoneV240mKeyboard.getInstance();
        }
        else if (supportedTerminal == SupportedTerminal.VERIFONE_520){
            return VerifoneVx520Keyboard.getInstance();
        }
        else if (supportedTerminal == SupportedTerminal.VERIFONE_690){
            return VerifoneVx690Keyboard.getInstance();
        }
        return null;
    }
    public TPVModem getModemInstance() {
        if (supportedTerminal == SupportedTerminal.INGENICO) {
            return IngenicoModem.getInstance();
        } else if (supportedTerminal == SupportedTerminal.VERIFONE_240) {
            return VerifoneV240mModem.getInstance();
        } else if (supportedTerminal == SupportedTerminal.VERIFONE_520) {
            return VerifoneVx520Modem.getInstance();
        } else if (supportedTerminal == SupportedTerminal.VERIFONE_690) {
            return VerifoneVx690Modem.getInstance();
        }
        return null;
    }
    public TPVEthernet getEthernetInstance() {
        if (supportedTerminal == SupportedTerminal.INGENICO) {
            return IngenicoEthernet.getInstance();
        } else if (supportedTerminal == SupportedTerminal.VERIFONE_240) {
            return VerifoneV240mEthernet.getInstance();
        } else if (supportedTerminal == SupportedTerminal.VERIFONE_520) {
            return VerifoneVx520Ethernet.getInstance();
        } else if (supportedTerminal == SupportedTerminal.VERIFONE_690) {
            return VerifoneVx690Ethernet.getInstance();
        }
        return null;
    }
    public TPVGPS getGPSInstance() {
        if (supportedTerminal == SupportedTerminal.INGENICO) {
            return IngenicoGPS.getInstance();
        } else if (supportedTerminal == SupportedTerminal.VERIFONE_240) {
            return VerifoneV240mGPS.getInstance();
        } else if (supportedTerminal == SupportedTerminal.VERIFONE_520) {
            return VerifoneVx520GPS.getInstance();
        } else if (supportedTerminal == SupportedTerminal.VERIFONE_690) {
            return VerifoneVx690GPS.getInstance();
        }
        return null;
    }

}
