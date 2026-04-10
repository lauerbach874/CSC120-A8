import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  /**
   * Attributes
   */
  private ArrayList<Student> residents; 
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Constructor 
   * @param name The name of the building
   * @param address The address of the building
   * @param nFloors The number of floors the building has
   * @param hasDiningRoom If the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    System.out.println("You have built a house: 🏠");
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }

  @Override
  /**
   * Method for showing what the available options are for the House
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n enter() \n exit() \n goUp() \n goDown()\n goToFloor(n)" + "moveIn(Student)\n isResident(Student)\n hasDiningRoom()\n nResidents()");
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
   * Getter for the boolean telling if the house has a dining room
   * @return ture if it has a dining room, false if not
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Getter for the number of residents in the house
   * @return the number of residents in the house
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Method for moving a student into the house
   * @param student The student
   */
  public void moveIn(Student s) {
    this.residents.add(s);
  }

  /**
   * Method for moving multiple students into the house
   * @param students The list of students being moved in
   */
  public void moveIn(ArrayList<Student> students) {
    for (int i =0; i < students.size(); i++) {
      Student s = students.get(i);
      this.residents.add(s);
    }
  }

  /**
   * Method for moving a student out of the house
   * @param student The student
   * @return The student who moved out
   */
  public Student moveOut(Student s) {
    if (this.residents.contains(s)) {
      this.residents.remove(s);
      return s;
    }
    else {
      throw new RuntimeException("The student isn't in the house.");
    }
  }

  /**
   * Method for moving mutliple students out of the house
   * @param students The list of students being moved out of the house
   */
  public void moveOut(ArrayList<Student> students) {
    for (int i =0; i < students.size(); i++) {
      Student s = students.get(i);
      this.residents.remove(s);
    }
  }

  /**
   * Method checking if the student is a resident of the house
   * @param student The student
   * @return true if the student is a resident, false if not
   */
  public boolean isResident(Student s) {
    if (this.residents.contains(s)) {
      boolean isResident = true;
      return isResident;
    }
    else {
      boolean isResident = false;
      return isResident;
    }
  }

  /**
   * Main 
   */
  public static void main(String[] args) {

    House chapin = new House("Chapin House", "3 Chapin Way", 4, true, false);
    House morris = new House("Morris House", "101 Green Street", 4, false, false);
    Student Lily = new Student("Lily", "99", 2028);
    chapin.showOptions();
    chapin.moveIn(Lily);
    boolean isResident = chapin.isResident(Lily);
    System.out.println(isResident);
    Student moveOut = chapin.moveOut(Lily);
    isResident = chapin.isResident(Lily);
    System.out.println(moveOut);
    System.out.println(isResident);

  }

}