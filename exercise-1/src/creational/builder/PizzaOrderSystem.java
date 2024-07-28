package creational.builder;

/**
 * Demonstrates the use of Pizza and PizzaBuilder classes.
 */
public class PizzaOrderSystem {
    /**
     * The entry point of the pizza ordering system.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder()
                .setSize("Large")
                .setCrust("Thin")
                .setCheese("Mozzarella")
                .setToppings("Pepperoni")
                .build();

        System.out.println("Order placed: " + pizza);

    }
}
