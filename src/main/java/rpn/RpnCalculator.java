package rpn;

import rpn.Operators.Evaluable;
import rpn.Operators.Evaluator;
import rpn.Orchestrators.Orchestrator;
import rpn.Registries.OperatorRegistryImpl;
import rpn.Registries.Registry;
import rpn.Operators.impl.*;
import rpn.Tokenizers.Tokenizer;

import java.util.*;

public class RpnCalculator {
        Registry registry;

    public RpnCalculator() {
        /* On ajoute les Operator que l'on veut gérer dans la registry*/
        registry = new OperatorRegistryImpl();
        registry.register(new Operand());
        registry.register(new Addition());
        registry.register(new Soustraction());
        registry.register(new Produit());
        registry.register(new Division());
    }

    public Double evaluate(String stringToEvaluate) throws Exception {

        //Tokenize
        Tokenizer tokenizer = new Tokenizer();
        List<String> tokens = tokenizer.tokenize(registry, stringToEvaluate, "\\s+");

        //Orchestrator
        Orchestrator orchestrator = new Orchestrator();
        List<Evaluable> terms = orchestrator.operatorize(registry, tokens);

        //Operators
        Evaluator evaluator = new Evaluator();
        return evaluator.evaluate(terms);
    }
}
