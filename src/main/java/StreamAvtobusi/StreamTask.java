package StreamAvtobusi;

import CustomStream.CustomStream;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class StreamTask {

    //This is a simple list of town names;
    private  List<String> towns
            = Stream.of("Atina","Blagoevgrad","Sofia","Plovdiv","Varna").toList();

    //This is a list of passengers and their journeys
    private  List<Person> people = new LinkedList<>() {
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

    private  void showBusInfo(){
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


    public static void main(String[] args) {
        StreamTask streamTask = new StreamTask();
        //The first task that basically used two forEach methods as two nested loops:
//        streamTask.showBusInfo();

        //The second task that uses a BusServiceCollector
        System.out.println(streamTask.people.stream().collect(BusServiceCollector.toCityStats(streamTask.towns)));

        CustomStream<Integer> customStream = new CustomStream<>(new Integer[] {1, 2, 3, 4, 5});
        Stream<Integer> stream = StreamSupport.stream(customStream, false);


    }
}
