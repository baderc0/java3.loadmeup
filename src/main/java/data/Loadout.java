/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author andrei
 */
public class Loadout {
    ArrayList<LineItem> items;

    public Loadout() {
    }

    public Loadout(ArrayList<LineItem> items) {
        this.items = items;
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<LineItem> items) {
        this.items = items;
    }
    
    public void addItem(LineItem item){
        this.items.add(item);
    }
    public void removeItem(LineItem item){
        this.items.remove(item);
    }
    public double getTotalWeight(){
        double total = 0;
        for (LineItem item : this.items) {
            total += item.getTotalWeight();
        }
        return total;
    }
}
