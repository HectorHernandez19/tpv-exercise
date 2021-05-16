package oop.inheritance.verifone.vx520;

import oop.inheritance.core.TPVKeyboard;

public class VerifoneVx520Keyboard implements TPVKeyboard {
    private static VerifoneVx520Keyboard uniqueInstance;

    private VerifoneVx520Keyboard(){}

    public static VerifoneVx520Keyboard getInstance(){
        if(uniqueInstance == null){
            synchronized (VerifoneVx520Keyboard.class){
                if(uniqueInstance == null){
                    uniqueInstance = new VerifoneVx520Keyboard();
                }
            }
        }
        return uniqueInstance;
    }
    public String get(){
        return "Key pressed";
    }
}
