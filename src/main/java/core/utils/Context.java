package core.utils;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<String, Object> contextMap;

    public Context() {
        contextMap = new HashMap<>();
    }

    public <T> T get(String key) {
        return (T) contextMap.get(key);
    }

    public void put(String key, Object value) {
        contextMap.put(key, value);
    }

}
