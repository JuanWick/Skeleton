package rpn.Orchestrators;

import rpn.Operators.Evaluable;
import rpn.Registries.Registry;

import java.util.ArrayList;
import java.util.List;

public class Orchestrator {
    public Orchestrator() {
    }

    public List<Evaluable> operatorize(Registry registry, List<String> tokens) {
        List<Evaluable> evaluables = new ArrayList<>();
        for(String item : tokens){
            Evaluable operator = (Evaluable) registry.getInstance(item);
            evaluables.add(operator);
        }
        return evaluables;
    }
}
