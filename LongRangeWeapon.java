package com.Yohith;

import java.util.Scanner;

public class LongRangeWeapon extends Item{
    public LongRangeWeapon(){
        getInput();
        calculateWeight();
    }

    public LongRangeWeapon(String name, int weight, String type, int lDamage, int ammoQuantity, int ammoWeight ) {
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.lDamage = lDamage;
        this.ammoQuantity = ammoQuantity;
        this.ammoWeight = ammoWeight;
        calculateWeight();
    }

    private void setlDamage(int lDamage){
        this.lDamage = lDamage;
    }

    private int getlDamage(){
        return lDamage;
    }

    private void setAmmoQuantity(int ammoQuantity){
        this.ammoQuantity = ammoQuantity;
    }

    private int getAmmoQuantity(){
        return ammoQuantity;
    }

    private void setAmmoWeight(int ammoWeight){
        this.ammoWeight = ammoWeight;
    }

    private int getAmmoWeight(){
        return ammoWeight;
    }

    private void setEachItemWeight(int eachItemWeight){
        this.eachItemWeight = eachItemWeight;
    }

    private int getEachItemWeight(){
        return eachItemWeight;
    }

    @Override
    public void getInput(){
        super.getInput();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter damage of Long Range Weapon = ");
        setlDamage(input.nextInt());
        System.out.print("Enter ammo quantity of Long Range Weapon = ");
        setAmmoQuantity(input.nextInt());
        System.out.print("Enter ammo weight of Long Range Weapon = ");
        setAmmoWeight(input.nextInt());
        System.out.println();
        printDesign();
    }

    private void printDesign(){
        System.out.println("                     ,1             ,-===========.\n" +
                "                    /,| ___________((____________\\\\_                _\n" +
                " ,========.________//_|/===========._#############L_Y_....-----====//\n" +
                "(#######(==========\\################\\=======.______ --############((\n" +
                " `=======`\"        ` ===============|::::.___|[ ))[JW]#############\\\\\n" +
                "                                    |####|     \"\"\\###|   :##########\\\\\n" +
                "                                   /####/         \\##\\     ```\"\"\"=,,,))\n" +
                "                                  /####/           \\##\\\n" +
                "                                 '===='             `=`");

        System.out.println();
        System.out.println("                                      ____    _     __     _    ____\n" +
                "                                     |####`--|#|---|##|---|#|--'##|#|\n" +
                "   _                                 |____,--|#|---|##|---|#|--.__|_|\n" +
                " _|#)_____________________________________,--'EEEEEEEEEEEEEE'_=-.\n" +
                "((_____((_________________________,--------[JW](___(____(____(_==)        _________\n" +
                "                               .--|##,----o  o  o  o  o  o  o__|/`---,-,-'=========`=+==.\n" +
                "                               |##|_Y__,__.-._,__,  __,-.___/ J \\ .----.#############|##|\n" +
                "                               |##|              `-.|#|##|#|`===l##\\   _\\############|##|\n" +
                "                              =======-===l          |_|__|_|     \\##`-\"__,=======.###|##|\n" +
                "                                                                  \\__,\"          '======'");
        System.out.println();
    }

    private void calculateWeight(){
        int ItemTotalWeight = weight + (ammoQuantity*ammoWeight);
        setEachItemWeight(ItemTotalWeight);
    }

    @Override
    public void print(){
        super.print();
        System.out.println("Damage\t\t\t: " + getlDamage());
        System.out.println("Ammo Quantity\t: " + getAmmoQuantity());
        System.out.println("Ammo Weight\t\t: " + getAmmoWeight());
        System.out.println("Total Weight\t: " + getEachItemWeight());
        System.out.println();
    }

    @Override
    public String getInfo(){
        super.getInfo();
        return ("Name\t\t\t: " + getName()
                + "\nWeight\t\t\t: " +   getWeight()
                + "\nType\t\t\t: " + getType()
                + "\nDamage\t\t\t: " + getlDamage()
                + "\nAmmo Quantity\t: " + getAmmoQuantity()
                + "\nAmmo Weight\t\t: " + getAmmoWeight()
                + "\nTotal Weight\t: " + getEachItemWeight());
    }

    @Override
    public String forFileWrite(){
        super.forFileWrite();
        return (getName() + "\n" + getWeight() + "\n" + getType() + "\n" + getlDamage() + "\n" + getAmmoQuantity() + "\n" + getAmmoWeight());
    }
}
