package StreamAvtobusi;

import org.javatuples.Triplet;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class BusServiceCollector implements Collector<Person,// Ivan: kachil se: Petrich, Slqzul: Varna
                                        Map<String, Integer>,// grad | kachili se | slezli | produljili
                                Map<String, Integer>>// grad | kachili se | slezli | produljili
{


        public static BusServiceCollector toCityStats(){
                return new BusServiceCollector();
        }

        /**
         *
         * @return what is going to be initialized
         */
        @Override
        public Supplier<Map<String, Integer>> supplier() {
                return HashMap<String, Integer>::new;
        }

        /**
         * Represents an operation that accepts two input arguments and returns no result.
         * This is the two-arity specialization of Consumer. Unlike most other functional interfaces,
         * BiConsumer is expected to operate via side-effects.
         * This is a functional interface whose functional method is accept(Object, Object).
         * @return
         */
        @Override
        public BiConsumer<Map<String, Integer>, Person> accumulator() {
                return (hashMap, person) -> {

                        hashMap.merge(person.getFirstStop(), 1, Integer::sum);
                };
        }

        @Override
        public BinaryOperator<Map<String, Integer>> combiner() {
                //Merge the two hashMaps
                return (hashMap1, hashMap2) -> {
                        hashMap2.forEach((key, value) -> {
                                if(hashMap1.containsKey(key)){
                                        hashMap1.put(key, hashMap1.get(key) + value);
                                }
                        });
                        return hashMap1;
                };
        }

        @Override
        public Function<Map<String,Integer>, Map<String, Integer>> finisher() {
                return Collections::unmodifiableMap;
        }

        @Override
        public Set<Characteristics> characteristics() {
//                return Set.of(Characteristics.UNORDERED);
                return new HashSet<>();
        }

}
