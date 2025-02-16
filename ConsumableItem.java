package com.Yohith;

import java.util.Scanner;

public class ConsumableItem extends Item{

    public ConsumableItem() {
        getInput();
        calculateWeight();
    }

    public ConsumableItem(String name, int weight, String type, int quantity) {
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.quantity = quantity;
        calculateWeight();
    }

    private void setQuantity(int quantity){
        this.quantity = quantity;
    }

    private int getQuantity(){
        return quantity;
    }

    private void setEachItemWeight(int eachItemWeight){
        this.eachItemWeight = eachItemWeight;
    }

    private int getEachItemWeight(){
        return eachItemWeight;
    }

    @Override
    public void getInput() {
        super.getInput();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter quantity of item = ");
        setQuantity(input.nextInt());
        System.out.println();
        printDesign();
    }

    private void printDesign(){
        System.out.println("      _____\n" +
                "     `.___,'\n" +
                "      (___)\n" +
                "      <   >\n" +
                "       ) (\n" +
                "      /`-.\\\n" +
                "     /     \\\n" +
                "    / _    _\\\n" +
                "   :,' `-.' `:\n" +
                "   |         |\n" +
                "   :         ;\n" +
                "    \\       /\n" +
                "     `.___.'");
        System.out.println();
        System.out.print("     _____\n" +
                "    [IIIII]\n" +
                "     )\"\"\"(\n" +
                "    /     \\\n" +
                "   /       \\\n" +
                "   |`-...-'|\n" +
                "   |asprin |\n" +
                " _ |`-...-'j    _\n" +
                "(\\)`-.___.(I) _(/)\n" +
                "  (I)  (/)(I)(\\)\n" +
                "     (I)        ");
        System.out.println();
        System.out.println();
    }
    private void calculateWeight(){
        int totalWeight = (weight*quantity);
        setEachItemWeight(totalWeight);
    }

    @Override
    public void print(){
        super.print();
        System.out.println("Quantity\t\t: " + getQuantity());
        System.out.println("Total Weight\t: " + getEachItemWeight());
        System.out.println();
    }

    @Override
    public String getInfo(){
        super.getInfo();
        return ("Name\t\t\t: " + getName()
                + "\nWeight\t\t\t: " +   getWeight()
                + "\nType\t\t\t: " + getType()
                + "\nQuantity\t\t: " + getQuantity()
                + "\nTotal Weight\t: " + getEachItemWeight());
    }

    @Override
    public String forFileWrite(){
        super.forFileWrite();
        return (getName() + "\n" + getWeight() + "\n" + getType() + "\n" + getQuantity() );
    }
}
