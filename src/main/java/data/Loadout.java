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

    private ArrayList<LineItem> items;

    public Loadout() {
        this.items = new ArrayList<LineItem>();
    }

    public Loadout(ArrayList<LineItem> items) {
        this.items = items;
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public LineItem getItem(int index) {
        return this.items.get(index);
    }

    public void setItems(ArrayList<LineItem> items) {
        this.items = items;
    }

    public void addItem(LineItem item) {
        // if loadout is empty
        if (this.checkEmpty()) {
            this.items.add(item);
        } else { 
            int index = findIndex(item);
            if (index != -1) { // if item exists in the loadout already
                this.getItem(index).setQuantity(this.getItem(index).getQuantity() + 1); // increment quantity by 1
            } else {
                this.items.add(item);
            }
        }
    }

    public boolean checkEmpty() {
        return items.isEmpty();
    }

    public int findIndex(LineItem item) {
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getItem(i).getWeapon().getCode().equalsIgnoreCase(item.getWeapon().getCode())) { // if item already exists in the loadout
                return i;
            }
        }
        return -1;
    }

    public void removeItem(LineItem item) {
        for (int i = 0; i < this.items.size(); i++) {
            if (item.getWeapon().getCode().equals(this.items.get(i).getWeapon().getCode())) { // match
                LineItem removeItem = this.items.get(i); // get item from ArrayList that needs to be altered or removed
                if ((removeItem.getQuantity() - 1) > 0) { // if removing would result in a quantity of greater than 0
                    this.items.get(i).setQuantity(this.items.get(i).getQuantity() - 1); // decrement quantity by one
                } else {
                    this.items.remove(i); // remove item from ArrayList altogether
                }
            }
        }
    }

    public int getSize() {
        return this.items.size();
    }

    public double getTotalWeight() {
        double total = 0;
        for (LineItem item : this.items) {
            total += item.getTotalWeight();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Loadout{" + "items=" + items + '}';
    }

}
