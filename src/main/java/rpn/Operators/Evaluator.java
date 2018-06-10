package rpn.Operators;

import java.util.List;
import java.util.Stack;

public class Evaluator {

    public Evaluator() {
    }

    public Double evaluate(List<Evaluable> terms) throws Exception {
        Stack numberStack = new Stack();

        for(Evaluable term:terms){
                term.evaluate(numberStack);
        }

        if(numberStack.size() == 1){
            return (Double) numberStack.pop();
        } else {
            String result = "";
            while(!numberStack.empty()) {
                result += " " + (Double) numberStack.pop();
            }
            throw new Exception("Incomplete operation, actual result :" + result);
        }    }
}
