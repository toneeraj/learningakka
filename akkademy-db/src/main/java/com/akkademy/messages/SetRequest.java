package com.akkademy.messages;

/**
 * Represents a message that will store a key (String) and a value (any Object) in memory.
 * <p>
 * Messages should be immutable
 * <p>
 * Created by Neeraj on 7/20/2016.
 */
public class SetRequest {
    private final String key;
    private final Object value;

    public SetRequest(String key, Object value) {
        this.key = key;
        this.value = value;

    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
