package CustomStream;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyEntityMapper implements EntitiesMapper<MyEntity> {
    @Override
    public MyEntity map(ResultSet resultSet) throws SQLException {
        MyEntity myEntity = new MyEntity();
        myEntity.setId(resultSet.getLong("id"));
        myEntity.setName(resultSet.getString("name"));
        myEntity.setAge(resultSet.getInt("age"));
        return myEntity;
    }
}