/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author andrei
 */
public class LineItem {
    private Weapon weapon;
    private int quantity;
    private double totalWeight;

    public LineItem() {
        
    }

    public LineItem(Weapon weapon, int quantity) {
        this.weapon = weapon;
        this.quantity = quantity;
        this.totalWeight = this.weapon.getWeight()*quantity;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.setQuantity(this.quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalWeight = this.weapon.getWeight()*quantity;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
    
    
}
