package rpn;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static rpn.CLI.evaluate;

public class CLITest {

    @Test
    public void should_not_evaluate_incorrect_syntax_expression() {
        try {
            evaluate("");
            evaluate("Hello !");
            evaluate("5 5 Hello");
        }catch(Exception exp){
            assert(exp.getMessage().contains("Invalid character in expression"));
        }
    }

    @Test
    public void should_not_evaluate_incomplete_expression() {
        try {
        evaluate("5");
        evaluate("5 +");
        evaluate("7 2 - 3 4");
        }catch(Exception exp){
            assert(exp.getMessage().contains("Incomplete operation, actual result :"));
        }
    }

    @Test
    public void should_evaluate_simple_addition() {
        assertThat(evaluate("17 5 +")).isEqualTo(22);
        assertThat(evaluate("2 3 5 + +")).isEqualTo(10);
    }

    @Test
    public void should_evaluate_simple_soustraction() {
        assertThat(evaluate("17 5 -")).isEqualTo(12);
        assertThat(evaluate("2 3 5 - -")).isEqualTo(4);
    }

    @Test
    public void should_evaluate_simple_multiply() {
        assertThat(evaluate("17 5 *")).isEqualTo(85);
        assertThat(evaluate("2 3 5 * *")).isEqualTo(30);
    }

    @Test
    public void should_evaluate_simple_divide() {
        assertThat(evaluate("9 3 /")).isCloseTo(3,Offset.offset(0.01));
        assertThat(evaluate("20 5 /")).isEqualTo(4,Offset.offset(0.01));
    }

    @Test
    public void should_evaluate_mix_operations_not_postfixe() {
        assertThat(evaluate("5 2 3 + -")).isEqualTo(0);
        assertThat(evaluate("4 2 + 3 -")).isEqualTo(3);
        assertThat(evaluate("3 5 8 * 7 + *")).isEqualTo(141);
    }

    @Test
    public void should_evaluate_negative_operations() {
        assertThat(evaluate("-20 5 +")).isEqualTo(-15);
        assertThat(evaluate("-20 5 -")).isEqualTo(-25);
    }

    @Test
    public void should_not_evaluate_divide_by_0() {
        try {
            assertThat(evaluate("9 0 /"));
        }catch(Exception exp){
            assert(exp.getClass()).isInstance(ArithmeticException.class);
        }

    }
}