package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Block {
    private int x;
    private int y;
    public static final int MAX = 7;
    private List<Observer> observers;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        this.observers = new ArrayList<>();
    }

    public void register(Observer observer){
        observers.add(observer);
    }
    
    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
    
    
    public void left() {
        if (x == 1) return;
        x--;
        changed();
    }

    public void right() {
        if (x == MAX) return;
        x++;
        changed();
    }    
    
    public void down() {
        if (y == 1) return;
        y--;
        changed();
    }
    
    public void up() {
        if (y == MAX) return;
        y++;
        changed();
    }    

    private void changed() {
        for (Observer observer : observers){
            observer.changed();
        }
    }
    
    public interface Observer {
        public void changed();
    }
    


    
    
}
