package rpn.Operators.impl;


import java.util.Stack;

import rpn.Operators.Evaluable;
import rpn.Operators.Operator;
import rpn.Registries.OperatorRegistered;

public class Addition extends Operator implements Evaluable, OperatorRegistered {

    public Addition() {
    }

    private Addition(String value) {
        super(value);
    }

    @Override
    public String getPattern() {
        return "\\+";
    }

    @Override
    public Stack evaluate(Stack stack) throws Exception {
        if(stack.size() > 0){
            if(stack.size() == 1){
                throw new Exception("Addition : Le nombre de valeur à calculer est insuffisant");
            }

            Double value2 = (Double) stack.pop();
            Double value1 = (Double) stack.pop();
            Double result = value2 + value1;
            stack.push(result);
            return stack;

        } else {
            throw new Exception("Addition : l n'y a pas de valeur à calculer");
        }
    }

    @Override
    public OperatorRegistered getInstance(String value){
        return new Addition(value);
    }
}
