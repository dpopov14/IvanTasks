package CustomStream;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.Arrays;

public class CustomStream<T> implements Spliterator<T> {
    // The array of data that the stream will be operating on
    private final T[] data;
    // The current index of the data array that the stream is at
    private int currentIndex = 0;

    /**
     * Constructor for the CustomStream class
     * @param data the data that the stream will operate on
     */
    public CustomStream(T[] data) {
        this.data = data;
    }

    /**
     * Method that is used to advance the stream and process the current element
     * @param action the Consumer object that performs the action on the current element
     * @return true if there is a next element, false otherwise
     */
    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        // Check if there is a next element in the data array
        if (currentIndex < data.length) {
            // Perform the action on the current element and increment the current index
            action.accept(data[currentIndex++]);
            return true;
        }
        return false;
    }

    /**
     * Method that is used to split the stream into smaller streams
     * @return a new CustomStream object that represents the split stream, or null if the stream cannot be split
     */
    @Override
    public Spliterator<T> trySplit() {
        // Calculate the midpoint of the data array
        int mid = data.length / 2;
        // Check if the midpoint has been passed
        if (mid <= currentIndex) {
            return null;
        }
        // Create a new array that contains the data from the current index to the midpoint
        T[] newData = Arrays.copyOfRange(data, currentIndex, mid);
        // Update the current index to the midpoint
        currentIndex = mid;
        // Return a new CustomStream object that operates on the new data array
        return new CustomStream<>(newData);
    }

    /**
     * Method that returns an estimate of the remaining size of the stream
     * @return the remaining size of the stream
     */
    @Override
    public long estimateSize() {
        return data.length - currentIndex;
    }

    /**
     * Method that returns the characteristics of the stream
     * @return a set of flags that describe the characteristics of the stream
     */
    @Override
    public int characteristics() {
        return ORDERED | IMMUTABLE | NONNULL | SIZED;
    }
}
