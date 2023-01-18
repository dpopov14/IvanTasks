package StreamAvtobusi;

import java.util.*;


public class StreamTask {

    //This is a simple list of town names;
    protected static ArrayList<String> towns = new ArrayList<>() {
        {
            add("Atina");
            add("Blagoevgrad");
            add("Sofia");
            add("Plovdiv");
            add("Varna");
        }
    };
    //This is a list of passengers and their journeys
    protected static List<Person> people = new LinkedList<>() {
        {
            add(new Person("Asen", "Atina", "Blagoevgrad"));
            add(new Person("Boris", "Atina", "Varna"));
            add(new Person("Cvetan", "Sofia", "Plovdiv"));
            add(new Person("Dimitar", "Atina", "Varna"));
            add(new Person("Evgeni", "Atina", "Blagoevgrad"));
            add(new Person("Filip", "Atina", "Varna"));
            add(new Person("Georgi", "Atina", "Blagoevgrad"));
            add(new Person("Hristo", "Atina", "Varna"));
        }
    };

    private static void showBusInfo(List<Person> people, List<String> towns){
        //Should return a list of type:
        /** Town | Boarding | Departing | Continued on */

        Bus bus = new Bus(0, 0, 0);
        System.out.println("|----------------------------------------------------------------|");
        towns.stream().forEach(
                town -> {
                    System.out.print("|"+ String.format(" %-11s",town) + " |");
                    bus.setBoarding(0);
                    bus.setGettingOff(0);
                    people.stream().forEach(person -> {
                        if (person.getFirstStop().equals(town)) {
                            bus.incrementBoarding();
                            bus.incrementContinuing();
                        } else if (person.getLastStop().equals(town)) {
                            bus.incrementGettingOff();
                            bus.decrementContinuing();
                        }
                    });
                    System.out.print(bus);
                    System.out.println("|----------------------------------------------------------------|");
                });

    }

    private static void testMyCollector(){
        Map<String, List<Integer>> returnTable =  people.stream().collect(BusServiceCollector.toCityStats(towns));
        System.out.println(returnTable);
    }


    public static void main(String[] args) {

        //The first task that basically used two forEach methods as two nested loops:
        showBusInfo(people, towns);

        //The second task that uses a BusServiceCollector
        testMyCollector();

    }
}
