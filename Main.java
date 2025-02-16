package com.Yohith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//General information about the game:
//This Item game runs well assuming that the user inputs coreect data/primitive types for each attribute if not then it will give error message
//The extra Creativity and Enhancements made to this code is that the user can save their items ib bag and retrieve those items back
//next time they play the game. A money system is also added, whenever the user adds items certain amount of money reduces. If the user runs out
//of money then the user can't add more items anymore, the game would ask the user if they want to sell one of their items or not. If user wants
//wants to load previously saved game data after starting a new game then the game would ask if the user wished to owerwrite the current items in
//bag or not. Before quiting the game, if the user has items in the bag, then the game would ask if the user wants to save the items or not.
//Everytime the user saves the items after finishing the game, it will overwrite previously saved data. Different text files are used to

//How saving the items are done:
//Different text files are created one for each type of item. Then the data from the ArrayList of items is written to the respective text files.
//When loading back previous data then the game reads data stored from respective files. An extra text file called item.txt is created and writes
//items data as the same format as viewAllItems() method so that if user wants to print items list on a paper or something, they can do it.
//Learnt from multiple internet and YouTube sources.

//Text art are taken from:    https://fsymbols.com/text-art/
//                            https://asciiart.website/index.php?art=objects/bottles
//                            https://www.asciiart.eu/weapons/swords

//What the user has to know before playing the game?
//Each time a game is started the user is given 100 money, where they can spend it by adding items into their bag.
//Price of Consumable Items is 10 money.
//Price of Weapon is 20 money.
//Price of Long Range Weapon is 30 money.


public class Main {

    public static ArrayList<Item> items = new ArrayList<Item>();
    public int money = 100;

    public static void main(String[] args) {
        //Test code:
        Main dummy = new Main(); // creating dummy object to test the code
        dummy.actionInput();
    }

    private String userInputSearchItem(String message){
        System.out.println();
        System.out.print(message);
        Scanner input = new Scanner(System.in);
        String itemToBeSearched = input.nextLine().toLowerCase();
        return itemToBeSearched;
    }

    private int getMoney(){
        return money;
    }

    private int returnChoiceType() {
        int choice;
        while (true){
            Scanner input = new Scanner(System.in);
            System.out.print("Enter type of item = ");
            String inputType = input.nextLine();
            if (inputType.toLowerCase().equals("consumableitem") || inputType.toLowerCase().equals("consumable item")){
                choice = 1;
                System.out.println();
                System.out.println("\n" +
                        "███████████████████████████████████████████████████████████████████████████████████████████\n" +
                        "█─▄▄▄─█─▄▄─█▄─▀█▄─▄█─▄▄▄▄█▄─██─▄█▄─▀█▀─▄██▀▄─██▄─▄─▀█▄─▄███▄─▄▄─███▄─▄█─▄─▄─█▄─▄▄─█▄─▀█▀─▄█\n" +
                        "█─███▀█─██─██─█▄▀─██▄▄▄▄─██─██─███─█▄█─███─▀─███─▄─▀██─██▀██─▄█▀████─████─████─▄█▀██─█▄█─██\n" +
                        "▀▄▄▄▄▄▀▄▄▄▄▀▄▄▄▀▀▄▄▀▄▄▄▄▄▀▀▄▄▄▄▀▀▄▄▄▀▄▄▄▀▄▄▀▄▄▀▄▄▄▄▀▀▄▄▄▄▄▀▄▄▄▄▄▀▀▀▄▄▄▀▀▄▄▄▀▀▄▄▄▄▄▀▄▄▄▀▄▄▄▀");
                System.out.println();
                break;
            }
            else if (inputType.toLowerCase().equals("weapon")){
                choice = 2;
                System.out.println();
                System.out.println("\n" +
                        "██████████████████████████████████████████\n" +
                        "█▄─█▀▀▀█─▄█▄─▄▄─██▀▄─██▄─▄▄─█─▄▄─█▄─▀█▄─▄█\n" +
                        "██─█─█─█─███─▄█▀██─▀─███─▄▄▄█─██─██─█▄▀─██\n" +
                        "▀▀▄▄▄▀▄▄▄▀▀▄▄▄▄▄▀▄▄▀▄▄▀▄▄▄▀▀▀▄▄▄▄▀▄▄▄▀▀▄▄▀");
                System.out.println();
                break;
            }
            else if (inputType.toLowerCase().equals("longrangeweapon") || inputType.toLowerCase().equals("long range weapon")){
                choice = 3;
                System.out.println();
                System.out.println("\n" +
                        "████████████████████████▀███████████████████████████▀██████████████████████████████████████████████████\n" +
                        "█▄─▄███─▄▄─█▄─▀█▄─▄█─▄▄▄▄███▄─▄▄▀██▀▄─██▄─▀█▄─▄█─▄▄▄▄█▄─▄▄─███▄─█▀▀▀█─▄█▄─▄▄─██▀▄─██▄─▄▄─█─▄▄─█▄─▀█▄─▄█\n" +
                        "██─██▀█─██─██─█▄▀─██─██▄─████─▄─▄██─▀─███─█▄▀─██─██▄─██─▄█▀████─█─█─█─███─▄█▀██─▀─███─▄▄▄█─██─██─█▄▀─██\n" +
                        "▀▄▄▄▄▄▀▄▄▄▄▀▄▄▄▀▀▄▄▀▄▄▄▄▄▀▀▀▄▄▀▄▄▀▄▄▀▄▄▀▄▄▄▀▀▄▄▀▄▄▄▄▄▀▄▄▄▄▄▀▀▀▀▄▄▄▀▄▄▄▀▀▄▄▄▄▄▀▄▄▀▄▄▀▄▄▄▀▀▀▄▄▄▄▀▄▄▄▀▀▄▄▀");
                System.out.println();
                break;
            }
            else {
                System.out.println();
                System.out.println("Invalid type of item!");
                System.out.println("Please enter \"ConsumableItem\" or \"Weapon\" or \"LongRangeWeapon\" only !!!");
                System.out.println();
            }
        }
        return choice;
    }

