package oop.inheritance.verifone.vx690;

import oop.inheritance.core.TPVKeyboard;

public class VerifoneVx690Keyboard implements TPVKeyboard {
    private static VerifoneVx690Keyboard uniqueInstance;

    private VerifoneVx690Keyboard(){}

    public static VerifoneVx690Keyboard getInstance(){
        if(uniqueInstance == null){
            synchronized (VerifoneVx690Keyboard.class){
                if(uniqueInstance == null){
                    uniqueInstance = new VerifoneVx690Keyboard();
                }
            }
        }
        return uniqueInstance;
    }
    public String get(){
        return "Key pressed";
    }
}
