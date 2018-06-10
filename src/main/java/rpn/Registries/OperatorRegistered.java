package rpn.Registries;

public interface OperatorRegistered {
    String getPattern();
    OperatorRegistered getInstance(String value);
}
