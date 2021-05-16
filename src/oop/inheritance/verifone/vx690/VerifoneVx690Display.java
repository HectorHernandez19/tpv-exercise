package oop.inheritance.verifone.vx690;

import oop.inheritance.core.TPVDisplay;

public class VerifoneVx690Display implements TPVDisplay {
    private boolean lightTurnedOn;
    //Lazy initialization
    private static VerifoneVx690Display uniqueInstance;

    //Con esto hacemos que mo se puedan crear instancias desde cualquier lado
    private VerifoneVx690Display(){
    }

    public static VerifoneVx690Display getInstance(){
        if(uniqueInstance == null){
            synchronized (VerifoneVx690Display.class){
                if(uniqueInstance == null)
                    uniqueInstance = new VerifoneVx690Display();
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
