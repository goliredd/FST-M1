package Activities;

class Car {
    //List of variables in the class
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;
    //Constructor
    public Car(){
        tyres = 4;
        doors = 4;
    }
    //Adding method to display Characteristics
    public void displayCharacteristics(){
        System.out.println("Color of the Car: " +color);
        System.out.println("Transmission of the Car: " +transmission);
        System.out.println("Year of Make: " +make);
        System.out.println("No of tyres: " +tyres);
        System.out.println("No of doors: " +doors);
    }
    //Adding method to accelarate
    public void accelarate(){

        System.out.println("Car is moving forward.");
    }
    //Adding method to brake
    public void brake(){

        System.out.println("Car has stopped.");
    }
}

public class Activity1 {
    public static void main(String[] args){
        //Create object to Car class
        Car carName = new Car();
        //Initializing the values
        carName.make = 2014;
        carName.color = "Black";
        carName.transmission = "Manual";
        //Calling the methods
        carName.displayCharacteristics();
        carName.accelarate();
        carName.brake();
    }
}
