package rpn.Registries;

import java.util.ArrayList;
import java.util.List;

public class OperatorRegistryImpl implements Registry {

    List<OperatorRegistered> registry;

    public OperatorRegistryImpl() {
        registry = new ArrayList<>();
    }

    @Override
    public void register(OperatorRegistered operator) {
        registry.add(operator);
    }

    @Override
    public OperatorRegistered getInstance(String value) {//todo peut retourner null
        OperatorRegistered result = null;

        for(OperatorRegistered register : registry) {
            if(value.matches(register.getPattern())){
                result = register.getInstance(value);
            }
        }
        return result;
    }

    @Override
    public List<OperatorRegistered> getEntries() {
        return registry;
    }
}
