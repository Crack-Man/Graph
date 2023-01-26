package GraphRedactor.Main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void main() {
        Parameters parameters = Parameters.get();
        Assertions.assertNotNull(parameters);
    }
}