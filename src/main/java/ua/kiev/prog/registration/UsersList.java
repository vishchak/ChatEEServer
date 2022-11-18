package ua.kiev.prog.registration;

import java.util.HashMap;

import java.util.Map;

public class UsersList {
    private static final Map<String, String> map = new HashMap<>();

    static {
        map.put("admin", "admin");
    }

    public static Map<String, String> getInstance() {
        return map;
    }
}
