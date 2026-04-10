import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class Library extends Building implements LibraryRequirements {

  /**
   * Attributes
   */
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

    /**
    * Constructor
    * @param name The name of the building
    * @param address The address of the building
    * @param nFloors The number of floors the building has
    * @param hasElevator If the building has an elevator
    */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<>();
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
    }

    @Override
    /**
     * Method for showing the available options for the library
     */
    public void showOptions(){
      System.out.println("Available options at " + this.name + ":\n enter() \n exit() \n goUp() \n goDown()\n goToFloor(n)\n addTitle(title)\n removeTitle(title)\n checkouut(title)\n isAvailable(title)\n containsTitle(title)\n printCollection()");
    }

    @Override
    /**
     * Method for going up and down floors
     * @param floorNum The floor number 
     */
    public void goToFloor(int floorNum) {
      if (this.hasElevator) {
        super.goToFloor(floorNum);
      }
      else {
        System.out.println("This building has no elevators, you must use the stairs.");
        super.goToFloor(floorNum);
      }
    }

    /**
     * Method for adding a book to the library 
     * @param title String of the title of the book 
     */
    public void addTitle(String title) {
      if (this.containsTitle(title) == false) {
        this.collection.put(title, true);
      }
      else {
        throw new RuntimeException("The title has already been added to the collection");
      }
    }

    /**
    * Method for adding multiple books into the collection
    * @param list The list of books being added 
    */
    public void addTitle(ArrayList<String> list) {
      for (int i = 0; i < list.size(); i ++) {
        String title = list.get(i);
        this.collection.put(title, true);
      }
    }

    /**
     * Method for removing a book from the colletion
     * @param title String of the title of the book
     * @return title of the book being removed
     */
    public String removeTitle(String title) {
      if (this.containsTitle(title)) {
        this.collection.remove(title);
        return title;
      }
      else {
        throw new RuntimeException("The title is not in the collection");
      }
    }

    /**
     * Method for removing mutliple books from the collection
     * @param list The list of books being removed
     */
    public void removeTitle(ArrayList<String> list) {
      for (int i = 0; i < list.size(); i ++) {
        String title = list.get(i);
        this.collection.remove(title);
      }
    }

    /**
     * Method for checking out a book from the library
     * @param title String of the title of the book
     */
    public void checkOut(String title){ 
      if (this.isAvailable(title)) {
        this.collection.replace(title, false);
      }
      else {
        throw new RuntimeException("The title is unavailable.");
      }
    }

    /**
     * Method for returning a book to the library
     * @param title String of the title of the book
     */
    public void returnBook(String title) {
      if (this.isAvailable(title) == false) {
        this.collection.replace(title, true);
      }
      else {
        throw new RuntimeException("The title wasn't checked out.");
      }
    }

    /**
    * Method for seeing if the book is in the collection
    * @param title String of the title of the book
    * @return true if the book is in the collection, false if not
    */
    public boolean containsTitle(String title) {
      if (this.collection.containsKey(title)) {
        return true;
      }
      else {
        return false;
      }
    } 

    /**
     * Method for seeing if the book is available for checkout
     * @param title String of the title of the book
     * @return available, ture if the book is available, false if not
     */
    public boolean isAvailable(String title) {
      if (this.containsTitle(title)) {
        boolean available = this.collection.get(title);
        return available;
      }
      else {
        throw new RuntimeException("The title is not in the collection.");
      }
    }

    /**
     * Method for printing out the books in the collection and their status
     */
    public void printCollection() {
      Set<String> setOfKeys = this.collection.keySet();
        for (String key : setOfKeys) {
          System.out.println("Title: " + key + " Available: " + this.collection.get(key));
        }
    }

  /**
   * Main
   */
  public static void main(String[] args) {
    Library neilson = new Library("Neilson", "1 Neilson Drive", 4, true);

    ArrayList<String> titles = new ArrayList<String>();
    neilson.showOptions();

    titles.add("Wrinkle in Time");
    titles.add("Harry Potter");
    titles.add("Crime and Punishment");
    titles.add("Twilight");
    neilson.addTitle(titles);
    neilson.printCollection();
    neilson.removeTitle(titles);
    neilson.printCollection();

    
  }
}