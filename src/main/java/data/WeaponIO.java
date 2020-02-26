/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author andrei
 */
public class WeaponIO {
    public static ArrayList<Weapon> getWeapons(String filepath) 
            throws IOException {
        ArrayList<Weapon> weapons = new ArrayList();
        File file = new File(filepath);
        Scanner read = new Scanner(file);
        while(read.hasNextLine()){
            String[] tokens = read.nextLine().split("|");
            weapons.add(new Weapon(tokens[0], tokens[1], Double.parseDouble(tokens[2])));
        }
    return weapons;
    }
}
