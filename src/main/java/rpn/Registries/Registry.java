package rpn.Registries;

import java.util.List;

public interface Registry {
        void register(OperatorRegistered operator);

        OperatorRegistered getInstance(String value);

        List<OperatorRegistered> getEntries();
    }
