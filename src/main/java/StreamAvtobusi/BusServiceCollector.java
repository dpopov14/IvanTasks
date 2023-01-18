package StreamAvtobusi;

import org.javatuples.Triplet;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**\
 * <City, List<Long>> - качили се, слезли, продължили
 * Supplier - тази структура, в която ще върнем
 * Accumulator - тази структура, което ще чете резултата и ще натрупва
 */

public class BusServiceCollector implements Collector<Person,// T Ivan: kachil se: Petrich, Slqzul: Varna
        Map<String, List<Integer>>,// A grad | kachili se | slezli | produljili
        Map<String, List<Integer>>>// R grad | kachili se | slezli | produljili
{
    static ArrayList<String> orderedTowns; //Atina, Blagoevgrad, Sofia, Plovdiv, Varna, Burgas
//    Burgas should not appear in the final output as there are
//                           // no people


    public static BusServiceCollector toCityStats(ArrayList<String> orderedTownsArgument) {
        orderedTowns = orderedTownsArgument;
        return new BusServiceCollector();
    }

    /**
     * @return what is going to be initialized
     */
    @Override
    public Supplier<Map<String, List<Integer>>> supplier() {
        return LinkedHashMap<String, List<Integer>>::new;
    }

    /**
     * Represents an operation that accepts two input arguments and returns no result.
     * This is the two-arity specialization of Consumer. Unlike most other functional interfaces,
     * BiConsumer is expected to operate via side-effects.
     * This is a functional interface whose functional method is accept(Object, Object).
     *
     * @return
     */
    @Override
    public BiConsumer<Map<String, List<Integer>>, Person> accumulator() {
        return (hashMap, person) -> {

            hashMap.merge(person.getFirstStop(), new LinkedList<Integer>(Arrays.asList(1, 0, 0)),
                    this::sum); // one more person has gotten on that stop

            hashMap.merge(person.getLastStop(), new LinkedList<Integer>(Arrays.asList(0, 1, 0)),
                    this::sum); //one more person has gotten off that stop

            //Flag that indicates whether the person has gotten on the bus:
            boolean onBus = false;
            for (String town : orderedTowns) { //iterate though all the towns consecutively:
                if (town.equals(person.getFirstStop())) { // the person has gotten on the bus:
                    onBus = true;
                }
                //While the person is on the bus, iterate the 'continued' count of all
                // stops that follow until the person gets off the bus
                if (onBus) {
                    hashMap.merge(town, new LinkedList<Integer>(Arrays.asList(0, 0, 1)),
                            this::sum);
                }
                if (town.equals(person.getLastStop())) { //the person gets off the bus
                    hashMap.merge(town, new LinkedList<Integer>(Arrays.asList(0, 0, -1)),
                            this::sum); //this stop should now have one less person that continue
                                        //to the next stop
                    break; //no need to continue, the person has gotten of the bus
                }

            }
        };
    }

    @Override
    public BinaryOperator<Map<String, List<Integer>>> combiner() {
        //Merge the two hashMaps
        return (hashMap1, hashMap2) -> {
            hashMap2.forEach((key, value) -> {
                if (hashMap1.containsKey(key)) {
//                                        hashMap1.put(key, hashMap1.get(key) + value);
                }
            });
            return hashMap1;
        };
    }

    @Override
    public Function<Map<String, List<Integer>>, Map<String, List<Integer>>> finisher() {
        return Collections::unmodifiableMap;
    }

    @Override
    public Set<Characteristics> characteristics() {
//                return Set.of(Characteristics.UNORDERED);
        return new HashSet<>();
    }

    public List<Integer> sum(List<Integer> startingList, List<Integer> secondList) {
        for (int i = 0; i < startingList.size(); i++) {
            int res = 0;
            res = startingList.get(i) + secondList.get(i);
            startingList.set(i, res);
        }
        return startingList;
    }

}
