package rpn.Operators;

import java.util.Stack;

public interface Evaluable {
     Stack evaluate(Stack stack) throws Exception;
}
