package oop.inheritance.verifone.vx520;

import oop.inheritance.core.TPVDisplay;

public class VerifoneVx520Display implements TPVDisplay {
    private boolean lightTurnedOn;
    //Lazy initialization
    private static  VerifoneVx520Display uniqueInstance;

    //Con esto hacemos que mo se puedan crear instancias desde cualquier lado
    private VerifoneVx520Display(){
    }

    public static VerifoneVx520Display getInstance(){
        if(uniqueInstance == null){
            synchronized (VerifoneVx520Display.class){
                if(uniqueInstance == null)
                    uniqueInstance = new VerifoneVx520Display();
            }
        }
        return uniqueInstance;
    }
    /**
     * Prints a message to specied position
     *
     * @param x       horizontal position
     * @param y       vertical position
     * @param message message to be printed
     */
    public void showMessage(int x, int y, String message) {
    }
    @Override
    public void toogleLight(){
        lightTurnedOn = !lightTurnedOn;
    }


    /**
     * Clears the screen
     */
    public void clear() {

    }
}
