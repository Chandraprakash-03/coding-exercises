package creational.builder;

/**
 * Represents a Pizza with various attributes like size, crust, cheese, toppings.
 */
public class Pizza {
    private String size;
    private String crust;
    private String cheese;
    private String toppings;

    /**
     * Constructs a Pizza with the given attributes.
     * @param builder the builder used to build the Pizza object.
     */
    Pizza(PizzaBuilder builder){
        this.size = builder.size;
        this.crust = builder.crust;
        this.cheese = builder.cheese;
        this.toppings = builder.toppings;
    }

    /**
     * Returns the string representation of the Pizza object.
     * @return a string describing the Pizza's size, crust, cheese, and toppings.
     */
    @Override
    public String toString() {
        return "Pizza [size=" + size + ", crust=" + crust + ", cheese=" + cheese + ", toppings=" + toppings + "]";
    }

    /**
     * Builder class for constructing Pizza objects.
     * Provides methods to set various attributes and create a Pizza instance.
     */
    public static class PizzaBuilder {
        private String size;
        private String crust;
        private String cheese;
        private String toppings;

        /**
         * Sets the size of the Pizza.
         * @param size the size of the pizza.
         * @return the current Pizza instance.
         */
        public PizzaBuilder setSize(String size) {
            this.size = size;
            return this;
        }

        /**
         * Sets the crust type of the Pizza.
         * @param crust the crust of the Pizza.
         * @return the current Pizza instance
         */
        public PizzaBuilder setCrust(String crust) {
            this.crust = crust;
            return this;
        }

        /**
         * Sets the type of cheese used in the Pizza.
         * @param cheese the cheese type of the Pizza.
         * @return the current Pizza instance
         */
        public PizzaBuilder setCheese(String cheese) {
            this.cheese = cheese;
            return this;
        }

        /**
         * Sets the different toppings used in the Pizza.
         * @param toppings the toppings used in the Pizza.
         * @return the current Pizza instance
         */
        public PizzaBuilder setToppings(String toppings) {
            this.toppings = toppings;
            return this;
        }

        /**
         * Builds a Pizza instance.
         * @return the Pizza object.
         */
        public Pizza build() {
            return new Pizza(this);
        }
    }
}
