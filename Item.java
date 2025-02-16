package com.Yohith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Item {

    public String type, name;
    public int weight, quantity, eachItemWeight, damage, lDamage, ammoQuantity, ammoWeight;

    public static void main(String[] args) {

    }

    public Item() {

    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }

    public String getInfo(){
        return "override method";
    }

    public String forFileWrite(){
        return "override";
    }

    public void print(){
        System.out.println("Name\t\t\t: " + getName()
                + "\nWeight\t\t\t: " +   getWeight()
                + "\nType\t\t\t: " + getType());
    }

    public String toString() {
        return ("Item name: "+ name);
    }

    public void getInput(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name of item = ");
        setName(input.nextLine());
        System.out.print("Enter weight of item = ");
        setWeight(input.nextInt());
    }
}
