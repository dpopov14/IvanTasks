//package StreamAvtobusi;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SmartBus {
//
//    List<Person> people;
//    int boarding;
//    int gettingOff;
//
//
//    public SmartBus() {
//        this.people = new ArrayList<>();
//        this.boarding = 0;
//        this.gettingOff = 0;
//    }
//
//    public SmartBus(List<Person> people, int boarding, int gettingOff, int continuing) {
//        this.people = people;
//        this.boarding = boarding;
//        this.gettingOff = gettingOff;
//    }
//
//
//    public int getBoarding() {
//        return boarding;
//    }
//
//    public void setBoarding(int boarding) {
//        this.boarding = boarding;
//    }
//
//    public void incrementBoarding(Person person){
//        this.people.add(person);
//    }
//    public void incrementGettingOff(Person person){
//        this.people.remove(person);
//    }
//
//
//    /**
//     * Returns the number of people that will continue riding to the next stop
//     * @return integer - number of people that will continue
//     */
//    public int numberOfPeopleOnBus(){
//        return this.people.size();
//    }
//
//
//    /**
//     * Resets the boarding and getting off counters as the bus will move to the next town (stop)
//     */
//    public void leaveStop(){
//        this.boarding = 0;
//        this.gettingOff = 0;
//
//    }
//
//
//
//
//    public int getGettingOff() {
//        return gettingOff;
//    }
//
//    public void setGettingOff(int gettingOff) {
//        this.gettingOff = gettingOff;
//    }
//
//
//
//
//}
