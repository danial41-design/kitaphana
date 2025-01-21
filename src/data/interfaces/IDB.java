package data.interfaces;

public interface IDB {package data.interfaces;

import java.sql.Connection;

public interface IDB {
    Connection getConnection();
    void close();
}
}
