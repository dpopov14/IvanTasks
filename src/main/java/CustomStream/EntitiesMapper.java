package CustomStream;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntitiesMapper<T> {
    T map(ResultSet resultSet) throws SQLException;
}