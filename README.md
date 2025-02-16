# MMORPG Item Management System

This project is an item management system for an **MMORPG** game, developed as part of **Coursework 2** for the **Comp1202 - Programming 1** module. It allows players to manage different types of in-game items, such as **Consumable Items, Weapons, and Long-Range Weapons**, with features like weight calculation, item searching, and saving/loading game progress.

## 📌 Features
- **Item Management System**:
  - Supports **Consumable Items, Weapons, and Long-Range Weapons**.
  - Uses **inheritance and polymorphism** for efficient code design.
- **Interactive Menu**:
  - Add, view, and search for items in the player's inventory.
- **Weight Calculation**:
  - **Consumable Items**: `total weight = weight * quantity`
  - **Weapons**: `total weight = weight`
  - **Long-Range Weapons**: `total weight = weight + (ammoQuantity * ammoWeight)`
- **Money System**:
  - Players start with **100 money**.
  - Buying items reduces money.
  - Selling items restores money.
  - Players can't buy items if they run out of money.
- **Saving & Loading**:
  - Items are saved in text files and can be loaded in future sessions.
  - Players are asked whether to overwrite saved data when loading.
- **Case-Insensitive Item Search**:
  - Search works even if input contains extra spaces or different capitalization.
- **ASCII Art for Items**:
  - Each item type displays an ASCII art representation.

## 📜 Classes Overview
### **1. Item (Base Class)**
- Parent class for all items.
- Attributes: `name, weight, type`
- Methods: `getInput(), print(), getInfo()`

### **2. ConsumableItem (Extends Item)**
- Has a `quantity` attribute.
- Implements `calculateWeight()` as `weight * quantity`.
- Allows consumption to reduce quantity.

### **3. Weapon (Extends Item)**
- Has a `damage` attribute.
- Implements `calculateWeight()` as `weight`.

### **4. LongRangeWeapon (Extends Weapon)**
- Additional attributes: `ammoQuantity` and `ammoWeight`.
- Implements `calculateWeight()` as `weight + (ammoQuantity * ammoWeight)`.

### **5. Main (Handles Game Logic)**
- Manages the **inventory using an `ArrayList<Item>`**.
- Handles user input for:
  - Adding items.
  - Viewing all items.
  - Searching items by name.
  - Saving and loading game progress.

## 🔧 How to Run the Program
1. **Compile the Java files**:
   ```sh
   javac Main.java
   ```
2. **Run the program**:
   ```sh
   java Main
   ```
3. **Follow the interactive menu** to manage items.

## 🎮 Game Mechanics
- **Adding Items**: Choose between **ConsumableItem, Weapon, or LongRangeWeapon**.
- **Viewing Items**: Lists all items in inventory along with their weight and attributes.
- **Searching Items**: Enter a keyword to find matching items.
- **Saving & Loading**: Items are saved in text files for future sessions.

## 📂 File Storage System
- **ConsumableItem.txt** → Stores consumable items.
- **Weapon.txt** → Stores weapon items.
- **LongRangeWeapon.txt** → Stores long-range weapons.
- **Money.txt** → Stores player's money.
- **items.txt** → A formatted list of all items for reference.

## 🎨 ASCII Art
The game features ASCII art for weapons and items.

**ASCII sources:**
- [fsymbols.com](https://fsymbols.com/text-art/)
- [ASCII Art Website](https://asciiart.website/)
- [ASCII Art Weapons](https://www.asciiart.eu/weapons/swords)

## 🔗 References
- [Java Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
- [Java ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- [File Handling in Java](https://www.geeksforgeeks.org/file-handling-in-java/)

