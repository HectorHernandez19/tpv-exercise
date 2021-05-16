package oop.inheritance.ingenico;

import oop.inheritance.core.TPVDisplay;

public class IngenicoDisplay implements TPVDisplay {
    private boolean lightTurnedOn;
    //Lazy initialization
    private static IngenicoDisplay uniqueInstance;

    //Con esto hacemos que mo se puedan crear instancias desde cualquier lado
    private IngenicoDisplay(){
    }

    public static IngenicoDisplay getInstance(){
        if(uniqueInstance == null){
            synchronized (IngenicoDisplay.class){
                if(uniqueInstance == null)
                    uniqueInstance = new IngenicoDisplay();
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
