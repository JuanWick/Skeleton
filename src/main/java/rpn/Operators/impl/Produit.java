package rpn.Operators.impl;

import rpn.Operators.Evaluable;
import rpn.Operators.Operator;
import rpn.Registries.OperatorRegistered;

import java.util.Stack;

public class Produit extends Operator implements Evaluable, OperatorRegistered {

    public Produit() {
    }

    private Produit(String value) {
        super(value);
    }

    @Override
    public String getPattern() {
        return "\\*";
    }

    @Override
    public Stack evaluate(Stack stack) throws Exception {
        if(stack.size() > 0){
            if(stack.size() == 1){
                throw new Exception("Produit : Le nombre de valeur à calculer est insuffisant");
            }
            Double value2 = (Double) stack.pop();
            Double value1 = (Double) stack.pop();
            Double result = value1 * value2;
            stack.push(result);
            return stack;

        } else {
            throw new Exception("Produit : Il n'y a pas de valeur à calculer");
        }
    }

    @Override
    public OperatorRegistered getInstance(String value){
        return new Produit(value);
    }
}
