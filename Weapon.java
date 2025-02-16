package com.Yohith;

import java.util.Scanner;

public class Weapon extends Item{
    public Weapon(){ //This constructor gets user input for each attribute and sets them, it also calculates weight and sets them.
        getInput();
        calculateWeight();
    }

    public Weapon(String name, int weight, String type, int damage) {
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.damage = damage;
        calculateWeight();
    }

    private void setDamage(int damage){
        this.damage = damage;
    }

    private int getDamage(){
        return damage;
    }

    private void setItemWeight(int weight){
        this.weight = weight;
    }

    private int getEachItemWeight(){
        return eachItemWeight;
    }

    @Override
    public void getInput(){
        super.getInput();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter damage of Weapon = ");
        setDamage(input.nextInt());
        System.out.println();
        printDesign();

    }

    private void printDesign(){
        System.out.println("              />\n" +
                " (           //------------------------------------------------------(\n" +
                "(*)OXOXOXOXO(*>                  --------                             \\\n" +
                " (           \\\\--------------------------------------------------------)\n" +
                "              \\>");;
        System.out.println();
        System.out.println(" _________________.---.______\n" +
                "(_(______________(_o o_(____()\n" +
                "             .___.'. .'.___.\n" +
                "             \\ o    Y    o /\n" +
                "              \\ \\__   __/ /\n" +
                "               '.__'-'__.'\n" +
                "                   '''");
        System.out.println();
    }

    private void calculateWeight(){
        eachItemWeight = weight;
        setItemWeight(eachItemWeight);
    }

    @Override
    public void print(){
        super.print();
        System.out.println("Damage\t\t\t: " + getDamage());
        System.out.println("Total Weight\t: " + getEachItemWeight());
        System.out.println();
    }

    @Override
    public String getInfo(){
        super.getInfo();
        return ("Name\t\t\t: " + getName()
                + "\nWeight\t\t\t: " +   getWeight()
                + "\nType\t\t\t: " + getType()
                + "\nDamage\t\t\t: " + getDamage()
                + "\nTotal Weight\t: " + getEachItemWeight());
    }

    @Override
    public String forFileWrite(){
        super.forFileWrite();
        return (getName() + "\n" + getWeight() + "\n" + getType() + "\n" + getDamage() );
    }
}
