package oop.inheritance.verifone.v240m;

import oop.inheritance.core.TPVKeyboard;

public class VerifoneV240mKeyboard implements TPVKeyboard {
    private static VerifoneV240mKeyboard uniqueInstance;

    private VerifoneV240mKeyboard(){}

    public static VerifoneV240mKeyboard getInstance(){
        if(uniqueInstance == null){
            synchronized (VerifoneV240mKeyboard.class){
                if(uniqueInstance == null){
                    uniqueInstance = new VerifoneV240mKeyboard();
                }
            }
        }
        return uniqueInstance;
    }
    public String get(){
        return "Key pressed";
    }
}
