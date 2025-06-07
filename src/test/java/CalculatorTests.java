import org.example.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {

    @Test
    void calculator_delimiter() throws Exception {
        assertEquals(6, Calculator.add("//;\n1;2;3"));
    }

    @Test
    void calculator_exception() {
        String invalidInput = "1;2;3";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.add(invalidInput);
        });

        assertTrue(exception.getMessage().contains("Input string does not starts with //"));
    }

}
