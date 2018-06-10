package rpn.Operators.impl;

import rpn.Operators.Evaluable;
import rpn.Operators.Operator;
import rpn.Registries.OperatorRegistered;

import java.util.Stack;

public class Operand extends Operator implements Evaluable, OperatorRegistered {

    public Operand(){
    }

    private Operand(String value){
        super(value);
    }

    @Override
    public String getPattern() {
        return "[\\d]*|^\\-[\\d]+";
    }

    @Override
    public Stack evaluate(Stack stack) throws Exception {
        try{
            Double result = Double.valueOf(value);
            stack.push(result);
            return stack;

        } catch (Exception e){
            throw new Exception("Not Yet implement");
        }
    }

    @Override
    public OperatorRegistered getInstance(String value){
        return new Operand(value);
    }
}
