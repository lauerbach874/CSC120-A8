public class Cafe extends Building implements CafeRequirements{

    /**
     * Attributes
     */
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructor 
     * @param name The name of the building
     * @param address The address of the building
     * @param nFloors The number of floors the building has
     * @param coffee The amount of coffee in the cafe
     * @param sugar The amount of sugar in the cafe
     * @param cream The amount of cream in the cafe
     * @param cups The number of cups in the cafe
     */
    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
        System.out.println("You have built a cafe: ☕");
    }

    @Override
    /**
     * Method for showing available options for the cafe
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n enter() \n exit() \n goUp() \n goDown()\n goToFloor(n)" + "sellCoffee()");
    }
    
    @Override
    /**
     * Method for going up and down floors
     * @param floorNum The floor number 
     */
    public void goToFloor(int floorNum) {
        System.out.println("Sorry, you don't have authorization to go to this floor");
    }
    /**
     * Method for selling a coffee
     * @param size The size of the coffee
     * @param nSugarPackets The number of sugar packets to add to the coffee
     * @param nCreams The number of creams to add to the coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces - size >= 0) {
            this.nCoffeeOunces -= size;
        }
        else {
            this.restock(50, this.nSugarPackets, this.nCreams, this.nCups);
            this.nCoffeeOunces -= size;
        }
        if (this.nSugarPackets - nSugarPackets >= 0) {
            this.nSugarPackets -= nSugarPackets;
        }
        else {
            this.restock(this.nCoffeeOunces, 50, this.nCreams, this.nCups);
            this.nSugarPackets -= nSugarPackets;
        }
        if (this.nCreams - nCreams >= 0) {
            this.nCreams -= nCreams;
        }
        else {
            this.restock(this.nCoffeeOunces, this.nSugarPackets, 50, this.nCups);
            this.nCreams -= nCreams;
        }
        if (this.nCups - 1 >= 0) {
            this.nCups -= 1;
        }
        else {
            this.restock(this.nCoffeeOunces, this.nSugarPackets, this.nCreams, 50);
            this.nCups -= 1;
        }
    }

    /**
     * Method for selling a regular cup of coffee
     */
    public void sellCoffee() {
        this.sellCoffee(16, 2, 3);
    }

    /**
     * Method for restocking the shop
     * @param nCoffeeOunces The amount of coffee
     * @param nSugarPackets The number of sugar packets
     * @param nCreams The number of creams
     * @param nCups The number of cups 
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * Method for restocking just the coffee
     * @param nCoffeeOunces The amount of coffee being restocked
     */
    public void restock (int nCoffeeOunces) {
        this.nCoffeeOunces += nCoffeeOunces;
    }

    /**
     * Method for restocking just the sugar and cream
     * @param nSugarPackets The amount of sugar being restocked
     * @param nCreams The amount of cream being restocked
     */
    public void restock (int nSugarPackets, int nCreams) {
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
    }
    
    /**
     * Main
     */
    public static void main(String[] args) {
        Cafe campusCenter = new Cafe("Campus Center Cafe", "1 Chapin Way", 3, 50, 50, 50, 50);
        campusCenter.sellCoffee(57, 14, 3);
        campusCenter.goToFloor(3);

        campusCenter.restock(100);
        campusCenter.restock(25, 3);
        campusCenter.sellCoffee();

    }
}
