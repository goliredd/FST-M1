package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;

    public Plane(int maxPassengers){
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }
    public void onboard(String passengers){
        this.passengers.add(passengers);
    }
    public Date takeOff(){
        this.lastTimeTookOf = new Date();
        return lastTimeTookOf;
    }
    public void land(){
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }
    public Date getLastTimeLanded(){
        return lastTimeLanded;
    }
    public List<String> getPassengers(){
        return passengers;
    }
}

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(10);
        plane.onboard("Cherry");
        plane.onboard("Berry");
        plane.onboard("Chikki");
        plane.onboard("Lichi");
        System.out.println("Plane take-off time:");
        System.out.println(plane.takeOff());
        System.out.println("List of passengers:");
        System.out.println(plane.getPassengers());
        Thread.sleep(5000);
        plane.land();
        System.out.println("Plane landing time:");
        System.out.println(plane.getLastTimeLanded());
        }

}
