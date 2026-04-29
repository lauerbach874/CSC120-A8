import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Neilson", "1 Neilson Drive", 4));
        myMap.addBuilding(new Building("Campus Center Cafe", "1 Chapin Way", 3));
        myMap.addBuilding(new Building("Chapin House", "3 Chapin Way", 4));
        myMap.addBuilding(new Building("Morris House", "101 Green Street", 4));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Drive", 4));
        myMap.addBuilding(new Building("Scott Gym", "102 Lower College Lane", 3));
        myMap.addBuilding(new Building("Burton Hall", "46 College Lane", 4));
        myMap.addBuilding(new Building("McConnell Hall", "2 Tyler Ct", 4));
        System.out.println(myMap);

        Building ford = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(ford.toString());

        // The overloaded methods for house
        House chapin = new House("Chapin House", "3 Chapin Way", 4, true, false);
        Student Lily = new Student("Lily", "99", 2028);
        Student Alara = new Student("Alara", "99999", 2028);
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(Lily);
        students.add(Alara);
        chapin.showOptions();
        chapin.moveIn(students);
        System.out.println(chapin.nResidents());
        chapin.moveOut(students);
        System.out.println(chapin.nResidents());

        // The overloaded methods for library
        Library neilson = new Library("Neilson", "1 Neilson Drive", 4, false);

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
        neilson.goToFloor(4);

        // The overloaded methods for cafe
        Cafe campusCenter = new Cafe("Campus Center Cafe", "1 Chapin Way", 3, 50, 50, 50, 50);
        campusCenter.sellCoffee(57, 14, 3);
        campusCenter.showOptions();
        campusCenter.goToFloor(3);

        campusCenter.restock(100);
        campusCenter.restock(25, 3);
        campusCenter.sellCoffee();

    }
    
}
