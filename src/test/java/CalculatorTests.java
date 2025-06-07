import org.example.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {

    @Test
    void calculator_basic() {
        assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    void calculator_newline() {
        assertEquals(6, Calculator.add("1\n2,3"));
    }
}
