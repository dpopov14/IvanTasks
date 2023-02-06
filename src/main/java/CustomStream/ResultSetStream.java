package CustomStream;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ResultSetStream<T> implements Spliterator<T> {
    // The JDBC ResultSet that the stream will be operating on
    private ResultSet resultSet;
    // The mapper that will map the resultSet rows to entities
    private EntitiesMapper<T> mapper;

    /**
     * Constructor for the ResultSetStream class
     * @param resultSet the JDBC ResultSet that the stream will operate on
     * @param mapper the mapper that will map the resultSet rows to entities
     */
    public ResultSetStream(ResultSet resultSet, EntitiesMapper<T> mapper) {
        this.resultSet = resultSet;
        this.mapper = mapper;
    }

    /**
     * Method that is used to advance the stream and process the current element
     * @param action the Consumer object that performs the action on the current element
     * @return true if there is a next element, false otherwise
     */
    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        try {
            // Check if there is a next element in the ResultSet
            if (resultSet.next()) {
                // Map the current element to an entity and perform the action
                action.accept(mapper.map(resultSet));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method that is used to split the stream into smaller streams
     * Not Implemented since the ResultSet already represents a stream of data
     * @return null
     */
    @Override
    public Spliterator<T> trySplit() {
        return null;
    }

    /**
     * Method that returns an estimate of the remaining size of the stream
     * @return the remaining size of the stream
     */
    @Override
    public long estimateSize() {
        try {
            // move the cursor to the last row and get the number of rows
            resultSet.last();
            return resultSet.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
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





