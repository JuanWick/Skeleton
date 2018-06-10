package rpn;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        Double result = evaluate(expression);
        System.out.println("> " + result);
    }

    static Double evaluate(String expression) {
        RpnCalculator rpnCalculator = new RpnCalculator();
        Double result = 0.0;
        try {
            result = rpnCalculator.evaluate(expression);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return result;
    }
}
