package org.ivan_smirnov.bdconnector;

import org.junit.Test;

public class DBConnectorTest {

    @Test
    public void starter() {
        DBConnector connector = new DBConnector();
        connector.start();
    }
}
