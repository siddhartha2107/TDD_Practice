import org.example.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {

    @Test
    void calculator_basic() throws Exception {
        assertEquals(6, Calculator.add("//[;]\n1;2;3"));
    }

    @Test
    void calculator_exception() {
        String invalidInput = "1;2;3";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.add(invalidInput);
        });

        assertTrue(exception.getMessage().contains("Input string does not starts with //"));
    }

    @Test
    void calculator_exception_negativeNumber() {
        String invalidInput = "//[;]\n1;-2;3";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.add(invalidInput);
        });

        assertTrue(exception.getMessage().contains("negative numbers not allowed"));
    }

    @Test
    void calculator_exception_ignore_greater_k() throws Exception {
        String input = "//[;]\n2;1001";
        assertEquals(2, Calculator.add(input));
    }

    @Test
    void calculator_wrong_delim() throws Exception {
        String invalidInput = "//***\n1***2***3";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.add(invalidInput);
        });
        assertTrue(exception.getMessage().contains("No delimiters found in brackets"));
    }


    @Test
    void calculator_basic2() throws Exception {
        String input = "//[***]\n";
        assertEquals(0, Calculator.add(input));
    }

    @Test
    void calculator_basic3() throws Exception {
        String input = "//[***]\n1";
        assertEquals(1, Calculator.add(input));
    }


    @Test
    void calculator_multiple_delim() throws Exception {
        String input = "//[***][%]\n1***2%3";
        assertEquals(6, Calculator.add(input));
    }

}