    private void addItem(Item item) {
        items.add(item);
    }

    private void toCreateItem() {
        int number = returnChoiceType();
        if (number == 1 && money>=10) {
            ConsumableItem objectItem = new ConsumableItem();
            money -= 10;
            objectItem.setType("Consumable Item");
            addItem(objectItem);
            System.out.println("Consumable Item " + "\"" + objectItem.name + "\"" + " added to bag.");
            printRemainingMoney();
        } else if (number == 2 && money>=20) {
            Weapon objectItem = new Weapon();
            money -= 20;
            objectItem.setType("Weapon");
            addItem(objectItem);
            System.out.println("Weapon " + "\"" + objectItem.name + "\"" + " added to bag.");
            printRemainingMoney();
        } else if (number == 3 && money>=30) {
            LongRangeWeapon objectItem = new LongRangeWeapon();
            money -= 30;
            objectItem.setType("Long Range Weapon");
            addItem(objectItem);
            System.out.println("Long Range Weapon " + "\"" + objectItem.name + "\"" + " added to bag.");
            printRemainingMoney();
        }else {
            sellItem();
        }
    }

    private void sellItem(){
        Scanner input = new Scanner(System.in);
        System.out.println("Not enough money! Do you want to sell any item ?");
        System.out.print("Enter yes or no: ");
        String yesOrNo = input.nextLine();
        if (yesOrNo.toLowerCase().equals("yes")){
            removeItem();
        }
    }

    private void removeItem(){
        while (true) {
            boolean got = true;
            Scanner input = new Scanner(System.in);
            System.out.print("Enter name of item to be sold: ");
            String itemName = input.nextLine();
            for (Item item : items) {
                if (itemName.toLowerCase().equals(item.getName().toLowerCase())) {
                    if (item.getType().toLowerCase().equals("consumableitem")) {
                        money += 10;
                    } else if (item.getType().toLowerCase().equals("weapon")) {
                        money += 20;
                    } else if (item.getType().toLowerCase().equals("long range weapon")) {
                        money  = getMoney() + 30;
                    }
                    System.out.println("Item " + item.getName() + " is sold.");
                    System.out.println();
                    items.remove(item);
                    got = false;
                    break;
                }
            }
            if (got){
                System.out.println();
                System.out.println("Item " + itemName + " not found in bag!");
                System.out.println("Try again!");
                System.out.println();
            }
            else {
                System.out.println("Do you to sell another item?");
                System.out.print("Enter yes or no: ");
                String yesOrNo = input.nextLine();
                if (yesOrNo.toLowerCase().equals("no")){
                    break;
                }
            }

        }
        System.out.println("Your money now is: " + getMoney());
    }

    private void printRemainingMoney(){
        System.out.println("Remaining money: " + getMoney());
    }

    private void printTotalItemsWeight(){
        System.out.println("Total Items Weight : " + calculateTotalWeight());
    }

