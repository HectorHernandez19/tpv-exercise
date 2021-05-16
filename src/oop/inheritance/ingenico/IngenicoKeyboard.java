package oop.inheritance.ingenico;

import oop.inheritance.core.TPVKeyboard;

public class IngenicoKeyboard implements TPVKeyboard {
    private static IngenicoKeyboard uniqueInstance;

    private IngenicoKeyboard(){}

    public static IngenicoKeyboard getInstance(){
        if(uniqueInstance == null){
            synchronized (IngenicoKeyboard.class){
                if(uniqueInstance == null){
                    uniqueInstance = new IngenicoKeyboard();
                }
            }
        }
        return uniqueInstance;
    }

    /**
     * @return key pressed
     */
    public String get() {
        return "Key pressed";
    }
}
