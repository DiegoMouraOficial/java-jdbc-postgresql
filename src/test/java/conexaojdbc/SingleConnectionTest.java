package conexaojdbc;

import org.junit.Test;

public class SingleConnectionTest {
    @Test
    public void initBanco() {
        SingleConnection.getConnection();
    }
}
