# Design Patterns Implementation

---

## Overview

This project demonstrates the implementation of various design patterns using Java. The purpose of this is to showcase the understanding and application of design patterns in real-world scenarios.

---

## Design Patterns

Design patterns are typical solutions to commonly occuring problems in software design. They are like pre-made blueprints that you can customize to solve a recurring design problem in code.

---

## Categories of Design Patterns

Design patterns are broadly categorized into 3 types as follows:

- Behavioral Pattern
- Creational Pattern
- Structural Pattern

**Behavioral Design Pattern**

Behavioral design patterns are concerned with algorithms and the assignment of responsibilities between objects.

**Creational Design Pattern**

Creational Design Pattern provide various object creation mechanisms, which increases flexibility and reuse of existing code.

**Structural Design Pattern**

Structural design patterns explain how to assemble objects ans classes into larger structurs, while keeping these structures flexible and efficient.

## Project Structure

The project is organized into different folders based on the design patterns used:

 - `command/`: Contains examples of the Command design pattern.
 - `state/`: Contains examples of State design pattern.
 - `builder/`: Contains examples of the Builder design pattern.
 - `prototype/`: Contains examples of the Prototype design pattern.
 - `composite/`: Contains examples of the Composite design pattern.
 - `flyweight/`: Contains examples of the Flyweight design pattern.

## Design Patterns Implemented 

### Behavioral Patterns

**1. Command Pattern**

- **Classes**:
  - `Command.java`: Interface for command objects.
  - `LightCommand.java`: Command for controlling lights.
  - `SmartHomeController.java`: Invoker that executes commands.
  - `ThermostatCommand.java`: Command for setting the thermostat.
  - `SmartHome.java`: Demonstrates the use of commands to control objects.

**2. State Pattern**

- **Classes**
    - `VendingMachine.java`: Class that maintains the current state.
    - `VendingMachineState.java`: Interface for different states of the vending machine.
    - `ReadyState.java`: Concrete state when the machine is ready for a new transaction.
    - `HasCoinState.java`: Concrete state when a coin has been inserted.
    - `DispensingState.java`: Concrete state when an item is being dispensed.
    - `Vending.java`: Demonstrates the use of states to manipulate a Vending Machine.

### Creational Patterns

**1. Builder Pattern**

- **Classes**
    - `Pizza.java`: Represents the item to be built.
    - `PizzaBuilder.java`: Provides methods to build a `Pizza` instance.
    - `PizzaOrderSystem.java`: Demonstrates the use of the builder to create a pizza order.

**2. Prototype Pattern**

- **Classes**
    - `Character.java`: Interface for characters that can be cloned.
    - `CharacterCreator.java`: Handles character creation and cloning.
    - `Warrior.java`: Demonstrates the implementation of a character.

### Structural Patterns

**1. Composite Pattern**

- **Classes**
    - `File.java`: Represents a file in the file system.
    - `FileSystemComponent.java`: Interface for file system components.
    - `Directory.java`: Represents a directory containing other file system components.
    - `FileSystem.java`: Simulates the use of composite pattern to store files in a directory.

**2. Flyweight Pattern**

- **Classes**
    - `Character.java`: Represents a character with intrinsic properties.
    - `CharacterFactory.java`: Manages the creation and reuse of characters.
    - `CharacterProperties.java`: Contains character properties.
    - `CharacterDemo.java`: Demonstrates the use of flyweight pattern to create and modify characters and their properties.

---

## Usage 

To test each design pattern, navigate to the respective folder and run the Class with the `main` function. Ensure that Java has been installed and properly set up in your system.

---
## Documentation

Each class and method is documented with Javadoc comments. You can view the Javadoc documentation for detailed information on the functionalities provided by each component.

---

## Contribution

If you have any suggestions or improvements, feel free to open an issue or submit a pull request.

---

## References 
- [Refactoring Guru: Design Patterns](https://refactoring.guru/design-patterns)