    private boolean checkNumberOfItemsInList(){
        return items.size() != 0;
    }

    private int calculateTotalWeight() {
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.eachItemWeight;
        }
        return totalWeight;
    }

    private void searchItem(){
        String query = userInputSearchItem("Name of item to be searched = ").toLowerCase();
        String[] splitQuery = query.toLowerCase().split(" ");
        int matches = 0;
        boolean got = true;
        System.out.println();
        System.out.print("Items in bag matching your search: ");
        System.out.println();
        for (Item item: items) {
            if (Arrays.stream(splitQuery).allMatch(item.getName().toLowerCase()::contains)) { //https://stackoverflow.com/a/5100817
                System.out.println();
                System.out.println("Item: " + item.getName());
                matches++;
                got= false;
            }
        }
        if (got){
            System.out.println("None!");
        }
        System.out.println();
        System.out.println("Matches = " + matches);
    }

    private void viewAllItem(){
        int count = 0;
        for (Item item:items){
            count += 1;
            System.out.println();
            System.out.println();
            System.out.println("Item " + count);
            item.print();
        }
    }

    private void actionInput() {
        while (true){
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println("1. Add item to bag");
            System.out.println("2. View all items in bag");
            System.out.println("3. Search for items in bag");
            System.out.println("4. Quit");
            System.out.println("5. Load previous game");
            System.out.print("Enter your choice number: ");
            int choiceNumber = input.nextInt();
            if (choiceNumber == 1) {
                System.out.println();
                System.out.println("There are three types of item that can be added: \t \"ConsumableItem\"    or    \"Weapon\"    or    \"LongRangeWeapon\"");
                toCreateItem();
            }
            else if (choiceNumber == 2) {
                if (checkNumberOfItemsInList()) {
                    viewAllItem();
                    printTotalItemsWeight();
                    printRemainingMoney();
                }
                else {
                    System.out.println();
                    System.out.println("No items in bag!" + "\nAdd items to bag first!");
                }
            }
            else if (choiceNumber == 3) {
                searchItem();
            }
            else if (choiceNumber == 4){
                quitGame();
                break;
            }
            else if (choiceNumber == 5){
                try {
                    Scanner reader = new Scanner(new File("items.txt"));
                    if (reader.hasNext()) {
                        if (items.isEmpty()) {
                            readConsumableItemTextFile();
                            readWeaponTextFile();
                            readLongRangeWeaponTextFile();
                            readMoneyTextFile();
                            System.out.println();
                            System.out.println("Last saved game data loaded...");
                        } else {
                            System.out.println("Loading data from previously saved game will make you lose items in the bag and money now.");
                            while (true) {
                                Scanner inp = new Scanner(System.in);
                                System.out.print("Are you sure you want to load previous data? : ");
                                String yesOrNo = inp.nextLine();
                                if (yesOrNo.toLowerCase().equals("yes")) {
                                    items.clear();
                                    readConsumableItemTextFile();
                                    readWeaponTextFile();
                                    readLongRangeWeaponTextFile();
                                    readMoneyTextFile();
                                    System.out.println();
                                    System.out.println("Last saved game data loaded...");
                                    break;
                                } else if (yesOrNo.toLowerCase().equals("no")) {
                                    break;
                                } else {
                                    System.out.println("Invalid input! Try again!");
                                }
                            }
                        }
                    } else {
                        System.out.println("No available previous game data that can be loaded!");
                    }
                }
                catch (FileNotFoundException fnf){
                    System.out.println("File was not found!");
                }

            }
        }
    }

    private void createConsumableItemTextFile(){
        try {
            File itemFile = new File("ConsumableItem.txt");
            PrintStream writer = new PrintStream(itemFile);
            int count = 0;
            for (Item item : items) {
                if (item.getType().toLowerCase().equals("consumable item")) {
                    count += 1;
                    writer.println(item.forFileWrite());
                }
            }
            writer.close();
        }
        catch (FileNotFoundException fnf){
            System.out.println("The file was not found.");
        }
    }

    private void readConsumableItemTextFile() {

        try {
            Scanner input = new Scanner(new File("ConsumableItem.txt"));
            while(input.hasNext()) {
                String name = input.nextLine();
                int weight = Integer.parseInt(input.nextLine());
                String type = input.nextLine();
                int quantity = Integer.parseInt(input.nextLine());
                items.add(new ConsumableItem(name,weight,type,quantity));
                //System.out.println(name + " " + weight+ " " + type+ " " + quantity);
            }
        }
        catch (FileNotFoundException fnf){
            System.out.println("The file was not found. No previous game data.");
        }

    }

    private void createWeaponTextFile(){
        try {
            File itemFile = new File("Weapon.txt");
            PrintStream writer = new PrintStream(itemFile);
            int count = 0;
            for (Item item : items) {
                if (item.getType().toLowerCase().equals("weapon")) {
                    count += 1;
                    writer.println(item.forFileWrite());
                }
            }
            writer.close();
        }
        catch (FileNotFoundException fnf){
            System.out.println("The file was not found.");
        }
    }

    private void readWeaponTextFile() {

        try {
            Scanner input = new Scanner(new File("Weapon.txt"));
            while(input.hasNext()) {
                String name = input.nextLine();
                int weight = Integer.parseInt(input.nextLine());
                String type = input.nextLine();
                int damage = Integer.parseInt(input.nextLine());
                items.add(new Weapon(name,weight,type,damage));
            }
        }
        catch (FileNotFoundException fnf){
            System.out.println("The file was not found. No previous game data.");
        }

    }

    private void createLongRangeWeaponTextFile(){
        try {
            File itemFile = new File("LongRangeWeapon.txt");
            PrintStream writer = new PrintStream(itemFile);
            int count = 0;
            for (Item item : items) {
                if (item.getType().toLowerCase().equals("long range weapon")) {
                    count += 1;
                    writer.println(item.forFileWrite());
                }
            }
            writer.close();
        }
        catch (FileNotFoundException fnf){
            System.out.println("The file was not found.");
        }
    }

    private void readLongRangeWeaponTextFile() {

        try {
            Scanner input = new Scanner(new File("LongRangeWeapon.txt"));
            while(input.hasNext()) {
                String name = input.nextLine();
                int weight = Integer.parseInt(input.nextLine());
                String type = input.nextLine();
                int lDamage = Integer.parseInt(input.nextLine());
                int ammoQuantity = Integer.parseInt(input.nextLine());
                int ammoWeight = Integer.parseInt(input.nextLine());
                items.add(new LongRangeWeapon(name,weight,type,lDamage,ammoQuantity,ammoWeight));
                //System.out.println(name + " " + weight+ " " + type+ " " + quantity);
            }
        }
        catch (FileNotFoundException fnf){
            System.out.println("The file was not found. No previous game data.");
        }

    }

    private void createMoneyTextFile(){
        try {
            File itemFile = new File("Money.txt");
            PrintStream writer = new PrintStream(itemFile);
            int count = 0;
            writer.println(getMoney());
            writer.close();
        }
        catch (FileNotFoundException fnf){
            System.out.println("The file was not found.");
        }
    }

    private void readMoneyTextFile() {

        try {
            Scanner input = new Scanner(new File("Money.txt"));
            while(input.hasNext()) {
                money = Integer.parseInt(input.nextLine());
            }
        }
        catch (FileNotFoundException fnf){
            System.out.println("The file was not found. No previous game data.");
        }

    }

    private void createItemTextFile(){
        try {
            File itemFile = new File("items.txt");
            PrintStream writer = new PrintStream(itemFile);
            int count = 0;
            for (Item item : items) {
                count += 1;
                writer.println("");
                writer.println("Item " + count);
                writer.println("-------");
                writer.println(item.getInfo());
            }
            writer.close();
        }
        catch (FileNotFoundException fnf){
            System.out.println("The file was not found.");
        }
    }

    private void askUserToSaveOrNot(){
        System.out.println();
        System.out.println("Do you want to save your items before quiting?" + "\nEnter \"Yes\" or \"No\"");
        while (true) {
            Scanner input = new Scanner(System.in);
            String yesOrNo = input.nextLine();
            if (yesOrNo.toLowerCase().equals("yes")) {
                createItemTextFile();
                createConsumableItemTextFile();
                createWeaponTextFile();
                createLongRangeWeaponTextFile();
                createMoneyTextFile();
                System.out.println("Item list is saved in file = \"items.txt\"");
                System.out.println("Thanks for playing !");
                break;
            } else if (yesOrNo.toLowerCase().equals("no")) {
                System.out.println();
                System.out.println("Thanks for playing !");
                break;
            } else {
                System.out.println("Invalid entry");
                System.out.println("Please enter \"Yes\" or \"No\".");
                System.out.println();
            }
        }
    }

    private void quitGame(){
        if (checkNumberOfItemsInList()){
            askUserToSaveOrNot();
        }
        else{
            System.out.println();
            System.out.println("Thanks for playing !");
        }
    }
}
